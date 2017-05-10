package net.kaneka.knowledgeiseverything.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.kaneka.knowledgeiseverything.container.ContainerCombiningTable;
import net.kaneka.knowledgeiseverything.interfaces.IBlueprintRecipe;
import net.kaneka.knowledgeiseverything.recipes.RecipesCombining;
import net.kaneka.knowledgeiseverything.registry.ModBlueprintRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBlueprintWorkbench extends TileEntity 
{
	protected ItemStackHandler itemStackHandler; 
	private NonNullList<ItemStack> craftinggrid = NonNullList.withSize(9,ItemStack.EMPTY);
	
	public TileEntityBlueprintWorkbench()
	{
		this.itemStackHandler = new ItemStackHandler(11);
	}
	
	public ItemStackHandler getItemStackHandler()
	{
		return itemStackHandler;
	}
	
	 @Override
	    public void readFromNBT(@Nonnull NBTTagCompound compound) 
	{
        if (itemStackHandler != null)
        {
            itemStackHandler.deserializeNBT(compound.getCompoundTag("itemStackHandler"));
        }
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound compound) 
    {
        if (itemStackHandler != null)
        {
            compound.setTag("itemStackHandler", itemStackHandler.serializeNBT());
        }
        return super.writeToNBT(compound);
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) 
    {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemStackHandler != null || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemStackHandler != null)
        {
            return (T) itemStackHandler;
        }
        return super.getCapability(capability, facing);
    }
	
    @Nullable
    private IBlueprintRecipe getRecipe() {
        for(IBlueprintRecipe recipe : ModBlueprintRecipes.getBlueprintRecipes()) 
        {
            if(recipe.matches(craftinggrid, itemStackHandler.getStackInSlot(9))) {
                return recipe;
            }
        }
        return null;
    }
    

	public void forceUpdate() 
	{
		 craftinggrid.clear();
	        for (int i = 0; i < 9; i++)
	            craftinggrid.set(i, itemStackHandler.getStackInSlot(i));
	        IBlueprintRecipe recipe = getRecipe();
	    
	        if (recipe != null) {
	            itemStackHandler.setStackInSlot(10, recipe.getResult(craftinggrid, itemStackHandler.getStackInSlot(9)));
	        } else {
	        	itemStackHandler.setStackInSlot(10, ItemStack.EMPTY);
	        }
	}
	
	public void takeComponents()
	{
		IBlueprintRecipe recipe = getRecipe();
		NonNullList<ItemStack> remaining = recipe.getRemainingItems(craftinggrid, itemStackHandler.getStackInSlot(9));
        for (int i = 0; i < 9; i++)
            itemStackHandler.setStackInSlot(i, remaining.size() > i ? remaining.get(i) : ItemStack.EMPTY);
	}
}
