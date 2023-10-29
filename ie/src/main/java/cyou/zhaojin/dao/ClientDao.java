package cyou.zhaojin.dao;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.constants.Result;

/**
 * @author Zhao JIN
 */
public interface ClientDao {
    Result saveClient(Client client);
}
