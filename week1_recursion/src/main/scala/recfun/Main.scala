package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 5) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println()

    println("Parentheses Balance")
    println(balance("".toList))             // true
    println(balance(")()()()()()(".toList)) // false
    println(balance("()()()()()()".toList)) // true
    println()

    println("Counting Change")
    println(countChange(4, List(1, 2)))
    println()
  }
  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = if (c == 0 | r == c) 1 else pascal(c, r-1) + pascal(c-1, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(status: Int, subchars: List[Char]) : Int = {
        subchars match {
          case head :: tail => {
            if (head.toString == "(") loop(status+1, tail)
            else if (head.toString == ")")
              if (status == 0) -1 // If counter becomes negative, parentheses cannot be balanced
              else loop(status-1, tail)
            else loop(status, tail)
          }
          case Nil => status
        }
      }
      val result = loop(0, chars)

      if (result == 0) true
      else false
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money < 0 | coins.isEmpty) 0
      else {
        countChange(money, coins.tail) + countChange(money - coins.head, coins)
      }
    }
  }
