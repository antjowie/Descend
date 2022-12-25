package net.tomodachi.descend.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Rarity;

public class ItemDirtSword extends SwordItem implements IItem {
    public static final String ID = "dirt_sword";
    public ItemDirtSword() {
        super(ToolMaterials.DIRT, 10, 10.F, new FabricItemSettings().rarity(Rarity.EPIC));
        FuelRegistry.INSTANCE.add(this, 300);
    }
    @Override
    public String GetID() {
        return ID;
    }
}
