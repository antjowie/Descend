package net.tomodachi.descend.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tomodachi.descend.items.IItem;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static net.tomodachi.descend.DescendMod.*;
import static org.reflections.scanners.Scanners.SubTypes;

public class InitItems {

    private static HashMap<String, Item> ITEMS = new HashMap<>();

    public static Item Get(String itemID){
        return ITEMS.get(itemID);
    }

    // Setup and register items to the game. Called before any other initialization happens
    public static void Setup() {
        Reflections reflections = new Reflections("net.tomodachi.descend.items");
        Set<Class<?>> itemClasses = reflections.get(SubTypes.of(IItem.class).asClass());
        for (Class<?> itemClass : itemClasses) {
            try {
                Constructor<?> constructor = itemClass.getConstructor();
                IItem item = (IItem) constructor.newInstance();
                Item itemInstance = Registry.register(Registries.ITEM, new Identifier(MOD_ID, item.GetID()), (Item) item);
                ITEMS.put(item.GetID(), itemInstance);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                LOGGER.warn("Failed to construct " + itemClass.getName() + " with exception type " + e);
                LOGGER.warn("We will likely crash due to unhandled items...");
            }
        }
    }

    // Called after mod is done setting up any configuration that we might need, such as item groups
    public static void Register() {
        for (Item item: ITEMS.values()) {
            ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
                content.add(item);
            });
        }
    }
}
