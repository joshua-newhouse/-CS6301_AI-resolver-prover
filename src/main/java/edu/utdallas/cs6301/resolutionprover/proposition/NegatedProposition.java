package edu.utdallas.cs6301.resolutionprover.proposition;

import java.util.Objects;
import java.util.Set;

public class NegatedProposition implements Proposition {
    private final AtomicProposition proposition;

    public NegatedProposition(AtomicProposition proposition) {
        this.proposition = proposition;
    }

    @Override
    public boolean normalizeSet(Set<Proposition> propositions) {
        return propositions.remove(proposition);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        NegatedProposition that = (NegatedProposition) o;
        return Objects.equals(proposition, that.proposition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proposition);
    }

    @Override
    public String toString() {
        return "~" + proposition;
    }
}
