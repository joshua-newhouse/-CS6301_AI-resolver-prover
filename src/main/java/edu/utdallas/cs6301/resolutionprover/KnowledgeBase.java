package edu.utdallas.cs6301.resolutionprover;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class KnowledgeBase {
    private final ClauseSet clauses = new ClauseSet();
    private int clauseCounter = 1;

    public void add(Clause clause) {
        if(clauses.add(clause)) {
            clause.setClauseID(clauseCounter++);
        }
    }

    public boolean resolve() {
        ClauseSet newClauses;

        do {
            newClauses = new ClauseSet();

            for(Clause clause1 : clauses) {
                ClauseSet tailSet = clauses.getTailSet(clause1);
                for(Clause clause2 : tailSet) {
                    Clause c = clause1.resolve(clause2);
                    if(c == null) continue;

                    if(!clauses.contains(c) && newClauses.add(c)) {
                        c.setClauseID(clauseCounter++);
                    }

                    if(c.isEmpty()) {
                        clauses.addAllClauses(newClauses);
                        return true;
                    }
                }
            }

            clauses.addAllClauses(newClauses);
        } while(!newClauses.isEmpty());

        return false;
    }

    public void print(OutputStream os) throws IOException{
        clauses.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(clause -> {
                    try {
                        os.write((clause.toString() + "\n").getBytes(StandardCharsets.UTF_8));
                    } catch(IOException e) {
                        System.out.println(e.getMessage());
                    }
                });

        os.write(("Size of final clause set: " + clauses.size() + "\n").getBytes(StandardCharsets.UTF_8));
    }

    private static class ClauseSet extends LinkedHashSet<Clause> {
        private ClauseSet getTailSet(Clause fromClause) {
            ClauseSet retSet = new ClauseSet();

            this.stream()
                    .filter(clause -> fromClause.compareTo(clause) > 0)
                    .forEach(retSet::add);

            return retSet;
        }

        private boolean addAllClauses(ClauseSet cs) {
            int initsize = this.size();

            cs.forEach(this::add);

            return initsize + cs.size() == this.size();
        }
    }
}
