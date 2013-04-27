package de.paleocrafter.pcraft.client.renderer.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.pcraft.client.model.ModelDinoEgg;
import de.paleocrafter.pcraft.lib.Textures;

/**
 * PaleoCraft
 * 
 * ItemDinoEggRenderer
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ItemDinoEggRenderer implements IItemRenderer {
    private ModelDinoEgg modelDinoEgg;

    public ItemDinoEggRenderer() {
        modelDinoEgg = new ModelDinoEgg();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
            ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch (type) {
            case ENTITY: {
                renderEgg(0.5F, 1.0F, 0.5F);
                break;
            }
            case EQUIPPED: {
                renderEgg(0.5F, 1.5F, 0.5F);
                break;
            }
            case INVENTORY: {
                renderEgg(0.0F, 1.0F, 0.0F);
                break;
            }
            default:
                break;
        }
    }

    private void renderEgg(float x, float y, float z) {

        FMLClientHandler.instance().getClient().renderEngine
                .bindTexture(Textures.MODEL_EGG);
        GL11.glPushMatrix(); // start
        GL11.glTranslatef(x, y, z); // size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(90, 0, 1, 0);
        modelDinoEgg.renderAll();
        GL11.glPopMatrix(); // end
    }
}
