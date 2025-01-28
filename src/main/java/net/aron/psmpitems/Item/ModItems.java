package net.aron.psmpitems.Item;

import net.aron.psmpitems.PsmpItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CRUZ = registerItem( "cruz", new Item(new FabricItemSettings()));

    public static final Item DEATH = registerItem("death",
            new Item(new FabricItemSettings().maxCount(1)));

    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries) {
        entries.add (CRUZ);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PsmpItems.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PsmpItems.LOGGER.info("Registering Mod Items for " + PsmpItems.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTabItemGroup);
    }
}
