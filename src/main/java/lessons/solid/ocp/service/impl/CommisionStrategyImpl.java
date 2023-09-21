package lessons.solid.ocp.service.impl;

import lessons.solid.ocp.model.Account;
import lessons.solid.ocp.service.CommisionStrategy;
import lessons.solid.ocp.service.commission.CommissionHandler;

import java.util.Map;

public class CommisionStrategyImpl implements CommisionStrategy {
    private Map<Account.Type, CommissionHandler> commissionHandlerMap;

    public CommisionStrategyImpl(Map<Account.Type, CommissionHandler> commissionHandlerMap) {
        this.commissionHandlerMap = commissionHandlerMap;
    }

    @Override
    public CommissionHandler get(Account.Type type) {
        return commissionHandlerMap.get(type);
    }
}
