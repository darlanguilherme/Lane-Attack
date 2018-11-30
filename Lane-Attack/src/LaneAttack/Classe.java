package LaneAttack;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Classe implements Serializable {

    protected Personagem[] personagens;

    public Classe() {
        personagens = new Personagem[3];
        
    }
    
    public int getPoderP1(){
       return personagens[0].getPoder();
    }
    
    public int getPoderP2(){
       return personagens[1].getPoder();
    }
    
    public int getPoderP3(){
       return personagens[2].getPoder();
    }
    
    public Personagem[] getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Personagem[] personagens) {
        this.personagens = personagens;
    }
    

}
