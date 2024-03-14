package com.mirohaap.towerofhanoitutor;

import java.util.Arrays;
import java.util.Stack;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * The Tutor class represents a tutor for the Tower of Hanoi game.
 * It generates and stores the best moves for solving the game.
 */
public class Tutor {

    private static Tutor instance;
    private Stack<Move> bestMoves = new Stack<Move>();

    private boolean isEnabled = false;

    private Voice voice;

    /**
     * Private constructor for the Tutor class.
     * Initializes the best moves by solving the Tower of Hanoi game with 9 disks.
     */
    private Tutor() {
        towerOfHanoi(9, 1, 3, 2);

        VoiceManager voiceManager = VoiceManager.getInstance();
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.setRate(110);
        voice.setPitch(100);
        voice.setVolume(0.8f);
    }

    /**
     * Returns the singleton instance of the Tutor class.
     *
     * @return the Tutor instance
     */
    public static Tutor getTutor() {
        if (instance == null) {
            instance = new Tutor();
        }
        return instance;
    }


    public boolean isEnabled() {
        return isEnabled;
    }

    /**
     * Toggles the enabled state of the tutor.
     */
    public void toggleEnabled() {
        isEnabled = !isEnabled;


        if(isEnabled){
            speak("I'm here to help.");
            return;
        }

        speak("Goodbye.");
    }

    /**
     * Checks if the given move is the best move according to the tutor.
     * Pops the move from stack if valid. Assumes move will be processed if valid.
     * @param move the move to check
     * @return true if the move is the best move, false otherwise
     */
    public boolean isBestMove(Move move) {
        if (!isEnabled) {
            return true;
        }
        if (move != bestMoves.peek()) {
            return false;
        }

        bestMoves.pop();


        return true;
    }

    public void speak(String message) {
        new Thread(() -> voice.speak(message)).start();
    }

    /**
     * Adds a best move to the tutor's list of best moves.
     *
     * @param n    the number of the disk being moved
     * @param from the source rod
     * @param to   the destination rod
     */
    public void addBestMove(int n, int from, int to) {
        Move move = new Move().setN(n).setFrom(from).setTo(to);
        bestMoves.push(move);
    }

    /**
     * Recursively solves the Tower of Hanoi game and adds the best moves to the tutor.
     *
     * @param n        the number of disks
     * @param from_rod the source rod
     * @param to_rod   the destination rod
     * @param aux_rod  the auxiliary rod
     */
    private void towerOfHanoi(int n, int from_rod, int to_rod, int aux_rod) {
        if (n == 1) {
            addBestMove(1, from_rod, to_rod);
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        addBestMove(n, from_rod, to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public Stack<Move> getBestMoves(){
        return bestMoves;
    }
}