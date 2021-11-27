package Dezeus.Core;

public class Truth extends Statement {

    private Boolean value;

    public Truth(Boolean value) {
        this.value = value;
    }

    public Truth getTruth() {
        return this;
    }

    public int logicalSize() {
        return 1;
    }

    public Boolean getValue() {
        return value;
    }

    public String toString() {
        if (value)
            return "True";
        else
            return "False";
    }

    // Logical Operators

    public static Truth and(Truth a, Truth b) {
        return new Truth(a.getValue() && b.getValue());
    }

    public static Truth or(Truth a, Truth b) {
        return new Truth(a.getValue() || b.getValue());
    }

    public static Truth not(Truth a) {
        return new Truth(!a.getValue());
    }

    public static Truth cond(Truth ant, Truth cons) {
        if (ant.getValue()) {
            return cons;
        } else {
            return new Truth(true);
        }
    }

    public static Truth bicond(Truth a, Truth b) {
        return new Truth(a.getValue().equals(b.getValue()));
    }
}