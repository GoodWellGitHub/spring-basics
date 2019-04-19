package com.org.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String cid;
    private String content;
    private String rootCid;
    private String parentCid;
    List<Comment> childComments;
}
