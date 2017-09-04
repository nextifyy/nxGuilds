package net.nextifyy.nxguilds.managers;

import net.nextifyy.nxguilds.GuildsPlugin;
import net.nextifyy.nxguilds.common.GuildPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuildPlayersManager {

    public List<GuildPlayer> players = new ArrayList<GuildPlayer>();
    GuildsPlugin plugin;

    public GuildPlayersManager(GuildsPlugin plugin) {
        this.plugin = plugin;
    }

    public GuildPlayer getGuildPlayerByName(String name) {
        for (GuildPlayer gp : players) {
            if (gp.getNickname().toLowerCase().equals(name.toLowerCase())) {
                return gp;
            }
        }
        return null;
    }

    public boolean isPlayerBanned(GuildPlayer player) {
        return player.getDeathBan() > System.currentTimeMillis();
    }

    public void revievePlayer(GuildPlayer player) {
        player.setDeathBan(System.currentTimeMillis());
        player.setLives(this.plugin.configManager.defaultPlayerLives);
    }

    public GuildPlayer getGuildPlayerByUUID(UUID uuid) {
        for (GuildPlayer gp : players) {
            if (gp.getUuid().equals(uuid)) {
                return gp;
            }
        }
        return null;
    }

    public GuildPlayer getGuildPlayerById(int id) {
        for (GuildPlayer gp : players) {
            if (gp.getId() == id) {
                return gp;
            }
        }
        return null;
    }

}
