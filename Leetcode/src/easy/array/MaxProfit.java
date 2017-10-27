package easy.array;

public class MaxProfit {
	 public int maxProfit(int[] prices) {
		 int maxprofit = 0;
	     if(prices.length >=2){
	    	 int maxtemp = 0;
	    	 if(prices[1]>=prices[0]){
	    		 maxtemp = prices[1] - prices[0];
	    	 }
	    	 for(int i = 2;i<prices.length;i++){
	    		 int value = prices[i] - prices[i-1];
	    		 if(value>0){
	    			 if((prices[i] - prices[i-1])> maxtemp+value)
	    			 maxtemp = maxtemp + value;
	    		 }
	    	 }
	    	 
	     }
	     return maxprofit;
	  }
}
