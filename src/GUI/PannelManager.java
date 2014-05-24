package GUI;

public class PannelManager {
	private static MainPanel mainPanel;
	private static SidePanel sidePanel;
	private static CenterPanel centerPanel;
	private static ConsolPanel consolPanel;
	
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
	
	static CenterPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new CenterPanel();
		}
		return centerPanel;
	}
	static ConsolPanel getConsolPanel() {
		if (consolPanel == null) {
			consolPanel = new ConsolPanel();
		}
		return consolPanel;
	}
}
