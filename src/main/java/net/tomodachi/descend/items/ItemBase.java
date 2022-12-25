package net.tomodachi.descend.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.tomodachi.descend.DescendMod.MOD_ID;

public abstract class ItemBase extends Item{
    public ItemBase(Settings settings) {
        super(settings);
    }

    public abstract String GetID();
}
