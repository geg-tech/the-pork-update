package geg.tech.component;

import com.mojang.serialization.Codec;
import geg.tech.porkin;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModComponents {
    protected static void initialize() {
        porkin.LOGGER.info("Registering {} components", porkin.MOD_ID);
        //loggin and notify the console
    }

    public static final DataComponentType<String> TOOLTIP_TEST = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(porkin.MOD_ID, "tooltip_test"),
            DataComponentType.<String>builder().persistent(Codec.STRING).build()
    );
}
