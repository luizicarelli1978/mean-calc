/**
 * Water Consumption Calculator
 * Calculates ideal daily water intake based on various factors
 */
public class WaterConsumptionCalculator {

    /**
     * Calculation method using body weight
     * Standard formula: weight (kg) × 35 mL = daily water intake
     *
     * @param weightKg Body weight in kilograms
     * @return Daily water intake in milliliters
     */
    public static double calculateByWeight(double weightKg) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        return weightKg * 35;
    }

    /**
     * Calculation method using body weight in pounds
     * Converts to kg first, then applies formula
     *
     * @param weightLbs Body weight in pounds
     * @return Daily water intake in milliliters
     */
    public static double calculateByWeightPounds(double weightLbs) {
        double weightKg = weightLbs * 0.453592;
        return calculateByWeight(weightKg);
    }

    /**
     * 8x8 rule: 8 glasses of 8 oz each
     * Simple baseline recommendation
     *
     * @return Daily water intake in milliliters (approximately 2.3L)
     */
    public static double calculateBy8x8Rule() {
        return 8 * 237; // 8 fl oz = ~237 mL
    }

    /**
     * Advanced calculation considering activity level and climate
     *
     * @param weightKg Body weight in kilograms
     * @param activityLevel Activity multiplier (1.0 = sedentary, 1.5 = moderate, 2.0 = very active)
     * @param climateMultiplier Climate factor (1.0 = temperate, 1.2-1.5 = hot/humid)
     * @return Daily water intake in milliliters
     */
    public static double calculateAdvanced(double weightKg, double activityLevel, double climateMultiplier) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        if (activityLevel <= 0) {
            throw new IllegalArgumentException("Activity level must be positive");
        }
        if (climateMultiplier <= 0) {
            throw new IllegalArgumentException("Climate multiplier must be positive");
        }

        double baseIntake = calculateByWeight(weightKg);
        return baseIntake * activityLevel * climateMultiplier;
    }

    /**
     * Calculate with pre-defined activity levels
     *
     * @param weightKg Body weight in kilograms
     * @param activityLevel Predefined: SEDENTARY, MODERATE, ACTIVE, VERY_ACTIVE
     * @param climateType Predefined: COLD, TEMPERATE, HOT
     * @return Daily water intake in milliliters
     */
    public static double calculateWithDefaults(double weightKg, ActivityLevel activityLevel, ClimateType climateType) {
        return calculateAdvanced(weightKg, activityLevel.getMultiplier(), climateType.getMultiplier());
    }

    /**
     * Convert milliliters to liters
     */
    public static double toLiters(double milliliters) {
        return milliliters / 1000;
    }

    /**
     * Convert milliliters to fluid ounces (US)
     */
    public static double toFluidOunces(double milliliters) {
        return milliliters / 29.5735;
    }

    /**
     * Convert milliliters to cups (US)
     */
    public static double toCups(double milliliters) {
        return milliliters / 236.588;
    }

    /**
     * Activity Level Enum
     */
    public enum ActivityLevel {
        SEDENTARY(1.0, "Little or no exercise"),
        MODERATE(1.3, "Exercise 3-4 days per week"),
        ACTIVE(1.5, "Exercise 5-6 days per week"),
        VERY_ACTIVE(2.0, "Daily exercise or intense training");

        private final double multiplier;
        private final String description;

        ActivityLevel(double multiplier, String description) {
            this.multiplier = multiplier;
            this.description = description;
        }

        public double getMultiplier() {
            return multiplier;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * Climate Type Enum
     */
    public enum ClimateType {
        COLD(1.0, "Cold climate"),
        TEMPERATE(1.0, "Temperate climate"),
        HOT(1.3, "Hot/humid climate");

        private final double multiplier;
        private final String description;

        ClimateType(double multiplier, String description) {
            this.multiplier = multiplier;
            this.description = description;
        }

        public double getMultiplier() {
            return multiplier;
        }

        public String getDescription() {
            return description;
        }
    }
}
