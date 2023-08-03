package net.dismord.worldblocker.config;

import com.mojang.datafixers.util.Pair;
import net.dismord.worldblocker.WorldBlocker;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static boolean NETHER;
    public static boolean END;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(WorldBlocker.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("Nether", false));
        configs.addKeyValuePair(new Pair<>("End", false));
    }

    private static void assignConfigs() {
        NETHER = CONFIG.getOrDefault("Nether", false);
        END = CONFIG.getOrDefault("End", false);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
