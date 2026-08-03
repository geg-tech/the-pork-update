package geg.tech;

import net.fabricmc.api.ModInitializer;

import net.minecraft.IdentifierException;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class porkin implements ModInitializer {
	public static final String MOD_ID = "porkin";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//initialize items
			//make a custom sound event (for the bottle of fat item)
			//^ deprecated, moved to CustomSounds in the sound directory
		//Registry.register(BuiltInRegistries.SOUND_EVENT, Identifier.fromNamespaceAndPath(porkin.MOD_ID, "burp"),
		//	SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(porkin.MOD_ID, "burp")));

		LOGGER.info("Hello Fabric world!");
	}
}