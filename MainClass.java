
public class MainClass {
	
	public void goDraw (){
		DrawText draw = new DrawText ();
		Thread t1 = new Thread(draw);
		Thread t2 = new Thread(draw);
		
		t1.setName("my first thread");
		t2.setName("my second thread");
		t1.start();
		t2.start();
	}
	
	
	public static void main (String[]args){
		MainClass mc = new MainClass();
		//for(int i = 0; i < 5; i++){
			mc.goDraw();
		//}
		
		//System.out.println("Thread t1 # - " + t1.getName());
	
	}

}
