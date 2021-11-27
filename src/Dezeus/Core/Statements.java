package Dezeus.Core;

import java.util.Iterator;
import java.util.Set;

public class Statements implements Iterable<Statement> {
    
    private Set<Statement> statements;

    public Statements() {

    }

    public Statements(Statement statement) {
        statements.add(statement);
    }

    public Statements(Statement a, Statement b) {
        statements.add(a);
        statements.add(b);
    }

    public Statements(Statements statements) {
        statements.add(statements);
    }

    public Set<Statement> getSet() {
        return this.statements;
    }

    public Iterator<Statement> iterator() {
        return statements.iterator();
    }

    public void add(Statements statements) {
        while(statements.iterator().hasNext()) {
            add(statements.iterator().next());
        }
    }

    public void add(Statement statement) {
        statements.add(statement);
    }
}
