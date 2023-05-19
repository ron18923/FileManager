package com.example.filemanager.compose.homeScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.filemanager.ui.theme.PieChartColor1
import com.example.filemanager.ui.theme.PieChartColor2
import kotlin.math.min

@Composable
internal fun twoValuesPieChart(
    modifier: Modifier = Modifier,
    used: Float,
    free: Float
) {
    /*
     Limited for 2 items only because of the color list. If needed to add more values, only need to add more colors to the list.
    */

    val values = listOf(used, free)

    val colors = listOf(
        PieChartColor1,
        PieChartColor2
    )

    val chartDegrees = 360f // circle shape

    // start drawing clockwise (top to right)
    var startAngle = 270f

    // calculate each input percentage
    val proportions = values.map {
        it * 100 / values.sum()
    }

    // calculate each input slice degrees
    val angleProgress = proportions.map { prop ->
        chartDegrees * prop / 100
    }

    // calculate each slice end point in degrees, for handling click position
    val progressSize = mutableListOf<Float>()

    LaunchedEffect(angleProgress) {
        progressSize.add(angleProgress.first())
        for (x in 1 until angleProgress.size) {
            progressSize.add(angleProgress[x] + progressSize[x - 1])
        }
    }

    BoxWithConstraints(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {

        val canvasSize = min(constraints.maxWidth, constraints.maxHeight)
        val size = Size(canvasSize.toFloat(), canvasSize.toFloat())
        val canvasSizeDp = with(LocalDensity.current) { canvasSize.toDp() }

        Canvas(
            modifier = Modifier
                .shadow(elevation = 5.dp, shape = CircleShape)
                .size(canvasSizeDp)) {

            angleProgress.forEachIndexed { index, angle ->
                drawArc(
                    color = colors[index],
                    startAngle = startAngle,
                    sweepAngle = angle,
                    useCenter = true,
                    size = size,
                    style = Fill
                )
                startAngle += angle
            }

        }

    }
}