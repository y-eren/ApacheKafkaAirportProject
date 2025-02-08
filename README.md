<h1 align="center" style="color:#2c3e50;">✈️ Havalimanı Yönetim Sistemi (Kafka + WebSocket + Spring Boot)</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Spring%20Boot-✓-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Kafka-✓-red?style=for-the-badge" />
  <img src="https://img.shields.io/badge/WebSocket-✓-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Docker-✓-lightblue?style=for-the-badge" />
</p>

---

## 🛠 **Proje Açıklaması**
Bu proje, **Apache Kafka, Spring Boot ve WebSocket** kullanarak **havacılık sektöründe veri güncellemelerini gerçek zamanlı olarak yönetmek** için geliştirilmiştir. Kullanıcılar **havalimanı bilgilerini güncelleyebilir** ve bu güncellemeler:

- **Kafka** ile asenkron bir şekilde admin paneline iletilir.
- **WebSocket** kullanılarak admin dashboard’da canlı olarak gösterilir.
- **Veritabanında loglanır** ve değişiklikler saklanır.
- **Email bildirimi olarak gönderilir.**

📌 **Kullanım Senaryosu:**
1. Kullanıcı **havalimanı bilgilerini günceller** (User Service).  
2. Güncellenen veriler, **Kafka topic'ine mesaj olarak yazılır**.  
3. **Kafka consumer'ları mesajları dinler** ve bu bilgileri:  
   - **WebSocket** ile admin dashboard’a gönderir.  
   - **Log olarak veritabanına kaydeder**.  
   - **Adminlere e-posta gönderir**.  

Kafka sayesinde **senkron REST API çağrılarına ihtiyaç duyulmadan**, servisler birbirinden bağımsız çalışabilir.

---

## 🏗 **Proje Mimarisi**
Bu projede **iki bağımsız mikroservis** bulunmaktadır:

- **🟢 User Service (8081 Portu)**  
  - Kullanıcılar **havalimanı bilgilerini günceller** ve Kafka'ya mesaj gönderir.
  
- **🔵 Airport Service (8080 Portu)**  
  - Kafka'dan gelen mesajları **admin panelinde WebSocket ile gösterir, loglar ve e-posta olarak yollar.**

📌 **Kafka'nın Kullanım Nedeni:**
- **Asenkron ve ölçeklenebilir iletişim sağlamak**
- **Mikroservisler arasında bağımsız veri akışı oluşturmak**
- **Mesajların saklanarak daha sonra tekrar işlenmesine olanak tanımak**

---

## 🔧 **Kullanılan Teknolojiler**
- **Java 17**  
- **Spring Boot (Spring Web, Spring Data JPA, Spring Mail, Spring WebSocket)**  
- **Apache Kafka**  
- **WebSocket**  
- **Docker & Docker-Compose**  
- **PostgreSQL**  
- **PrimeFaces & JSF**  
- **Lombok**  
- **JoinFaces (JSF Entegrasyonu)**  

---

## 🚀 **Projenin Temel Bileşenleri**
- **Kafka Producer (Mesaj Üretimi):** Kullanıcıların güncelleme yaptığı veriler Kafka'ya gönderilir.  
- **Kafka Consumer (Mesaj Dinleme):** Admin paneli ve e-posta servisi Kafka'dan gelen mesajları dinler ve işler.  
- **WebSocket Entegrasyonu:** Gerçek zamanlı bildirimler admin dashboard'a iletilir.  
- **Loglama & Email Servisi:** Güncellenen havalimanı bilgileri veritabanına kaydedilir ve adminlere e-posta bildirimleri gönderilir.  

Bu yapılar, **mikroservisler arasında olay tabanlı iletişim** sağlayarak **senkron API çağrılarını ortadan kaldırır** ve sistemin daha ölçeklenebilir hale gelmesine olanak tanır.

---

## 📊 Projede Öğrendiklerim

Bu proje kapsamında birçok farklı teknolojiyi ve yazılım geliştirme pratiğini deneyimledim:

- **Apache Kafka ile Asenkron Mikroservis Haberleşmesi**  
  Servisler arasında veri alışverişinin **bağımsız** ve **olay tabanlı** olarak gerçekleştirilmesini sağladım.  

- **WebSocket ile Gerçek Zamanlı Veri Akışı**  
  Havalimanı güncellemelerini **anlık olarak admin dashboard’a gönderen** bir sistem geliştirdim.  

- **Spring Boot ile Modern Mikroservis Geliştirme**  
  Mikroservis mimarisine uygun olarak **bağımsız servisler** oluşturdum.  

- **Event-Driven Architecture (Olay Tabanlı Mimari)**  
  Kafka ile **servislerin birbirinden bağımsız** olarak çalışmasını sağladım.  

- **Docker & PostgreSQL Kullanımı**  
  Uygulamanın **taşınabilir ve ölçeklenebilir** olmasını sağlamak için servisleri **Docker konteynerleri** içinde çalıştırdım.  

---



## 🎯 Sonuç  

Bu proje, **gerçek zamanlı mesajlaşma ve olay tabanlı mikroservis mimarisi** konseptlerini **Kafka ve WebSocket** ile nasıl uygulayabileceğimizi göstermektedir. **Mikroservislerin birbirinden bağımsız çalışmasını sağlayan Kafka, mesajları güvenli ve asenkron bir şekilde iletir.**  
