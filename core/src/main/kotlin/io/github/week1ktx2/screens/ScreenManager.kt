package io.github.week1ktx2.screens

import io.github.week1ktx2.Main


class ScreenManager(private val game: Main) {

    private var introScreen: IntroScreen? = null
    private var gameScreen : GameScreen? = null
    private var endScreen: EndScreen? = null


    fun changeScreen(screen : Int) {
        when(screen){
            INTRO_SCREEN -> {
                introScreen = introScreen ?: IntroScreen(game)
                game.screen = introScreen
            }
            GAME_SCREEN -> {
                gameScreen = gameScreen ?: GameScreen(game)
                game.screen = gameScreen
            }
            END_SCREEN -> {
                endScreen = endScreen ?: EndScreen(game)
                game.screen = endScreen
            }
            else -> {
                println("Don't have any loading screen")
            }
        }
    }

    companion object {
        const val INTRO_SCREEN = 0
        const val GAME_SCREEN = 1
        const val END_SCREEN = 2
    }
}

