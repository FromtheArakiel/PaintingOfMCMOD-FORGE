package cn.mcmod.painting.mixin;

import cn.mcmod.painting.PaintingOfMCMOD;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.PaintingRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.ForgeRegistries;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PaintingRenderer.class)
public class PaintingRendererMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void renderHighRes(Painting painting, float entityYaw, float partialTicks,
                               PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                               CallbackInfo ci) {
        PaintingVariant variant = painting.getVariant().value();
        ResourceLocation variantId = ForgeRegistries.PAINTING_VARIANTS.getKey(variant);

        if (variantId == null || !variantId.getNamespace().equals(PaintingOfMCMOD.MODID)) {
            return;
        }

        ci.cancel();

        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.scale(0.0625F, 0.0625F, 0.0625F);

        ResourceLocation texture = new ResourceLocation(variantId.getNamespace(),
                "textures/painting/" + variantId.getPath() + ".png");
        VertexConsumer consumer = buffer.getBuffer(RenderType.entitySolid(texture));

        int width = variant.getWidth();
        int height = variant.getHeight();
        renderPainting(poseStack, consumer, painting, width, height);

        poseStack.popPose();
    }

    private void renderPainting(PoseStack poseStack, VertexConsumer consumer,
                                Painting painting, int width, int height) {
        PoseStack.Pose pose = poseStack.last();
        Matrix4f matrix4f = pose.pose();
        Matrix3f matrix3f = pose.normal();

        float f = (float) (-width) / 2.0F;
        float f1 = (float) (-height) / 2.0F;
        float f2 = 0.5F;

        int i = width / 16;
        int j = height / 16;
        double d0 = 16.0D / (double) i;
        double d1 = 16.0D / (double) j;

        for (int k = 0; k < i; ++k) {
            for (int l = 0; l < j; ++l) {
                float f15 = f + (float) ((k + 1) * 16);
                float f16 = f + (float) (k * 16);
                float f17 = f1 + (float) ((l + 1) * 16);
                float f18 = f1 + (float) (l * 16);
                int i1 = painting.getBlockX();
                int j1 = Mth.floor(painting.getY() + (double) ((f17 + f18) / 2.0F / 16.0F));
                int k1 = painting.getBlockZ();
                Direction direction = painting.getDirection();
                if (direction == Direction.NORTH) {
                    i1 = Mth.floor(painting.getX() + (double) ((f15 + f16) / 2.0F / 16.0F));
                }
                if (direction == Direction.WEST) {
                    k1 = Mth.floor(painting.getZ() - (double) ((f15 + f16) / 2.0F / 16.0F));
                }
                if (direction == Direction.SOUTH) {
                    i1 = Mth.floor(painting.getX() - (double) ((f15 + f16) / 2.0F / 16.0F));
                }
                if (direction == Direction.EAST) {
                    k1 = Mth.floor(painting.getZ() + (double) ((f15 + f16) / 2.0F / 16.0F));
                }

                int l1 = LevelRenderer.getLightColor(painting.level(), new BlockPos(i1, j1, k1));

                float f19 = (float) (d0 * (double) (i - k)) / 16.0F;
                float f20 = (float) (d0 * (double) (i - (k + 1))) / 16.0F;
                float f21 = (float) (d1 * (double) (j - l)) / 16.0F;
                float f22 = (float) (d1 * (double) (j - (l + 1))) / 16.0F;

                // 正面
                vertex(matrix4f, matrix3f, consumer, f15, f18, f20, f21, -0.5F, 0, 0, -1, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f18, f19, f21, -0.5F, 0, 0, -1, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f17, f19, f22, -0.5F, 0, 0, -1, l1);
                vertex(matrix4f, matrix3f, consumer, f15, f17, f20, f22, -0.5F, 0, 0, -1, l1);

                // 背面
                vertex(matrix4f, matrix3f, consumer, f15, f17, 0.0F, 0.0F, 0.5F, 0, 0, 1, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f17, 1.0F, 0.0F, 0.5F, 0, 0, 1, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f18, 1.0F, 1.0F, 0.5F, 0, 0, 1, l1);
                vertex(matrix4f, matrix3f, consumer, f15, f18, 0.0F, 1.0F, 0.5F, 0, 0, 1, l1);

                // 上边
                vertex(matrix4f, matrix3f, consumer, f15, f17, 0.0F, 0.0F, -0.5F, 0, 1, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f17, 1.0F, 0.0F, -0.5F, 0, 1, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f17, 1.0F, 1.0F, 0.5F, 0, 1, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f15, f17, 0.0F, 1.0F, 0.5F, 0, 1, 0, l1);

                // 下边
                vertex(matrix4f, matrix3f, consumer, f15, f18, 0.0F, 0.0F, 0.5F, 0, -1, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f18, 1.0F, 0.0F, 0.5F, 0, -1, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f18, 1.0F, 1.0F, -0.5F, 0, -1, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f15, f18, 0.0F, 1.0F, -0.5F, 0, -1, 0, l1);

                // 左边
                vertex(matrix4f, matrix3f, consumer, f15, f17, 0.0F, 0.0F, 0.5F, -1, 0, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f15, f18, 0.0F, 1.0F, 0.5F, -1, 0, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f15, f18, 1.0F, 1.0F, -0.5F, -1, 0, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f15, f17, 1.0F, 0.0F, -0.5F, -1, 0, 0, l1);

                // 右边
                vertex(matrix4f, matrix3f, consumer, f16, f17, 0.0F, 0.0F, -0.5F, 1, 0, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f18, 0.0F, 1.0F, -0.5F, 1, 0, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f18, 1.0F, 1.0F, 0.5F, 1, 0, 0, l1);
                vertex(matrix4f, matrix3f, consumer, f16, f17, 1.0F, 0.0F, 0.5F, 1, 0, 0, l1);
            }
        }
    }

    private void vertex(Matrix4f matrix4f, Matrix3f matrix3f, VertexConsumer consumer,
                        float x, float y, float z, float u, float v,
                        int normalX, int normalY, int normalZ, int light) {
        consumer.vertex(matrix4f, x, y, z)
                .color(255, 255, 255, 255)
                .uv(u, v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(light)
                .normal(matrix3f, normalX, normalY, normalZ)
                .endVertex();
    }
}