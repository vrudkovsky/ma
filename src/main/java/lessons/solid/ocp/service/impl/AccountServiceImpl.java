package lessons.solid.ocp.service.impl;

import lessons.solid.ocp.dao.AccountDao;
import lessons.solid.ocp.model.Account;
import lessons.solid.ocp.service.AccountService;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void createNewAccount(String accountNumber, Account.Type type) {
        Account account = new Account();
        account.setNumber(accountNumber);
        account.setType(type);
        accountDao.add(account);
    }
}
