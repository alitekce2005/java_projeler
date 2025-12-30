// lamda ifadesiye tek metodu olan bir arayüzü kullanabiliriz
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    interface Siparisİslem{
        void uygula(Siparis s);
    }
    public static class Siparis {
        String musteri;
        double tutar;
        boolean onaylandi;
        boolean kargoyaVerildi;
        Siparis(String musteri,double tutar){
            this.musteri=musteri;
            this.tutar=tutar;
            this.onaylandi=false;
            this.kargoyaVerildi=false;
        }
        @Override
        public String toString() {
            return "Müşteri : " + musteri+
                    "| Tutar: " + tutar+
                    "| Onay : " + onaylandi+
                    "| Kargo: " + kargoyaVerildi;
        }
    }
    public class LamdaSipariş{
        static void siparisIsle(Siparis siparis, List<Siparisİslem> islemler){
            for (Siparisİslem islem:islemler){
                islem.uygula(siparis);
            }
        }
    }
    public static void main(String[] args){
        Siparis s1 = new Siparis("Ali",1200);
        Siparis s2 = new Siparis("Ayse",2000);
        Siparisİslem onayla = s -> s.onaylandi=true;
        Siparisİslem indirimUygula = s -> {
                                                    if(s.tutar>1000){
                                                        s.tutar*=0.90;
                                                    }
        };

        Siparisİslem kargoyaVer  = s -> {
                                                if(s.onaylandi){
                                                    s.kargoyaVerildi=true;
                                                }
        };

        List<Siparisİslem> islemSirasi = new ArrayList<>();
        islemSirasi.add(onayla);
        islemSirasi.add(indirimUygula);
        islemSirasi.add(kargoyaVer);

        LamdaSipariş.siparisIsle(s1,islemSirasi);
        LamdaSipariş.siparisIsle(s2,islemSirasi);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}