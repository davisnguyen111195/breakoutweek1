package io.github.week1ktx2.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.maps.MapLayer
import com.badlogic.gdx.maps.MapLayers
import com.badlogic.gdx.maps.objects.RectangleMapObject
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.badlogic.gdx.utils.viewport.Viewport
import io.github.week1ktx2.Hud
import io.github.week1ktx2.Main
import io.github.week1ktx2.Main.Companion.PPMHeight
import io.github.week1ktx2.Main.Companion.PPMWidth
import io.github.week1ktx2.Main.Companion.WORLD_HEIGHT
import io.github.week1ktx2.Main.Companion.WORLD_WIDTH


class GameScreen(private val game: Main) : Screen {
    private lateinit var batch : SpriteBatch
    private lateinit var camera : OrthographicCamera
    private lateinit var viewport : Viewport
    private lateinit var hud: Hud
    private lateinit var mapLoader : TmxMapLoader
    private lateinit var tiledMap : TiledMap
    private lateinit var brickLayer : MapLayer

    override fun show() {
        game.assetManager.queueAddFonts()
        game.assetManager.manager.finishLoading()
        hud = Hud(game)
        batch = SpriteBatch()
        camera = OrthographicCamera()
        viewport = StretchViewport(PPMWidth, PPMHeight, camera)
        tiledMap = mapLoader.load("breakout.tmx")
        brickLayer = tiledMap.layers.get("brick") as MapLayer
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f,0f,0f,1f); //  clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        hud.update()
        hud.render()

    }

    fun brickCreate(){
        for(obj in brickLayer.objects){
            if(obj is RectangleMapObject){
                val rect = obj.rectangle
                val entity =
            }
        }
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
        batch.dispose()
        hud.dispose()
    }

    override fun dispose() {
        println("gamescreen dispose!")
    }
}

