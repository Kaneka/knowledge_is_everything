package net.kaneka.knowledgeiseverything.recipes;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class RecipesCombining
{
    private static final RecipesCombining COMBINING_BASE = new RecipesCombining();
    private final Map< NonNullList<ItemStack>,ItemStack> combiningList = Maps.<NonNullList<ItemStack>,ItemStack>newHashMap();

    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static RecipesCombining instance()
    {
        return COMBINING_BASE;
    }

    private RecipesCombining()
    {
        this.addRecipe(	ItemStack.EMPTY, new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT),
        				new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT),
        				new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT),
        				new ItemStack(Items.DIAMOND), new ItemStack(Items.GOLD_INGOT)
        			  );
    }



    public void addRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack input5, ItemStack input6, ItemStack input7, ItemStack input8, ItemStack input9,  ItemStack result, ItemStack blueprint)
    {
    	NonNullList<ItemStack> inputs = NonNullList.<ItemStack>withSize(10, ItemStack.EMPTY);
    	inputs.set(0, input1);
    	inputs.set(1, input2);
    	inputs.set(2, input3);
    	inputs.set(3, input4);
    	inputs.set(4, input5);
    	inputs.set(5, input6);
    	inputs.set(6, input7);
    	inputs.set(7, input8);
    	inputs.set(8, input9);
    	inputs.set(9, blueprint);
        this.combiningList.put(inputs, result);
    }

    public ItemStack getResults(NonNullList<ItemStack> stack)
    {
    	Iterator iterator = combiningList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStackEqual(stack, (NonNullList<ItemStack>)entry.getKey()));

        return (ItemStack)entry.getValue();
    }


    private boolean areItemStackEqual(NonNullList<ItemStack> stack, NonNullList<ItemStack> stack2) 
    {
    	boolean returnvalue = true; 
    	 for (int i = 0; i < 10; i++) 
         {
    		 if(!compareItemStacks(stack.get(i), stack2.get(i)))
    		 {
    			 returnvalue = false; 
    		 }
         }
    	
    	
		return returnvalue;
	}

	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<NonNullList<ItemStack>, ItemStack> getSmeltingList()
    {
        return this.combiningList;
    }
}