package com.example.toyproject01.controller;

import com.example.toyproject01.dto.PostDTO;
import com.example.toyproject01.service.PostService;
import com.example.toyproject01.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("/select")
    public PostDTO select(@RequestParam String no) {
        return service.findPost(Integer.parseInt(no));
    }

    @PostMapping("/insert")
    public void insert(@RequestBody PostDTO postDTO) {
        service.insertPost(postDTO);
    }

    @PutMapping("/update")
    public void update(@RequestBody PostDTO postDTO) {
        service.updatePost(postDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int no) {
        service.deletePost(no);
    }
}
