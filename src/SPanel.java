import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class SPanel extends JPanel implements Runnable, KeyListener{
	private Thread thread;
	
	boolean a,s,d,f; // sporoci kter je pritisnjen
	public boolean pa,ps,pd,pf;//pravilni pritiski, ki jih task zahteva. ko se zaporedje ujema z asdf je izziv pravilno rešen.
	
	
	
	
	
	public SPanel(SFrame fr) {
		super();
		thread=new Thread(this);
		thread.start();
		
		fr.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_A){a=true;}
				if(e.getKeyCode()==KeyEvent.VK_S){s=true;}
				if(e.getKeyCode()==KeyEvent.VK_D){d=true;}
				if(e.getKeyCode()==KeyEvent.VK_F){f=true;}
					
				
			}
			
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_A){a=false;}
				if(e.getKeyCode()==KeyEvent.VK_S){s=false;}
				if(e.getKeyCode()==KeyEvent.VK_D){d=false;}
				if(e.getKeyCode()==KeyEvent.VK_F){f=false;}
			}
			
		});
		
	}

	public SPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	
    public void paintComponent(Graphics g) {
    	/* Risanje testa */
        Dimension dim=this.getSize();
        int h=dim.height;
        int w=dim.width;
        super.paintComponent(g);
        if(Tester.t.konec){
        	g.setColor(Color.BLACK);
        	g.fillRect(0, 0, w, h);
        }else{
	        g.setColor(Color.WHITE);

	        if(pa){g.setColor(Color.RED);g.fillRect(0, 0,w/4+1,h);}
	        if(ps){g.setColor(Color.GREEN);g.fillRect(w/4, 0,w/4+1,h);}
	        if(pd){g.setColor(Color.BLUE);g.fillRect(w/2, 0,w/4+1,h);}
	        if(pf){g.setColor(Color.MAGENTA);g.fillRect(3*w/4, 0,w/4+1,h);}
	        g.setColor(Color.WHITE);
	        
	        if(this.passed(a, s, d, f, pa, ps, pd, pf)){
	        	System.out.println("passed");
	        	Tester.t.advance();
	        }
        }

        
        
        
    }

	public void run() {//tle je vse
		// TODO Auto-generated method stub
		while(true){
			repaint();
		}
	}

	public void keyPressed(KeyEvent arg0) {
		
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean passed(boolean a,boolean s,boolean d,boolean f,boolean pa,boolean ps,boolean pd,boolean pf){
		return ((a==pa) && (s==ps) && (d==pd) && (f==pf)); // i think this should work
	}
	
}
