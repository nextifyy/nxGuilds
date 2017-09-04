package net.nextifyy.nxguilds.managers;

import net.nextifyy.nxguilds.GuildsPlugin;
import net.nextifyy.nxguilds.common.Guild;
import net.nextifyy.nxguilds.common.GuildPlayer;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuildsManager {

    public List<Guild> guilds = new ArrayList<Guild>();
    GuildsPlugin plugin;

    public GuildsManager(GuildsPlugin plugin) {
        this.plugin = plugin;
    }

    public Guild getGuildByTag(String tag) {
        for (Guild g : guilds) {
            if (g.getTag().toLowerCase().equals(tag.toLowerCase())) {
                return g;
            }
        }
        return null;
    }

    public Guild getGuildByID(int id) {
        for (Guild g : guilds) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    public Guild getGuildByName(String name) {
        for (Guild g : guilds) {
            if (g.getName().toLowerCase().equals(name.toLowerCase())) {
                return g;
            }
        }
        return null;
    }

    public Guild getGuildByPlayerUUID(UUID uuid) {
        for (Guild g : guilds) {
            for (GuildPlayer gp : g.getMembers()) {
                if (gp.getUuid().equals(uuid)) {
                    return g;
                }
            }
        }
        return null;
    }

    public Guild getGildiaByLocation(Location loc) {
        for (Guild g : guilds) {
            if (loc.getWorld().getName().equals(g.getCenterLocation().getWorld().getName())) {
                int guildX = g.getCenterLocation().getBlockX();
                int guildZ = g.getCenterLocation().getBlockZ();
                int x = loc.getBlockX();
                int z = loc.getBlockZ();
                int maX = Math.max(x, guildX);
                int miX = Math.min(x, guildX);
                int maZ = Math.max(z, guildZ);
                int miZ = Math.min(z, guildZ);
                if ((maX - miX <= g.getSize()) && (maZ - miZ <= g.getSize())) {
                    return g;
                }
            }
        }
        return null;
    }


}
