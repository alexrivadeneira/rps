package com.company.main;
import com.company.main.Player;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

import java.util.ArrayList;

public class Game {

    boolean singlePlayerGame;
    public ArrayList<String> possibleMoves;

    public boolean isSinglePlayerGame() {
        return singlePlayerGame;
    }

    public void newGame(){
        System.out.println("MAIN MENU");
        System.out.println("==========");

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players? (enter 1 or 2)");
        String numPlayers = scanner.nextLine();

        boolean validStart = false;

        while(validStart == false){
            if(numPlayers.equals("1")){
                singlePlayerGame = true;
                System.out.println("Starting single player game");
                validStart = true;
            } else if (numPlayers.equals("2")){
                singlePlayerGame = false;
                System.out.println("Starting two player game");
                validStart = true;
            } else {
                System.out.println("Enter either the digit 1 (single player) or 2 (two player)");
                numPlayers = scanner.nextLine();
            }
        }

        if(isSinglePlayerGame()){
            singlePlayerGame();
        } else {
            twoPlayerGame();
        }

    }

    public void singlePlayerGame(){

        boolean won = false;

        System.out.println("~ * ~ * Single player game!~ * ~ * ");

        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Player player1 = new Player(name);
        Player player2 = new Player("The computer");



        while(won == false){
            player1.makeMove(getMoveInput(player1));
            player2.makeMove(this.makeComputerMove());

            Player winner = determineWinner(player1, player2);

            if(winner != null) {
                System.out.println(winner.getName().toUpperCase() + " has won!");
                won = true;
            } else {
                System.out.println("It's a tie! Play again!");
            }
        }

    }


    public void twoPlayerGame(){

        boolean won = false;

        System.out.println("~ * ~ * Two player game!~ * ~ * ");

        System.out.println("Enter player one's name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Player player1 = new Player(name);

        System.out.println("Enter player two's name:");
        String player2name = scanner.nextLine();
        Player player2 = new Player(player2name);


        while(won == false){
            player1.makeMove(getMoveInput(player1));
            player2.makeMove(getMoveInput(player2));

            Player winner = determineWinner(player1, player2);

            if(winner != null) {
                System.out.println(winner.getName().toUpperCase() + " has won!");
                won = true;
            } else {
                System.out.println("it's a tie! Play again!");
            }
        }
    }

    public Player determineWinner(Player p1, Player p2){
        if(p1.getLastMove().equals("rock")){
            if (p2.getLastMove().equals("paper")) {
                return p2;
            } else if (p2.getLastMove().equals("scissor")) {
                return p1;
            }
        } else if (p1.getLastMove().equals("paper")){
            if(p2.getLastMove().equals("rock")){
                return p1;
            } else if (p2.getLastMove().equals("scissor")){
                return p2;
            }
        } else if (p1.getLastMove().equals("scissor")){
            if(p2.getLastMove().equals("paper")){
                return p1;
            } else if (p2.getLastMove().equals("rock")){
                return p2;
            }
        }

        return null;

    }



    public String makeComputerMove(){
        ArrayList<String> moves = new ArrayList<>();
        moves.add("rock");
        moves.add("paper");
        moves.add("scissor");
        Random rand = new Random();
        int randChoice = rand.nextInt(3);

        return moves.get(randChoice);

    }

    public String getMoveInput(Player player){
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String input = "";

        while(validInput == false){
            System.out.println(player.getName().toUpperCase() + ": Enter rock, paper or scissor");

            try{
                input = scanner.nextLine().toLowerCase();
                if(input.equals("rock") || input.equals("scissor") || input.equals("paper")){
                    validInput = true;
                }
            } catch (InputMismatchException e){
                System.out.printf("Invalid input!");
            }

        }

        return input;
    }

}
