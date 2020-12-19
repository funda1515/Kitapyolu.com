package kütüphane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Islem {
    public Connection con =null;
    public Statement statement = null;
   
    public PreparedStatement preparedStatement = null;
    
    public Islem(){
    String serverName = "127.0.0.1";
    String portNumber = "1521";
    String sid = "xe";
    String url = "jdbc:oracle:thin:@"+serverName+":"+portNumber+":"+sid;
    String userName = "Bilgehan35";
    String password = "Bnm456bnm.";
    
        try {
            con = DriverManager.getConnection(url,userName,password);
        } catch (SQLException ex) {
            Logger.getLogger(Islem.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
     public boolean girisyap(String UYEKULLANICIADI,String UYEPAROLA){
     String sorgu = "Select * From UYEGİRİS where UYEKULLANICIADI = ? and UYEPAROLA = ? ";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,UYEKULLANICIADI);
            preparedStatement.setString(2,UYEPAROLA);
            
            ResultSet rs =preparedStatement.executeQuery();
           
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islem.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
     
    }
     public boolean girisYap(String kullanici_adi,String parola){
     String sorgu = "Select * From ADMINLER where Kullanıcı_Adı = ? and Parola = ? ";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2,parola);
            
            ResultSet rs =preparedStatement.executeQuery();
           
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islem.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
     
    }
     public void kitapEkle(String ad,String yazar,String baski,String sayfa,String dil,String yayınevi){
         String sorgu = " Insert Into KİTAPLAR(KitapAd,KitapYazari,KitapBaskiYil,KitapSayfaSayisi,KitapDil,KitapYayinEvi) values (?,?,?,?,?,?)";
        try {
            preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1, ad);
             preparedStatement.setString(2, yazar);
             preparedStatement.setString(3, baski);
             preparedStatement.setString(4, sayfa);
             preparedStatement.setString(5, dil);
             preparedStatement.setString(6, yayınevi);
            
            
             preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Islem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
     }
    public static void main(String[] args) {
        Islem islem = new Islem();
        
        
    }
    public void kitapSil(int no){
         String sorgu = "Delete from KİTAPLAR where KitapNo = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1,no);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }
public void kitapGuncelle(String yeni_ad,String yeni_yazar,String yeni_baski,String yeni_sayfa,String yeni_dil,String yeni_yayınevi,int no) {
        String sorgu =  "Update KİTAPLAR set KitapAd = ? , KitapYazari = ? , KitapBaskiYil= ? , KitapSayfaSayisi = ? , KitapDil = ?, KitapYayinEvi = ? where KitapNo = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
             preparedStatement.setString(1, yeni_ad);
             preparedStatement.setString(2, yeni_yazar);
             preparedStatement.setString(3, yeni_baski);
             preparedStatement.setString(4, yeni_sayfa);
             preparedStatement.setString(5, yeni_dil);
             preparedStatement.setString(6, yeni_yayınevi);
             preparedStatement.setInt(7, no);
            
             preparedStatement.executeUpdate();
 
        } catch (SQLException ex) {
            Logger.getLogger(Islem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 public boolean sifre_degistir(String yenisifre,String eskisifre,String ad){
     String sorgu ="UPDATE ADMINLER set Parola = ? where Kullanıcı_Adı = ? and Parola = ?";
    
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,yenisifre);
            preparedStatement.setString(2, ad);
            preparedStatement.setString(3, eskisifre);
            
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islem.class.getName()).log(Level.SEVERE, null, ex);

        }
        
         return true;
         
 }

    public ArrayList<KitapProperties> kitaplari_getir() {
        ArrayList<KitapProperties> cikti = new ArrayList<KitapProperties>();
        try {
            
            statement = con.createStatement();
            String sorgu = "Select * From KİTAPLAR";
            ResultSet rs =statement.executeQuery(sorgu);
            while(rs.next()){
                
                    
                    String ad = rs.getString("KitapAd");
                    String yazar = rs.getString("KitapYazari");
                    int baski_yili = rs.getInt("KitapBaskiYil");
                    int sayfa_sayfasi = rs.getInt("KitapSayfaSayisi");
                    String dil = rs.getString("KitapDil");
                    String yayin_evi=rs.getString("KitapYayinEvi");
                    int no = rs.getInt("KitapNo");
                    cikti.add(new KitapProperties(ad,yazar,baski_yili,sayfa_sayfasi,dil,yayin_evi,no));
            }
                return cikti;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islem.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
      
    }
   

    
   
}
