package com.company.test;
import com.company.main.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player testPlayer;

    @Before
    public void setUp(){
        testPlayer = new Player("Alex");
    }

    @Test
    public void getName_returnsCorrectName(){
        assertEquals(testPlayer.getName(), "Alex");
    }

    @Test
    public void checkWin_returnsFalseAtGameStart(){
        assertEquals(testPlayer.getWin(), false);
    }

    @Test
    public void getMoves_getEmptyArrayAtGameStart(){
        assertEquals(testPlayer.getMoves().size(), 0);
    }

    @Test
    public void makeMove_successfullyMakesMove(){
        testPlayer.makeMove("rock");
        testPlayer.makeMove("paper");
        testPlayer.makeMove("scissor");
        assertEquals(testPlayer.getMoves().size(), 3);
        assertEquals(testPlayer.getMoves().get(1), "paper");
    }

    @Test
    public void makeMove_successfullyMakesMoveWithRandomCasing(){
        testPlayer.makeMove("ROCK");
        testPlayer.makeMove("paPeR");
        testPlayer.makeMove("Scissor");
        testPlayer.makeMove("roCk");
        testPlayer.makeMove("rock");
        assertEquals(testPlayer.getMoves().size(), 5);
        assertEquals(testPlayer.getMoves().get(0), "rock");
        assertEquals(testPlayer.getMoves().get(3), "rock");
    }

    @Test
    public void getLastMove_successfullyGetLastMove(){
        testPlayer.makeMove("ROCK");
        testPlayer.makeMove("paPeR");
        testPlayer.makeMove("Scissor");
        testPlayer.makeMove("roCk");
        testPlayer.makeMove("rock");
        assertEquals(testPlayer.getLastMove(), "rock");
    }

}

