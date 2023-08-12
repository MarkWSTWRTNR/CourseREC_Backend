package couserec.rest.service;

import couserec.rest.dao.UserDao;
import couserec.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByCmuitaccount(String cmuitaccount) {
        return userDao.findByCmuitaccount(cmuitaccount);
    }
}
