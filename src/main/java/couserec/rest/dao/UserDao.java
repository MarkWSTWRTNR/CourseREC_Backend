package couserec.rest.dao;

import couserec.rest.entity.User;

public interface UserDao {
    User findByCmuitaccount(String cmuitaccount);
}
