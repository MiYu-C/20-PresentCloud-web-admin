package PresentCloud.tool;


import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/*
* 用户从token中取出用户Id
* */
public class TokenUtil {

    // 过期时间30天
    private static final long EXPIRE_TIME = 24 * 60 * 30 * 1000;

    public static String getTokenUserId() {
        String token = getRequest().getHeader("Token");// 从 http 请求头中取出 token
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
