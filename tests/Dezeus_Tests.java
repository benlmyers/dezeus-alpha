import Dezeus.Core.*;

class Dezeus_Tests {

    public static void main(String[] args) {

        System.out.println("Dezeus (Alpha)");

        Variable a = new Variable("A");
        Variable b = new Variable("B");
        Variable c = new Variable("C");

        Statement p = a.and(b);
        Statement q = b.iff(c);
        Statement r = a.or(c);

        Statement assumption = p.and(q);
        Statement conclusion = r;

        Proposition proposition = new Proposition(assumption, conclusion);

        proposition.prove();
    }
}
