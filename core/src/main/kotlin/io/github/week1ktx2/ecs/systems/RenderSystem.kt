package io.github.week1ktx2.ecs.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.week1ktx2.Utils
import io.github.week1ktx2.ecs.components.BrickComponent
import io.github.week1ktx2.ecs.components.PositionComponent

class RenderSystem(val batch: SpriteBatch, val camera: OrthographicCamera) : IteratingSystem(
    Family.all(BrickComponent::class.java, PositionComponent::class.java).get()
) {

    private val brickMapper = ComponentMapper.getFor(
        BrickComponent::class.java
    )

    private val positionMapper = ComponentMapper.getFor(
        PositionComponent::class.java
    )
    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val brick = brickMapper[entity]
        val position = positionMapper[entity]

        batch.begin()
        batch.draw(brick.brickTexture, Utils.convertToPPM(position.x), Utils.convertToPPM(position.y), 0.33f, 0.33f)
        batch.end()
    }
}
