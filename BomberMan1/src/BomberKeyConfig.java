import java.awt.event.KeyEvent;
import java.io.*;

/**
 * File:         BomberKeyConfig.java
 * Copyright:    Copyright (c) 2001
 * @author Sammy Leong
 * @version 1.0
 */

/**
 * This class keeps track of the keyboard configration for each player.
 * This class can't be instanciated.
 */
public  class BomberKeyConfig {
    /** the keys */
    public  int[][] keys = new int[4][5];
    /** player numbers enumerations */
    public static final int P1 = 0;
    public static final int P2 = 1;
    public static final int P3 = 2;
    public static final int P4 = 3;
    /** key number enumerations */
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static final int BOMB = 4;



    /**
     * Creates the configuration file with default configurations.
     */
    public  BomberKeyConfig() {


        /** player 1 default key configurations */
        keys[P1][UP] = KeyEvent.VK_UP;
        keys[P1][DOWN] = KeyEvent.VK_DOWN;
        keys[P1][LEFT] = KeyEvent.VK_LEFT;
        keys[P1][RIGHT] = KeyEvent.VK_RIGHT;
        keys[P1][BOMB] = KeyEvent.VK_ENTER;

        /** player 2 default key configurations */
        keys[P2][UP] = KeyEvent.VK_W;
        keys[P2][DOWN] = KeyEvent.VK_S;
        keys[P2][LEFT] = KeyEvent.VK_A;
        keys[P2][RIGHT] = KeyEvent.VK_D;
        keys[P2][BOMB] = KeyEvent.VK_Q;

        /** player 3 default key configurations */
        keys[P3][UP] = KeyEvent.VK_Y;
        keys[P3][DOWN] = KeyEvent.VK_H;
        keys[P3][LEFT] = KeyEvent.VK_G;
        keys[P3][RIGHT] = KeyEvent.VK_J;
        keys[P3][BOMB] = KeyEvent.VK_T;

        /** player 4 default key configurations */
        keys[P4][UP] = KeyEvent.VK_O;
        keys[P4][DOWN] = KeyEvent.VK_L;
        keys[P4][LEFT] = KeyEvent.VK_K;
        keys[P4][RIGHT] = KeyEvent.VK_SEMICOLON;
        keys[P4][BOMB] = KeyEvent.VK_I;


    }
}