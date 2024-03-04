package com.example.toyproject01.vo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PostVO {
    // 글 번호, 제목, 작성자, 내용, 날짜
    private int no,hit;
    private String name,subject,content, pwd;
    private Date regdate;

    public PostVO(int no, int hit, String name, String subject, String content, String pwd, Date regdate) {
        this.no = no;
        this.hit = hit;
        this.name = name;
        this.subject = subject;
        this.content = content;
        this.pwd = pwd;
        this.regdate = regdate;
    }
}
