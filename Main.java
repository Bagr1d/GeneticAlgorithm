public class Main {
    public static void main(String[] args) {
        Population population = new Population(10);
        population.generatePopulation();
        population.evaluateFitness();
        population.displayPopulationWithFitnessValues();
        population.displayFitnessValues();
        population.displayPopulation();
        population.calculateAverage();
        population.countBelowAverage();
        population.countAboveAverage();
    }
}
