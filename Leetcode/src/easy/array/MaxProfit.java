package easy.array;

public class MaxProfit {
	 public int maxProfit(int[] prices) {
		if(prices.length == 0){
			return 0;
		}else{
			int max = 0;
			int min = prices[0];
			int profit = 0;
			for(int i = 0; i < prices.length;i++){
				if(prices[i] < min){
					min = prices[i];
				}else{
					if((prices[i]-min)>max){
						max = prices[i] - min;
					}
				}
			}
			profit = max;
			return profit;
		}

	  }
}
