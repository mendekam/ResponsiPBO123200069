package controller;

import model.Model;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    Model model;
    View view;
    public String data;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;


        if (model.getBanyakData()!=0) {
            String[][] dataAslab = model.readData();
            view.tabel.setModel((new JTable(dataAslab, view.columnName)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }


        view.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = view.getNama();
                double portofolio = Double.parseDouble(view.getPortofolio());
                double microteaching = Double.parseDouble(view.getMicroteaching());
                double wawancara = Double.parseDouble(view.getWawancara());
                double nilai = (portofolio+microteaching+wawancara)/3;
                model.insertData(nama, portofolio, microteaching, wawancara, nilai);

                String[][] dataAslab = model.readData();
                view.tabel.setModel((new JTable(dataAslab, view.columnName)).getModel());
            }
        });

        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = view.getNama();
                double portofolio = Double.parseDouble(view.getPortofolio());
                double microteaching = Double.parseDouble(view.getMicroteaching());
                double wawancara = Double.parseDouble(view.getWawancara());
                double nilai = (portofolio+microteaching+wawancara)/3;
                model.updateData(nama, portofolio, microteaching, wawancara, nilai);

                String[][] dataAslab = model.readData();
                view.tabel.setModel((new JTable(dataAslab, view.columnName)).getModel());
            }
        });


        view.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                view.fNama.setText("");
                view.fNilaiPorto.setText("");
                view.fNilaiMicro.setText("");
                view.fNilaiWawancara.setText("");
            }
        });


        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = view.tabel.getSelectedRow();
                data = view.tabel.getValueAt(baris, 0).toString();
                String[] dataUpdate = new String[4];
                dataUpdate[0] = view.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = view.tabel.getValueAt(baris, 1).toString();


                System.out.println(data);



            }
        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus data " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    model.deleteData(data);
                    String dataAslab[][] = model.readData();
                    view.tabel.setModel((new JTable(dataAslab, view.columnName)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Dihapus");
                }
            }
        });

    }

}

