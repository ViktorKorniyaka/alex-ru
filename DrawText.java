


public class DrawText extends MainClass implements Runnable{
	
	int count;
	
	public void run (){
		
		for(int i = 0; i<=400; i++){ // ������ ������ ��������� ���� � �� �� �������� � ����� filtrArrayList
			
			read();
			count++;
		}
		
		System.out.println("Thread # - "+ Thread.currentThread()+ "Count = "+ count);
		//writefiltrArrayList ();
		test();
	}
	
	
	

}
