package com.company;

/**
 * Created by Anne-Louis on 02/03/2017.
 */
public class Player {
    private String pseudo;
    private int healthpoint = 100;

    public Player(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getHealthpoint() {
        return healthpoint;
    }

    public void setHealthpoint(int healthpoint) {
        this.healthpoint = healthpoint;
    }

    public void hit() {
        //To do
    }

    public void heal() {
        //to do
    }
}
