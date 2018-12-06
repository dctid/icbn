fun isValidIsbn(isbn: String): Boolean {
    val normalizedIsbn = isbn.replace("\\s|\\-".toRegex(), "")

    try {
        normalizedIsbn.toBigInteger()
    } catch (e: NumberFormatException) {
        return false
    }

    return if (normalizedIsbn.length == 10)
        validate10IsbnChecksum(normalizedIsbn)
    else
        validate13IsbnChecksum(normalizedIsbn)
}

fun validate10IsbnChecksum(normalizedIsbn: String): Boolean = true

internal fun validate13IsbnChecksum(isbn: String): Boolean {
    var sum = calculateSum(isbn)

    val reducedSum = (10 - sum % 10) % 10
    val checkSumDigit = isbn.getIntAt(13)

    return reducedSum == checkSumDigit
}

private fun calculateSum(isbn: String): Int {
    var sum = 0
    for (i in 1..12) {
        sum += calculateSumForDigit(i, isbn.getIntAt(i))
    }
    return sum
}

private fun calculateSumForDigit(index: Int, isbnDigit: Int): Int =
        if (index.isOdd()) {
            isbnDigit
        } else {
            isbnDigit * 3
        }


fun Int.isOdd(): Boolean = this % 2 != 0

internal fun String.getIntAt(index: Int): Int = this[index - 1].toString().toInt()