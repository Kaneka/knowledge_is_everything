package net.kaneka.knowledgeiseverything.packets;

import net.kaneka.knowledgeiseverything.Main;
import net.kaneka.knowledgeiseverything.packets.handler.SyncClientCapabilityHandler;
import net.kaneka.knowledgeiseverything.packets.messages.SyncClientCapabilityMessage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ModPackets {
	
	public static SimpleNetworkWrapper network;
	
	public static void register()
    {
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Main.MODID);
		int id = 0; 
		network.registerMessage(new SyncClientCapabilityHandler(), SyncClientCapabilityMessage.class, id++, Side.CLIENT);
    }

}
