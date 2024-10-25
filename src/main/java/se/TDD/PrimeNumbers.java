package se.TDD;

public class PrimeNumbers {


    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();

        try {
            //Kalkylerar antalet och summa av primtal mellan 0 - 1000
            int count = primeNumbers.countPrimesInRange(0, 1000);
            int totalSum = primeNumbers.sumPrimesInRange(0, 1000);


            primeNumbers.printCount(count);
            primeNumbers.printSum(totalSum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimesInRange(int start, int end) {
        if (start < 0 || end > 1000 || start > end) {
            throw new IllegalArgumentException("Fel intervall angivet!");
        }
        int count = 0;
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    public int sumPrimesInRange(int start, int end) {
        if (start < 0 || end > 1000 || start > end) {
            throw new IllegalArgumentException("Fel intervall angivet!");
        }
        int totalSum = 0;
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                totalSum += num;
            }
        }
        return totalSum;
    }

    public void printCount(int count) {
        System.out.println("Hej, det finns " + count + " primtal mellan 0 och 1000!");
    }

    public void printSum(int sum) {
        System.out.println("Och den totala summan av dessa primtal är " + sum + ".");
    }
}

