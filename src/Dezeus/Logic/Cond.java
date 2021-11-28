package Dezeus.Logic;

import java.util.Set;

import Dezeus.Core.*;

public class Cond extends Statement {

    private Statement ant, cons;

    public Cond(Statement ant, Statement cons) {
        this.ant = ant;
        this.cons = cons;
    }

    public Cond(Statement conditional) {
        Deduction deduction = conditional.getDeduction();
        this.ant = deduction.getAssumptions().toStatement();
        this.cons = deduction.getKnowns().toStatement();
    }

    public int logicalSize() {
        return ant.logicalSize() + cons.logicalSize();
    }

    public Truth getTruth(Set<Variable> props) {
        return Truth.cond(ant.getTruth(props), cons.getTruth(props));
    }

    @Override
    public Statements getChildren() {
        return new Statements(ant, cons);
    }

    @Override
    public Deduction getDeduction() {
        return new Deduction(new Statements(), new Statements(ant));
    }

    public String toString() {
        return ant.groupedString() + " => " + cons.groupedString();
    }
}