
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main3 {
    static abstract class SensorOlayDinleyici {
        public abstract void VeriOlustu(String sensor_adi, double deger);

        public abstract void HataOlustu(String sensor_adi, String hata_mesaji);

    }

    static abstract class Sensor {
        protected String sensorAdi;
        protected boolean aktif = false;
        protected List<SensorOlayDinleyici> dinleyiciler = new ArrayList<>();

        public Sensor(String sensorAdi) {
            this.sensorAdi = sensorAdi;
        }

        protected abstract double veriOku();

        protected abstract boolean veri_gecerli_mi(double veri);

        public final void oku_ve_isle() {
            if (!aktif) {
                bildirimHata("Sensor aktif değil.");
                return;
            }
            try {
                double veri = veriOku();
                if (veri_gecerli_mi(veri)) {
                    bildirimVeri(veri);
                } else {
                    bildirimHata("Geçersiz veri alındı.");
                }
            } catch (Exception e) {
                bildirimHata("Veri okuma hatası: " + e.getMessage());
            }
        }

        public void dinleyiciEkle(SensorOlayDinleyici dinleyici1) {
            dinleyiciler.add(dinleyici1);
        }

        protected void bildirimVeri(double veri) {
            for (SensorOlayDinleyici dinleyici1 : dinleyiciler) {
                dinleyici1.VeriOlustu(sensorAdi, veri);
                dinleyici1.VeriOlustu(sensorAdi, veri);
            }
        }

        protected void bildirimHata(String hata_mesaji) {
            for (SensorOlayDinleyici dinleyici1 : dinleyiciler) {
                dinleyici1.HataOlustu(sensorAdi, hata_mesaji);
            }
        }
    }

    static class SicaklikSensoru extends Sensor {
        private Random rnd = new Random();

        public SicaklikSensoru(String sensorAdi) {
            super("Sıcaklık Sensörü");
        }

        @Override
        protected double veriOku() {
            return rnd.nextDouble() * 80 - 20;
        }

        @Override
        protected boolean veri_gecerli_mi(double veri) {
            return veri >= -30 && veri <= 70;
        }
    }

    static class NemSensoru extends Sensor {
        private Random rnd = new Random();

        public NemSensoru() {
            super("Nem Sensörü");
        }

        @Override
        protected double veriOku() {
            return rnd.nextDouble() * 110;
        }

        @Override
        protected boolean veri_gecerli_mi(double veri) {
            return veri >= 0 && veri <= 100;
        }
    }

    public static void main(String[] args) {
        System.out.println("<><><><><> Sensör Sistemi <><><><><><>\n");
        SicaklikSensoru sicaklik = new SicaklikSensoru("Sıcaklık Sensörü");
        NemSensoru nem = new NemSensoru();

        SensorOlayDinleyici dinleyici = new SensorOlayDinleyici() {
            @Override
            public void VeriOlustu(String sensor_adi, double deger) {
                System.out.println(sensor_adi + " -> Veri: " + deger);
            }

            @Override
            public void HataOlustu(String sensor_adi, String hata_mesaji) {
                System.out.println(sensor_adi + " -> Hata: " + hata_mesaji);
            }
        };

        sicaklik.dinleyiciEkle(dinleyici);
        nem.dinleyiciEkle(dinleyici);

        for (int i = 0; i < 5; i++) {
            if (i > 0) {
                sicaklik.aktif = true;
                nem.aktif = true;
            }
            sicaklik.oku_ve_isle();
            nem.oku_ve_isle();
            System.out.println("----------------------------------");
        }

    }
}
