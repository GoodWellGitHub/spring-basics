package com.org.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Base64;

public class JWTUtil {
    private static String jwt ="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJQbkEzUHZyViIsImlhdCI6MTU1MzI0MDg2OSwiZXhwIjoxNTUzMjQ4MDY5LCJhdWQiOiI1eHEzb3k0MWpuIiwib3Blbl9pZCI6Ijk2NHE4bTU2djF6ZHlydjUiLCJ1c2VyX2lkIjoiMTgwODkyNTcwIiwibmFtZSI6Ilx1NTIxOFx1NmQwYlx1NmQwYiIsImF2YXRhciI6IiIsInZlcnNpb24iOiJ2MSJ9.UwZFsnWwWVF6qI0kZww3Reuqj3JxyXVWYcUCfDW9mVYBCrtEKKpWB822wSCDe8IsWkvORx4fFnAvFVwZmFLJgh8kW1ZBCWABZN9W_X9jKvXrfGo1KcvQr18QF-6KarpHdn5jS4O9enivTbtKIxkwJxgcOUrF-BCSTLAoze3K6pYM70iKEqQ2Zh_H8vuHCdw0LOFi5VhOATUDMyd_tPZFhohT_uyYF7R4lWrjgYcN9lQ3l98vo2aGzDJ2A9wjlhs3bzatBWYfDwKLiNATrcJGu3xV4MwWESVwYm2nlD9QWp7AoadWvg8IfGi_Bz0VHhTkl7TjvJuzODiS8fkN-5PvCQ";

    public static void main(String[] args) {
        BaiLingUserInfo userInfo=parseJWTBase64(jwt);
        System.out.println(userInfo.toString());
    }

    private static BaiLingUserInfo parseJWTBase64(String jwt) {
        try {
            String data = jwt.split("\\.")[1];
            byte[] alg = Base64.getDecoder().decode(data);
            return JSONObject.parseObject(new String(alg), BaiLingUserInfo.class);
        } catch (Exception e) {
            System.out.println("解析jwt失败, jwt:{},err:{}" + jwt + e);
        }
        return null;
    }
}
