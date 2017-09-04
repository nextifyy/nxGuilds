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

    //   GuildPlayer player = new GuildPlayer();
//        player.setUuid(UUID.randomUUID());
//        player.setPoints(0);
//        player.setNickname("xD");
//        player.setKills(0);
//        player.setGuildId(0);
//        player.setDeaths(0);
//        player.setDeathBan(0);
//        player.setLives(0);
//        player.setId(0);
//        Guild g = new Guild();
//        g.setAnnoucement("oglo");
//        g.setCenterLocation(Bukkit.getWorld("world").getSpawnLocation());
//        g.setCreateDate(5444444);
//        g.setDescription("opis");
//        g.setExpirationDate(52222222);
//        g.setHealth(1000);
//        g.setHomeLocation(Bukkit.getWorld("world").getSpawnLocation());
//        g.setId(1);
//        g.setLastExplosion(54444);
//        g.setLeader(player);
//        g.setMembers(Arrays.asList(player));
//        g.setvLeader(player);
//        g.setMembersSize(3);
//        System.out.println(generateRequestFromMap(generateColumnsAndValues(g), MySQLRequestType.INSERT, "guilds"));
//        System.out.println(generateRequestFromMap(generateColumnsAndValues(player), MySQLRequestType.INSERT, "players"));
}
