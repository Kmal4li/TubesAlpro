import java.util.Scanner;

class Karyawan {
    // atribut
    public String nama, posisi, departemen, alamat;
    public int gaji, nik;
    public String tglMasuk;
    public int saldoCuti = 12;

    // constructor
    public Karyawan(int nik, String nama, String posisi, String departemen,
                    String alamat, int gaji, String tglMasuk) {
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

    // untuk menerima data karyawan
    static Karyawan[] daftarKaryawan = new Karyawan[100];
    static int jumlahKaryawan = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        // menampilkan menu
        do {
            System.out.println("\n=== MENU SISTEM DATA KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Tampilkan Semua Karyawan");
            System.out.println("3. Cari Karyawan");
            System.out.println("4. Edit Karyawan");
            System.out.println("5. Hapus Karyawan");
            System.out.println("6. Ajukan Cuti");
            System.out.print("7. Keluar");
            System.out.println("\n==================================");
            System.out.print("Pilih menu (1-7): ");
            pilihan = input.nextInt();

            // pilih menu
            switch (pilihan) {
                case 1: tambahKaryawan(); break;
                case 2: tampilkanSemua(); break;
                case 3: cariKaryawan(); break;
                case 4: editKaryawan(); break;
                case 5: hapusKaryawan(); break;
                case 6: ajukanCuti(); break;
                case 7: System.out.println("Keluar..."); break;
                default: System.out.println("Pilihan tidak valid! (pilih 1-7)");
            }
        } while (pilihan != 7);
    }

    // tambah karyawan
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
        String tglMasuk = input.next();

        // untuk buat objek karyawan
        Karyawan k = new Karyawan(nik, nama, posisi, departemen, alamat, gaji, tglMasuk);

        // menyimpan objek karyawan
        daftarKaryawan[jumlahKaryawan] = k;
        jumlahKaryawan++;
        System.out.println("Karyawan berhasil ditambahkan!");
    }

    // menampilkan semua karyawan
    public static void tampilkanSemua() {
        if (jumlahKaryawan == 0) {
            System.out.println("Belum ada data karyawan.");
            return;
        }

        System.out.println("\n=== DAFTAR SEMUA KARYAWAN ===");
        for (int i = 0; i < jumlahKaryawan; i++) {
            daftarKaryawan[i].tampilkanData();
        }
    }

    // mencari data karyawan berdasarkan nik atau nama
    public static void cariKaryawan() {
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

        // jika karyawan tidak ada
        if (!ditemukan) {
            System.out.println("Karyawan tidak ditemukan!");
        }
    }

    // mengedit data karyawan
    public static void editKaryawan() {
        System.out.print("Masukkan NIK karyawan: ");
        int nikCari = input.nextInt();

        // pilih data yang akan diubah
        System.out.println("Pilih data yang akan diubah:");
        System.out.println("1. Nama");
        System.out.println("2. Posisi");
        System.out.println("3. Departemen");
        System.out.println("4. Alamat");
        System.out.println("5. Gaji");
        System.out.println("6. Tanggal Masuk");
        System.out.print("Pilih (1-6): ");
        int pilihan = input.nextInt();

        for (int i = 0; i < jumlahKaryawan; i++) {
            if (daftarKaryawan[i].nik == nikCari) {
                
                // mengubah data karyawan tergantung pilihan diatas
                switch(pilihan) {
                    case 1: System.out.print("Nama baru: ");
                            daftarKaryawan[i].nama = input.next(); 
                            break;
                    case 2: System.out.print("Posisi baru: ");
                            daftarKaryawan[i].posisi = input.next();
                            break;
                    case 3: System.out.print("Departemen baru: ");
                            daftarKaryawan[i].departemen = input.next();
                            break;
                    case 4: System.out.print("Alamat baru: ");
                            daftarKaryawan[i].alamat = input.next();
                            break;
                    case 5: System.out.print("Gaji baru: ");
                            daftarKaryawan[i].gaji = input.nextInt();
                            break;
                    case 6: System.out.print("Tanggal Masuk baru: ");
                            daftarKaryawan[i].tglMasuk = input.next();
                            break;
                }
                
                System.out.println("Data berhasil diupdate!");

                // menampilkan karyawan setelah diedit
                boolean ditemukan = false;
                for (int j = 0; j < jumlahKaryawan; j++) {
                    if (daftarKaryawan[i].nik == nikCari) {
                        daftarKaryawan[i].tampilkanData();
                        ditemukan = true;
                    }
                }
                return;
            }
        }
        // error handling jika karyawan tidak ada
        System.out.println("Karyawan tidak ditemukan!");
    }

    // menghapus data karyawan
    public static void hapusKaryawan() {
        System.out.print("Masukkan NIK: ");
        int nikCari = input.nextInt();

        for (int i = 0; i < jumlahKaryawan; i++) {
            if (daftarKaryawan[i].nik == nikCari) {
                for (int j = i; j < jumlahKaryawan - 1; j++) {
                    daftarKaryawan[j] = daftarKaryawan[j + 1];
                }
                jumlahKaryawan--;
                System.out.println("Data karyawan berhasil dihapus!");
                return;
            }
        }
        // error handling jika karyawan tidak ada
        System.out.println("Karyawan tidak ditemukan!");
    }

    // mengajukan cuti
    public static void ajukanCuti() {
        System.out.print("Masukkan NIK: ");
        int nik = input.nextInt();

        for (int i = 0; i < jumlahKaryawan; i++) {
            if (daftarKaryawan[i].nik == nik) {
                System.out.print("Tanggal Cuti (YYYY-MM-DD): ");
                String tglCuti = input.next();

                System.out.print("Jumlah hari cuti: ");
                int jumlahHari = input.nextInt();

                if (jumlahHari > daftarKaryawan[i].saldoCuti) {
                    System.out.println("Saldo cuti tidak cukup!");
                    return;
                }

                daftarKaryawan[i].saldoCuti -= jumlahHari;
                System.out.println("Cuti berhasil diajukan pada tanggal " + tglCuti);
                System.out.println("Sisa saldo cuti: " + daftarKaryawan[i].saldoCuti);
                return;
            }
        }
        // error handling jika karyawan tidak ada
        System.out.println("Karyawan tidak ditemukan!");
    }
}
