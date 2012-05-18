package viny.soltux;

import java.io.IOException;

import org.anddev.andengine.audio.sound.Sound;
import org.anddev.andengine.audio.sound.SoundFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.util.Debug;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.Toast;

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
public class TecladoEquipos extends BaseExample {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final int CAMERA_WIDTH = 720;
	private static final int CAMERA_HEIGHT = 480;
	private String nombres[]=new String[5];
	// ===========================================================
	// Fields
	// ===========================================================
	private ChangeableText text;
	private Camera mCamera;
	private BitmapTextureAtlas mBitmapTextureAtlas;
	private TiledTextureRegion qt;
	private TiledTextureRegion wt;
	private TiledTextureRegion et;
	private TiledTextureRegion rt;
	private TiledTextureRegion tt;
	private TiledTextureRegion yt;
	private TiledTextureRegion ut;
	private TiledTextureRegion it;
	private TiledTextureRegion ot;
	private TiledTextureRegion pt;
	private TiledTextureRegion at;
	private TiledTextureRegion st;
	private TiledTextureRegion dt;
	private TiledTextureRegion ft;
	private TiledTextureRegion gt;
	private TiledTextureRegion ht;
	private TiledTextureRegion jt;
	private TiledTextureRegion kt;
	private TiledTextureRegion lt;
	private TiledTextureRegion zt;
	private TiledTextureRegion xt;
	private TiledTextureRegion ct;
	private TiledTextureRegion vt;
	private TiledTextureRegion bt;
	private TiledTextureRegion nt;
	private TiledTextureRegion mt;
	private TiledTextureRegion borrart;
	private TiledTextureRegion cancel;
	
	private BitmapTextureAtlas mFontTexture;
	private Font mFont;
	private String aux;
	private AnimatedSprite q;
	private AnimatedSprite w;
	private AnimatedSprite e;
	private AnimatedSprite r;
	private AnimatedSprite t;
	private AnimatedSprite y;
	private AnimatedSprite u;
	private AnimatedSprite i;
	private AnimatedSprite o;
	private AnimatedSprite p;
	private AnimatedSprite a;
	private AnimatedSprite s;
	private AnimatedSprite d;
	private AnimatedSprite f;
	private AnimatedSprite g;
	private AnimatedSprite h;
	private AnimatedSprite j;
	private AnimatedSprite k;
	private AnimatedSprite l;
	private AnimatedSprite ñ;
	private AnimatedSprite z;
	private AnimatedSprite x;
	private AnimatedSprite c;
	private AnimatedSprite v;
	private AnimatedSprite b;
	private AnimatedSprite n;
	private AnimatedSprite m;
	private Text texto;
	private AnimatedSprite borrar;
	private BitmapTextureAtlas mBackgroundTexture;
	private TextureRegion mBgTexture;
	private TextureRegion tLibreta;
	private BitmapTextureAtlas mLibreta;
	private Text texto1;
	private IEntity texto2;
	private Text texto3;
	private Text texto4;
	private IEntity texto5;
	private IEntity texto6;
	private Text texto7;
	private IEntity texto8;
	private Text texto9;
	private IEntity texto10;
	private IEntity texto11;
	private IEntity texto12;
	private Text texto13;
	private Text texto14;
	private Text texto15;
	private Text texto16;
	private Text texto17;
	private Text texto18;
	private Text texto19;
	private Text texto20;
	private Text texto21;
	private Text texto22;
	private Text texto23;
	private Text texto24;
	private Text texto25;
	private Text texto26;
	private Text texto27;
	private TiledTextureRegion anotart;
	private AnimatedSprite anotar;
	private Text texto28;
	private int cont=0;
	private  Scene scene;
	private Sprite Libreta;
	private BitmapTextureAtlas mFontTexture2; 
	private ChangeableText textos[]=new ChangeableText[5];
	// ===========================================================
	// Constructors
	// ===========================================================
	private Font mFont2;
	private Text texto29;
	private AnimatedSprite cancelar;
	private BitmapTextureAtlas mFontTexture3;
	private Font mFont3;
	private AnimatedSprite delete;
	private TiledTextureRegion deletet;
	private AnimatedSprite go;
	private Sound sonido;
	private Text texto30;
	private Text texto31;
	private AnimatedSprite agregar;
	private Text texto32;
	private TiledTextureRegion agregart;
	private TiledTextureRegion got;
	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public Engine onLoadEngine() {

		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE,
				new FillResolutionPolicy(),
				this.mCamera).setNeedsSound(true));
	}

	@Override
	public void onLoadResources() {
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(128, 64,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mBackgroundTexture = new BitmapTextureAtlas(1024, 1024,
				TextureOptions.DEFAULT);
		this.mLibreta = new BitmapTextureAtlas(1024, 1024,
				TextureOptions.DEFAULT);
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.mBgTexture = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBackgroundTexture, this,
						"fondoB.png", 0, 0);
		this.tLibreta = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mLibreta, this,
						"Lanotaciones.png", 0, 0);
		this.qt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.wt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.et = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.rt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.tt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.yt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.ut = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.it = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.ot = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.pt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.at = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.st = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.dt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.ft = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.gt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.ht = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.jt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.kt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.lt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.zt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.xt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.ct = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.vt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.bt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.nt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.mt = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.borrart = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.anotart = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.cancel = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.deletet = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);	
		this.agregart = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);
		this.got = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				this.mBitmapTextureAtlas, this, "tecla.png", 0, 0, 2, 1);	
		this.mFontTexture = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		this.mFont = new Font(this.mFontTexture, Typeface.create(
				Typeface.DEFAULT, Typeface.BOLD), 32, true, Color.WHITE);
		this.mFontTexture2 = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		this.mFont2 = new Font(this.mFontTexture2, Typeface.create(
				Typeface.DEFAULT, Typeface.BOLD), 32, true, Color.WHITE);
		this.mFontTexture3 = new BitmapTextureAtlas(256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		this.mFont3 = new Font(this.mFontTexture3, Typeface.create(
				Typeface.DEFAULT, Typeface.BOLD), 32, true, Color.WHITE);
		SoundFactory.setAssetBasePath("mfx/");
		try {
			this.sonido = SoundFactory.createSoundFromAsset(
					this.mEngine.getSoundManager(), this, "tecla.ogg");
		} catch (final IOException e) {
			Debug.e(e);
		}   
		
		this.mEngine.getTextureManager().loadTextures(this.mFontTexture,this.mFontTexture2,this.mFontTexture3,this.mBackgroundTexture,
				this.mBitmapTextureAtlas,this.mLibreta);
		this.mEngine.getFontManager().loadFonts(this.mFont,this.mFont2,this.mFont3);

	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		scene = new Scene();
		SpriteBackground bg = new SpriteBackground(new Sprite(0, 0, mBgTexture));
		scene.setBackground(bg);
		text = new ChangeableText(250, 80, this.mFont, "", 8);
		scene.attachChild(text);
		Libreta = new Sprite (-150,-50,this.tLibreta);
		Libreta.setScale(0.75f);
		//scene.registerTouchArea(Libreta);
		scene.attachChild(Libreta);
		// q
		q = new AnimatedSprite(10, 200, this.qt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("Q");
					
					this.setCurrentTileIndex(1);
				} if (Event.getAction() == MotionEvent.ACTION_UP) {
					
					this.setCurrentTileIndex(0);
				}
				return true;
			}
		};
		texto1 = new Text(27, 212, this.mFont, "Q");
		scene.attachChild(q);
		scene.attachChild(texto1);
		// w
		w = new AnimatedSprite(80, 200, this.wt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					
					escribir("W");
					
					this.setCurrentTileIndex(1);
				} if (Event.getAction() == MotionEvent.ACTION_UP) {
					
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto2 = new Text(97, 212, this.mFont, "W");
		scene.attachChild(w);
		scene.attachChild(texto2);
		// e
		e = new AnimatedSprite(150, 200, this.et) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("E");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto3 = new Text(167, 212, this.mFont, "E");
		scene.attachChild(e);
		scene.attachChild(texto3);
		// r
		r = new AnimatedSprite(220, 200, this.rt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("R");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto4 = new Text(237, 212, this.mFont, "R");
		scene.attachChild(r);
		scene.attachChild(texto4);
		
		// t
		t = new AnimatedSprite(290, 200, this.tt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("T");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto5 = new Text(307, 212, this.mFont, "T");
		scene.attachChild(t);
		scene.attachChild(texto5);
		
		// y
		y = new AnimatedSprite(360, 200, this.yt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("Y");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto6 = new Text(377, 212, this.mFont, "Y");
		scene.attachChild(y);
		scene.attachChild(texto6);
		
		// u
		u = new AnimatedSprite(430, 200, this.ut) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("U");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto7 = new Text(447, 212, this.mFont, "U");
		scene.attachChild(u);
		scene.attachChild(texto7);
		
		// i
		i = new AnimatedSprite(500, 200, this.it) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("I");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto8 = new Text(517, 212, this.mFont, "I");
		scene.attachChild(i);
		scene.attachChild(texto8);
		
		// o
		o = new AnimatedSprite(570, 200, this.ot) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("O");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto9 = new Text(587, 212, this.mFont, "O");
		scene.attachChild(o);
		scene.attachChild(texto9);
		
		// p
		p = new AnimatedSprite(640, 200, this.pt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("P");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto10 = new Text(657, 212, this.mFont2, "P");
		scene.attachChild(p);
		scene.attachChild(texto10);
		
		// Final de la primera Fila de teclas

		// a
		a = new AnimatedSprite(40, 300, this.at) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("A");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto11 = new Text(57, 312, this.mFont2, "A");
		scene.attachChild(a);
		scene.attachChild(texto11);
		
		// s
		s = new AnimatedSprite(110, 300, this.st) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("S");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto12 = new Text(127, 312, this.mFont2, "S");
		scene.attachChild(s);
		scene.attachChild(texto12);
		
		// d
		d = new AnimatedSprite(180, 300, this.dt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("D");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto13 = new Text(197, 312, this.mFont2, "D");
		scene.attachChild(d);
		scene.attachChild(texto13);
		
		// f
		f = new AnimatedSprite(250, 300, this.ft) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("F");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto14 = new Text(267, 312, this.mFont2, "F");
		scene.attachChild(f);
		scene.attachChild(texto14);
		
		// g
		g = new AnimatedSprite(320, 300, this.gt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("G");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto15 = new Text(337, 312, this.mFont2, "G");
		scene.attachChild(g);
		scene.attachChild(texto15);
		
		// y
		h = new AnimatedSprite(390, 300, this.ht) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("H");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto16 = new Text(407, 312, this.mFont2, "H");
		scene.attachChild(h);
		scene.attachChild(texto16);
		
		// j
		j = new AnimatedSprite(460, 300, this.jt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("J");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto17 = new Text(477, 312, this.mFont2, "J");
		scene.attachChild(j);
		scene.attachChild(texto17);
		
		// k
		k = new AnimatedSprite(530, 300, this.kt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("K");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto18 = new Text(547, 312, this.mFont2, "K");
		scene.attachChild(k);
		scene.attachChild(texto18);
		
		// l
		l = new AnimatedSprite(600, 300, this.lt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("L");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto19 = new Text(617, 312, this.mFont2, "L");
		scene.attachChild(l);
		scene.attachChild(texto19);
		
		// fin de la segunda fila de teclas

		// z
		z = new AnimatedSprite(70, 400, this.zt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("Z");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto20 = new Text(87, 412, this.mFont3, "Z");
		scene.attachChild(z);
		scene.attachChild(texto20);
		
		// x
		x = new AnimatedSprite(140, 400, this.xt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("X");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto21 = new Text(157, 412, this.mFont3, "X");
		scene.attachChild(x);
		scene.attachChild(texto21);
		
		// c
		c = new AnimatedSprite(210, 400, this.ct) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("C");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto22 = new Text(227, 412, this.mFont3, "C");
		scene.attachChild(c);
		scene.attachChild(texto22);
		
		// v
		v = new AnimatedSprite(280, 400, this.vt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("V");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto23 = new Text(297, 412, this.mFont3, "V");
		scene.attachChild(v);
		scene.attachChild(texto23);
		
		// b
		b = new AnimatedSprite(350, 400, this.bt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("B");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto24 = new Text(367, 412, this.mFont3, "B");
		scene.attachChild(b);
		scene.attachChild(texto24);
		
		// n
		n = new AnimatedSprite(420, 400, this.nt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("N");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto25 = new Text(437, 412, this.mFont3, "N");
		scene.attachChild(n);
		scene.attachChild(texto25);
		
		// m
		m = new AnimatedSprite(490, 400, this.mt) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("M");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto26 = new Text(507, 412, this.mFont3, "M");
		scene.attachChild(m);
		scene.attachChild(texto26);
		
		// -<
		borrar = new AnimatedSprite(560, 400, this.borrart) {
			@Override
			public boolean onAreaTouched(final TouchEvent Event,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (Event.getAction() == MotionEvent.ACTION_DOWN) {
					escribir("<-");
					this.setCurrentTileIndex(1);
				} else {
					this.setCurrentTileIndex(0);
				}

				return true;
			}
		};
		texto27 = new Text(567, 412, this.mFont3, "del");
		scene.attachChild(borrar);
		scene.attachChild(texto27);
		// ok   
				anotar = new AnimatedSprite(40, 100, this.anotart) {
					@Override
					public boolean onAreaTouched(final TouchEvent Event,
							final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
						if (Event.getAction() == MotionEvent.ACTION_DOWN) {
							if(text.getText().length()!=0 && a.isVisible()){
								
								nombres[cont]=text.getText();
								cont++;
								
								SalirTeclado();
							}
							
							
							
							
							this.setCurrentTileIndex(1);
						} else {
							this.setCurrentTileIndex(0);
						}
						return true;
					}

					
				};
				texto28 = new Text(36, 115, this.mFont3, "OK");
				scene.attachChild(anotar);
				anotar.setScale(2.0f);
				scene.attachChild(texto28);
				texto28.setScale(2.0f);
				// cancel 
				cancelar = new AnimatedSprite(630, 400, this.cancel) {
					@Override
					public boolean onAreaTouched(final TouchEvent Event,
							final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
						if (Event.getAction() == MotionEvent.ACTION_DOWN) {
							
									
								SalirTeclado();
							
							
							
							
							
							this.setCurrentTileIndex(1);
						} else {
							this.setCurrentTileIndex(0);
						}
						return true;
					}

					
				};
				texto29 = new Text(610, 412, this.mFont3, "cancel");
				texto29.setScale(0.5f);
				scene.attachChild(cancelar);
				scene.attachChild(texto29);
		// eliminar jugador
				delete = new AnimatedSprite(340, 10, this.deletet) {
					@Override
					public boolean onAreaTouched(final TouchEvent Event,
							final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
						if (Event.getAction() == MotionEvent.ACTION_DOWN) {
							if(cont>0){
								cont--;
								textos[cont].setText("");	
							}		
							this.setCurrentTileIndex(1);
						} else {
							this.setCurrentTileIndex(0);
						}
						return true;
					}					
				};
				texto30 = new Text(360, 25, this.mFont3, "-");
				scene.attachChild(delete);
				scene.registerTouchArea(delete);
				scene.attachChild(texto30);
				texto30.setScale(3.0f);
				// ir
				go = new AnimatedSprite(400, 10, this.got) {
					@Override
					public boolean onAreaTouched(final TouchEvent Event,
							final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
						if (Event.getAction() == MotionEvent.ACTION_DOWN) {
							if(cont>1){
							Intent a = new Intent(TecladoEquipos.this,CachoEquipos.class);	
							a.putExtra("vector", nombres);
							a.putExtra("contador", cont);
							TecladoEquipos.this.startActivity(a);
							TecladoEquipos.this.finish();
							}else{   
								mostrarString("Añada por lo menos 2 equipos");
							}
							this.setCurrentTileIndex(1);
						} else {
							this.setCurrentTileIndex(0);
						}
						return true;
					}					
				};  
				texto31 = new Text(417, 22, this.mFont3, "ir");
			
				scene.attachChild(go);
				scene.registerTouchArea(go);
				scene.attachChild(texto31);	
				
				/// boton agregar
				agregar = new AnimatedSprite(280, 10, this.agregart) {
					@Override
					public boolean onAreaTouched(final TouchEvent Event,
							final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
						if (Event.getAction() == MotionEvent.ACTION_DOWN) {
							if(cont<=2){
							for(int i=0;i<4;i++){
								textos[i].setText("");
							}
							q.setVisible(true);
							w.setVisible(true);
							e.setVisible(true);
							r.setVisible(true);
							t.setVisible(true);
							y.setVisible(true);
							u.setVisible(true);
							i.setVisible(true);
							o.setVisible(true);
							p.setVisible(true);
							a.setVisible(true);
							s.setVisible(true);
							d.setVisible(true);
							f.setVisible(true);
							g.setVisible(true);
							h.setVisible(true);
							j.setVisible(true);
							k.setVisible(true);
							l.setVisible(true);
							z.setVisible(true);
							x.setVisible(true);
							c.setVisible(true);
							v.setVisible(true);
							b.setVisible(true);
							n.setVisible(true);
							m.setVisible(true);
							anotar.setVisible(true);
							borrar.setVisible(true);
							cancelar.setVisible(true);
							texto1.setVisible(true);
							texto2.setVisible(true);
							texto3.setVisible(true);
							texto4.setVisible(true);
							texto5.setVisible(true);
							texto6.setVisible(true);
							texto7.setVisible(true);
							texto8.setVisible(true);
							texto9.setVisible(true);
							texto10.setVisible(true);
							texto11.setVisible(true);
							texto12.setVisible(true);
							texto13.setVisible(true);
							texto14.setVisible(true);
							texto15.setVisible(true);
							texto16.setVisible(true);
							texto17.setVisible(true);
							texto18.setVisible(true);
							texto19.setVisible(true);
							texto20.setVisible(true);
							texto21.setVisible(true);
							texto22.setVisible(true);
							texto23.setVisible(true);
							texto24.setVisible(true);
							texto25.setVisible(true);
							texto26.setVisible(true);
							texto27.setVisible(true);
							texto28.setVisible(true);
							texto29.setVisible(true);
							scene.unregisterTouchArea(this);
							Libreta.setVisible(false);
							agregar.setVisible(false);
							scene.unregisterTouchArea(agregar);
							delete.setVisible(false);
							scene.unregisterTouchArea(delete);
							go.setVisible(false);
							scene.unregisterTouchArea(go);
							texto32.setVisible(false);
							texto30.setVisible(false);
							texto31.setVisible(false);						
						}
						}
						return true;
					}};
				texto32 = new Text(297, 32, this.mFont3, "+");
				texto32.setScale(2.0f);
				scene.attachChild(agregar);
				scene.registerTouchArea(agregar);
				scene.attachChild(texto32);	
		q.setVisible(false);
		w.setVisible(false);
		e.setVisible(false);
		r.setVisible(false);
		t.setVisible(false);
		y.setVisible(false);
		u.setVisible(false);
		i.setVisible(false);
		o.setVisible(false);
		p.setVisible(false);
		a.setVisible(false);
		s.setVisible(false);
		d.setVisible(false);
		f.setVisible(false);
		g.setVisible(false);
		h.setVisible(false);
		j.setVisible(false);
		k.setVisible(false);
		l.setVisible(false);
		z.setVisible(false);
		x.setVisible(false);
		c.setVisible(false);
		v.setVisible(false);
		b.setVisible(false);
		n.setVisible(false);
		m.setVisible(false);
		borrar.setVisible(false);
		anotar.setVisible(false);
		cancelar.setVisible(false);
		texto1.setVisible(false);
		texto2.setVisible(false);
		texto3.setVisible(false);
		texto4.setVisible(false);
		texto5.setVisible(false);
		texto6.setVisible(false);
		texto7.setVisible(false);
		texto8.setVisible(false);
		texto9.setVisible(false);
		texto10.setVisible(false);
		texto11.setVisible(false);
		texto12.setVisible(false);
		texto13.setVisible(false);
		texto14.setVisible(false);
		texto15.setVisible(false);
		texto16.setVisible(false);
		texto17.setVisible(false);
		texto18.setVisible(false);
		texto19.setVisible(false);
		texto20.setVisible(false);
		texto21.setVisible(false);
		texto22.setVisible(false);
		texto23.setVisible(false);
		texto24.setVisible(false);
		texto25.setVisible(false);
		texto26.setVisible(false);
		texto27.setVisible(false);
		texto28.setVisible(false);
		texto29.setVisible(false);
		// l
		/*
		 * l = new AnimatedSprite(600, 350, this.lt) {
		 * 
		 * @Override public boolean onAreaTouched(final TouchEvent Event, final
		 * float pTouchAreaLocalX, final float pTouchAreaLocalY) { if
		 * (Event.getAction() == MotionEvent.ACTION_DOWN) { escribir("L");
		 * this.setCurrentTileIndex(1); }else{ this.setCurrentTileIndex(0); }
		 * 
		 * return true; } }; texto= new Text(617,362,this.mFont,"L");
		 * scene.attachChild(l); scene.attachChild(texto);
		 * scene.registerTouchArea(l);
		 */
		scene.registerTouchArea(q);
		scene.registerTouchArea(w);
		scene.registerTouchArea(e);
		scene.registerTouchArea(r);
		scene.registerTouchArea(t);
		scene.registerTouchArea(y);
		scene.registerTouchArea(u);
		scene.registerTouchArea(i);
		scene.registerTouchArea(o);
		scene.registerTouchArea(p);
		scene.registerTouchArea(a);
		scene.registerTouchArea(s);
		scene.registerTouchArea(d);
		scene.registerTouchArea(f);
		scene.registerTouchArea(g);
		scene.registerTouchArea(h);
		scene.registerTouchArea(j);
		scene.registerTouchArea(k);
		scene.registerTouchArea(l);
		scene.registerTouchArea(z);
		scene.registerTouchArea(x);
		scene.registerTouchArea(c);
		scene.registerTouchArea(v);
		scene.registerTouchArea(b);
		scene.registerTouchArea(n);
		scene.registerTouchArea(m);
		scene.registerTouchArea(borrar);
		scene.registerTouchArea(anotar);
		scene.registerTouchArea(cancelar);
		scene.setTouchAreaBindingEnabled(true);
		int ye=180;
		for(int i=0;i<4;i++){
			textos[i] = new ChangeableText(90, ye, this.mFont,"",8);
			textos[i].setScale(1.3f);
			textos[i].setColor(0, 0, 0);
			ye+=60;
			scene.attachChild(textos[i]);
		}
		return scene;
	}

	@Override
	public void onLoadComplete() {

	}

	public void escribir(String x) {
		if(a.isVisible()){
			sonido.play();
		if(x.equalsIgnoreCase("<-")){
			
			aux=text.getText();
			if(aux.length()!=0){
			aux=aux.substring(0, aux.length()-1);
			text.setText(aux);
			}
		}else{
			
			aux = text.getText();
			if(aux.length()==8){
				mostrar("Limite de numero de caracteres");
			}else{
			text.setText(aux + x);
			}
		}
		}

	}
	public void mostrar(String x) {
		Toast.makeText(this, x, Toast.LENGTH_SHORT).show();
	}
	
	
	
	private void SalirTeclado() {
		
		text.setText("");
		for(int i=0;i<cont;i++){
			textos[i].setText(nombres[i]);	
		}
		q.setVisible(false);
		w.setVisible(false);
		e.setVisible(false);
		r.setVisible(false);
		t.setVisible(false);
		y.setVisible(false);
		u.setVisible(false);
		i.setVisible(false);
		o.setVisible(false);
		p.setVisible(false);
		a.setVisible(false);
		s.setVisible(false);
		d.setVisible(false);
		f.setVisible(false);
		g.setVisible(false);
		h.setVisible(false);
		j.setVisible(false);
		k.setVisible(false);
		l.setVisible(false);
		z.setVisible(false);
		x.setVisible(false);
		c.setVisible(false);
		v.setVisible(false);
		b.setVisible(false);
		n.setVisible(false);
		m.setVisible(false);
		anotar.setVisible(false);
		borrar.setVisible(false);
		cancelar.setVisible(false);
		texto1.setVisible(false);
		texto2.setVisible(false);
		texto3.setVisible(false);
		texto4.setVisible(false);
		texto5.setVisible(false);
		texto6.setVisible(false);
		texto7.setVisible(false);
		texto8.setVisible(false);
		texto9.setVisible(false);
		texto10.setVisible(false);
		texto11.setVisible(false);
		texto12.setVisible(false);
		texto13.setVisible(false);
		texto14.setVisible(false);
		texto15.setVisible(false);
		texto16.setVisible(false);
		texto17.setVisible(false);
		texto18.setVisible(false);
		texto19.setVisible(false);
		texto20.setVisible(false);
		texto21.setVisible(false);
		texto22.setVisible(false);
		texto23.setVisible(false);
		texto24.setVisible(false);
		texto25.setVisible(false);
		texto26.setVisible(false);
		texto27.setVisible(false);
		texto28.setVisible(false);
		texto29.setVisible(false);
		scene.registerTouchArea(agregar);
		Libreta.setVisible(true);
		agregar.setVisible(true);
		scene.registerTouchArea(agregar);
		delete.setVisible(true);
		scene.registerTouchArea(delete);
		go.setVisible(true);
		scene.registerTouchArea(go);
		texto32.setVisible(true);
		texto30.setVisible(true);
		texto31.setVisible(true);
	}
	public void mostrarString(String x) {
		Toast.makeText(this, x, Toast.LENGTH_SHORT).show();
	}
}