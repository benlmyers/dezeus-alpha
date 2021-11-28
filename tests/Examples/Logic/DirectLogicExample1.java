package Examples.Logic;

import Dezeus.Core.*;

public class DirectLogicExample1 {

    public static void main(String[] args) {

        Variable a = new Variable("A");
        Variable b = new Variable("B");
        Variable c = new Variable("C");
        Variable d = new Variable("D");

        Statement p = a.implies(b.implies(c));
        Statement q = (b.implies(c)).implies(d);
        Statement r = d.not();
        Statement s = a.not();

        Proposition proposition = new Proposition(p.and(q).and(r), s);

        Truth result = proposition.prove();
    }
}