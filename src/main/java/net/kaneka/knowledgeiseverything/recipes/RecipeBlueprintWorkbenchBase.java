package net.kaneka.knowledgeiseverything.recipes;

import net.kaneka.knowledgeiseverything.interfaces.IBlueprintRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class RecipeBlueprintWorkbenchBase implements IBlueprintRecipe
{

	@Override
	public boolean matches(NonNullList<ItemStack> craftinggrid, ItemStack blueprint) 
	{
		 return !getResult(craftinggrid, blueprint).isEmpty();
	}

	@Override
	public ItemStack getResult(NonNullList<ItemStack> craftinggrid,ItemStack blueprint) 
	{
		return null;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(NonNullList<ItemStack> craftinggrid, ItemStack blueprint) 
	{
		  NonNullList<ItemStack> craftinggridCopy = NonNullList.withSize(10, ItemStack.EMPTY);
	        for (int i = 0; i < craftinggrid.size(); i++) {
	            ItemStack slot = craftinggrid.get(i);
	            if (slot.getCount() > 1) {
	                ItemStack toAdd = slot.copy();
	                toAdd.shrink(1);
	                craftinggridCopy.set(i, toAdd);
	            } else {
	                craftinggridCopy.set(i, ItemStack.EMPTY);
	            }
	        }
	        if (blueprint.getCount() > 1) {
	            ItemStack inputCopy = blueprint.copy();
	            inputCopy.shrink(1);
	            craftinggridCopy.set(9, inputCopy);
	        }
	        return craftinggridCopy;
	}
}


