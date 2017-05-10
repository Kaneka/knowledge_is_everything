package net.kaneka.knowledgeiseverything.registry;

import net.kaneka.knowledgeiseverything.block.BlockBlueprintWorkbench;
import net.kaneka.knowledgeiseverything.block.BlockCrafting5x5;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Modblocks 
{
	public static Block combiningTable;
	
	
	
	public static void registerBlocks()
	{
		registerBlock(combiningTable = new  BlockBlueprintWorkbench(), "combiningTable");
	}
	
	public static void registerBlock(Block block, String name)
	{
		GameRegistry.register(block.setRegistryName(name));
		GameRegistry.register(new ItemBlock(block).setRegistryName(name));
	}
	
	public static void registerBlockPlant(Block block, String name)
	{
		GameRegistry.register(block.setRegistryName(name));
	}
}
