package cn.wzvtc.dmtbs.config.authentication;

import cn.wzvtc.dmtbs.utils.CharsetUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证入口。
 * 需要认证时从这里进入。对于rest应用来说，为需要登录的用户不需要重定向为登录界面 -- 返回401 状态码，并提示用户需要登录(认证)
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = response.getWriter();
        out.write(CharsetUtil.AUTHENTICATION_NEED);
        out.flush();
        out.close();
    }
}
