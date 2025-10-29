package ders4;

public class Main3 {

    static class VeriTabaniIslemi{
        void calistir(){
            System.out.println("Veri tabani islemi yapiliyor.");
        }
    }

    static class EklemeIslemi extends VeriTabaniIslemi{
        String tablo;
        String veri;
        public EklemeIslemi(String tablo, String veri){
            this.tablo = tablo;
            this.veri = veri;
        }

        @Override
        void calistir() {
            System.out.println(tablo + " tablosuna" + veri + " verisi eklendi");
        }
    }

    static class SilmeIslemi extends VeriTabaniIslemi{
        String tablo;
        int id;
        public SilmeIslemi(String tablo, int id){
            this.tablo = tablo;
            this.id = id;
        }

        @Override
        void calistir() {
            System.out.println(tablo + "tablosundanID" + id + "silindi.");
        }
    }

    static class GuncellemeIslemi extends VeriTabaniIslemi{
        String tablo;
        int id;
        String yeniVeri;

        public GuncellemeIslemi(String tablo, int id, String yeniVeri){
            this.tablo = tablo;
            this.id = id;
            this.yeniVeri = yeniVeri;
        }

        @Override
        void calistir() {
            System.out.println(tablo + " tablosunda ID " + id + " olan veri " + yeniVeri + "olarak guncellendi");
        }
    }

    static class VeriTabaniYonetimi{
        void islemCalistir(VeriTabaniIslemi islem){
            islem.calistir();
        }
    }
    public static void main (String[] args){
        VeriTabaniYonetimi yonetim = new VeriTabaniYonetimi();
        VeriTabaniIslemi[] islemler = {new EklemeIslemi("Musteriler", "Ali Veli"),
                new SilmeIslemi("Urunler", 45),
                new GuncellemeIslemi("Siparisler", 123, "TeslimEdildi") };

        for(VeriTabaniIslemi islem:islemler){
            yonetim.islemCalistir(islem);
        }
    }
}