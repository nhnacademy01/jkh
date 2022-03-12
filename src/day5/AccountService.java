package day5;

class SignInUpShell {

}

public class AccountService {
    private final AccountRepository repository = new AccountRepository();

    void join(JoinRequest req) {
        Acount acount = req.toAccount();
        repository.save(acount);
    }


};

class AccountRepository {
    Acount[] sources = new Acount[10];

    public void save(Acount acount) {
    }
}

class JoinRequest {
    private String userId;
    private String password;
    private String name;

    public Acount toAccount() {
        return null;
    }

}

class Acount {

}