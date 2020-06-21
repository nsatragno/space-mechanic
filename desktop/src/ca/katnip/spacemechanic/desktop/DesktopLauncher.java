package ca.katnip.spacemechanic.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ca.katnip.spacemechanic.Main;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Space Mechanic";
		config.width = 640;
		config.height = 360;
		config.fullscreen = false;
		config.vSyncEnabled = true;
		new LwjglApplication(new Main(), config);
	}
}
