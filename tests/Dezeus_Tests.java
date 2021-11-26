import Dezeus.Core.*;

class Dezeus_Tests {

    public static void main(String[] args) {

        System.out.println("Dezeus (Alpha)");

        Variable a = new Variable();
        Variable b = new Variable();
        Variable c = new Variable();

        Statement p = a.implies(b);
        Statement q = b.implies(c);
        Statement r = a.implies(c);

        Statement assumption = p.and(q);
        Statement conclusion = r;

        Proposition proposition = new Proposition(assumption, conclusion);

        // proposition.prove();
    }
}
