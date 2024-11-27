package io.github.week1ktx2

import com.badlogic.gdx.Game
import io.github.week1ktx2.loader.BreakoutAssetManager
import io.github.week1ktx2.screens.ScreenManager
import io.github.week1ktx2.screens.ScreenManager.Companion.INTRO_SCREEN

class Main : Game() {
    lateinit var screenManager: ScreenManager
    lateinit var assetManager: BreakoutAssetManager
    override fun create() {
        screenManager = ScreenManager(this)
        assetManager = BreakoutAssetManager.getInstance()
        screenManager.changeScreen(INTRO_SCREEN)

    }

    companion object {
        const val PPM = 100f
        const val WORLD_WIDTH = 1280f
        const val WORLD_HEIGHT = 720f
        const val PPMWidth = WORLD_WIDTH / PPM
        const val PPMHeight = WORLD_HEIGHT / PPM

    }
}
