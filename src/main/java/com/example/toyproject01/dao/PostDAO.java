package com.example.toyproject01.dao;

import com.example.toyproject01.dto.PostDTO;
import com.example.toyproject01.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO {
    @Autowired
    private PostMapper mapper;

    public PostDTO findPost(int no) {
        return mapper.findPost(no);
    }

    public void insertPost(PostDTO postDTO) {
        mapper.insertPost(postDTO);
    }

    public void updatePost(PostDTO postDTO) {
        mapper.updatePost(postDTO);
    }

    public void deletePost(int no) {
        mapper.deletePost(no);
    }
}
