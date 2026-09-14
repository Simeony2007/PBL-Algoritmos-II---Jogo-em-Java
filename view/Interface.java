package view;

public class Interface{
	private String text;

	public Interface(String text){
		this.text = text;
	}

	public String getText(){
		return this.text;
	}

	public void setText(String text){
		this.text = text;
	}
}