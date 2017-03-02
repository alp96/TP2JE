package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        String pseudo;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bonjour à vous et bienvenue dans ce petit RPG\nTout d'abord faisons connaissance.");
        System.out.println("Comment vous appelez-vous ?");
        pseudo = scanner.next();
        Player player1 = new Player(pseudo);
        System.out.println("Oh bonjour " + pseudo + "! Comment s'appelle ton adversaire ?");
        pseudo = scanner.next();
        Player player2 = new Player(pseudo);
        System.out.println("Parfait ! C'est parti " + player1.getPseudo() + " et " + player2.getPseudo() + " !");

        int currentPlayerN;
        int choice;
        Player currentPlayer;
        Random random = new Random();
        currentPlayerN = random.nextInt(2 ) + 1;
        int hit;
        int heal;
        int critical;

        while(player1.getHealthpoint() > 0 && player2.getHealthpoint() > 0) {
            if(currentPlayerN == 2){
                currentPlayerN = 1;
                currentPlayer = player1;
            } else {
                currentPlayerN = 2;
                currentPlayer = player2;
            }

            System.out.println("C'est à toi " + currentPlayer.getPseudo() + " ! Que veux-tu faire ?");
            System.out.println("1) Frapper\n2) Se soigner");
            do {
                choice = scanner.nextInt();
            }
            while (choice != 1 && choice != 2);

            if(choice == 1) {
                hit = random.nextInt(20) + 10;
                critical = random.nextInt(100);
                if(critical > 70){
                    hit = hit * 2;
                    System.out.println("Coup critique !");
                }
                System.out.println(currentPlayer.getPseudo() + " frappe et inflige " + hit + " points de dégats !");
                if(currentPlayerN == 1){
                    player2.setHealthpoint(player2.getHealthpoint() - hit);
                    if(player2.getHealthpoint() <= 0){
                        System.out.println(player2.getPseudo() + " meurt ! Bravo " + player1.getPseudo() + " !");
                        break;
                    }
                    System.out.println("Il reste " + player2.getHealthpoint() + " points de vie à " + player2.getPseudo());
                } else {
                    player1.setHealthpoint(player1.getHealthpoint() - hit);
                    if(player1.getHealthpoint() <= 0) {
                        System.out.println(player1.getPseudo() + " meurt ! Bravo " + player2.getPseudo() + " !");
                        break;
                    }
                    System.out.println("Il reste " + player1.getHealthpoint() + " points de vie à " + player1.getPseudo());
                }

            } else {
                heal = random.nextInt(40) + 20;
                System.out.println(currentPlayer.getPseudo() + " se soigne de " + heal + " points de vie");
                if(currentPlayerN == 1){
                    player1.setHealthpoint(player1.getHealthpoint() + heal);
                } else {
                    player2.setHealthpoint(player2.getHealthpoint() + heal);
                }
            }
            TimeUnit.MILLISECONDS.sleep(1300);
            }
        }
    }
