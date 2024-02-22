import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class ConsoleVmTest: FunSpec({
    class TestConsole(vararg input: String): Console {
        val out: MutableList<String> = mutableListOf()

        override fun writeLine(line: String) {
            TODO("Not yet implemented")
        }

        override fun readLine(): String {
            TODO("Not yet implemented")
        }

        fun output(): List<String> {
            val result = out.toList()
            out.clear()
            return result
        }
    }

    val products = mapOf(
        RealProduct(BigDecimal(15.0), "Барни") to 1
    )

    test("simple test") {
        val console = TestConsole(
            "insert 5"
        )

        val vm = ConsoleVendingMachine(console, products)
        vm.step()
        console.output() shouldBe listOf("продукт не выбран")

        vm.step()
        console.output() shouldBe listOf("продукт не выбран")
    }

    test("with DSL") {
        // TODO: vm(nSteps, consoleIn).shouldOut(consoleOut)
        //       vm(nSteps = 1, "insert 5", "insert 10")
    //               .shouldOut("продукт не выбран", "продукт не выбран")

    }
})