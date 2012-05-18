
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
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.opengl.util.GLHelper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
public class MenuPrincipal extends BaseExample {
	
	private static final int CAMERA_WIDTH = 720;
	private static final int CAMERA_HEIGHT = 480;
	private Camera mCamera;
	private BitmapTextureAtlas mBitmapTextureAtlas;
	private BitmapTextureAtlas mapaItems;
	private BitmapTextureAtlas iconos;
	private TextureRegion mFaceTextureRegion;
	private TiledTextureRegion item1;
	private TiledTextureRegion item2;
	private TiledTextureRegion item3;
	private TiledTextureRegion item4;
	private TextureRegion facebook;
	private TextureRegion twitter;
	private BitmapTextureAtlas mapaSalir;
	private TiledTextureRegion tsalir;
    
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
		this.mapaItems = new BitmapTextureAtlas(1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mapaSalir = new BitmapTextureAtlas(512, 512, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.iconos = new BitmapTextureAtlas(32, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "fondo1.png", 0, 0);
		this.item1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mapaItems, this, "individual.png", 0, 0,2,1);
		this.item2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mapaItems, this, "equipos.png", 0, 64,2,1);
		this.item3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mapaItems, this, "reglas.png", 0, 128,2,1);
		this.item4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mapaItems, this, "criditos.png", 0, 192,2,1);
		this.tsalir = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mapaSalir, this, "flecha-izquierda.png", 0, 0,2,1);
		this.facebook = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.iconos, this, "face.png", 0, 0);
		this.twitter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.iconos, this, "twit.png", 0, 32);
		this.mEngine.getTextureManager().loadTextures(this.mBitmapTextureAtlas,this.mapaItems,this.iconos,this.mapaSalir);
	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		final Scene scene = new Scene();
		final Sprite face = new Sprite(0, 0, this.mFaceTextureRegion);
		scene.attachChild(face);
		final AnimatedSprite i1=new AnimatedSprite(20, 320, this.item1){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					this.setCurrentTileIndex(1);
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					this.setCurrentTileIndex(0);
					Intent a = new Intent(MenuPrincipal.this,TecladoIndividual.class);
					MenuPrincipal.this.startActivity(a);
				}
				return true;
			}  
		};
		final AnimatedSprite i2=new AnimatedSprite(20, 400, this.item2){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					this.setCurrentTileIndex(1);
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					this.setCurrentTileIndex(0);
					Intent a = new Intent(MenuPrincipal.this,TecladoEquipos.class);
					MenuPrincipal.this.startActivity(a);
				}
				return true;
			}  
		};
		final AnimatedSprite i3=new AnimatedSprite(377, 320, this.item3){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					this.setCurrentTileIndex(1);
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					Intent a = new Intent(MenuPrincipal.this,SubMenuComoJugar.class);
					MenuPrincipal.this.startActivity(a);
					this.setCurrentTileIndex(0);
				}
				return true;
			}  
		};
		final AnimatedSprite i4=new AnimatedSprite(377, 400, this.item4){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					this.setCurrentTileIndex(1);
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					this.setCurrentTileIndex(0);
					Intent a = new Intent(MenuPrincipal.this,CreditosActivity.class);
					MenuPrincipal.this.startActivity(a);
				}
				return true;
			}     
		}; 
		final AnimatedSprite sal=new AnimatedSprite(-40, -40, this.tsalir){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					this.setCurrentTileIndex(1);
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					this.setCurrentTileIndex(0);
					MenuPrincipal.this.finish();
					Intent a = new Intent(MenuPrincipal.this,Salida.class);
					MenuPrincipal.this.startActivity(a);
				}
				return true;
			}     
		};   
		final Sprite fc=new Sprite(620, 10, this.facebook){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/juegacacho") ) );				}
				return true;
			}   
		};
		final Sprite tw=new Sprite(675, 10, this.twitter){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ketanolab") ) );
				}
				return true;
			}  
		};
		fc.setScale(1.5f);
		tw.setScale(1.5f);
		scene.attachChild(i1);
		scene.attachChild(i2);
		scene.attachChild(i3);
		scene.attachChild(i4);
		scene.attachChild(fc);
		scene.attachChild(tw);
		scene.registerTouchArea(i1);
		scene.registerTouchArea(i2);
		scene.registerTouchArea(i3);
		scene.registerTouchArea(i4);
		scene.registerTouchArea(fc);
		scene.registerTouchArea(tw);
		sal.setScale(0.5f);
		scene.attachChild(sal);
		scene.registerTouchArea(sal);
		return scene;
	}
	@Override
	public void onLoadComplete() {
	}
	@Override
	public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent) {
		if (pKeyCode == KeyEvent.KEYCODE_BACK) {

			AlertDialog.Builder salir = new AlertDialog.Builder(this);
			salir.setMessage("Salir?")
					.setCancelable(false)
					.setPositiveButton("Si",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									MenuPrincipal.this.finish();
									Intent a = new Intent(MenuPrincipal.this,Salida.class);
									MenuPrincipal.this.startActivity(a);
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			AlertDialog alertaexit = salir.create();
			alertaexit.show();
		}
		if (pKeyCode == KeyEvent.KEYCODE_MENU
				&& pEvent.getAction() == KeyEvent.ACTION_DOWN) {		
		}
		return true;
	}
}