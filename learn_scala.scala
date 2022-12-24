
@main def hello(names : String*) =

    val name = names.reduce(_ + ", " + _)

    name match 
        case null | "" => 
            println("Hello World!")
        case _ =>
            println("Hello " + name + "!")



    

