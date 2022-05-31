package model;

import javax.swing.*;
import java.sql.*;

public class Model {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/aslab_db";
    static final String USER = "root";
    static final String PASS = "";
    Connection koneksi;
    Statement statement;

    public Model(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] readData(){

        try{
            int jmlData = 0;

            String[][] data = new String[getBanyakData()][5];

            String query = "SELECT * FROM aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = resultSet.getString("portofolio");
                data[jmlData][2] = resultSet.getString("microteaching");
                data[jmlData][3] = resultSet.getString("wawancara");
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertData(String Nama, double Portofolio, double Microteaching, double Wawancara, double Nilai){
        int jmlData=0;

        try {
            String query = "SELECT * FROM aslab WHERE nama='" + Nama+"'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if((Portofolio>=0 && Portofolio <=100) &&(Microteaching>=0 && Microteaching <=100) &&(Wawancara>=0 && Wawancara <=100)){
                if (jmlData==0) {
                    query = "INSERT INTO aslab(nama,portofolio,microteaching,wawancara,nilai) VALUES('"+Nama+"','"+Portofolio+"','"+Microteaching+"','"+Wawancara+"','"+Nilai+"')";

                    statement = (Statement) koneksi.createStatement();
                    statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Data Aslab ditambahkan");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Data Aslab sudah ada");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Data nilai harus 0-100");
            }


        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateData(String Nama, double Portofolio, double Microteaching, double Wawancara, double Nilai){
        int jmlData=0;
        try {
            String query = "SELECT * FROM aslab WHERE nama='" + Nama+"'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if((Portofolio>=0 && Portofolio <=100) &&(Microteaching>=0 && Microteaching <=100) &&(Wawancara>=0 && Wawancara <=100)) {
                if (jmlData==1) {
                    query = "UPDATE aslab SET portofolio='" + Portofolio + "', microteaching='" + Microteaching + "',wawancara='" + Wawancara + "' ,nilai='"+ Nilai+"' WHERE nama='" + Nama+"'";
                    statement = (Statement) koneksi.createStatement();
                    statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Data Aslab Berhasil diupdate");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Data Aslab Tidak Ada");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Data nilai harus 0-100");
            }


        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void deleteData (String Nama) {
        try{
            String query = "DELETE FROM aslab WHERE nama = '"+Nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Aslab Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
}
