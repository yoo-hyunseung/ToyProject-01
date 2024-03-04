package com.example.toyproject01.mapper;

import com.example.toyproject01.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
//    조회
    public PostDTO findPost(int no);
// 글쓰기
    public void insertPost(PostDTO postDTO);

    //    삭제
    public void deletePost(int no);

    //    수정
    public void updatePost(PostDTO postDTO);
}
