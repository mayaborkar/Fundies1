import java.awt.Color
import kotlin.random.Random

/**
 * The desired canvas width, which must be at least 4 times [MIN_RECTANGLE_WIDTH].
 */
const val REQUESTED_CANVAS_WIDTH = 400

/**
 * The desired canvas height, which must be at least 4 times [MIN_RECTANGLE_HEIGHT].
 */
const val REQUESTED_CANVAS_HEIGHT = 400

/**
 * The minimum width of a colored rectangle.
 */
const val MIN_RECTANGLE_WIDTH = 80

/**
 * The minimum height of a colored rectangle.
 */
const val MIN_RECTANGLE_HEIGHT = 80

// seed for random number generator
val SEED = 2500

open class MondrianPainter {
    // Use this property when generating random numbers.
    val random = Random(SEED)

    val canvas =
        Canvas(
            "Mondrian Painter",
            this,
            REQUESTED_CANVAS_WIDTH,
            REQUESTED_CANVAS_HEIGHT,
        )

    /**
     * Performs a side-by-side split of the region specified by [x], [y],
     * [width], and [height], if it is wide enough to split, and calls
     * [doMondrian] on each of the two smaller regions. If the original
     * region is too narrow to split, no action is taken.
     *
     * @return true if the original region was wide enough to split, false
     * otherwise
     */
    private fun splitLeftRight(x: Int, y: Int, width: Int, height: Int): Boolean {
        // TODO("Implement")
        if (width > 2 * MIN_RECTANGLE_WIDTH) {
            val splitPoint = x + Random(SEED).nextInt(MIN_RECTANGLE_WIDTH, width - MIN_RECTANGLE_WIDTH)

            doMondrian(x, y, splitPoint - x, height)
            doMondrian(splitPoint, y, (x + width) - splitPoint, height)

            return true
        }
        return false
    }

    /**
     * Performs an over-under split of the region specified by [x], [y],
     * [width], and [height], if it is tall enough to split, and calls
     * [doMondrian] on each of the two smaller regions. If the original
     * region is too short to split, no action is taken.
     *
     * @return true if the original region was tall enough to split, false
     * otherwise
     */
    private fun splitTopBottom(x: Int, y: Int, width: Int, height: Int): Boolean {
        // TODO("Implement")
        if (height > 2 * MIN_RECTANGLE_HEIGHT) {
            val splitPoint = y + Random(SEED).nextInt(MIN_RECTANGLE_HEIGHT, height - MIN_RECTANGLE_HEIGHT)

            doMondrian(x, y, width, splitPoint - y)
            doMondrian(x, splitPoint, width, (y + height) - splitPoint)

            return true
        }
        return false
    }

    /**
     * Performs an horizontal and vertical split of the region specified
     * by [x], [y], [width], and [height], if it is both wide and tall enough
     * to split, and calls [doMondrian] on each of the four smaller regions.
     * If the original region is too small to split, no action is taken.
     *
     * @return true if the original region could be split, false otherwise
     */
    private fun split4Way(x: Int, y: Int, width: Int, height: Int): Boolean {
        // TODO("Implement")
        if (width > 2 * MIN_RECTANGLE_WIDTH && height > 2 * MIN_RECTANGLE_HEIGHT) {

            val verticalSplitPoint = x + Random(SEED).nextInt(MIN_RECTANGLE_WIDTH, width - MIN_RECTANGLE_WIDTH)
            val horizontalSplitPoint = y + Random(SEED).nextInt(MIN_RECTANGLE_HEIGHT, height - MIN_RECTANGLE_HEIGHT)

            doMondrian(x, y, verticalSplitPoint - x, horizontalSplitPoint - y) // Top-left

            doMondrian(verticalSplitPoint, y, (x + width) - verticalSplitPoint, horizontalSplitPoint - y) // Top-right

            doMondrian(
                x,
                horizontalSplitPoint,
                verticalSplitPoint - x,
                (y + height) - horizontalSplitPoint
            ) // Bottom-left
            doMondrian(
                verticalSplitPoint,
                horizontalSplitPoint,
                (x + width) - verticalSplitPoint,
                (y + height) - horizontalSplitPoint
            ) // Bottom-right

            return true

        }
        return false
    }

    /**
     * Divides the region with the given [x] and [y] coordinates and having
     * width [width] and height [height] into one or more colored rectangles,
     * in the style of Piet Mondrian.
     */
    // needs to be public to be accessed outside the class
    fun doMondrian(
        x: Int,
        y: Int,
        width: Int,
        height: Int,
    ) {

        // 1. If the width of the region is more than half the canvas width AND
        //    the height of the region is more than half the canvas height,
        //    call split4Way(x, y, width, height).

        if (width > REQUESTED_CANVAS_WIDTH / 2 && height > REQUESTED_CANVAS_HEIGHT / 2) {
            if (split4Way(x, y, width, height)) {
                return
            }
        }

        // 2. Otherwise, if the width of the region is more than half the
        //    canvas width (but the height is not more than half the canvas
        //    height), call splitLeftRight(x, y, width, height).

        else if (width > REQUESTED_CANVAS_WIDTH / 2 && height <= REQUESTED_CANVAS_HEIGHT / 2) {
            splitLeftRight(x, y, width, height)
        }
        // 3. Otherwise, if the height of the region is more than half the
        //    canvas height (but the width is not more than half the canvas
        //    width), call splitTopBottom(x, y, width, height).
        else if (width <= REQUESTED_CANVAS_WIDTH / 2 && height > REQUESTED_CANVAS_HEIGHT / 2) {
            if (splitTopBottom(x, y, width, height)) {
                return
            }
        }

        // 4. Otherwise, randomly choose a split type to attempt from these
        //    three options: LeftRight, TopBottom, or Both.
        //    If LeftRight is chosen and the region is wide enough to split
        //      into two side-by-side regions, do so.
        //    f TopBottom was chosen and the region is tall enough to split
        //      into two stacked (over-under) regions, do so.
        //    If Both was chosen and the region is both wide enough and tall
        //      enough to split into four regions, do so.

        val splitChoice = listOf("LeftRight", "TopBottom", "Both").random()
        when (splitChoice) {
            "LeftRight" -> if (width > MIN_RECTANGLE_WIDTH) {
                splitLeftRight(x, y, width, height)
            }

            "TopBottom" -> if (height > MIN_RECTANGLE_HEIGHT) {
                splitTopBottom(x, y, width, height)
            }

            "Both" -> if (width > MIN_RECTANGLE_WIDTH && height > MIN_RECTANGLE_HEIGHT) {
                split4Way(x, y, width, height)
            }
        }

        // 5. If none of the above conditions code caused a split method to be
        //    called, fill the entire region with a single color. Half the time,
        //    the color should be white. The other half of the time, choose
        //    randomly among red, yellow, and blue. The outline color should
        //    always be black. You can modify the below sample code, which
        //    always draws a yellow rectangle with a black outline.
        val splitColor = if (random.nextBoolean()) {
            Color.WHITE
        } else {
            listOf(Color.RED, Color.YELLOW, Color.BLUE).random()
        }



        canvas.drawRectangle(
            x,
            y,
            width,
            height,
            fillColor = splitColor,
            outlineColor = Color.BLACK,
        )

    }

    /**
     * Handles a click at the specified [x]-[y] coordinates.
     */
    // needs to be public to be accessed outside the class
    fun handleClick(x: Int, y: Int) {
        recolorRectangle(x, y)
    }

    /**
     * Changes the fill color of the rectangle containing ([x], [y]).
     */
    open fun recolorRectangle(x: Int, y: Int) {
        // You will need to determine the boundaries of the rectangle the
        // user has clicked on.
        // You may find the method canvas.getColorAt(x, y) helpful.
        // Get the current color at the clicked coordinates
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
                listOf(Color.RED, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.PINK).random()
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
    MondrianPainter()
}
