# Twitter Clone Backend (Spring Boot)

Bu proje, **Spring Boot** kullanılarak geliştirilmiş basit bir **Twitter klonu** backend uygulamasıdır.  
Amaç, kullanıcıların kayıt olup giriş yapabildiği, tweet paylaşabildiği, retweet, beğeni (like) ve yorum (comment) yapabildiği bir sosyal medya API’si oluşturmaktır.  

## 🚀 Özellikler
- 👤 Kullanıcı Yönetimi
  - Kullanıcı kayıt olma
  - Kullanıcı giriş yapma
- 🐦 Tweet Yönetimi
  - Yeni tweet paylaşma
  - Retweet
  - Tweet beğenme (like)
  - Tweet yorumlama (comment)
- 🔍 Postman üzerinden test edilebilir REST API uç noktaları

## 🛠️ Teknolojiler
- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Web
- PostgreSQL (veya başka SQL veritabanı)
- Postman (API testi için)

## 🔑 API Endpointleri (Örnek)
- **POST /api/auth/register** → Yeni kullanıcı kaydı oluşturur  
- **POST /api/auth/login** → Kullanıcı girişi yapar  
- **POST /api/tweets** → Yeni tweet paylaşır  
- **POST /api/tweets/{id}/retweet** → Retweet yapar  
- **POST /api/tweets/{id}/like** → Tweeti beğenir  
- **POST /api/tweets/{id}/comment** → Tweet’e yorum yapar  
- **GET /api/tweets** → Tüm tweetleri listeler  
