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
public val ads_click: ImageVector
    get() {
        if (_ads_click != null) {
            return _ads_click!!
        }
        _ads_click =
            ImageVector.Builder(
                name = "ads_click",
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
                        moveTo(11.7f, 18f)
                        quadTo(9.3f, 17.88f, 7.65f, 16.15f)
                        quadTo(6f, 14.43f, 6f, 12f)
                        quadTo(6f, 9.5f, 7.75f, 7.75f)
                        reflectiveQuadTo(12f, 6f)
                        quadToRelative(2.43f, 0f, 4.15f, 1.65f)
                        reflectiveQuadTo(18f, 11.7f)
                        lineTo(15.9f, 11.08f)
                        quadTo(15.58f, 9.73f, 14.5f, 8.86f)
                        reflectiveQuadTo(12f, 8f)
                        quadTo(10.35f, 8f, 9.18f, 9.17f)
                        reflectiveQuadTo(8f, 12f)
                        quadToRelative(0f, 1.42f, 0.86f, 2.5f)
                        reflectiveQuadToRelative(2.21f, 1.4f)
                        lineTo(11.7f, 18f)
                        close()
                        moveToRelative(1.2f, 3.95f)
                        quadTo(12.68f, 22f, 12.45f, 22f)
                        reflectiveQuadTo(12f, 22f)
                        quadTo(9.93f, 22f, 8.1f, 21.21f)
                        quadTo(6.28f, 20.43f, 4.93f, 19.08f)
                        quadTo(3.58f, 17.73f, 2.79f, 15.9f)
                        reflectiveQuadTo(2f, 12f)
                        quadTo(2f, 9.92f, 2.79f, 8.1f)
                        quadTo(3.58f, 6.27f, 4.93f, 4.93f)
                        quadTo(6.28f, 3.57f, 8.1f, 2.79f)
                        quadTo(9.93f, 2f, 12f, 2f)
                        reflectiveQuadToRelative(3.9f, 0.79f)
                        reflectiveQuadToRelative(3.17f, 2.14f)
                        quadToRelative(1.35f, 1.35f, 2.14f, 3.17f)
                        quadTo(22f, 9.92f, 22f, 12f)
                        quadToRelative(0f, 0.22f, 0f, 0.45f)
                        reflectiveQuadTo(21.95f, 12.9f)
                        lineTo(20f, 12.3f)
                        verticalLineTo(12f)
                        quadTo(20f, 8.65f, 17.68f, 6.32f)
                        reflectiveQuadTo(12f, 4f)
                        reflectiveQuadTo(6.33f, 6.32f)
                        reflectiveQuadTo(4f, 12f)
                        reflectiveQuadToRelative(2.33f, 5.68f)
                        reflectiveQuadTo(12f, 20f)
                        quadToRelative(0.08f, 0f, 0.15f, 0f)
                        reflectiveQuadToRelative(0.15f, 0f)
                        lineToRelative(0.6f, 1.95f)
                        close()
                        moveToRelative(7.63f, 0.55f)
                        lineTo(16.25f, 18.23f)
                        lineTo(15f, 22f)
                        lineTo(12f, 12f)
                        lineToRelative(10f, 3f)
                        lineToRelative(-3.77f, 1.25f)
                        lineToRelative(4.27f, 4.27f)
                        lineTo(20.53f, 22.5f)
                        close()
                    }
                }
                .build()
        return _ads_click!!
    }

private var _ads_click: ImageVector? = null