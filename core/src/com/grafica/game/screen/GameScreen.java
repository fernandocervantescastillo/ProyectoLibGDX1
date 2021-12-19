package com.grafica.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grafica.game.MyGame;

public class GameScreen  implements Screen {

    MyGame game;
    SpriteBatch batch;
    Texture img;
    int x, y;

    public GameScreen(MyGame game) {
        this.game = game;

        batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal("badlogic.jpg"));

        x=0;
        y=0;

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);


        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if(x+10<=Gdx.graphics.getWidth()-img.getWidth())
                x=x+10;
            else
                x=Gdx.graphics.getWidth()-img.getWidth();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if(x-10>=0)
                x=x-10;
            else
                x=0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if(y+10<=Gdx.graphics.getHeight()-img.getHeight())
                y=y+10;
            else
                y=Gdx.graphics.getHeight()-img.getHeight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if(y-10>=0)
                y=y-10;
            else
                y=0;
        }

        batch.setTransformMatrix(game.getViewport().getCamera().view);
        batch.setProjectionMatrix(game.getCamera().projection);
        batch.begin();
        batch.draw(img, x, y);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        img.dispose();
    }

}