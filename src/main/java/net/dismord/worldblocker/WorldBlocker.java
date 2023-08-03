package net.dismord.worldblocker;

import net.dismord.worldblocker.config.ModConfigs;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorldBlocker implements ModInitializer {
	public static final String MOD_ID = "WorldBlocker";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();

		LOGGER.info( "WorldBlocker initialized.");
	}


}
