package net.kaneka.knowledgeiseverything.registry;

import java.io.File;

import net.kaneka.knowledgeiseverything.Main;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModConfiguration 
{
	private static ModConfiguration configuration;
	
	public static void register(FMLPreInitializationEvent e)
	{
		configuration = new ModConfiguration(e.getSuggestedConfigurationFile());
	}
	public static Configuration cfg;
	public static int seeddroprate;
	
	
	
	public ModConfiguration(File suggestedConfigurationFile)
	{
		cfg = new Configuration(suggestedConfigurationFile, Main.VERSION);
		cfg.load();
		setup();
	}

	private void setup() {
		seeddroprate = cfg.get("Seeddroprate", "seeddroprate", 10).getInt();
		
		cfg.save();
	}
	

}
