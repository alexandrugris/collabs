println("Hello World From Scala")

val l = List(1, 2, 3, 4, 5)

// with views, to reduce copying
l.view.map(_ + 1)
    .filter(_ > 2)
    .takeWhile( _ < 5).toList

val tuple = ("String", 0.1, 5)

// union type
case class Username(name: String)
case class Password(hash: Int)

def help(id : Username | Password) = 
    id match
        case Username(name) => name
        case Password(hash) => hash
    

val u : Username | Password = if(false) Username("Alex") else Password(123)
println(help(u))

// enumerations

enum Topping:
  case Cheese, Pepperoni, Sausage, Mushrooms, Onions

// string interpolations
val s = s"2 + 2 = ${2+2}"
println(s) 

val i = -4
i.abs

val quote = """The essence of Scala:
               Fusion of functional and object-oriented
               programming in a typed setting."""

println(quote)

// loops
val lx = List(1, 2, 3, 4, 5)

for j <- lx do {
    println(j)
}

// single loop
for j <- lx if j > 2 do
    println(j)

// double loop
for i <- -10 to 10 
    j <- -10 to 10
    if i > 0
    if j > 0 
do
    println(s"${i}, ${j}")

// for expressions

val names = List("chris", "ed", "maurice")
val capitalized = for c <- names yield c.toUpperCase()

println(capitalized)

// matches

def getClassAsString(x : Matchable) = x match
    case _ : Int => "Int"
    case _ : Double => "Double"
    case _ : String => "String"
    case _ => "Unknown"

val x = 2.0
println(getClassAsString(x))


// case classes

// define a case class
case class Person(
  name: String,
  vocation: String
)

// create an instance of the case class
val p = Person("Reginald Kenneth Dwight", "Singer")

val p2 = p.copy(name="Alex Gris")

print(p2)

///

val zToT = (0 to 10)

for i <- zToT do
    print(i)

val zToTList = zToT.toList

val lstStr = List("Hello", "World")
    .map(_.toUpperCase())
    .flatMap(_.toCharArray())

// companion object

class Circle(radius : Double):
    import Circle.*
    def area() = computeArea(radius)

object Circle:
    private def computeArea(radius: Double) = radius * radius * 3.1415

val circle = Circle(10)
circle.area()

trait Add : 
    def add(a : Int, b : Int) = a + b

trait Multiply :
    def multiply(a : Int, b : Int)  = a * b

object MathService extends Add, Multiply;

// expose traits as services
import MathService.*

add(2, 3)

// sorting
val pl = List(
    Person("Alex", "Singer"),
    Person("Bubu", "Singer"),
    Person("Alex", "Programmer"),
    Person("Bubu", "Programmer")
).sortBy(p => (p.vocation, p.name))


// match with capturing the variable for the default case

def toStrDummy(i : Matchable) = i match
  case 0 => println("1")
  case 1 => println("2")
  case what => println(s"You gave me: $what")

println(toStrDummy(0))

// match with contains

def guessInterval(x : Int) = x match
  case a if 0 to 9 contains a => println(s"0-9 range: $a")
  case b if 10 to 19 contains b => println(s"10-19 range: $b")
  case c if 20 to 29 contains c => println(s"20-29 range: $c")
  case _ => println("Hmmm...")

println(guessInterval(23))

def pattern(x : Matchable) = x match
    case (1, a, b) => (a, b)
    case (a, 2, b) => (a, b)
    case l : List[?] => l match
        case head :: next => (head, next)
        case Nil => Nil
    
    case _ => x

pattern((1, 2, 3))
pattern((4, 2, 3))
pattern(List(1, 2, 3))

// 

val x1 = Person("Alex", "IT")
val x2 = Person("Alex", "IT")

x1 == x2 == true

trait AudioMessage

case object StopMusic extends AudioMessage
case class PlaySong(name : String) extends AudioMessage


def musicPlayer(msg : AudioMessage) : Unit = 
    msg match
        case StopMusic => println("Stop Music")
        case PlaySong(name) => println(s"Playing $name") 

musicPlayer(StopMusic)
musicPlayer(PlaySong("Bubu"))

// generic functions

def map[A, B](f: (B) => A, xs: List[B]): List[A] =
  for x <- xs yield f(x)

map((s: String) => s.length() , List("Alex", "Olga"))

for x <- map((s: String) => s.length() , List("Alex", "Olga", "Laur", "Adriana")) do
    println(x)

def recsum(list: List[Int]): Int = list match
  case Nil => 0
  case x :: xs => x + recsum(xs)

recsum(List(1, 2, 3, 4, 5))


val emptyList : List[Int] = List()

try
    emptyList.reduce(_ + _)
catch
    case e1 : UnsupportedOperationException => println(e1)

def makeInt(s : String) : Option[Int] =
    try
        Some(Integer.parseInt(s))
    catch
        case _ => None

makeInt("5") match
    case Some(x) => println(x)
    case None => println("Can't convert")



        






