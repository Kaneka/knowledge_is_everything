package net.kaneka.knowledgeiseverything.recipes.blueprintworkbench;

import net.kaneka.knowledgeiseverything.recipes.RecipeBlueprintWorkbenchBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class Test extends RecipeBlueprintWorkbenchBase
{
	@Override
	public ItemStack getResult(NonNullList<ItemStack> craftinggrid,ItemStack blueprint) 
	{
		NonNullList<ItemStack> inputs = NonNullList.withSize(9,ItemStack.EMPTY); 
		inputs.set(0, new ItemStack(Items.APPLE));
		inputs.set(1, new ItemStack(Items.APPLE));
		inputs.set(2, new ItemStack(Items.APPLE));
		inputs.set(3, new ItemStack(Items.APPLE));
		inputs.set(4, new ItemStack(Items.APPLE));
		inputs.set(5, new ItemStack(Items.APPLE));
		inputs.set(6, new ItemStack(Items.APPLE));
		inputs.set(7, new ItemStack(Items.APPLE));
		inputs.set(8, new ItemStack(Items.APPLE));
		
		ItemStack neededBlueprint = new ItemStack(Items.ARROW);
		
		ItemStack output = new ItemStack(Blocks.DIAMOND_BLOCK);
		
		if(blueprint.isEmpty())
		{
			return ItemStack.EMPTY;
		}
		if(!ItemStack.areItemsEqual(neededBlueprint, blueprint))
		{
			return ItemStack.EMPTY;
		}
		for (int i = 0; i < 9; i++)
		{
			if(!ItemStack.areItemsEqual(inputs.get(i), craftinggrid.get(i)))
			{
				return ItemStack.EMPTY;
			}
		}
		
		return output;
	}


}
