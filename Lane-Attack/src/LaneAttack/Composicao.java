package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Composicao implements Jogada {

    protected Classe classeJogador1;
    protected Classe classeJogador2;

    public Composicao() {
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
    
    
    public boolean estaPreenchido(){
        return classeJogador1 != null && classeJogador2 != null;
    }
    
}

