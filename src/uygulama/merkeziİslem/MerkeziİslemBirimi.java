package uygulama.merkeziİslem;

import uygulama.Arayuz.Arayuz;
import uygulama.Arayuz.IArayuz;
import uygulama.isbirimleri.Eyleyici;
import uygulama.isbirimleri.IEyleyici;
import uygulama.isbirimleri.ISıcaklıkAlgılayıcı;
import uygulama.isbirimleri.SıcaklıkAlgılayıcı;

public class MerkeziİslemBirimi implements IMerkeziİslemBirimi{
    IArayuz arayuz = new Arayuz();
    ISıcaklıkAlgılayıcı sicaklikAlgilayici= new SıcaklıkAlgılayıcı();
    IEyleyici eyleyici = new Eyleyici();

    @Override
    public boolean arayuzeGiris(){
        return arayuz.kullaniciGiris();
    }
    // arayuze giris yapıldıysa işlem seçimi tutar//
    @Override
    public int arayuzIleIslemSecimi(){
        return arayuz.islemSecimi();
    }
    //işlemimize göre metodu çağırıyor
    @Override
    public void islemYap(){
        if(arayuzeGiris()){
            int islem =0;
            do{
                islem = arayuzIleIslemSecimi();
                switch (islem){
                    case 1:
                        sicaklikGoster();
                        break;
                    case 2:
                        sogutucuAc();
                        break;
                    case 3:
                        sogutucuKapat();;
                        break;
                    case 4:
                        Cikis();
                        break;
                    default:
                        System.out.println("DOGRU GİRİS YAPINIZ");
                        break;
                }
            }while(islem!=4);
        }else{
            System.out.println("ARAYUZE GİRMEDEN İŞLEM YAPAMAZSINIZ");
        }
    }
    @Override
    public void sicaklikGoster(){
        arayuz.sicaklik(sicaklikAlgilayici);
    }
    @Override
    public void sogutucuAc(){
        arayuz.sogutucuAc(eyleyici);
    }
    @Override
    public void sogutucuKapat(){
        arayuz.sogutucuKapat(eyleyici);
    }
    @Override
    public void Cikis(){
        arayuz.Cikis();
    }
}
