package kunalsProblems.arrays.easy;

import java.util.Arrays;

public class Problem7MaxPopulationYear {

    /*
        LeetCode : 1854. Link : https://leetcode.com/problems/maximum-population-year/description/
     */

    public static void main(String[] args) {
        int[][] logs = {
                {1993, 1999},
                {2000, 2010},
                {1990, 2000}
        };

        maximumPopulation1(logs);
        maximumPopulation2(logs);
    }

    public static int maximumPopulation1(int[][] logs) {

        /*
            In this solution, we have taken as 1950 to 2050 only with the array size 101.
            Because, this is the leeetcode constraint.

            But, what if the year range was not provided. See solution 2
         */
        int[] population = new int[101]; // index 0 = 1950, index 100 = 2050

        for (int[] log : logs) {
            population[log[0] - 1950]++;
            population[log[1] - 1950]--;
        }

        int maxYear = 1950;
        int maxPop = 0;
        int currPop = 0;

        for (int i = 0; i < 101; i++) {
            currPop += population[i];
            if (currPop > maxPop) {
                maxPop = currPop;
                maxYear = 1950 + i;
            }
        }

        return maxYear;
    }

    public static int maximumPopulation2(int[][] logs) {
        /*
            Intution :
            ----------
            The idea is to:

            Simulate population changes in chronological order by looking at when people are born and when they die.

            🔍 Why Sort Separately?
            You're breaking down the problem into two separate timelines:

            1. One for birth events
            2. One for death events

            By sorting both:

            # You can process births and deaths in order (like merging two timelines).
            # This allows you to simulate how the population evolves year by year — without explicitly iterating over every single year (which is useful when year range is large or unknown).

            🔁 Intuition for the Two Pointers
            * birthPointer → moves forward as new people are born
            * deathPointer → moves forward as people die before the next birth

            IMPORTANT NOTE:
            ===============
            At each step:

            1. Before a birth year is processed, check if someone already died (death[deathPointer] <= birth[birthPointer]).
            2. If yes, decrement current population.
            3. You're cleaning up old lives before adding a new one.
            4. Add the new person being born.
            5. Check if population is the highest so far, and if yes, update the result.

            This mimics real life: before someone is born in a year, people who already passed away are no longer counted.

         */
        int[] birth = new int[logs.length];
        int[] death = new int[logs.length];

        for(int i = 0; i < logs.length; i++) {
            birth[i] = logs[i][0];
            death[i] = logs[i][1];
        }

        Arrays.sort(birth);
        Arrays.sort(death);

        int year = 0;
        int lives = 0;
        int maxLives = 0;

        int birthPointer = 0, deathPointer = 0;
        while(birthPointer < birth.length) {
            while(deathPointer < birthPointer && death[deathPointer] <= birth[birthPointer]) {
                lives--;
                deathPointer++;
            }

            lives += 1;
            if(lives > maxLives) {
                year = birth[birthPointer];
                maxLives = lives;
            }

            birthPointer++;
        }

        return year;
    }

}
