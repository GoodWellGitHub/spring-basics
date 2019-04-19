package com.org.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String portal;
    private String app_id;
    private String msgtype;
    private MessageInfo msg;
    private List<String> touser;
}
