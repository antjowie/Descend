package net.tomodachi.descend;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.tomodachi.descend.init.InitItems;
import net.tomodachi.descend.items.ItemDirtDiamond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DescendMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "descend";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ItemGroup ITEM_GROUP = null;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Descend world!");

		InitItems.Setup();

		// Setup our custom item group
		ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "custom_group")).
				icon(() -> new ItemStack(InitItems.Get(ItemDirtDiamond.ID))).
				build();

		InitItems.Register();
	}


}
