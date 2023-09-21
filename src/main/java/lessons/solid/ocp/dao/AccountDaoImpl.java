package lessons.solid.ocp.dao;

import lessons.solid.ocp.db.Storage;
import lessons.solid.ocp.model.Account;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void add(Account account) {
        Storage.accounts.add(account);
    }

    @Override
    public Account get(String accountNumber) {
        return Storage.accounts.stream()
                .filter(a -> a.getNumber().equals(accountNumber))
                .findFirst().get();
    }

    @Override
    public void update(Account account) {
        Account accountFromDb = get(account.getNumber());
        Storage.accounts.remove(accountFromDb);
        add(account);
    }
}
