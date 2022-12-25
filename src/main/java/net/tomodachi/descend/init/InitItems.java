package net.tomodachi.descend.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tomodachi.descend.items.ItemBase;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static net.tomodachi.descend.DescendMod.LOGGER;
import static net.tomodachi.descend.DescendMod.MOD_ID;
import static org.reflections.scanners.Scanners.SubTypes;

public class InitItems {
    public static void Register() {
        Reflections reflections = new Reflections("net.tomodachi.descend.items");
        Set<Class<?>> itemClasses = reflections.get(SubTypes.of(ItemBase.class).asClass());
        for (Class<?> itemClass : itemClasses) {
            try {
                Constructor<?> constructor = itemClass.getConstructor();
                ItemBase item = (ItemBase) constructor.newInstance();
                Registry.register(Registries.ITEM, new Identifier(MOD_ID, item.GetID()), item);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                LOGGER.warn("Failed to construct " + itemClass.getName() + " with exception type " + e);
                LOGGER.warn("We will likely crash due to unhandled items...");
            }
        }
    }
}
