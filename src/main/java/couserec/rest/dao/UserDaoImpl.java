package couserec.rest.dao;

import couserec.rest.entity.User;
import couserec.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db")
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByCmuitaccount(String cmuitaccount) {
        return userRepository.findByCmuitaccount(cmuitaccount);
    }
}
