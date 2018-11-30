package LaneAttack;

import java.io.Serializable;

public class Personagem implements Serializable {

    protected int clas;
    protected int atk;
    protected int def;
    protected int agi;
    protected int sor;

    public Personagem(int clas, int atk, int def, int agi, int sor) {
        this.clas = clas;
        switch (clas) {
            case 1: //cavaleiro
                this.atk = (int) ((atk * 1.02) + 8);
                this.def = (int) ((def * 1.01) + 7);
                this.agi = (int) ((agi * 0.3) + 2);
                this.sor = (int) ((sor * 0.7) + 1);
                break;
            case 2: //feiticeira
                this.atk = (int) ((atk * 0.25) + 1);
                this.def = (int) ((def * 0.5) + 1);
                this.agi = (int) ((agi * 1.1) + 5);
                this.sor = (int) ((sor * 1.3) + 10);
                break;
            case 3: //goku
                this.atk = (int) ((atk * 1.1) + 5);
                this.def = (int) ((def * 0.5) + 2);
                this.agi = (int) ((agi * 1.02) + 3);
                this.sor = (int) ((sor * 0.7) + 3);
                break;
        }

    }

    public int getPoder() {
        return (int) (atk + def + agi + (sor * 1.02));
    }

}
