package io.github.week1ktx2.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.badlogic.gdx.utils.viewport.Viewport
import io.github.week1ktx2.Main
import io.github.week1ktx2.Main.Companion.PPMHeight
import io.github.week1ktx2.Main.Companion.PPMWidth
import io.github.week1ktx2.Main.Companion.WORLD_HEIGHT
import io.github.week1ktx2.Main.Companion.WORLD_WIDTH
import io.github.week1ktx2.screens.ScreenManager.Companion.GAME_SCREEN

class IntroScreen(private val game: Main) : Screen {
    private lateinit var batch: SpriteBatch
    private lateinit var viewport: Viewport
    private lateinit var camera : OrthographicCamera
    private lateinit var imageIntro : TextureRegion
    override fun show() {
        batch = SpriteBatch()
        camera = OrthographicCamera()
        viewport = StretchViewport(PPMWidth, PPMHeight, camera)
        imageIntro = TextureRegion(Texture("intro169.png"))
        batch.projectionMatrix.setToOrtho2D(
            0f,
            0f,
            PPMWidth,
            PPMHeight
        )

    }

    override fun render(delta: Float) {

        batch.begin()

        batch.draw(imageIntro, 0f, 0f, PPMWidth, PPMHeight)

        batch.end()

        if(Gdx.input.isTouched){
            game.screenManager.changeScreen(GAME_SCREEN)
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
        imageIntro.texture.dispose()
        println("intro_hide")
    }

    override fun dispose() {
        println("intro_dispose")
    }


}
