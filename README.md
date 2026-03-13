# 📦 Java Stok ve Envanter Yönetimi

Bu proje, Java programlama dili ve veri yapıları kullanılarak geliştirilmiş konsol tabanlı bir stok yönetim otomasyonudur. 

## 🚀 Kullanılan Teknolojiler ve Kavramlar
- **Java (JDK)**
- **Java Collections (HashMap):** Ürünlerin `O(1)` zaman karmaşıklığında (Time Complexity) hızlıca aranması ve güncellenmesi için kullanıldı.
- **Exception Handling (Hata Yönetimi):** Kullanıcı giriş hatalarını (örn: harf girilmesi) `try-catch` blokları ile yakalayarak programın çökmesi engellendi (InputMismatchException koruması).
- **OOP (Nesne Yönelimli Programlama):** Ürün verileri `Urun` sınıfı üzerinden kapsüllenerek (Encapsulation) yönetildi.

## ⚙️ Proje Özellikleri
- 🔐 Basit Admin giriş doğrulama sistemi.
- ➕ Yeni ürün ekleme ve benzersiz kod (ID) kontrolü.
- 🛒 Stoktan ürün düşme (Satış simülasyonu).
- 💰 Depodaki tüm ürünlerin toplam finansal değerini hesaplama.
- 🛡️ "Infinite Loop" (Sonsuz Döngü) korumalı akıllı konsol menüsü.
