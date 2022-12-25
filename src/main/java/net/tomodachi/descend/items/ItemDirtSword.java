package net.tomodachi.descend.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ItemDirtSword extends ItemBase{

    @Override
    public String GetID() {
        return "dirt_sword";
    }

    @Override
    public Item GetItem() {
        return new Item(new FabricItemSettings().maxCount(1));
    }
}
