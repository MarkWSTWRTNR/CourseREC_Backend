package couserec.rest.dao;

import couserec.rest.entity.User;
import couserec.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("db")
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> getUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    public User save(User user){
        return userRepository.save(user);
    }
}
