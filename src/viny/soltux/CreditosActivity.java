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
import static org.anddev.andengine.extension.physics.box2d.util.constants.PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.AutoParallaxBackground;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.extension.physics.box2d.PhysicsConnector;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;
import org.anddev.andengine.extension.physics.box2d.util.Vector2Pool;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.sensor.accelerometer.AccelerometerData;
import org.anddev.andengine.sensor.accelerometer.IAccelerometerListener;
import org.anddev.andengine.util.Debug;

import android.hardware.SensorManager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;


public class CreditosActivity extends BaseExample implements IAccelerometerListener, IOnSceneTouchListener {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final int CAMERA_WIDTH = 480;
	private static final int CAMERA_HEIGHT = 720;
	private static final FixtureDef FIXTURE_DEF = PhysicsFactory.createFixtureDef(1, 0.5f, 0.5f);

	// ===========================================================
	// Fields
	// ===========================================================

	private BitmapTextureAtlas mBitmapTextureAtlas;

	
	private TextureRegion dado;
	private TextureRegion dado1;
	private TextureRegion dado2;

	private Scene mScene;

	private PhysicsWorld mPhysicsWorld;
	private int mFaceCount = 0;
	private BitmapTextureAtlas mAutoParallaxBackgroundTexture;

	private TextureRegion mParallaxLayerBack;
	

	@Override
	public Engine onLoadEngine() {
		
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT, new FillResolutionPolicy(), camera);
		engineOptions.getTouchOptions().setRunOnUpdateThread(true);
		return new Engine(engineOptions);
	}

	@Override
	public void onLoadResources() {
		
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.mAutoParallaxBackgroundTexture = new BitmapTextureAtlas(2048, 2048, TextureOptions.DEFAULT);
		
		this.mParallaxLayerBack = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mAutoParallaxBackgroundTexture, this, "creditos.png", 0, 0);
		
		
		this.dado = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "daditos.png", 0, 0); // 64x32
		this.dado1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "daditos2.png", 60, 0); // 64x32
		this.dado2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this, "daditos3.png", 128, 0); // 64x32
		this.mEngine.getTextureManager().loadTextures(this.mBitmapTextureAtlas,this.mAutoParallaxBackgroundTexture);
	}

	@Override
	public Scene onLoadScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		this.mScene = new Scene();
		final AutoParallaxBackground autoParallaxBackground = new AutoParallaxBackground(0, 0, 0, 5);
		autoParallaxBackground.attachParallaxEntity(new ParallaxEntity(10.0f, new Sprite(0, CAMERA_HEIGHT - this.mParallaxLayerBack.getHeight(), this.mParallaxLayerBack)));
		
		mScene.setBackground(autoParallaxBackground);
		this.mScene.setOnSceneTouchListener(this);

		this.mPhysicsWorld = new PhysicsWorld(new Vector2(0, SensorManager.GRAVITY_EARTH), false);

		/*final Shape ground = new Rectangle(0, CAMERA_HEIGHT - 2, CAMERA_WIDTH, 2);
		final Shape roof = new Rectangle(0, 0, CAMERA_WIDTH, 2);*/
		 

		final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(0, 0.5f, 0.5f);
		/*PhysicsFactory.createBoxBody(this.mPhysicsWorld, ground, BodyType.StaticBody, wallFixtureDef);
		PhysicsFactory.createBoxBody(this.mPhysicsWorld, roof, BodyType.StaticBody, wallFixtureDef);*/
		

	/*	this.mScene.attachChild(ground);
		this.mScene.attachChild(roof);
		
		ground.setVisible(false);
		roof.setVisible(false);*/
		this.mScene.registerUpdateHandler(this.mPhysicsWorld);
  
		return this.mScene;
	}

	@Override
	public void onLoadComplete() {

	}

	@Override
	public boolean onSceneTouchEvent(final Scene pScene, final TouchEvent pSceneTouchEvent) {
		if(this.mPhysicsWorld != null) {
			if(pSceneTouchEvent.isActionDown()) {
				this.addFace(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
				return true;
			}
		}
		return false;
	}

	@Override
	public void onAccelerometerChanged(final AccelerometerData pAccelerometerData) {
		final Vector2 gravity = Vector2Pool.obtain(pAccelerometerData.getX(), pAccelerometerData.getY());
		this.mPhysicsWorld.setGravity(gravity);
		Vector2Pool.recycle(gravity);
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

	
   
	private void addFace(final float pX, final float pY) {
		this.mFaceCount++;
		Debug.d("Faces: " + this.mFaceCount);

		final Sprite face;
		final Body body;
		if(this.mFaceCount<= 50) {
		if(this.mFaceCount % 3 == 0) {
			face = new Sprite(pX, pY, this.dado);
			body = CreditosActivity.createHexagonBody(this.mPhysicsWorld, face, BodyType.DynamicBody, FIXTURE_DEF);
		} else if (this.mFaceCount % 3 == 1) {
			face = new Sprite(pX, pY, this.dado1);
			body = CreditosActivity.createHexagonBody(this.mPhysicsWorld, face, BodyType.DynamicBody, FIXTURE_DEF);
		}  else {
			face = new Sprite(pX, pY, this.dado2);
			body = CreditosActivity.createHexagonBody(this.mPhysicsWorld, face, BodyType.DynamicBody, FIXTURE_DEF);
		}
		

		

		this.mScene.attachChild(face);
		this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(face, body, true, true));
	}
}
	/**
	 * <pre>
	 *  /\
	 * /  \
	 * |  |
	 * |  |
	 * \  /
	 *  \/
	 * </pre>
	 */
	private static Body createHexagonBody(final PhysicsWorld pPhysicsWorld, final Shape pShape, final BodyType pBodyType, final FixtureDef pFixtureDef) {

		final float halfWidth = pShape.getWidthScaled() * 0.5f / PIXEL_TO_METER_RATIO_DEFAULT;
		final float halfHeight = pShape.getHeightScaled() * 0.5f / PIXEL_TO_METER_RATIO_DEFAULT;

		final float top = -halfHeight;
		final float bottom = halfHeight;

		final float centerX = 0;

		final float left = -halfWidth + 2.5f / PIXEL_TO_METER_RATIO_DEFAULT;
		final float right = halfWidth - 2.5f / PIXEL_TO_METER_RATIO_DEFAULT;
		final float higher = top + 8.25f / PIXEL_TO_METER_RATIO_DEFAULT;
		final float lower = bottom - 8.25f / PIXEL_TO_METER_RATIO_DEFAULT;
		final Vector2[] vertices = {
				new Vector2(centerX, top),
				new Vector2(right, higher),
				new Vector2(right, lower),
				new Vector2(centerX, bottom),
				new Vector2(left, lower),
				new Vector2(left, higher)
		};
		return PhysicsFactory.createPolygonBody(pPhysicsWorld, pShape, vertices, pBodyType, pFixtureDef);
	}
	@Override
	public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent) {
		if (pKeyCode == KeyEvent.KEYCODE_BACK) {
			CreditosActivity.this.finish();
			
		}
		if (pKeyCode == KeyEvent.KEYCODE_MENU){
				
		}

	
		return true;
	}
}