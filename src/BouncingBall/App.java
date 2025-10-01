package BouncingBall;

import Doctrine.Game;

public class App {
    public static void main(String[] args) {
        Game game = new BouncingBallGame();
        game.start();
    }
}
