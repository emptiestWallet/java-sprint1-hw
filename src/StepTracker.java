import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    private int goalByStepsPerDay;

    StepTracker(Scanner scan) {
        scanner = scan;

        this.goalByStepsPerDay = 10000;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Такого месяца не существует");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int monthDay = scanner.nextInt();
        if (monthDay < 1 || monthDay > 30) {
            System.out.println("Такого дня не существует");
            return;
        }

        System.out.println("Введите количество шагов");
        int stepCount = scanner.nextInt();
        if (stepCount <= 0) {
            System.out.println("Количество шагов не может быть отрицательным");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];
        if (monthData == null) {
            monthData = new MonthData();
            monthToData[monthNumber - 1] = monthData;
        }

        monthData.days[monthDay - 1] = stepCount;
    }

    void changeStepGoal() {
        System.out.println("Текущая цель по количеству шагов в день составляет " + this.goalByStepsPerDay);
        System.out.println("Введите новую цель:");
        int newGoal = scanner.nextInt();
        if (newGoal <= 0) {
            System.out.println("Количество шагов не может быть отрицательным или равным нулю");
        } else {
            this.goalByStepsPerDay = newGoal;
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Такого месяца не существует");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];
        Converter convert = new Converter();

        int sumSteps = monthData.sumStepsFromMonth();
        int averageSteps = sumSteps / monthData.days.length;
        int distance = convert.convertToKm(sumSteps);
        int calories = convert.convertStepsToKilocalories(sumSteps);

        if (monthData != null) {
            monthData.printDaysAndStepsFromMonth();
            System.out.println("Общая сумма шагов за месяц: " + sumSteps);
            System.out.println("Максимальное пройденное количество шагов за месяц: " + monthData.maxSteps());
            System.out.println("Среднее пройденное количество шагов за месяц: " + averageSteps);
            System.out.println("Пройденная за месяц дистанция в км: " + distance);
            System.out.println("Количество сожжённых килокалорий за месяц: " + calories);
            System.out.println("Лучшая серия шагов за месяц: " + monthData.bestSeries(goalByStepsPerDay));
            System.out.println();
        }
    }
}
