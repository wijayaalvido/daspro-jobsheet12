import java.util.Scanner;

public class Kafe05 {

    public static void Menu(String namaPelanggan, boolean isMember, String kodePromo) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("Kode Promo yang Anda masukkan: " + kodePromo);

        if (kodePromo.equals("DISKON50")) {
            System.out.println("Promo: Diskon 50%");
        } else if (kodePromo.equals("DISKON30")) {
            System.out.println("Promo: Diskon 30%");
        } else {
            System.out.println("Kode promo tidak valid");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappucino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
    }

    public static int hitungTotalHarga05(int pilihanMenu, int banyakItem, String kodePromo) {

        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        double diskon = 0;

        if (kodePromo.equals("DISKON50")) {
            diskon = hargaTotal * 0.50;
        } else if (kodePromo.equals("DISKON30")) {
            diskon = hargaTotal * 0.30;
        }

        return (int) (hargaTotal - diskon);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nama = "Adi";
        boolean member = true;

        System.out.print("Masukkan kode promo: ");
        String kodePromo = sc.nextLine();

        Menu(nama, member, kodePromo);

        int totalKeseluruhan = 0;

        System.out.print("\nBerapa jenis menu yang ingin Anda pesan? ");
        int jumlahJenisMenu = sc.nextInt();

        for (int i = 1; i <= jumlahJenisMenu; i++) {
            System.out.println("\nPesanan ke-" + i);

            System.out.print("Masukkan nomor menu: ");
            int pilihanMenu = sc.nextInt();

            System.out.print("Masukkan jumlah item: ");
            int banyakItem = sc.nextInt();

            int totalPerMenu = hitungTotalHarga05(pilihanMenu, banyakItem, kodePromo);

            System.out.println("Total untuk menu ini: Rp " + totalPerMenu);

            totalKeseluruhan += totalPerMenu;
        }

        System.out.println("\n===============================");
        System.out.println("Total keseluruhan pesanan: Rp " + totalKeseluruhan);
        System.out.println("===============================");

        sc.close();
    }
}
