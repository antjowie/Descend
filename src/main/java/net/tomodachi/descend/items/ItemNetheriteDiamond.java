package net.tomodachi.descend.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ItemNetheriteDiamond extends ItemBase{

    public static final String ID = "netherite_diamond";
    public static final Item ITEM = new Item(new FabricItemSettings());

    @Override
    public boolean ShouldRegister() {
        return false;
    }
    @Override
    public String GetID() {
        return ID;
    }

    @Override
    public Item GetItem() {
        return ITEM;
    }
}
