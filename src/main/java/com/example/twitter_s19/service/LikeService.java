package com.example.twitter_s19.service;

import com.example.twitter_s19.entity.Like;
import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.entity.User;
import com.example.twitter_s19.repository.LikeRepository;
import com.example.twitter_s19.repository.TweetRepository;
import com.example.twitter_s19.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public LikeService(LikeRepository likeRepository, UserRepository userRepository,
                       TweetRepository tweetRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public void likeTweet(Long userId, Long tweetId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new RuntimeException("Tweet not found"));

        if (likeRepository.existsByUserAndTweet(user, tweet)) {
            throw new RuntimeException("User already liked this tweet");
        }

        Like like = Like.builder()
                .user(user)
                .tweet(tweet)
                .createdAt(LocalDateTime.now())
                .build();

        likeRepository.save(like);
    }

    public void dislikeTweet(Long userId, Long tweetId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new RuntimeException("Tweet not found"));

        likeRepository.findByUserAndTweet(user, tweet)
                .ifPresent(likeRepository::delete);
    }
}

