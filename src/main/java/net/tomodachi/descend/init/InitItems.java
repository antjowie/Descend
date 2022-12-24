package net.tomodachi.descend.init;

import net.tomodachi.descend.items.ItemBase;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static net.tomodachi.descend.DescendMod.LOGGER;
import static org.reflections.scanners.Scanners.SubTypes;

public class InitItems {
    public static void Register() {
        Reflections reflections = new Reflections("net.tomodachi.descend.items");
        Set<Class<?>> itemClasses = reflections.get(SubTypes.of(ItemBase.class).asClass());
        for (Class<?> itemClass : itemClasses) {
            try {
                Constructor<?> ctor = itemClass.getConstructor();
                ItemBase item = (ItemBase) ctor.newInstance();
                if (item != null && item.ShouldRegister()) {
                    LOGGER.info("Registered item " + item.GetID());
                    item.Register();
                } else {
                    LOGGER.warn("Failed to register " + itemClass.getName() + " since it fails to cast to ItemBase");
                }

            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                LOGGER.warn("Failed to construct " + itemClass.getName() + " with exception type " + e.toString());
            }
        }
    }
}
