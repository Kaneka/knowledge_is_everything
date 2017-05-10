package net.kaneka.knowledgeiseverything.item;

import net.kaneka.knowledgeiseverything.Main;
import net.kaneka.knowledgeiseverything.gui.GuiHandler;
import net.kaneka.knowledgeiseverything.packets.ModPackets;
import net.kaneka.knowledgeiseverything.packets.messages.SyncClientCapabilityMessage;
import net.kaneka.knowledgeiseverything.registry.ModCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGuide extends Item
{
	public ItemGuide()
	{
		super();
		this.setUnlocalizedName("guide");
		this.setCreativeTab(ModCreativeTabs.TabItems); 
	}

	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{

		if(worldIn.isRemote)
		{

			playerIn.openGui(Main.instance, GuiHandler.GUI_ENUM.GUI_Guide.ordinal(), worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
