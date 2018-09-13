package cn.wzvtc.dmtbs.controller;

import cn.wzvtc.dmtbs.domain.User;
import cn.wzvtc.dmtbs.repository.UserRepository;
import cn.wzvtc.dmtbs.utils.MD5Util;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/public")
@RestController
@AllArgsConstructor
public class PublicController {

    private final UserRepository userRepository;

    @PostMapping("/users")
    public boolean registerUser(@RequestBody User user) {
        String encodePassword = MD5Util.generate(user.getPassword());
        user.setPassword(encodePassword);
        userRepository.persist(user);
        return true;
    }

}
