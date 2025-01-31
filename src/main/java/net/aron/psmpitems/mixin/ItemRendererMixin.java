package net.aron.psmpitems.mixin;

import net.aron.psmpitems.PsmpItems;
import net.aron.psmpitems.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useCustomModels(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.MORTE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PsmpItems.MOD_ID, "morte_3d", "inventory"));
        }
        if (stack.isOf(ModItems.LYNE) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PsmpItems.MOD_ID, "lyne_3d", "inventory"));
        }
        if (stack.isOf(ModItems.SALAMECOISAIAS) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PsmpItems.MOD_ID, "salamecoisaias_3d", "inventory"));
        }
        if (stack.isOf(ModItems.BONK) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PsmpItems.MOD_ID, "bonk_3d", "inventory"));
        }
        if (stack.isOf(ModItems.DADO) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PsmpItems.MOD_ID, "dado_3d", "inventory"));
        }
        if (stack.isOf(ModItems.PUNICAO_DIVINA) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PsmpItems.MOD_ID, "punicao_divina_3d", "inventory"));
        }
        if (stack.isOf(ModItems.DEVASTADORA_DE_ALMAS) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(PsmpItems.MOD_ID, "devastadora_de_almas_3d", "inventory"));
        }
        return value;
    }
}
