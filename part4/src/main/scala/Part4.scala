object Part4 extends App {

    trait Result
    case class Finite(value: Int) extends Result
    case object Undefined extends Result

    trait Calculation {
        def calculate: Result
    }

    case class Number(value: Int) extends Calculation {
        val calculate = Finite(value)
    }

    case class Addition(a: Calculation, b: Calculation) extends Calculation {
        def calculate: Result = {
            a.calculate match {
                case Finite(x) => b.calculate match {
                    case Finite(y) => Finite(x + y)
                    case Undefined => Undefined
                }
                case Undefined => Undefined
            }
        }
    }

    case class Multiplication(a: Calculation, b: Calculation) extends Calculation {
        def calculate: Result = {
            a.calculate match {
                case Finite(x) => b.calculate match {
                    case Finite(y) => Finite(x * y)
                    case Undefined => Undefined
                }
                case Undefined => Undefined
            }
        }
    }

    case class Division(a: Calculation, b: Calculation) extends Calculation {
        def calculate: Result = {
            a.calculate match {
                case Finite(x) => b.calculate match {
                    case Finite(0) => Undefined
                    case Finite(y) => Finite(x / y)
                    case Undefined => Undefined
                }
                case Undefined => Undefined
            }
        }
    }



    val one = Addition(Number(1), Multiplication(Number(2), Number(3)))
    val two = Division(Number(1), Number(0))

    println("one is " + one.calculate)
    println("two is " + two.calculate)

}
