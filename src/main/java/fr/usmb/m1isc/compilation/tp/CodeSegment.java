package fr.usmb.m1isc.compilation.tp;
import java.util.ArrayList;

public class CodeSegment {
    public static class Instruction{
        private final Operateur operateur;
        private final String operandes; //TODO faudra peut-être changer ça si on veut optimiser

        public Instruction(Operateur operateur, String operandes) {
            this.operateur = operateur;
            this.operandes = operandes;
        }

        @Override
        public String toString() {
            switch (operateur) {
                case debut_while:
                case faux_gt:
                case sortie_gt:
                case sortie_while:
                    return operateur.name() + "_" + operandes + ":";
                default:
                    return "\t" + operateur.name() + " " + operandes;
            }
        }
    }

    public enum Operateur{div, push, mov, mul, sub, add, in, debut_while, jz, sortie_while, jmp, jle, faux_gt, sortie_gt, out, pop}

    ArrayList<Instruction> instructions;
    private int nbWhile;
    private int nbGt;

    public CodeSegment() {
        instructions = new ArrayList<>();
        nbWhile = 0;
        nbGt = 0;
    }

    public void add(Operateur op, String operandes){
        //TODO ajouter de quoi optimiser
        instructions.add(new Instruction(op, operandes));
    }

    public int nouveauWhile() {
        return ++nbWhile;
    }

    public int nouveaugt() {
        return ++nbGt;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("CODE SEGMENT\n");
        for (Instruction instruction : instructions)
            res.append(instruction.toString()).append("\n");
        res.append("CODE ENDS\n");
        return res.toString();
    }
}
