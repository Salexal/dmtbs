package cn.wzvtc.dmtbs.config.authentication;

import cn.wzvtc.dmtbs.utils.MD5Util;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            return MD5Util.verify(rawPassword.toString(), encodedPassword);
        } catch (Exception e) {
            throw new BadCredentialsException("认证失败,用户名或密码错误");
        }
    }
}
