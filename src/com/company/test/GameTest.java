package com.company.test;
import com.company.main.Game;
import com.company.main.Player;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void game_takesInputToStartSinglePlayerGame(){
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Game game = new Game();
        game.newGame();

        assertTrue(game.isSinglePlayerGame());
    }

//    @Test
//    public void getMoveInput_successfullyCoercesPreselectedMove() {
//        Game game = new Game();
//
//        String input = "paper";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        assertEquals(game.getMoveInput(), "paper");
//
//    }

    @Test
    public void makeComputerMove_successfullyReturnsRandomMove(){
        Game game = new Game();
        assertEquals(game.makeComputerMove(), "rock");
    }

    @Test
    public void determineWinner_successfullyDeterminesWinner(){
        Game game = new Game();
        Player p1 = new Player("Testplayer");
        Player p2 = new Player("Testplayer2");

        p1.makeMove("rock");
        p2.makeMove("scissor");

        assertEquals(game.determineWinner(p1, p2), p1);
    }


}
