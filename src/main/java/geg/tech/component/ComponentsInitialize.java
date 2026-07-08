package geg.tech.component;

import net.fabricmc.api.ModInitializer;

//just the initializer for the mod components, nothing special here really
//same shtick as ModItemsInitialize or MobBlocksInitialize
public class ComponentsInitialize implements ModInitializer {
    @Override
    public void onInitialize() {
        ModComponents.initialize();
    }
}
