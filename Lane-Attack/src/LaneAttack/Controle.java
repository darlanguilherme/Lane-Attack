package LaneAttack;

public class Controle {

    protected int meuId;
    protected int roundsVencidos;
    protected int roundsAdvVencido;

    protected Composicao composicao;

    protected Combate combate;
    protected AtorJogador atorJogador;

    protected boolean partidaEmAndamento;
    protected boolean conectado;

    public Controle(AtorJogador ator) {
        atorJogador = ator;
        meuId = 0;
        roundsAdvVencido = 0;
        roundsVencidos = 0;
        combate = new Combate();
    }

    public int verificarVencedor() {
        if (roundsVencidos >= 2) {
            return 1;
        } else if (roundsAdvVencido >= 2) {
            return 2;
        }
        return 0;
    }

    public void criarComposicao(int v, int a, int d, int am, int s, int parameter) {

    }

    public boolean informarConectado() {
        // TODO - implement Controle.informarConectado
        throw new UnsupportedOperationException();
    }

    public void estabelecerConectado(boolean valor) {
        // TODO - implement Controle.estabelecerConectado
        throw new UnsupportedOperationException();
    }

    public boolean informarEmAndamento() {
        // TODO - implement Controle.informarEmAndamento
        throw new UnsupportedOperationException();
    }

    public void iniciar() {
        // TODO - implement Controle.iniciar
        throw new UnsupportedOperationException();
    }

    public void iniciarRound() {
        // TODO - implement Controle.iniciarRound
        throw new UnsupportedOperationException();
    }

    public void finalizarPartida() {
        // TODO - implement Controle.finalizarPartida
        throw new UnsupportedOperationException();
    }

    public void setComposicaoJ1(Composicao composicao) {
        // TODO - implement Controle.setComposicaoJ1
        throw new UnsupportedOperationException();
    }

    public void setComposicaoJ2(Composicao composicao) {
        // TODO - implement Controle.setComposicaoJ2
        throw new UnsupportedOperationException();
    }

    public void tratarRound() {

    }

    void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    void iniciarCombate() {
        if (composicao.getVencedor() == 1 && meuId == 1) {
            roundsVencidos += 1;
            atorJogador.voceVenceuRound();

        } else if (composicao.getVencedor() == 2 && meuId == 2) {
            roundsVencidos += 1;
            atorJogador.voceVenceuRound();
        } else {
            roundsAdvVencido += 1;
            atorJogador.vocePerdeuRound();
        }

        switch (verificarVencedor()) {
            case 1:
                atorJogador.voceVenceu();
                break;

            case 2:
                atorJogador.vocePerdeu();
                break;

            case 0:
                atorJogador.iniciarNovoRound();
        }
    }

    void criarPersonagens(int clas, int parseInt, int parseInt0, int parseInt1, int parseInt2, int parseInt3, int parseInt4, int parseInt5, int parseInt6, int parseInt7, int parseInt8, int parseInt9, int parseInt10) {
        Personagem personagem1 = new Personagem(clas, parseInt, parseInt2, parseInt5, parseInt8);
        Personagem personagem2 = new Personagem(clas, parseInt0, parseInt3, parseInt6, parseInt9);
        Personagem personagem3 = new Personagem(clas, parseInt1, parseInt4, parseInt7, parseInt10);

        Personagem[] personagens = new Personagem[3];
        personagens[0] = personagem1;
        personagens[1] = personagem2;
        personagens[2] = personagem3;

        if (composicao.classeJogador1 == null) {
            composicao.classeJogador1 = new Classe();
            composicao.classeJogador1.setPersonagens(personagens);

            atorJogador.enviarJogada(this.composicao);
        } else if (composicao.classeJogador2 == null) {
            composicao.classeJogador2 = new Classe();
            composicao.classeJogador2.setPersonagens(personagens);

            atorJogador.enviarJogada(this.composicao);
        } else {

        }
    }

    //    void criarJogador(String idJogador) {
//    if (jogador1 == null){
//			jogador1 = new Jogador();
//			jogador1.iniciar();
//			jogador1.assumirNome(idJogador);
//		}else{
//			jogador2 = new Jogador();
//			jogador2.iniciar();
//			jogador2.assumirNome(idJogador);			
//		}    
//    }
    void limparComposicao() {
        this.composicao = null;
    }
}
