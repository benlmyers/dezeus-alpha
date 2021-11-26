package Dezeus.Core;

public class Truth extends Statement {

    private Boolean value;

    public Truth(Boolean value) {
        this.value = value;
    }

    public Truth getTruth() {
        return this;
    }

    public Boolean getValue() {
        return value;
    }

    // Logical Operators

    public static Truth and(Truth a, Truth b) {
        return new Truth(a.getValue() && b.getValue());
    }
}