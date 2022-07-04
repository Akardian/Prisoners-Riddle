import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import prison.Prison
import kotlin.test.assertFalse

class PrisonTest {

    @Test
    @DisplayName("Loop Strategy Failure")
    fun loopStrategyFailure() {
        val prison = Prison()

        prison.shuffle(seed = 12345)
        println()
        prison.printStats()
        println()
        prison.printPretty()
        println()


        assertFalse(prison.loopStrategy())
    }

    @Test
    @DisplayName("Loop Strategy Success")
    fun loopStrategySuccess() {
        val prison = Prison()

        prison.shuffle(seed = 1234567890)
        println()
        prison.printStats()
        println()
        prison.printPretty()
        println()


        assert(prison.loopStrategy())
    }
}