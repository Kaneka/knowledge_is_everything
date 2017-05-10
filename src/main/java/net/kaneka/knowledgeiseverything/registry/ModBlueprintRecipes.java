package net.kaneka.knowledgeiseverything.registry;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;

import net.kaneka.knowledgeiseverything.interfaces.IBlueprintRecipe;
import net.kaneka.knowledgeiseverything.recipes.blueprintworkbench.Test;

public class ModBlueprintRecipes 
{
    private final static List<IBlueprintRecipe> recipes = new ArrayList<>();

	
    public static void register()
    {
		   recipes.add(new Test());
    }

    public static List<IBlueprintRecipe> getBlueprintRecipes() 
    {
        return ImmutableList.copyOf(recipes);
    }

}
