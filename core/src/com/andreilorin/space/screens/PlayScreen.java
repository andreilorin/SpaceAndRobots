package com.andreilorin.space.screens;

import com.andreilorin.space.MyGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Lorin on 2016-10-13.
 */
public class PlayScreen implements Screen {

    private MyGame game;
    Texture texture;
    private OrthographicCamera gameCamera;
    private Viewport gamePort;


    public PlayScreen(MyGame game){
        this.game = game;
        texture = new Texture("BG.jpg");
        gameCamera = new OrthographicCamera();
        gamePort = new FitViewport(MyGame.V_WIDTH, MyGame.V_HEIGHT, gameCamera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(gameCamera.combined);

        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();

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
