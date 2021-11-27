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
        // TODO: Implement
        return new Truth(false);
    }

    public String toString() {
        return statement.toString();
    }

    public Statement getStatement() {
        return statement;
    }
}