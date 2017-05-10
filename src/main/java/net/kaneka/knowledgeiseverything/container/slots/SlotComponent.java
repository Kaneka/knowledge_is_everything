package net.kaneka.knowledgeiseverything.container.slots;

import net.kaneka.knowledgeiseverything.tileentity.TileEntityBlueprintWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotComponent extends SlotItemHandler
{
	private TileEntityBlueprintWorkbench te; 

	public SlotComponent(IItemHandler itemHandler, TileEntityBlueprintWorkbench te, int index, int xPosition,int yPosition) 
	{
		super(itemHandler, index, xPosition, yPosition);
		this.te = te; 
	}
	
	@Override
	public void onSlotChanged() 
	{
		te.forceUpdate();
		super.onSlotChanged();
	}

}
