package lessons.solid.ocp;

import lessons.solid.ocp.dao.AccountDaoImpl;
import lessons.solid.ocp.db.Storage;
import lessons.solid.ocp.model.Account;
import lessons.solid.ocp.service.*;
import lessons.solid.ocp.service.commission.*;
import lessons.solid.ocp.service.commission.impl.GoldCommissionHandler;
import lessons.solid.ocp.service.commission.impl.PlatinumCommissionHandler;
import lessons.solid.ocp.service.commission.impl.RegularCommissionHandler;
import lessons.solid.ocp.service.commission.impl.UsualCommissionHandler;
import lessons.solid.ocp.service.impl.AccountServiceImpl;
import lessons.solid.ocp.service.impl.BankServiceImpl;
import lessons.solid.ocp.service.impl.CommisionStrategyImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // SOLID: OCP
        // Create commission map
        Map<Account.Type, CommissionHandler> commissionHandlersMap = new HashMap<>();
        commissionHandlersMap.put(Account.Type.GOLD, new GoldCommissionHandler());
        commissionHandlersMap.put(Account.Type.PLATINUM, new PlatinumCommissionHandler());
        commissionHandlersMap.put(Account.Type.REGULAR, new RegularCommissionHandler());
        commissionHandlersMap.put(Account.Type.USUAL, new UsualCommissionHandler());
        // Create demo-accounts
        AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());
        accountService.createNewAccount("1233", Account.Type.GOLD);
        accountService.createNewAccount("5788", Account.Type.PLATINUM);
        accountService.createNewAccount("7788", Account.Type.USUAL);
        accountService.createNewAccount("3344", Account.Type.REGULAR);

        for (int i = 0; i < Storage.accounts.size(); i++) {
            System.out.println(Storage.accounts.get(i));
        }
        System.out.println("----------------");

        // Make transfer money between accounts
        CommisionStrategyImpl commission = new CommisionStrategyImpl(commissionHandlersMap);
        BankService bankService = new BankServiceImpl(new AccountDaoImpl(), commission);

        bankService.transfer("1233", "5788", new BigDecimal(1000));
        bankService.transfer("5788", "7788", new BigDecimal(1000));
        bankService.transfer("7788", "3344", new BigDecimal(1000));
        bankService.transfer("3344", "1233", new BigDecimal(1000));

        for (int i = 0; i < Storage.accounts.size(); i++) {
            System.out.println(Storage.accounts.get(i));
        }
    }
}
