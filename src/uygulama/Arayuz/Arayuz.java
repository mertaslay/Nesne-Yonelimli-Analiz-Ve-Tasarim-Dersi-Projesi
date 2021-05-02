package uygulama.Arayuz;

import uygulama.isbirimleri.IEyleyici;
import uygulama.isbirimleri.ISıcaklıkAlgılayıcı;
import uygulama.observer.IObServer;
import veritabani.IKullaniciVeriTabaniServisi;
import veritabani.postgreSQL.KullaniciPostgreSQLSurucusu;

import java.util.Scanner;

public class Arayuz implements IArayuz, IObServer {
    Scanner input = new Scanner (System.in);
    //5 deneme hakki olan kullanici girisi
    @Override
    public boolean kullaniciGiris(){
        int girishakkı = 0;
        do{
            girishakkı++;
            System.out.println("Cihaz Başlatılıyor..");
            IKullaniciVeriTabaniServisi kullanici = KullaniciPostgreSQLSurucusu.getInstance();
            String kullaniciAdi = "";
            String sifre= "";
            System.out.println("İslem yapmak için bilgilerinizi giriniz..");
            System.out.println("Kullanıcı Adı: ");
            kullaniciAdi = input.next();
            System.out.println("Sifre: ");
            sifre = input.next();
            boolean sonuc = kullanici.kullaniciDogrula(kullaniciAdi,sifre);
            if (sonuc) {
                return true;
            }

        } while(girishakkı!=5);
        return false;
    }
    @Override
    public int islemSecimi(){
        int islem = 0;
        System.out.println("/------İŞLEMLER------/");
        System.out.println("|  1-Sıcaklık Göster |");
        System.out.println("|  2-Soğutucu Aç     |");
        System.out.println("|  3-Soğutucu Kapat  |");
        System.out.println("|  4-Çıkış           |");
        System.out.println("/--------------------/");
        islem= input.nextInt();
        if(islem==0){
            System.out.println("İşlem seçilemedi");
        }else{
            System.out.println("Seçilen işlem: "+islem);
        }
        return islem;

    }
    @Override
    public void sicaklik(ISıcaklıkAlgılayıcı sicaklikAlgilayici){
        sicaklikAlgilayici.sicaklikGonder();
    }
    @Override
    public void sogutucuAc(IEyleyici eyleyici){
        eyleyici.sogutucuAc();
    }
    @Override
    public void sogutucuKapat(IEyleyici eyleyici){
        eyleyici.sogutucuKapat();
    }
    @Override
    public void Cikis(){
        System.out.println("Arayüzden çıkış yapılıyor..");
    }
    @Override
    public void guncelle(int sicaklik){
        System.out.println("Sıcaklık değişimi güncellendi");
    }

}
