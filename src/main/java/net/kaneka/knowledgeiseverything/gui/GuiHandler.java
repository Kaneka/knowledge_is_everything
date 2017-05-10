package net.kaneka.knowledgeiseverything.gui;


import net.kaneka.knowledgeiseverything.Main;
import net.kaneka.knowledgeiseverything.capabilities.KnowledgesProvider;
import net.kaneka.knowledgeiseverything.container.ContainerCombiningTable;
import net.kaneka.knowledgeiseverything.tileentity.TileEntityBlueprintWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

	 public enum GUI_ENUM 
	    {
	        GUI_Guide, GUI_Crafting5x5, GUI_CombiningTable
	    }
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		if (tileEntity != null)
        {
            if (ID == GUI_ENUM.GUI_CombiningTable.ordinal())
            {
                return new ContainerCombiningTable(player.inventory, (TileEntityBlueprintWorkbench) world.getTileEntity(new BlockPos(x,y,z)));
            }
        }
		
		if (ID == GUI_ENUM.GUI_Guide.ordinal())
        {
            return null;
        }
		
		return null;
		
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

		if (tileEntity != null)
        {
            if (ID == GUI_ENUM.GUI_CombiningTable.ordinal())
            {
            	return new GuiCombiningTable(player.inventory, (TileEntityBlueprintWorkbench)tileEntity);
            }
        }
		
        if (ID == GUI_ENUM.GUI_Guide.ordinal())
        {
        	return new GuiGuide(player);
        }
        
        return null;
    }

}
