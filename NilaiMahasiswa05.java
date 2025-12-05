import java.util.Scanner;

public class NilaiMahasiswa05 {

    static void isianArray(int[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
    }

    static void tampilArray(int[] arr) {
        System.out.println("\nDaftar Nilai Mahasiswa:");
        for (int nilai : arr) {
            System.out.print(nilai + " ");
        }
        System.out.println();
    }

    static int hitTot(int[] arr) {
        int total = 0;
        for (int nilai : arr) {
            total += nilai;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa (N): ");
        int N = sc.nextInt();

        int[] nilai = new int[N];

        isianArray(nilai, sc);
        tampilArray(nilai);

        int total = hitTot(nilai);
        System.out.println("Total nilai seluruh mahasiswa = " + total);
    }
}
