package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class AtorJogador {

    private static AtorJogador instance;

    private boolean vez;
    protected String idUsuario;
    protected Controle ctrl;
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
        ctrl = new Controle(this);
    }

    
    public void tratarInicio(int posicao) {
        vez = (posicao == 1);

        if (telaAtributos == null) {
            telaAtributos = new TelaAtributos(this);
        }
        telaPrincipal.setVisible(false);
        telaAtributos.setVisible(true);
    }

    
    void iniciarNovoRound() {
        ctrl.limparComposicao();
        telaAtributos.setVisible(true);
        telaPrincipal.setVisible(false);
    }


    public void enviarJogada(Composicao composicao) {
        System.out.println("Enviei uma Jogada");
        vez = false;
        rede.enviarJogada(composicao);
        ctrl.setComposicao(composicao);
        if (true) {
            System.out.println("Enviei uma Jogada e esta preenchida");
            ctrl.meuId = 2;
            ctrl.iniciarCombate();
        }
        
    }

    public void receberJogada(Composicao composicao) {
        vez = true;
        ctrl.setComposicao(composicao);
        System.out.println("Recebi uma Jogada");
        if (true) {
            System.out.println("Recebi uma Jogada e está preenchida");
            ctrl.meuId = 1;
            ctrl.iniciarCombate();
        }
    }

    public boolean isVez() {
        return vez;
    }

    
    void voceVenceu() {
        telaPrincipal.exibirDialogoVoceVenceu();
    }

    void vocePerdeu() {
        telaPrincipal.exibirDialogoVocePerdeu();
    }

    void voceVenceuRound() {
        telaPrincipal.exibirDialogoVoceVenceuRound();
    }

    void vocePerdeuRound() {
        telaPrincipal.exibirDialogoVocePerdeuRound();
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
    
    public void desconectar() {
        rede.desconectar();
    }

}
