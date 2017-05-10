package net.kaneka.knowledgeiseverything.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs{

	private ItemStack stack= new ItemStack(Blocks.COBBLESTONE); 
	
	public CreativeTab(String label, ItemStack stack) 
	{
		super(label);
		this.stack = stack; 
	}

	@Override
	public ItemStack getTabIconItem() {
		return this.stack;
	}

}
