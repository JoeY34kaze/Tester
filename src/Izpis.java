
public class Izpis {
	public String naslov;
	public String content;

	public Izpis(String naslov) {
		this.naslov=naslov;
	}
	
	public void add(String x){
		this.content+=x+"\n";
	}

}
