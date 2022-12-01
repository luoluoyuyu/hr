package com.hr.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.hr.pojo.UserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class JWTTool {
    private String secret="lzy";
    private static String header="token";
    private long expiration= (long) (60 * 60 * 1000);


    public static String getHeader(){
        return header;
    }

    public String generateToken(UserDetail userDetail) {
        Map<String, Object> claims = new HashMap<>(3);
        claims.put("sub", userDetail.getUsername());
        claims.put("name",userDetail.getName());
        claims.put("created", new Date());
        claims.put("roles", String .join(",",userDetail.getRoles()));
        return generateToken(claims);
    }


    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public  String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            username = null;
        }
        return username;
    }

    public List<String> getRoleFromToken(String token){
        List<String> role;
        try {
            DecodedJWT decode = JWT.decode(token);
            role = Arrays.asList(
                    decode.getClaim("roles").asString()
                    .split(","));
        } catch (Exception e) {
            role = null;
        }
        return role;
    }

    public String getNameFromToken(String token){
        String name;
        try {
            DecodedJWT decode = JWT.decode(token);
            name= decode.getClaim("name").asString();
        } catch (Exception e) {
            name = null;
        }
        return name;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userDetails 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {

        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    /**
     * 从claims生成令牌,如果看不懂就看谁调用它
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);

        String token= Jwts.builder().setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明,如果看不懂就看谁调用它
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            claims = null;
        }
        return claims;
    }

    public Date getExpiration(String token){
        Date date;
        Claims claims=getClaimsFromToken(token);
        try {
            date = claims.getExpiration();
        }catch (Exception e){
            return null;
        }
        return date;
    }
    public Date getCreated(String token){
        Date date;
        Claims claims=getClaimsFromToken(token);
        try {
            date = claims.get("created",Date.class);
        }catch (Exception e){
            return null;
        }
        return date;
    }







    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public static void setHeader(String header) {
        JWTTool.header = header;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public JWTTool() {
    }
}
