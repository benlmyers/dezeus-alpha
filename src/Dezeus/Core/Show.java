package Dezeus.Core;

public class Show {

    private Statement statement;
    private Deduction deduction;

    public Show(Statement statement, Deduction deduction) {
        this.statement = statement;
        this.deduction = deduction;
    }

    public Show(Statement statement) {
        this.statement = statement;
        this.deduction = new Deduction();
    }

    public Truth show() {
        Logger.log(this);
        // Use existing theorems to aid in proving.
        // Otherwise, use a truth table to brute force the proof.
        return new Truth(false);
    }

    public String toString() {
        return deduction.getLevelIndentation() + "Show " + statement.toString();
    }

    public Statement getStatement() {
        return statement;
    }

    public Deduction getDeduction() {
        return deduction;
    }
}