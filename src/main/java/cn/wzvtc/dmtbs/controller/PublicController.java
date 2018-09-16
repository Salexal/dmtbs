package cn.wzvtc.dmtbs.controller;

import cn.wzvtc.dmtbs.domain.User;
import cn.wzvtc.dmtbs.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/public")
@RestController
@AllArgsConstructor
public class PublicController {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/users")
    public boolean registerUser(@RequestBody User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("username is exist");
        }

        String encode = encoder.encode(user.getPassword());
        user.setPassword(encode);
        userRepository.persist(user);
        return true;
    }

}
