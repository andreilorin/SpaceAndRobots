package com.andreilorin.space.screens;

import com.andreilorin.space.MyGame;
import com.andreilorin.space.scenes.Hud;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Lorin on 2016-10-13.
 */
public class PlayScreen implements Screen {

    //Game field
    private MyGame game;

    //Camera fields
    private OrthographicCamera gameCamera;
    private Viewport gamePort;
    private Hud hud;

    //Map fields
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;



    public PlayScreen(MyGame game){
        this.game = game;

        //Create camera
        gameCamera = new OrthographicCamera();
        //Create FitViewport
        gamePort = new FitViewport(MyGame.V_WIDTH, MyGame.V_HEIGHT, gameCamera);
        //Create HUD
        hud = new Hud(game.batch);
        //Create map loader
        mapLoader = new TmxMapLoader();
        //Load map
        map = mapLoader.load("C:\\Users\\Lorin\\Desktop\\images\\spaceandrobots.tmx");//TODO cant load map, 32x32 tiles problem ?
        //Render map
        renderer = new OrthogonalTiledMapRenderer(map);
        //Fit camera around viewport based on gameworld
        gameCamera.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

    }

    @Override
    public void show() {

    }

    //Handle input method
    public void handleInput(float dt){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            gameCamera.position.x += 100 * dt;

    }

    //Gameworld update
    public void update(float dt){
        handleInput(dt);
        gameCamera.update();
        renderer.setView(gameCamera);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
