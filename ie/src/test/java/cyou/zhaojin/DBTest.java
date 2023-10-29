package cyou.zhaojin;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Zhao JIN
 */
public class DBTest {
    @Test
    public void dbtest() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection connection = cpds.getConnection();
        connection.close();
        cpds.close();
    }
}
