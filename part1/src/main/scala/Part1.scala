object Part1 extends App {

    case class Cat(color: String, favouriteFood: String)

    val oswald = Cat("black", "milk")
    val henderson = Cat("ginger and white", "chips")
    val quentin = Cat("tabby and white", "curry")

    object ChipShop {
        def serve(cat: Cat): String = cat match {
            case Cat(_, "chips") => "OMNOM"
            case _ => "Blehhh"
        }
    }

    println("oswald = " + oswald)
    println("henderson.color = " + henderson.color)
    println("ChipShop.serve(quentin) = " + ChipShop.serve(quentin))
    println("ChipShop.serve(henderson) = " + ChipShop.serve(henderson))

}
