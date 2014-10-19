object Part2 extends App {

    trait Shape {
        def width: Double
        def height: Double
        def area: Double
    }

    case class Rectangle(width: Double, height: Double) extends Shape {
        val area = width * height
    }

    case class Circle(radius: Double) extends Shape {
        val width = 2 * radius
        val height = 2 * radius
        val area = math.Pi * radius * radius
    }


    val r = Rectangle(5, 8)
    val c = Circle(10)

    println("r is " + r.width + " units by " + r.height + " units")
    println("c is " + c.width + " units by " + c.height + " units")

    println("The area of r is " + r.area)
    println("The area of c is " + c.area)

}
