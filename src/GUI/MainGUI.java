package GUI;


public class MainGUI {
		
	public static MainFrame mainFrame;
	
	public static void main(String[] args) {
		mainFrame = new MainFrame();
	}
	public static MainFrame getCurrentFrame(){
		return mainFrame;
	}
	
}
