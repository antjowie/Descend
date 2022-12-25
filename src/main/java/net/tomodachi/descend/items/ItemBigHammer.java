package net.tomodachi.descend.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Rarity;

public class ItemBigHammer extends SwordItem implements IItem {
    public static final String ID = "big_hammer";
    public ItemBigHammer() {
        super(ToolMaterials.HAMMER, 10000, 1.F, new FabricItemSettings().rarity(Rarity.EPIC));
        FuelRegistry.INSTANCE.add(this, 300);
    }
    @Override
    public String GetID() {
        return ID;
    }
}
