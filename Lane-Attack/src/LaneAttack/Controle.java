package LaneAttack;

public class Controle {

    protected int meuId;
    protected int roundsVencidos;
    protected int roundsAdvVencido;

    protected Composicao composicao;

    protected Combate combate;
    protected AtorJogador atorJogador;
    public Classe teste;
    protected boolean partidaEmAndamento;
    protected boolean conectado;

    public Controle(AtorJogador ator) {

        if (composicao == null) {
            composicao = new Composicao();
        }
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

    void criarPersonagens(int clas, int atk1, int atk2, int atk3, int parseInt2, int parseInt3, int parseInt4, int parseInt5, int parseInt6, int parseInt7, int parseInt8, int parseInt9, int parseInt10) {
        Personagem personagem1 = new Personagem(clas, atk1, parseInt2, parseInt5, parseInt8);
        Personagem personagem2 = new Personagem(clas, atk2, parseInt3, parseInt6, parseInt9);
        Personagem personagem3 = new Personagem(clas, atk3, parseInt4, parseInt7, parseInt10);

        Personagem[] personagens = new Personagem[3];
        personagens[0] = personagem1;
        personagens[1] = personagem2;
        personagens[2] = personagem3;

        if (composicao.classeJogador1 == null) {
            composicao.classeJogador1 = new Classe();
            composicao.classeJogador1.setPersonagens(personagens);

            System.out.print("CRIEI E ENVIEI1");

            atorJogador.enviarJogada(this.composicao);
        } else if (composicao.classeJogador2 == null) {
            composicao.classeJogador2 = new Classe();
            composicao.classeJogador2.setPersonagens(personagens);

            System.out.print("CRIEI E ENVIEI2");

            atorJogador.enviarJogada(this.composicao);
        }
        meuId = 0;
    }

    void limparComposicao() {
        this.composicao.limpar();
    }
}
