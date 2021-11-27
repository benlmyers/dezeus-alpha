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
}
