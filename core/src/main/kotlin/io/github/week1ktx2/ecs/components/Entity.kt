package io.github.week1ktx2.ecs.components

import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle


fun createBrick(rect: Rectangle, brickTexure: TextureRegion) : Entity {
    return Entity().apply {
        add(PositionComponent(rect.x, rect.y))
        add(CollisionComponent(rect))
        add(BrickComponent(brickTexure))
    }
}


