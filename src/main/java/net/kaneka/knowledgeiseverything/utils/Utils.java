package net.kaneka.knowledgeiseverything.utils;

import net.kaneka.knowledgeiseverything.Main;
import net.kaneka.knowledgeiseverything.capabilities.IKnowledge;
import net.kaneka.knowledgeiseverything.capabilities.KnowledgesProvider;
import net.kaneka.knowledgeiseverything.packets.ModPackets;
import net.kaneka.knowledgeiseverything.packets.messages.SyncClientCapabilityMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
	public static Logger logger; 
	
	public static Logger getLogger() 
	{
		if(logger == null)
		{
			logger = LogManager.getFormatterLogger(Main.MODID); 
		}
		return logger;
	}
	
	public static void increaseKnowledge(String cap, float increase, int min, int max, EntityPlayer player)
	{
		if(player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getLevel(cap) >= min)
		{
			player.getCapability(KnowledgesProvider.Knowledge_CAP, null).increaseKnowledge(cap, increase, max);
		}
		if(!player.world.isRemote)
		{
			ModPackets.network.sendTo(SyncClientCapabilityMessage.messageFrom(player), (EntityPlayerMP) player);
		}
	}

}
