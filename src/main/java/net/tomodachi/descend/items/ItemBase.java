package net.tomodachi.descend.items;

import net.minecraft.item.Item;

/**
 * The base class for all items. Items should never be manually constructed but instead
 * retrieved from their respective Init classes.
 */
public abstract class ItemBase extends Item{
    private static Boolean CONSTRUCTED = false;

    public ItemBase(Settings settings) {
        super(settings);
        // Items should only be constructed once via Init classes. Instead of recreating them,
        // access them via the Init classes.
        assert(!CONSTRUCTED);
        CONSTRUCTED = true;
    }

    public abstract String GetID();
}
