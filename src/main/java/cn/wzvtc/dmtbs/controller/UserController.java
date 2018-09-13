package cn.wzvtc.dmtbs.controller;

import cn.wzvtc.dmtbs.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @GetMapping("/current")
    public User user(@AuthenticationPrincipal User user) {
        return user;
    }
}
