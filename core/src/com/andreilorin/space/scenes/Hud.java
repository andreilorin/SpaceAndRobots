package com.andreilorin.space.scenes;

import com.andreilorin.space.MyGame;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Lorin on 2016-10-13.
 * Hud class for on screen information about level, time, lives and score
 */
public class Hud {
    public Stage stage;
    private Viewport viewport;

    //fields for labels
    private Integer worldTimer;
    private float timeCount;
    private Integer score;
    private Integer lives;

    //labels to be displayed
    Label countDownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label levelNumberLabel;
    Label spaceLabel;
    Label livesLabel;
    Label liveNumberLabel;

    //Constructor
    public Hud(SpriteBatch sb){
        worldTimer = 300;
        timeCount = 0;
        score = 0;
        lives = 3;

        //Set viewport and stage
        viewport = new FitViewport(MyGame.V_WIDTH, MyGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        //Create table to add labels on
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        //Create labels
        countDownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%05d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("Level", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelNumberLabel = new Label("StarDocks", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        spaceLabel = new Label("Score", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        livesLabel = new Label("Lives", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        liveNumberLabel = new Label(String.format("%01d", lives), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //Add labels to table
        table.add(spaceLabel).expandX().padTop(10);
        table.add(levelLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.add(livesLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelNumberLabel).expandX();
        table.add(countDownLabel).expandX();
        table.add(liveNumberLabel).expandX();

        //Add table to stage
        stage.addActor(table);
    }
}
