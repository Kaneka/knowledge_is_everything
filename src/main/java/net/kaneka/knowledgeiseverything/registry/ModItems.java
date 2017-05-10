package net.kaneka.knowledgeiseverything.registry;

import net.kaneka.knowledgeiseverything.item.ItemGuide;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems 
{
	public static Item guide; 
	
	public static void registerItems()
	{
		registerItem(guide = new ItemGuide(), "guide"); 
	}
	
	public static void registerItem(Item item, String name)
	{
		GameRegistry.register(item.setRegistryName(name));
	}


}
