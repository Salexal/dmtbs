package cn.wzvtc.dmtbs.config.authentication;

import cn.wzvtc.dmtbs.utils.CharsetUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthenticationFaildHandler extends SimpleUrlAuthenticationFailureHandler {

    /**
     * 无法理解认证失败时 SimpleUrlAuthenticationFailureHandler 同样创建了 session。这里重写了规则，不创建session
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException
            exception) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = response.getWriter();
        out.write(CharsetUtil.AUTHENTICATION_FAIL);
        out.flush();
        out.close();
    }

}
