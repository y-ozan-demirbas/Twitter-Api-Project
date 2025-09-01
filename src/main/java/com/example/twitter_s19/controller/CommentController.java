package com.example.twitter_s19.controller;

import com.example.twitter_s19.entity.Comment;
import com.example.twitter_s19.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Yorum oluştur
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestParam Long userId,
                                                 @RequestParam Long tweetId,
                                                 @RequestParam String content) {
        Comment comment = commentService.createComment(userId, tweetId, content);
        return ResponseEntity.ok(comment);
    }

    // Yorum güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id,
                                                 @RequestParam Long userId,
                                                 @RequestParam String content) {
        Comment updatedComment = commentService.updateComment(id, userId, content);
        return ResponseEntity.ok(updatedComment);
    }

    // Yorum sil
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id,
                                                @RequestParam Long userId) {
        commentService.deleteComment(id, userId);
        return ResponseEntity.ok("Comment deleted successfully");
    }

    // Tweet'e ait yorumları listele
    @GetMapping("/byTweet")
    public ResponseEntity<List<Comment>> getCommentsByTweet(@RequestParam Long tweetId) {
        List<Comment> comments = commentService.getCommentsByTweet(tweetId);
        return ResponseEntity.ok(comments);
    }
}
