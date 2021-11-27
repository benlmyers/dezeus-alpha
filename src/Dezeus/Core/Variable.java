package Dezeus.Core;

import java.util.Set;
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

    public Truth getTruth() {
        return new Truth(false);
    }

    public String toString() {
        return this.name;
    }
}