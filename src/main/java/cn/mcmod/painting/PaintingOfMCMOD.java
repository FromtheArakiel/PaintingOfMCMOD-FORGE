package cn.mcmod.painting;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(PaintingOfMCMOD.MODID)
public class PaintingOfMCMOD {
    public static final String MODID = "paintingofmcmodforge";

    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MODID);

    public static final RegistryObject<PaintingVariant> BLACK_MODE_16 =
            PAINTING_VARIANTS.register("black_mode_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> BLACK_MODE_32 =
            PAINTING_VARIANTS.register("black_mode_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> BLACK_MODE_2_16 =
            PAINTING_VARIANTS.register("black_mode_2_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> BLACK_MODE_2_32 =
            PAINTING_VARIANTS.register("black_mode_2_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> CANDLE_16 =
            PAINTING_VARIANTS.register("candle_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> CANDLE_32 =
            PAINTING_VARIANTS.register("candle_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> COMMON_16 =
            PAINTING_VARIANTS.register("common_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> COMMON_32 =
            PAINTING_VARIANTS.register("common_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> CONFUSED_16 =
            PAINTING_VARIANTS.register("confused_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> CONFUSED_32 =
            PAINTING_VARIANTS.register("confused_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> DISGUST_16 =
            PAINTING_VARIANTS.register("disgust_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> DISGUST_32 =
            PAINTING_VARIANTS.register("disgust_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> DOUBT_16 =
            PAINTING_VARIANTS.register("doubt_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> DOUBT_32 =
            PAINTING_VARIANTS.register("doubt_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> GOOD_16 =
            PAINTING_VARIANTS.register("good_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> GOOD_32 =
            PAINTING_VARIANTS.register("good_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> LOVE_16 =
            PAINTING_VARIANTS.register("love_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> LOVE_32 =
            PAINTING_VARIANTS.register("love_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> MEOW_16 =
            PAINTING_VARIANTS.register("meow_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> MEOW_32 =
            PAINTING_VARIANTS.register("meow_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> PETPET_16 =
            PAINTING_VARIANTS.register("petpet_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> PETPET_32 =
            PAINTING_VARIANTS.register("petpet_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> QUESTION_16 =
            PAINTING_VARIANTS.register("question_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> QUESTION_32 =
            PAINTING_VARIANTS.register("question_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> SAD_16 =
            PAINTING_VARIANTS.register("sad_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> SAD_32 =
            PAINTING_VARIANTS.register("sad_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> SCARE_16 =
            PAINTING_VARIANTS.register("scare_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> SCARE_32 =
            PAINTING_VARIANTS.register("scare_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> SHRUG_16 =
            PAINTING_VARIANTS.register("shrug_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> SHRUG_32 =
            PAINTING_VARIANTS.register("shrug_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> SHY_16 =
            PAINTING_VARIANTS.register("shy_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> SHY_32 =
            PAINTING_VARIANTS.register("shy_32x", () -> new PaintingVariant(32, 32));
    public static final RegistryObject<PaintingVariant> TIRED_16 =
            PAINTING_VARIANTS.register("tired_16x", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> TIRED_32 =
            PAINTING_VARIANTS.register("tired_32x", () -> new PaintingVariant(32, 32));

    public PaintingOfMCMOD() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        PAINTING_VARIANTS.register(modEventBus);
    }
}