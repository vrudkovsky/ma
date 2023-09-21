package lessons.solid.ocp.service.impl;

import lessons.solid.ocp.dao.AccountDao;
import lessons.solid.ocp.model.Account;
import lessons.solid.ocp.service.BankService;
import lessons.solid.ocp.service.CommisionStrategy;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {
    private AccountDao accountDao;
    private CommisionStrategy commisionStrategy;

    public BankServiceImpl(AccountDao accountDao, CommisionStrategy commisionStrategy) {
        this.accountDao = accountDao;
        this.commisionStrategy = commisionStrategy;
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account fromAccount = accountDao.get(fromAccountNumber);
        Account toAccount = accountDao.get(toAccountNumber);

        // TODO: calculate commision based on account type
        // if Account.Type.REGULAR --> commisionis 1% from amount
        // if Account.Type.Gold --> commisionis 3 UAH
        // if Account.Type.PLATINUM --> commisionis 0 UAH
        // if Account.Type.USUAL --> commisionis 10 UAH

//        BigDecimal commission = new BigDecimal(0);
//        if (fromAccount.getType() == Account.Type.REGULAR) {
//            commission = amount.multiply(new BigDecimal("0.01"));
//        } else if (fromAccount.getType() == Account.Type.GOLD) {
//            commission = new BigDecimal(3);
//        } else if (fromAccount.getType() == Account.Type.USUAL) {
//            commission = new BigDecimal(10);
//        }

        BigDecimal commission = commisionStrategy.get(fromAccount.getType()).getCommission(amount);


        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount).subtract(commission);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        toAccount.setAmount(newValueTo);

        accountDao.update(fromAccount);
        accountDao.update(toAccount);
    }
}
