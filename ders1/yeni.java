public class yeni {

    public static void main(String[] args) {
        AraSatir();

        Ögrenci ogrenci1 = new Ögrenci("Ali", "Veli", 20, 85);
        ogrenci1.bilgileriYazdir();
        BoslukAtici();
        ogrenci1.setNot(120);
        AraSatir();
        ogrenci1.bilgileriYazdir();
        BoslukAtici();
        AraSatir();

    }

    static void AraSatir() {
        System.out.println("<------------------------------->");
    }

    static void BoslukAtici() {
        System.out.println();
    }

    public static class Ögrenci {
        String ad;
        String soyad;
        int yas;
        int not;

        public Ögrenci(String ad, String soyad, int yas, int not) {
            this.ad = ad;
            this.soyad = soyad;
            this.yas = yas;
            this.not = not;
        }

        public String getAd() {
            return ad;
        }

        public void setAd(String ad) {
            this.ad = ad;
        }

        public String getSoyad() {
            return soyad;
        }

        public void setSoyad(String soyad) {
            this.soyad = soyad;
        }

        public int getYas() {
            return yas;
        }

        public void setYas(int yas) {
            this.yas = yas;
        }

        public int getNot() {
            return not;
        }

        public void setNot(int not) {
            if (not >= 0 && not <= 100) {
                this.not = not;
            } 

            else {
                System.out.println("Not 0-100 arasında olmalıdır!");
            }
        }

        public void bilgileriYazdir() {
            System.out.println("Ad: " + ad);
            System.out.println("Soyad: " + soyad);
            System.out.println("Yaş: " + yas);
            System.out.println("Not: " + not);
        }

    }
}
