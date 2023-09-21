package lessons.solid.ocp.model;

import java.math.BigDecimal;

public class Account {
    private String number;
    private BigDecimal amount = new BigDecimal(10000);
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public enum Type {
        REGULAR, GOLD, PLATINUM, USUAL;
    }

    @Override
    public String toString() {
        return "Account number " + number + "; " +
                "Amount " + amount + ";";
    }
}
