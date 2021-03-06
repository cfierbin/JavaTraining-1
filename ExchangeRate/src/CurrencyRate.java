
public class CurrencyRate {

	private String to;
	private String from;
	private String rate;
	
	public CurrencyRate(String to, String rate, String from){
		this.to = to;
		this.rate = rate;
		this.from = from;
	}
	
	public void print(){
		System.out.println("Last currency rate from "+from+" to "+to+" is "+rate);
	}
	
	
	public double getValue(){
		return Double.parseDouble(rate);
	}
	
}
