package cn.wzvtc.dmtbs.repository;

import cn.wzvtc.dmtbs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    User persist(User user);

    Optional<User> findByUsername(String username);
}
