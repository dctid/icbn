fun String.isValidIsbn(): Boolean =
        removeSpacesAndDashes().validate()

private fun String.removeSpacesAndDashes(): String =
        replace("\\s|-".toRegex(), "")


private fun String.validate(): Boolean =
        when (length) {
            10 -> validate10IsbnChecksum()
            13 -> validate13IsbnChecksum()
            else -> false
        }

private fun String.validate10IsbnChecksum(): Boolean =
        calculate10DigitSum() == getChecksum()


private fun String.calculate10DigitSum(): Int =
        subSequence(0, 9)
                .toList()
                .withIndex()
                .sumBy { it.value.toIsbnValue() * (it.index + 1) } % 11


private fun String.validate13IsbnChecksum(): Boolean =
        calculate13DigitChecksum() == getChecksum()

private fun String.calculate13DigitChecksum(): Int =
        ((10 - calculatePrefixChecksumFor13Isbn() % 10) % 10)

private fun String.calculatePrefixChecksumFor13Isbn(): Int =
        subSequence(0, 12)
                .toList()
                .withIndex()
                .sumBy { it.value.toIsbnValue().calculateSumForDigit(it.index + 1) }


private fun String.getChecksum() = last().toIsbnValue()

private fun Int.calculateSumForDigit(index: Int): Int =
        if (index.isOdd()) {
            this
        } else {
            this * 3
        }

private fun Int.isOdd(): Boolean = this % 2 != 0

private fun Char.toIsbnValue(): Int =
        when (this) {
            'X' -> 10
            in '0'..'9' -> Character.getNumericValue(this)
            else -> -1
        }