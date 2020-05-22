package PresentCloud.services;

import PresentCloud.pojo.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * token 下发
 */
@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;  //一小时有效时间
        Date end = new Date(currentTime);   // 过期时间为start 时间加上一小时
        String token = "";

        token = JWT.create().withAudience(String.valueOf(user.getId())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
