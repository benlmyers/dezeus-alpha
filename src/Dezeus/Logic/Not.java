package Dezeus.Logic;

import java.util.Set;

import Dezeus.Core.*;

public class Not extends Statement {

    private Statement a;

    public Not(Statement a) {
        this.a = a;
    }

    public int logicalSize() {
        return a.logicalSize();
    }

    public Truth getTruth(Set<Variable> props) {
        return Truth.not(a.getTruth(props));
    }

    public String toString() {
        return "!" + a.groupedString();
    }
}
