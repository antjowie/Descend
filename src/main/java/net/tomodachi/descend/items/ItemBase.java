package net.tomodachi.descend.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.tomodachi.descend.DescendMod.MOD_ID;

public abstract class ItemBase {
    public abstract String GetID();
    public abstract Item GetItem();

    public boolean ShouldRegister() {
        return true;
    }

    public final void Register()
    {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, GetID()), GetItem());
    }
}
