package net.kaneka.knowledgeiseverything.interfaces;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public interface IBlueprintRecipe 
{

    boolean matches(NonNullList<ItemStack> craftinggrid, ItemStack blueprint);

    @Nonnull
    ItemStack getResult(NonNullList<ItemStack> craftinggrid, ItemStack blueprint);

    @Nonnull
    NonNullList<ItemStack> getRemainingItems(NonNullList<ItemStack> craftinggrid, ItemStack blueprint);
}
