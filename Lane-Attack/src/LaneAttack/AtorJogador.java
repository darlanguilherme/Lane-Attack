package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;

public class AtorJogador {

    private static AtorJogador instance;

    private boolean vez;
    protected String nomeDoJogador;
    protected Mapa map;
    protected AtorNetGames rede = new AtorNetGames(this);
    protected TelaPrincipal telaPrincipal;
    protected TelaAtributos telaAtributos;

    public static AtorJogador getInstance(TelaPrincipal interfacePrincipal) {
        if (instance == null) {
            instance = new AtorJogador(interfacePrincipal);
        }
        return instance;
    }

    public AtorJogador(TelaPrincipal TelaPraincipal) {
        this.telaPrincipal = TelaPraincipal;
    }

    public boolean conectar(String nome) {
        return rede.conectar(nome);
    }

    public boolean iniciarPartida() {
        if (!rede.isConectado()) {
            return false;
        }
        rede.iniciarPartida();
        rede.setAguardandoJogador(true);
        return true;
    }

    public TelaPrincipal informarJanela() {
        return telaPrincipal;
    }

    public boolean aguardandoJogador() {
        return rede.isAguardandoJogador();
    }

    public void tratarInicio(int posicao) {

        vez = (posicao == 1);

        if (telaAtributos == null) {
            telaAtributos = new TelaAtributos();
        }
        telaPrincipal.setVisible(false);
        telaAtributos.setVisible(true);
    }

    public void desconectar() {

    }

    public void enviarJogada(Composicao composicao) {
        vez = false;
        if (composicao.estaPreenchido()) {    
             telaPrincipal.realizarBatalha();
        }
        rede.enviarJogada(composicao);
    }

    public void receberJogada(Composicao composicao) {
         telaPrincipal.composicao = composicao;
         vez = true;
        if (composicao.estaPreenchido()) {    
             telaPrincipal.realizarBatalha();
        } else{
            telaAtributos.setVisible(true);
            telaPrincipal.setVisible(false);
        }
    }

}
