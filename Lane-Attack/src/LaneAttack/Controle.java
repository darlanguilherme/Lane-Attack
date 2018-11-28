package LaneAttack;

public class Controle {

    protected Composicao composicao;
    protected Combate combate;
    protected AtorJogador atorJogador;
    

    protected Jogador jogador1;
    protected Jogador jogador2;
    protected boolean partidaEmAndamento;
    protected boolean conectado;
    protected int numRounds;
    private static Controle instance;

    public static Controle getInstance() {
        return instance;
    }

    public Controle(AtorJogador ator) {
        composicao = new Composicao();
        atorJogador = ator;
        instance = new Controle(ator);
    }

    
    
    public boolean informarConectado() {
        // TODO - implement Controle.informarConectado
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param valor
     */
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

    /**
     *
     * @param idJogador
     */
    public void criarJoador(String idJogador) {
        // TODO - implement Controle.criarJoador
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

    /**
     *
     * @param composicao
     */
    public void setComposicaoJ1(Composicao composicao) {
        // TODO - implement Controle.setComposicaoJ1
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param composicao
     */
    public void setComposicaoJ2(Composicao composicao) {
        // TODO - implement Controle.setComposicaoJ2
        throw new UnsupportedOperationException();
    }

    public Jogador verificarVencedor() {
        // TODO - implement Controle.verificarVencedor
        throw new UnsupportedOperationException();
    }

    public void tratarRound() {
        // TODO - implement Controle.tratarRound
        throw new UnsupportedOperationException();
    }

    
    public void criarComposicao(int v, int a, int d, int am, int s, int parameter) {
        
    }

    void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    void iniciarCombate() {
        combate.gerarResultado(composicao);
        //Limpar a composicao aqui
    }

    void criarPersonagens(int clas,int parseInt, int parseInt0, int parseInt1, int parseInt2, int parseInt3, int parseInt4, int parseInt5, int parseInt6, int parseInt7, int parseInt8, int parseInt9, int parseInt10) {
        Personagem personagem1 = new Personagem(clas, parseInt, parseInt2, parseInt5, parseInt8);
        Personagem personagem2 = new Personagem(clas, parseInt0, parseInt3, parseInt6, parseInt9);
        Personagem personagem3 = new Personagem(clas, parseInt1, parseInt4, parseInt7, parseInt10);
        
        Personagem[] personagens = new Personagem[3];
        personagens[0] = personagem1;
        personagens[1] = personagem2;
        personagens[2] = personagem3;
        
        if(composicao.classeJogador1 == null){
            composicao.classeJogador1 = new Classe();
            composicao.classeJogador1.setPersonagens(personagens);
            
           atorJogador.enviarJogada(this.composicao);
        }else if(composicao.classeJogador2 == null){
            composicao.classeJogador2 = new Classe();
            composicao.classeJogador2.setPersonagens(personagens);
            
            atorJogador.enviarJogada(this.composicao);
        }else{
            
        }
    }



}
