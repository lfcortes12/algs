package com.ex.training.algs;

import java.util.Arrays;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
   private static final int INACTIVE = 0;
   private static final int ACTIVE = 1;

   // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

   public int calculateState(int left, int right) {
      return left == right ? INACTIVE : ACTIVE;
   }

   public void printState(final int[] houseStates) {
      System.out.println(Arrays.stream(houseStates).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
   }

   public List<Integer> cellCompete(int[] states, int days) {
      int[] previousState = null;
      for (int i = 0; i < days; i++) {
         previousState = states.clone();
         nextDayStatus(states, previousState);
      }
      printState(states);
      return IntStream.of(states).boxed().collect(Collectors.toList());

   }

   private void nextDayStatus(int[] states, int[] previousState) {
      int leftNeighbor;
      int rightNeighbor;
      for (int j = 0; j < states.length; j++) {
         if (j == 0) {
            leftNeighbor = INACTIVE;
            rightNeighbor = previousState[j + 1];
         } else if (j == states.length - 1) {
            leftNeighbor = previousState[j - 1];
            rightNeighbor = INACTIVE;
         } else {
            leftNeighbor = previousState[j - 1];
            rightNeighbor = previousState[j + 1];
         }

         states[j] = calculateState(leftNeighbor, rightNeighbor);
      }
   }
   // METHOD SIGNATURE ENDS

   public static void main(String[] args) {

      int statesOne[] = { 1, 0, 0, 0, 0, 1, 0, 0 };
      int statesTwo[] = { 1, 1, 1, 0, 1, 1, 1, 1 };

      Solution solution = new Solution();
      solution.cellCompete(statesOne, 1);
      solution.cellCompete(statesTwo, 2);

   }
}