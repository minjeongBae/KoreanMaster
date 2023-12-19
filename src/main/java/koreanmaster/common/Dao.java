package koreanmaster.common;

import java.sql.SQLException;

public class Dao {
    protected final ExecuteSql executeSql;

    public Dao() throws SQLException {
        executeSql = new ExecuteSql();
    }

}
