package fr.usmb.m1isc.compilation.tp.arbres;

import fr.usmb.m1isc.compilation.tp.ArbreAbstrait;

public class ArbreAnd extends ArbreAbstrait {
    private ArbreEntier e1;
    private ArbreEntier e2;

    public ArbreAnd(ArbreAbstrait e1, ArbreAbstrait e2) {
        this.e1 = (ArbreEntier) e1;
        this.e2 = (ArbreEntier) e2;
    }

    @Override
    public String genereInstructions() {
        String res = "\tmov eax, " + e1.valeur + "\n";
        res += "\tpush eax\n";
        res += "\tjz and_retourne_faux\n";
        res += "\tmov ebx, " + e2.valeur + "\n";
        res += "\tpush ebx\n";
        res += "\tjz and_retourne_faux\n";
        res += "\tpush 1\n";
        res += "\tand_retourne_faux:\n";
        res += "\t\tpush 0\n"; //TODO : voir si nécessaire de pop ebx

        return res;
    }

    @Override
    protected String valeurToString() { return "AND"; }
}
