package enumType;
import static enumType.Signal.*;
public class TrafficLight {
	Signal color = Red;
	public void change(){
		switch(color){
			case Red:color = Green;break;
			case Green: color = Yello;break;
			case Yello: color = Red;break;
		}
	}
	
	public String toString(){
		return "the nextlight is "+color;
	}
	
	public static void main(String[] args){
		TrafficLight t = new TrafficLight();
		for(int i=0;i<7;i++){
			System.out.println(t.color);
			t.change();
		}
	}
}
