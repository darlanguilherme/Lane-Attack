package LaneAttack;

import java.io.Serializable;

public class Personagem implements Serializable {

    protected int atk;
    protected int def;
    protected int agi;
    protected int sor;

    public Personagem(int clas, int atk, int def, int agi, int sor) {
        this.atk = atk;
        this.def = def;
        this.agi = agi;
        this.sor = sor;

        if (clas == 1) {
            this.atk += 8;
            this.def += 7;
            this.agi += 2;
            this.sor += 1;
        }
        if (clas == 2) {
            this.atk += 1;
            this.def += 1;
            this.agi += 5;
            this.sor += 11;
        }
        if (clas == 3) {
            this.atk += 5;
            this.def += 2;
            this.agi += 3;
            this.sor += 8;
        }
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getAgi() {
        return agi;
    }

    public int getSor() {
        return sor;
    }

}
