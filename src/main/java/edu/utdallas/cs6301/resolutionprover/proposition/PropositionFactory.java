package edu.utdallas.cs6301.resolutionprover.proposition;

public class PropositionFactory {
    private static final char NOT_OPERATOR = '~';

    public static Proposition getProposition(String literal) {
        return literal.charAt(0) == NOT_OPERATOR ?
                new NegatedProposition(new AtomicProposition(literal.substring(1))) :
                new AtomicProposition(literal);
    }
}
