package com.alvarpq.GOTF.oldgui.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityManager {

	private static ArrayList<Entity> entities=new ArrayList<Entity>();
	
	public static void addEntity(Entity en){
		entities.add(en);
	}
	
	public static void removeEntity(Entity en){
		entities.remove(en);
	}
	
	//ALL RENDERING SHOULD BE HAPPENNING HERE! THAT INCLUDES UNITS AND HEXES!
	public static void renderAll(SpriteBatch batch){
		for(Entity e:entities){
			e.render(batch);
		}
	}
}
