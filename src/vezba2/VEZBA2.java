/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezba2;
import java.sql.*;
import java.util.Properties;
/**
 *
 * @author Anja
 */
public class VEZBA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Upravljacki program (drajver) je ucitan!");
            String dbUrl="jdbc:mysql://localhost:3306/prodaja";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection veza=DriverManager.getConnection(dbUrl,user,pass);
            System.out.println("Uspostavljena je konekcija izmedju baze i driver manager-a.");
            Statement stmt=veza.createStatement();
            String upit="SELECT * from Racun";
            ResultSet rezultat=null;
            rezultat=stmt.executeQuery(upit);
            System.out.println("Sadrzaj tabele Racun:");
            while(rezultat.next()){
            System.out.println(rezultat.getString("BrojRacuna")+" "+rezultat.getString("NazivPartnera")+" "+rezultat.getDouble("UkupnaVrednost")+" "+rezultat.getBoolean("Obradjen")+" "+rezultat.getBoolean("Storniran"));
            }
            stmt.close();
            
            /*Statement stmt2=veza.createStatement();
            String upit2="INSERT INTO Racun (BrojRacuna, NazivPartnera, UkupnaVrednost, Obradjen, Storniran) VALUES (0067893, 'BAS', 4800, true, false)";
            stmt2.executeUpdate(upit2);
            stmt2.close();*/
            
            /*Statement stmt3=veza.createStatement();
            String upit3="DELETE FROM Racun where BrojRacuna=0067893";
            stmt3.executeUpdate(upit3);
            stmt3.close();*/
            
            /*String upit4="INSERT INTO Racun (BrojRacuna, NazivPartnera, UkupnaVrednost, Obradjen, Storniran) VALUES (?,?,?,?,?)";
            PreparedStatement PSTATEMENT=veza.prepareStatement(upit4);
            PSTATEMENT.setString(1, new String("0012584") );
            PSTATEMENT.setString(2, new String("Janusevic") );
            PSTATEMENT.setDouble(3, new Double(5300) );
            PSTATEMENT.setBoolean(4, new Boolean(true));
            PSTATEMENT.setBoolean(5, new Boolean(false));
            PSTATEMENT.executeUpdate();
            PSTATEMENT.close();*/
            
            /*String upit5="DELETE FROM Racun WHERE NazivPartnera=?";
            PreparedStatement PSTATEMENT2=veza.prepareStatement(upit5);
            PSTATEMENT2.setString(1, new String("Janusevic"));
            PSTATEMENT2.executeUpdate();
            PSTATEMENT2.close();*/
            
            veza.close();
        } 
        catch(ClassNotFoundException e) {
            System.out.println("Upravljacki program nije ucitan: " + e);
        }
        catch(SQLException ex){
            System.out.println("Greska konekcije: "+ex);
        }
        catch(SecurityException e){
            System.out.println("Nedozvoljena operacija: "+e);
        }
    }
    
}
