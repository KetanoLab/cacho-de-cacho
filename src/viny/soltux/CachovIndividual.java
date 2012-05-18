package viny.soltux;
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
import java.io.IOException;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.audio.sound.Sound;
import org.anddev.andengine.audio.sound.SoundFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnAreaTouchListener;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.scene.menu.MenuScene;
import org.anddev.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.anddev.andengine.entity.scene.menu.item.IMenuItem;
import org.anddev.andengine.entity.scene.menu.item.TextMenuItem;
import org.anddev.andengine.entity.scene.menu.item.decorator.ColorMenuItemDecorator;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.sensor.accelerometer.AccelerometerData;
import org.anddev.andengine.sensor.accelerometer.IAccelerometerListener;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.HorizontalAlign;

import android.app.AlertDialog;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

public class CachovIndividual extends BaseExample implements
IAccelerometerListener, IOnMenuItemClickListener,IOnSceneTouchListener, IOnAreaTouchListener {
	private static final int camara_alto = 480;
	private static final int camara_ancho = 720;
	private int contador = 0;
	private int posiciones[]=new int[5];
	private Camera camara;
	private BitmapTextureAtlas mapa;
	private TextureRegion mBgTexture;
	private BitmapTextureAtlas mBackgroundTexture;
	private BitmapTextureAtlas mlibreta;
	private BitmapTextureAtlas mboton1;
	private BitmapTextureAtlas mboton2;
	private BitmapTextureAtlas mboton3;
	private BitmapTextureAtlas mmenu;
	private BitmapTextureAtlas mbocina;
	private BitmapTextureAtlas mcacho;
	private TiledTextureRegion textura1;
	private TiledTextureRegion textura2;
	private TiledTextureRegion textura3;
	private TiledTextureRegion textura4;
	private TiledTextureRegion textura5;
	private TiledTextureRegion tbocina;
	private TextureRegion texturaboton1;
	private TextureRegion texturaboton2;
	private TextureRegion tlibreta;
	private TextureRegion tcacho;
	private TextureRegion tmenu;
	private Scene escena;
	private AnimatedSprite dado1;
	private AnimatedSprite dado2;
	private AnimatedSprite dado3;
	private AnimatedSprite dado4;
	private AnimatedSprite dado5;
	private boolean swdado1 = false;
	private boolean swdado2 = false;
	private boolean swdado3 = false;
	private boolean swdado4 = false;
	private boolean swdado5 = false;
	private int swaps = 3;
	private Sprite cubilete;
	private int datoDado1;
	private int datoDado2;
	private int datoDado3;
	private int datoDado4;
	private int datoDado5;
	private Sprite boton1;
	private boolean sw1 = false;
	private boolean swpuntuacion = false;
	private Sprite boton2;
	private String Sescalera = "X";
	private String Sfull = "X";
	private String Spoker = "X";
	private String Sgrande = "X";
	private int ntiros = 0;
	private Sound musica;
	private BitmapTextureAtlas mFontTexture;
	private Font mFont;
	protected static final int MENU_RESET = 0;
	protected static final int MENU_QUIT = MENU_RESET + 1;
	protected MenuScene mMenuScene;
	private Sprite libreta;
	private static final int MENU_SOUND = MENU_QUIT + 1;
	private ChangeableText puntuacion1;
	private ChangeableText puntuacion2;
	private ChangeableText puntuacion3;
	private ChangeableText puntuacion4;
	private ChangeableText puntuacion5;
	private ChangeableText puntuacion6;
	private ChangeableText puntuacion7;
	private ChangeableText puntuacion8;
	private ChangeableText puntuacion9;
	private ChangeableText puntuacion10;
	private ChangeableText puntuacion11;
	private ChangeableText txt[] = new ChangeableText[4];
	private int uno;
	private int dos;
	private int tres;
	private int cuatro;
	private int cinco;
	private Text dormida;
	private boolean swespecial = false;
	private boolean swdado = false;
	private int v[];
	private boolean swtabla = false;
	private int NJ;
	private String m[][] = new String[1][1];
	private int g[][] = new int[1][1];
	private int np = 0;
    
	
	private boolean viny = false;
	private boolean sound = true;
	private Sprite menuf;
	private AnimatedSprite bocina;
	private BitmapTextureAtlas mFontTexture2;
	private Font mFont2;
	private TiledTextureRegion texturaboton3;
	private AnimatedSprite boton3;
	private Music mMusic;
	private long lastShakeTime = 0;
	private float lastShakeX, lastShakeY, lastShakeZ = 0;
	private Sound tic;
	private BitmapTextureAtlas mBackgroundTexture2;
	private TextureRegion mBgTexture2;
	private TiledTextureRegion taceptar;
	private BitmapTextureAtlas maceptar;
	private AnimatedSprite ace;
	private boolean finalisimo=false;
	private Text fin;
	
	
	public Engine onLoadEngine() {
		this.camara = new Camera(0, 0, camara_ancho, camara_alto);
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE,
				new FillResolutionPolicy(), this.camara).setNeedsSound(true).setNeedsMusic(true));
	}

	public void onLoadResources() {
		this.mmenu = new BitmapTextureAtlas(1024, 1024,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		
		this.mlibreta = new BitmapTextureAtlas(512, 512,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mFontTexture = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		this.mEngine.getTextureManager().loadTexture(this.mFontTexture);

		this.mcacho = new BitmapTextureAtlas(512, 512,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		this.mapa = new BitmapTextureAtlas(512, 64,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mboton1 = new BitmapTextureAtlas(64, 64,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mboton2 = new BitmapTextureAtlas(64, 64,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mboton3 = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mbocina = new BitmapTextureAtlas(128, 64,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.maceptar = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.tlibreta = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mlibreta, this, "libreta.png", 0, 0);
		this.tmenu = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mmenu, this, "menufondo.png", 0, 0);
		this.textura1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.mapa, this, "dados.png", 0, 0, 6, 1);
		this.textura2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.mapa, this, "dados.png", 0, 0, 6, 1);
		this.textura3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.mapa, this, "dados.png", 0, 0, 6, 1);
		this.textura4 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.mapa, this, "dados.png", 0, 0, 6, 1);
		this.textura5 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.mapa, this, "dados.png", 0, 0, 6, 1);
		this.tbocina = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.mbocina, this, "bocinas.png", 0, 0,
						2, 1);

		this.texturaboton1 = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mboton1, this, "boton1.png", 0, 0);
		this.texturaboton2 = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mboton2, this, "boton2.png", 0, 0);
		this.texturaboton3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.mboton3, this, "lanzar.png", 0, 0,2,1);
		this.tcacho = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				this.mcacho, this, "cacho.png", 0, 0);
		this.taceptar = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.maceptar, this, "aceptar.png", 0, 0,
						2, 1);
		
		this.mBackgroundTexture = new BitmapTextureAtlas(1024, 1024,
				TextureOptions.DEFAULT);
		this.mBackgroundTexture2 = new BitmapTextureAtlas(1024, 1024,
				TextureOptions.DEFAULT);
		this.mBgTexture2 = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBackgroundTexture2, this,
						"backgroundFinal.png", 0, 0);
		
		this.mBgTexture = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBackgroundTexture, this,
						"background.png", 0, 0);
		
		

		SoundFactory.setAssetBasePath("mfx/");
		try {
			this.musica = SoundFactory.createSoundFromAsset(
					this.mEngine.getSoundManager(), this, "Dado.ogg");
			this.tic = SoundFactory.createSoundFromAsset(
					this.mEngine.getSoundManager(), this, "tic.ogg");
		} catch (final IOException e) {
			Debug.e(e);
		}   
		   
		MusicFactory.setAssetBasePath("mfx/");
		try {
			this.mMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "Dado2.ogg");
			
		} catch (final IOException e) {
			Debug.e(e);
		}
		   
		this.mFontTexture = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mFontTexture2 = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		FontFactory.setAssetBasePath("font/");
		this.mFont = FontFactory.createFromAsset(this.mFontTexture, this,
				"Droid.ttf", 40, true, Color.WHITE);
		this.mFont2 = FontFactory.createFromAsset(this.mFontTexture2, this,
				"Droid.ttf", 48, true, Color.WHITE);
		this.mEngine.getFontManager().loadFonts(this.mFont, this.mFont2);
		this.mEngine.getTextureManager().loadTextures(this.mapa, this.mboton1,
				this.mboton2, this.mboton3, this.mlibreta,
				this.mBackgroundTexture2,this.mBackgroundTexture, this.mFontTexture, this.mFontTexture2,
				 this.mmenu, this.mbocina, this.mcacho,this.maceptar);

	}

	public Scene onLoadScene() {

	
		Intent in = getIntent();
		
		NJ=in.getIntExtra("contador", NJ);
		final String[] jugadores =  in.getStringArrayExtra("vector");
		
		
		
		
		
		final CharSequence[] items = { "1 Jugador", "2 Jugadores",
				"3 Jugadores" };

		
		
		m[0][0] = "";

		this.mEngine.registerUpdateHandler(new FPSLogger());
		escena = new Scene();
		this.mMenuScene = this.createMenuScene();
		libreta = new Sprite(-40, 380, this.tlibreta);

		SpriteBackground bg = new SpriteBackground(new Sprite(0, 0, mBgTexture));
		escena.setBackground(bg);
		cubilete = new Sprite(2, 85, this.tcacho);
		escena.attachChild(cubilete);
		
				m = new String[NJ][12];
				g = new int[NJ][13];
				for (int i = 0; i <= 11; i++) {
					for (int j = 0; j < NJ; j++) {
						m[j][i] = "~~";
						g[j][i] = 0;
					}
				}
				int y = 410;
				posiciones[0]=0;
				posiciones[1]=0;
				posiciones[2]=0;
				posiciones[3]=0;
				switch(NJ){
				case 1:
					m[0][0] = jugadores[0];
					g[0][0] = 0;
					txt[0] = new ChangeableText(500, y,
							CachovIndividual.this.mFont, "", 8){
						@Override
						public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
								final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
							if(!swtabla){
							if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
								mostrarAll( posiciones[0]);
							} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
								salirAll( );	
							}}
							return true;
							}
					};
					txt[0].setText(m[0][0]);
					txt[0].setColor(0.0f, 0.2f, 0.0f, 0.5f);
					escena.attachChild(txt[0]);
					escena.registerTouchArea(txt[0]);
					break;
				case 2:
					m[0][0] = jugadores[0];
					g[0][0] = 0;
					txt[0] = new ChangeableText(500, y,
							CachovIndividual.this.mFont, "", 8){
						@Override
						public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
								final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
							if(!swtabla){
							if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
								mostrarAll(0);
							} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
								salirAll( );	
							}}
							return true;
							}
					};
					txt[0].setText(m[0][0]);
					txt[0].setColor(0.0f, 0.2f, 0.0f, 0.5f);
					escena.attachChild(txt[0]);
					escena.registerTouchArea(txt[0]);
					y-=50;
					m[1][0] = jugadores[1];
					g[1][0] = 0;
					txt[1] = new ChangeableText(500, y,
							CachovIndividual.this.mFont, "", 8){
						@Override
						public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
								final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
							if(!swtabla){
							if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
								mostrarAll(1);
							} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
								salirAll( );	
							}}
							return true;
							}
					};
					txt[1].setText(m[1][0]);
					txt[1].setColor(0.0f, 0.2f, 0.0f, 0.5f);
					escena.attachChild(txt[1]);
					escena.registerTouchArea(txt[1]);
					break;
					default:
						m[0][0] = jugadores[0];
						g[0][0] = 0;
						txt[0] = new ChangeableText(500, y,
								CachovIndividual.this.mFont, "", 8){
							@Override
							public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
									final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
								if(!swtabla){
								if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
									mostrarAll(0);
								} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
									salirAll( );	
								}}
								return true;
								}
						};
						txt[0].setText(m[0][0]);
						txt[0].setColor(0.0f, 0.2f, 0.0f, 0.5f);
						escena.attachChild(txt[0]);
						escena.registerTouchArea(txt[0]);
						y-=50;
						m[1][0] = jugadores[1];
						g[1][0] = 0;
						txt[1] = new ChangeableText(500, y,
								CachovIndividual.this.mFont, "", 8){
							@Override
							public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
									final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
								if(!swtabla){
								if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
									mostrarAll(1);
								} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
									salirAll( );	
								}}
								return true;
								}
						};
						txt[1].setText(m[1][0]);
						txt[1].setColor(0.0f, 0.2f, 0.0f, 0.5f);
						escena.attachChild(txt[1]);
						escena.registerTouchArea(txt[1]);
						y-=50;
						m[2][0] = jugadores[2];
						g[2][0] = 0;
						txt[2] = new ChangeableText(500, y,
								CachovIndividual.this.mFont, "", 8){
							@Override
							public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
									final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
								if(!swtabla){
								if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
									mostrarAll(2);
								} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
									salirAll( );	
								}}
								return true;
								}
						};
						txt[2].setText(m[2][0]);
						txt[2].setColor(0.0f, 0.2f, 0.0f, 0.5f);
						escena.attachChild(txt[2]);
						escena.registerTouchArea(txt[2]);
						break;
				}
				
				txt[0].setColor(1.0f, 1.0f, 1.0f, 0.5f);				 
				viny = true;
		bocina = new AnimatedSprite(400, 415, this.tbocina) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					if (sound) {
						sound = false;
						this.setCurrentTileIndex(1);
					} else {
						this.setCurrentTileIndex(0);
						sound = true;
					}
				}
				return true;
			}
		};
		// bocina.setCurrentTileIndex(0);
		escena.attachChild(bocina);
		escena.registerTouchArea(bocina);
		boton1 = new Sprite(250, 380, this.texturaboton1) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					if (ntiros == 0) {
						CachovIndividual.this.libreta.setPosition(-40, 380);
						puntuacion1.setText("");
						puntuacion2.setText("");
						puntuacion3.setText("");
						puntuacion4.setText("");
						puntuacion5.setText("");
						puntuacion6.setText("");
						puntuacion7.setText("");
						puntuacion8.setText("");
						puntuacion9.setText("");
						puntuacion10.setText("");
						puntuacion11.setText("");
						this.setVisible(false);
						swtabla = false;
					} else {
						CachovIndividual.this.salirPuntuacion2();

					}
				}
				return true;
			}
		};
		boton1.setScale(2);
		
		boton1.setVisible(false);
		boton2 = new Sprite(15, 400, this.texturaboton2) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					if (cubilete.collidesWith(dado1)
							|| cubilete.collidesWith(dado2)
							|| cubilete.collidesWith(dado3)
							|| cubilete.collidesWith(dado4)
							|| cubilete.collidesWith(dado5)) {
						if (ntiros == 0) {
							CachovIndividual.this.libreta.setPosition(0, 50);
							CachovIndividual.this.textear();
							boton1.setVisible(true);
							escena.registerTouchArea(boton1);
							swtabla = true;
						}
					} else {

						if (ntiros != 0) {
							mostrarPuntuacion();
							swtabla=true;
						} else {

							CachovIndividual.this.libreta.setPosition(0, 50);
							CachovIndividual.this.textear();
							boton1.setVisible(true);
							escena.registerTouchArea(boton1);
							swtabla = true;
						}
					}
				}
				return true;
			}
		};
		boton2.setVisible(false);
		escena.attachChild(boton2);
		boton2.setScale(1.5f);
		escena.registerTouchArea(boton2);
		boton3 = new AnimatedSprite(30, 30, this.texturaboton3) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					this.setCurrentTileIndex(1);
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					this.setCurrentTileIndex(0);
					if ((CachovIndividual.this.cubilete.collidesWith(dado1)
							|| CachovIndividual.this.cubilete.collidesWith(dado2)
							|| CachovIndividual.this.cubilete.collidesWith(dado3)
							|| CachovIndividual.this.cubilete.collidesWith(dado4) || CachovIndividual.this.cubilete
								.collidesWith(dado5)) && !swtabla && viny) {
						if ( !sw1) {
							swaps = 0;
							swespecial = false;
							if (CachovIndividual.this.cubilete.collidesWith(dado1)
									&& CachovIndividual.this.cubilete.collidesWith(dado2)
									&& CachovIndividual.this.cubilete.collidesWith(dado3)
									&& CachovIndividual.this.cubilete.collidesWith(dado4)
									&& CachovIndividual.this.cubilete.collidesWith(dado5)) {
								swespecial = true;
							}

							CachovIndividual.this.mEngine.vibrate(350);
							if (sound) {
								CachovIndividual.this.musica.play();
							}

							if (CachovIndividual.this.dado1.collidesWith(cubilete)) {
								CachovIndividual.this.dado1.animate(20);
								CachovIndividual.this.dado1.setPosition(390, 40);
								CachovIndividual.this.dado1.setVisible(true);
								CachovIndividual.this.dado1.setScale(1.5f);
							}
							if (CachovIndividual.this.dado2.collidesWith(cubilete)) {
								CachovIndividual.this.dado2.animate(20);
								CachovIndividual.this.dado2.setPosition(590, 40);
								CachovIndividual.this.dado2.setVisible(true);
								CachovIndividual.this.dado2.setScale(1.5f);
							}
							if (CachovIndividual.this.dado3.collidesWith(cubilete)) {
								CachovIndividual.this.dado3.animate(20);
								CachovIndividual.this.dado3.setPosition(490, 40);
								CachovIndividual.this.dado3.setVisible(true);
								CachovIndividual.this.dado3.setScale(1.5f);
							}
							if (CachovIndividual.this.dado4.collidesWith(cubilete)) {
								CachovIndividual.this.dado4.animate(20);
								CachovIndividual.this.dado4.setPosition(540, 190);
								CachovIndividual.this.dado4.setVisible(true);
								CachovIndividual.this.dado4.setScale(1.5f);
							}
							if (CachovIndividual.this.dado5.collidesWith(cubilete)) {
								CachovIndividual.this.dado5.animate(20);
								CachovIndividual.this.dado5.setPosition(410, 190);
								CachovIndividual.this.dado5.setVisible(true);
								CachovIndividual.this.dado5.setScale(1.5f);
							}
							
							  int a = (int) System.currentTimeMillis(); a = a + 1700; 
							  while
							  ((int) System.currentTimeMillis() <= a) { }
							 
							if (CachovIndividual.this.dado1.isAnimationRunning()) {
								datoDado1 = (int) (Math.random() * 6);
								CachovIndividual.this.dado1.stopAnimation();
								CachovIndividual.this.dado1.setCurrentTileIndex(datoDado1);
								
								
								
								escena.registerTouchArea(dado1);
							}
							if (CachovIndividual.this.dado2.isAnimationRunning()) {
								datoDado2 = (int) (Math.random() * 6);
								CachovIndividual.this.dado2.stopAnimation();
								CachovIndividual.this.dado2.setCurrentTileIndex(datoDado2);
								
								
								
								escena.registerTouchArea(dado2);
							}
							if (CachovIndividual.this.dado3.isAnimationRunning()) {
								datoDado3 = (int) (Math.random() * 6);
								CachovIndividual.this.dado3.stopAnimation();
								CachovIndividual.this.dado3.setCurrentTileIndex(datoDado3);
							
								
								
								escena.registerTouchArea(dado3);
							}
							if (CachovIndividual.this.dado4.isAnimationRunning()) {
								datoDado4 = (int) (Math.random() * 6);
								CachovIndividual.this.dado4.stopAnimation();
								CachovIndividual.this.dado4.setCurrentTileIndex(datoDado4);
								
								
								
								escena.registerTouchArea(dado4);
							}
							if (CachovIndividual.this.dado5.isAnimationRunning()) {
								datoDado5 = (int) (Math.random() * 6);
								CachovIndividual.this.dado5.stopAnimation();
								CachovIndividual.this.dado5.setCurrentTileIndex(datoDado5);
							
								
								
								escena.registerTouchArea(dado5);
							}
							CachovIndividual.this.mEngine.vibrate(50);

							sw1 = false;
							ntiros++;
							calcularLista();
							if (ntiros >= 2) {
								mostrarPuntuacion();
							}
						}
					}
				
				}
				return true;
			}
		};
		boton3.setScale(1.3f);
		escena.attachChild(boton3);
		escena.registerTouchArea(boton3);
		puntuacion1 = new ChangeableText(80, 120, this.mFont2, "  ", 3) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,

			final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][1] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(String.valueOf(v[0]));
						g[np][1] = 1;
						if (g[np][2] == 1) {
							g[np][2] = 0;
							puntuacion2.setText(m[np][7]);
							puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
							puntuacion3.setText(m[np][4]);
							puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);

						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
							puntuacion4.setText(m[np][2]);
							puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
							puntuacion5.setText(m[np][8]);
							puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
							puntuacion6.setText(m[np][5]);
							puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
							puntuacion7.setText(m[np][3]);
							puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
							puntuacion8.setText(m[np][9]);
							puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
							puntuacion9.setText(m[np][6]);
							puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
							puntuacion10.setText(m[np][10]);
							puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
							puntuacion11.setText(m[np][11]);
							puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
					} else {
						calcularLista();
						if (g[np][1] == 1
								&& this.getText().equals(String.valueOf(v[0]))) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][1] = String.valueOf(v[0]);
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
							
							salirPuntuacion();
							}
							ntiros = 0;
							g[np][1] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								// txtjugador.setText(m[np][0]);
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}

						} else {
							if (g[np][1] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(String.valueOf(v[0]));
								g[np][1] = 1;
								if (g[np][2] == 1) {
									g[np][2] = 0;
									puntuacion2.setText(m[np][7]);
									puntuacion2.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
									puntuacion3.setText(m[np][4]);
									puntuacion3.setColor(0.14f, 0.40f, 0.50f,
											1.0f);

								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
									puntuacion4.setText(m[np][2]);
									puntuacion4.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
									puntuacion5.setText(m[np][8]);
									puntuacion5.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
									puntuacion6.setText(m[np][5]);
									puntuacion6.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
									puntuacion7.setText(m[np][3]);
									puntuacion7.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
									puntuacion8.setText(m[np][9]);
									puntuacion8.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
									puntuacion9.setText(m[np][6]);
									puntuacion9.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
									puntuacion10.setText(m[np][10]);
									puntuacion10.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
									puntuacion11.setText(m[np][11]);
									puntuacion11.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
							}
						}

					}
				}
				return true;
			}
		};
		puntuacion2 = new ChangeableText(150, 160, this.mFont2, "  ", 3) {

			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][2] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(Sescalera);
						g[np][2] = 1;
						if (g[np][1] == 1) {
							g[np][1] = 0;
						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
						}
						puntuacion1.setText(m[np][1]);
						puntuacion3.setText(m[np][4]);
						puntuacion4.setText(m[np][2]);
						puntuacion5.setText(m[np][8]);
						puntuacion6.setText(m[np][5]);
						puntuacion7.setText(m[np][3]);
						puntuacion8.setText(m[np][9]);
						puntuacion9.setText(m[np][6]);
						puntuacion10.setText(m[np][10]);
						puntuacion11.setText(m[np][11]);
						puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);

					} else {
						calcularLista();
						if (g[np][2] == 1 && this.getText().equals(Sescalera)) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][7] = Sescalera;
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							g[np][2] = 2;
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								// txtjugador.setText(m[np][0]);
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][2] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(Sescalera);
								g[np][2] = 1;
								if (g[np][1] == 1) {
									g[np][1] = 0;

								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
								}
								puntuacion1.setText(m[np][1]);
								puntuacion3.setText(m[np][4]);
								puntuacion4.setText(m[np][2]);
								puntuacion5.setText(m[np][8]);
								puntuacion6.setText(m[np][5]);
								puntuacion7.setText(m[np][3]);
								puntuacion8.setText(m[np][9]);
								puntuacion9.setText(m[np][6]);
								puntuacion10.setText(m[np][10]);
								puntuacion11.setText(m[np][11]);
								puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion10
										.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion11
										.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							}
						}
					}
				}

				return true;
			}
		};
		puntuacion3 = new ChangeableText(220, 190, this.mFont2, "  ", 3) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,

			final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][3] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(String.valueOf(v[3] * 4));
						g[np][3] = 1;
						if (g[np][2] == 1) {
							g[np][2] = 0;
							puntuacion2.setText(m[np][7]);
							puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][1] == 1) {
							g[np][1] = 0;
							puntuacion1.setText(m[np][1]);
							puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
							puntuacion4.setText(m[np][2]);
							puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
							puntuacion5.setText(m[np][8]);
							puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
							puntuacion6.setText(m[np][5]);
							puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
							puntuacion7.setText(m[np][3]);
							puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
							puntuacion8.setText(m[np][9]);
							puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
							puntuacion9.setText(m[np][6]);
							puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
							puntuacion10.setText(m[np][10]);
							puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
							puntuacion11.setText(m[np][11]);
							puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
					} else {
						calcularLista();
						if (g[np][3] == 1
								&& this.getText().equals(
										String.valueOf(v[3] * 4))) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][4] = String.valueOf(v[3] * 4);
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][3] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}

						} else {
							if (g[np][3] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(String.valueOf(v[3] * 4));
								g[np][3] = 1;
								if (g[np][2] == 1) {
									g[np][2] = 0;
									puntuacion2.setText(m[np][7]);
									puntuacion2.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][1] == 1) {
									g[np][1] = 0;
									puntuacion1.setText(m[np][1]);
									puntuacion1.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
									puntuacion4.setText(m[np][2]);
									puntuacion4.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
									puntuacion5.setText(m[np][8]);
									puntuacion5.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
									puntuacion6.setText(m[np][5]);
									puntuacion6.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
									puntuacion7.setText(m[np][3]);
									puntuacion7.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
									puntuacion8.setText(m[np][9]);
									puntuacion8.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
									puntuacion9.setText(m[np][6]);
									puntuacion9.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
									puntuacion10.setText(m[np][10]);
									puntuacion10.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
									puntuacion11.setText(m[np][11]);
									puntuacion11.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
							}
						}

					}
				}
				return true;
			}
		};
		puntuacion4 = new ChangeableText(40, 190, this.mFont2, "  ", 3) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,

			final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][4] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(String.valueOf(v[1] * 2));
						g[np][4] = 1;
						if (g[np][2] == 1) {
							g[np][2] = 0;
							puntuacion2.setText(m[np][7]);
							puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
							puntuacion3.setText(m[np][4]);
							puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);

						}
						if (g[np][1] == 1) {
							g[np][1] = 0;
							puntuacion1.setText(m[np][1]);
							puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
							puntuacion5.setText(m[np][8]);
							puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
							puntuacion6.setText(m[np][5]);
							puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
							puntuacion7.setText(m[np][3]);
							puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
							puntuacion8.setText(m[np][9]);
							puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
							puntuacion9.setText(m[np][6]);
							puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
							puntuacion10.setText(m[np][10]);
							puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
							puntuacion11.setText(m[np][11]);
							puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
					} else {
						calcularLista();
						if (g[np][4] == 1
								&& this.getText().equals(
										String.valueOf(v[1] * 2))) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][2] = String.valueOf(v[1] * 2);
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][4] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								// txtjugador.setText(m[np][0]);
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][4] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(String.valueOf(v[1] * 2));
								if (g[np][2] == 1) {
									g[np][2] = 0;
									puntuacion2.setText(m[np][7]);
									puntuacion2.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
									puntuacion3.setText(m[np][4]);
									puntuacion3.setColor(0.14f, 0.40f, 0.50f,
											1.0f);

								}
								if (g[np][1] == 1) {
									g[np][1] = 0;
									puntuacion1.setText(m[np][1]);
									puntuacion1.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
									puntuacion5.setText(m[np][8]);
									puntuacion5.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
									puntuacion6.setText(m[np][5]);
									puntuacion6.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
									puntuacion7.setText(m[np][3]);
									puntuacion7.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
									puntuacion8.setText(m[np][9]);
									puntuacion8.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
									puntuacion9.setText(m[np][6]);
									puntuacion9.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
									puntuacion10.setText(m[np][10]);
									puntuacion10.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
									puntuacion11.setText(m[np][11]);
									puntuacion11.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
							}
						}

					}
				}
				return true;
			}
		};
		puntuacion5 = new ChangeableText(115, 230, this.mFont2, "  ", 3) {

			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][5] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(Sfull);
						g[np][5] = 1;
						if (g[np][1] == 1) {
							g[np][1] = 0;
						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
						}
						if (g[np][2] == 1) {
							g[np][2] = 0;
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
						}
						puntuacion1.setText(m[np][1]);
						puntuacion3.setText(m[np][4]);
						puntuacion4.setText(m[np][2]);
						puntuacion2.setText(m[np][7]);
						puntuacion6.setText(m[np][5]);
						puntuacion7.setText(m[np][3]);
						puntuacion8.setText(m[np][9]);
						puntuacion9.setText(m[np][6]);
						puntuacion10.setText(m[np][10]);
						puntuacion11.setText(m[np][11]);
						puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);

					} else {
						calcularLista();
						if (g[np][5] == 1 && this.getText().equals(Sfull)) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][8] = Sfull;
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][5] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								// txtjugador.setText(m[np][0]);
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][5] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(Sfull);
								g[np][5] = 1;
								if (g[np][1] == 1) {
									g[np][1] = 0;
								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
								}
								if (g[np][2] == 1) {
									g[np][2] = 0;
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
								}
								puntuacion1.setText(m[np][1]);
								puntuacion3.setText(m[np][4]);
								puntuacion4.setText(m[np][2]);
								puntuacion2.setText(m[np][7]);
								puntuacion6.setText(m[np][5]);
								puntuacion7.setText(m[np][3]);
								puntuacion8.setText(m[np][9]);
								puntuacion9.setText(m[np][6]);
								puntuacion10.setText(m[np][10]);
								puntuacion11.setText(m[np][11]);
								puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion10
										.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion11
										.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							}
						}
					}
				}

				return true;
			}
		};
		puntuacion6 = new ChangeableText(190, 265, this.mFont2, "  ", 3) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,

			final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][6] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(String.valueOf(v[4] * 5));
						g[np][6] = 1;
						if (g[np][2] == 1) {
							g[np][2] = 0;
							puntuacion2.setText(m[np][7]);
							puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
							puntuacion3.setText(m[np][4]);
							puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);

						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
							puntuacion4.setText(m[np][2]);
							puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
							puntuacion5.setText(m[np][8]);
							puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][1] == 1) {
							g[np][1] = 0;
							puntuacion1.setText(m[np][1]);
							puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
							puntuacion7.setText(m[np][3]);
							puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
							puntuacion8.setText(m[np][9]);
							puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
							puntuacion9.setText(m[np][6]);
							puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
							puntuacion10.setText(m[np][10]);
							puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
							puntuacion11.setText(m[np][11]);
							puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
					} else {
						calcularLista();
						if (g[np][6] == 1
								&& this.getText().equals(
										String.valueOf(v[4] * 5))) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][5] = String.valueOf(v[4] * 5);
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][6] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][6] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(String.valueOf(v[4] * 5));
								g[np][6] = 1;
								if (g[np][2] == 1) {
									g[np][2] = 0;
									puntuacion2.setText(m[np][7]);
									puntuacion2.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
									puntuacion3.setText(m[np][4]);
									puntuacion3.setColor(0.14f, 0.40f, 0.50f,
											1.0f);

								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
									puntuacion4.setText(m[np][2]);
									puntuacion4.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
									puntuacion5.setText(m[np][8]);
									puntuacion5.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][1] == 1) {
									g[np][1] = 0;
									puntuacion1.setText(m[np][1]);
									puntuacion1.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
									puntuacion7.setText(m[np][3]);
									puntuacion7.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
									puntuacion8.setText(m[np][9]);
									puntuacion8.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
									puntuacion9.setText(m[np][6]);
									puntuacion9.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
									puntuacion10.setText(m[np][10]);
									puntuacion10.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
									puntuacion11.setText(m[np][11]);
									puntuacion11.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
							}
						}

					}
				}
				return true;
			}
		};
		puntuacion7 = new ChangeableText(10, 250, this.mFont2, "  ", 3) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,

			final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][7] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(String.valueOf(v[2] * 3));
						g[np][7] = 1;
						if (g[np][2] == 1) {
							g[np][2] = 0;
							puntuacion2.setText(m[np][7]);
							puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
							puntuacion3.setText(m[np][4]);
							puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);

						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
							puntuacion4.setText(m[np][2]);
							puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
							puntuacion5.setText(m[np][8]);
							puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
							puntuacion6.setText(m[np][5]);
							puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][1] == 1) {
							g[np][1] = 0;
							puntuacion1.setText(m[np][1]);
							puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
							puntuacion8.setText(m[np][9]);
							puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
							puntuacion9.setText(m[np][6]);
							puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
							puntuacion10.setText(m[np][10]);
							puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
							puntuacion11.setText(m[np][11]);
							puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
					} else {

						calcularLista();
						if (g[np][7] == 1
								&& this.getText().equals(
										String.valueOf(v[2] * 3))) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][3] = String.valueOf(v[2] * 3);
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][7] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								// txtjugador.setText(m[np][0]);
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][7] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(String.valueOf(v[2] * 3));
								g[np][7] = 1;

								if (g[np][2] == 1) {
									g[np][2] = 0;
									puntuacion2.setText(m[np][7]);
									puntuacion2.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
									puntuacion3.setText(m[np][4]);
									puntuacion3.setColor(0.14f, 0.40f, 0.50f,
											1.0f);

								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
									puntuacion4.setText(m[np][2]);
									puntuacion4.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
									puntuacion5.setText(m[np][8]);
									puntuacion5.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
									puntuacion6.setText(m[np][5]);
									puntuacion6.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][1] == 1) {
									g[np][1] = 0;
									puntuacion1.setText(m[np][1]);
									puntuacion1.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
									puntuacion8.setText(m[np][9]);
									puntuacion8.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
									puntuacion9.setText(m[np][6]);
									puntuacion9.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
									puntuacion10.setText(m[np][10]);
									puntuacion10.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
									puntuacion11.setText(m[np][11]);
									puntuacion11.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
							}
						}

					}
				}

				return true;
			}
		};
		puntuacion8 = new ChangeableText(80, 300, this.mFont2, "  ", 3) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][8] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(Spoker);
						g[np][8] = 1;
						if (g[np][1] == 1) {
							g[np][1] = 0;

						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
						}
						if (g[np][2] == 1) {
							g[np][2] = 0;
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
						}
						puntuacion1.setText(m[np][1]);
						puntuacion3.setText(m[np][4]);
						puntuacion4.setText(m[np][2]);
						puntuacion2.setText(m[np][7]);
						puntuacion6.setText(m[np][5]);
						puntuacion7.setText(m[np][3]);
						puntuacion5.setText(m[np][8]);
						puntuacion9.setText(m[np][6]);
						puntuacion10.setText(m[np][10]);
						puntuacion11.setText(m[np][11]);
						puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);

					} else {
						calcularLista();
						if (g[np][8] == 1 && this.getText().equals(Spoker)) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][9] = Spoker;
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][8] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][8] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(Spoker);
								g[np][8] = 1;
								if (g[np][1] == 1) {
									g[np][1] = 0;

								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
								}
								if (g[np][2] == 1) {
									g[np][2] = 0;
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
								}
								puntuacion1.setText(m[np][1]);
								puntuacion3.setText(m[np][4]);
								puntuacion4.setText(m[np][2]);
								puntuacion2.setText(m[np][7]);
								puntuacion6.setText(m[np][5]);
								puntuacion7.setText(m[np][3]);
								puntuacion5.setText(m[np][8]);
								puntuacion9.setText(m[np][6]);
								puntuacion10.setText(m[np][10]);
								puntuacion11.setText(m[np][11]);
								puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion10
										.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion11
										.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							}
						}
					}
				}

				return true;
			}
		};
		puntuacion9 = new ChangeableText(160, 330, this.mFont2, "  ", 3) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,

			final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
					if (g[np][9] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(String.valueOf(v[5] * 6));
						g[np][9] = 1;
						if (g[np][2] == 1) {
							g[np][2] = 0;
							puntuacion2.setText(m[np][7]);
							puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
							puntuacion3.setText(m[np][4]);
							puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);

						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
							puntuacion4.setText(m[np][2]);
							puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
							puntuacion5.setText(m[np][8]);
							puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
							puntuacion6.setText(m[np][5]);
							puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
							puntuacion7.setText(m[np][3]);
							puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
							puntuacion8.setText(m[np][9]);
							puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][1] == 1) {
							g[np][1] = 0;
							puntuacion1.setText(m[np][1]);
							puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
							puntuacion10.setText(m[np][10]);
							puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
							puntuacion11.setText(m[np][11]);
							puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						}
					} else {
						calcularLista();
						if (g[np][9] == 1
								&& this.getText().equals(
										String.valueOf(v[5] * 6))) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][6] = String.valueOf(v[5] * 6);
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][9] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								// txtjugador.setText(m[np][0]);
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][9] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(String.valueOf(v[5] * 6));
								g[np][9] = 1;
								if (g[np][2] == 1) {
									g[np][2] = 0;
									puntuacion2.setText(m[np][7]);
									puntuacion2.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
									puntuacion3.setText(m[np][4]);
									puntuacion3.setColor(0.14f, 0.40f, 0.50f,
											1.0f);

								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
									puntuacion4.setText(m[np][2]);
									puntuacion4.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
									puntuacion5.setText(m[np][8]);
									puntuacion5.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
									puntuacion6.setText(m[np][5]);
									puntuacion6.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
									puntuacion7.setText(m[np][3]);
									puntuacion7.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
									puntuacion8.setText(m[np][9]);
									puntuacion8.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][1] == 1) {
									g[np][1] = 0;
									puntuacion1.setText(m[np][1]);
									puntuacion1.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
									puntuacion10.setText(m[np][10]);
									puntuacion10.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
									puntuacion11.setText(m[np][11]);
									puntuacion11.setColor(0.14f, 0.40f, 0.50f,
											1.0f);
								}
							}
						}

					}
				}
				return true;
			}
		};
		puntuacion10 = new ChangeableText(25, 375, this.mFont2, "  ", 3) {

			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][10] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(Sgrande);
						g[np][10] = 1;
						if (g[np][1] == 1) {
							g[np][1] = 0;

						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
						}
						if (g[np][9] == 1) {
							g[np][9] = 0;
						}
						if (g[np][1] == 1) {
							g[np][1] = 0;
						}
						if (g[np][11] == 1) {
							g[np][11] = 0;
						}
						puntuacion1.setText(m[np][1]);
						puntuacion3.setText(m[np][4]);
						puntuacion4.setText(m[np][2]);
						puntuacion2.setText(m[np][7]);
						puntuacion6.setText(m[np][5]);
						puntuacion7.setText(m[np][3]);
						puntuacion5.setText(m[np][8]);
						puntuacion9.setText(m[np][6]);
						puntuacion8.setText(m[np][9]);
						puntuacion11.setText(m[np][11]);
						puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);

					} else {
						calcularLista();
						if (g[np][10] == 1 && this.getText().equals(Sgrande)) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][10] = Sgrande;
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								
								
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][10] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								// txtjugador.setText(m[np][0]);
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][10] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(Sgrande);
								g[np][10] = 1;
								if (g[np][1] == 1) {
									g[np][1] = 0;

								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
								}
								if (g[np][9] == 1) {
									g[np][9] = 0;
								}
								if (g[np][1] == 1) {
									g[np][1] = 0;
								}
								if (g[np][11] == 1) {
									g[np][11] = 0;
								}
								puntuacion1.setText(m[np][1]);
								puntuacion3.setText(m[np][4]);
								puntuacion4.setText(m[np][2]);
								puntuacion2.setText(m[np][7]);
								puntuacion6.setText(m[np][5]);
								puntuacion7.setText(m[np][3]);
								puntuacion5.setText(m[np][8]);
								puntuacion9.setText(m[np][6]);
								puntuacion8.setText(m[np][9]);
								puntuacion11.setText(m[np][11]);
								puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion11
										.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							}
						}
					}
				}

				return true;
			}
		};
		puntuacion11 = new ChangeableText(120, 410, this.mFont2, "  ", 3) {

			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {

				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {

					if (g[np][11] == 0) {
						calcularLista();
						this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
						this.setText(Sgrande);
						g[np][11] = 1;
						if (g[np][1] == 1) {
							g[np][1] = 0;

						}
						if (g[np][3] == 1) {
							g[np][3] = 0;
						}
						if (g[np][4] == 1) {
							g[np][4] = 0;
						}
						if (g[np][5] == 1) {
							g[np][5] = 0;
						}
						if (g[np][6] == 1) {
							g[np][6] = 0;
						}
						if (g[np][7] == 1) {
							g[np][7] = 0;
						}
						if (g[np][8] == 1) {
							g[np][8] = 0;
						}
						if (g[np][9] == 1) {

							g[np][9] = 0;
						}
						if (g[np][10] == 1) {
							g[np][10] = 0;
						}
						if (g[np][2] == 1) {
							g[np][2] = 0;
						}
						puntuacion1.setText(m[np][1]);
						puntuacion3.setText(m[np][4]);
						puntuacion4.setText(m[np][2]);
						puntuacion2.setText(m[np][7]);
						puntuacion6.setText(m[np][5]);
						puntuacion7.setText(m[np][3]);
						puntuacion5.setText(m[np][8]);
						puntuacion9.setText(m[np][6]);
						puntuacion10.setText(m[np][10]);
						puntuacion8.setText(m[np][9]);
						puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
						puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);

					} else {
						calcularLista();
						if (g[np][11] == 1 && this.getText().equals(Sgrande)) {
							this.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							m[np][11] = Sgrande;
							int a = (int) System.currentTimeMillis();
							a = a + 2000;
							while ((int) System.currentTimeMillis() <= a) {
							}
							if(!verificar()){
								salirPuntuacion();
								}
							ntiros = 0;
							g[np][11] = 2;
							txt[np].setColor(0.0f, 0.2f, 0.0f, 0.5f);
							if (np < NJ) {
								np++;
								if (np == NJ) {
									np = 0;
								}
								txt[np].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								
							}
							if (contador >= 11 * NJ) {
								for (int i = 0; i < NJ; i++) {
									txt[i].setColor(1.0f, 1.0f, 1.0f, 0.5f);
								}

							}
						} else {
							if (g[np][11] <= 1) {
								calcularLista();
								this.setColor(0.7764f, 0.0f, 0.0f, 0.5f);
								this.setText(Sgrande);
								g[np][11] = 1;
								if (g[np][1] == 1) {
									g[np][1] = 0;

								}
								if (g[np][3] == 1) {
									g[np][3] = 0;
								}
								if (g[np][4] == 1) {
									g[np][4] = 0;
								}
								if (g[np][5] == 1) {
									g[np][5] = 0;
								}
								if (g[np][6] == 1) {
									g[np][6] = 0;
								}
								if (g[np][7] == 1) {
									g[np][7] = 0;
								}
								if (g[np][8] == 1) {
									g[np][8] = 0;
								}
								if (g[np][9] == 1) {

									g[np][9] = 0;
								}
								if (g[np][10] == 1) {
									g[np][10] = 0;
								}
								if (g[np][2] == 1) {
									g[np][2] = 0;
								}
								puntuacion1.setText(m[np][1]);
								puntuacion3.setText(m[np][4]);
								puntuacion4.setText(m[np][2]);
								puntuacion2.setText(m[np][7]);
								puntuacion6.setText(m[np][5]);
								puntuacion7.setText(m[np][3]);
								puntuacion5.setText(m[np][8]);
								puntuacion9.setText(m[np][6]);
								puntuacion10.setText(m[np][10]);
								puntuacion8.setText(m[np][9]);
								puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion10
										.setColor(0.14f, 0.40f, 0.50f, 1.0f);
								puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
							}
						}
					}
				}

				return true;
			}
		};

		dado1 = new AnimatedSprite(110, 260, this.textura1) {
			boolean accion = false;

			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,

			final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (ntiros != 0 && !swdado) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						this.setScale(1.85f);
						this.accion = true;
						break;
					case TouchEvent.ACTION_MOVE:
						if (this.accion) {
							this.setPosition(
									pSceneTouchEvent.getX() - this.getWidth()
											/ 2,
									pSceneTouchEvent.getY() - this.getHeight()
											/ 2);
						}
						break;
					case TouchEvent.ACTION_UP:
						if (this.accion) {
							this.accion = false;
							this.setScale(1);
						}
						if (this.collidesWith(cubilete)) {
							this.setPosition(110, 260);
							CachovIndividual.this.mEngine.vibrate(50);
							this.setVisible(false);
							if(sound){
							CachovIndividual.this.tic.play();
							}
							escena.unregisterTouchArea(this);
						} else {
							this.setPosition(390, 40);
							this.setScale(1.5f);
						}
						break;
					}
				} else {
					if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP
							&& (swaps < 2 || swdado1)) {
						switch (datoDado1) {
						case 0:
							datoDado1 = 5;
							this.setCurrentTileIndex(datoDado1);
							break;
						case 1:
							datoDado1 = 4;
							this.setCurrentTileIndex(datoDado1);
							break;
						case 2:
							datoDado1 = 3;
							this.setCurrentTileIndex(datoDado1);
							break;
						case 3:
							datoDado1 = 2;
							this.setCurrentTileIndex(datoDado1);
							break;
						case 4:
							datoDado1 = 1;
							this.setCurrentTileIndex(datoDado1);
							break;
						default:
							datoDado1 = 0;
							this.setCurrentTileIndex(datoDado1);
							break;
						}
						if (!swdado1) {
							swdado1 = true;
							swaps++;
						} else {
							swdado1 = false;
							swaps--;
						}
						desregistro();
						atachild();
					}

				}
				return true;
			}

		};
		dado2 = new AnimatedSprite(70, 395, this.textura2) {
			boolean accion = false;

			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (ntiros != 0 && !swdado) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						this.setScale(1.85f);
						this.accion = true;
						break;
					case TouchEvent.ACTION_MOVE:
						if (this.accion) {
							this.setPosition(
									pSceneTouchEvent.getX() - this.getWidth()
											/ 2,
									pSceneTouchEvent.getY() - this.getHeight()
											/ 2);
						}
						break;
					case TouchEvent.ACTION_UP:
						if (this.accion) {
							this.accion = false;
							this.setScale(1);
						}
						if (this.collidesWith(cubilete)) {
							this.setPosition(70, 395);
							this.setVisible(false);
							CachovIndividual.this.mEngine.vibrate(50);
							escena.unregisterTouchArea(this);
							if(sound){
							CachovIndividual.this.tic.play();
							}
						} else {
							this.setPosition(590, 40);
							this.setScale(1.5f);
						}
						break;
					}
				} else {
					if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP
							&& (swaps < 2 || swdado2)) {
						switch (datoDado2) {
						case 0:
							datoDado2 = 5;
							this.setCurrentTileIndex(datoDado2);
							break;
						case 1:
							datoDado2 = 4;
							this.setCurrentTileIndex(datoDado2);
							break;
						case 2:
							datoDado2 = 3;
							this.setCurrentTileIndex(datoDado2);
							break;
						case 3:
							datoDado2 = 2;
							this.setCurrentTileIndex(datoDado2);
							break;
						case 4:
							datoDado2 = 1;
							this.setCurrentTileIndex(datoDado2);
							break;
						default:
							datoDado2 = 0;
							this.setCurrentTileIndex(datoDado2);
							break;
						}
						if (!swdado2) {
							swdado2 = true;
							swaps++;
						} else {
							swdado2 = false;
							swaps--;
						}
						desregistro();
						atachild();
					}

				}
				return true;
			}
		};
		dado3 = new AnimatedSprite(230, 220, this.textura3) {
			boolean accion = false;

			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (ntiros != 0 && !swdado) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						this.setScale(1.85f);
						this.accion = true;
						break;
					case TouchEvent.ACTION_MOVE:
						if (this.accion) {
							this.setPosition(
									pSceneTouchEvent.getX() - this.getWidth()
											/ 2,
									pSceneTouchEvent.getY() - this.getHeight()
											/ 2);
						}
						break;
					case TouchEvent.ACTION_UP:
						if (this.accion) {
							this.accion = false;
							this.setScale(1);
						}
						if (this.collidesWith(cubilete)) {
							this.setPosition(230, 220);
							this.setVisible(false);
							CachovIndividual.this.mEngine.vibrate(50);
							escena.unregisterTouchArea(this);
							if(sound){
							CachovIndividual.this.tic.play();
							}
						} else {
							this.setPosition(490, 40);
							this.setScale(1.5f);  
						}
						break;
					}
				} else {
					if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP
							&& (swaps < 2 || swdado3)) {
						switch (datoDado3) {
						case 0:
							datoDado3 = 5;
							this.setCurrentTileIndex(datoDado3);
							break;
						case 1:
							datoDado3 = 4;
							this.setCurrentTileIndex(datoDado3);
							break;
						case 2:
							datoDado3 = 3;
							this.setCurrentTileIndex(datoDado3);
							break;
						case 3:
							datoDado3 = 2;
							this.setCurrentTileIndex(datoDado3);
							break;
						case 4:
							datoDado3 = 1;
							this.setCurrentTileIndex(datoDado3);
							break;
						default:
							datoDado3 = 0;
							this.setCurrentTileIndex(datoDado3);
							break;
						}
						if (!swdado3) {
							swdado3 = true;
							swaps++;
						} else {
							swdado3 = false;
							swaps--;
						}
						desregistro();
						atachild();
					}

				}
				return true;
			}
		};
		dado4 = new AnimatedSprite(250, 320, this.textura4) {
			boolean accion = false;

			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (ntiros != 0 && !swdado) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						this.setScale(1.85f);
						this.accion = true;
						break;
					case TouchEvent.ACTION_MOVE:
						if (this.accion) {
							this.setPosition(
									pSceneTouchEvent.getX() - this.getWidth()
											/ 2,
									pSceneTouchEvent.getY() - this.getHeight()
											/ 2);
						}
						break;
					case TouchEvent.ACTION_UP:
						if (this.accion) {
							this.accion = false;
							this.setScale(1);
						}
						if (this.collidesWith(cubilete)) {
							this.setPosition(250, 320);
							this.setVisible(false);
							CachovIndividual.this.mEngine.vibrate(50);
							escena.unregisterTouchArea(this);
							if(sound){
							CachovIndividual.this.tic.play();
							}
						} else {
							this.setPosition(540, 190);
							this.setScale(1.5f);
						}
						break;
					}
				} else {
					if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP
							&& (swaps < 2 || swdado4)) {
						switch (datoDado4) {
						case 0:
							datoDado4 = 5;
							this.setCurrentTileIndex(datoDado4);
							break;
						case 1:
							datoDado4 = 4;
							this.setCurrentTileIndex(datoDado4);
							break;
						case 2:
							datoDado4 = 3;
							this.setCurrentTileIndex(datoDado4);
							break;
						case 3:
							datoDado4 = 2;
							this.setCurrentTileIndex(datoDado4);
							break;
						case 4:
							datoDado4 = 1;
							this.setCurrentTileIndex(datoDado4);
							break;
						default:
							datoDado4 = 0;
							this.setCurrentTileIndex(datoDado4);
							break;
						}
						if (!swdado4) {
							swdado4 = true;
							swaps++;
						} else {
							swdado4 = false;
							swaps--;
						}
						desregistro();
						atachild();
					}

				}
				return true;
			}
		};
		dado5 = new AnimatedSprite(160, 250, this.textura5) {
			boolean accion = false;
            
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (ntiros != 0 && !swdado) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						this.setScale(1.85f);
						this.accion = true;
						break;
					case TouchEvent.ACTION_MOVE:
						if (this.accion) {
							this.setPosition(
									pSceneTouchEvent.getX() - this.getWidth()
											/ 2,
									pSceneTouchEvent.getY() - this.getHeight()
											/ 2);
						}
						break;
					case TouchEvent.ACTION_UP:
						if (this.accion) {
							this.accion = false;
							this.setScale(1);
						}
						if (this.collidesWith(cubilete)) {
							this.setPosition(160, 250);
							this.setVisible(false);
							CachovIndividual.this.mEngine.vibrate(50);
							escena.unregisterTouchArea(this);
							if(sound){
							CachovIndividual.this.tic.play();
							}
						} else {
							this.setPosition(410, 190);
							this.setScale(1.5f);
						}
						break;
					}
				} else {
					if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
					} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP
							&& (swaps < 2 || swdado5)) {
						switch (datoDado5) {
						case 0:
							datoDado5 = 5;
							this.setCurrentTileIndex(datoDado5);
							break;
						case 1:
							datoDado5 = 4;
							this.setCurrentTileIndex(datoDado5);
							break;
						case 2:
							datoDado5 = 3;
							this.setCurrentTileIndex(datoDado5);
							break;
						case 3:
							datoDado5 = 2;
							this.setCurrentTileIndex(datoDado5);
							break;
						case 4:
							datoDado5 = 1;
							this.setCurrentTileIndex(datoDado5);
							break;
						default:
							datoDado5 = 0;
							this.setCurrentTileIndex(datoDado5);
							break;
						}
						if (!swdado5) {
							swdado5 = true;
							swaps++;
						} else {
							swdado5 = false;
							swaps--;
						}
						desregistro();
						atachild();

					}

				}
				return true;
			}
		};
		escena.setTouchAreaBindingEnabled(true);
		escena.attachChild(dado1);
		escena.attachChild(dado2);
		escena.attachChild(dado3);
		escena.attachChild(dado4);
		escena.attachChild(dado5);
		
		escena.attachChild(libreta);
		escena.attachChild(boton1);
		escena.attachChild(puntuacion1);
		escena.attachChild(puntuacion2);
		escena.attachChild(puntuacion3);
		escena.attachChild(puntuacion4);
		escena.attachChild(puntuacion5);
		escena.attachChild(puntuacion6);
		escena.attachChild(puntuacion7);
		escena.attachChild(puntuacion8);
		escena.attachChild(puntuacion9);
		escena.attachChild(puntuacion10);
		escena.attachChild(puntuacion11);
		puntuacion1.setText("");
		puntuacion2.setText("");
		puntuacion3.setText("");
		puntuacion4.setText("");
		puntuacion5.setText("");
		puntuacion6.setText("");
		puntuacion7.setText("");
		puntuacion8.setText("");
		puntuacion9.setText("");
		puntuacion10.setText("");
		puntuacion11.setText("");
		puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		dado1.setVisible(false);
		dado2.setVisible(false);
		dado3.setVisible(false);
		dado4.setVisible(false);
		dado5.setVisible(false);
		
		escena.registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {

			}

			@Override
			public void onUpdate(final float pSecondsElapsed) {

				if (viny == false) {
					Intent a = new Intent(CachovIndividual.this,
							CachovIndividual.class);
					CachovIndividual.this.startActivity(a);
					CachovIndividual.this.finish();
				}

			}
		});
		menuf = new Sprite(0, 0, this.tmenu);
		escena.attachChild(menuf);
		menuf.setVisible(false);
		return escena;
	}

	public void onLoadComplete() {
		this.mEngine.enableVibrator(this);
	}   
	@Override
	public void onAccelerometerChanged(final AccelerometerData ace) {
		  
		
		if ((this.cubilete.collidesWith(dado1)
				|| this.cubilete.collidesWith(dado2)
				|| this.cubilete.collidesWith(dado3)
				|| this.cubilete.collidesWith(dado4) || this.cubilete
					.collidesWith(dado5)) && !swtabla && viny) {
			if ((ace.getZ() < -7 && ace.getY() < 7 && ace.getX() < 1)
					||(ace.getZ() < -7 && ace.getY() < 1 && ace.getX() > 4)
					||(ace.getZ() < -7 && ace.getY() < -6 && ace.getX() > 1)
					||(ace.getZ() < -7 && ace.getY() < -1 && ace.getX() < -5)
						&& !sw1) {
				swaps = 0;
				swespecial = false;
				if (this.cubilete.collidesWith(dado1)
						&& this.cubilete.collidesWith(dado2)
						&& this.cubilete.collidesWith(dado3)
						&& this.cubilete.collidesWith(dado4)
						&& this.cubilete.collidesWith(dado5)) {
					swespecial = true;
				}

				this.mEngine.vibrate(350);
				if (sound) {
					 if(mMusic.isPlaying()){
                		 CachovIndividual.this.mMusic.pause();
                	 }
					CachovIndividual.this.musica.play();
				}

				if (this.dado1.collidesWith(cubilete)) {
					this.dado1.animate(20);
					this.dado1.setPosition(390, 40);
					this.dado1.setVisible(true);
					this.dado1.setScale(1.5f);
				}
				if (this.dado2.collidesWith(cubilete)) {
					this.dado2.animate(20);
					this.dado2.setPosition(590, 40);
					this.dado2.setVisible(true);
					this.dado2.setScale(1.5f);
				}
				if (this.dado3.collidesWith(cubilete)) {
					this.dado3.animate(20);
					this.dado3.setPosition(490, 40);
					this.dado3.setVisible(true);
					this.dado3.setScale(1.5f);
				}
				if (this.dado4.collidesWith(cubilete)) {
					this.dado4.animate(20);
					this.dado4.setPosition(540, 190);
					this.dado4.setVisible(true);
					this.dado4.setScale(1.5f);
				}
				if (this.dado5.collidesWith(cubilete)) {
					this.dado5.animate(20);
					this.dado5.setPosition(410, 190);
					this.dado5.setVisible(true);
					this.dado5.setScale(1.5f);
				}
				
				  int a = (int) System.currentTimeMillis(); a = a + 1700; 
				  while
				  ((int) System.currentTimeMillis() <= a) { }
				 
				if (this.dado1.isAnimationRunning()) {
					datoDado1 = (int) (Math.random() * 6);
					this.dado1.stopAnimation();
					this.dado1.setCurrentTileIndex(datoDado1);
					
					
					
					escena.registerTouchArea(dado1);
				}
				if (this.dado2.isAnimationRunning()) {
					datoDado2 = (int) (Math.random() * 6);
					this.dado2.stopAnimation();
					this.dado2.setCurrentTileIndex(datoDado2);
					
					
					
					escena.registerTouchArea(dado2);
				}
				if (this.dado3.isAnimationRunning()) {
					datoDado3 = (int) (Math.random() * 6);
					this.dado3.stopAnimation();
					this.dado3.setCurrentTileIndex(datoDado3);
				
					
					
					escena.registerTouchArea(dado3);
				}
				if (this.dado4.isAnimationRunning()) {
					datoDado4 = (int) (Math.random() * 6);
					this.dado4.stopAnimation();
					this.dado4.setCurrentTileIndex(datoDado4);
					
					
					
					escena.registerTouchArea(dado4);
				}
				if (this.dado5.isAnimationRunning()) {
					datoDado5 = (int) (Math.random() * 6);
					this.dado5.stopAnimation();
					this.dado5.setCurrentTileIndex(datoDado5);
				
					
					
					escena.registerTouchArea(dado5);
				}
				this.mEngine.vibrate(50);

				sw1 = false;
				ntiros++;
				calcularLista();
				if (ntiros >= 2) {
					mostrarPuntuacion();
				}
			}
			 long currentTime = System.currentTimeMillis();         
             
            
             if((currentTime - lastShakeTime) > 100) {
            
                     long diffTime = currentTime - lastShakeTime;
              
                    
                     lastShakeTime = currentTime;
                    
                     float x = ace.getX();
                     float y = ace.getY();
                     float z = ace.getZ();
                    
                     float speed = Math.abs(x+y+z-lastShakeX-lastShakeY-lastShakeZ) / diffTime * 10000;
              
                    
                     if(speed > 1000) 
                     {
                             
                    	 this.mEngine.vibrate(250);
                    	 if(sound){
                    	 if(!mMusic.isPlaying()){
                    		 CachovIndividual.this.mMusic.play();
                    	 }
                    	 }
                     }
                    
                     lastShakeX = x;
                     lastShakeY = y;
                     lastShakeZ = z;                
                     
             }
			
			
			
		}
		
		
		
	}
	
  
	public void calcularLista() {
		v = new int[6];
		v[datoDado1]++;
		v[datoDado2]++;
		v[datoDado3]++;
		v[datoDado4]++;
		v[datoDado5]++;
		boolean swanotado = false;
		if ((swespecial || ntiros == 1) && swaps == 0) {
			if ((v[0] == 1 && v[1] == 1 && v[2] == 1 && v[3] == 1 && v[4] == 1)
					|| (v[5] == 1 && v[1] == 1 && v[2] == 1 && v[3] == 1 && v[4] == 1)
					|| (v[5] == 1 && v[0] == 1 && v[2] == 1 && v[3] == 1 && v[4] == 1)) {
				Sescalera = "$";
				swanotado = true;
			}
			if ((v[0] == 3 || v[1] == 3 || v[2] == 3 || v[3] == 3 || v[4] == 3 || v[5] == 3)
					&& (v[0] == 2 || v[1] == 2 || v[2] == 2 || v[3] == 2
							|| v[4] == 2 || v[5] == 2)) {
				Sfull = "$";
				swanotado = true;
			}
			if (v[0] == 4 || v[1] == 4 || v[2] == 4 || v[3] == 4 || v[4] == 4
					|| v[5] == 4) {
				Spoker = "$";
				swanotado = true;
			}
			if (v[0] == 5 || v[1] == 5 || v[2] == 5 || v[3] == 5 || v[4] == 5
					|| v[5] == 5) {
				swaps = 3;
				this.libreta.setVisible(false);
				this.escena.unregisterTouchArea(dado1);
				this.escena.unregisterTouchArea(dado2);
				this.escena.unregisterTouchArea(dado3);
				this.escena.unregisterTouchArea(dado4);
				this.escena.unregisterTouchArea(dado5);
				this.escena.unregisterTouchArea(boton1);
				this.escena.unregisterTouchArea(boton2);
				this.escena.unregisterTouchArea(boton3);
				this.puntuacion1.setVisible(false);
				this.puntuacion2.setVisible(false);
				this.puntuacion3.setVisible(false);
				this.puntuacion4.setVisible(false);
				this.puntuacion5.setVisible(false);
				this.puntuacion6.setVisible(false);
				this.puntuacion7.setVisible(false);
				this.puntuacion8.setVisible(false);
				this.puntuacion9.setVisible(false);
				this.puntuacion10.setVisible(false);
				this.puntuacion11.setVisible(false);
				this.cubilete.setVisible(false);
				this.boton3.setVisible(false);
				this.boton2.setVisible(false);
				this.boton1.setVisible(false);
				this.bocina.setVisible(false);
				this.puntuacion1.setVisible(false);
				this.puntuacion2.setVisible(false);
				this.puntuacion3.setVisible(false);
				this.puntuacion4.setVisible(false);
				this.puntuacion5.setVisible(false);
				this.puntuacion6.setVisible(false);
				this.puntuacion7.setVisible(false);
				this.puntuacion8.setVisible(false);
				this.puntuacion9.setVisible(false);
				this.puntuacion10.setVisible(false);
				this.puntuacion11.setVisible(false);
				this.escena.unregisterTouchArea(puntuacion1);
				this.escena.unregisterTouchArea(puntuacion2);
				this.escena.unregisterTouchArea(puntuacion3);
				this.escena.unregisterTouchArea(puntuacion4);
				this.escena.unregisterTouchArea(puntuacion5);
				this.escena.unregisterTouchArea(puntuacion6);
				this.escena.unregisterTouchArea(puntuacion7);
				this.escena.unregisterTouchArea(puntuacion8);
				this.escena.unregisterTouchArea(puntuacion9);
				this.escena.unregisterTouchArea(puntuacion10);
				this.escena.unregisterTouchArea(puntuacion11);
				SpriteBackground fn = new SpriteBackground(new Sprite(0, 0, this.mBgTexture2));
				escena.setBackground(fn);
				
				this.swpuntuacion=true;
				for(int i=0;i<NJ;i++){
					txt[i].setVisible(false);
				}
				this.dormida = new Text(0, 0, this.mFont, "Dormida!!\nGanaste "+m[np][0],
						HorizontalAlign.LEFT);
				this.dormida.setPosition(150, 290);
				this.dormida.registerEntityModifier(new ScaleModifier(3, 0.1f,
						1.5f));
				this.dormida.registerEntityModifier(new RotationModifier(3, 0,
						720));
				this.escena.attachChild(this.dormida);
				swanotado = true;
				aceptar();
			}
		}
		if (!swanotado) {
			if ((v[0] == 1 && v[1] == 1 && v[2] == 1 && v[3] == 1 && v[4] == 1)
					|| (v[5] == 1 && v[1] == 1 && v[2] == 1 && v[3] == 1 && v[4] == 1)
					|| (v[5] == 1 && v[0] == 1 && v[2] == 1 && v[3] == 1 && v[4] == 1)) {
				Sescalera = "0";

			} else {
				Sescalera = "X";
			}
			if ((v[0] == 3 || v[1] == 3 || v[2] == 3 || v[3] == 3 || v[4] == 3 || v[5] == 3)
					&& (v[0] == 2 || v[1] == 2 || v[2] == 2 || v[3] == 2
							|| v[4] == 2 || v[5] == 2)) {
				Sfull = "0";

			} else {
				Sfull = "X";
			}
			if (v[0] == 4 || v[1] == 4 || v[2] == 4 || v[3] == 4 || v[4] == 4
					|| v[5] == 4) {
				Spoker = "0";

			} else {
				Spoker = "X";
			}
			if (v[0] == 5 || v[1] == 5 || v[2] == 5 || v[3] == 5 || v[4] == 5
					|| v[5] == 5) {
				Sgrande = "$";

			} else {
				Sgrande = "X";
			}
			
			
			
		}
		

	}

	@Override
	public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent) {
		if (pKeyCode == KeyEvent.KEYCODE_BACK) {

			AlertDialog.Builder salir = new AlertDialog.Builder(this);
			salir.setMessage("Los datos se perderan, ok?")
					.setCancelable(false)
					.setPositiveButton("Si",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									CachovIndividual.this.finish();
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
		if (pKeyCode == KeyEvent.KEYCODE_SEARCH
				&& pEvent.getAction() == KeyEvent.ACTION_DOWN) {
			return super.onKeyDown(KeyEvent.KEYCODE_HOME, pEvent);

		}
		if (pKeyCode == KeyEvent.KEYCODE_MENU
				&& pEvent.getAction() == KeyEvent.ACTION_DOWN) {
			if (this.escena.hasChildScene()) {
				this.mMenuScene.back();
				menuf.setVisible(false);
			} else {
				menuf.setVisible(true);
				CachovIndividual.this.escena.setChildScene(
				CachovIndividual.this.mMenuScene, false, true, true);
			}
		}
					
			 
		
			
		
		else {
			return super.onKeyDown(pKeyCode, pEvent);
		}
		return true;
	}

	@Override
	public boolean onMenuItemClicked(final MenuScene pMenuScene,
			final IMenuItem pMenuItem, final float pMenuItemLocalX,
			final float pMenuItemLocalY) {
		switch (pMenuItem.getID()) {
		case MENU_SOUND:
			if (sound) {
				sound = false;
				this.bocina.setCurrentTileIndex(1);
				this.mostrar("Sonido desactivado");
			} else {
				sound = true;
				this.bocina.setCurrentTileIndex(0);
				this.mostrar("Sonido activado");
			}

			return true;

		case MENU_RESET:

			this.finish();
			return true;
		case MENU_QUIT:

			AlertDialog.Builder salir = new AlertDialog.Builder(this);
			salir.setMessage("Los datos se perderan, ok?")
					.setCancelable(false)
					.setPositiveButton("Si",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									CachovIndividual.this.finish();
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
			return true;
		default:
			return false;
		}
	}

	protected MenuScene createMenuScene() {
		final MenuScene menuScene = new MenuScene(this.camara);

		final IMenuItem resetMenuItem = new ColorMenuItemDecorator(
				new TextMenuItem(MENU_RESET, this.mFont, "Reiniciar"), 1.0f,
				0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
		resetMenuItem.setBlendFunction(GL10.GL_SRC_ALPHA,
				GL10.GL_ONE_MINUS_SRC_ALPHA);
		menuScene.addMenuItem(resetMenuItem);

		final IMenuItem quitMenuItem = new ColorMenuItemDecorator(
				new TextMenuItem(MENU_QUIT, this.mFont, "Salir"), 1.0f, 0.0f,
				0.0f, 1.0f, 1.0f, 1.0f);
		quitMenuItem.setBlendFunction(GL10.GL_SRC_ALPHA,
				GL10.GL_ONE_MINUS_SRC_ALPHA);
		menuScene.addMenuItem(quitMenuItem);

		final IMenuItem musicMenuItem = new ColorMenuItemDecorator(
				new TextMenuItem(MENU_SOUND, this.mFont, "Sonido"), 1.0f, 0.0f,
				0.0f, 1.0f, 1.0f, 1.0f);
		quitMenuItem.setBlendFunction(GL10.GL_SRC_ALPHA,
				GL10.GL_ONE_MINUS_SRC_ALPHA);
		menuScene.addMenuItem(musicMenuItem);
		menuScene.buildAnimations();
		menuScene.setBackgroundEnabled(false);

		
		menuScene.setOnMenuItemClickListener(this);
		return menuScene;
	}

	public void mostrar(String x) {
		Toast.makeText(this, x, Toast.LENGTH_SHORT).show();
	}

	public void mostrarPuntuacion() {
		if(!swpuntuacion){
		if (ntiros == 1) {
			escena.registerTouchArea(boton1);
			boton1.setVisible(true);

		}
        swtabla = true;
		boton2.setVisible(false);

		escena.unregisterTouchArea(bocina);
		swaps = 0;
		swdado1 = false;
		swdado2 = false;
		swdado3 = false;
		swdado4 = false;
		swdado5 = false;
		swdado = true;
		uno = datoDado1;
		dos = datoDado2;
		tres = datoDado3;
		cuatro = datoDado4;
		cinco = datoDado5;
		dado1.setPosition(390, 40);
		dado1.setScale(1.5f);
		dado2.setPosition(590, 40);
		dado2.setScale(1.5f);
		dado3.setPosition(490, 40);
		dado3.setScale(1.5f);
		dado4.setPosition(540, 190);
		dado4.setScale(1.5f);
		dado5.setPosition(410, 190);
		dado5.setScale(1.5f);
		escena.setTouchAreaBindingEnabled(true);
		libreta.setPosition(0, 50);
		escena.unregisterTouchArea(boton2);   
		puntuacion1.setText(m[np][1]);
		puntuacion2.setText(m[np][7]);
		puntuacion3.setText(m[np][4]);
		puntuacion4.setText(m[np][2]);
		puntuacion5.setText(m[np][8]);
		puntuacion6.setText(m[np][5]);
		puntuacion7.setText(m[np][3]);
		puntuacion8.setText(m[np][9]);
		puntuacion9.setText(m[np][6]);
		puntuacion10.setText(m[np][10]);
		puntuacion11.setText(m[np][11]);
		desregistro();
		atachild();
		}
	}

	private void salirPuntuacion() {
		if (ntiros == 1) {
			escena.unregisterTouchArea(boton1);
			boton1.setVisible(false);
		}

		boton2.setVisible(true);
		escena.registerTouchArea(bocina);

		swdado1 = false;
		swdado2 = false;
		swdado3 = false;
		swdado4 = false;
		swdado5 = false;
		libreta.setPosition(-40, 380);
		swdado = false;
		swaps = 3;
		escena.registerTouchArea(boton2);
		desregistro();
		puntuacion1.setText("");
		puntuacion2.setText("");
		puntuacion3.setText("");
		puntuacion4.setText("");
		puntuacion5.setText("");
		puntuacion6.setText("");
		puntuacion7.setText("");
		puntuacion8.setText("");
		puntuacion9.setText("");
		puntuacion10.setText("");
		puntuacion11.setText("");
		dado1.setPosition(70, 260);
		dado1.setScale(1);
		dado1.setCurrentTileIndex(0);
		dado2.setPosition(70, 395);
		dado2.setScale(1);
		dado2.setCurrentTileIndex(0);
		dado3.setPosition(230, 220);
		dado3.setScale(1);
		dado3.setCurrentTileIndex(0);
		dado4.setPosition(250, 320);
		dado4.setScale(1);
		dado4.setCurrentTileIndex(0);
		dado5.setPosition(160, 250);
		dado5.setScale(1);
		dado1.setVisible(false);
		dado2.setVisible(false);
		dado3.setVisible(false);
		dado4.setVisible(false);
		dado5.setVisible(false);
		escena.unregisterTouchArea(dado1);
		escena.unregisterTouchArea(dado2);
		escena.unregisterTouchArea(dado3);
		escena.unregisterTouchArea(dado4);
		escena.unregisterTouchArea(dado5);
		dado5.setCurrentTileIndex(0);
		swtabla = false;
		contador++;

		if (contador == 11 * NJ) {
			this.escena.unregisterTouchArea(dado1);
			this.escena.unregisterTouchArea(dado2);
			this.escena.unregisterTouchArea(dado3);
			this.escena.unregisterTouchArea(dado4);
			this.escena.unregisterTouchArea(dado5);
			this.escena.unregisterTouchArea(boton1);
			this.escena.unregisterTouchArea(boton2);
			this.escena.unregisterTouchArea(boton3);
			this.dado1.setVisible(false);
			this.dado2.setVisible(false);
			this.dado3.setVisible(false);
			this.dado4.setVisible(false);
			this.dado5.setVisible(false);
			this.bocina.setVisible(false);
			this.libreta.setVisible(false);
			this.cubilete.setVisible(false);
			this.swpuntuacion=true;
			this.puntuacion1.setVisible(false);
			this.puntuacion2.setVisible(false);
			this.puntuacion3.setVisible(false);
			this.puntuacion4.setVisible(false);
			this.puntuacion5.setVisible(false);
			this.puntuacion6.setVisible(false);
			this.puntuacion7.setVisible(false);
			this.puntuacion8.setVisible(false);
			this.puntuacion9.setVisible(false);
			this.puntuacion10.setVisible(false);
			this.puntuacion11.setVisible(false);
			this.boton1.setVisible(false);
			this.boton2.setVisible(false);
			this.boton3.setVisible(false);
			SpriteBackground fn = new SpriteBackground(new Sprite(0, 0, this.mBgTexture2));
			escena.setBackground(fn);
		
			

			int y = 5;
			for (int i = 0; i < NJ; i++) {
				escena.detachChild(txt[i]);
			}
			int ganador = 0, id = 0;
			for (int i = 0; i < NJ; i++) {
				txt[i] = new ChangeableText(5, y, CachovIndividual.this.mFont,
						"", 15);
				String a = (m[i][0] + " = " + String.valueOf(CPT(i)));
				if (CPT(i) > ganador) {
					ganador = CPT(i);
					id = i;
				}
				txt[i].setText(a);
				txt[i].setColor(1.0f, 1.0f, 1.0f, 1.0f);
				escena.attachChild(txt[i]);
				y += 50;
			}
			ChangeableText win = new ChangeableText(5, y,
					CachovIndividual.this.mFont, "", 30);
			if (ganador == 0) {
				win.setText("0 que mal...practica mas ");
			} else {
				win.setText("El ganador es: " + m[id][0]);
			}
			escena.attachChild(win);
			swtabla = true;
			aceptar();
		}
		
	}

	public int CPT(int nj) {
		int c = 0;
		c += Integer.parseInt(m[nj][1]);
		c += Integer.parseInt(m[nj][2]);
		c += Integer.parseInt(m[nj][3]);
		c += Integer.parseInt(m[nj][4]);
		c += Integer.parseInt(m[nj][5]);
		c += Integer.parseInt(m[nj][6]);

		if (m[nj][7].equals("$")) {
			c += 25;
		} else {
			if (m[nj][7].equals("0")) {
				c += 20;
			}
		}
		if (m[nj][8].equals("$")) {
			c += 35;
		} else {
			if (m[nj][8].equals("0")) {
				c += 30;
			}
		}
		if (m[nj][9].equals("$")) {
			c += 45;
		} else {
			if (m[nj][9].equals("0")) {
				c += 40;
			}
		}
		if (m[nj][10].equals("$")) {
			c += 50;
		}
		if (m[nj][11].equals("$")) {
			c += 50;
		}
		return c;
	}

	public void textear() {
		puntuacion1.setVisible(true);
		puntuacion2.setVisible(true);
		puntuacion3.setVisible(true);
		puntuacion4.setVisible(true);
		puntuacion5.setVisible(true);
		puntuacion6.setVisible(true);
		puntuacion7.setVisible(true);
		puntuacion8.setVisible(true);
		puntuacion9.setVisible(true);
		puntuacion10.setVisible(true);
		puntuacion11.setVisible(true);
		puntuacion1.setText(m[np][1]);
		puntuacion2.setText(m[np][7]);
		puntuacion3.setText(m[np][4]);
		puntuacion4.setText(m[np][2]);
		puntuacion5.setText(m[np][8]);
		puntuacion6.setText(m[np][5]);
		puntuacion7.setText(m[np][3]);
		puntuacion8.setText(m[np][9]);
		puntuacion9.setText(m[np][6]);
		puntuacion10.setText(m[np][10]);
		puntuacion11.setText(m[np][11]);
	}

	private void salirPuntuacion2() {
		escena.unregisterTouchArea(boton1);
		boton1.setVisible(false);
		boton2.setVisible(true);

		escena.registerTouchArea(bocina);
		swdado1 = false;
		swdado2 = false;
		swdado3 = false;
		swdado4 = false;
		swdado5 = false;
		libreta.setPosition(-40, 380);
		swdado = false;
		swaps = 3;
		swtabla = false;
		escena.registerTouchArea(boton2);
		// escena.registerTouchArea(boton3);
		desregistro();
		puntuacion1.setText("");
		puntuacion2.setText("");
		puntuacion3.setText("");
		puntuacion4.setText("");
		puntuacion5.setText("");
		puntuacion6.setText("");
		puntuacion7.setText("");
		puntuacion8.setText("");
		puntuacion9.setText("");
		puntuacion10.setText("");
		puntuacion11.setText("");
		puntuacion1.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion2.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion3.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion4.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion5.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion6.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion7.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion8.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion9.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion10.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		puntuacion11.setColor(0.14f, 0.40f, 0.50f, 1.0f);
		escena.registerTouchArea(dado1);
		escena.registerTouchArea(dado2);
		escena.registerTouchArea(dado3);
		escena.registerTouchArea(dado4);
		escena.registerTouchArea(dado5);
		escena.setTouchAreaBindingEnabled(true);
		datoDado1 = uno;
		datoDado2 = dos;
		datoDado3 = tres;
		datoDado4 = cuatro;
		datoDado5 = cinco;
		dado1.setCurrentTileIndex(uno);
		dado2.setCurrentTileIndex(dos);
		dado3.setCurrentTileIndex(tres);
		dado4.setCurrentTileIndex(cuatro);
		dado5.setCurrentTileIndex(cinco);
	}

	public void atachild() {
		if (ntiros != 0) {
			calcularLista();
			boolean a = true;

			if (v[0] != 0 || 11 * NJ - NJ <= contador || g[np][1] == 2) {
				escena.registerTouchArea(puntuacion1);
				puntuacion1.setVisible(true);
				if (g[np][1] != 2) {
					a = false;
				}
			}
			if (v[1] != 0 || 11 * NJ - NJ <= contador || g[np][4] == 2) {
				escena.registerTouchArea(puntuacion4);
				puntuacion4.setVisible(true);
				if (g[np][4] != 2) {
					a = false;
				}
			}
			if (v[2] != 0 || 11 * NJ - NJ <= contador || g[np][7] == 2) {
				escena.registerTouchArea(puntuacion7);
				puntuacion7.setVisible(true);
				if (g[np][7] != 2) {
					a = false;
				}
			}
			if (v[3] != 0 || 11 * NJ - NJ <= contador || g[np][3] == 2) {
				escena.registerTouchArea(puntuacion3);
				puntuacion3.setVisible(true);
				if (g[np][3] != 2) {
					a = false;
				}
			}
			if (v[4] != 0 || 11 * NJ - NJ <= contador || g[np][6] == 2) {
				escena.registerTouchArea(puntuacion6);
				puntuacion6.setVisible(true);
				if (g[np][6] != 2) {
					a = false;
				}
			}

			if (v[5] != 0 || 11 * NJ - NJ <= contador || g[np][9] == 2) {
				escena.registerTouchArea(puntuacion9);
				puntuacion9.setVisible(true);
				if (g[np][9] != 2) {
					a = false;
				}
			}
			if (!Sescalera.equals("X") || 11 * NJ - NJ <= contador
					|| g[np][2] == 2) {
				escena.registerTouchArea(puntuacion2);
				puntuacion2.setVisible(true);
				if (g[np][2] != 2) {
					a = false;
				}
			}
			if (!Sfull.equals("X") || 11 * NJ - NJ <= contador || g[np][5] == 2) {
				escena.registerTouchArea(puntuacion5);
				puntuacion5.setVisible(true);
				if (g[np][5] != 2) {
					a = false;
				}
			}
			if (!Spoker.equals("X") || 11 * NJ - NJ <= contador
					|| g[np][8] == 2) {
				escena.registerTouchArea(puntuacion8);
				puntuacion8.setVisible(true);
				if (g[np][8] != 2) {
					a = false;
				}
			}
			if (!Sgrande.equals("X") || 11 * NJ - NJ <= contador
					|| g[np][10] == 2) {
				escena.registerTouchArea(puntuacion10);
				puntuacion10.setVisible(true);
				if (g[np][10] != 2) {
					a = false;
				}
			}
			if (!Sgrande.equals("X") || 11 * NJ - NJ <= contador
					|| g[np][11] == 2) {
				escena.registerTouchArea(puntuacion11);
				puntuacion11.setVisible(true);
				if (g[np][11] != 2) {
					a = false;
				}
			}
			if (a) {
				ggar();
			}

		}
	}

	private void ggar() {
		if (g[np][1] != 2) {
			escena.registerTouchArea(puntuacion1);
			puntuacion1.setVisible(true);
		}
		if (g[np][2] != 2) {
			escena.registerTouchArea(puntuacion2);
			puntuacion2.setVisible(true);
		}
		if (g[np][3] != 2) {
			escena.registerTouchArea(puntuacion3);
			puntuacion3.setVisible(true);
		}
		if (g[np][4] != 2) {
			escena.registerTouchArea(puntuacion4);
			puntuacion4.setVisible(true);
		}
		if (g[np][5] != 2) {
			escena.registerTouchArea(puntuacion5);
			puntuacion5.setVisible(true);
		}
		if (g[np][6] != 2) {
			escena.registerTouchArea(puntuacion6);
			puntuacion6.setVisible(true);
		}
		if (g[np][7] != 2) {
			escena.registerTouchArea(puntuacion7);
			puntuacion7.setVisible(true);
		}
		if (g[np][8] != 2) {
			escena.registerTouchArea(puntuacion8);
			puntuacion8.setVisible(true);
		}
		if (g[np][9] != 2) {
			escena.registerTouchArea(puntuacion9);
			puntuacion9.setVisible(true);
		}
		if (g[np][10] != 2) {
			escena.registerTouchArea(puntuacion10);
			puntuacion10.setVisible(true);
		}
		if (g[np][11] != 2) {
			escena.registerTouchArea(puntuacion11);
			puntuacion11.setVisible(true);
		}

	}

	public void desregistro() {

		if (puntuacion1.isVisible()) {
			escena.unregisterTouchArea(puntuacion1);
			puntuacion1.setVisible(false);
		}
		if (puntuacion2.isVisible()) {
			escena.unregisterTouchArea(puntuacion2);
			puntuacion2.setVisible(false);
		}
		if (puntuacion3.isVisible()) {
			escena.unregisterTouchArea(puntuacion3);
			puntuacion3.setVisible(false);
		}
		if (puntuacion4.isVisible()) {
			escena.unregisterTouchArea(puntuacion4);
			puntuacion4.setVisible(false);
		}
		if (puntuacion5.isVisible()) {
			escena.unregisterTouchArea(puntuacion5);
			puntuacion5.setVisible(false);
		}
		if (puntuacion6.isVisible()) {
			escena.unregisterTouchArea(puntuacion6);
			puntuacion6.setVisible(false);
		}
		if (puntuacion7.isVisible()) {
			escena.unregisterTouchArea(puntuacion7);
			puntuacion7.setVisible(false);
		}
		if (puntuacion8.isVisible()) {
			escena.unregisterTouchArea(puntuacion8);
			puntuacion8.setVisible(false);
		}
		if (puntuacion1.isVisible()) {
			escena.unregisterTouchArea(puntuacion1);
			puntuacion1.setVisible(false);
		}
		if (puntuacion9.isVisible()) {
			escena.unregisterTouchArea(puntuacion9);
			puntuacion9.setVisible(false);
		}
		if (puntuacion10.isVisible()) {
			escena.unregisterTouchArea(puntuacion10);
			puntuacion10.setVisible(false);
		}
		if (puntuacion11.isVisible()) {
			escena.unregisterTouchArea(puntuacion11);
			puntuacion11.setVisible(false);
		}

	}

	@Override
	public void onResumeGame() {
		super.onResumeGame();

		this.enableAccelerometerSensor(this);
	}

	@Override
	public void onPauseGame() {
		super.onPauseGame();
		this.disableAccelerometerSensor();
	}
	
	public boolean verificar(){
		if((m[np][7].equals("$") &&
				m[np][8].equals("$") &&
				m[np][9].equals("$") &&
				(m[np][10].equals("$") ||m[np][11].equals("$")))
				
		)
		
		{		
			swaps = 3;
			swpuntuacion=true;
			this.libreta.setVisible(false);
			this.escena.unregisterTouchArea(dado1);
			this.escena.unregisterTouchArea(dado2);
			this.escena.unregisterTouchArea(dado3);
			this.escena.unregisterTouchArea(dado4);
			this.escena.unregisterTouchArea(dado5);
			this.escena.unregisterTouchArea(boton2);
			this.puntuacion1.setVisible(false);
			this.puntuacion2.setVisible(false);
			this.puntuacion3.setVisible(false);
			this.puntuacion4.setVisible(false);
			this.puntuacion5.setVisible(false);
			this.puntuacion6.setVisible(false);
			this.puntuacion7.setVisible(false);
			this.puntuacion8.setVisible(false);
			this.puntuacion9.setVisible(false);
			this.puntuacion10.setVisible(false);
			this.puntuacion11.setVisible(false);
			this.cubilete.setVisible(false);
			this.boton3.setVisible(false);
			this.boton2.setVisible(false);
			this.boton1.setVisible(false);
			this.bocina.setVisible(false);
			this.puntuacion1.setVisible(false);
			this.puntuacion2.setVisible(false);
			this.puntuacion3.setVisible(false);
			this.puntuacion4.setVisible(false);
			this.puntuacion5.setVisible(false);
			this.puntuacion6.setVisible(false);
			this.puntuacion7.setVisible(false);
			this.puntuacion8.setVisible(false);
			this.puntuacion9.setVisible(false);
			this.puntuacion10.setVisible(false);
			this.puntuacion11.setVisible(false);
			this.escena.unregisterTouchArea(puntuacion1);
			this.escena.unregisterTouchArea(puntuacion2);
			this.escena.unregisterTouchArea(puntuacion3);
			this.escena.unregisterTouchArea(puntuacion4);
			this.escena.unregisterTouchArea(puntuacion5);
			this.escena.unregisterTouchArea(puntuacion6);
			this.escena.unregisterTouchArea(puntuacion7);
			this.escena.unregisterTouchArea(puntuacion8);
			this.escena.unregisterTouchArea(puntuacion9);
			this.escena.unregisterTouchArea(puntuacion10);
			this.escena.unregisterTouchArea(puntuacion11);
			this.escena.unregisterTouchArea(boton1);
			this.escena.unregisterTouchArea(boton2);
			this.escena.unregisterTouchArea(boton3);
			this.dado1.setVisible(false);
			this.dado2.setVisible(false);
			this.dado3.setVisible(false);
			this.dado4.setVisible(false);
			this.dado5.setVisible(false);
			boton1.setVisible(false);
			boton2.setVisible(false);
			boton3.setVisible(false);
			SpriteBackground fn = new SpriteBackground(new Sprite(0, 0, this.mBgTexture2));
			escena.setBackground(fn);
			for(int i=0;i<NJ;i++){
				txt[i].setVisible(false);
			}
			this.dormida = new Text(0, 0, this.mFont, "Panza de oro!!\nGanaste "+m[np][0],
					HorizontalAlign.LEFT);
			this.dormida.setPosition(150, 290);
			this.dormida.registerEntityModifier(new ScaleModifier(3, 0.1f,
					1.5f));
			this.dormida.registerEntityModifier(new RotationModifier(3, 0,
					720));
			
			this.escena.attachChild(this.dormida);
			aceptar();
			
			
			
			
			return true;
			
		}
		if(!m[np][1].equalsIgnoreCase("~~")&&
				!m[np][2].equalsIgnoreCase("~~")&&
				!m[np][3].equalsIgnoreCase("~~")&&
				!m[np][4].equalsIgnoreCase("~~")&&
				!m[np][5].equalsIgnoreCase("~~")&&
				!m[np][6].equalsIgnoreCase("~~")){
		if((Integer.parseInt(m[np][1])>=4 &&
				Integer.parseInt(m[np][2])>=8 &&
				Integer.parseInt(m[np][3])>=12 &&
				Integer.parseInt(m[np][4])>=16 &&
				Integer.parseInt(m[np][5])>=20 &&
					Integer.parseInt(m[np][6])>=24 &&
							(m[np][10].equals("$") ||m[np][11].equals("$")))){
			swaps = 3;
			swpuntuacion=true;
			this.libreta.setVisible(false);
			this.escena.unregisterTouchArea(dado1);
			this.escena.unregisterTouchArea(dado2);
			this.escena.unregisterTouchArea(dado3);
			this.escena.unregisterTouchArea(dado4);
			this.escena.unregisterTouchArea(dado5);
			this.escena.unregisterTouchArea(boton2);
			this.puntuacion1.setVisible(false);
			this.puntuacion2.setVisible(false);
			this.puntuacion3.setVisible(false);
			this.puntuacion4.setVisible(false);
			this.puntuacion5.setVisible(false);
			this.puntuacion6.setVisible(false);
			this.puntuacion7.setVisible(false);
			this.puntuacion8.setVisible(false);
			this.puntuacion9.setVisible(false);
			this.puntuacion10.setVisible(false);
			this.puntuacion11.setVisible(false);
			this.cubilete.setVisible(false);
			this.boton3.setVisible(false);
			this.boton2.setVisible(false);
			this.boton1.setVisible(false);
			this.bocina.setVisible(false);
			this.puntuacion1.setVisible(false);
			this.puntuacion2.setVisible(false);
			this.puntuacion3.setVisible(false);
			this.puntuacion4.setVisible(false);
			this.puntuacion5.setVisible(false);
			this.puntuacion6.setVisible(false);
			this.puntuacion7.setVisible(false);
			this.puntuacion8.setVisible(false);
			this.puntuacion9.setVisible(false);
			this.puntuacion10.setVisible(false);
			this.puntuacion11.setVisible(false);
			this.escena.unregisterTouchArea(puntuacion1);
			this.escena.unregisterTouchArea(puntuacion2);
			this.escena.unregisterTouchArea(puntuacion3);
			this.escena.unregisterTouchArea(puntuacion4);
			this.escena.unregisterTouchArea(puntuacion5);
			this.escena.unregisterTouchArea(puntuacion6);
			this.escena.unregisterTouchArea(puntuacion7);
			this.escena.unregisterTouchArea(puntuacion8);
			this.escena.unregisterTouchArea(puntuacion9);
			this.escena.unregisterTouchArea(puntuacion10);
			this.escena.unregisterTouchArea(puntuacion11);
			this.escena.unregisterTouchArea(boton1);
			this.escena.unregisterTouchArea(boton2);
			this.escena.unregisterTouchArea(boton3);
			boton1.setVisible(false);
			boton2.setVisible(false);
			boton3.setVisible(false);
			this.dado1.setVisible(false);
			this.dado2.setVisible(false);
			this.dado3.setVisible(false);
			this.dado4.setVisible(false);
			this.dado5.setVisible(false);
			SpriteBackground fun = new SpriteBackground(new Sprite(0, 0, this.mBgTexture2));
			escena.setBackground(fun);
			for(int i=0;i<NJ;i++){
				txt[i].setVisible(false);
			}
			this.dormida = new Text(0, 0, this.mFont, "Alalay!!!\nGanaste "+m[np][0],
					HorizontalAlign.LEFT);
			this.dormida.setPosition(150, 290);
			this.dormida.registerEntityModifier(new ScaleModifier(3, 0.1f,
					1.5f));
			this.dormida.registerEntityModifier(new RotationModifier(3, 0,
					720));
			
			this.escena.attachChild(this.dormida);
			aceptar();
			return true;
		}else{
			return false;
		}
		
		}
		else{
			return false;
		}
		
		
		
	}
	public void mostrarAll(int x){
		
		if(!swtabla && !finalisimo){
			puntuacion1.setText((m[x][1]));
			puntuacion2.setText((m[x][7]));
			puntuacion3.setText((m[x][4]));
			puntuacion4.setText((m[x][2]));
			puntuacion5.setText((m[x][8]));
			puntuacion6.setText((m[x][5]));
			puntuacion7.setText((m[x][3]));
			puntuacion8.setText((m[x][9]));
			puntuacion9.setText((m[x][6]));
			puntuacion10.setText((m[x][10]));
			puntuacion11.setText((m[x][11]));
			puntuacion1.setVisible(true);
			puntuacion2.setVisible(true);
			puntuacion3.setVisible(true);
			puntuacion4.setVisible(true);
			puntuacion5.setVisible(true);
			puntuacion6.setVisible(true);
			puntuacion7.setVisible(true);
			puntuacion8.setVisible(true);
			puntuacion9.setVisible(true);
			puntuacion10.setVisible(true);
			puntuacion11.setVisible(true);
			libreta.setPosition(0, 50);
			}
		}
		
	@Override
	public boolean onSceneTouchEvent(final Scene pScene, final TouchEvent evento) {
		
			if(evento.isActionDown()) {
				if(evento.getX()==txt[1].getX() && evento.getY()==txt[1].getY()){
					mostrarAll(1);
				}
				return true;
			}
			if(evento.isActionUp()){
				salirAll();
			}
		
		return false;
	}
	public void salirAll()
	{
		if(!swtabla){
			puntuacion1.setText("");
			puntuacion2.setText("");
			puntuacion3.setText("");
			puntuacion4.setText("");
			puntuacion5.setText("");
			puntuacion6.setText("");
			puntuacion7.setText("");
			puntuacion8.setText("");
			puntuacion9.setText("");
			puntuacion10.setText("");
			puntuacion11.setText("");
			puntuacion1.setVisible(false);
			puntuacion2.setVisible(false);
			puntuacion3.setVisible(false);
			puntuacion4.setVisible(false);
			puntuacion5.setVisible(false);
			puntuacion6.setVisible(false);
			puntuacion7.setVisible(false);
			puntuacion8.setVisible(false);
			puntuacion9.setVisible(false);
			puntuacion10.setVisible(false);
			puntuacion11.setVisible(false);
			libreta.setPosition(-40, 380);
		}
	}

	@Override
	public boolean onAreaTouched(TouchEvent arg0, ITouchArea arg1, float arg2,
			float arg3) {
		
		// TODO Auto-generated method stub
		return false;
	}
	 public void aceptar(){
	    	
		 finalisimo=true;
		 ace=new AnimatedSprite(565,400,this.taceptar){
	    		
	    	@Override
	    			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
	    					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
	    				if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_DOWN) {
	    					this.setCurrentTileIndex(1);
	    				} else if (pSceneTouchEvent.getAction() == MotionEvent.ACTION_UP) {
	    					this.setCurrentTileIndex(0);
	    					CachovIndividual.this.finish();
	    				}
	    				return true;
	    				
	    	}
	     
	    };
	    
	    ace.setScale(2);
	    fin= new Text(548,403,this.mFont,"aceptar");
	    CachovIndividual.this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				  escena.attachChild(ace);
				    escena.attachChild(fin);
				    escena.registerTouchArea(ace);
			}
		});
	    
	    	}

}