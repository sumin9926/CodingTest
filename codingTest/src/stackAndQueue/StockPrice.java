package codingTest.src.stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2,1,3,2,1})));
    }
    public static int[] solution(int[] prices){
        Queue<Integer> pricesQ=new LinkedList<>();
        for(int i:prices){
            pricesQ.add(i);
        }
        int[] result = new int[prices.length];
        Arrays.fill(result, 0);
        int index=0;

        while(pricesQ.size()>1){
            int referencePrice=pricesQ.poll(), qSize=pricesQ.size(), i=0;
            for( ; i<qSize; i++){
                int price = pricesQ.poll();
                pricesQ.add(price);
                result[index]+=1;
                if(price<referencePrice) break;
            }
            if(i<qSize-1){
                i++;
                for( ; i<qSize; i++){
                    int price = pricesQ.poll();
                    pricesQ.add(price);
                }
            }
            index++;
        }

        return result;
    }
}
