package com.app.todo.serviceImpl;

import com.app.todo.dto.PostDTO;
import com.app.todo.dto.SuccessResponse;
import com.app.todo.entity.Post;
import com.app.todo.repo.PostRepo;
import com.app.todo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public ResponseEntity<SuccessResponse> addPost(PostDTO postDTO) {

        Post post = new Post();
        post.setPostData(postDTO.getPostData());
        postRepo.save(post);

        return ResponseEntity.ok(new SuccessResponse(true, "Post added"));
    }

    @Override
    public List<Post> getAllPost() {
        return postRepo.findAll();
    }
}
