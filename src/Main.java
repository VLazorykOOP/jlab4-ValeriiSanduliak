import java.util.Scanner;

public class Main {
    static void printMenu() {
        System.out.println("|--------------------------|");
        System.out.println("|           MENU           |");
        System.out.println("|--------------------------|");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Task1          |");
        System.out.println("|        2. Task2          |");
        System.out.println("|        3. Exit           |");
        System.out.println("|--------------------------|");
    }

    public static void main(String[] args) {
        System.out.println(" Lab 4");
        Scanner in = new Scanner(System.in);
        int ch = 1;
        while (ch != 4) {
            printMenu();
            System.out.print("Select option:");
            ch = in.nextInt();
            switch (ch) {
                case 1:
                    Task1.task1();
                    break;
                //case 2 : Task2(); break;
                case 3:
                    return;
            }
        }
    }
}
