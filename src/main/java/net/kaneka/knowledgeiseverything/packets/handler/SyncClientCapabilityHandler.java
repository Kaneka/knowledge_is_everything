package net.kaneka.knowledgeiseverything.packets.handler;

import net.kaneka.knowledgeiseverything.capabilities.Knowledges;
import net.kaneka.knowledgeiseverything.capabilities.KnowledgesProvider;
import net.kaneka.knowledgeiseverything.packets.messages.SyncClientCapabilityMessage;
import net.kaneka.knowledgeiseverything.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class SyncClientCapabilityHandler implements IMessageHandler<SyncClientCapabilityMessage, IMessage>
{

	@Override
	public IMessage onMessage(SyncClientCapabilityMessage message, MessageContext ctx) 
	{
		if(ctx.side == Side.CLIENT)
		{
			IThreadListener mainThread = Minecraft.getMinecraft();
			 mainThread.addScheduledTask(() -> {
							Knowledges knowledges = (Knowledges) Minecraft.getMinecraft().player.getCapability(KnowledgesProvider.Knowledge_CAP, null); 
							knowledges.setKnowledge("LerningKnowledge", message.lerningKnowledge);
							knowledges.setKnowledge("EnderKnowledge", message.enderKnowledge);
							knowledges.setKnowledge("MagicKnowledge", message.magicKnowledge);
							knowledges.setKnowledge("NatureKnowledge", message.natureKnowledge);
							knowledges.setKnowledge("TechKnowledge", message.techKnowledge);
	                });
	     }
		
		return null;
	}

	

}