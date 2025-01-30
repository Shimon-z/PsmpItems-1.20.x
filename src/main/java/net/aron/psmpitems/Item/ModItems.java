package net.aron.psmpitems.item;

import net.aron.psmpitems.PsmpItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroups;
import net.minecraft.entity.effect.StatusEffectInstance;

public class ModItems {

    public static final Item CRUZ = registerItem("cruz", new Item(new FabricItemSettings()));

    public static final Item LYNE = registerItem("lyne",
            new SwordItem(ModToolMaterial.LYNE, 30, 1.6f, new FabricItemSettings()) {

                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target != null) {
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 1));
                    }
                    return super.postHit(stack, target, attacker);
                }
            }
    );

    public static final Item SALAMECOISAIAS = registerItem("salamecoisaias",
            new SwordItem(ModToolMaterial.SALAMECOISAIAS, 400, 0.1f, new FabricItemSettings()) {

                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target != null) {
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 2));
                    }
                    return super.postHit(stack, target, attacker);
                }
            }
    );

    public static final Item DEATH = registerItem("death",
            new SwordItem(ModToolMaterial.DEATH, 15, 0.5f, new FabricItemSettings().maxCount(1)) {

                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target != null) {
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1));
                    }
                    return super.postHit(stack, target, attacker);
                }
            });

    private static void addItemsToIngredientsTab(FabricItemGroupEntries entries) {
        entries.add(CRUZ);
    }

    private static void addItemsToCombatTab(FabricItemGroupEntries entries) {
        entries.add(DEATH);
        entries.add(LYNE);
        entries.add(SALAMECOISAIAS);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PsmpItems.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PsmpItems.LOGGER.info("Registering Mod Items for " + PsmpItems.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTab);

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
                boolean hasCruzInInventory = false;

                for (ItemStack stack : player.getInventory().main) {
                    if (stack.isOf(CRUZ)) {
                        hasCruzInInventory = true;
                        break;
                    }
                }

                if (hasCruzInInventory) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 1, false, false, true)); // 15 segundos
                }
            }
        });
    }
}
