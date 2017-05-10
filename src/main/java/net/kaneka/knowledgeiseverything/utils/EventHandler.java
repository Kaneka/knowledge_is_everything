package net.kaneka.knowledgeiseverything.utils;

import net.kaneka.knowledgeiseverything.capabilities.IKnowledge;
import net.kaneka.knowledgeiseverything.capabilities.KnowledgesProvider;
import net.kaneka.knowledgeiseverything.packets.ModPackets;
import net.kaneka.knowledgeiseverything.packets.messages.SyncClientCapabilityMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventHandler {
	
	 	@SubscribeEvent
	    public void onPlayerClone(PlayerEvent.Clone event)
	    {
	        EntityPlayer player = event.getEntityPlayer();
	        IKnowledge knowledges = player.getCapability(KnowledgesProvider.Knowledge_CAP, null);
	        IKnowledge oldKnowledges = event.getOriginal().getCapability(KnowledgesProvider.Knowledge_CAP, null);

	        knowledges.setKnowledge("EnderKnowledge", oldKnowledges.getKnowledge("EnderKnowledge"));
	        knowledges.setKnowledge("MagicKnowledge", oldKnowledges.getKnowledge("MagicKnowledge"));
	        knowledges.setKnowledge("NatureKnowledge", oldKnowledges.getKnowledge("NatureKnowledge"));
	        knowledges.setKnowledge("MagicbyteKnowledge", oldKnowledges.getKnowledge("MagicbyteKnowledge"));
	    }
	 	
	 	@SubscribeEvent
	 	public void onEnderPearlTeleport(EnderTeleportEvent event)
	 	{
	 		Entity entity = event.getEntity(); 
	 		if(entity.world.isRemote || !(entity instanceof EntityPlayerMP))
	 		{
	 			return; 
	 		}
	 		
	 		 EntityPlayer player = (EntityPlayer) entity;
	         
	 		 Utils.increaseKnowledge("EnderKnowledge", 0.5F, 0, 2, player);
	         IKnowledge knowledges = player.getCapability(KnowledgesProvider.Knowledge_CAP, null);
	         String message = String.valueOf(knowledges.getKnowledge("EnderKnowledge"));
	         player.sendMessage(new TextComponentString(message));
	         message = String.valueOf(knowledges.getLevel("EnderKnowledge"));
	         player.sendMessage(new TextComponentString(message));
	 	}
	 	
	 	@SubscribeEvent
	 	public void onPlayerLoggedIn(PlayerLoggedInEvent event)
	 	{
	 		
	 		if(!event.player.world.isRemote)
			{
				ModPackets.network.sendTo(SyncClientCapabilityMessage.messageFrom(event.player), (EntityPlayerMP) event.player);
			}
	 	}

}
