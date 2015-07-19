package com.alvarpq.GOTF.oldgui.screen;
public class ScreenManager {

	private static Screen currentScreen;
	
	public static void setScreen(Screen sc){
		if(currentScreen !=null){
			currentScreen.dispose();
		}
		currentScreen=sc;
		currentScreen.create();
	}
	
	public static Screen getCurrentScreen(){
		return currentScreen;
	}
	
}
