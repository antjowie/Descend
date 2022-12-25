package net.tomodachi.descend.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ItemNetheriteDiamond extends ItemBase{
    public static final String ID = "netherite_diamond";
    public ItemNetheriteDiamond() {
        super(new FabricItemSettings().maxCount(16));
        FuelRegistry.INSTANCE.add(this, 600);
    }

    @Override
    public String GetID() {
        return ID;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.ENTITY_COW_DEATH, 1.0F, 1.0F);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
