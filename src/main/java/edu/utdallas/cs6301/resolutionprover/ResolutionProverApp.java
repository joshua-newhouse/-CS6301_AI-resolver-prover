package edu.utdallas.cs6301.resolutionprover;

import edu.utdallas.cs6301.resolutionprover.io.FileIOService;
import edu.utdallas.cs6301.resolutionprover.proposition.PropositionFactory;

import java.io.IOException;

public class ResolutionProverApp {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Program expects exactly 1 argument; the knowledge base file path.");
            System.exit(1);
        }

        FileIOService ioService = new FileIOService(args[0]);

        System.out.printf("Constructing the knowledge base from file %s\n", args[0]);

        KnowledgeBase knowledgeBase = new KnowledgeBase();
        ioService.getInputLines().forEach(line -> {
            String[] literals = line.split(" ");

            Clause clause = new Clause();
            for(String literal : literals) {
                if (!clause.add(PropositionFactory.getProposition(literal))) {
                    System.out.printf("Duplicate proposition dropped from clause. %s\n", literal);
                }
            }

            knowledgeBase.add(clause);
        });

        knowledgeBase.print(System.out);

        System.out.println("Resolving the knowledge base");
        boolean result = knowledgeBase.resolve();

        if (result) {
            knowledgeBase.print(System.out);
        } else {
            System.out.println("Failure");
        }
    }
}
