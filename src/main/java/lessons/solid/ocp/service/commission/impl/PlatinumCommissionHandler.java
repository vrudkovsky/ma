package lessons.solid.ocp.service.commission.impl;

import lessons.solid.ocp.service.commission.CommissionHandler;

import java.math.BigDecimal;

public class PlatinumCommissionHandler implements CommissionHandler {
    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        return new BigDecimal(0);
    }
}
