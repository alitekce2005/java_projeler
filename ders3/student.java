public class student {

    public static class Kisi {
        protected String isim;
        protected int yas;

        public Kisi(String isim, int yas) {
            this.isim = isim;
            this.yas = yas;
            System.out.println("Kisi Sınıfı Yapıcı Metodu Çalıştı");
        }

        public void bilgileriGoster() {
            System.out.println("İsim: " + isim);
            System.out.println("Yaş: " + yas);
        }
    }
    
    public static class Ogrenci extends Kisi {
        
        private String sinif;
        
        public Ogrenci(String isim, int yas, String sinif) {
            super(isim, yas);
            this.sinif = sinif;
            System.out.println("Öğrenci Sınıfı Yapıcı Metodu Çalıştı");
        }
        
        @Override
        public void bilgileriGoster() {
            super.bilgileriGoster();
            System.out.println("Sınıf: " + sinif);
            System.out.println("---------------------");
        }
    }

    public static class Ogretmen extends Kisi {

        private String brans;

        public Ogretmen(String isim, int yas, String brans) {
            super(isim, yas);
            this.brans = brans;
            System.out.println("Öğretmen Sınıfı Yapıcı Metodu Çalıştı");
        }

        @Override
        public void bilgileriGoster() {
            super.bilgileriGoster();
            System.out.println("Branş: " + brans);
            System.out.println("---------------------");
        }
    }

    public static void main(String[] args) {
        System.out.println("---------------------");
        Ogrenci ogrenci1 = new Ogrenci("Ayça", 15, "9-A");
        ogrenci1.bilgileriGoster();

        Ogretmen ogretmen1 = new Ogretmen("Ali Hoca", 40, "İngilizce");
        ogretmen1.bilgileriGoster();

    }
}
