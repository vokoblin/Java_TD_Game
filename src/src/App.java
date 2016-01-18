/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Vovaxs
 */
public class App {

    public static void main(String[] args) {
        Thread game = new Thread(new Game());
        game.start();
    }
}
