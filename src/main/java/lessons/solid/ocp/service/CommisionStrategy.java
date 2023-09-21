package lessons.solid.ocp.service;

import lessons.solid.ocp.model.Account;
import lessons.solid.ocp.service.commission.CommissionHandler;

public interface CommisionStrategy {
    CommissionHandler get(Account.Type type);
}
