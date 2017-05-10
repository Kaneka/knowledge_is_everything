package net.kaneka.knowledgeiseverything.registry;

import net.kaneka.knowledgeiseverything.tileentity.TileEntityBlueprintWorkbench;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities 
{
	public static void registerTileEntities()
	{
		
		GameRegistry.registerTileEntity(TileEntityBlueprintWorkbench.class, "tileentitycombiningtable");
	
	}
}
