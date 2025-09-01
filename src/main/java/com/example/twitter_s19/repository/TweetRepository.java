package com.example.twitter_s19.repository;

import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByUser(User user);

    List<Tweet> findByUserId(Long userId);
}
