package net.nextifyy.nxguilds.common.mysql;

import net.nextifyy.nxguilds.common.GuildsObject;

public class MySQLQuery {

    private MySQLQueryType queryType;
    private GuildsObject object;
    private boolean important;

    public MySQLQuery(MySQLQueryType queryType, GuildsObject object, boolean important) {
        this.queryType = queryType;
        this.object = object;
        this.important = important;
    }

    public MySQLQueryType getQueryType() {
        return queryType;
    }

    public void setQueryType(MySQLQueryType queryType) {
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
