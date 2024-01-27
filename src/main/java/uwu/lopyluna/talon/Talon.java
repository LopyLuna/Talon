package uwu.lopyluna.talon;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import uwu.lopyluna.talon.baseRegistry.TalonRegistry;

@Mod(Talon.MOD_ID)
@SuppressWarnings({"all"})
public class Talon {
    public static final String NAME = "Talon";
    public static final String MOD_ID = "talon";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Talon()
    {
        IEventBus e = FMLJavaModLoadingContext.get().getModEventBus();
        e.addListener(this::commonSetup);

        TalonRegistry.ITEMS.register(e);
        TalonRegistry.BLOCKS.register(e);
        TalonRegistry.CREATIVE_MODE_TABS.register(e);

        MinecraftForge.EVENT_BUS.register(this);
        e.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
