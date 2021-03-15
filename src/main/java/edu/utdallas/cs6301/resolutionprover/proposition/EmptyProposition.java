package edu.utdallas.cs6301.resolutionprover.proposition;

import java.util.Set;

public class EmptyProposition implements Proposition {
    private static final EmptyProposition INSTANCE = new EmptyProposition();

    private EmptyProposition() {
    }

    public static EmptyProposition getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "NIL";
    }

    @Override
    public Proposition resolve(Proposition other) {
        return INSTANCE;
    }
}
