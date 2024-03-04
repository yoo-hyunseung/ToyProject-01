package com.example.toyproject01.service;

import com.example.toyproject01.dao.PostDAO;
import com.example.toyproject01.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService{
    @Autowired
    private PostDAO postDAO;
    @Override
    public PostDTO findPost(int no) {
        return postDAO.findPost(no);
    }

    @Override
    public void insertPost(PostDTO postDTO) {
        postDAO.insertPost(postDTO);
    }

    @Override
    public void updatePost(PostDTO postDTO) {
        postDAO.updatePost(postDTO);
    }

    @Override
    public void deletePost(int no) {
        postDAO.deletePost(no);
    }
}
