package com.example.twitter_s19.repository;


import com.example.twitter_s19.entity.Like;
import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Optional<Like> findByUserAndTweet(User user, Tweet tweet);

    List<Like> findByTweet(Tweet tweet);

    List<Like> findByUser(User user);

    boolean existsByUserAndTweet(User user, Tweet tweet);
}

