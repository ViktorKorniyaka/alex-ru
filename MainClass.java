import java.util.*;

public class MainClass {
	List<Integer> fibonachi = new ArrayList();
	List<Integer> filtrArrayList = new ArrayList();
	List<Integer> bigArray = new ArrayList();

	public void goDraw() {
		DrawText draw = new DrawText();
		Thread t1 = new Thread(draw);
		Thread t2 = new Thread(draw);
		Thread t3 = new Thread(draw);
		
		t1.setName("my first thread");
		t2.setName("my second thread");
		t3.setName("my therd thread");
		t1.start();
		t2.start();
		t3.start();

	}

	private int nextFibo; // почему в методе drawFibo - The local variable nextFibo may not have been initialized
	private int prevFibo;
	private int bufFibo;
	
	public void drawFibo() {

		for (int i = 0; i < 40; i++) {

			if (i <= 2) {
				nextFibo = i;
				prevFibo = i - 1;
			} else {
				bufFibo = nextFibo;
				nextFibo = prevFibo + bufFibo;
				prevFibo = bufFibo;
			}
			fibonachi.add(nextFibo);
			//System.out.println("fibo = " + fibonachi.get(i));
		}
	}

	public void drawBigArray() {
		for (int i = 0; i <= 1000; i++) {
			bigArray.add(i);
			//System.out.println("Array = " + bigArray.get(i));
		}
	}

	int countReadFibo;
	int bigArrayIndex;

	public synchronized void read (){
		drawFibo();
		drawBigArray();
		
		//System.out.println("countReadFibo = "+countReadFibo);
		//System.out.println("bigArrayIndex = "+bigArrayIndex);
		
		if(/*bigArray.get(bigArrayIndex)*/bigArrayIndex == 	fibonachi.get(countReadFibo)){ // непонятно посчему но когда bigArray.get(bigArrayIndex) = 144 а fibonachi.get(countReadFibo) = 12 заходить в выполняющий блок не хочет 
			
			filtrArrayList.add(fibonachi.get(countReadFibo));
			countReadFibo++;
			bigArrayIndex++;
		} else {
			bigArrayIndex++;
		}
	}

	
	
public void test (){
	System.out.println("Test - size filtrArrayList = " + filtrArrayList.size());
	System.out.println("Test - size filtrArrayList = " + filtrArrayList);
}
	public static void main(String[] args) {
		
		MainClass mc = new MainClass();
		mc.goDraw();
		
		

	}

}
