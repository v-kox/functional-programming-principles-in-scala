package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1)) // true
  val a = union(Set(1, 2, 3), Set(3, 4, 5))
  println(a(3))                                       // true


  val b = Set(1, 2, 3)
  println(forall(b, (x: Int) => x > 2))               // false
  println(exists(b, (x: Int) => x > 2))               // true
  println(map(b, x => x * 2)(6))                      // true
  println(map(b, x => x * 2)(5))                      // false
}
