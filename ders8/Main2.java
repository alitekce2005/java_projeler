public class Main2 {
    public static class OdemeIslemMerkezi {
        interface OdemeStratejisi {
            void öde(String musteriAdi, double tutar);

        }

        abstract static class IslemLogger {
            public abstract void logYaz(String mesaj);
        }

        public void odemeYap(String musteriAdi, double tutar, String odemeTipi) {
            String islemKOdu = "OD-" + System.currentTimeMillis();
            IslemLogger logger = new IslemLogger() {
                @Override
                public void logYaz(String mesaj) {
                    System.out.println("[LOG " + islemKOdu + "] " + mesaj);
                }
            };
            logger.logYaz("Ödeme İşlemi Başladı");
            OdemeStratejisi strateji = null;
            switch (odemeTipi) {
                case "Kredi Kartı":
                    strateji = new OdemeStratejisi() {
                        @Override
                        public void öde(String musteriAdi, double tutar) {
                            logger.logYaz("Kredi kartı ile ödeme alınıyor");
                            System.out.println("Kredi kartı ödemesi");
                            System.out.println("Müşteri adı:" + musteriAdi);
                            System.out.println("Gönderilen Tutar:" + tutar + "TL");
                            logger.logYaz("Kredi Kartı işlemi tamamlandı");
                        }
                    };
                    break;
                case "Banka Havalesi":
                    strateji = new OdemeStratejisi() {
                        @Override
                        public void öde(String musteriAdi, double tutar) {
                            logger.logYaz("Havale işlemi başlatıldı");
                            System.out.println("Banka havalesi");
                            System.out.println("Müşteri adı:" + musteriAdi);
                            System.out.println("Gönderilen Tutar:" + tutar + "TL");
                            logger.logYaz("Havale başarıyla gönderildi");
                        }
                    };
                    break;
                default:
                    logger.logYaz("Desteklenmeyen ödeme şekli: " + odemeTipi);
                    System.out.println("Geçersiz ödeme tipi");
                    break;
            }

            if (strateji != null) {
                strateji.öde(musteriAdi, tutar);
            }
            logger.logYaz("Ödeme işlemi sona erdi");
        }

    }

    public static void main(String[] args) {
        OdemeIslemMerkezi odemeSistemi = new OdemeIslemMerkezi();
        System.out.println("--------------------");
        odemeSistemi.odemeYap("Ahmet", 2500, "Kredi Kartı");
        System.out.println("--------------------");
        odemeSistemi.odemeYap("Ayşe", 900, "Banka Havalesi");
        System.out.println("--------------------");
        odemeSistemi.odemeYap("Ali", 1500, "Bitcoin");
    }
}
