package cyou.zhaojin.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import cyou.zhaojin.bean.Client;
import cyou.zhaojin.constants.Result;
import cyou.zhaojin.dao.ClientDao;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Zhao JIN
 */
@Log4j2
public class ClientDaoImpl implements ClientDao {
    private static final ComboPooledDataSource CPDS = new ComboPooledDataSource();

    @Override
    public Result saveClient(Client client) {
        try (Connection connection = CPDS.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("insert into client(email, name, address, tel, amount, duration, descr, income, spent) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, client.getEmail());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setString(4, client.getTel());
            preparedStatement.setInt(5, client.getAmount());
            preparedStatement.setInt(6, client.getDuration());
            preparedStatement.setString(7, client.getDescription());
            preparedStatement.setDouble(8, client.getIncome());
            preparedStatement.setDouble(9, client.getSpent());
            if (preparedStatement.execute()) {
                return Result.SUCCESS;
            }
            return Result.SAVE_ERROR;
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.SAVE_ERROR;
        }
    }
}
