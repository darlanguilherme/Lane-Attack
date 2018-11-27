package LaneAttack;

public class Jogador {

    protected String nome;
    protected int roundsVencidos;
    protected boolean daVez;
    protected boolean vencedor;

    public void setRoundVencido() {
        roundsVencidos++;
        if (roundsVencidos == 2) {
            assumirVencedor();
        }
    }

    public void iniciar() {
        daVez = false;
        vencedor = false;
    }

    public boolean informarDaVez() {
        return daVez;
    }

    public String informarNome() {
        return nome;
    }

    public boolean informarVencedor() {
        return vencedor;
    }

    public void assumirNome(String idJogador) {
        nome = idJogador;
    }

    public void habilitar() {
        daVez = true;
    }

    public void desabilitar() {
        daVez = false;
    }

    public void assumirVencedor() {
        vencedor = true;
    }

}
