package uygulama.isbirimleri;


import uygulama.observer.IObServer;
import uygulama.observer.ISubject;
import java.util.ArrayList;
import java.util.Random;

public class SıcaklıkAlgılayıcı implements ISıcaklıkAlgılayıcı, ISubject{

    private ArrayList observers = new ArrayList();

    @Override
    public int sicaklikOku(){
        Random rnd = new Random();
        int sayi = rnd.nextInt(150);
        return sayi;
    }

    @Override
    public int sicaklikGonder(){
        System.out.println("Sıcaklık: "+sicaklikOku()+" Derece");
        return sicaklikOku();
    }

    public void registerObserver(IObServer o){
        observers.add(o);
    }

    public void removeObserver(IObServer o){
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(i);
        }
    }
    public void notifyObservers(){
        for(int i=0; i< observers.size(); i++) {

            IObServer observer = (IObServer)observers.get(i);
            observer.guncelle(sicaklikGonder());
        }
    }
}
