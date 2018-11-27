package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Composicao implements Jogada{

	protected Classe classe;

//	public void assumir(Classe classe) {
//		return this.classe;
//	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
}