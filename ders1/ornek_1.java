import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ornek_1 {
    enum IzinTuru {
        Yillik_Izin,
        Hastalik_Izni,
        Mazeret_Izni
    }

    static final class IzinTalebi {
        private final IzinTuru izinTuru;
        private final int gunSayisi;
        private final String aciklama;

        public IzinTalebi(IzinTuru izinTuru, int gunSayisi, String aciklama) {
            if (gunSayisi <= 0) {
                throw new IllegalArgumentException("Gun sayisi sifirdan buyuk olmalidir.");
            }
            this.izinTuru = izinTuru;
            this.gunSayisi = gunSayisi;
            this.aciklama = aciklama;
            
        }
        
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
        public static class Calisan {
            private String isim;
            private final String sicilNo;
            private int yillikIizinHakki;
            private final List<IzinTalebi> izinTalepleri;

            public Calisan(String isim, String sicilNo, int yillikIizinHakki) {
                setIsim(isim);
                if (sicilNo == null || sicilNo.isEmpty()) {
                    throw new IllegalArgumentException("Sicil no bos olamaz.");
                }
                this.sicilNo = sicilNo;
                setYillikIzinHakki(yillikIizinHakki);
                this.izinTalepleri = new ArrayList<>();

            }

            public String getIsim() {
                return isim;
            }

            public void setIsim(String isim) {
                if (isim == null || isim.isEmpty()) {
                    throw new IllegalArgumentException("Isim bos olamaz.");
                }
                this.isim = isim;
            }

            public String getSicilNo() {
                return sicilNo;
            }

            public int getYillikIzinHakki() {
                return yillikIizinHakki;
            }

            public void setYillikIzinHakki(int yillikIzinHakki) {
                if (yillikIzinHakki < 0) {
                    throw new IllegalArgumentException("Yillik izin hakki sifirdan kucuk olamaz.");
                }
                this.yillikIizinHakki = yillikIzinHakki;
            }

            public List<IzinTalebi> getIzinTalepleri() {
                return Collections.unmodifiableList(izinTalepleri);
            }

            public boolean izinTalebiEkle(IzinTalebi talep) {
                if (talep.getGunSayisi() <= yillikIizinHakki) {
                    izinTalepleri.add(talep);
                    yillikIizinHakki -= talep.getGunSayisi();
                    System.out.println("Izin talebi kabul edildi: " + talep.getAciklama());
                    if (talep.getIzinTuru() == IzinTuru.Yillik_Izin) {
                        yillikIizinHakki -= talep.getGunSayisi();
                    }
                    return true;
                } else {
                    System.out.println("Yetersiz izin hakki.");
                    return false;
                }
            }

            public void bilgileriGöster() {
                System.out.println("Calisan: " + getIsim());
                System.out.println("Sicil No: " + getSicilNo());
                System.out.println("Yillik Izin Hakki: " + getYillikIzinHakki() + " gun");
                System.out.println("Izin Talepleri:");
                for (IzinTalebi talep : izinTalepleri) {
                    System.out.println("- " + talep.getIzinTuru() + ": " + talep.getGunSayisi() + " gun, Aciklama: "
                            + talep.getAciklama());
                }
            }
        
        }
        public static void main(String[] args) {
            System.out.println("=== Calisan ve Izin Talebi Ornegi ===");
            Calisan calisan = new Calisan("Ahmet Yilmaz", "12345", 15);
            //Calisan calisan2 = new Calisan("Mehmet Demir", "67890", 10);

            IzinTalebi talep1 = new IzinTalebi(IzinTuru.Yillik_Izin, 5, "Yaz tatili");
            IzinTalebi talep2 = new IzinTalebi(IzinTuru.Hastalik_Izni, 3, "Grip");
            IzinTalebi talep3 = new IzinTalebi(IzinTuru.Mazeret_Izni, 10, "Tasinma");

            System.out.println("<---------------------------->");
            calisan.izinTalebiEkle(talep1);
            calisan.izinTalebiEkle(talep2);
            calisan.izinTalebiEkle(talep3);

            //calisan2.izinTalebiEkle(talep1);

            System.out.println("<---------------------------->");
            calisan.bilgileriGöster();

            List<IzinTalebi> disTalepler = calisan.getIzinTalepleri();
            try {
                disTalepler.add(new IzinTalebi(IzinTuru.Mazeret_Izni, 2, "Ozel Sebep"));
            } catch (UnsupportedOperationException e) {
                System.out.println("Dışarıdan izin talepleri listesi değiştirilemez.");
            }

            try {
                calisan.setIsim("");
            } catch (IllegalArgumentException e) {
                System.out.println("İsim boş olamaz");
            }
            System.out.println("<---------------------------->");
            //calisan.bilgileriGöster();
        }
}