import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StepTracker tracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int i = scanner.nextInt();

            if (i == 1) {
                tracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                tracker.changeStepGoal();
            } else if (i == 3) {
                tracker.printStatistic();
            } else if (i == 4) {
                System.out.println("Всего хорошего!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды не существует");
            }
        }
    }

    static void printMenu() {
        System.out.println("Выберите действие, которое хотите выполнить:\n" +
                "1. Ввести количество шагов за определённый день;\n" +
                "2. Изменить цель по количеству шагов в день;\n" +
                "3. Напечатать статистику за определённый месяц;\n" +
                "4. Выйти из приложения.");
    }
}
