package cyou.zhaojin.dao;

import cyou.zhaojin.bean.Credit;

import java.util.List;

/**
 * @author Zhao JIN
 */
public interface CreditDao {
    List<Credit> findAll(String email);
}
