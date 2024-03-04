package com.example.toyproject01.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Data
public class PostDTO {
    private int no,hit;
    private String name,subject,content,pwd;
    private Date regdate;
}
