package com.org.util;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaiLingUserInfo {

    private String aud;
    private String appname;
    @JSONField(name = "user_id")
    private String userId;
    private String avatar;
    @JSONField(name = "name_cn")
    private String nameCn;

}
