package lessons.solid.srp.service;

import lessons.solid.srp.dao.AccountDao;
import lessons.solid.srp.model.Account;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService{
    private AccountDao accountDao;

    public BankServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        // TODO: implement

        // 1. Get account from storage
        Account fromAccount = accountDao.get(fromAccountNumber);
        Account toAccount = accountDao.get(toAccountNumber);

        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        toAccount.setAmount(newValueTo);

        accountDao.update(fromAccount);
        accountDao.update(toAccount);
        // 2. Transfer money between accounts
    }
}
