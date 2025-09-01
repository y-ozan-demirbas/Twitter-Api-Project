package com.example.twitter_s19.service;

import com.example.twitter_s19.entity.Retweet;
import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.entity.User;
import com.example.twitter_s19.repository.RetweetRepository;
import com.example.twitter_s19.repository.TweetRepository;
import com.example.twitter_s19.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RetweetService {

    private final RetweetRepository retweetRepository;
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public RetweetService(RetweetRepository retweetRepository, TweetRepository tweetRepository,
                          UserRepository userRepository) {
        this.retweetRepository = retweetRepository;
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void retweet(Long userId, Long tweetId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new RuntimeException("Tweet not found"));

        if (retweetRepository.existsByUserAndTweet(user, tweet)) {
            throw new RuntimeException("User already retweeted this tweet");
        }

        Retweet retweet = Retweet.builder()
                .user(user)
                .tweet(tweet)
                .createdAt(LocalDateTime.now())
                .build();

        retweetRepository.save(retweet);
    }

    public void deleteRetweet(Long retweetId, Long userId) {
        Retweet retweet = retweetRepository.findById(retweetId)
                .orElseThrow(() -> new RuntimeException("Retweet not found"));

        if (!retweet.getUser().getId().equals(userId)) {
            throw new RuntimeException("You cannot delete this retweet");
        }

        retweetRepository.delete(retweet);
    }
}

