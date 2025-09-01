package com.example.twitter_s19.repository;

import com.example.twitter_s19.entity.Retweet;
import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface RetweetRepository extends JpaRepository<Retweet, Long> {

    Optional<Retweet> findByUserAndTweet(User user, Tweet tweet);

    List<Retweet> findByTweet(Tweet tweet);

    List<Retweet> findByUser(User user);

    boolean existsByUserAndTweet(User user, Tweet tweet);
}
