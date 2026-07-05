import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val simulation: ImageVector
    get() {
        if (_simulation != null) {
            return _simulation!!
        }
        _simulation =
            ImageVector.Builder(
                name = "simulation",
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
                        moveTo(8f, 17f)
                        verticalLineTo(16.43f)
                        quadToRelative(0f, -1.1f, 1.1f, -1.76f)
                        reflectiveQuadTo(12f, 14f)
                        reflectiveQuadToRelative(2.9f, 0.66f)
                        reflectiveQuadTo(16f, 16.43f)
                        verticalLineTo(17f)
                        horizontalLineTo(8f)
                        close()
                        moveToRelative(2.59f, -4.59f)
                        quadTo(10f, 11.83f, 10f, 11f)
                        quadToRelative(0f, -0.83f, 0.59f, -1.41f)
                        reflectiveQuadTo(12f, 9f)
                        reflectiveQuadToRelative(1.41f, 0.59f)
                        reflectiveQuadTo(14f, 11f)
                        reflectiveQuadToRelative(-0.59f, 1.41f)
                        reflectiveQuadTo(12f, 13f)
                        reflectiveQuadTo(10.59f, 12.41f)
                        close()
                        moveTo(3f, 9.2f)
                        verticalLineToRelative(7.65f)
                        quadToRelative(0.35f, 0.32f, 0.85f, 0.56f)
                        reflectiveQuadTo(5f, 17.77f)
                        verticalLineTo(9.85f)
                        quadTo(4.45f, 9.73f, 3.94f, 9.56f)
                        reflectiveQuadTo(3f, 9.2f)
                        close()
                        moveTo(21f, 9.17f)
                        quadToRelative(-0.42f, 0.2f, -0.92f, 0.36f)
                        reflectiveQuadTo(19f, 9.82f)
                        verticalLineToRelative(7.95f)
                        quadToRelative(0.65f, -0.13f, 1.15f, -0.36f)
                        reflectiveQuadTo(21f, 16.85f)
                        verticalLineTo(9.17f)
                        close()
                        moveTo(7f, 20.15f)
                        quadTo(4.13f, 19.8f, 2.56f, 18.98f)
                        reflectiveQuadTo(1f, 17f)
                        verticalLineTo(7f)
                        quadTo(1f, 5.57f, 3.84f, 4.8f)
                        reflectiveQuadTo(12f, 4.02f)
                        reflectiveQuadTo(20.16f, 4.8f)
                        reflectiveQuadTo(23f, 7f)
                        verticalLineTo(17f)
                        quadToRelative(0f, 1.15f, -1.56f, 1.98f)
                        reflectiveQuadTo(17f, 20.15f)
                        verticalLineToRelative(-12f)
                        quadToRelative(1.28f, -0.2f, 2.26f, -0.49f)
                        quadTo(20.25f, 7.38f, 20.68f, 7.1f)
                        quadTo(19.6f, 6.68f, 17f, 6.34f)
                        reflectiveQuadTo(12f, 6f)
                        reflectiveQuadTo(7f, 6.34f)
                        quadTo(4.4f, 6.68f, 3.33f, 7.1f)
                        quadTo(3.75f, 7.4f, 4.74f, 7.68f)
                        reflectiveQuadTo(7f, 8.15f)
                        verticalLineToRelative(12f)
                        close()
                        moveTo(3f, 9.2f)
                        verticalLineToRelative(8.57f)
                        quadTo(3f, 17.65f, 3f, 17.41f)
                        reflectiveQuadTo(3f, 16.85f)
                        verticalLineTo(9.2f)
                        close()
                        moveTo(21f, 9.17f)
                        verticalLineToRelative(7.68f)
                        quadToRelative(0f, 0.32f, 0f, 0.56f)
                        reflectiveQuadToRelative(0f, 0.36f)
                        verticalLineTo(9.17f)
                        close()
                    }
                }
                .build()
        return _simulation!!
    }

private var _simulation: ImageVector? = null