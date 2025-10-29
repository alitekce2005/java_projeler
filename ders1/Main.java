public class Main {
    public static void main(String[] args) {
        AraSatir();

        Kitap Kitabimiz = new Kitap("Karayip Korsanlar", "Jack Sparrow", 350);

        Kitabimiz.bilgileriYazdir();

        BoslukAtici();
        AraSatir();

        Kitap yenKitap = new Kitap("Hobbit", "J.R.R. Tolkien", 250);
        yenKitap.bilgileriYazdir();

        BoslukAtici();
        AraSatir();

        // #region Nesne Oluşturma ve Bilgi Yazdırma
        /*
         * Kitap kitap1 = new Kitap();
         * kitap1.ad = "Suç ve Ceza";
         * kitap1.yazar = "Fyodor Dostoyevski";
         * kitap1.sayfaSayisi = 430;
         * kitap1.bilgileriYazdir();
         * 
         * BoslukAtici();
         * AraSatir();
         */
        // #endregion

        
    }

    static void AraSatir() {
        System.out.println("<------------------------------->");
    }

    static void BoslukAtici() {
        System.out.println();
    }

    public static class Kitap {
        String ad;
        String yazar;
        int sayfaSayisi;

        public Kitap() {
        }

        public Kitap(String ad) {
            this.ad = ad;
        }

        public Kitap(String ad, String yazar, int sayfaSayisi) {
            this.ad = ad;
            this.yazar = yazar;
            this.sayfaSayisi = sayfaSayisi;
        }

        public void bilgileriYazdir() {
            System.out.println("Kitap Adi: " + ad);
            System.out.println("Yazari: " + yazar);
            System.out.println("Sayfa Sayisi: " + sayfaSayisi);

        }
    }
}
