package com.ex.training.algs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class GDC {

   int gcd(final int a, final int b) {
      System.out.println("GDC");
      if (a == 0)
         return b;
      return gcd(b % a, a);
   }

   public int generalizedGCD(final int num, final int[] arr) {
      final List<Integer> list = Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
      int result = arr[0];
      for (int i = 0; i < num; i++) {
         result = gcd(list.get(i), result);
      }
      return result;
   }

   public static void main(String[] args) {

      int statesOne[] = { 2, 4, 6, 8, 10 };
      int statesTwo[] = { 2, 3, 4, 5, 6 };

      GDC solution = new GDC();
      solution.generalizedGCD(5, statesTwo);
      solution.generalizedGCD(5, statesOne);
   }
}