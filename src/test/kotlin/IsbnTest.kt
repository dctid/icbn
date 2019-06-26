import assertk.assert
import assertk.assertions.*
import org.junit.Test


internal class IsbnTest {

    @Test
    fun `should return true with valid 13 digit isbn`() {
        assert("9780470059029".isValidIsbn()).isTrue()
        assert("978 0 471 48648 0".isValidIsbn()).isTrue()
        assert("978-0596809485".isValidIsbn()).isTrue()
        assert("978-0-13-149505-0".isValidIsbn()).isTrue()
    }

    @Test
    fun `should return false with alphas in 13 digit isbn`() {
        assert("X7804m0059029".isValidIsbn()).isFalse()
    }

    @Test
    fun `should return false with invalid checksum 13 digit isbn`() {
        assert("9780470059023".isValidIsbn()).isFalse()
    }

    @Test
    fun `should return true with valid 10 digit isbn`() {
        assert("0471958697".isValidIsbn()).isTrue()
        assert("0 471 60695 2".isValidIsbn()).isTrue()
        assert("0-470-84525-2".isValidIsbn()).isTrue()
        assert("0-321-14653-0".isValidIsbn()).isTrue()
        assert("0-8044-2957-X".isValidIsbn()).isTrue()
    }

    @Test
    fun `should return false with invalid checksum 10 digit isbn`() {
        assert("0471958699".isValidIsbn()).isFalse()
    }

}
