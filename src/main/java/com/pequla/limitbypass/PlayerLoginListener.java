package com.pequla.limitbypass;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.logging.Logger;

public class PlayerLoginListener implements Listener {

    private final Logger logger;

    public PlayerLoginListener(Logger logger) {
        this.logger = logger;
    }

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event) {
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            Player player = event.getPlayer();
            String playerName = player.getName();
            logger.warning("Server is full, but player " + playerName + " wants to join!");
            if (player.hasPermission(LimitBypass.BYPASS_PLAYER_LIMIT_PERMISSION)) {
                logger.info("Player " + playerName + " bypassed the server slot limit!");
                event.allow();
            }
        }
    }
}
