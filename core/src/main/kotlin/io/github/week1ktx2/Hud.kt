package io.github.week1ktx2

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.badlogic.gdx.utils.viewport.Viewport
import io.github.week1ktx2.Main.Companion.PPMHeight
import io.github.week1ktx2.Main.Companion.PPMWidth
import io.github.week1ktx2.Main.Companion.WORLD_HEIGHT
import io.github.week1ktx2.Main.Companion.WORLD_WIDTH
import java.util.Locale


class Hud(
    game: Main
) : Disposable {
    private var stage: Stage
    private var table: Table
    private var viewport: Viewport
    private var camera: OrthographicCamera
    private lateinit var skin: Skin

    //    private var textField: TextField
    private lateinit var levelLabel: Label
    private lateinit var scoreLabel: Label
    private lateinit var liveLabel: Label
    private var score = 0
    private var level = 1
    private var lives = 3

    init {
        camera = OrthographicCamera()
        viewport = FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)
        stage = Stage(viewport)
        table = Table()

        table.setFillParent(true)
        table.setDebug(true)
        table.top()
        levelLabel = Label(
            "Level",
            Label.LabelStyle(
                game.assetManager.manager.get(
                    game.assetManager.fontMedium,
                    BitmapFont::class.java
                ), Color.WHITE
            )
        )
        scoreLabel = Label(
            "Lives: ",
            Label.LabelStyle(
                game.assetManager.manager.get(
                    game.assetManager.fontMedium,
                    BitmapFont::class.java
                ),
                Color.WHITE
            )
        )

        liveLabel = Label(
            "Score: ",
            Label.LabelStyle(
                game.assetManager.manager.get(
                    game.assetManager.fontMedium,
                    BitmapFont::class.java
                ),
                Color.WHITE
            )
        )

        //table widget
        table.add(levelLabel).left().top().padLeft(5f).expandX()
        table.add(scoreLabel).right().top().padRight(5f).expandX()

        table.row()

        table.add(liveLabel).left().padLeft(5f)

        stage.addActor(table)

        Gdx.input.inputProcessor = stage
    }

    fun update() {
        levelLabel.setText("Level" + level)
        scoreLabel.setText(String.format(Locale.getDefault(), "Score: %06d", score))
    }
    fun updateLives(){

    }
    fun render() {
        stage.act()
        stage.draw()
    }

    override fun dispose() {
        stage.dispose()
    }
}
