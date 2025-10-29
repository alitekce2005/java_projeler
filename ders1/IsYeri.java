import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Ana sınıfı is_yeri yerine Java standartlarına uygun olarak IsYeri yapalım.
public class IsYeri {

    // 1. Enum: İzin türlerini tanımlar. İsimlendirme standardına uygun hale getirildi.
    public enum IzinTuru {
        YILLIK, MAZERET, HASTALIK
    }

    // 2. IzinTalebi Sınıfı: Her bir izin talebini temsil eder.
    // Orijinal koddaki isim çakışması düzeltildi (Izin_Turu -> IzinTalebi)
    // ve değişkenler camelCase standardına çevrildi.
    public static class IzinTalebi {
        private final IzinTuru izinTuru;
        private final int gunSayisi;
        private final String aciklama;

        public IzinTalebi(IzinTuru izinTuru, int gunSayisi, String aciklama) {
            if (gunSayisi <= 0) {
                throw new IllegalArgumentException("Gün sayısı pozitif olmalıdır.");
            }
            this.izinTuru = izinTuru;
            this.gunSayisi = gunSayisi;
            this.aciklama = aciklama;
        }

        // Getter metotları
        public IzinTuru getIzinTuru() {
            return izinTuru;
        }

        public int getGunSayisi() {
            return gunSayisi;
        }

        public String getAciklama() {
            return aciklama;
        }
    }

    // 3. Calisan Sınıfı: Çalışan bilgilerini ve izin yönetimini içerir.
    // Tüm metotlar bu sınıfın içine doğru bir şekilde yerleştirildi.
    public static class Calisan {
        private String ad;
        private final String sicilNo;
        private int izinHakki;
        private final List<IzinTalebi> izinTalepleri;

        // Constructor hatası düzeltildi (void kaldırıldı).
        // Değişken isimleri (ad, sicilNo) tutarlı hale getirildi.
        public Calisan(String ad, String sicilNo, int izinHakki) {
            this.setAd(ad); // Setter metodu ile kontrol sağlanıyor.

            // Atama (=) yerine karşılaştırma (==) operatörü kullanıldı.
            if (sicilNo == null || sicilNo.trim().isEmpty()) {
                throw new IllegalArgumentException("Sicil numarası boş olamaz.");
            }
            this.sicilNo = sicilNo;
            this.setIzinHakki(izinHakki); // Setter metodu ile kontrol sağlanıyor.
            this.izinTalepleri = new ArrayList<>();
        }

        // Getter ve Setter Metotları
        public String getAd() {
            return ad;
        }

        public void setAd(String ad) {
            // trim().isEmpty() kontrolü ile boşluklardan oluşan isimler engellendi.
            if (ad == null || ad.trim().isEmpty()) {
                throw new IllegalArgumentException("İsim boş olamaz.");
            }
            this.ad = ad;
        }

        public String getSicilNo() {
            return sicilNo;
        }

        public int getIzinHakki() {
            return izinHakki;
        }

        // Değer atama (setter) ve değer okuma (getter) metotları ayrıldı.
        public void setIzinHakki(int izinHakki) {
            if (izinHakki < 0) {
                throw new IllegalArgumentException("İzin hakkı negatif olamaz.");
            }
            this.izinHakki = izinHakki;
        }
        
        // Dışarıdan listenin değiştirilmesini engellemek için unmodifiableList kullanmak iyi bir pratiktir.
        public List<IzinTalebi> getIzinTalepleri() {
            return Collections.unmodifiableList(izinTalepleri);
        }

        // İzin ekleme metodu
        public boolean izinTalebiEkle(IzinTalebi talep) {
            // Metot adı hatası düzeltildi (getIzinGun_Sayisi -> getGunSayisi)
            if (talep.getGunSayisi() <= this.izinHakki) {
                this.izinTalepleri.add(talep);
                this.izinHakki -= talep.getGunSayisi();
                System.out.println("✓ İzin talebi KABUL EDİLDİ: " + talep.getIzinTuru() + ", "
                        + talep.getGunSayisi() + " gün. Kalan izin: " + this.izinHakki);
                return true; // Başarılı durumda true dönmesi eklendi.
            } else {
                System.out.println("✗ İzin talebi REDDEDİLDİ: Yetersiz izin hakkı. (İstenen: "
                        + talep.getGunSayisi() + ", Mevcut: " + this.izinHakki + ")");
                return false;
            }
        }

        // Bilgileri gösterme metodu
        public void bilgileriGoster() {
            System.out.println("\n--- Çalışan Bilgileri ---");
            System.out.println("Çalışan Adı: " + this.ad);
            System.out.println("Sicil No: " + this.sicilNo);
            System.out.println("Kalan Yıllık İzin Hakkı: " + this.izinHakki + " gün");
            System.out.println("Geçmiş İzin Talepleri:");

            if (izinTalepleri.isEmpty()) {
                System.out.println("- Kayıtlı izin talebi bulunmamaktadır.");
            } else {
                for (IzinTalebi talep : this.izinTalepleri) {
                    // Metot adı hatası düzeltildi (getIzinGun_Sayisi -> getGunSayisi)
                    System.out.println("- " + talep.getIzinTuru() + ": " + talep.getGunSayisi() + " gün, Açıklama: "
                            + talep.getAciklama());
                }
            }
            System.out.println("------------------------\n");
        }
    }

    // Main metodu: Kodun çalışmasını test etmek için bir başlangıç noktası
    public static void main(String[] args) {
        // Bir çalışan oluşturalım.
        Calisan calisan1 = new Calisan("Ahmet Yılmaz", "1025", 20);
        calisan1.bilgileriGoster();

        // İzin talepleri oluşturalım.
        IzinTalebi talep1 = new IzinTalebi(IzinTuru.YILLIK, 10, "Yaz tatili");
        IzinTalebi talep2 = new IzinTalebi(IzinTuru.MAZERET, 2, "Taşınma");
        IzinTalebi talep3 = new IzinTalebi(IzinTuru.HASTALIK, 15, "Ameliyat"); // Bu talep reddedilecek.

        // Talepleri çalışana ekleyelim.
        calisan1.izinTalebiEkle(talep1);
        calisan1.izinTalebiEkle(talep2);
        calisan1.izinTalebiEkle(talep3); // Yetersiz izin hakkı nedeniyle reddedilecek.

        // Çalışanın son durumunu görelim.
        calisan1.bilgileriGoster();
    }
}