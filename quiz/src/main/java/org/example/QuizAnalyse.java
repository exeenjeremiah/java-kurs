package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QuizAnalyse {

    public int sum(int[] results) {
        int sum = 0;
        for (int result : results) {
            sum += result;
        }
        return sum;
    }

    public double average(int[] results) {
        if (results.length == 0) {
            return 0.0;
        }
        return (double) sum(results) / results.length;
    }

    public int countPassed(int[] results) {
        int count = 0;
        for (int result : results) {
            if (result >= 50) {
                count++;
            }
        }
        return count;
    }

    public int min(int[] results) {
        if (results.length == 0) {
            return 0;
        }
        int minimum = results[0];
        for (int result : results) {
            if (result < minimum) {
                minimum = result;
            }
        }
        return minimum;
    }

    public int max(int[] results) {
        if (results.length == 0) {
            return 0;
        }
        int maximum = results[0];
        for (int result : results) {
            if (result > maximum) {
                maximum = result;
            }
        }
        return maximum;
    }

    public String evaluateAverage(double average) {
        if (average < 50) {
            return "Powtórz!";
        } else if (average < 80) {
            return "Fajny wynik!";
        }
        return "Bardzo fajny wynik!";
    }

    public Set<Integer> uniqueResults(int[] results) {
        Set<Integer> unique = new HashSet<>();
        for (int result : results) {
            unique.add(result);
        }
        return unique;
    }

    public Map<Integer, Integer> frequencies(int[] results) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int result : results) {
            counts.put(result, counts.getOrDefault(result, 0) + 1);
        }
        return counts;
    }

    public int[] scoreRanges(int[] results) {
        int[] ranges = new int[3];
        for (int result : results) {
            if (result < 50) {
                ranges[0]++;
            } else if (result < 80) {
                ranges[1]++;
            } else {
                ranges[2]++;
            }
        }
        return ranges;
    }

    public double passingPercentage(int[] results) {
        if (results.length == 0) {
            return 0.0;
        }
        return countPassed(results) * 100.0 / results.length;
    }
}