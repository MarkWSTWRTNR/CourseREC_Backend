package couserec.rest.repository;

import couserec.rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCmuitaccount(String cmuitaccount);
}

