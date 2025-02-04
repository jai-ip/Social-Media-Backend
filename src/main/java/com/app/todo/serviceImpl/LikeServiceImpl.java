package com.app.todo.serviceImpl;

import com.app.todo.dto.SuccessResponse;
import com.app.todo.entity.Like;
import com.app.todo.entity.Post;
import com.app.todo.repo.LikeRepo;
import com.app.todo.repo.PostRepo;
import com.app.todo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private LikeRepo likeRepo;

    @Override
    public ResponseEntity<SuccessResponse> likePost(Long postId) {

        Post post = postRepo.findPostByPostId(postId);

        Like like = new Like();
        like.setPost(post);
        likeRepo.save(like);

        return ResponseEntity.ok(new SuccessResponse(true, "Like added"));
    }
}
