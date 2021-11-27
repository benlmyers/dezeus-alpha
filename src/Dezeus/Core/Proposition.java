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
        Show show = new Show(assumption.implies(conclusion));
        Truth truth = show.show();
        Logger.log(truth);
        return truth;
    }

    public int getNumber() {
        return number;
    }
}
