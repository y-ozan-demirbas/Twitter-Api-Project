package com.example.twitter_s19.service;

import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.entity.User;
import com.example.twitter_s19.repository.TweetRepository;
import com.example.twitter_s19.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Tweet createTweet(Long userId, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tweet tweet = Tweet.builder()
                .content(content)
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();

        return tweetRepository.save(tweet);
    }

    public List<Tweet> getTweetsByUser(Long userId) {
        return tweetRepository.findByUserId(userId);
    }

    public Tweet getTweetById(Long id) {
        return tweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tweet not found"));
    }

    public Tweet updateTweet(Long tweetId, Long userId, String newContent) {
        Tweet tweet = getTweetById(tweetId);

        if (!tweet.getUser().getId().equals(userId)) {
            throw new RuntimeException("You are not the owner of this tweet");
        }

        tweet.setContent(newContent);
        tweet.setUpdatedAt(LocalDateTime.now());

        return tweetRepository.save(tweet);
    }

    public void deleteTweet(Long tweetId, Long userId) {
        Tweet tweet = getTweetById(tweetId);

        if (!tweet.getUser().getId().equals(userId)) {
            throw new RuntimeException("You cannot delete this tweet");
        }

        tweetRepository.delete(tweet);
    }
}

