import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Karyawan {
    public String nama, posisi, departemen, alamat;
    public int gaji, nik;
    public LocalDate tglMasuk;
    public int saldoCuti = 12;

    public Karyawan(int nik, String nama, String posisi, String departemen,
                    String alamat, int gaji, LocalDate tglMasuk) {
        this.nik = nik;
        this.nama = nama;
        this.posisi = posisi;
        this.departemen = departemen;
        this.alamat = alamat;
        this.gaji = gaji;
        this.tglMasuk = tglMasuk;
    }

    // menampilkan data karyawan
    public void tampilkanData() {
        System.out.println("======================================");
        System.out.println("NIK          : " + nik);
        System.out.println("Nama         : " + nama);
        System.out.println("Posisi       : " + posisi);
        System.out.println("Departemen   : " + departemen);
        System.out.println("Saldo Cuti   : " + saldoCuti);
        System.out.println("======================================");
    }
}

public class sistemDataKaryawan {

    static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        // tampilan menu
        do {
            System.out.println("\n=== MENU SISTEM DATA KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Tampilkan Semua Karyawan");
            System.out.println("3. Cari Karyawan");
            System.out.println("4. Ajukan Cuti");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            // memilih menu
            switch (pilihan) {
                case 1:
                    tambahKaryawan();
                    break;
                case 2:
                    tampilkanSemua();
                    break;
                case 3:
                    cariKaryawan();
                    break;
                case 4:
                    ajukanCuti();
                    break;
                case 5:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! (pilih 1-5)");
            }
        } while (pilihan != 3);
    }

    // menambah data karyawan
    public static void tambahKaryawan() {
        System.out.print("NIK: ");
        int nik = input.nextInt();

        System.out.print("Nama: ");
        String nama = input.next();

        System.out.print("Posisi: ");
        String posisi = input.next();

        System.out.print("Departemen: ");
        String departemen = input.next();

        System.out.print("Alamat: ");
        String alamat = input.next();

        System.out.print("Gaji: ");
        int gaji = input.nextInt();

        System.out.print("Tanggal Masuk (YYYY-MM-DD): ");
        LocalDate tglMasuk = LocalDate.parse(input.next());

        // buat objek karyawan
        Karyawan k = new Karyawan(nik, nama, posisi, departemen, alamat, gaji, tglMasuk);

        // simpan ke ArrayList
        daftarKaryawan.add(k);
        System.out.println(">> Karyawan berhasil ditambahkan!");
    }

    // menampilkan semua karyawan
    public static void tampilkanSemua() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }

        System.out.println("\n=== DAFTAR SEMUA KARYAWAN ===");
        for (Karyawan k : daftarKaryawan) {
            k.tampilkanData();
        }
    }

    // mencari data karyawan berdasarkan nik atau nama
    public static void cariKaryawan() {
        System.out.println("\n=== CARI KARYAWAN ===");
        System.out.println("Cari berdasarkan:");
        System.out.println("1. NIK");
        System.out.println("2. Nama");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();

        boolean ditemukan = false;

        if (pilih == 1) {
            // cari berdasarkan nik
            System.out.print("Masukkan NIK: ");
            int nikCari = input.nextInt();
        
        for (Karyawan k : daftarKaryawan) {
                if (k.nik == nikCari) {
                    System.out.println("\nData ditemukan!");
                    k.tampilkanData();
                    ditemukan = true;
                    break;
                }
            }
        } 
            else if (pilih == 2) {
            // cari berdasarkan nama
            System.out.print("Masukkan Nama: ");
            // input dan mengubah ke lower case
            String namaCari = input.next().toLowerCase();
        
        // cari berdasarkan nama
        for (Karyawan k : daftarKaryawan) {
                if (k.nama.toLowerCase().contains(namaCari)) {
                    System.out.println("\nData ditemukan!");
                    k.tampilkanData();
                    ditemukan = true;
                }
            }
        }

        // error notification
        if (!ditemukan) {
            System.out.println(">> Karyawan tidak ditemukan!");
        }
    }

    // mengajukan cuti
    public static void ajukanCuti() {
        System.out.println("\n=== AJUKAN CUTI ===");

        System.out.print("Masukkan NIK: ");
        int nik = input.nextInt();

        // cari karyawan berdasarkan nik
        Karyawan karyawan = null;
        for (Karyawan k : daftarKaryawan) {
            if (k.nik == nik) {
                karyawan = k;
                break;
            }
        }

        // jika tidak ditemukan
        if (karyawan == null) {
            System.out.println(">> Karyawan tidak ditemukan!");
            return;
        }

        // input data cuti
        System.out.print("Masukkan alasan cuti: ");
        String alasan = input.next();

        System.out.print("Masukkan tanggal cuti (YYYY-MM-DD): ");
        LocalDate tglCuti = LocalDate.parse(input.next());

        System.out.print("Masukkan jumlah hari cuti: ");
        int jumlahHari = input.nextInt();

        // cek saldo cuti
        if (jumlahHari > karyawan.saldoCuti) {
            System.out.println("\n>> Saldo cuti tidak cukup!");
            System.out.println("Saldo saat ini: " + karyawan.saldoCuti + " hari");
            return;
        }

        // kurangi saldo cuti
        karyawan.saldoCuti -= jumlahHari;

        // menampilkan data karyawan dan saldo cuti terbaru
        System.out.println("\n=== PENGAJUAN CUTI BERHASIL ===");
        System.out.println("NIK          : " + karyawan.nik);
        System.out.println("Nama         : " + karyawan.nama);
        System.out.println("Tanggal Cuti : " + tglCuti);
        System.out.println("Jumlah Hari  : " + jumlahHari);
        System.out.println("Alasan       : " + alasan);
        System.out.println("Sisa Saldo Cuti : " + karyawan.saldoCuti + " hari");
    }
}
