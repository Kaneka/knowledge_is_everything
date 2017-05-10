package net.kaneka.knowledgeiseverything.capabilities;

import java.util.Map;

public interface IKnowledge 
{
	 public void increaseKnowledge(String key,float knowledge, int maxLevel);
	 
	 public void decreaseKnowledge(String key, float knowledge, int minLevel);
	 
	 public void setKnowledge(String key, float knowledge);

	 public float getKnowledge(String key);
	 
	 public int getLevel(String key);
	 
	 public Map getKnowledgesMap();
	 
	 public float getLevelKnowledge(int level);

}
