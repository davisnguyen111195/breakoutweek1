package io.github.week1ktx2.loader

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader

class BreakoutAssetManager {
    val fontSmall: String = "size18.otf"
    private val gameFont: String = "assets/GAMER.otf"
    val fontLarge: String = "size72.otf"
    val fontMedium: String = "size36.otf"
    val gameImages = "assets/breakout.atlas"
    val manager: AssetManager = AssetManager()

    fun queueAddImage() {
        manager.load(gameImages, TextureAtlas::class.java)
    }
    fun queueAddFonts() {
        manager.setLoader(
            FreeTypeFontGenerator::class.java,
            FreeTypeFontGeneratorLoader(InternalFileHandleResolver())
        )
        manager.setLoader(
            BitmapFont::class.java,
            ".otf",
            FreetypeFontLoader(InternalFileHandleResolver())
        )

        val fontParameterSmall = FreetypeFontLoader.FreeTypeFontLoaderParameter().apply {
            fontFileName = gameFont
            fontParameters.size = 18
        }

        val fontParameterLarge = FreetypeFontLoader.FreeTypeFontLoaderParameter().apply {
            fontFileName = gameFont
            fontParameters.size = 72
        }
        val fontParameterMedium = FreetypeFontLoader.FreeTypeFontLoaderParameter().apply {
            fontFileName = gameFont
            fontParameters.size = 36
        }

        manager.load(fontSmall, BitmapFont::class.java, fontParameterSmall)
        manager.load(fontLarge, BitmapFont::class.java, fontParameterLarge)
        manager.load(fontMedium, BitmapFont::class.java, fontParameterMedium)
    }

    fun dispose() {
        manager.dispose()
        instance = null
    }

    companion object {
        private var instance: BreakoutAssetManager? = null
        fun getInstance(): BreakoutAssetManager {
            synchronized(BreakoutAssetManager::class.java) {
                instance = instance ?: BreakoutAssetManager()
                return instance!!
            }
        }
    }
}
