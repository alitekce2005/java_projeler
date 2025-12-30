//button.setOnclickListener(new ActionListener){
//Override
//public void actionPerformed(Action e){
//system.out.println("Tıklandı")
//  }
//};
//button.setOnClickListener(e->System.out.println("Tıklandı"););
//Lambda

import java.util.ArrayList;
import java.util.List;

public class Main {
    interface GecmeKurali{
        boolean gectiMi(int vize,int fin);
    }
    static class Ogrenci{
        String ad;int vize;int fin;
        Ogrenci(String ad,int vize,int fin){
            this.ad = ad;
            this.vize=vize;
            this.fin = fin;
        }
    }
    public class LambdaNotOrnek{
        static void OgrencileriDegerlendir(List<Ogrenci> ogrenciler,GecmeKurali kural){
            for (Ogrenci o:ogrenciler){
                if(kural.gectiMi(o.vize,o.fin)){
                    System.out.println(o.ad+" -> Geçti");
                }else {
                    System.out.println(o.ad+" -> Kaldi");
                }
            }
        }
    }
    public static void main(String[] args){
        List<Ogrenci> liste = new ArrayList<>();
        liste.add(new Ogrenci("Ali",60,80));
        liste.add(new Ogrenci("Ayşe",60,75));
        liste.add(new Ogrenci("Mehmet",30,40));

        System.out.println("Standart Geçme Kuralı:");
        LambdaNotOrnek.OgrencileriDegerlendir(liste,((vize, fin)->(vize*0.4+fin*0.6)>=60));

        System.out.println("Final Ağırlıklı Geçme Kuralı :");
        LambdaNotOrnek.OgrencileriDegerlendir(liste,(vize,fin)->(fin>=60));
    }
}