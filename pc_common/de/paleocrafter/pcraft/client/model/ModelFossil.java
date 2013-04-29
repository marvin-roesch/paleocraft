package de.paleocrafter.pcraft.client.model;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.lib.Models;

/**
 * PaleoCraft
 *
 * ModelFossil
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ModelFossil {
    private IModelCustom modelFossil;

    public ModelFossil() {

        modelFossil = AdvancedModelLoader.loadModel(Models.FOSSIL);
    }

    public void render() {

        modelFossil.renderAll();
    }
}
