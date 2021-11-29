package Dezeus.Core;

import java.util.Set;

import Dezeus.Derivation.InvalidException;
import Dezeus.Derivation.Justification;

import java.util.HashSet;

public class Variable extends Statement {

    public static Set<String> usedNames = new HashSet<String>();

    public String name;

    public Variable(String name) {
        super();
        this.name = name;
        usedNames.add(name);
    }

    @Override
    public Set<Variable> getVariables() {
        Set<Variable> set = new HashSet<>();
        set.add(this);
        return set;
    }

    public int logicalSize() {
        return 1;
    }

    public Truth getTruth(Set<Variable> props) {
        return new Truth(props.contains(this));
    }

    public String toString() {
        return this.name;
    }

    @Override
    public Justification dezeus(Set<Variable> trueVariables) throws InvalidException {
        if (trueVariables.contains(this)) {
            return new Justification("Variable True", "VT");
        } else {
            throw new VariableDerivationException();
        }
    }

    public class VariableDerivationException extends InvalidException {

        public VariableDerivationException() {
            super("This statement is a false variable.");
        }
    }
}