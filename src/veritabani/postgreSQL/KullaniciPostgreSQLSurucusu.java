package veritabani.postgreSQL;

import veritabani.IKullaniciVeriTabaniServisi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public  class KullaniciPostgreSQLSurucusu implements IKullaniciVeriTabaniServisi{

   private static KullaniciPostgreSQLSurucusu instance;
   private static String userName= "postgres";
   private static String password= "MERTaslay1907";
   private static String dbUrl="jdbc:postgresql://localhost:5432/AkilliCihaz";

   private KullaniciPostgreSQLSurucusu(){

    }
    private Connection baglan(){
       Connection conn=null;

       try{
           conn = DriverManager.getConnection(dbUrl,userName,password);
           if(conn != null)
               System.out.println("Veritabanına bağlanıldı..");
           else
               System.out.println("Bağlantı girişimi başarısız..!");
       }catch (Exception e){
           e.printStackTrace();
       }
       return conn;
    }
    public static KullaniciPostgreSQLSurucusu getInstance(){
       if(instance==null){
           instance=new KullaniciPostgreSQLSurucusu();
       }
       return instance;
    }

    @Override
    public boolean kullaniciDogrula(String kullaniciAdi,String sifre){
       Connection conn= this.baglan();

       String sql="SELECT \"kullaniciAdi\",\"sifre\" FROM \"kullanici\" WHERE \"kullaniciAdi\"="+"'"+kullaniciAdi+"'"+"AND \"sifre\"="+"'"+sifre+"'";
       try {
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql);

           conn.close();

           if (!rs.next()) {
               System.out.println("Kullanıcı doğrulama başarısız..!");
               return false;
           } else {
               System.out.println("*Kullanıcı doğrulama başarılı*");
               System.out.println("/--Arayüzü Kullanabilirsiniz--/");
               return true;
           }
       }
       catch (Exception e){
           System.out.println(e);
           return false;
       }
    }


}
