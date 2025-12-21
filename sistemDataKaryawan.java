import java.time.LocalDate;
import java.util.Scanner;

class Karyawan {
    String nama, posisi, departemen, alamat;
    int gaji, nik;
    String tglMasuk;
    int saldoCuti = 12;

    public Karyawan(int nik, String nama, String posisi, String departemen, String alamat, int gaji, String tglMasuk) {
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
        System.out.println("Tanggal Masuk: " + tglMasuk);
        System.out.println("Saldo Cuti   : " + saldoCuti);
        System.out.println("======================================");
    }
}

public class sistemDataKaryawan {

    static Karyawan[] daftarKaryawan = new Karyawan[100];
    static int jumlahKaryawan = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            // menu
            System.out.println("\n=== MENU SISTEM DATA KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Tampilkan Semua Karyawan");
            System.out.println("3. Cari Karyawan");
            System.out.println("4. Edit Karyawan");
            System.out.println("5. Hapus Karyawan");
            System.out.println("6. Ajukan Cuti");
            System.out.println("7. Keluar");
            System.out.println("==================================");
            System.out.print("Pilihan: ");
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
                    editKaryawan();
                    break;
                case 5: 
                    hapusKaryawan();
                    break;
                case 6: 
                    ajukanCuti();
                    break;
                case 7: 
                    System.out.println("Keluar...");
                    break;
                default: System.out.println("Pilihan tidak valid! Pilih (1-7)");
            }
        } while (pilihan != 7);
    }

    // tambah karyawan
    public static void tambahKaryawan() {
        System.out.println("\n=== TAMBAH KARYAWAN ===");
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

        System.out.print("Tanggal Masuk: ");
        String tglMasuk = input.next();
        System.out.println("=========================");

        daftarKaryawan[jumlahKaryawan++] =
                new Karyawan(nik, nama, posisi, departemen, alamat, gaji, tglMasuk);

        System.out.println("Karyawan berhasil ditambahkan!");
    }

    // menampilkan semua karyawan
    public static void tampilkanSemua() {
        if (jumlahKaryawan == 0) {
            System.out.println("Belum ada data karyawan.");
            return;
        }

        for (int i = 0; i < jumlahKaryawan; i++) {
            daftarKaryawan[i].tampilkanData();
        }
    }

    // cari karyawan
    public static void cariKaryawan() {
        System.out.println("\n=== CARI KARYAWAN ===");
        System.out.print("Masukkan NIK atau Nama: ");
        String cari = input.next();

        boolean ditemukan = false;
        for (int i = 0; i < jumlahKaryawan; i++) {
            if (String.valueOf(daftarKaryawan[i].nik).equals(cari)
                    || daftarKaryawan[i].nama.equalsIgnoreCase(cari)) {
                daftarKaryawan[i].tampilkanData();
                ditemukan = true;
            }
        }

        // error handling jika tidak ditemukan
        if (!ditemukan) {
            System.out.println("Karyawan tidak ditemukan!");
        }
    }

    // mengedit data karyawan 
    public static void editKaryawan() {
        System.out.println("\n=== EDIT KARYAWAN ===");
        System.out.print("Masukkan NIK karyawan yang ingin diedit: ");
        int nikCari = input.nextInt();

        int index = -1;

        // mencari karyawan
        for (int i = 0; i < jumlahKaryawan; i++) {
            if (daftarKaryawan[i].nik == nikCari) {
                index = i;
                break;
            }
        }

        // jika tidak ditemukan
        if (index == -1) {
            System.out.println("Karyawan tidak ditemukan!");
            return;
        }

        // tampilkan data lama
        System.out.println("\nData karyawan saat ini:");
        daftarKaryawan[index].tampilkanData();

        // menu edit
        System.out.println("\nPilih data yang ingin diedit:");
        System.out.println("1. Nama");
        System.out.println("2. Posisi");
        System.out.println("3. Departemen");
        System.out.println("4. Alamat");
        System.out.println("5. Gaji");
        System.out.println("6. Tanggal Masuk");
        System.out.println("7. Edit Semua Data");
        System.out.println("=========================");
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                System.out.print("Nama baru: ");
                daftarKaryawan[index].nama = input.next();
                break;
            case 2:
                System.out.print("Posisi baru: ");
                daftarKaryawan[index].posisi = input.next();
                break;
            case 3:
                System.out.print("Departemen baru: ");
                daftarKaryawan[index].departemen = input.next();
                break;
            case 4:
                System.out.print("Alamat baru: ");
                daftarKaryawan[index].alamat = input.next();
                break;
            case 5:
                System.out.print("Gaji baru: ");
                daftarKaryawan[index].gaji = input.nextInt();
                break;
            case 6:
                System.out.print("Tanggal masuk baru: ");
                daftarKaryawan[index].tglMasuk = input.next();
                break;
            case 7:
                System.out.print("Nama baru: ");
                daftarKaryawan[index].nama = input.next();
                System.out.print("Posisi baru: ");
                daftarKaryawan[index].posisi = input.next();
                System.out.print("Departemen baru: ");
                daftarKaryawan[index].departemen = input.next();
                System.out.print("Alamat baru: ");
                daftarKaryawan[index].alamat = input.next();
                System.out.print("Gaji baru: ");
                daftarKaryawan[index].gaji = input.nextInt();
                System.out.print("Tanggal Masuk baru (YYYY-MM-DD): ");
                daftarKaryawan[index].tglMasuk = input.next();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        System.out.println("\nData berhasil diperbarui!");
    }

    // hapus data karyawan
    public static void hapusKaryawan() {
        System.out.println("\n=== HAPUS KARYAWAN ===");
        System.out.print("Masukkan NIK karyawan yang ingin dihapus: ");
        int nikCari = input.nextInt();

        int index = -1;

        // mencari karyawan
        for (int i = 0; i < jumlahKaryawan; i++) {
            if (daftarKaryawan[i].nik == nikCari) {
                index = i;
                break;
            }
        }

        // jika tidak ditemukan
        if (index == -1) {
            System.out.println("Karyawan tidak ditemukan!");
            return;
        }

        // tampilkan data karyawan
        System.out.println("\nData karyawan yang akan dihapus:");
        daftarKaryawan[index].tampilkanData();

        // konfirmasi
        System.out.print("Apakah yakin ingin menghapus? (y/n): ");
        String konfirmasi = input.next();

        if (konfirmasi.equalsIgnoreCase("y")) {
            // geser array ke kiri
            for (int i = index; i < jumlahKaryawan - 1; i++) {
                daftarKaryawan[i] = daftarKaryawan[i + 1];
            }
            jumlahKaryawan--;
            System.out.println("Data karyawan berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    // cuti
    public static void ajukanCuti() {
        System.out.println("\n=== AJUKAN CUTI ===");
        System.out.print("Masukkan NIK: ");
        int nik = input.nextInt();

        for (int i = 0; i < jumlahKaryawan; i++) {
            if (daftarKaryawan[i].nik == nik) {
                System.out.print("Jumlah cuti: ");
                int hari = input.nextInt();

                // mengecek saldo cuti
                if (hari > daftarKaryawan[i].saldoCuti) {
                    System.out.println("Saldo cuti tidak cukup!");
                    return;
                }

                // mengurangi saldo sesuai jumlah cuti yang diinginkan
                daftarKaryawan[i].saldoCuti -= hari;
                System.out.println("Berhasil mengajukan cuti!");
                System.out.println("Saldo cuti tersisa: " + daftarKaryawan[i].saldoCuti);
                return;
            }
        }
        // error handling jika tidak ditemukan
        System.out.println("Karyawan tidak ditemukan!");
    }
}
