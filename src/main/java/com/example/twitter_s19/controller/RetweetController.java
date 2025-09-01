package com.example.twitter_s19.controller;

import com.example.twitter_s19.service.RetweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/retweets")
public class RetweetController {

    private final RetweetService retweetService;

    public RetweetController(RetweetService retweetService) {
        this.retweetService = retweetService;
    }

    // Tweet'i retweet et
    @PostMapping
    public ResponseEntity<String> retweet(@RequestParam Long userId,
                                          @RequestParam Long tweetId) {
        retweetService.retweet(userId, tweetId);
        return ResponseEntity.ok("Tweet retweeted successfully");
    }

    // Retweet'i sil
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRetweet(@PathVariable Long id,
                                                @RequestParam Long userId) {
        retweetService.deleteRetweet(id, userId);
        return ResponseEntity.ok("Retweet deleted successfully");
    }
}

