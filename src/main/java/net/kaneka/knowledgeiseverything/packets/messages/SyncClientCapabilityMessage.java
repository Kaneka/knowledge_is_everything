package net.kaneka.knowledgeiseverything.packets.messages;

import io.netty.buffer.ByteBuf;
import net.kaneka.knowledgeiseverything.capabilities.KnowledgesProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class SyncClientCapabilityMessage implements IMessage
{
	 public float lerningKnowledge, enderKnowledge, magicKnowledge, natureKnowledge, techKnowledge; 
	 
	  @Override 
	  public void fromBytes(ByteBuf buf) { 
		lerningKnowledge = buf.readFloat(); 
		enderKnowledge = buf.readFloat(); 
		magicKnowledge = buf.readFloat(); 
		natureKnowledge = buf.readFloat();
		techKnowledge = buf.readFloat();
	  } 
	 
	  @Override 
	  public void toBytes(ByteBuf buf) { 
	    buf.writeFloat(lerningKnowledge); 
	    buf.writeFloat(enderKnowledge); 
	    buf.writeFloat(magicKnowledge); 
	    buf.writeFloat(natureKnowledge); 
	    buf.writeFloat(techKnowledge);
	  } 
	
	  public static SyncClientCapabilityMessage messageFrom(EntityPlayer player) 
	  { 
		  SyncClientCapabilityMessage message = new SyncClientCapabilityMessage(); 
		  	message.lerningKnowledge = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getKnowledge("LerningKnowledge");
		  	message.enderKnowledge = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getKnowledge("EnderKnowledge");
		  	message.magicKnowledge = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getKnowledge("MagicKnowledge");
		  	message.natureKnowledge = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getKnowledge("NatureKnowledge"); 
		  	message.techKnowledge = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getKnowledge("TechKnowledge"); 
		  	return message; 
	  } 
}
