package moreContainer;

public class FindWordCount {
	int index;
	Object[][] pairs;
	
	FindWordCount(int length){
		this.pairs = new Object[length][2];
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i<index;i++){
			builder.append(pairs[i][0]);
			builder.append(":");
			builder.append(pairs[i][1]);
			if(i < index -1){
				builder.append("\n");
			}
		}
		return builder.toString();
	}
	
	public void put(String key){
		if(index >= pairs.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int i = 0;i<index;i++){
			if(pairs[i][0].equals(key)){
				pairs[i][1] = (Integer)pairs[i][1] + 1;
				return;
			}
		}
		pairs[index++] = new Object[]{key, 1};
	}
	
	public Integer get(String key){
		for(int i = 0; i<index;i++){
			if(pairs[i][0].equals(key)){
				return (Integer) pairs[i][1];
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		FindWordCount f = new FindWordCount(20);
		String[] s = "we are we are the best one man man man".split(" ");
		for(String word:s){
			f.put(word);
		}
		System.out.println(f);
		System.out.println(f.get("we"));
	}
}
