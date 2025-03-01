package net.aron.psmpitems.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {

    DEVASTADORA_DE_ALMAS(1, 5000, 1f, 1.0f, 30,
            () -> Ingredient.empty()),

    PUNICAO_DIVINA(1, 5000, 1f, 1.0f, 30,
            () -> Ingredient.empty()),

    BONK(1, 5000, 1f, 1.0f, 30,
            () -> Ingredient.empty()),

    MORTE(4, 2500, 1f, 4.0f, 26,
            () -> Ingredient.empty()),

    LYNE(4, 2500, 1f, 4.0f, 26,
            () -> Ingredient.empty()),

    SALAMECOISAIAS(20, 10000, 20.0f, 100.0f, 30,
            () -> Ingredient.empty());

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
