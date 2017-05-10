package net.kaneka.knowledgeiseverything.capabilities;

import java.util.HashMap;
import java.util.Map;

import net.kaneka.knowledgeiseverything.packets.ModPackets;
import net.kaneka.knowledgeiseverything.packets.messages.SyncClientCapabilityMessage;
import net.minecraft.entity.player.EntityPlayerMP;

public class Knowledges implements IKnowledge
{

	private Map<String, Float> knowledges = new HashMap(); 
	private float[] levelcondition = {10F, 50F, 100F, 200F, 400F, 800F, 1600F, 3200F, 6400F, 12800F} ; 

	public Knowledges() 
	{
		this.knowledges.put("LerningKnowledge", 0F); 
		this.knowledges.put("EnderKnowledge", 0F); 
		this.knowledges.put("MagicKnowledge", 0F); 
		this.knowledges.put("NatureKnowledge", 0F); 
		this.knowledges.put("TechKnowledge", 0F); 
		
	}
	
	@Override
	public void increaseKnowledge(String key, float knowledge, int maxLevel) 
	{
		if(this.knowledges.containsKey(key))
		{ 
			float floatvalue = this.knowledges.get(key); 
			float maxKnowledge = levelcondition[maxLevel-1];
			if(floatvalue <= (maxKnowledge - knowledge))
			{
				float newValue = floatvalue+knowledge; 
				this.knowledges.put(key, newValue); 
			}
		}

	}
	
	@Override
	public void decreaseKnowledge(String key, float knowledge, int minLevel) 
	{
		if(this.knowledges.containsKey(key))
		{
			float floatvalue = this.knowledges.get(key); 
			float minKnowledge = levelcondition[minLevel-1];
			if(floatvalue >= (minKnowledge - knowledge))
			{
				float newValue = floatvalue-knowledge; 
				this.knowledges.put(key, newValue); 
			}
		}
	}

	@Override
	public void setKnowledge(String key, float knowledge) 
	{	
		if(this.knowledges.containsKey(key))
		{
			this.knowledges.put(key, knowledge); 
		}
	}
	
	@Override
	public float getKnowledge(String key) 
	{
		if(this.knowledges.containsKey(key))
		{ 
			float floatvalue = this.knowledges.get(key); 
			return floatvalue; 
		}
		return 0; 
	}
	
	@Override
	public Map<String, Float> getKnowledgesMap() 
	{
		return this.knowledges; 
	}
	
	public int getLevel(String key)
	{
		if (this.knowledges.containsKey(key))
		{
			int level = 0;
			float knowledge = this.getKnowledge(key);
			while(knowledge >= this.levelcondition[level])
			{
				level++; 
			}
				
				return level;
		} 
		return 0; 
	}
	
	public float getLevelKnowledge(int level)
	{
		return this.levelcondition[level-1];
	}
}
