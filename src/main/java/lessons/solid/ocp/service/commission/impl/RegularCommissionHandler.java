package lessons.solid.ocp.service.commission.impl;

import lessons.solid.ocp.service.commission.CommissionHandler;

import java.math.BigDecimal;

public class RegularCommissionHandler implements CommissionHandler {
    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.01"));
    }
}
