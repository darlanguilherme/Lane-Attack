package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Composicao implements Jogada {

    protected Classe classeJogador1;
    protected Classe classeJogador2;

    public Composicao() {
        classeJogador1 = null;
        classeJogador2 = null;
    }

    void limpar() {
        classeJogador1 = null;
        classeJogador2 = null;
    }

    public boolean estaPreenchido() {
        return classeJogador1 != null && classeJogador2 != null;
    }

    void setClasse(Classe classe) {

        if (classeJogador1 == null) {
            classeJogador1 = classe;
        } else {
            classeJogador2 = classe;
        }
    }

    public int getVencedor() {
        int pontosj1 = 0, pontosj2 = 0;

        if (classeJogador1.getPoderP1() > classeJogador2.getPoderP1()) {
            pontosj1 += 1;
        } else {
            pontosj2 += 1;
        }

        if (classeJogador1.getPoderP2() > classeJogador2.getPoderP2()) {
            pontosj1 += 1;
        } else {
            pontosj2 += 1;
        }

        if (classeJogador1.getPoderP3() > classeJogador2.getPoderP3()) {
            pontosj1 += 1;
        } else {
            pontosj2 += 1;
        }

        if (pontosj1 > pontosj2) {
            return 1;
        } else {
            return 2;
        }

    }

}
