package easy.array;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascal {
	public List<List<Integer>> generate(int numRnows){
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<=numRnows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	}
	
	public List<Integer> getRow(int rowIndex){
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<rowIndex;i++){
			result.add(0, 1);
			for(int j = 1;j<result.size()-1;j++){
				result.set(j, result.get(j)+result.get(j+1));
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int numRnows = 3;
		GeneratePascal ge = new GeneratePascal();
		List<Integer> f = ge.getRow(numRnows);
		System.out.println(f);
	}
}
