package Dezeus.Derivation;

public class DerivationException extends Exception {

    protected String description;

    public DerivationException(String description) {
        super();
        this.description = description;
    }

    @Override
    public void printStackTrace() {
        System.out.println(description);
    }
}
