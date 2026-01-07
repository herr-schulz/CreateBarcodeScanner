package com.jackslash.barcodescanner.block.entity;

import com.jackslash.barcodescanner.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class BarcodeScannerBlockEntity extends BlockEntity {

    private final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    public BarcodeScannerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BARCODESCANNER_BE.get(), pos, state);
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    /* ========= NBT (Minecraft 1.21 korrekt) ========= */

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);

        CompoundTag invTag = inventory.serializeNBT(provider);
        tag.put("Inventory", invTag);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);

        if (tag.contains("Inventory")) {
            inventory.deserializeNBT(provider, tag.getCompound("Inventory"));
        }
    }
}
