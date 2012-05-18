
package viny.soltux;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.modifier.LoopEntityModifier;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.util.GLHelper;

import android.content.Intent;
import android.view.KeyEvent;
   
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
public class Salida extends BaseExample {
	int a;
	private static final int CAMERA_WIDTH = 720;
	private static final int CAMERA_HEIGHT = 480;
	private Camera mCamera;
	private BitmapTextureAtlas mBitmapTextureAtlas;
	private TextureRegion mFaceTextureRegion;
    
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
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "salida.png", 0, 0);
		a = (int) System.currentTimeMillis()+2500;
		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		final Scene scene = new Scene();
		final Sprite face = new Sprite(0, 0, this.mFaceTextureRegion) {
			@Override
			protected void applyRotation(final GL10 pGL) {
				if((int)System.currentTimeMillis()>a){	
					Salida.this.finish();
				}
			}
		}; 
		scene.attachChild(face);
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