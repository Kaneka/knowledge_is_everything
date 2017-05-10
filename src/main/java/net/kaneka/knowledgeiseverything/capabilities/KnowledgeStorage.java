package net.kaneka.knowledgeiseverything.capabilities;

import java.util.Map;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class KnowledgeStorage implements IStorage<IKnowledge>{

	@Override
	public NBTBase writeNBT(Capability<IKnowledge> capability, IKnowledge instance, EnumFacing side) 
	{
		
		Map<String, Float> map = instance.getKnowledgesMap(); 
		NBTTagCompound compound = new NBTTagCompound(); 
		compound.setFloat("LerningKnowledge", map.get("LerningKnowledge"));
		compound.setFloat("EnderKnowledge", map.get("EnderKnowledge"));
		compound.setFloat("MagicKnowledge", map.get("MagicKnowledge"));
		compound.setFloat("NatureKnowledge", map.get("NatureKnowledge"));
		compound.setFloat("TechKnowledge", map.get("TechKnowledge"));
		
		return compound;
	}

	@Override
	public void readNBT(Capability<IKnowledge> capability, IKnowledge instance,EnumFacing side, NBTBase nbt) 
	{
		instance.setKnowledge("LerningKnowledge",((NBTTagCompound)nbt).getFloat("LerningKnowledge")); 
		instance.setKnowledge("EnderKnowledge",((NBTTagCompound)nbt).getFloat("EnderKnowledge")); 
		instance.setKnowledge("MagicKnowledge",((NBTTagCompound)nbt).getFloat("MagicKnowledge")); 
		instance.setKnowledge("NatureKnowledge",((NBTTagCompound)nbt).getFloat("NatureKnowledge")); 
		instance.setKnowledge("TechKnowledge",((NBTTagCompound)nbt).getFloat("TechKnowledge")); 
	}

}
