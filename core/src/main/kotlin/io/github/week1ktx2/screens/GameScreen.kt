package io.github.week1ktx2.screens

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.maps.MapLayer
import com.badlogic.gdx.maps.objects.RectangleMapObject
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.badlogic.gdx.utils.viewport.Viewport
import io.github.week1ktx2.Hud
import io.github.week1ktx2.Main
import io.github.week1ktx2.Main.Companion.PPMHeight
import io.github.week1ktx2.Main.Companion.PPMWidth
import io.github.week1ktx2.ecs.components.createBrick
import io.github.week1ktx2.ecs.systems.RenderSystem


class GameScreen(private val game: Main) : Screen {
    private lateinit var batch : SpriteBatch
    private lateinit var camera : OrthographicCamera
    private lateinit var viewport : Viewport
    private lateinit var engine : Engine
    private lateinit var hud: Hud
    private lateinit var mapLoader : TmxMapLoader
    private lateinit var tiledMap : TiledMap
    private lateinit var brickLayer : MapLayer
    private lateinit var textures : TextureAtlas

    override fun show() {
        game.assetManager.queueAddFonts()
        game.assetManager.queueAddImage()
        game.assetManager.manager.finishLoading()
        mapLoader = TmxMapLoader()
        hud = Hud(game)
        batch = SpriteBatch().apply {
            projectionMatrix.setToOrtho2D(0f, 0f, PPMWidth, PPMHeight)
        }
        camera = OrthographicCamera()
        viewport = StretchViewport(PPMWidth, PPMHeight, camera)
        tiledMap = mapLoader.load("test.tmx")

        brickLayer = tiledMap.layers.get("brick")
        println(brickLayer.objects)
        textures = game.assetManager.manager.get(game.assetManager.gameImages)
        engine = Engine()
        brickCreate()
        engine.addSystem(RenderSystem(batch, camera))
    }

    override fun render(delta: Float) {
        //Gdx.gl.glClearColor(0f,0f,0f,1f); //  clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        engine.update(delta)
        hud.update()
        hud.render()



    }

    private fun brickCreate(){
        val textureBrick = TextureRegion(textures.findRegion("Sprite-0001"))
        println(textureBrick)
        for(obj in brickLayer.objects){
            if(obj is RectangleMapObject){
                val rect = obj.rectangle
                engine.addEntity(createBrick(rect, textureBrick))
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

