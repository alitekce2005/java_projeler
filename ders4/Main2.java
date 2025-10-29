package ders4;

public class Main2 {

    static public class Medya{
        String baslik;
        int yayinYili;

        public Medya (String baslik, int yayinYili){
            this.baslik = baslik;
            this.yayinYili = yayinYili;
        }
        void oynat(){
            System.out.println("Medya oynatiliyor");
        }
        void bilgiGoster(){
            System.out.println("Baslik: " + baslik + ", Yayin Yili" + yayinYili);
        }
    }

    static class Film extends  Medya{
        String yonetmen;
        public Film(String baslik, int yayinYili, String yonetmen){
            super(baslik, yayinYili);
            this.yonetmen = yonetmen;
        }

        @Override
        void oynat() {
            System.out.println("Film oynatiliyor: " + baslik + " Yonetmen: " + yonetmen);
        }

        @Override
        void bilgiGoster() {
            System.out.println("Tur: Film");
        }
    }

    static class Podcast extends  Medya{
        String konuk;
        public Podcast(String baslik, int yayinYili, String konuk){
            super(baslik, yayinYili);
            this.konuk = konuk;
        }

        @Override
        void oynat() {
            System.out.println("Podcast oynatiliyor: " + baslik + " Konuk: " + konuk);
        }

        @Override
        void bilgiGoster() {
            System.out.println("Tur: Podcast");
        }
    }

    public static void main(String[] args) {
        Medya[] medyaListesi = {new Film("Film1", 2018, "Abdul Basit Adam"),
            new Podcast( "Teknoloji Sohbetleri", 2007, "Selcuk Bayraktar")};

    }
}