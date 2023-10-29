package cyou.zhaojin.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import cyou.zhaojin.bean.Credit;
import cyou.zhaojin.dao.CreditDao;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Zhao JIN
 */
@Log4j2
public class CreditDaoImpl implements CreditDao {
    private static final ComboPooledDataSource CPDS = new ComboPooledDataSource();

    @Override
    public List<Credit> findAll(String email) {
        try (Connection connection = CPDS.getConnection()){
            PreparedStatement statement = connection.prepareStatement("select credit_id, email, c_amount, c_duration, c_time_rest, c_amount_rest from credit where email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<Credit> credits = new ArrayList<>();
            while (resultSet.next()) {
                Credit credit = new Credit();
                for (int i = 0; i < columnCount; i++) {
                    Object object = resultSet.getObject(i+1);
                    String columnName = metaData.getColumnName(i+1);
                    Field field = Credit.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(credit, object);
                }
                credits.add(credit);
            }
            return credits;
        } catch (Exception e) {
            log.error(e.getMessage());
            return Collections.emptyList();
        }
    }
}