package Dezeus.Core;

import java.util.concurrent.CompletableFuture.AsynchronousCompletionTask;

public class Proposition {

    private Statement statement;

    public Proposition(Statement proposition) {
        this.statement = proposition;
    }
}
