package Dezeus.Core;

import java.util.Set;

public class Show {

    private Statement statement;

    public Show(Statement statement) {
        this.statement = statement;
    }

    public Truth show() {
        Statements knowns = new Statements();
        return show(knowns);
    }

    public Truth show(Statements knowns) {
        return new Truth(false);
    }
}