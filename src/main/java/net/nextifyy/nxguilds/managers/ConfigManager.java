package net.nextifyy.nxguilds.managers;

import net.nextifyy.nxguilds.GuildsPlugin;

public class ConfigManager {

    public int defaultPlayerLives;
    GuildsPlugin plugin;

    public ConfigManager(GuildsPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        this.defaultPlayerLives = this.plugin.getConfig().getInt("config.player.default-player-lives");
    }

    public void saveConfig() {
        this.plugin.getConfig().set("config.player.default-player-lives", this.defaultPlayerLives);
    }

}
