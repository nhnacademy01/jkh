package day11.hw2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

/**
 * Server class.
 */
public class Server {
    private final ConcurrentHashMap<String, DataOutputStream> clientOutMap = new ConcurrentHashMap<>();
    private final SecureRandom sr = new SecureRandom();

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }

    /**
     * ServerSocket start function.
     */
    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println(getTime() + " Start server " + serverSocket.getLocalSocketAddress());
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    ClientSession client = new ClientSession(socket);
                    client.start();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
    }

    private String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }


    private void loggingCurrentClientCount() {
        String str = getTime() + " Currently " + clientOutMap.size() + " clients are connected.";
        System.out.println(str);
    }

    private void sendToAll(String message) {
        for (DataOutputStream out : clientOutMap.values()) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
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

        private void leaveChat(ClientSession session) {
            clientOutMap.remove(session.id);

            sendToAll("[System] " + session.id + "님이 나갔습니다.");
            String str = getTime() + " " + session.id +
                    " is leaved: " + session.socket.getInetAddress();
            System.out.println(str);
            loggingCurrentClientCount();
        }

        @Override
        public void run() {
            initialize();
            connect();
        }

        private void initialize() {
            try {
                this.id = in.readUTF();

            } catch (IOException cause) {
                cause.printStackTrace();
            }
        }

        private void connect() {
            try {
                if (isConnect()) {
                    System.out.println(id);
                    gameResultSend(this.id);
                }

            } finally {
                disconnect();
            }
        }

        private void gameResultSend(String id) {
            Gameplay gameplay = new Gameplay(id);
            try {
                int monster = Integer.parseInt(in.readUTF());
                out.writeUTF(requireNonNull(gameplay.fight(monster)));
                int monster2 = Integer.parseInt(in.readUTF());
                out.writeUTF(requireNonNull(gameplay.fight2(monster2)));
                int monster3 = Integer.parseInt(in.readUTF());
                String tempDragon = gameplay.fight3(monster3);
                out.writeUTF(requireNonNull(tempDragon));
                sendToAll(tempDragon);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        private boolean isConnect() {
            return this.in != null;
        }

        private void disconnect() {
            leaveChat(this);
        }
    }

    class Gameplay {
        public final User user;
        public final Slime slime;
        public final Oak oak;
        public final Dragon dragon;

        Gameplay(String id) {
            user = new User(id);
            slime = new Slime();
            oak = new Oak();
            dragon = new Dragon();
        }

        private String fight(int monster) throws InterruptedException {
            int userHp = user.general.getHp();
            int monsterHp = slime.general.getHp();
            if (monster == 1) {
                while (true) {
                    monsterHp -= sr.nextInt(user.general.getAttack()) + 1;
                    userHp -= sr.nextInt(slime.general.getAttack()) + 1;
                    System.out.println(monsterHp + " " + userHp);
                    Thread.sleep(500);
                    if (monsterHp < 0) {
                        user.general.setHp(userHp);
                        String strSend = "슬라임을 물리쳤다.\n야생의 오크가 나타났다.\n1. 공격\n2. 도망간다. (게임 종료)";
                        System.out.println(strSend);
                        return strSend;
                    }
                }
            }
            return null;
        }

        private String fight2(int monster) throws InterruptedException {

            int userHp = user.general.getHp();
            if (monster == 1) {
                int monsterHp = oak.general.getHp();
                while (true) {
                    monsterHp -= sr.nextInt(user.general.getAttack()) + 1;
                    userHp -= sr.nextInt(oak.general.getAttack()) + 1;
                    System.out.println(monsterHp + " " + userHp);
                    Thread.sleep(500);
                    if (monsterHp < 0) {
                        user.general.setHp(150);
                        user.general.setLevel(2);
                        user.general.setAttack(20);
                        String strSend = "오크를 물리쳤다.\n레벨" + user.general.getLevel() +
                                "로 상승했다.\n*보스* 드래곤이 나타났다.\n1. 공격\n2. 도망간다. (게임 종료)";
                        System.out.println(strSend);
                        return strSend;
                    }
                }
            }
            return null;
        }

        private String fight3(int monster) throws InterruptedException {
            int userHp = user.general.getHp();
            int bless = 15;
            if (monster == 1) {
                int monsterHp = dragon.general.getHp();
                while (true) {

                    if (sr.nextInt(10) == 1) {
                        userHp -= bless;
                    } else {
                        monsterHp -= sr.nextInt(user.general.getAttack()) + 1;
                    }
                    userHp -= sr.nextInt(dragon.general.getAttack()) + 1;
                    System.out.println(monsterHp + " " + userHp);
                    Thread.sleep(500);
                    if (monsterHp < 0) {
                        String strSend = "[외침] 용사 " + this.user.getId() + "가 드래곤을 물리쳤다!.\n";
                        System.out.println(strSend);
                        sendToAll(strSend);
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

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id) {
        general = new General(1, 100, 10);
        setId(id);
    }
}

class Slime {
    General general;

    public Slime() {
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