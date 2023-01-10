/* You have an inventory of different colored balls, and there is a customer that wants orders balls of any color... The customer weirdly values the colored balls... Each colored ball's value is the number of balls of that color you currently have in your inventory... For example, if you own 6 yellow balls, the customer would pay 6 for the first yellow ball... After the transaction, there are only 5 yellow balls left, so the next yellow ball is then valued at 5 (i.e., the value of the balls decreases as you sell more to the customer)... You are given an integer array, inventory, where inventory[i] represents the number of balls of the ith color that you initially own... You are also given an integer orders, which represents the total number of balls that the customer wants... You can sell the balls in any order... Return the maximum total value that you can attain after selling orders colored balls...
 * Eg 1: inventory = [2,5]         orders = 4    Output = 14 = 2 + 5 + 4 + 3
 * Eg 2: inventory = [3,5]         orders = 6    Output = 19 = 5 + 4 + 3 + 3 + 2 + 2
  */
import java.util.*;
public class Coloured
{
    public int MaxProfit(int array[], int order)
    {
        int sum = 0, orders = 0, i = 0, index = array.length-1;
        do
        {
            sum = sum + array[index-i];   // Evaluating the sum by decreasing the maximum value...
            array[index-i]--;    // The current ball price reduced...
            if(index-i == 0)
                i = 0;  // If we have reached the left end, we have no choice but to decrement only left...
            if(array[index-i] < array[index-i-1])
                i++;    // If right value gets lower, we move towards left...
            orders++;
        }while(orders != order);
        return sum;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, p;
        System.out.print("Enter the number of Coloured balls : ");
        x = sc.nextInt();
        System.out.print("Enter the number of Orders : ");
        p = sc.nextInt();
        int balls[] = new int[x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter the number of balls of "+(i+1)+" Color : ");
            balls[i] = sc.nextInt();
        }
        Arrays.sort(balls);
        Coloured coloured = new Coloured();      // Object creation...
        System.out.println("The Maximum Profit that can be gained : "+coloured.MaxProfit(balls, p));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(1) space...

/* DEDUCTIONS :- 
 * 1. We sort the array, to get the prices of each coloured ball...
 * 2. The Balls of maximum quantity must be removed first, because the greater quantity balls have greater prices...
 * 3. When the number of balls of two balls becomes same, we can move towards left to choose the next ball...
 */