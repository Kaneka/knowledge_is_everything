package net.kaneka.knowledgeiseverything.block;

import net.kaneka.knowledgeiseverything.Main;
import net.kaneka.knowledgeiseverything.gui.GuiHandler;
import net.kaneka.knowledgeiseverything.registry.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCrafting5x5 extends Block{

	public BlockCrafting5x5() {
		super(Material.WOOD);
		this.setCreativeTab(ModCreativeTabs.TabBlocks);
		this.setUnlocalizedName("combiningtable");
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,IBlockState state, EntityPlayer playerIn, EnumHand hand,EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote)
		{
				playerIn.openGui(Main.instance, GuiHandler.GUI_ENUM.GUI_Crafting5x5.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing,
				hitX, hitY, hitZ);
	}
}
