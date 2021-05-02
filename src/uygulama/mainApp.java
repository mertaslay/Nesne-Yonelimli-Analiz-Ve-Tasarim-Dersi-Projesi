package uygulama;

import uygulama.merkeziİslem.IMerkeziİslemBirimi;
import uygulama.merkeziİslem.MerkeziİslemBirimi;
import veritabani.Builder.kullaniciDogrula;

public class mainApp {
    public static void main (String[] args){
        kullaniciDogrula KD =new kullaniciDogrula.Builder().KullaniciAdi("Mert"+"Ahmet"+"Selim").Sifre("admin"+"erzfb"+"XOXO").build();
        IMerkeziİslemBirimi merkeziİslemBirimi = new MerkeziİslemBirimi();
        merkeziİslemBirimi.islemYap();
    }
}
