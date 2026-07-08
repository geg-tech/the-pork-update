package geg.tech.Items;

import net.fabricmc.api.ModInitializer;

public class ModItemsInitialize implements ModInitializer {
    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}