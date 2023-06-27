public class Converter {

    private final int kilometerInCentimeters = 100_000;
    private final int stepInCentimeters = 75;
    int convertToKm(int stepCount) {
        if (stepCount > 0) {
            return stepCount * stepInCentimeters / kilometerInCentimeters;
        }
        return 0;
    }

    private final int caloriesInOneKilocalorie = 1000;
    private final int stepInCalories = 50;

    int convertStepsToKilocalories(int stepCount) {
        return stepCount * stepInCalories / caloriesInOneKilocalorie;
    }
}
