package com.games.starassault.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Block {
	public static final float SIZE = 1f;
	
	Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();
	
	// Getters ---------
	public Vector2 getPosition() {
		return this.position;
	}
	public Rectangle getBounds() {
		return this.bounds;
	}
	// ---------------------
	public Block(Vector2 pos) {
		this.position = pos;
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
}
