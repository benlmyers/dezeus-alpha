package Dezeus.Core;

import Dezeus.Logic.*;

public abstract class Statement {

    public abstract Truth getTruth();

    // Convenience Methods

    public Statement and(Statement b) {
        return new And(this, b);
    }
}