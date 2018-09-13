package cn.wzvtc.dmtbs.utils;

/**
 * 定制 restful 的关于认证的响应正文信息。
 */
//todo : 关于认证的信息
public class CharsetUtil {
    public final static String AUTHENTICATION_FAIL = "{" +
            "\"code\" : " + 0 + "," +
            "\"msg\"  : \"认证失败，用户名或密码错误!\"}";

    public final static String AUTHENTICATION_NEED = "{" +
            "\"code\" : " + 0 + "," +
            "\"msg\"  : \"用户未认证，或认证已过期\"}";

    public final static String PERMISSION_DENIED = "{" +
            "\"code\" : " + 0 + "," +
            "\"msg\"  :   \"权限不足，请联系管理员!\"}";

    public final static String LOGOUT_SUCCESS = "{" +
            "\"code\" :" + 200 + "," +
            "\"msg\"  :\"登出成功!\"}";
}
