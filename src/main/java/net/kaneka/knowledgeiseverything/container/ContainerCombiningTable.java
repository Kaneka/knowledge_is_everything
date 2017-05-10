package net.kaneka.knowledgeiseverything.container;

import net.kaneka.knowledgeiseverything.container.slots.SlotComponent;
import net.kaneka.knowledgeiseverything.container.slots.SlotResult;
import net.kaneka.knowledgeiseverything.tileentity.TileEntityBlueprintWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCombiningTable extends Container
{
	private TileEntityBlueprintWorkbench te; 

    public ContainerCombiningTable(InventoryPlayer playerInventory, TileEntityBlueprintWorkbench te)
    {

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
            	this.addSlotToContainer(new SlotComponent(te.getItemStackHandler(), te, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }
        
        this.addSlotToContainer(new SlotComponent(te.getItemStackHandler(), te, 9, 94, 17));
        this.addSlotToContainer(new SlotResult(te.getItemStackHandler(),te, 10, 124, 35));
        
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
        this.te = te; 
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
    {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) 
    {
        return true;
    }
    
    
    
}

