package net.tomodachi.descend.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.descend." + GetID()));
    }
}
