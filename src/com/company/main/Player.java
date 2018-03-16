package com.company.main;

import java.util.ArrayList;

public class Player {

    private boolean win;
    private ArrayList<String> moves;
    private String name;

    public Player(String playerName){
        win = false;
        moves = new ArrayList<>();
        name = playerName;
    }

    public String getName() {
        return name;
    }

    public void makeMove(String input){
        System.out.println(this.name.toUpperCase() + " made a move, " + input);
        moves.add(input.toLowerCase());
    }

    public String getLastMove(){
        return moves.get(moves.size() - 1);
    }


    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }

    public boolean getWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }




}
