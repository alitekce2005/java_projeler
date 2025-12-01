package dersyedi;
public class main2 {

    public class BankaSistemi {
        private static int GenelIslemSayaci;
        private static double BankaGenelKasasi;

        public static class ParaTransferiModülü {
            public static class TrasferTalebi {
                private String gonderenHesap;
                private String aliciHesap;
                private double miktar;
                private String aciklama;

                public TrasferTalebi(String gonderenHesap, String aliciHesap, double miktar, String aciklama) {
                    this.gonderenHesap = gonderenHesap;
                    this.aliciHesap = aliciHesap;
                    this.miktar = miktar;
                    this.aciklama = aciklama;
                }

                public void IslemiGerceklestir() {
                    GenelIslemSayaci++;
                    BankaGenelKasasi -= miktar;
                    System.out.println("------------------------------------\nTransfer İşlemi:");
                    System.out.println("Gönderen Hesap: " + gonderenHesap);
                    System.out.println("Alıcı Hesap: " + aliciHesap);
                    System.out.println("Miktar: " + miktar);
                    System.out.println("Açıklama: " + aciklama);
                    System.out.println("Genel İşlem Sayacı: " + GenelIslemSayaci);
                    System.out.println(
                            "Banka Genel Kasası: " + BankaGenelKasasi);
                }
            }
        }

        public static class KrediAnalizi {
            public static class MusteriVerisi {
                private String adSoyad;
                private int krediSkoru;
                private double gelir;
                private double mevcutBorc;

                public MusteriVerisi(String adSoyad, int krediSkoru, double gelir, double mevcutBorc) {
                    this.adSoyad = adSoyad;
                    this.krediSkoru = krediSkoru;
                    this.gelir = gelir;
                    this.mevcutBorc = mevcutBorc;
                }

                public void riskAnaliziYap() {
                    GenelIslemSayaci++;
                    double borOrani = mevcutBorc / gelir;
                    System.out.println("------------------------------------\nKredi Analizi:");
                    System.out.println("Müşteri Ad Soyad: " + adSoyad);
                    System.out.println("Müşteri Kredi Skoru: " + krediSkoru);
                    System.out.println("Müşteri Gelir oranı: " + borOrani);
                    if (krediSkoru > 700 && borOrani < 0.3) {
                        System.out.println("Kredi Durumu: Onaylandı");
                    } else {
                        System.out.println("Kredi Durumu: Reddedildi");
                    }
                }

                public static int getGenelIslemSayaci() {
                    return GenelIslemSayaci;
                }
            }

        }
    }

    public static void main(String[] args) {
        BankaSistemi.ParaTransferiModülü.TrasferTalebi transfer1 = new BankaSistemi.ParaTransferiModülü.TrasferTalebi(
                "TR1234567890", "TR0987654321", 1500.0, "Kira Ödemesi");
        transfer1.IslemiGerceklestir();

        BankaSistemi.KrediAnalizi.MusteriVerisi musteri1 = new BankaSistemi.KrediAnalizi.MusteriVerisi(
                "Ayşe YILMAZ", 750, 8000.0, 2000.0);
        musteri1.riskAnaliziYap();

        System.out.println("-----------------------------------\nToplam İşlem Sayısı: "
                + BankaSistemi.KrediAnalizi.MusteriVerisi.getGenelIslemSayaci());
    }

}