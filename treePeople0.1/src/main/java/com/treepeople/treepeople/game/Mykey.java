package com.treepeople.treepeople.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class Mykey extends KeyAdapter {
    Play play;
    int playerNum;
    boolean up, left, right;
    Timer timer;

    Mykey(Play p, int n) {
        this.play = p;
        this.playerNum = n;
        initializeTimer();
    }

    private void initializeTimer() {
        timer = new Timer(10, new ActionListener() { // 10毫秒触发一次
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (playerNum == 1) {
                    play.people1.move(play.people1.up, play.people1.left, play.people1.right);
                } else if (playerNum == 2) {
                    play.people2.move(play.people2.up, play.people2.left, play.people2.right);
                }
            }
        });
        timer.start();
    }

    public void keyPressed(KeyEvent e) {
        switch (playerNum) {
            case 1: // Player 1
                handlePlayer1Keys(e);
                break;
            case 2: // Player 2
                handlePlayer2Keys(e);
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (playerNum) {
            case 1: // Player 1
                handlePlayer1KeysReleased(e);
                break;
            case 2: // Player 2
                handlePlayer2KeysReleased(e);
                break;
        }
    }

    private void handlePlayer1Keys(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                play.people1.up = true;
                break;
            case KeyEvent.VK_LEFT:
                play.people1.left = true;
                break;
            case KeyEvent.VK_RIGHT:
                play.people1.right = true;
                break;
        }
    }

    private void handlePlayer1KeysReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                play.people1.up = false;
                break;
            case KeyEvent.VK_LEFT:
                play.people1.left = false;
                break;
            case KeyEvent.VK_RIGHT:
                play.people1.right = false;
                break;
        }
    }

    private void handlePlayer2Keys(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // 'W' key for up
                play.people2.up = true;
                break;
            case KeyEvent.VK_A: // 'A' key for left
                play.people2.left = true;
                break;
            case KeyEvent.VK_D: // 'D' key for right
                play.people2.right = true;
                break;
        }
    }

    private void handlePlayer2KeysReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                play.people2.up = false;
                break;
            case KeyEvent.VK_A:
                play.people2.left = false;
                break;
            case KeyEvent.VK_D:
                play.people2.right = false;
                break;
        }
    }
}
