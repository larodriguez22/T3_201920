package test.sort;

import model.sort.QuickPedantic;

public class TestQuick {
	private Comparable[] arreglo;
	private static int TAMANO=5;
	private QuickPedantic organizador;
	
	public void setUp1() {
		arreglo= new Comparable[TAMANO];
	}

	public void setUp2() {
		for(int i =0; i< TAMANO; i++){
			
			if(i%2==0){
				arreglo[i]=i;
			}
			else{
				arreglo[i]=i*2;
			}
		}
		QuickPedantic organizador=new QuickPedantic();
	}
	public void setUp3(){
		
		for(int i =0; i< TAMANO; i++){
				
			arreglo[i]=i;
			
		}
	}
	public void setUp4(){
		int j=0;
		for(int i =TAMANO; i> TAMANO; i--){
				
			arreglo[j]=i;
			j++;
		}
	}
	
	public void TestSort(){
		setUp2();
		Comparable aux[]={0,1,2,3,4};
		
		organizador.sort(arreglo);
		
		for (int i=0;i<TAMANO;i++){
			assert equals(arreglo[i]==aux[i]);	
		}
	}
	public void TestSort2(){
		setUp3();
		Comparable aux[]={0,1,2,3,4};
			
		organizador.sort(arreglo);
			
		for (int i=0;i<TAMANO;i++){
			assert equals(arreglo[i]==aux[i]);	
			}
	}
		
		public void TestSort3(){
			setUp4();
			Comparable aux[]={0,1,2,3,4};
			
			organizador.sort(arreglo);
			
			for (int i=0;i<TAMANO;i++){
				assert equals(arreglo[i]==aux[i]);	
			}
	}
}
