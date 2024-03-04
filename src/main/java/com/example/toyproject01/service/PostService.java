package com.example.toyproject01.service;

import com.example.toyproject01.dto.PostDTO;

public interface PostService {
    PostDTO findPost(int no);

    void insertPost(PostDTO postDTO);

    void updatePost(PostDTO postDTO);

    void deletePost(int no);
}
