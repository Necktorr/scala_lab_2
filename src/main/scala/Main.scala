object Main {
  def main(args: Array[String]): Unit = {
    println(Compositions.testCompose((num: Int) => num + 2)((num: Int) => num - 0)(
      (num: Int) => num - 2
    )(10))
    println(Compositions.testMapFlatMap((x: Int) => Some(x))(Some(_))(Some(_))(
      Some(7)
    ))
    println(Compositions.testForComprehension((x: Int) => Some(x + x))((x: Int) =>
          Some(x + x)
        )((x: Int) => Some(x + x))(Some(2)))
    println(RecursiveData.testListIntEmpty(Nil()))
    println(RecursiveData.testListIntEmpty(Cons(10, Cons(10, Nil()))))
    println(RecursiveData.testListIntHead(Nil()))
    println(RecursiveFunctions.testReverse(Cons(5, Cons(12, Nil()))))
    println(RecursiveFunctions.testMap(Cons(5, Cons(12, Nil())), (num: Int) => num * 2))
    println(RecursiveFunctions.testAppend(Cons(5, Cons(12, Nil())), Cons(6, Cons(13, Nil()))))
    println(RecursiveFunctions.testFlatMap(Cons(5, Cons(12, Nil())), (x: Int) => Cons(x * 2, Nil())))
  }
}