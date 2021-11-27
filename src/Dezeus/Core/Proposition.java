package Dezeus.Core;

public class Proposition {

    private int number = 1;

    private Statement assumption;
    private Statement conclusion;

    public Proposition(Statement assumption, Statement conclusion) {
        this.assumption = assumption;
        this.conclusion = conclusion;
    }

    public Truth prove() {
        Logger.log(this);
        Deduction deduction = new Deduction(new Statements(), new Statements(assumption));
        Show show = new Show(conclusion, deduction);
        Truth truth = show.show();
        Logger.log(truth);
        return truth;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return "Proposition " + number + ": " + assumption + " |- " + conclusion;
    }

    public Statement getStatement() {
        return assumption.implies(conclusion);
    }
}
