package com.alvarpq.GOTF.desktop;
import com.alvarpq.GOTF.GOTF;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1080;
		config.height = 829;
		new LwjglApplication(new GOTF(), config);
	}
}
