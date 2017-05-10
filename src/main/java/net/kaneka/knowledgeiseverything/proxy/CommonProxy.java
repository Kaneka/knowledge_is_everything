package net.kaneka.knowledgeiseverything.proxy;

import net.kaneka.knowledgeiseverything.Main;
import net.kaneka.knowledgeiseverything.capabilities.CapabilityHandler;
import net.kaneka.knowledgeiseverything.capabilities.IKnowledge;
import net.kaneka.knowledgeiseverything.capabilities.Knowledges;
import net.kaneka.knowledgeiseverything.capabilities.KnowledgeStorage;
import net.kaneka.knowledgeiseverything.gui.GuiHandler;
import net.kaneka.knowledgeiseverything.packets.ModPackets;
import net.kaneka.knowledgeiseverything.registry.ModBlueprintRecipes;
import net.kaneka.knowledgeiseverything.registry.ModConfiguration;
import net.kaneka.knowledgeiseverything.registry.ModCreativeTabs;
import net.kaneka.knowledgeiseverything.registry.ModItems;
import net.kaneka.knowledgeiseverything.registry.ModRecipes;
import net.kaneka.knowledgeiseverything.registry.ModTileEntities;
import net.kaneka.knowledgeiseverything.registry.Modblocks;
import net.kaneka.knowledgeiseverything.utils.EventHandler;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.world.DimensionType;

public class CommonProxy {
	

    public void preInit(FMLPreInitializationEvent e) 
    {
    	ModConfiguration.register(e);
    	ModCreativeTabs.registerTabs(); 
    	ModItems.registerItems();
    	Modblocks.registerBlocks();
    	ModTileEntities.registerTileEntities();
    	ModRecipes.registerRecipe();
    	ModPackets.register();
    	ModBlueprintRecipes.register();
    	
    }

    public void init(FMLInitializationEvent e) 
    {
    	CapabilityManager.INSTANCE.register(IKnowledge.class, new KnowledgeStorage(), Knowledges.class);
    	NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler()); 
    	MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public void postInit(FMLPostInitializationEvent e) 
    {

    }
}
