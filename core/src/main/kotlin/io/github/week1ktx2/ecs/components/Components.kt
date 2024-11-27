package io.github.week1ktx2.ecs.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle

data class PositionComponent(var x: Float = 0f, var y: Float = 0f) : Component
data class VelocityComponent(var xSpeed: Float = 0f, var ySpeed: Float = 0f) : Component
data class PaddleComponent(var paddleTexture: TextureRegion, ): Component
data class BallComponent(var ballTexture: TextureRegion) : Component
data class CollisionComponent(var bounds: Rectangle) : Component
data class BrickComponent(var brickTexture: TextureRegion): Component
