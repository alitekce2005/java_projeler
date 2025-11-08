package ders5;

public class Main {
    static class Arac {
        String model;
        int hiz;

        public Arac(String model, int hiz) {
            this.model = model;
            this.hiz = hiz;
        }

        void HareketEt() {
            System.out.println(model + " aracı hareket ediyor.");
        }

        static class Bisiklet extends Arac {
            boolean elektrikli;

            public Bisiklet(String model, int hiz, boolean elektrikli) {
                super(model, hiz);
                this.elektrikli = elektrikli;
            }

            void PedalCevır() {
                System.out.println(model + " bisikleti pedal çeviriyor.");
            }

            void elektrikli_surus() {
                if (elektrikli) {
                    System.out.println(model + " elektrikli modda sürülüyor.");
                } else {
                    System.out.println(model + " manuel modda sürülüyor.");
                }
            }

        }

        static class Scooter extends Arac {
            int pil;

            public Scooter(String model, int hiz, int pil) {
                super(model, hiz);
                this.pil = pil;
            }

            public void pil_durumu() {
                System.out.println(model + " scooter'ın pil durumu: %" + pil);
            }

            void elektrikli_surus() {
                if (pil <= 0) {
                    System.out.println(model + " scooter'ın pili bitmiş.");
                } else {
                    System.out.println(model + " scooterı elektrikli modda sürülüyor.");
                }
            }
        }

        static class AracBakim {
            static void BakimYap(Arac arac) {
                System.out.println(arac.model + " aracına bakım yapılıyor.");
                if (arac instanceof Bisiklet) {
                    Bisiklet bisiklet = (Bisiklet) arac;
                    System.out.println("Bisikletbakımı yapılıytr");
                    bisiklet.PedalCevır();
                    bisiklet.elektrikli_surus();
                    System.out.println("Fren kontrolü yapıldı.");
                } else if (arac instanceof Scooter) {
                    Scooter scooter = (Scooter) arac;
                    System.out.println("Scooter bakımı yapılıyor");
                    scooter.elektrikli_surus();
                    scooter.pil_durumu();
                    System.out.println("Pil kontrolü yapıldı.");
                } else {
                    System.out.println("Bilinmeyen araç türü.");
                }
                System.out.println("Bakım tamamlandı.");
            }
        }

        public static void main(String[] args) {
            System.out.println("Araç Bakım Sistemi");
            System.out.println("------------------");
            Arac[] araclar = { new Bisiklet("Mountain Bike", 25, false),
                    new Scooter("Xiamio M365", 30, 80),
                    new Bisiklet("E-Bike", 35, true),
                    new Scooter("Segway", 28, 5),
                    new Arac("Genel Araç", 40)
            };

            AracBakim bakim = new AracBakim();
            for (Arac arac : araclar) {
                arac.HareketEt();
                bakim.BakimYap(arac);
                System.out.println();
            }
        }
    }
}
