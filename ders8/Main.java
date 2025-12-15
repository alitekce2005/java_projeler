import java.util.*;

public class Main {

    public static class KayıtİşlemeSistemi {
        public void kayıtlarıİşle(List<String> kayıtlar, String dosyaadı) {
            String dosyaTuru = dosyaadı.substring(dosyaadı.lastIndexOf(".") + 1);
            class DosyaDenetleyicisi {
                public boolean formatUygunmu() {
                    System.out.println("[Format Kontrol] Dosya: " + dosyaadı);
                    if (!dosyaTuru.equalsIgnoreCase("csv")) {
                        System.out.println("Sistem sadece csv türü dosya kabul etmektedir");
                        return false;
                    }
                    System.out.println("[Format uygundur ");
                    return true;
                }

            }
            DosyaDenetleyicisi denetleyicisi = new DosyaDenetleyicisi();
            if (!denetleyicisi.formatUygunmu()) {
                return;
            }
            class KayıtIleyici {
                private final List<String> temizkayıtlar = new ArrayList<>();

                public List<String> işle() {
                    System.out.println("[İşlem] Kayıt işlemi başladı...");
                    for (String satır : kayıtlar) {
                        System.out.println("İşlenen satır: " + satır);
                        String[] parçalar = satır.split(",");

                        if (parçalar.length == 2) {
                            System.out.println(" Hatalı kayıt formatı (2 alan bekleniyor).");
                            continue;
                        }
                        String isim = parçalar[0].trim();
                        String yasstr = parçalar[1].trim();

                        if (isim.length() < 2) {
                            System.out.println(" Geçersiz isim");
                            continue;
                        }
                        try {
                            int yas = Integer.parseInt(yasstr);
                            if (yas < 0 || yas > 120) {
                                System.out.println("Gerçek dışı yaş ");
                                continue;

                            }
                        } catch (NumberFormatException e) {
                            System.out.println(" Yaş sayıya dönüştürülemedi");
                            continue;
                        }
                        System.out.println("Kayıt kabul edildi.");
                        temizkayıtlar.add(satır);
                    }
                    return temizkayıtlar;
                }

            }
            KayıtIleyici işleyici = new KayıtIleyici();
            List<String> temizliste = işleyici.işle();

            class RaporYazıcı {
                public void raporoluştur() {
                    System.out.println(" Dosya adı:" + dosyaadı);
                    System.out.println("Dosya Türü: " + dosyaTuru);
                    System.out.println(" Toplam Kayıt:" + kayıtlar.size());
                    System.out.println(" Temizlenen kayıt:" + temizliste.size());
                    System.out.println("Başarı oranı:% " + (100 * temizliste.size() / kayıtlar.size()));
                }
            }
            RaporYazıcı rapor = new RaporYazıcı();
            rapor.raporoluştur();
        }
    }

    public static void main(String[] args) {
        KayıtİşlemeSistemi sistem = new KayıtİşlemeSistemi();
        List<String> kayıtlar = List.of("Ali,30", "A,40", "Ayşe,abc", "Mehmet,25");
        sistem.kayıtlarıİşle(kayıtlar, "veri.csv");
    }
}