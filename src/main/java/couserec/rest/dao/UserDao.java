package couserec.rest.dao;

import couserec.rest.entity.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUsername(String username);

    User save(User user);

    User getUserByUsername(String username);

    User saveUser(User user);
}
