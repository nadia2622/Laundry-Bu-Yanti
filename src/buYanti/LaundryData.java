/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buYanti;

/**
 *
 * @author abida
 */


public class LaundryData {
    private String nama;
    private String layanan;
    private String alamat;
    private String harga;
    private String deadline;

    public LaundryData(String nama, String layanan, String alamat, String harga, String deadline) {
        this.nama = nama;
        this.layanan = layanan;
        this.alamat = alamat;
        this.harga = harga;
        this.deadline = deadline;
    }

    // Getter kalau kamu mau tampilkan data
    public String getNama() { return nama; }
    public String getLayanan() { return layanan; }
    public String getAlamat() { return alamat; }
    public String getHarga() { return harga; }
    public String getDeadline() { return deadline; }
}

