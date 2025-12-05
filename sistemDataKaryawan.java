import java.time.LocalDateTime;
import java.util.Scanner;

class karyawan {
    public String nama, posisi, departemen, alamat;
    public int gaji, nik;
    public LocalDateTime tglMasuk;
    public int saldoCuti = 12;
}

public class sistemDataKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        karyawan karyawan = new karyawan();

        System.out.println("Nama: " + karyawan.nik);
        int nik = input.nextInt();
        System.out.println("Nama: " + karyawan.nama);
        String nama = input.next();
        System.out.println("Posisi: " + karyawan.posisi);
        String posisi = input.next();
        System.out.println("Departemen: " + karyawan.departemen);
        String departemen = input.next();
        System.out.println("Alamat: " + karyawan.alamat);
        String alamat = input.next();
        System.out.println("Gaji: " + karyawan.gaji);
        int gaji = input.nextInt();
        System.out.println("Tanggal Masuk: " + karyawan.tglMasuk);
        LocalDateTime tglMasuk = LocalDateTime.now();
        System.out.println("Saldo Cuti: " + karyawan.saldoCuti);
        int saldoCuti = input.nextInt();
    }
}

