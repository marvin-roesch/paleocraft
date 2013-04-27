package de.paleocrafter.pcraft.tileentity;

import java.util.Random;

public class TileFossil extends TilePC {
    private boolean initialized;

    public TileFossil() {
        super();
    }

    public void init() {
        this.setOrientation(new Random().nextInt(5));
        initialized = true;
    }

    public boolean isInitialized() {
        return initialized;
    }
}
