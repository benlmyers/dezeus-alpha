package Dezeus.Core;

import java.util.HashSet;
import java.util.Set;

import Dezeus.Derivation.InvalidException;
import Dezeus.Derivation.Justification;
import Dezeus.Logic.*;

public abstract class Statement {

    public abstract Truth getTruth(Set<Variable> props);

    public Set<Variable> getVariables() {
        Statements children = getChildren();
        if (children != null) {
            return children.getVariables();
        } else {
            return new HashSet<>();
        }
    }

    public Boolean hasChildren() {
        return getChildren() != null;
    }

    public Statements getChildren() {
        return null;
    }

    // Deduction Methods

    public abstract Justification dezeus(Set<Variable> trueVariables) throws InvalidException;

    public Deduction getDeduction() {
        return new Deduction(this);
    }

    // Utility Methods

    public abstract int logicalSize();

    public abstract String toString();

    public String groupedString() {
        if (logicalSize() > 1)
            return "(" + toString() + ")";
        else
            return toString();
    }

    // Convenience Methods - Logic

    public Statement and(Statement b) {
        return new And(this, b);
    }

    public Statement or(Statement b) {
        return new Or(this, b);
    }

    public Statement not() {
        return new Not(this);
    }

    public Statement given(Statement ant) {
        return new Cond(ant, this);
    }

    public Statement implies(Statement cons) {
        return new Cond(this, cons);
    }

    public Statement iff(Statement b) {
        return new Bicond(this, b);
    }
}