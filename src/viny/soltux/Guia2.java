
package viny.soltux;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
Cacho de Cacho 
Android Videogame
Copyright (C) 2012 Ketanolab contacto@ketanolab.com
This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.
   Author:Vinicius Da Silva Limachi   dasilvavinic7@gmail.com
*/
public class Guia2 extends BaseExample {
	
	private static final int CAMERA_WIDTH = 720;
	private static final int CAMERA_HEIGHT = 480;

	private Camera mCamera;
	private BitmapTextureAtlas mBitmapTextureAtlas;
	private BitmapTextureAtlas flechaDer;
	private BitmapTextureAtlas flechaIzq;
	private TextureRegion mFaceTextureRegion;
	private TiledTextureRegion tfd;
	private TiledTextureRegion tfi;

	@Override
	public Engine onLoadEngine() {   
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE, new FillResolutionPolicy(), this.mCamera);
        engineOptions.getTouchOptions().setRunOnUpdateThread(true);
        final Engine engine = new Engine(engineOptions);
        return engine;
	} 
        
	@Override
	public void onLoadResources() {
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.flechaDer= new BitmapTextureAtlas(512,512,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.flechaIzq= new BitmapTextureAtlas(512,512,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "tuto2.png", 0, 0);
		this.tfd = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.flechaDer, this, "flecha-derecha.png",0,0,2,1);
		this.tfi = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.flechaIzq, this, "flecha-izquierda.png",0,0,2,1);
		this.mEngine.getTextureManager().loadTextures(this.mBitmapTextureAtlas,this.flechaDer,this.flechaIzq);
	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		final Scene scene = new Scene();
		final Sprite face = new Sprite(0, 0, this.mFaceTextureRegion);
		scene.attachChild(face);
		final AnimatedSprite botonDer= new AnimatedSprite(600,360,this.tfd){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					this.setCurrentTileIndex(1);
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					this.setCurrentTileIndex(0);
					Intent a = new Intent(Guia2.this,Guia3.class);
					Guia2.this.startActivity(a);
					Guia2.this.finish();
				}
			return true;
		}
		};
		final AnimatedSprite botonIzq= new AnimatedSprite(-20,360,this.tfi){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					this.setCurrentTileIndex(1);
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					this.setCurrentTileIndex(0);
					Intent a = new Intent(Guia2.this,Guia1.class);
					Guia2.this.startActivity(a);
					Guia2.this.finish();
				}
			return true;
		}
		};
		botonIzq.setScale(0.5f);
		botonDer.setScale(0.5f);
		scene.attachChild(botonIzq);
		scene.attachChild(botonDer);
		scene.registerTouchArea(botonIzq);
		scene.registerTouchArea(botonDer);
		return scene;
	}

	@Override
	public void onLoadComplete() {

	}
	@Override
	public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent) {
		if (pKeyCode == KeyEvent.KEYCODE_BACK) {
			
			
		}
		if (pKeyCode == KeyEvent.KEYCODE_MENU){
				
		}

	
		return true;
	}
}