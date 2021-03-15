package edu.utdallas.cs6301.resolutionprover;

import edu.utdallas.cs6301.resolutionprover.proposition.Proposition;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Clause implements Comparable<Clause> {
    private static final char OR_OPERATOR = '+';

    private final Set<Proposition> propositions;

    private final String parentClauses;

    private int clauseID;

    public Clause() {
        this.propositions = new HashSet<>();
        this.parentClauses = "{}";
    }

    public Clause(Set<Proposition> propositions, int clauseID1, int clauseID2) {
        this.propositions = propositions;
        this.parentClauses = "{" + clauseID1 + "," + clauseID2 + "}";
    }

    public void setClauseID(int clauseID) {
        this.clauseID = clauseID;
    }

    public boolean add(Proposition p) {
        return p.normalizeSet(propositions) || propositions.add(p);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Clause clause = (Clause) o;
        return propositions.equals(clause.propositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propositions);
    }

    @Override
    public int compareTo(Clause clause) {
        return this.equals(clause) ? 0 : clause.clauseID - this.clauseID;
    }

    public Clause resolve(final Clause clause) {
        boolean resolved = false;

        Set<Proposition> p2 = new HashSet<>(this.propositions);

        for(Proposition prop : clause.propositions) {
            boolean thisPropNormed = prop.normalizeSet(p2);

            if(!thisPropNormed) {
                p2.add(prop);
            }

            resolved = resolved || thisPropNormed;
        }

        return resolved ? new Clause(p2, this.clauseID, clause.clauseID) : null;
    }

    public boolean isEmpty() {
        return propositions.isEmpty();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" " + OR_OPERATOR + " ");

        for(Proposition prop : propositions) {
            sj.add(prop.toString());
        }

        return clauseID + ": " + (sj.length() > 0 ? sj : "False") + "    " + parentClauses;
    }
}
