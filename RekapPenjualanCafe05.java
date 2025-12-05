import java.util.Scanner;

public class RekapPenjualanCafe05 {

    static String[] menu;
    static int[][] penjualan;
    static int jumlahMenu, jumlahHari;

    static void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah menu: ");
        jumlahMenu = sc.nextInt();
        System.out.print("Masukkan jumlah hari penjualan: ");
        jumlahHari = sc.nextInt();
        sc.nextLine();

        menu = new String[jumlahMenu];
        penjualan = new int[jumlahMenu][jumlahHari];

        System.out.println("\n-- Input Nama Menu --");
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.print("Menu ke-" + (i+1) + ": ");
            menu[i] = sc.nextLine();
        }

        System.out.println("\n-- Input Penjualan per Hari (angka integer) --");
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println("Penjualan '" + menu[i] + "':");
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("  Hari " + (j+1) + ": ");
                penjualan[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilkanTabelRapi() {
        int firstColWidth = "Menu".length();
        for (String m : menu) if (m.length() > firstColWidth) firstColWidth = m.length();
        firstColWidth += 2; 

        int[] colWidth = new int[jumlahHari];
        for (int j = 0; j < jumlahHari; j++) {
            String header = "Hari " + (j+1);
            colWidth[j] = header.length();
            for (int i = 0; i < jumlahMenu; i++) {
                int len = String.valueOf(penjualan[i][j]).length();
                if (len > colWidth[j]) colWidth[j] = len;
            }
            colWidth[j] += 2; 
        }

        int[] totalPerMenu = new int[jumlahMenu];
        int maxTotalLen = "TOTAL".length();
        for (int i = 0; i < jumlahMenu; i++) {
            int s = 0;
            for (int j = 0; j < jumlahHari; j++) s += penjualan[i][j];
            totalPerMenu[i] = s;
            int len = String.valueOf(s).length();
            if (len > maxTotalLen) maxTotalLen = len;
        }
        maxTotalLen += 2;

        System.out.printf("%-" + firstColWidth + "s", "Menu");
        for (int j = 0; j < jumlahHari; j++) {
            System.out.printf("%" + colWidth[j] + "s", "Hari " + (j+1));
        }
        System.out.printf("%" + maxTotalLen + "s", "TOTAL");
        System.out.println();

        int totalTableWidth = firstColWidth;
        for (int w : colWidth) totalTableWidth += w;
        totalTableWidth += maxTotalLen;
        for (int k = 0; k < totalTableWidth; k++) System.out.print("-");
        System.out.println();

        for (int i = 0; i < jumlahMenu; i++) {
            System.out.printf("%-" + firstColWidth + "s", menu[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.printf("%" + colWidth[j] + "d", penjualan[i][j]);
            }
            System.out.printf("%" + maxTotalLen + "d", totalPerMenu[i]);
            System.out.println();
        }

        for (int k = 0; k < totalTableWidth; k++) System.out.print("-");
        System.out.println();

        System.out.printf("%-" + firstColWidth + "s", "TOTAL HARI");
        int grandTotal = 0;
        for (int j = 0; j < jumlahHari; j++) {
            int colSum = 0;
            for (int i = 0; i < jumlahMenu; i++) colSum += penjualan[i][j];
            grandTotal += colSum;
            System.out.printf("%" + colWidth[j] + "d", colSum);
        }
        System.out.printf("%" + maxTotalLen + "d", grandTotal);
        System.out.println();

        System.out.println();
        System.out.println("Rata-rata penjualan tiap menu:");
        for (int i = 0; i < jumlahMenu; i++) {
            double avg = (double) totalPerMenu[i] / jumlahHari;
            System.out.printf("%-" + firstColWidth + "s : %.2f%n", menu[i], avg);
        }
    }

    public static void main(String[] args) {
        inputData();
        System.out.println();
        tampilkanTabelRapi();
    }
}