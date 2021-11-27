package Dezeus.Core;

import java.util.Set;

public class Variable extends Statement {

    public static Set<String> usedNames;

    public String name;

    public Variable(String name) {
        super();
        this.name = name;
        usedNames.add(name);
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