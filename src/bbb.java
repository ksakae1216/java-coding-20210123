package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bbb {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;

    // 13 5 5
    // 900 600 700 600 2000 2300 1600 500 2800 1500 1900 2200 2500
    // N 商品数
    // クーポンA X 5%
    // クーポンB Y -100
    int cnt = 0;
    int item = 0;
    int couponA = 0;
    int couponB = 0;
    int total = 0;
    while ((line = in.readLine()) != null) {
        if(cnt == 0) {
            String[] str = line.split(" ");
            item = Integer.parseInt(str[0]);
            couponA = Integer.parseInt(str[1]);
            couponB = Integer.parseInt(str[2]);
        } else {
            int[] items = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            
            for(int i = item-1; i != 0; i--) {
              int patternA = 0;
              int patternB = 0;

              if(couponA != 0) {
                patternA = (int)(items[i] * 0.95);
              } else {
                patternA = items[i];
              }

              if(couponB != 0) {
                patternB = items[i] - 100;
              } else {
                patternB = items[i];
              }
              
              if(patternA < patternB && couponA != 0) {
                couponA-=1;
                total += patternA;
              } else if(couponB != 0) {
                couponB-=1;
                total += patternB;
              } else {
                total += items[i];
              }
            }
            System.out.println(total);
        }
    //   System.out.println(line);
        cnt++;
    }
    System.out.println(item);
  }

}