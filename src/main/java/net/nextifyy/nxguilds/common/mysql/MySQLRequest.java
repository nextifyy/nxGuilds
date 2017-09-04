package net.nextifyy.nxguilds.common.mysql;

import net.nextifyy.nxguilds.common.GuildsObject;

public class MySQLRequest {

    private MySQLRequestType queryType;
    private GuildsObject object;
    private boolean important;

    public MySQLRequest(MySQLRequestType queryType, GuildsObject object, boolean important) {
        this.queryType = queryType;
        this.object = object;
        this.important = important;
    }

    public MySQLRequestType getQueryType() {
        return queryType;
    }

    public void setQueryType(MySQLRequestType queryType) {
        this.queryType = queryType;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public GuildsObject getObject() {
        return object;
    }

    public void setObject(GuildsObject object) {
        this.object = object;
    }
}
