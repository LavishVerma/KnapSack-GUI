
package knapsack_awt;
import java.util.*;



public class knapsack
{
int matrix[][] = new int[100][100];
int picks[][] = new int[100][100];
Integer[] weights,values;
 int knapsackSize,nItems;
    ArrayList<Integer> items=new ArrayList<>();
 
     Integer TotalWeight()
     {
      return knapsack(nItems,knapsackSize,weights,values);   
     }
  
    ArrayList<Integer> TotalItems()
    {
        return items;
    }

void accept(ArrayList<Integer> value,ArrayList<Integer> weight,String knapsackweight,int size)
{
  weights=new Integer[weight.size()];
 weights=weight.toArray(weights);
  
  values=new Integer[value.size()];
 values=value.toArray(values);
 knapsackSize=Integer.parseInt(knapsackweight);
 
  nItems =size;
 System.out.println(knapsack(nItems,knapsackSize,weights,values));
 printPicks(nItems,knapsackSize, weights);
}
    /*public knapsack() 
    {
       
   
   
    

    System.out.println(knapsack(nItems,knapsackSize,weights,values));
   
    printPicks(nItems,knapsackSize, weights);
    }
*/

int max(int a,int b){return (a>b)?a:b;}



 int knapsack(int nItems, int size, Integer weights[], Integer values[]){
    int i,j;

    for (i=1;i<=nItems;i++){
        for (j=0;j<=size;j++){
            if (weights[i-1]<=j){
                matrix[i][j] = max(matrix[i-1][j],values[i-1]+matrix[i-1][j-weights[i-1]]);
                if (values[i-1]+matrix[i-1][j-weights[i-1]]>matrix[i-1][j])
                    picks[i][j]=1;
                else
                    picks[i][j]=-1;
            }
            else{
                picks[i][j] = -1;
                matrix[i][j] = matrix[i-1][j];
            }
        }
    }

    return matrix[nItems][size];

}

void printPicks(int item, int size, Integer weights[]){

    while (item>0){
        if (picks[item][size]==1)
        {
            System.out.println(item-1);
            items.add(item-1);
            item--;
            size -= weights[item];
        }
        else{
            item--;
        }
    }

    
return;
}

/*public static void main(String A[])
{
   

   new knapsack();
}*/
}