package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;

public class AtorJogador {

    private static AtorJogador instance;

    private boolean vez;
    protected String nomeDoJogador;
    protected Controle map;
    protected AtorNetGames rede = new AtorNetGames(this);
    protected TelaPrincipal telaPrincipal;
    protected TelaAtributos telaAtributos;

    public static AtorJogador getInstance(TelaPrincipal interfacePrincipal) {
        if (instance == null) {
            instance = new AtorJogador(interfacePrincipal);
        }
        return instance;
    }

    public AtorJogador(TelaPrincipal TelaPrincipal) {
        this.telaPrincipal = TelaPrincipal;
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
        System.err.println("cheguei enviarjogada");
        if (telaAtributos == null) {
            telaAtributos = new TelaAtributos(this);
        }
        telaPrincipal.setVisible(false);
        telaAtributos.setVisible(true);
    }

    public void desconectar() {
        rede.desconectar();
    }

    public void enviarJogada(Composicao composicao) {
        rede.enviarJogada(composicao);
        System.err.println("cheguei enviarjogada");
//        if (composicao.estaPreenchido()) {
//            telaPrincipal.informarInicioBatalha();
//        }
        vez = false;
        telaAtributos.setVisible(false);
        telaPrincipal.setVisible(true);
        
    }

    public void receberJogada(Composicao composicao) {

        System.err.println("cheguei receberJogada");
//        telaPrincipal.informarComposicao(composicao);
        vez = true;
        telaAtributos.setVisible(true);
        telaPrincipal.setVisible(false);
//        if (composicao.estaPreenchido()) {
//            telaPrincipal.informarInicioBatalha();
//        } else {
//            telaAtributos.setVisible(true);
//            telaPrincipal.setVisible(false);
//        }
    }

    public boolean isVez() {
        return vez;
    }

}
