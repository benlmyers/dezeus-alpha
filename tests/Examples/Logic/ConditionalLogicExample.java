package Examples.Logic;

import Dezeus.Core.*;

public class ConditionalLogicExample {
    
    public static void main(String[] args) {

        System.out.println("Transitive Logic Example\n");

        Variable a = new Variable("A");
        Variable b = new Variable("B");

        Statement p = a.implies(b);

        Statement assumption = a.and(p);
        Statement conclusion = b;

        Proposition proposition = new Proposition(assumption, conclusion);

        proposition.prove();
    }
}
