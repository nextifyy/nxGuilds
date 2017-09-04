package net.nextifyy.nxguilds.common;

import java.util.UUID;

public class GuildPlayer implements GuildsObject {

    private int id;
    private UUID uuid;
    private String nickname;
    private int points;
    private int kills;
    private int deaths;
    private long deathBan;
    private int guildId;
    private int lives;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public long getDeathBan() {
        return deathBan;
    }

    public void setDeathBan(long deathBan) {
        this.deathBan = deathBan;
    }

    public int getGuildId() {
        return guildId;
    }

    public void setGuildId(int guildId) {
        this.guildId = guildId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void updateMe() {

    }

    public void createMe() {

    }

    public void deleteMe() {

    }
}
