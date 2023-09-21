package lessons.solid.srp.service;

import lessons.solid.srp.dao.AccountDao;
import lessons.solid.srp.model.Account;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void createNewAccount(String accountNumber) {
        Account account = new Account();
        account.setNumber(accountNumber);
        accountDao.add(account);
    }
}
