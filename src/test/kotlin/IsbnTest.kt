import assertk.assert
import assertk.assertions.*
import org.junit.Test


internal class IsbnTest {

    @Test
    fun `should return true with valid 13 digit isbn`() {
        assert(isValidIsbn("9780470059029")).isTrue()
    }

    @Test
    fun `should return false with invalid 13 digit isbn`() {
        assert(isValidIsbn("X780470059029")).isFalse()
    }

}