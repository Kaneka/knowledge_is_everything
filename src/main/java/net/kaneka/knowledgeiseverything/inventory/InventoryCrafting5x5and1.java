package net.kaneka.knowledgeiseverything.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class InventoryCrafting5x5and1 extends InventoryCrafting
{

	private final NonNullList<ItemStack> stackList;
	private final int inventoryWidth;
	private final int inventoryHeight;
	private final Container eventHandler;
	
	
	public InventoryCrafting5x5and1(Container eventHandlerIn, int width, int height) 
	{
		super(eventHandlerIn, width, height);
		this.stackList = NonNullList.<ItemStack>withSize((width * height)+1, ItemStack.EMPTY);
		this.eventHandler = eventHandlerIn; 
		this.inventoryWidth = width;
	    this.inventoryHeight = height;
	}
	
	@Override
    public int getSizeInventory()
    {
        return this.stackList.size();
    }

	@Override
    public boolean isEmpty()
    {
        for (ItemStack itemstack : this.stackList)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

	@Override
    public ItemStack getStackInSlot(int index)
    {
        return index >= this.getSizeInventory() ? ItemStack.EMPTY : (ItemStack)this.stackList.get(index);
    }
    
	@Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.stackList, index);
    }

	@Override
    public ItemStack decrStackSize(int index, int count)
    {
        ItemStack itemstack = ItemStackHelper.getAndSplit(this.stackList, index, count);

        if (!itemstack.isEmpty())
        {
            this.eventHandler.onCraftMatrixChanged(this);
        }

        return itemstack;
    }

	@Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        this.stackList.set(index, stack);
        this.eventHandler.onCraftMatrixChanged(this);
    }
    
	@Override
    public void clear()
    {
        this.stackList.clear();
    }

	@Override
    public int getHeight()
    {
        return this.inventoryHeight;
    }

	@Override
    public int getWidth()
    {
        return this.inventoryWidth;
    }

}
