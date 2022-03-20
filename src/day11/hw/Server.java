package day11.hw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private final ConcurrentHashMap<String, DataOutputStream> clientOutMap = new ConcurrentHashMap();

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println(getTime() + " Start server " + serverSocket.getLocalSocketAddress());
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    ClientSession client = new ClientSession(socket);
                    client.start();
                    //todo 관련 처리 로직 작성

                } catch (IOException e) {
                    // TODO 클라이언트 접속 실패
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }

    private void joinChat(ClientSession session) {
        clientOutMap.put(session.id, session.out);

        sendToAll("[System] " + session.id + "님이 입장했습니다.");
        System.out.println(getTime() + " " + session.id + " is joined: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
    }

    private void leaveChat(ClientSession session) {
        clientOutMap.remove(session.id);

        sendToAll("[System] " + session.id + "님이 나갔습니다.");
        System.out.println(getTime() + " " + session.id + " is leaved: " + session.socket.getInetAddress());
        loggingCurrentClientCount();
    }

    private void loggingCurrentClientCount() {
        System.out.println(getTime() + " Currently " + clientOutMap.size() + " clients are connected.");
    }//로그 처리

    private void sendToAll(String message) {
        for (DataOutputStream out : clientOutMap.values()) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                // TODO: 해당 클라이언트로 송출 스트림이 실패함(네트워크 끈김)
            }
        }
    }


    class ClientSession extends Thread {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;
        private String id;

        ClientSession(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            initialize();
            connect();
//            Gameplay gp = new Gameplay(id);
//            gp.start();
        }

        private void initialize() {
            try {
                this.id = in.readUTF();
                //joinChat(this);
            } catch (IOException cause) {
                // TODO: 최초 통신(아이디 받기)이 실패하는 경우
            }
        }

        private void connect() {
            try {
                //while (isConnect()) {
                if (isConnect()) {
                    System.out.println(id);
                    gameResultSend(this.id);
                }
                //sendToAll(in.readUTF());//참여자 모두에게 전송하는 메서드
                // }
            } finally {
                disconnect();
            }
        }

        private void gameResultSend(String id) {
            Gameplay gameplay = new Gameplay(id);
            try {
                int monster = Integer.parseInt(in.readUTF());
                out.writeUTF(gameplay.fight(monster));
                int monster2 = Integer.parseInt(in.readUTF());
                out.writeUTF(gameplay.fight2(monster2));
                int monster3 = Integer.parseInt(in.readUTF());
                String tempDragon = gameplay.fight3(monster3);
                out.writeUTF(tempDragon);
                sendToAll(tempDragon);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isConnect() {
            return this.in != null;
        }

        private void disconnect() {
            leaveChat(this);
        }//엔딩용
    }

    class Gameplay {
        public User user;
        public Slime slime;
        public Oak oak;
        public Dragon dragon;

        Gameplay(String id) {
            user = new User(id);
            slime = new Slime();
            oak = new Oak();
            dragon = new Dragon();
        }

        //        @Override
//        public void run(){
//            //todo 게임 처리함수 로드
//            //fight(1);
//        }
        private String fight(int monster) {
            Random r = new Random();
            //todo 몬스터인자값으로 처리하기 1 슬라임 2 오크 3 드래곤
            int userHp = user.general.hp;
            int monsterHp = slime.general.hp;
            if (monster == 1) {
                while (true) {
                    monsterHp -= r.nextInt(user.general.attack) + 1;
                    userHp -= r.nextInt(slime.general.attack) + 1;
                    System.out.println(monsterHp + " " + userHp);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (monsterHp < 0) {
                        user.general.hp = userHp;//마지막 값으로 남겨둠
                        String strSend = //"uesr win and remaining hp : " + userHp;
                                "슬라임을 물리쳤다.\n" +
                                      "야생의 오크가 나타났다.\n" +
                                        "1. 공격\n" +
                                        "2. 도망간다. (게임 종료)";
                        System.out.println(strSend);
                        return strSend;
                    }
                }
            }

            return null;
        }

        private String fight2(int monster) {
            Random r = new Random();
            int userHp = user.general.hp;
            if (monster == 1) {
                int monsterHp = oak.general.hp;
                while (true) {
                    monsterHp -= r.nextInt(user.general.attack) + 1;
                    userHp -= r.nextInt(oak.general.attack) + 1;
                    System.out.println(monsterHp + " " + userHp);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (monsterHp < 0) {
                        user.general.hp = 150;
                        user.general.level = 20;
                        user.general.attack = 20;//userHp;//마지막 값으로 남겨둠
                        //String strSend = "uesr win and remaining hp : " + userHp;
                        String strSend = "오크를 물리쳤다.\n" +
                                "레벨2로 상승했다.\n" +
                                "*보스* 드래곤이 나타났다.\n" +
                                "1. 공격\n" +
                                "2. 도망간다. (게임 종료)";
                        System.out.println(strSend);
                        return strSend;
                    }
                }
            }
            return null;
        }

        private String fight3(int monster) {
            Random r = new Random();
            int userHp = user.general.hp;
            if (monster == 1) {
                int monsterHp = dragon.general.hp;
                while (true) {
                    //monsterHp -= r.nextInt(user.general.attack) + 1;
                    int bless = 15;
                    if (r.nextInt(10) == 1)
                        userHp -= bless;
                    else
                        monsterHp -= r.nextInt(user.general.attack) + 1;
                    userHp -= r.nextInt(dragon.general.attack) + 1;
                    System.out.println(monsterHp + " " + userHp);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (monsterHp < 0) {
//                        user.general.hp = 150;
//                        user.general.level = 20;
//                        user.general.attack =20;//userHp;//마지막 값으로 남겨둠
                        String strSend = "[외침] 용사 "+this.user.id+"가 드래곤을 물리쳤다!.\n"; //"uesr win and remaining hp : " + userHp;
                        System.out.println(strSend);
                        //sendToAll(strSend);
                        return strSend;
                    }
                    if (userHp < 0) {
                        String strSend = "user lose and monster remaining hp : " + monsterHp;
                        System.out.println(strSend);
                        return strSend;


                    }
                }
            }
            return null;
        }
//        }private int monster(){
//
//        }
    }
}

class General {
    int level;
    int hp;
    int attack;

    public General(int level, int hp, int attack) {
        this.level = level;
        this.hp = hp;
        this.attack = attack;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

class User {
    General general;
    String id;

    public void setId(String id) {
        this.id = id;
    }

    public User(String id) {
        /*general.attack = 10;
        general.hp = 100;
        general.level = 1;*/
        general = new General(1, 100, 10);
        setId(id);
    }

    public void setGeneral(General general) {
        this.general = general;
    }
}

class Slime {
    General general;

    public Slime() {
//        general.attack = 4;
//        general.hp = 30;
//        general.level = 1;
        general = new General(1, 30, 4);
    }
}

class Oak {
    General general;

    public Oak() {
        general = new General(2, 40, 6);
    }
}

class Dragon {
    General general;

    public Dragon() {
        general = new General(3, 100, 10);
    }
}