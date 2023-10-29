package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {

    private AccountDAO accountDAO;
    
    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public Account postNewUserRegistration(Account account) {
        return accountDAO.postNewUserRegistration(account);
    }

    public String getUserNameString(Account account){
        return accountDAO.getUserNameString(account);
    }

    public String getPasswordString(Account account){
        return accountDAO.getPasswordString(account);
    }

    public Account postUserLogin(Account account) {
        return accountDAO.postUserLogin(account);
    }


}
