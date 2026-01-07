package com.jackslash.barcodescanner.item;

import com.jackslash.barcodescanner.BarcodeScanner;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BarcodeScanner.MODID);

 //public static final DeferredItem<Item> BARCODESCANNER = ITEMS.register("barcodescanner",
    //         () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}