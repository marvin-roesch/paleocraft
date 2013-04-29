package de.paleocrafter.pcraft.tileentity;

import java.util.Random;

/**
 * PaleoCraft
 *
 * TileFossil
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileFossil extends TilePC {
    public void init() {
        this.setOrientation(new Random().nextInt(5));
    }
}
