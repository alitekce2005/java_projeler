import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main3 {

    interface IslemStratejisi<T> {
        T hesapla(List<Integer> notlar);
    }

    static class OrtalamaStrateji implements IslemStratejisi<Double> {

        @Override
        public Double hesapla(List<Integer> notlar) {
            return notlar.stream().mapToInt(Integer::intValue).average().orElse(0);

        }

    }

    static class EnYuksekNotStrateji implements IslemStratejisi<Integer> {

        @Override
        public Integer hesapla(List<Integer> notlar) {
            return notlar.stream().max(Integer::compareTo).orElse(00);

        }

    }

    static abstract class Ogrenci {
        protected String ad;
        protected int numara;
        protected List<Integer> notlar;

        public Ogrenci(String ad, int numara, List<Integer> notlar) {
            this.ad = ad;
            this.numara = numara;
            this.notlar = notlar;
        }
        // Alt sınıfların kullanabilmesi için yeni constructor eklendi.
        public Ogrenci(String ad, int numara) {
            this(ad, numara, new ArrayList<>());
        }

        public void notEkle(int not) {
            notlar.add(not);
        }

        public abstract void bilgiGoster();

        public final List<Integer> tumnotlar() {
            return Collections.unmodifiableList(notlar);

        }

    }

    static class IlkogretimOgrencisi extends Ogrenci{

        public IlkogretimOgrencisi(String ad, int numara) {
            super(ad, numara);
        }

    @Override
    public void bilgiGoster() {
        System.out.println("[İlköğretim]" + ad + "(" + numara + ")");
    }

    }

    static class UniversiteOgrencisi extends Ogrenci {
        public UniversiteOgrencisi(String ad, int numara) {
        super(ad, numara);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("[Üniversite]" + ad + "(" + numara + ")");
    }

    }

    static abstract class OgrenciFabrikasi{
        public abstract Ogrenci ogrenciOlustur(String ad, int numara);
    }

    static class IlkogretimOgrenciFabrikasi extends OgrenciFabrikasi {
        @Override
        public Ogrenci ogrenciOlustur(String ad, int numara) {
            return new IlkogretimOgrencisi(ad, numara);
        }
    }

    static class UniversiteOgrenciFabrikasi extends OgrenciFabrikasi {
        @Override
        public Ogrenci ogrenciOlustur(String ad, int numara) {
            return new UniversiteOgrencisi(ad, numara);
        }

    }

    public static void main(String[] args) {
        OgrenciFabrikasi fab1=new IlkogretimOgrenciFabrikasi();
        OgrenciFabrikasi fab2=new UniversiteOgrenciFabrikasi();

        Ogrenci o1=fab1.ogrenciOlustur("Ali",101);
        Ogrenci o2=fab2.ogrenciOlustur("Ayşe",500);

        o1.notEkle(70);
        o1.notEkle(80);
        o1.notEkle(85);

        o2.notEkle(90);
        o2.notEkle(80);
        o2.notEkle(95);

        IslemStratejisi<Double> ortalamaStrateji=new OrtalamaStrateji();
        IslemStratejisi<Integer> enYuksekNotStrateji=new EnYuksekNotStrateji();

        o1.bilgiGoster();
        System.out.println("Ortalama:" + ortalamaStrateji.hesapla(o1.tumnotlar()));
        System.out.println("En yüksek not:" + enYuksekNotStrateji.hesapla(o1.tumnotlar()));
        System.out.println();

        o2.bilgiGoster();
        System.out.println("Ortalama:" + ortalamaStrateji.hesapla(o2.tumnotlar()));
        System.out.println("En yüksek not:" + enYuksekNotStrateji.hesapla(o2.tumnotlar()));
        System.out.println();


    }
}
