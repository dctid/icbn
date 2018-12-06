

fun isValidIsbn(isbn:String) : Boolean =
        try {
            isbn.replace("\\s|\\-".toRegex(), "").toBigInteger()
            true
        } catch (e : NumberFormatException){
            false
        }

