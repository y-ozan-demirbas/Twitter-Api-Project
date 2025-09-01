package com.example.twitter_s19.controller;

import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.service.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    // Tweet oluştur
    @PostMapping
    public ResponseEntity<Tweet> createTweet(@RequestParam Long userId,
                                             @RequestParam String content) {
        Tweet tweet = tweetService.createTweet(userId, content);
        return ResponseEntity.ok(tweet);
    }

    // Kullanıcının tüm tweetlerini getir

    @GetMapping("/findByUserId")
    public ResponseEntity<List<Tweet>> getTweetsByUser(@RequestParam Long userId) {
        List<Tweet> tweets = tweetService.getTweetsByUser(userId);
        return ResponseEntity.ok(tweets);
    }

    // Tweet detayını getir
    @GetMapping("/findById")
    public ResponseEntity<Tweet> getTweetById(@RequestParam Long id) {
        Tweet tweet = tweetService.getTweetById(id);
        return ResponseEntity.ok(tweet);
    }

    // Tweet güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Tweet> updateTweet(@PathVariable Long id,
                                             @RequestParam Long userId,
                                             @RequestParam String content) {
        Tweet updatedTweet = tweetService.updateTweet(id, userId, content);
        return ResponseEntity.ok(updatedTweet);
    }

    // Tweet sil
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTweet(@PathVariable Long id,
                                              @RequestParam Long userId) {
        tweetService.deleteTweet(id, userId);
        return ResponseEntity.ok("Tweet deleted successfully");
    }
}

