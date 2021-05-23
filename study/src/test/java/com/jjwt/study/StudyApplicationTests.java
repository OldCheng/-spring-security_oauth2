package com.jjwt.study;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Decoder;

import java.util.Base64;
import java.util.Date;

@SpringBootTest
class StudyApplicationTests {

    /**
     * 生成jwt
     */
    @Test
    public void testJwt() {
        JwtBuilder jwtBuilder = Jwts.builder()
                // 唯一ID{"id":"888"}
                .setId("888")
                // 接受的用户{"sub":"Rose"}
                .setSubject("Rose")
                // 签发的时间{"iat":"Rose"}
                .setIssuedAt(new Date())
                // 签名算法，及密钥
                .signWith(SignatureAlgorithm.HS256, "xxxx");
        // 签发token
        String token = jwtBuilder.compact();
        System.out.println(token);

        System.out.println("----------------------------------------------------");
        String[] split = token.split("\\.");
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        // 这个会乱码
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
    }


    /**
     * 解析token
     */
    @Test
    public void testParseToke() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjIxMjU5MDU0fQ.QEq5h9Xq7a3ayBjPz9k_K_33o7kS4R1vBp-Nza5bexo";
        // 解析token 获取claims对象，jwt中荷载申明的对象
        Claims claims = (Claims) Jwts.parser()
                //密钥
                .setSigningKey("xxxx")
                .parse(token)
                .getBody();

        System.out.println("id=" + claims.getId());
        System.out.println("sub=" + claims.getSubject());
        System.out.println("iat=" + claims.getIssuedAt());
    }

    /**
     * 生成jwt(生效时间)
     */
    @Test
    public void testJwtHasExpire() {

        // 当前时间
        long date = System.currentTimeMillis();

        long exp = date + 60 * 1000;

        JwtBuilder jwtBuilder = Jwts.builder()
                // 唯一ID{"id":"888"}
                .setId("888")
                // 接受的用户{"sub":"Rose"}
                .setSubject("Rose")
                // 签发的时间{"iat":"Rose"}
                .setIssuedAt(new Date())
                // 签名算法，及密钥
                .signWith(SignatureAlgorithm.HS256, "xxxx")
                // 设置生效时间
                .setExpiration(new Date(exp));
        // 签发token
        String token = jwtBuilder.compact();
        System.out.println(token);

        System.out.println("----------------------------------------------------");
        String[] split = token.split("\\.");
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        // 这个会乱码
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
    }

    /**
     * 解析token
     */
    @Test
    public void testParseTokeHasExpire() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjIxNzQ5MDExLCJleHAiOjE2MjE3NDkwNzF9.UPqRxBwTdBczV_IAl6uRsbqQGJmcOmn4ZejTwYMT34Q";

        // 解析token 获取claims对象，jwt中荷载申明的对象
        Claims claims = (Claims) Jwts.parser()
                //密钥
                .setSigningKey("xxxx")
                .parse(token)
                .getBody();

        System.out.println("id=" + claims.getId());
        System.out.println("sub=" + claims.getSubject());
        System.out.println("iat=" + claims.getIssuedAt());
    }

    /**
     * 生成jwt(自定义申明)
     */
    @Test
    public void testJwtEnhancer() {

        // 当前时间
        long date = System.currentTimeMillis();

        long exp = date + 60 * 1000;

        JwtBuilder jwtBuilder = Jwts.builder()
                // 唯一ID{"id":"888"}
                .setId("888")
                // 接受的用户{"sub":"Rose"}
                .setSubject("Rose")
                // 签发的时间{"iat":"Rose"}
                .setIssuedAt(new Date())
                // 签名算法，及密钥
                .signWith(SignatureAlgorithm.HS256, "xxxx")
                .claim("name","jack")
                .claim("logo","xxx.jpg");
        // 签发token
        String token = jwtBuilder.compact();
        System.out.println(token);

        System.out.println("----------------------------------------------------");
        String[] split = token.split("\\.");
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        // 这个会乱码
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
    }


    /**
     * 解析token
     */
    @Test
    public void testParseTokeEnhancer() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjIxNzQ5NDU4LCJuYW1lIjoiamFjayIsImxvZ28iOiJ4eHguanBnIn0.2BfVa92KVGUutdQUX8PpEkuxVw9-UR4btgWcXN7oe7A";

        // 解析token 获取claims对象，jwt中荷载申明的对象
        Claims claims = (Claims) Jwts.parser()
                //密钥
                .setSigningKey("xxxx")
                .parse(token)
                .getBody();

        System.out.println("id=" + claims.getId());
        System.out.println("sub=" + claims.getSubject());
        System.out.println("iat=" + claims.getIssuedAt());
        System.out.println("name=" + claims.get("name"));
        System.out.println("logo=" + claims.get("logo"));
    }


}
