package edu.utdallas.cs6301.resolutionprover.proposition;

import java.util.Iterator;
import java.util.Set;

public interface Proposition {
    Proposition resolve(Proposition other);

    default boolean normalizeSet(Set<Proposition> propositions) {
        return false;
    }
}
