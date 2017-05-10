package net.kaneka.knowledgeiseverything.container.slots;

import net.kaneka.knowledgeiseverything.tileentity.TileEntityBlueprintWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotResult extends SlotItemHandler{
	
	private TileEntityBlueprintWorkbench te; 

	public SlotResult(IItemHandler itemHandler, TileEntityBlueprintWorkbench te, int index, int xPosition,int yPosition) 
	{
		super(itemHandler, index, xPosition, yPosition);
		this.te = te; 
	}
	
	@Override
	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) 
	{
		this.te.takeComponents();
		return super.onTake(thePlayer, stack);
	}

}
