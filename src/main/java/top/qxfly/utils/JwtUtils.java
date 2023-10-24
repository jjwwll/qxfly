package top.qxfly.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import top.qxfly.pojo.User;

import java.util.Date;

public class JwtUtils {
    private static String SignKey = "qxfly";
    private static Long timeout = 2592000000L;//30天

    public static String createToken(User user, Date date) {
        String jwt = Jwts.builder()
                .claim("user",user)
                .setIssuedAt(date) //设置jwt生成时间
                .signWith(SignatureAlgorithm.HS256, SignKey)
                .setExpiration(new Date(System.currentTimeMillis() + timeout))
                .compact();
        return jwt;
    }

    public static Claims parseJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(SignKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
