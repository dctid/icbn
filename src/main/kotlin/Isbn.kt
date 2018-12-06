

fun isValidIsbn(isbn:String) : Boolean =
        try {
            isbn.toBigInteger()
            true
        } catch (e : NumberFormatException){
            false
        }

