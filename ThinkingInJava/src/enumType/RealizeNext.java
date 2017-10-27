package enumType;

import java.util.Random;

enum CartoonCharacter{
	SLAPPY,
	SPANKY,
	PUNCHY,
	SILLY,
	BOUNCY,
	NUTTY,
	BOB;
	
	Random rand = new Random(47);
	public CartoonCharacter next(){
		return values()[rand.nextInt(7)];
	}
}
public class RealizeNext {
	static CartoonCharacter cartoon = CartoonCharacter.BOB;
	public static void next(){
		System.out.println(cartoon.next());
	}
	
	public static void main(String[] args){
		RealizeNext r = new RealizeNext();
		for(int i = 0;i<7;i++){
			r.next();
		}
	}
}
