package com.example.twitter_s19.repository;

import com.example.twitter_s19.entity.Comment;
import com.example.twitter_s19.entity.Tweet;
import com.example.twitter_s19.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTweet(Tweet tweet);

    List<Comment> findByUser(User user);

    List<Comment> findByTweetId(Long tweetId);
}
