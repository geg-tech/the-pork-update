package geg.tech.Sound;

import geg.tech.porkin;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import org.slf4j.Logger;


public class porkinSounds implements ModInitializer {
    public static final String MOD_ID = porkin.MOD_ID;
    public static final Logger LOGGER = porkin.LOGGER;

    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, Identifier.fromNamespaceAndPath(MOD_ID, "burp"),
                SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(MOD_ID, "burp")));

        CustomSounds.initialize();
    }

    public static Identifier identifierOf(String path) {
        return Identifier.fromNamespaceAndPath(porkin.MOD_ID, path);
    }
}
