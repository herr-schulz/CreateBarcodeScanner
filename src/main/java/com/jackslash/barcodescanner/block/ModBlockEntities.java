package com.jackslash.barcodescanner.block;

import com.jackslash.barcodescanner.BarcodeScanner;
import com.jackslash.barcodescanner.block.entity.BarcodeScannerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE, BarcodeScanner.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BarcodeScannerBlockEntity>>
            BARCODESCANNER_BE = BLOCK_ENTITIES.register(
            "barcodescanner",
            () -> BlockEntityType.Builder.of(
                    BarcodeScannerBlockEntity::new,
                    ModBlocks.BARCODESCANNER_BLOCK.get()
            ).build(null)
    );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}