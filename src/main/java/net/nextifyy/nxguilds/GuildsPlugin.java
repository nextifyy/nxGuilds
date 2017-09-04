package net.nextifyy.nxguilds;

import net.nextifyy.nxguilds.managers.ConfigManager;
import net.nextifyy.nxguilds.managers.GuildPlayersManager;
import net.nextifyy.nxguilds.managers.GuildsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GuildsPlugin extends JavaPlugin {

    public ConfigManager configManager;
    public GuildsManager guildsManager;
    public GuildPlayersManager guildPlayersManager;


    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        this.guildsManager = new GuildsManager(this);
        this.guildPlayersManager = new GuildPlayersManager(this);
    }

    @Override
    public void onDisable() {
        this.configManager.saveConfig();
        this.configManager = null;
        this.guildsManager = null;
        this.guildPlayersManager = null;
    }


}
