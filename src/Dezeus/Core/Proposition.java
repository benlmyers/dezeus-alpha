package Dezeus.Core;

import Dezeus.Logic.*;

public class Proposition {

    private Statement assumption;
    private Statement conclusion;

    public Proposition(Statement assumption, Statement conclusion) {
        this.assumption = assumption;
        this.conclusion = conclusion;
    }
}
