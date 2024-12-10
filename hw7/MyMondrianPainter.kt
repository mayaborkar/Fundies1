import java.awt.Color

class MyMondrianPainter : MondrianPainter() {
    /**
     * overrides the recolorRectangle function to be able to changed to many more colors
     */
    override fun recolorRectangle(x: Int, y: Int) {
        val originalColor = canvas.getColorAt(x, y)

        var leftX = x
        var topY = y

        while (leftX > 0 && canvas.getColorAt(leftX - 1, y) == originalColor) {
            leftX--
        }

        var rightX = x
        while (rightX < REQUESTED_CANVAS_WIDTH - 1 && canvas.getColorAt(rightX + 1, y) == originalColor) {
            rightX++
        }

        while (topY > 0 && canvas.getColorAt(x, topY - 1) == originalColor) {
            topY--
        }

        var bottomY = y
        while (bottomY < REQUESTED_CANVAS_HEIGHT - 1 && canvas.getColorAt(x, bottomY + 1) == originalColor) {
            bottomY++
        }

        if (rightX > leftX && bottomY > topY) {
            val newColor =
                Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))
            canvas.drawRectangle(
                leftX,
                topY,
                rightX - leftX + 1,
                bottomY - topY + 1,
                fillColor = newColor,
                outlineColor = Color.BLACK
            )
        }
    }
}

/**
 * Creates a canvas and paints it in the style of Piet Mondrian.
 */
fun main() {
    require(REQUESTED_CANVAS_HEIGHT >= 4 * MIN_RECTANGLE_HEIGHT)
    require(REQUESTED_CANVAS_WIDTH >= 4 * MIN_RECTANGLE_WIDTH)
    MyMondrianPainter()
}
