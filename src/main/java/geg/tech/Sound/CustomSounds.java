package geg.tech.Sound;

import geg.tech.porkin;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class CustomSounds {
    //putting this here bc fabric docs + ion wanna lose track of where i register sound events
    private CustomSounds(){
    }

    //register sounds here
    public static final SoundEvent BURP = registerSound("burp");
    public static final Holder.Reference<SoundEvent> BURP2 = registerForHolder("porkin.sounds.burp");


    private static SoundEvent registerSound(String id){
        Identifier identifier = Identifier.fromNamespaceAndPath(porkinSounds.MOD_ID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    //took this code from the source code to use in my bottle lol
    private static Holder.Reference<SoundEvent> registerForHolder(String string) {
        return registerForHolder(Identifier.withDefaultNamespace(string));
    }

    private static Holder.Reference<SoundEvent> registerForHolder(Identifier identifier) {
        return registerForHolder(identifier, identifier);
    }

    private static Holder.Reference<SoundEvent> registerForHolder(Identifier identifier, Identifier identifier2) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier2));
    }

    public static void initialize() {
        porkinSounds.LOGGER.info("registerin " + porkin.MOD_ID + " sounds");
    }
}
