package net.kaneka.knowledgeiseverything;

import net.kaneka.knowledgeiseverything.proxy.CommonProxy;
import net.kaneka.knowledgeiseverything.registry.ModConfiguration;
import net.kaneka.knowledgeiseverything.utils.Utils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main 
{
	public static final String MODID = "knowledgeiseverything"; 
	public static final String NAME = "Knowledge Is Everything"; 
	public static final String VERSION = "1.0"; 

	@Instance
    public static Main instance;
    
    @SidedProxy(clientSide="net.kaneka.knowledgeiseverything.proxy.ClientProxy", serverSide="net.kaneka.knowledgeiseverything.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent e)
    {
    	Utils.getLogger().info("Pre Initialization");  
		this.proxy.preInit(e);
		
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	Utils.getLogger().info("Initialization");  
    	this.proxy.init(e);
    	
		
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent e)
    {
    	Utils.getLogger().info("Post Initialization");  
		this.proxy.postInit(e);
    }
}
