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
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroups;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.minecraft.client.item.TooltipContext;

import java.util.List;

public class ModItems {

    public static final Item DADO = registerItem("dado", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item CRUZ = registerItem("cruz", new Item(new FabricItemSettings().maxCount(1)));

    public static final Item PUNICAO_DIVINA = registerItem("punicao_divina", new SwordItem(ModToolMaterial.PUNICAO_DIVINA, 33, -2.4f, new FabricItemSettings().maxCount(1)) {
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if (target != null) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 4));
            }
            return super.postHit(stack, target, attacker);
        }

        public boolean isEnchantable(ItemStack stack) {
            return true;
        }

        public Text getName(ItemStack stack) {
            return Text.literal("Punição Divina").formatted(Formatting.YELLOW);
        }

        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Puna os pecadores e traga a luz da redenção.").formatted(Formatting.GOLD));
            super.appendTooltip(stack, world, tooltip, context);
        }
    });

    public static final Item DEVASTADORA_DE_ALMAS = registerItem("devastadora_de_almas", new SwordItem(ModToolMaterial.DEVASTADORA_DE_ALMAS, 38, -2.4f, new FabricItemSettings().maxCount(1)) {
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if (target != null) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 0));
            }
            return super.postHit(stack, target, attacker);
        }

        public Text getName(ItemStack stack) {
            return Text.literal("Devastadora de Almas").formatted(Formatting.RED);
        }

        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Faça a Justiça e DESTRUA todos eles.").formatted(Formatting.DARK_RED));
            super.appendTooltip(stack, world, tooltip, context);
        }
    });

    public static final Item LYNE = registerItem("lyne", new SwordItem(ModToolMaterial.LYNE, 30, -2.4f, new FabricItemSettings()) {
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if (target != null) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 1));
            }
            return super.postHit(stack, target, attacker);
        }

        public Text getName(ItemStack stack) {
            return Text.literal("Lyne").formatted(Formatting.DARK_RED);
        }

        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("A Vingança é o melhor sentimento que alguém pode ter.").formatted(Formatting.RED));
            super.appendTooltip(stack, world, tooltip, context);
        }
    });

    public static final Item SALAMECOISAIAS = registerItem("salamecoisaias", new SwordItem(ModToolMaterial.SALAMECOISAIAS, 399, -3.9f, new FabricItemSettings()) {
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            return super.postHit(stack, target, attacker);
        }
    });

    public static final Item MORTE = registerItem("morte", new SwordItem(ModToolMaterial.MORTE, 45, -2.5f, new FabricItemSettings().maxCount(1)) {
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if (target != null) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1));
            }
            return super.postHit(stack, target, attacker);
        }

        public boolean isEnchantable(ItemStack stack) {
            return true;
        }

        public Text getName(ItemStack stack) {
            return Text.literal("Morte").formatted(Formatting.DARK_GRAY);
        }

        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Os Sete Sinos da Igreja ressoam como um lamento fúnebre").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("ecoando na escuridão para anunciar").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("que mais uma alma foi tomada pela Morte.").formatted(Formatting.GRAY));
            super.appendTooltip(stack, world, tooltip, context);
        }
    });

    public static final Item BONK = registerItem("bonk", new SwordItem(ModToolMaterial.BONK, 1, 1.0f, new FabricItemSettings()) {
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if (!attacker.getWorld().isClient()) {
                attacker.getWorld().playSound(null, attacker.getBlockPos(), PsmpItems.BONK_SOUND_EVENT, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
            return super.postHit(stack, target, attacker);
        }

        public Text getName(ItemStack stack) {
            return Text.literal("Bonk");
        }

        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Martelo pessoal do Aron. Não tocar.").formatted(Formatting.LIGHT_PURPLE));
            super.appendTooltip(stack, world, tooltip, context);
        }
    });

    private static void addItemsToFunctionalTab(FabricItemGroupEntries entries) {
        entries.add(CRUZ);
    }

    private static void addItemsToCombatTab(FabricItemGroupEntries entries) {
        entries.add(MORTE);
        entries.add(LYNE);
        entries.add(SALAMECOISAIAS);
        entries.add(BONK);
        entries.add(PUNICAO_DIVINA);
        entries.add(DEVASTADORA_DE_ALMAS);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PsmpItems.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PsmpItems.LOGGER.info("Registering Mod Items for " + PsmpItems.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemsToFunctionalTab);

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
                boolean hasDadoInInventory = false;
                boolean hasCruzInInventory = false;

                for (ItemStack stack : player.getInventory().main) {
                    if (stack.isOf(DADO)) {
                        hasDadoInInventory = true;
                    }
                    if (stack.isOf(CRUZ)) {
                        hasCruzInInventory = true;
                    }
                }

                if (hasDadoInInventory) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 100, 10, false, false, true));
                }

                if (hasCruzInInventory) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 250, 1, false, false, true));
                }
            }
        });
    }
}
