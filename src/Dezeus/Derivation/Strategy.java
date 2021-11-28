package Dezeus.Derivation;

import Dezeus.Core.Show;

public interface Strategy {

    public Justification dezeus(Show show) throws DerivationException;
}
