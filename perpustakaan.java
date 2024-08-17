import java.sql.*;
import java.util.Scanner;
public class perpustakaan{
    public static void main(String[] args){
        try{
            Scanner f=new Scanner (System.in);
            System.out.println("DATA PERPUSTAKAAN KELOMPOK1");
            System.out.println("====================================================================================");
            System.out.println("|No  "+ "    Kategori  "+"      Judul            "+"         Label "+"            Penulis      |");
            System.out.println("====================================================================================");
            Class.forName("org.sqlite.JDBC");
            Connection koneksi = DriverManager.getConnection("jdbc:sqlite:perpustakaan.db");
            Statement stat = koneksi.createStatement();
            ResultSet sat =stat.executeQuery("select * from perpus");
            while(sat.next()){
                //data perpus
                String a = sat.getString("no");
                String b = sat.getString("kat");
                String c = sat.getString("judul");
                String d = sat.getString("label");
                String e = sat.getString("penulis");

                System.out.println("| "+a+" \t" +"|"+ b +"\t"+"|"+c+"\t"+"|"+d +"\t"+"\t"+"|"+e+"\t"+"|");
            }
            System.out.println("___________________________________________________________");
            System.out.print("masukan katergori buku yang ingin dicari : "); String kat=f.nextLine();
            ResultSet set = stat.executeQuery("select * from perpus where kat like '"+kat+"%'");
            while(set.next()){
                //data perpus
                String a = set.getString("no");
                String b = set.getString("kat");
                String c = set.getString("judul");
                String d = set.getString("label");
                String e = set.getString("penulis");

                System.out.println("| "+a+" \t" +"|"+ b +"\t"+"|"+c+"\t"+"|"+d +"\t"+"\t"+"|"+e+"\t"+"|");
            }
            System.out.println("====================================================================================");
            
            System.out.println();
            System.out.println("====================================================================================");
            System.out.println("|Tambah Peminjam Hari Ini|");
            System.out.println("====================================================================================");
            System.out.print("Nama         ="); String nama=f.nextLine();
            System.out.print("Judul        ="); String jdl=f.nextLine();
            System.out.print("Label        ="); String lbl=f.nextLine();
            System.out.print("Jam Pinjam   ="); String jp=f.nextLine();
            System.out.print("Pengembalian ="); String p=f.nextLine();
            stat.executeUpdate("insert into pinjam values('"+nama+"','"+jdl+"','"+lbl+"','"+jp+"','"+p+"')");
            
            System.out.println();
            System.out.println("========================");
            System.out.println("|Data Peminjam Hari Ini|");
            System.out.println("========================");
            System.out.println("Nama     Judul\t\t\t  Label \t Jam Pinjam    Pengembalian ");
            System.out.println("____________________________________________________________________________");
            stat.executeQuery("select * from pinjam");
            while(set.next()){
                
            String i = set.getString("nama");
            String g = set.getString("jdl");
            String h = set.getString("lbl");
            String j = set.getString("jp");
            String k = set.getString("p");
            System.out.println(i+"\t" + g +"\t"+"\t"+h+"\t   "+jp+"   \t"+k);
            
            }
        }
        catch (Exception e)
        { System.err.println("DB eror : "+e.getMessage());}
    }
}
