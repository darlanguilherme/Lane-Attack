package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Composicao implements Jogada {

    protected Classe classeJogador1;
    protected Classe classeJogador2;

    public Composicao() {
        classeJogador1 = null;
        classeJogador2 = null;
    }

    public boolean estaPreenchido() {
        return classeJogador1 != null && classeJogador2 != null;
    }

    public int getVencedor() {
        int pontosj1 = 0, pontosj2 = 0;

        if (classeJogador1.getPoderP1() > classeJogador2.getPoderP1()) {
            pontosj1 += 1;
        }else{
            pontosj2 += 1;
        }
        
       if (classeJogador1.getPoderP2() > classeJogador2.getPoderP2()) {
            pontosj1 += 1;
        }else{
            pontosj2 += 1;
        }
       
       if (classeJogador1.getPoderP3() > classeJogador2.getPoderP3()) {
            pontosj1 += 1;
        }else{
            pontosj2 += 1;
        }
       
       if(pontosj1 > pontosj2){
       return 1;
       }else{return 2;}

    }

    public Classe getClasseJogador1() {
        return classeJogador1;
    }

    public void setClasseJogador1(Classe classeJogador1) {
        this.classeJogador1 = classeJogador1;
    }

    public Classe getClasseJogador2() {
        return classeJogador2;
    }

    public void setClasseJogador2(Classe classeJogador2) {
        this.classeJogador2 = classeJogador2;
    }

}
