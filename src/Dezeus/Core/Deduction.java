package Dezeus.Core;

public class Deduction {

    private Statements knowns = new Statements();
    private Statements assumptions = new Statements();

    private int level = 1;

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
        this.level++;
        knowns.add(deduction.knowns);
        assumptions.add(deduction.assumptions);
    }

    public Statements getKnowns() {
        return knowns;
    }

    public Statements getAssumptions() {
        return assumptions;
    }

    public int getLevel() {
        return level;
    }

    public String getLevelIndentation() {
        String indentation = "";
        for(int i = 0; i < level; i++) {
            indentation += " ";
        }
        return indentation;
    }
}
