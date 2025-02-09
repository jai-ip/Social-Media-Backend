package com.app.todo.serviceImpl;

import com.app.todo.dto.CommentDataDTO;
import com.app.todo.dto.PostDTO;
import com.app.todo.dto.PostDataDTO;
import com.app.todo.dto.SuccessResponse;
import com.app.todo.entity.Comment;
import com.app.todo.entity.Post;
import com.app.todo.entity.User;
import com.app.todo.repo.PostRepo;
import com.app.todo.repo.UserRepo;
import com.app.todo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<SuccessResponse> addPost(PostDTO postDTO) {

        User user = userRepo.findByUserId(postDTO.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found, UserId: "+postDTO.getUserId()));

        Post post = new Post();
        post.setPostData(postDTO.getPostData());
        post.setUser(user);
        postRepo.save(post);

        return ResponseEntity.ok(new SuccessResponse(true, "Post added"));
    }

    @Override
    public List<PostDataDTO> getPostsByUserId(Long userId) {

        User user = userRepo.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found, UserId: "+userId));

        List<Post> posts = postRepo.findPostByUser(user);
        System.out.println("POST Size: "+posts.size());
        return posts.stream()
                .map(this::getPostDataDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDataDTO> getAllPostOfFollowersByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

    private PostDataDTO getPostDataDTO(Post post) {
        PostDataDTO postDataDTO = modelMapper.map(post, PostDataDTO.class);
        postDataDTO.setUserId(post.getUser().getUserId());

        postDataDTO.setComments(post.getComments().stream()
                .map(this::getCommentDataDTO)
                .collect(Collectors.toList()));

        postDataDTO.setLikeCount(post.getLikes().size());
        return postDataDTO;
    }

    private CommentDataDTO getCommentDataDTO(Comment comment) {
        return modelMapper.map(comment, CommentDataDTO.class);
    }

}
