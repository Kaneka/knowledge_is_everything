package net.kaneka.knowledgeiseverything.gui;

import net.kaneka.knowledgeiseverything.container.ContainerCombiningTable;
import net.kaneka.knowledgeiseverything.tileentity.TileEntityBlueprintWorkbench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCombiningTable extends GuiContainer
{
    private static final ResourceLocation combiningTableGuiTextures = new ResourceLocation("knowledgeiseverything:textures/gui/combining_table.png");
    private final InventoryPlayer inventoryPlayer;
    private final TileEntityBlueprintWorkbench tileCombiningTable;

	
	public GuiCombiningTable(InventoryPlayer parInventoryPlayer, TileEntityBlueprintWorkbench te) {
		super(new ContainerCombiningTable(parInventoryPlayer, te));
		   inventoryPlayer = parInventoryPlayer;
	        tileCombiningTable = te;
	}

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
      
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(combiningTableGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
       
    }
}