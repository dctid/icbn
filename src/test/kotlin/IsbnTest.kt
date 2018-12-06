import assertk.assert
import assertk.assertions.*
import org.junit.Test


internal class IsbnTest {

    @Test
    fun `should return true with valid 13 digit isbn`() {
        assert(isValidIsbn("9780470059029")).isTrue()
        assert(isValidIsbn("978 0 471 48648 0")).isTrue()
        assert(isValidIsbn("978-0596809485")).isTrue()
        assert(isValidIsbn("978-0-13-149505-0")).isTrue()
    }

    @Test
    fun `should return false with alphas in 13 digit isbn`() {
        assert(isValidIsbn("X780470059029")).isFalse()
    }

    @Test
    fun `should return false with invalid checksum 13 digit isbn`() {
        assert(isValidIsbn("9780470059023")).isFalse()
    }

}