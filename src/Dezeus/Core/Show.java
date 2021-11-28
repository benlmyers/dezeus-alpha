package Dezeus.Core;

import Dezeus.Derivation.*;

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
        Justification reason;
        try {
            reason = strategy.dezeus(this);
        } catch (DerivationException e) {
            Logger.log("[x] Derivation Exception");
            e.printStackTrace();
            return new Truth(false);
        }
        Logger.log(" " + deduction.getLevelIndentation() + statement + ".\t\t" + reason + "\t<QED>");
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