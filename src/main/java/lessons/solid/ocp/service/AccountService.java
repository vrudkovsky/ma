package lessons.solid.ocp.service;

import lessons.solid.ocp.model.Account;

import java.math.BigDecimal;

public interface AccountService {
    void createNewAccount(String accountNumber, Account.Type type);
}
