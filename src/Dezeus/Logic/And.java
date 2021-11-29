package Dezeus.Logic;

import java.util.Set;

import Dezeus.Core.*;
import Dezeus.Derivation.InvalidException;
import Dezeus.Derivation.Justification;

public class And extends Statement {

    private Statement a, b;

    public And(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    public int logicalSize() {
        return a.logicalSize() + b.logicalSize();
    }

    public Truth getTruth(Set<Variable> props) {
        return Truth.and(a.getTruth(props), b.getTruth(props));
    }

    @Override
    public Statements getChildren() {
        return new Statements(a, b);
    }

    @Override
    public Deduction getDeduction() {
        Statements statements = new Statements(a, b);
        return new Deduction(statements);
    }

    public String toString() {
        return a.groupedString() + " /\\ " + b.groupedString();
    }

    @Override
    public Justification dezeus(Set<Variable> trueVariables) throws InvalidException {
        Justification left = a.dezeus(trueVariables);
        Justification right = b.dezeus(trueVariables);
        if(left != null && right != null)
            return new Justification("Adjunction", "ADJ");
            else throw new AndDerivationException(left != null, right != null);
    }

    public class AndDerivationException extends InvalidException {

        public AndDerivationException(String description) {
            super(description);
        }

        public AndDerivationException(Boolean a, Boolean b) {
            super("This AND statement is invalid.");
            if (!a && !b)
                super.description = "Both sides are invalid.";
            else if (!a)
                super.description = "The left side is invalid.";
            else if (!b)
                super.description = "The right side is invalid.";
        }
    }
}