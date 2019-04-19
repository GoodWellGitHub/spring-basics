package com.org.algorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.org.domain.Comment;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TreeDiGui {
    private static final int k = 2;

    public static void main(String[] args) {
        List<Comment> comments = commentList();
        System.out.println(JSON.toJSONString(comments));

        Map<String, List<Comment>> commentMap = comments.stream().filter(obj -> {
            return !StringUtils.isEmpty(obj.getParentCid());
        }).collect(Collectors.groupingBy(Comment::getParentCid));

        list(commentMap.get("00"), commentMap);
        System.out.println(JSON.toJSONString(comments));

        for (Comment comment : commentMap.get("00")) {
            buildLevelComment(comment, 1);
        }
        System.out.println(JSON.toJSONString(comments));

    }


    static void digui(Map<String, List<Comment>> comments, Comment comment) {
        List<Comment> temp = comments.get(comment.getCid());
        if (CollectionUtils.isEmpty(temp)) {
            return;
        } else {
            comment.setChildComments(temp);
            list(temp, comments);
        }
    }


    static void list(List<Comment> comments, Map<String, List<Comment>> commentMap) {
        for (Comment comment : comments) {
            List<Comment> temp = commentMap.get(comment.getCid());
            if (CollectionUtils.isEmpty(temp)) {
                continue;
            } else {
                digui(commentMap, comment);
            }
        }
    }


    /**
     * 构建评论层级
     *
     * @param commentItem
     * @param
     */
    static void buildLevelComment(Comment commentItem, int level) {
        if (CollectionUtils.isEmpty(commentItem.getChildComments())) {
            return;
        }
        if (level >= 2) {
            List<Comment> childCommentItem = Lists.newArrayList();
            buildLevelCommentRecur(commentItem.getChildComments(), childCommentItem);
            commentItem.setChildComments(childCommentItem);
        } else {
            for (Comment comment : commentItem.getChildComments()) {
                buildLevelComment(comment, level + 1);
            }
        }
    }

    static void buildLevelCommentRecur(List<Comment> descendant, List<Comment> childCommentItems) {
        if (CollectionUtils.isEmpty(descendant)) {
            return;
        }
        childCommentItems.addAll(descendant);
        for (Comment commentItem : descendant) {
            buildLevelCommentRecur(commentItem.getChildComments(), childCommentItems);
            commentItem.setChildComments(null);
        }
    }


    static List<Comment> commentList() {
        Comment comment00 = Comment.builder().cid("00").build();
        Comment comment10 = Comment.builder().parentCid("00").cid("10").build();
        Comment comment11 = Comment.builder().parentCid("00").cid("11").build();
        Comment comment12 = Comment.builder().parentCid("00").cid("12").build();
        Comment comment21 = Comment.builder().parentCid("11").cid("21").build();
        Comment comment30 = Comment.builder().parentCid("21").cid("30").build();
        Comment comment40 = Comment.builder().parentCid("30").cid("40").build();


        List<Comment> comments = Lists.newArrayList();
        comments.add(comment00);
        comments.add(comment10);
        comments.add(comment11);
        comments.add(comment12);
        comments.add(comment21);
        comments.add(comment30);
        comments.add(comment40);

        return comments;

    }
}
