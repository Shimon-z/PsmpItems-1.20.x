package net.aron.psmpitems.Item;

import net.aron.psmpitems.PsmpItems;
import net.aron.psmpitems.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CRUZ_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PsmpItems.MOD_ID, "cruz"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.cruz"))
                    .icon(() -> new ItemStack(ModItems.CRUZ)).entries((displayContext, entries) -> {
                        entries.add(ModItems.CRUZ);

                        entries.add(ModItems.DEATH);

                        entries.add(ModItems.LYNE);

                        entries.add(ModItems.SALAMECOISAIAS);



                    }).build());


    public static void registerItemGroups() {
        PsmpItems.LOGGER.info("Registering Item Groups for " + PsmpItems.MOD_ID);
    }
}
