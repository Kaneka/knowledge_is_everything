package net.kaneka.knowledgeiseverything.registry;

import net.kaneka.knowledgeiseverything.utils.CreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs 
{
	public static CreativeTabs TabBlocks, TabItems; 
	
	public static void registerTabs()
	{
		TabBlocks = new CreativeTab("tabblocks", new ItemStack(Blocks.BOOKSHELF)); 
		TabItems = new CreativeTab("tabitems", new ItemStack(Items.BOOK)); 
	}

}
