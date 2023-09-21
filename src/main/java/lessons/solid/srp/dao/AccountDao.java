package lessons.solid.srp.dao;

import lessons.solid.srp.model.Account;

public interface AccountDao {
    public void add(Account account);
    Account get(String accountNumber);

    void update(Account account);
}
