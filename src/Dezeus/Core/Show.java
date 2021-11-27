package Dezeus.Core;

public class Show {

    private Statement statement;

    public Show(Statement statement) {
        this.statement = statement;
    }

    public Truth show() {
        Deduction deduction = new Deduction();
        return show(deduction);
    }

    public Truth show(Deduction deduction) {
        Logger.log(this);
        return new Truth(false);
    }
}