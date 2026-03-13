import java.util.HashMap;
import java.util.Scanner;

class Urun {
    private String urunKodu;
    private String urunAdi;
    private int stokMiktari;
    private double fiyat;

    public Urun(String urunKodu, String urunAdi, int stokMiktari, double fiyat) {
        this.urunKodu = urunKodu;
        this.urunAdi = urunAdi;
        this.stokMiktari = stokMiktari;
        this.fiyat = fiyat;
    }

    public String getUrunKodu() { return urunKodu; }
    public String getUrunAdi() { return urunAdi; }
    public int getStokMiktari() { return stokMiktari; }
    public double getFiyat() { return fiyat; }
    
    public void setStokMiktari(int stokMiktari) { this.stokMiktari = stokMiktari; }

    @Override
    public String toString() {
        return "Kod: " + urunKodu + " | Ad: " + urunAdi + " | Stok: " + stokMiktari + " | Fiyat: " + fiyat + " TL";
    }
}

public class StokYonetimi {
    private static HashMap<String, Urun> depo = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        depo.put("LTP01", new Urun("LTP01", "Asus Laptop", 10, 25000.0));
        depo.put("KLV02", new Urun("KLV02", "Mekanik Klavye", 50, 1500.0));
        depo.put("MOU03", new Urun("MOU03", "Oyuncu Mouse", 0, 800.0));

        System.out.println("--- Depo Yonetim Sistemine Giris ---");
        System.out.print("Admin Sifresi: ");
        String sifre = scanner.nextLine();

        if (!sifre.equals("admin123")) {
            System.out.println("Hatali sifre! Erisim engellendi.");
            System.exit(0);
        }

        while (true) {
            System.out.println("\n=== STOK ISLEMLERI ===");
            System.out.println("1. Tum Urunleri Listele");
            System.out.println("2. Yeni Urun Ekle");
            System.out.println("3. Urun Satisi Yap (Stoktan Dus)");
            System.out.println("4. Toplam Depo Degerini Hesapla");
            System.out.println("5. Sistemden Cik");
            System.out.print("Seciminiz: ");
            
            try {
                int islem = Integer.parseInt(scanner.nextLine());

                if (islem == 5) {
                    System.out.println("Sistem kapatiliyor...");
                    break;
                }

                switch (islem) {
                    case 1:
                        urunListele();
                        break;
                    case 2:
                        urunEkle();
                        break;
                    case 3:
                        satisYap();
                        break;
                    case 4:
                        depoDegeriHesapla();
                        break;
                    default:
                        System.out.println("Bilinmeyen islem numarasi!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Hata: Lutfen menuden gecerli bir rakam (1-5) giriniz!");
            }
        }
    }

    private static void urunListele() {
        System.out.println("\n--- Depodaki Urunler ---");
        if (depo.isEmpty()) {
            System.out.println("Depo su an bos.");
            return;
        }
        
        for (Urun u : depo.values()) {
            System.out.println(u.toString());
        }
    }

    private static void urunEkle() {
        System.out.print("Eklenecek Urun Kodu: ");
        String kod = scanner.nextLine().toUpperCase();
        
        if (depo.containsKey(kod)) {
            System.out.println("Uyari: Bu urun kodu zaten kayitli!");
            return;
        }

        System.out.print("Urunun Adi: ");
        String ad = scanner.nextLine();
        
        try {
            System.out.print("Adet: ");
            int adet = Integer.parseInt(scanner.nextLine()); 
            
            System.out.print("Birim Fiyati (TL): ");
            double fiyat = Double.parseDouble(scanner.nextLine());

            Urun yeni = new Urun(kod, ad, adet, fiyat);
            depo.put(kod, yeni);
            System.out.println("Urun basariyla depoya eklendi!");
        } catch (NumberFormatException e) {
            System.out.println("Hata: Adet ve Fiyat bilgileri sayisal olmalidir! Urun eklenemedi.");
        }
    }

    private static void satisYap() {
        System.out.print("Satilan Urunun Kodu: ");
        String kod = scanner.nextLine().toUpperCase();

        if (depo.containsKey(kod)) {
            Urun satilanUrun = depo.get(kod);
            if (satilanUrun.getStokMiktari() > 0) {
                satilanUrun.setStokMiktari(satilanUrun.getStokMiktari() - 1);
                System.out.println("Satis onaylandi! Kalan stok: " + satilanUrun.getStokMiktari());
            } else {
                System.out.println("Hata: " + satilanUrun.getUrunAdi() + " icin stok tukenmis!");
            }
        } else {
            System.out.println("Hata: Girdiginiz kodda bir urun bulunamadi.");
        }
    }

    private static void depoDegeriHesapla() {
        double toplamDeger = 0;
        for (Urun u : depo.values()) {
            toplamDeger += (u.getStokMiktari() * u.getFiyat());
        }
        System.out.println("\n-> Depodaki tum urunlerin toplam degeri: " + toplamDeger + " TL");
    }
}