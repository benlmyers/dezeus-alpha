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
        for(Statement statement: statements) {
            string = statement + ".";
        }
        return string;
    }

    public Set<Statement> getSet() {
        return this.statements;
    }

    public Set<Variable> getVariables() {
        Set<Variable> variables = new HashSet<>();
        for(Statement statement: statements) {
            variables.addAll(statement.getVariables());
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
            for(Statement statement: statements) {
                group = group.and(statement);
            }
            return group;
        }
    }

    public void add(Statements statements) {
        for(Statement statement: statements) {
            add(statement);
        }
    }

    public void add(Statement statement) {
        statements.add(statement);
    }
}
