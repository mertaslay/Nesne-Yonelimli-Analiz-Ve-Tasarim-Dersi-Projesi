package veritabani.Builder;

public class kullaniciDogrula {

        private String kullaniciAdi, sifre;


        private kullaniciDogrula(Builder builder) {
            this.kullaniciAdi = builder.kullaniciAdi;
            this.sifre = builder.sifre;
        }

        public String getKullaniciAdi() {
            return kullaniciAdi;
        }

        public String getSifre() {
            return sifre;
        }

        public static class Builder {
            private String kullaniciAdi, sifre;

            public Builder KullaniciAdi(String kullaniciAdi) {
                this.kullaniciAdi = kullaniciAdi;
                return this;
            }

            public Builder Sifre(String sifre) {
                this.sifre = sifre;
                return this;

            }
            public kullaniciDogrula build() {
                return new kullaniciDogrula(this);
            }

            }
        }



