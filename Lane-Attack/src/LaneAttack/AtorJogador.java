package LaneAttack;

import br.ufsc.inf.leobr.cliente.Jogada;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class AtorJogador {

    private static AtorJogador instance;

    private boolean vez;
    protected Controle ctrl;
    
    private String idJogador;
    
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
        telaPrincipal.setNomeAdversario(rede.informarNomeAdversario(idJogador));
        telaPrincipal.setVisible(false);
        telaAtributos.setVisible(true);
    }

    void iniciarNovoRound() {
        ctrl.limparComposicao();
        telaAtributos.setVisible(true);
        telaPrincipal.setVisible(false);
    }
    
     void resetJogo() {
         telaAtributos.setVisible(false);
        telaPrincipal.setVisible(true);
         telaAtributos.dispose();
         desconectar();
    }


    public void enviarJogada(Composicao composicao) throws InterruptedException {
        vez = false;
        rede.enviarJogada(composicao);
        ctrl.setComposicao(composicao);
        telaAtributos.verificarClasses();
        if (ctrl.composicao.estaPreenchido()) {
            ctrl.meuId = 2;
            ctrl.iniciarCombate();
            ctrl.limparComposicao();
        }

    }

    public void receberJogada(Composicao composicao) throws InterruptedException {
        vez = true;
        ctrl.setComposicao(composicao);
        if (ctrl.composicao.estaPreenchido()) {
            ctrl.meuId = 1;
            ctrl.iniciarCombate();
            ctrl.limparComposicao();
        }
    }
    

    public boolean isVez() {
        return vez;
    }

    public boolean conectar(String nome) {
        idJogador = nome;
        telaPrincipal.setNome(nome);
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
}

   
