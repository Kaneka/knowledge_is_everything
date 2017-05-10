package net.kaneka.knowledgeiseverything.capabilities;

import net.kaneka.knowledgeiseverything.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler 
{
	public static final ResourceLocation KnowledgeEnder_CAP = new ResourceLocation(Main.MODID, "knowledgeender");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent.Entity event)
    {
        if (!(event.getEntity() instanceof EntityPlayer)) return;

        event.addCapability(KnowledgeEnder_CAP, new KnowledgesProvider());
    }
}
