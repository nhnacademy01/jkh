package day11.hw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private final String id;

    public Client(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        if (hasNotArgs(args)) {
            System.out.println("USAGE: java MyChatClient {id}");
            return;
        }  Scanner sc = new Scanner(System.in);
        String id = args[0];
        System.out.println(id);
        Client c = new Client(id);
        c.showStart();
        c.connect("127.0.0.1", 8888);
        System.out.println("야생의 슬라임이 나타났다.\n" +
                "1. 공격\n" +
                "2. 도망간다. (게임 종료)");
//        System.out.println("야생의 오크가 나타났다.\n" +
//                "1. 공격\n" +
//                "2. 도망간다. (게임 종료)");
//        if(sc.nextInt() == 1){
//
//        }else if(sc.nextInt() == 2){
//            System.out.println("게임을 종료합니다.");
//            return;
//        }else {
//            throw new UserInputException("1과 2중에서 입력해주세요");
//       }

    }

    private void connect(String serverHost, int port) {
        try {
            Socket socket = new Socket(serverHost, port);
            System.out.println("Connected to server " + serverHost + ":" + port);//서버 접속확인
            Thread sender = new Sender(socket, id);//동적바인딩
            Thread receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasNotArgs(String[] args) {
        return args.length == 0;
    }

    private void showStart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("                 ___====-_  _-====___\n" +
                "           _--^^^#####//      \\\\#####^^^--_\n" +
                "        _-^##########// (    ) \\\\##########^-_\n" +
                "       -############//  |\\^^/|  \\\\############-\n" +
                "     _/############//   (@::@)   \\\\############\\_\n" +
                "    /#############((     \\\\//     ))#############\\\n" +
                "   -###############\\\\    (oo)    //###############-\n" +
                "  -#################\\\\  / VV \\  //#################-\n" +
                " -###################\\\\/      \\//###################-\n" +
                "_#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                "|/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                "`  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                "   `   `  `      `   / | |  | | \\   '      '  '   '\n" +
                "                    (  | |  | |  )\n" +
                "                   __\\ | |  | | /__\n" +
                "                  (vvv(VVV)(VVV)vvv)\n");
        System.out.println("-- 계속 할려면 엔터를 입력해주세요. --");
       // String e = sc.nextLine();
        //sc.nextLine();
    }

    private static class Sender extends Thread {
        private String id;
        private DataOutputStream out;

        private Sender(Socket socket, String id) throws IOException {
            this.id = id;
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            try {
                initialize();
                sendMessage();
            } catch (IOException e) {
                // TODO
            }
        }

        private void initialize() throws IOException {
            if (isSendable()) {
                this.out.writeUTF(id);
            }
        }

        private boolean isSendable() {
            return this.out != null;
        }

        private void sendMessage() throws IOException {
            try (Scanner scanner = new Scanner(System.in)) {
                while (isSendable()) {
                    //this.out.writeUTF("[" + id + "] " + scanner.nextLine());
                    String str = scanner.nextLine();
                    if (str.equals("1")) {
                        this.out.writeUTF(str);
                    } else if (str.equals("2")) {
                        System.out.println("게임을 종료합니다.");
                        System.exit(0);
                    } else {
                        throw new UserInputException("1과 2중에서 입력해주세요");
                    }

                }//chat 메시지 보내는 부분 -> 옵션값 전송으로 구조 개선
            }
        }
    }

    private static class Receiver extends Thread {
        private final DataInputStream in;

        private Receiver(Socket socket) throws IOException {
            this.in = new DataInputStream(socket.getInputStream());
        }

        @Override
        public void run() {
            while (isReceivable()) {
                receiveMessage();
            }
        }

        private boolean isReceivable() {
            return this.in != null;
        }

        private void receiveMessage() {
            try {
                System.out.println(in.readUTF());

            } catch (IOException e) {
                // TODO
            }
        }
    }//받는 함수값처리 여기서 해줘야됨
}

class UserInputException extends RuntimeException {
    public UserInputException() {
        super();
    }

    public UserInputException(String errorMessage) {
        super(errorMessage);
        String str = "잘못된 입력값입니다.";
        System.out.println(str);
    }

}