import java.util.ArrayList;
import java.util.List;

public class Main3 {
    static class Kullanici{
        String ad;
        boolean admin;
        public Kullanici(String ad,boolean admin){
            this.ad=ad;
            this.admin=admin;
        }
    }
    @FunctionalInterface
    interface GirisOlayi{
        void calistir(Kullanici k);
    }
    static class GirisSistemi{
        private List<GirisOlayi> giris = new ArrayList<>();
        void girisEkle(GirisOlayi olay){
            giris.add(olay);
        }
        void girisYap(Kullanici k){
            System.out.println("Giris Yapıldı : " + k.ad);
            for (GirisOlayi olay : giris){
                olay.calistir(k);
            }
        }
    }
    public class LamdaOrnek{
        static void logAl(Kullanici k){
            System.out.println("[LOG] Kullanici Giris Yaptı:" + k);
        }
    }

    public static void main(String[] args){
        GirisSistemi sistem = new GirisSistemi();
        sistem.girisEkle(k -> System.out.println("Hoş Geldin" + k.ad) );
        sistem.girisEkle(LamdaOrnek::logAl);
        sistem.girisEkle(k -> {
            if(k.admin){
                System.out.println("Admin yetkileri acık.");
            }else {
                System.out.println("Standart kullanici yetkileri acık");
            }
        });
        sistem.girisEkle(k -> new Thread(()-> {
            try {
                Thread.sleep(1000);
                System.out.println("Arkaplan Kontrolü tamamlandi: " + k.ad);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start()
        );

        Kullanici k1=new Kullanici("Ali123",false);
        Kullanici k2=new Kullanici("Admin123",true);
        sistem.girisYap(k1);
        sistem.girisYap(k2);
    }
}