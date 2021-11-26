package Dezeus.Core;

import Dezeus.Logic.*;

public class Proposition extends Statement {

    private Statement statement;

    public Proposition(Statement proposition) {
        this.statement = proposition;
    }

    public Proposition(Statement assumption, Statement conclusion) {
        this.statement = new Cond(assumption, conclusion);
    }

    public Truth getTruth() {
        return statement.getTruth();
    }
}
