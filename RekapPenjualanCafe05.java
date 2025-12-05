public class RekapPenjualanCafe05 {

    static String[] menu = {
        "Kopi", "Teh", "Es Kelapa Muda", "Roti Bakar", "Gorengan"
    };

    static int[][] penjualan = {
        {20, 20, 25, 20, 10, 60, 10},   
        {30, 80, 40, 10, 15, 20, 25},   
        {5, 9, 20, 25, 10, 5, 45},   
        {50, 8, 17, 18, 10, 30, 6},     
        {15, 10, 16, 15, 10, 10, 55}    
    };

    static void tampilkanTabel() {
        System.out.printf("%-15s", "Menu");
        for (int h = 1; h <= 7; h++) {
            System.out.printf("Hari %d\t", h);
        }
        System.out.println();

        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%-15s", menu[i]);
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d\t", penjualan[i][j]);
            }
            System.out.println();
        }
    }

    static void menuTertinggi() {
        int max = -1;
        int index = 0;

        for (int i = 0; i < menu.length; i++) {
            int total = 0;
            for (int j = 0; j < 7; j++) total += penjualan[i][j];
            if (total > max) {
                max = total;
                index = i;
            }
        }

        System.out.println("\nMenu dengan total penjualan tertinggi:");
        System.out.println(menu[index] + " = " + max);
    }

    static void rataRata() {
        System.out.println("\nRata-rata penjualan setiap menu:");
        for (int i = 0; i < menu.length; i++) {
            int total = 0;
            for (int j = 0; j < 7; j++) total += penjualan[i][j];
            double avg = total / 7.0;
            System.out.printf("%-15s: %.2f\n", menu[i], avg);
        }
    }

    public static void main(String[] args) {
        tampilkanTabel();
        menuTertinggi();
        rataRata();
    }
}
