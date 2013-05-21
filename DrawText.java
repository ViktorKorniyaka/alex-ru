


public class DrawText extends MainClass implements Runnable{
	
	int count;
	
	public void run (){
		
		for(int i = 0; i<=400; i++){ // походу потоки добавляют одно и то же значение в масив filtrArrayList
			
			read();
			count++;
		}
		
		System.out.println("Thread # - "+ Thread.currentThread()+ "Count = "+ count);
		//writefiltrArrayList ();
		test();
	}
	
	
	

}
