package LaneAttack;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Classe implements Serializable {

    protected Personagem[] personagens;

    public Classe() {
        personagens = new Personagem[3];
    }

    public Personagem[] getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Personagem[] personagens) {
        this.personagens = personagens;
    }

}
