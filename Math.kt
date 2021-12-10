internal object Math {
    fun nok(a: Int, b: Int): Int {
        return a * b / nod(a, b)
    }

    fun nod(a: Int, b: Int): Int {
        return if (b == 0) {
            a
        } else nod(b, a % b)
    }
}