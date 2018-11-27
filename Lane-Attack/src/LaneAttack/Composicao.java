package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Composicao implements Jogada {

    protected Classe classe;

    public Composicao(Classe classe) {
        this.classe = classe;
    }
    
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Classe getClasse() {
        return classe;
    }
}
