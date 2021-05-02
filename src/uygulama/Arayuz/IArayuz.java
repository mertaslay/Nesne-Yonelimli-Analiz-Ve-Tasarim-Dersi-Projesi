package uygulama.Arayuz;

import uygulama.isbirimleri.IEyleyici;
import uygulama.isbirimleri.ISıcaklıkAlgılayıcı;

public interface IArayuz {
    public boolean kullaniciGiris();
    public int islemSecimi();
    public void sicaklik(ISıcaklıkAlgılayıcı sicaklikAlgilayici);
    public void sogutucuAc(IEyleyici eyleyici);
    public void sogutucuKapat(IEyleyici eyleyici);
    public void Cikis();
}
