package LaneAttack;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Personagem implements Serializable{
    protected int atk;
    protected int def;
    protected int agi;
    protected int sor;

    public Personagem(int atk, int def, int agi, int sor) {
        this.atk = atk;
        this.def = def;
        this.agi = agi;
        this.sor = sor;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getSor() {
        return sor;
    }

    public void setSor(int sor) {
        this.sor = sor;
    }
    
    
}