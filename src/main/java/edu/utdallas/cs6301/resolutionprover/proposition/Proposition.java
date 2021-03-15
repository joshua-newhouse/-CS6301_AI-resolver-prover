package edu.utdallas.cs6301.resolutionprover.proposition;

import java.util.Set;

public interface Proposition {
    default boolean normalizeSet(Set<Proposition> propositions) {
        return false;
    }
}
