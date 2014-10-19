object Part4 extends App {

    trait Result
    case class Finite(value: Int) extends Result
    case object Undefined extends Result

    
    trait Calculation {
        def a: Calculation
        def b: Calculation

        def calculate: Result = {
            a.calculate match {
                case Finite(x) => b.calculate match {
                    case Finite(y) => op(x, y)
                    case Undefined => Undefined
                }
                case Undefined => Undefined
            }
        }

        protected def op(x: Int, y: Int): Result
    }

    case class Number(value: Int) extends Calculation {
        val a = null
        val b = null
        override val calculate = Finite(value)
        def op(x: Int, y: Int) = null
    }

    case class Addition(a: Calculation, b: Calculation) extends Calculation {
        def op(x: Int, y: Int) = Finite(x + y)
    }

    case class Multiplication(a: Calculation, b: Calculation) extends Calculation {
        def op(x: Int, y: Int) = Finite(x * y)
    }

    case class Division(a: Calculation, b: Calculation) extends Calculation {
        def op(x: Int, y: Int) = if (y == 0) Undefined else Finite(x / y)
    }



    val one = Addition(Number(1), Multiplication(Number(2), Number(3)))
    val two = Division(Number(1), Number(0))

    println("one is " + one.calculate)
    println("two is " + two.calculate)

}
