package com.example.twitter_s19.controller;

import com.example.twitter_s19.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // Tweet'e like at
    @PostMapping
    public ResponseEntity<String> likeTweet(@RequestParam Long userId,
                                            @RequestParam Long tweetId) {
        likeService.likeTweet(userId, tweetId);
        return ResponseEntity.ok("Tweet liked successfully");
    }

    // Tweet'ten like kaldır
    @PostMapping("/dislike")
    public ResponseEntity<String> dislikeTweet(@RequestParam Long userId,
                                               @RequestParam Long tweetId) {
        likeService.dislikeTweet(userId, tweetId);
        return ResponseEntity.ok("Like removed successfully");
    }
}

