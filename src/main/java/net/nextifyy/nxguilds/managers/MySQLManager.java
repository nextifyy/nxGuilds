package net.nextifyy.nxguilds.managers;

import net.nextifyy.nxguilds.GuildsPlugin;
import net.nextifyy.nxguilds.common.Guild;
import net.nextifyy.nxguilds.common.GuildPlayer;
import net.nextifyy.nxguilds.common.GuildsObject;
import net.nextifyy.nxguilds.common.mysql.MySQLRequest;
import net.nextifyy.nxguilds.common.mysql.MySQLRequestType;
import org.bukkit.Location;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLManager {

    List<MySQLRequest> toSend = new ArrayList<MySQLRequest>();
    GuildsPlugin plugin;
    private Connection connection;
    private Statement statement;
    private String host;
    private String user;
    private String password;
    private String database;

    public MySQLManager(GuildsPlugin plugin, String host, String user, String password, String database) {
        this.plugin = plugin;
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?" + "user=" + user + "&password=" + password + "");
            this.statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void sendRequest(MySQLRequest request) throws SQLException {
        if (!(request.getQueryType() == MySQLRequestType.DELETE)) {
            String table = (request.getObject() instanceof Guild) ? "players" : "guilds";
            getStatement().executeUpdate(generateRequestFromMap(generateColumnsAndValues(request.getObject()), request.getQueryType(), this.plugin.configManager.mysqlTablePrefix + table));
        } else {
            if (request.getObject() instanceof Guild) {
                getStatement().executeUpdate("DELETE * FROM `" + this.plugin.configManager.mysqlTablePrefix + "guilds` WHERE id='" + ((Guild) request.getObject()).getId() + "'");
            } else if (request.getObject() instanceof GuildPlayer) {
                getStatement().executeUpdate("DELETE * FROM `" + this.plugin.configManager.mysqlTablePrefix + "players` WHERE id='" + ((GuildPlayer) request.getObject()).getId() + "'");
            }
        }
    }

    public Map<String, Object> generateColumnsAndValues(GuildsObject object) {
        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, Object> fieldsNValues = new HashMap<String, Object>();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
                try {
                    fieldsNValues.put(field.getName(), field.get(object));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return fieldsNValues;
    }

    public String generateRequestFromMap(Map<String, Object> map, MySQLRequestType type, String table) {
        StringBuilder sb = new StringBuilder();
        if (type == MySQLRequestType.INSERT) {
            map.remove("id");
            sb.append("INSERT INTO ");
            sb.append(table);
            sb.append("(");
            sb.append(map.keySet());
            sb.append(")");
            sb.append(" VALUES (");
            for (Object o : map.values()) {
                if (o instanceof GuildPlayer) {
                    sb.append("'" + ((GuildPlayer) o).getId() + "', ");
                } else if (o instanceof List) {
                    StringBuilder sb1 = new StringBuilder();
                    for (Object ol : (List) o) {
                        if (ol instanceof GuildPlayer) {
                            sb1.append(((GuildPlayer) ol).getId() + ", ");
                        } else if (ol instanceof Guild) {
                            sb1.append(((Guild) ol).getId() + ", ");
                        } else {
                            sb1.append(ol + ", ");
                        }
                    }
                    sb1.setLength(sb1.length() - 2);
                    sb.append("'" + sb1.toString() + "', ");
                } else if (o instanceof Location) {
                    sb.append("'" + ((Location) o).getBlockX() + ";" + ((Location) o).getBlockY() + ";" + ((Location) o).getBlockZ() + "', ");
                } else {
                    sb.append("'" + o + "', ");
                }
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
            return sb.toString().replaceAll("\\[", "").replaceAll("\\]", "");
        } else if (type == MySQLRequestType.UPDATE) {
            sb.append("UPDATE " + table + " SET ");
            for (String mKey : map.keySet()) {
                sb.append(mKey + "=" + map.get(mKey) + ", ");
            }
            String whereGen = null;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getKey().toLowerCase().equals("id")) {
                    whereGen = entry.getKey() + "=" + entry.getValue();
                    break;
                }
            }
            sb.deleteCharAt(sb.length() - 2);
            sb.append("WHERE " + whereGen);
            return sb.toString();
        }
        return null;
    }

    public List<GuildsObject> loadGuildClassByFields(GuildsObject object) throws SQLException, IllegalAccessException {
        List<GuildsObject> objects = new ArrayList<GuildsObject>();
        Connection connection = getConnection();
        String table = (object instanceof Guild) ? "players" : "guilds";
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM `" + this.plugin.configManager.mysqlTablePrefix + table);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    while (rs.next()) {
                        field.setAccessible(true);
                        field.set(object.getClass(), rs.getObject(field.getName()));
                    }
                }
            }
            objects.add(object);
        }
        return objects;
    }

}
