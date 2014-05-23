package GUI;


public class MainGUI {
		
	private static MainFrame mainFrame;
	
	public static void main(String[] args) {
		mainFrame = new MainFrame();
	}
	public static MainFrame getCurrentFrame(){
		return mainFrame;
	}
	
}
