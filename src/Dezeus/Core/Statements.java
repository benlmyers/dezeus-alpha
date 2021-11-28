package Dezeus.Core;

import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;

public class Statements implements Collection<Statement> {
    
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

    @Override
    public boolean isEmpty() {
        return statements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return statements.contains(o);
    }

    @Override
    public Object[] toArray() {
        return statements.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return statements.toArray(a);
    }

    @Override
    public boolean add(Statement e) {
        return statements.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return statements.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return statements.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Statement> c) {
        return statements.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return statements.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return statements.retainAll(c);
    }

    @Override
    public void clear() {
        statements.clear();
    }
}
