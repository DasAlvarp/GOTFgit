package com.alvarpq.GOTF.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.alvarpq.GOTF.GOTF;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 750;
		config.height = 500;
		new LwjglApplication(new GOTF(), config);
	}
}
