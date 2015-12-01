import java.util.Random;


public class Test {
	
	/*
	 * VREDNOSTI TESTA:
	 * Celoten test ima 6 tezavnostnih stopenj
	 * Na vsaki stopnji bo 20 iteracij
	 * 
	 * test napreduje z funkcijo advance()
	 */
	private int tezavnostna_stopnja=0;
	private int iteracija=0;
	public boolean konec;
	private int prejsnji=-1;//najmanjsi indeks prejsnjega testa
	
	
	
	
	

	public Test() {//tle bojo samo vrednosti ki nj jih meèe na ekran
		// TODO Auto-generated constructor stub
		this.create_iteration();
	}

	public void advance() {//pobrise prejsnji test in napreduje
		Tester.panel.pa=false;
		Tester.panel.ps=false;
		Tester.panel.pd=false;
		Tester.panel.pf=false;
		iteracija++;
		if(iteracija==20){iteracija=0; tezavnostna_stopnja++;}
		if(tezavnostna_stopnja==6){konec=true; tezavnostna_stopnja=0;}
		if(konec){System.out.println("KONc TESTA gg wp no re noscope");}
		else{
			this.create_iteration();
		}
	}
	
	public void create_iteration(){//nastavi barve tle se ubistvu ustvarjo vsi testi
		Random ra=new Random();
		int r=ra.nextInt(4);
		if(tezavnostna_stopnja==0){//zaporedje 0123012301230123...
			prejsnji++;
			if(prejsnji==4){prejsnji=0;}
			r=prejsnji;
			if(r==0){Tester.panel.pa=true;}
			if(r==1){Tester.panel.ps=true;}
			if(r==2){Tester.panel.pd=true;}
			if(r==3){Tester.panel.pf=true;}
			System.out.println("Creating iteration: "+r);
		}
		else if(tezavnostna_stopnja==1){//1 cifra med 0-3
			prejsnji=-1;//zato da naslednji if dela normalno
			if(r==0){Tester.panel.pa=true;}
			if(r==1){Tester.panel.ps=true;}
			if(r==2){Tester.panel.pd=true;}
			if(r==3){Tester.panel.pf=true;}
			System.out.println("Creating iteration: "+r);
		}else if(tezavnostna_stopnja==2){//zaporedje 01 12 23 30 01 12 23...
			prejsnji++;
			if(prejsnji==4){prejsnji=0;}
			r=prejsnji;
			if(r==0){Tester.panel.pa=true;Tester.panel.ps=true;}
			if(r==1){Tester.panel.ps=true;Tester.panel.pd=true;}
			if(r==2){Tester.panel.pd=true;Tester.panel.pf=true;}
			if(r==3){Tester.panel.pf=true;Tester.panel.pa=true;}
			System.out.println("Creating iteration: "+r+"sosednji desni");
		}
		else if(tezavnostna_stopnja==3){//2 cifri
			int x=r;
			r=ra.nextInt(4);
			while(r==x){
				r=ra.nextInt(4);
			}
			if(r==0 || x==0){Tester.panel.pa=true;}
			if(r==1 || x==1){Tester.panel.ps=true;}
			if(r==2 || x==2){Tester.panel.pd=true;}
			if(r==3 || x==3){Tester.panel.pf=true;}
			System.out.println("Creating iteration: "+r+" "+x);
		}else{ // 3 cifre
			int x=r;
			r=ra.nextInt(4);
			while(r==x){r=ra.nextInt(4);}
			int y=r;
			r=ra.nextInt(4);
			while(r==y || r==x){r=ra.nextInt(4);}
			//tle bi mogle bit 3 unikatne stevilke
			
			
			
			if(r==0 || x==0 || y==0){Tester.panel.pa=true;}//hardcoded i know -.-
			if(r==1 || x==1 || y==1){Tester.panel.ps=true;}
			if(r==2 || x==2 || y==2){Tester.panel.pd=true;}
			if(r==3 || x==3 || y==3){Tester.panel.pf=true;}
			System.out.println("Creating iteration: "+r+" "+x+" "+r);
		}
		
	}

}
