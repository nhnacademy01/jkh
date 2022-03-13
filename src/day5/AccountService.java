package day5;

class SignInUpShell {
    private final AccountService service = new AccountService();
    public static void main(String[] args) {
        SignInUpShell shell = new SignInUpShell();
        shell.start();
    }
    private void start(){
        join();
    }
    private void join(){
        String userid = "jordan";
        String password = "passW0rd";
        String name = "jmj";

        //service.join(new JoinRequest(userid,password,name));
    }
}

public class AccountService {
    private final AccountRepository repository = new AccountRepository();

    void join(JoinRequest req) {
        day5.Account account = req.toAccount();
        repository.save(account);
    }


};
class LoginResult{
    private final boolean logged;
    private final Account account;

    public LoginResult(boolean logged){
        this.logged = logged;
        this.account = null;
    }

    public LoginResult(boolean logged, Account account) {
        this.logged = logged;
        this.account = account;
    }
    public boolean  isLogged(){
        return logged;
    }
    //public
}

class AccountRepository {
    day5.Account[] sources = new day5.Account[10];

    public boolean save(day5.Account account) {
        //todo
        for (int i = 0; i < sources.length; i++) {
            if(sources[i] == null){
                sources[i] =account;
                //save
                return true;
            }
        }
        return false;
    }
}

class JoinRequest {
    public JoinRequest(String userId, String password, String name, int role) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.role =role;
    }

//    public JoinRequest(String userId, String password, String name) {
//        this.userId = userId;
//        this.password = password;
//        this.name = name;
//    }

    private String userId;
    private String password;
    private String name;
    private final int role;

    public day5.Account toAccount() {
        return new Account(userId,password,name);
    }

}

class Account {
    static final int ROLE_ADMIN = 1;
    static final int ROLE_MEMBER = 2;
    private String userId;
    private String password;
    private String name;

    public Account(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }
}