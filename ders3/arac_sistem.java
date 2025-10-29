public class arac_sistem {

    static class Arac {
        String marka;
        String model;
        int yil;
        String renk;
        int adet;

        public Arac(String marka, String model, int yil, String renk, int adet) {// Constructor - Kurucu Metot
            this.marka = marka;
            this.model = model;
            this.yil = yil;
            this.renk = renk;
            this.adet = adet;
        }

        public int stokDurumu(Arac arac, String marka, String model, int yil, String renk, int adet) {
            if (arac.marka == marka && arac.model == model && arac.yil == yil && arac.renk == renk) {
                return arac.adet;
            } else {
                System.out.println("Araç bulunamadı.");
                return 0;
            }
        }

        public void bilgileriGoster() {
            System.out.println("Marka: " + marka);
            System.out.println("Model: " + model);
            System.out.println("Yıl: " + yil);
            System.out.println("Renk: " + renk);
            System.out.println("Adet: " + adet);
        }
    }

    static class Sedan extends Arac {
        String koltukSayisi = "5";

        public Sedan(String marka, String model, int yil, String renk, int adet, String koltukSayisi) {
            super(marka, model, yil, renk, adet);
            this.koltukSayisi = koltukSayisi;
        }

        @Override
        public void bilgileriGoster() {
            super.bilgileriGoster();
            System.out.println("Koltuk Sayısı: " + koltukSayisi);
        }
    }

    static class Kamyonet extends Arac {
        double yukKapasitesi;

        public Kamyonet(String marka, String model, int yil, String renk, int adet, double yukKapasitesi) {
            super(marka, model, yil, renk, adet);
            this.yukKapasitesi = yukKapasitesi;
        }

        @Override
        public void bilgileriGoster() {
            super.bilgileriGoster();
            System.out.println("Yük Kapasitesi: " + yukKapasitesi + " ton");
        }
    }

    public static void main(String[] args) {
        System.out.println("Araç Yönetim Sistemi\n");
        // Sedan nesneleri oluşturma
        Sedan sedan1 = new Sedan("Toyota", "Corolla", 2022, "Beyaz", 15, "5");
        Sedan sedan2 = new Sedan("Honda", "Civic", 2023, "Siyah", 0, "4");

        // Kamyonet nesneleri oluşturma
        Kamyonet kamyonet1 = new Kamyonet("Ford", "Transit", 2021, "Mavi", 5, 3.5);
        Kamyonet kamyonet2 = new Kamyonet("Mercedes", "Sprinter", 2022, "Gri", 2, 4.2);

        // Araç bilgilerini gösterme
        /*System.out.println("---------------------------------");
        System.out.println("--- Sedan 1 Bilgileri ---");
        sedan1.bilgileriGoster();

        System.out.println("\n---------------------------------");
        System.out.println("--- Sedan 2 Bilgileri ---");
        sedan2.bilgileriGoster();

        System.out.println("\n---------------------------------");
        System.out.println("--- Kamyonet 1 Bilgileri ---");
        kamyonet1.bilgileriGoster();

        System.out.println("\n---------------------------------");
        System.out.println("--- Kamyonet 2 Bilgileri ---");
        kamyonet2.bilgileriGoster();

        // Stok durumu kontrolü
        System.out.println("\n---------------------------------");
        System.out.println("--- Stok Durumu Kontrolü ---");
        int sedan1Stok = sedan1.stokDurumu(sedan1, "Toyota", "Corolla", 2022, "Beyaz", 15);
        System.out.println("Sedan 1 Stok Adedi: " + sedan1Stok);

        System.out.println("\n---------------------------------");
        int kamyonet2Stok = kamyonet2.stokDurumu(kamyonet2, "Mercedes", "Sprinter", 2022, "Gri", 2);
        System.out.println("Kamyonet 2 Stok Adedi: " + kamyonet2Stok);*/

        // Polimorfizm örneği
        System.out.println("--- Polimorfizm Örneği ---");
        Arac[] araclar = { sedan1, sedan2, kamyonet1, kamyonet2 };

        for (Arac arac : araclar) {
            arac.bilgileriGoster();
            System.out.println("---");
        }
    }

}
