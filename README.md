Twitter Clone Backend (Spring Boot)

This project is a simple Twitter clone backend application built with Spring Boot.
The goal is to provide a REST API where users can register, log in, post tweets, retweet, like tweets, and comment on tweets.

🚀 Features
👤 User Management

User registration

User login

🐦 Tweet Management

Create new tweets

Retweet existing tweets

Like tweets

Comment on tweets

🔍 Testing

Fully testable REST API endpoints using Postman

🛠️ Technologies

Java 17+

Spring Boot

Spring Data JPA

Spring Web

PostgreSQL (or any SQL database)

Postman (for API testing)

🔑 API Endpoints (Examples)

POST /api/auth/register → Create a new user account

POST /api/auth/login → User login

POST /api/tweets → Create a new tweet

POST /api/tweets/{id}/retweet → Retweet a tweet

POST /api/tweets/{id}/like → Like a tweet

POST /api/tweets/{id}/comment → Comment on a tweet

GET /api/tweets → List all tweets
