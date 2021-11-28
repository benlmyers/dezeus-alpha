package Dezeus.Derivation;

import java.util.Set;
import java.util.HashSet;

import Dezeus.Core.*;

public class TruthTableStrategy implements Strategy {

    public static final boolean LOG_TABLE = true;

    public void dezeus(Show show) throws DerivationException {
        Set<Variable> variables = show.getStatement().getVariables();
        Statements knowns = show.getDeduction().getKnowns();
        Statement conclusion = show.getStatement();
        logHeader(variables, knowns, conclusion);
        Set<Set<Variable>> rows = getSubsets(variables);
        for (Set<Variable> row : rows) {
            try {
                rowValid(row, variables, knowns, conclusion);
            } catch (PremiseBrokenException e) {
                continue;
            }
        }
    }

    private boolean rowValid(Set<Variable> props, Set<Variable> allVariables, Statements premises, Statement conclusion)
            throws DerivationException {
        String propsSegment = "";
        for (Variable variable: allVariables) {
            if(props.contains(variable)) {
                propsSegment += variable.toString() + "(T) \t";
            } else {
                propsSegment += variable.toString() + "(F) \t";
            }
        }
        String premisesSegment = "";
        for (Statement premise : premises) {
            Truth rowTruth = premise.getTruth(props);
            if (rowTruth.getValue()) {
                premisesSegment += premise.toString() + "(✔) \t";
            } else {
                premisesSegment += premise.toString() + "(✖) \t";
                Logger.log(propsSegment + "| " + premisesSegment + " ⬇");
                throw new PremiseBrokenException(premise);
            }
        }
        Truth conclusionTruth = conclusion.getTruth(props);
        if (!conclusionTruth.getValue()) {
            Logger.log(propsSegment + "| " + premisesSegment + "|- " + conclusion + " (✖)");
            throw new ConclusionFailedException(conclusion);
        } else {
            Logger.log(propsSegment + "| " + premisesSegment + "|- " + conclusion + " (✔) ⬇");
            return true;
        }
    }

    private void logHeader(Set<Variable> props, Statements knowns, Statement conclusion) {
        if (!LOG_TABLE)
            return;
        Logger.title("Truth Table");
        String propsSegment = "";
        for (Variable prop : props) {
            propsSegment += prop.toString() + "(-) \t";
        }
        String knownsSegment = "";
        for (Statement known : knowns) {
            knownsSegment += known.toString() + "(-) \t";
        }
        System.out.println(propsSegment + "| " + knownsSegment + "|- " + conclusion + " (-)");
    }

    private static <T> Set<Set<T>> getSubsets(Set<T> original) {
        Set<Set<T>> allSubsets = new HashSet<>();
        allSubsets.add(new HashSet<>()); // Add empty set.
        for (T element : original) {
            Set<Set<T>> tempClone = new HashSet<>(allSubsets);
            for (Set<T> subset : tempClone) {
                Set<T> extended = new HashSet<>(subset);
                extended.add(element);
                allSubsets.add(extended);
            }
        }
        return allSubsets;
    }

    private class PremiseBrokenException extends DerivationException {

        final Statement premise;

        PremiseBrokenException(Statement premise) {
            this.premise = premise;
        }

        @Override
        public void printStackTrace() {
            System.out.println("Premise" + premise + " invalid.");
        }
    }

    private class ConclusionFailedException extends InvalidException {

        final Statement conclusion;

        ConclusionFailedException(Statement conclusion) {
            this.conclusion = conclusion;
        }

        @Override
        public void printStackTrace() {
            System.out.println("Conclusion" + conclusion + " failed.");
        }
    }
}