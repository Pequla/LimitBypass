package com.pequla.limitbypass;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class LimitBypass extends JavaPlugin {

    public static final String BYPASS_PLAYER_LIMIT_PERMISSION = "limitbypass.bypass";

    @Override
    public void onEnable() {
        Logger logger = getLogger();
        logger.info("Starting the player login listener");
        getServer().getPluginManager().registerEvents(new PlayerLoginListener(logger), this);
        logger.info("Plugin is ready");
    }
}
