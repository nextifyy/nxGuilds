package net.nextifyy.nxguilds.common;


import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Guild implements GuildsObject {

    private int id;
    private GuildPlayer leader;
    private GuildPlayer vLeader;
    private String name;
    private String tag;
    private String description;
    private Location centerLocation;
    private Location homeLocation;
    private int size;
    private int membersSize;
    private long createDate;
    private long expirationDate;
    private int health;
    private int money;
    private long lastExplosion;
    private String annoucement;
    private List<GuildPlayer> members = new ArrayList<GuildPlayer>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getCenterLocation() {
        return centerLocation;
    }

    public void setCenterLocation(Location centerLocation) {
        this.centerLocation = centerLocation;
    }

    public Location getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(Location homeLocation) {
        this.homeLocation = homeLocation;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMembersSize() {
        return membersSize;
    }

    public void setMembersSize(int membersSize) {
        this.membersSize = membersSize;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public long getLastExplosion() {
        return lastExplosion;
    }

    public void setLastExplosion(long lastExplosion) {
        this.lastExplosion = lastExplosion;
    }

    public String getAnnoucement() {
        return annoucement;
    }

    public void setAnnoucement(String annoucement) {
        this.annoucement = annoucement;
    }

    public List<GuildPlayer> getMembers() {
        return members;
    }

    public void setMembers(List<GuildPlayer> members) {
        this.members = members;
    }

    public void updateMe() {

    }

    public void createMe() {

    }

    public void deleteMe() {

    }

    public GuildPlayer getLeader() {
        return leader;
    }

    public void setLeader(GuildPlayer leader) {
        this.leader = leader;
    }

    public GuildPlayer getvLeader() {
        return vLeader;
    }

    public void setvLeader(GuildPlayer vLeader) {
        this.vLeader = vLeader;
    }
}
