package net.aron.psmpitems.item;

import net.aron.psmpitems.PsmpItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.ItemGroups;
import net.minecraft.entity.effect.StatusEffectInstance;

public class ModItems {

    // Cruz não vai para a categoria Combate
    public static final Item CRUZ = registerItem("cruz", new Item(new FabricItemSettings()));

    // Espada "Death" vai para a categoria Combate e PSMP Items
    public static final Item DEATH = registerItem("death",
            new SwordItem(ModToolMaterial.DEATH, 15, 0.5f, new FabricItemSettings().maxCount(1)) {

                // Sobrescrevendo o método onItemUse
                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    // Verifica se o alvo é uma entidade válida (não null)
                    if (target != null) {
                        // Aplica o efeito de Slowness II por 100 ticks (5 segundos)
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1));
                    }
                    return super.postHit(stack, target, attacker); // Chama o método da superclasse
                }
            });

    private static void addItemsToPsmpTab(FabricItemGroupEntries entries) {
        entries.add(CRUZ); // Adiciona a Cruz apenas na categoria PSMP Items
    }

    private static void addItemsToCombatTab(FabricItemGroupEntries entries) {
        entries.add(DEATH); // Adiciona a espada Death na categoria Combate
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PsmpItems.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PsmpItems.LOGGER.info("Registering Mod Items for " + PsmpItems.MOD_ID);

        // Adiciona itens aos respectivos grupos de itens
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemsToPsmpTab); // PSMP Items
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTab); // Combate
    }
}
