package com.example.twitter_s19.service;

import com.example.twitter_s19.entity.Comment;
import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.entity.User;
import com.example.twitter_s19.repository.CommentRepository;
import com.example.twitter_s19.repository.TweetRepository;
import com.example.twitter_s19.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository,
                          TweetRepository tweetRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public Comment createComment(Long userId, Long tweetId, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new RuntimeException("Tweet not found"));

        Comment comment = Comment.builder()
                .content(content)
                .user(user)
                .tweet(tweet)
                .createdAt(LocalDateTime.now())
                .build();

        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, Long userId, String newContent) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        if (!comment.getUser().getId().equals(userId) && !comment.getTweet().getUser().getId().equals(userId)) {
            throw new RuntimeException("You cannot update this comment");
        }

        comment.setContent(newContent);
        comment.setUpdatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId, Long userId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        if (!comment.getUser().getId().equals(userId) && !comment.getTweet().getUser().getId().equals(userId)) {
            throw new RuntimeException("You cannot delete this comment");
        }

        commentRepository.delete(comment);
    }

    public List<Comment> getCommentsByTweet(Long tweetId) {
        return commentRepository.findByTweetId(tweetId);
    }
}

