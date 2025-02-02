package com.app.todo.serviceImpl;

import com.app.todo.dto.CommentDTO;
import com.app.todo.dto.SuccessResponse;
import com.app.todo.entity.Comment;
import com.app.todo.entity.Post;
import com.app.todo.repo.CommentRepo;
import com.app.todo.repo.PostRepo;
import com.app.todo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepo postRepo;

    @Override
    public ResponseEntity<SuccessResponse> addComment(Long postId, CommentDTO commentDTO) {

        Post post = postRepo.findPostByPostId(postId);

        Comment comment = new Comment();
        comment.setCommentData(commentDTO.getCommentData());
        comment.setPost(post);

        commentRepo.save(comment);

        return ResponseEntity.ok(new SuccessResponse(true, "Comment added"));
    }
}
