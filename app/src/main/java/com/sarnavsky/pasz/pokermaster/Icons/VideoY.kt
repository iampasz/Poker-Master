package com.example.test

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val slow_motion_video: ImageVector
    get() {
        if (_slow_motion_video != null) {
            return _slow_motion_video!!
        }
        _slow_motion_video =
            ImageVector.Builder(
                name = "slow_motion_video",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.Companion.NonZero,
                    ) {
                        moveTo(4.25f, 18.3f)
                        quadTo(3.3f, 17.2f, 2.73f, 15.85f)
                        reflectiveQuadTo(2f, 13f)
                        horizontalLineTo(4.05f)
                        quadTo(4.2f, 14.1f, 4.6f, 15.09f)
                        reflectiveQuadTo(5.65f, 16.9f)
                        lineToRelative(-1.4f, 1.4f)
                        close()
                        moveTo(2f, 11f)
                        quadTo(2.2f, 9.5f, 2.75f, 8.15f)
                        reflectiveQuadTo(4.25f, 5.7f)
                        lineToRelative(1.4f, 1.4f)
                        quadTo(5f, 7.93f, 4.6f, 8.91f)
                        reflectiveQuadTo(4.05f, 11f)
                        horizontalLineTo(2f)
                        close()
                        moveToRelative(8.95f, 10.95f)
                        quadTo(9.45f, 21.8f, 8.11f, 21.23f)
                        reflectiveQuadTo(5.65f, 19.75f)
                        lineTo(7.05f, 18.3f)
                        quadToRelative(0.88f, 0.65f, 1.84f, 1.07f)
                        reflectiveQuadToRelative(2.06f, 0.57f)
                        verticalLineToRelative(2f)
                        close()
                        moveTo(7.1f, 5.7f)
                        lineTo(5.65f, 4.25f)
                        quadTo(6.78f, 3.35f, 8.11f, 2.77f)
                        reflectiveQuadTo(11f, 2.05f)
                        verticalLineToRelative(2f)
                        quadTo(9.88f, 4.2f, 8.9f, 4.63f)
                        reflectiveQuadTo(7.1f, 5.7f)
                        close()
                        moveTo(9.5f, 16.5f)
                        verticalLineToRelative(-9f)
                        lineToRelative(7f, 4.5f)
                        lineToRelative(-7f, 4.5f)
                        close()
                        moveTo(13f, 21.95f)
                        verticalLineToRelative(-2f)
                        quadToRelative(3.03f, -0.43f, 5.01f, -2.68f)
                        quadTo(20f, 15.03f, 20f, 12f)
                        reflectiveQuadTo(18.01f, 6.72f)
                        quadTo(16.03f, 4.47f, 13f, 4.05f)
                        verticalLineToRelative(-2f)
                        quadToRelative(3.85f, 0.43f, 6.43f, 3.25f)
                        reflectiveQuadTo(22f, 12f)
                        reflectiveQuadToRelative(-2.57f, 6.7f)
                        reflectiveQuadTo(13f, 21.95f)
                        close()
                    }
                }
                .build()
        return _slow_motion_video!!
    }

private var _slow_motion_video: ImageVector? = null