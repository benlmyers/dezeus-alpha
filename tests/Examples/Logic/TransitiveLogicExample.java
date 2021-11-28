package Examples.Logic;

import Dezeus.Core.*;

public class TransitiveLogicExample {
    
    public static void main(String[] args) {

        System.out.println("Transitive Logic Example\n");

        Variable a = new Variable("A");
        Variable b = new Variable("B");
        Variable c = new Variable("C");

        Statement p = a.implies(b);
        Statement q = b.implies(c);
        Statement r = a.implies(c);

        Statement assumption = p.and(q);
        Statement conclusion = r;

        Proposition proposition = new Proposition(assumption, conclusion);

        proposition.prove();
    }
}
