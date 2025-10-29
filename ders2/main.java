public class main {

    public static class Calisan {
        protected String isim;
        protected int maas;

        public Calisan(String isim, int maas) {
            this.isim = isim;
            this.maas = maas;
        }

        public void bilgileriGoster() {
            System.out.println("İsim: " + isim);
            System.out.println("Maaş: " + maas);
        }
    }

    public static class Yonetici extends Calisan {
        private int sorumluDS;

        public Yonetici(String isim, int maas, int sorumluDS) {
            super(isim, maas);
            this.sorumluDS = sorumluDS;
        }

        @Override
        public void bilgileriGoster() {
            super.bilgileriGoster();
            System.out.println("Sorumlu DS: " + sorumluDS);
        }
    }

    public static void main(String[] args) {
        Yonetici yonetici = new Yonetici("Ahmet", 100000, 5);
        yonetici.bilgileriGoster();
    }

}