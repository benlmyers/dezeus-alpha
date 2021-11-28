package Dezeus.Core;

import Dezeus.Derivation.DerivationException;
import Dezeus.Derivation.Strategy;
import Dezeus.Derivation.TruthTableStrategy;

public class Show {

    private Statement statement;
    private Deduction deduction;

    public Show(Statement statement, Deduction deduction) {
        this.statement = statement;
        this.deduction = deduction;
    }

    public Show(Statement statement) {
        this.statement = statement;
        this.deduction = new Deduction();
    }

    public Truth show() {
        Logger.log(this);
        Strategy strategy;
        // Use existing theorems to aid in proving.
        // Otherwise, use a truth table to brute force the proof.
        strategy = new TruthTableStrategy();
        try {
            strategy.dezeus(this);
        } catch(DerivationException e) {
            Logger.line();
            Logger.log("[x] Derivation Exception");
            e.printStackTrace();
            return new Truth(false);
        }
        return new Truth(true);
    }

    public String toString() {
        return deduction.getLevelIndentation() + "Show " + statement.toString();
    }

    public Statement getStatement() {
        return statement;
    }

    public Deduction getDeduction() {
        return deduction;
    }
}