package Dezeus.Core;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class Statements implements Iterable<Statement> {
    
    private Set<Statement> statements = new HashSet<>();

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

    public String toString() {
        String string = "";
        while(statements.iterator().hasNext()) {
            string = statements.iterator().next() + ".";
        }
        return string;
    }

    public Set<Statement> getSet() {
        return this.statements;
    }

    public Set<Variable> getVariables() {
        Set<Variable> variables = new HashSet<>();
        while(statements.iterator().hasNext()) {
            variables.addAll(statements.iterator().next().getVariables());
        }
        return variables;
    }

    public int size() {
        return statements.size();
    }

    public Iterator<Statement> iterator() {
        return statements.iterator();
    }

    public Statement toStatement() {
        if(statements.isEmpty()) {
            return new Truth(false);
        } else if(statements.size() == 1) {
            return statements.iterator().next();
        } else {
            Statement group = statements.iterator().next();
            while(statements.iterator().hasNext()) {
                group = group.and(statements.iterator().next());
            }
            return group;
        }
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
