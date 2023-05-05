import java.util.Random;

public class Population {
    private int size;
    private double[][] population;
    private double[] fitnessValues;
    private double averageFitness;

    // Konstruktor klasy Population
    public Population(int size) {
        this.size = size;
        population = new double[size][2];
        fitnessValues = new double[size];
        averageFitness = 0.0;
    }

    // Metoda do generowania populacji osobników
    public void generatePopulation() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            double x1 = rand.nextDouble() * 4 - 2; // wartości od -2 do 2
            double x2 = rand.nextDouble() * 4 - 2; // wartości od -2 do 2
            population[i][0] = x1;
            population[i][1] = x2;
            // Sprawdzenie dopuszczalności osobnika
            while (!isIndividualValid(i)) {
                x1 = rand.nextDouble() * 4 - 2;
                x2 = rand.nextDouble() * 4 - 2;
                population[i][0] = x1;
                population[i][1] = x2;
            }
        }
    }

    // Metoda do sprawdzania dopuszczalności osobnika
    private boolean isIndividualValid(int index) {
        double x1 = population[index][0];
        double x2 = population[index][1];
        return x1 >= -2 && x1 <= 2 && x2 >= -2 && x2 <= 2;
    }

    // Metoda do wyznaczania wartości funkcji przystosowania dla każdego osobnika
    public void evaluateFitness() {
        for (int i = 0; i < size; i++) {
            double x1 = population[i][0];
            double x2 = population[i][1];
            double fitness = -Math.pow(x1, 2) - Math.pow(x2, 2) + 2;
            fitnessValues[i] = fitness;
        }
    }

    // Metoda do wyświetlania wszystkich chromosomów z populacji
    public void displayPopulation() {
        for (int i = 0; i < size; i++) {
            System.out.println("Chromosom " + (i + 1) + ": (" + population[i][0] + ", " + population[i][1] + ")");
        }
    }

    // Metoda do wyświetlania wartości funkcji przystosowania dla każdego chromosomu
    public void displayFitnessValues() {
        for (int i = 0; i < size; i++) {
            System.out.println("Wartość funkcji przystosowania dla chromosomu " + (i + 1) + ": " + fitnessValues[i]);
        }
    }

    // Metoda do wyświetlania chromosomów wraz z wartościami funkcji przystosowania
    public void displayPopulationWithFitnessValues() {
        for (int i = 0; i < size; i++) {
            System.out.println("Chromosom " + (i + 1) + ": (" + population[i][0] + ", " + population[i][1] + "), wartość funkcji przystosowania: " + fitnessValues[i]);
        }
    }

    // Metoda do wyznaczania średniej wartości funkcji przystosowania w populacji
    public void calculateAverage() {
        double sum = 0.0;
        for (int i = 0; i < fitnessValues.length; i++) {
            sum += fitnessValues[i];
        }
        double avg = sum / fitnessValues.length;
        System.out.println("Średnia wartość funkcji przystosowania: " + avg);
    }

    // Metoda do wyznaczania liczby osobników, których wartość funkcji przystosowania jest mniejsza niż średnia
    public void countBelowAverage() {
        double sum = 0.0;
        for (int i = 0; i < fitnessValues.length; i++) {
            sum += fitnessValues[i];
        }
        double avg = sum / fitnessValues.length;
        int count = 0;
        for (int i = 0; i < fitnessValues.length; i++) {
            if (fitnessValues[i] < avg) {
                count++;
            }
        }
        System.out.println("Liczba osobników o wartości funkcji przystosowania mniejszej od średniej: " + count);
    }

    // Metoda do wyznaczania liczby osobników, których wartość funkcji przystosowania jest większa lub równa średniej
    public void countAboveAverage() {
        double sum = 0.0;
        for (int i = 0; i < fitnessValues.length; i++) {
            sum += fitnessValues[i];
        }
        double avg = sum / fitnessValues.length;
        int count = 0;
        for (int i = 0; i < fitnessValues.length; i++) {
            if (fitnessValues[i] >= avg) {
                count++;
            }
        }
        System.out.println("Liczba osobników o wartości funkcji przystosowania większej lub równej średniej: " + count);
    }

}
