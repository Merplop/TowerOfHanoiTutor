package com.mirohaap.towerofhanoitutor;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TowerController {
    // Array of towers in the game
    public Tower towers[];
    // Matrix representing the discs on each tower
    // TODO: Replace this with Disc class once Saylor completes it
    public DummyDisc[][] discsOnTowers;
    // Array tracking the number of discs on each tower
    public int[] numDiscs;

    /**
     * Constructs a new TowerController object. Initializes towers and places discs on first tower.
     */

    public TowerController() {
        towers = new Tower[3];
        discsOnTowers = new DummyDisc[3][3];
        numDiscs = new int[3];

        for (int i=0;i<3;i++) {
            towers[i] = new Tower(100 + (200*i), 300);
        }
        discsOnTowers[0][0] = new DummyDisc(100, 300, Color.RED, 200);
        discsOnTowers[0][1] = new DummyDisc(100, 250, Color.GREEN, 150);

        // TODO: Add discs to towers once disc functionality and backend are completed
    }

    public void alignDiscToTower(int indexInDiscArray, int TowerNumber) {
        ;
    }

}
