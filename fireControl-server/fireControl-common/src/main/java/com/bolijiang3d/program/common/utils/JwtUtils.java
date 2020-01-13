package com.bolijiang3d.program.common.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static final String SECRETKEY = "8a92e49c69a9af5e0169a9c120960004";
    private static final String EXP = "exp";
    private static final String PAYLOAD = "payload";
    /**创建JWT*/
    public static <T> String createJwt(T object, Long pastTime) throws IllegalArgumentException, UnsupportedEncodingException{
        Map<String, Object> map = new HashMap<String, Object>();
        String jsonString = JSON.toJSONString(object);
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        long exp = System.currentTimeMillis() + pastTime;

        String token = JWT.create()
                .withHeader(map)
                .withClaim(PAYLOAD, jsonString)
                .withClaim(EXP, new Date(exp))
                .sign(Algorithm.HMAC256(SECRETKEY));
        return token;
    }

    /**验证jwt*/
    public static boolean verifyJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRETKEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            System.out.println("校验失败");
        }
        return false;
    }

    public static <T> T DecodedJWT(String token, Class<T> classT) {
        DecodedJWT decode = JWT.decode(token);
        Map<String, Claim> claims = decode.getClaims();
        if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)){
            long tokenTime = claims.get(EXP).asDate().getTime();
            long nowTime = new Date().getTime();
            // 判断令牌是否超时
            if (tokenTime > nowTime){
                String json = claims.get(PAYLOAD).asString();
                return JSON.parseObject(json, classT);
            }
        }
        return null;
    }

    public static void main(String[] args){
        try{
            //Map<String, Object> map = new HashMap<>();
            //map.put("name", "tom");
            //map.put("age", 18);

            Long time = new Long(3600000);
            String token = createJwt("ac4e59dc9bdc4281996734498523a022", time);
            System.out.println(token);
            System.out.println(verifyJwt(token));

            System.out.println(DecodedJWT(token, String.class));
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
