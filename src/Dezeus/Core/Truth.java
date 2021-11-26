package Dezeus.Core;

public class Truth implements Statement {

    private Boolean value;

    public Truth(Boolean value) {
        this.value = value;
    }

    @Override
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

    // Convenience Methods

    public Truth and(Truth b) {
        return and(this, b);
    }
}