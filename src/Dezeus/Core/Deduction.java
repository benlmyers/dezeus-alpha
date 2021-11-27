package Dezeus.Core;

public class Deduction {

    private Statements knowns = new Statements();
    private Statements assumptions = new Statements();

    public Deduction() {
    }

    public Deduction(Statement known) {
        this.knowns.add(known);
    }

    public Deduction(Statements knowns) {
        this.knowns = knowns;
    }

    public Deduction(Statements knowns, Statements assumptions) {
        this.knowns = knowns;
        this.assumptions = assumptions;
    }

    public void add(Deduction deduction) {
        knowns.add(deduction.knowns);
        assumptions.add(deduction.assumptions);
    }

    public Statements getKnowns() {
        return knowns;
    }

    public Statements getAssumptions() {
        return assumptions;
    }
}
