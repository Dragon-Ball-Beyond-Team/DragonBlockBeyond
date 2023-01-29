package io.firetamer81.dragonblockbeyond.init.handlers;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class EventsHandler {

    @Mod.EventBusSubscriber(modid = DragonBlockBeyond.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModBusClientEvents {

        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            KeyBindHandler.init();

            //ItemBlockRenderTypes.setRenderLayer(NamekModule.SHORT_NAMEK_GRASS.get(), RenderType.cutoutMipped());

            //ItemBlockRenderTypes.setRenderLayer(NamekModule.NAMEK_FLUID_SOURCE.get(), RenderType.translucent());
            //ItemBlockRenderTypes.setRenderLayer(NamekModule.NAMEK_FLUID_FLOWING.get(), RenderType.translucent());
            //ItemBlockRenderTypes.setRenderLayer(NamekModule.NAMEK_FLUID_BLOCK.get(), RenderType.translucent());
        }
    }

    @Mod.EventBusSubscriber(modid = DragonBlockBeyond.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class ForgeBusClientEvents {

        /**
        @SubscribeEvent
        public static void namekFluidBonemealUse(BonemealEvent event) {
            LocalPlayer player = Minecraft.getInstance().player;
            Level worldIn = player.getCommandSenderWorld();
            HitResult lookingAt = Minecraft.getInstance().hitResult;
            Random rand = new Random();

            if (lookingAt != null && lookingAt.getType() == HitResult.Type.BLOCK) {
                double x = lookingAt.getLocation().x();
                double y = lookingAt.getLocation().y();
                double z = lookingAt.getLocation().z();

                BlockPos blockpos_above_1 = new BlockPos(x, y, z).above();

                //player.displayClientMessage(new TextComponent("Clicked on full block, fluid state above block is: " + fluidstate), true);

                Task:
                for (int i = 0; i < 128; ++i) {
                    BlockPos blockpos1 = blockpos_above_1;

                    for (int j = 0; j < i / 16; ++j) {
                        blockpos1 = blockpos1.offset(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);

                        if (worldIn.getBlockState(blockpos1).isCollisionShapeFullBlock(worldIn, blockpos1)) {
                            continue Task;
                        }
                    }

                    BlockPos blockpos1_above = blockpos1.above();
                    BlockState blockstate1 = worldIn.getBlockState(blockpos1);
                    BlockState blockstate2 = worldIn.getBlockState(blockpos1_above);

                    if (blockstate1.equals(NamekModule.NAMEK_FLUID_BLOCK) && blockstate2.equals(NamekModule.NAMEK_FLUID_BLOCK)) {
                        BlockState blockstate3;

                        if (rand.nextInt(4) == 0) {
                            blockstate3 = NamekModule.NAMEK_SEAGRASS.get().defaultBlockState();
                        } else {
                            blockstate3 = NamekModule.NAMEK_SEAGRASS.get().defaultBlockState();
                        }

                        worldIn.setBlockAndUpdate(blockpos1, blockstate3);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void greenFogInNamekWater(EntityViewRenderEvent.FogColors event) {
            LocalPlayer player = Minecraft.getInstance().player;
            double eyeHeight = player.getEyeY() - 1 / 9d;
            FluidState fluidstate = player.level.getFluidState(new BlockPos(player.getX(), eyeHeight, player.getZ()));

            if (fluidstate.getType() == NamekModule.NAMEK_FLUID_FLOWING.get()
                    || fluidstate.getType() == NamekModule.NAMEK_FLUID_SOURCE.get()) {
                event.setBlue(0.09F);
                event.setGreen(0.45F); // As it stands, what I have done is match the ratios shown in the fluid color
                // to the fog color. 255 for the fluid color being 1.0F for the Fog FireLibColor.
                event.setRed(0);
            }
        }

        @SubscribeEvent
        public static void cancelVanillaWaterOverlay(RenderBlockOverlayEvent event) {
            @SuppressWarnings("resource")
            LocalPlayer player = Minecraft.getInstance().player;
            double eyeHeight = player.getEyeY() - 1 / 9d;
            FluidState fluidstate = player.level.getFluidState(new BlockPos(player.getX(), eyeHeight, player.getZ()));

            if (fluidstate.getType() == NamekModule.NAMEK_FLUID_FLOWING.get()
                    || fluidstate.getType() == NamekModule.NAMEK_FLUID_SOURCE.get()) {
                if (event.isCancelable()) {
                    event.setCanceled(true);
                }

            }
        }
        **/

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            KeyBindHandler.KeyBindActions();
        }
    }
}
