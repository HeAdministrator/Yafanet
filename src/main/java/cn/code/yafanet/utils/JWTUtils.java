package cn.code.yafanet.utils;

import cn.code.yafanet.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author AllenHe
 * @date 2022/3/24
 * @apiNote JWT工具类
 * 注意点：
 * 1,生成的token，是可以通过base64进行解密出明文信息
 * 2,base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3,无法作废已颁布的token，除非改密钥
 */
public class JWTUtils {

    /**
     * 过期时间，一周
     */
    private  static final long EXPIRE = 60000 * 60 *24 * 7;
    //private  static final long EXPIRE = 1;
    /**
     * 加密密匙
     */
    private  static final String SECRET = "yafanet.cn";

    /**
     * 令牌前缀
     */
    private static  final  String TOKEN_PREFIX = "yafanet";

    /**
     * subject
     */
    private  static  final  String  SUBJECT = "yafanet";

    /**
     * 根据用户信息，生成令牌
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                //payload 可以携带的有效资源
                .claim("head_Img",user.getHeadImg())
                .claim("id",user.getId())
                .claim("name",user.getName())
                //令牌下发时间
                .setIssuedAt(new Date())
                //令牌过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //签名
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();

        token = TOKEN_PREFIX + token;

        return token;
    }

    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try {
            final  Claims claims =  Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody();
            return  claims;
        }catch (Exception e){
            return  null;
        }

    }
}
