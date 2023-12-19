package koreanmaster.board;

import koreanmaster.common.ExecuteSql;

import java.sql.SQLException;

public class CommonDao {
    protected final ExecuteSql executeSql;

    public CommonDao() throws SQLException {
        executeSql = new ExecuteSql();
    }

}
