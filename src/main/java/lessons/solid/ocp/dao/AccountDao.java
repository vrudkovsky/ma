package lessons.solid.ocp.dao;

import lessons.solid.ocp.model.Account;

public interface AccountDao {
    public void add(Account account);
    Account get(String accountNumber);
    void update(Account account);
}
