object Part3 extends App {

    trait IntList {
        def length: Int = this match {
            case Empty => 0
            case Cell(_, tail) => 1 + tail.length
        }
        def sum: Int = this match {
            case Empty => 0
            case Cell(value, tail) => value + tail.sum
        }
        def get(index: Int): Any = this match {
            case Empty => Unit
            case Cell(value, tail) => if (index == 0) value else tail.get(index - 1)
        }
        def contains(item: Int): Boolean = this match {
            case Empty => false
            case Cell(value, tail) => if (value == item) true else tail.contains(item)
        }
        def indexOf(item: Int): Int = innerIndexOf(item, 0)
        private def innerIndexOf(item: Int, index: Int): Int = this match {
            case Empty => -1
            case Cell(value, tail) => if (value == item) index else tail.innerIndexOf(item, index + 1)
        }
    }

    case object Empty extends IntList
    case class Cell(value: Int, tail: IntList) extends IntList


    val a: IntList = Cell(1, Cell(2, Cell(3, Empty)))
    val b: IntList = Empty

    println()
    println("a = " + a)
    println("b = " + b)

    println()
    println("The length of a is " + a.length)
    println("The length of b is " + b.length)

    println()
    println("The sum of a is " + a.sum)
    println("The sum of b is " + b.sum)

    println()
    println("a.get(0) is " + a.get(0))
    println("a.get(2) is " + a.get(2))
    println("b.get(2) is " + b.get(2))

    println()
    println("a.contains(5) is " + a.contains(5))
    println("a.contains(2) is " + a.contains(2))
    println("b.contains(-3) is " + b.contains(-3))

    println()
    println("a.indexOf(1) is " + a.indexOf(1))
    println("a.indexOf(3) is " + a.indexOf(3))
    println("b.indexOf(2) is " + b.indexOf(2))

}
