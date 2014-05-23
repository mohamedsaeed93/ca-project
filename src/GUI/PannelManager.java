package GUI;

public class PannelManager {
	private static MainPanel mainPanel;
	private static SidePanel sidePanel;
	
	static MainPanel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new MainPanel();
		}
		return mainPanel;
	}
	
	static SidePanel getSidePanel() {
		if (sidePanel == null) {
			sidePanel = new SidePanel();
		}
		return sidePanel;
	}
}
