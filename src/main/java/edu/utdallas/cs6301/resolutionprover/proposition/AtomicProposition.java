package edu.utdallas.cs6301.resolutionprover.proposition;

import java.util.Objects;
import java.util.Set;

public class AtomicProposition implements Proposition {
    private final String identifier;

    public AtomicProposition(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AtomicProposition that = (AtomicProposition) o;
        return Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public Proposition resolve(Proposition other) {
        if (other instanceof NegatedProposition && ((NegatedProposition) other).getProposition().equals(this)) {
            return EmptyProposition.getInstance();
        }

        return this;
    }

    @Override
    public boolean normalizeSet(Set<Proposition> propositions) {
        return propositions.remove(new NegatedProposition(this));
    }

    @Override
    public String toString() {
        return identifier;
    }
}
