package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    JLabel lNama = new JLabel("Nama");
    JLabel lNilaiPorto = new JLabel("Nilai Portofolio");
    JLabel lNilaiMicro = new JLabel("Nilai Microteaching");
    JLabel lNilaiWawancara = new JLabel("Nilai Wawancara");

    public JTextField fNama = new JTextField();
    public JTextField fNilaiPorto = new JTextField();
    public JTextField fNilaiMicro = new JTextField();
    public JTextField fNilaiWawancara = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object[] columnName = {"Nama", "Nilai Portofolio", "Nilai Microteaching", "Nilai Wawancara", "Nilai Akhir"};

    public View() {
        dtm = new DefaultTableModel(columnName, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Aslab");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(lNama);
        lNama.setBounds(510, 20, 90, 20);
        add(fNama);
        fNama.setBounds(510, 40, 120, 20);

        add(lNilaiPorto);
        lNilaiPorto.setBounds(510, 60, 90, 20);
        add(fNilaiPorto);
        fNilaiPorto.setBounds(510, 80, 120, 20);

        add(lNilaiMicro);
        lNilaiMicro.setBounds(510, 100, 90, 20);
        add(fNilaiMicro);
        fNilaiMicro.setBounds(510, 120, 120, 20);

        add(lNilaiWawancara);
        lNilaiWawancara.setBounds(510, 140, 90, 20);
        add(fNilaiWawancara);
        fNilaiWawancara.setBounds(510, 160, 120, 20);

        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);

        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
    }

    public String getNama(){
        return fNama.getText();
    }

    public String getPortofolio(){
        return fNilaiPorto.getText();
    }

    public String getMicroteaching(){
        return fNilaiMicro.getText();
    }

    public String getWawancara(){
        return fNilaiWawancara.getText();
    }
}
