package net.kaneka.knowledgeiseverything.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class KnowledgesProvider implements ICapabilitySerializable<NBTBase>
{

	 @CapabilityInject(IKnowledge.class)
	  public static final Capability<IKnowledge> Knowledge_CAP = null;
	 
	private IKnowledge instance = Knowledge_CAP.getDefaultInstance(); 
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		return capability == Knowledge_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		return capability == Knowledge_CAP ? Knowledge_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() 
	{
		return Knowledge_CAP.getStorage().writeNBT(Knowledge_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) 
	{
		Knowledge_CAP.getStorage().readNBT(Knowledge_CAP, this.instance, null, nbt);
	}

}
