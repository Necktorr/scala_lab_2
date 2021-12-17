

import scala.annotation.tailrec

/** Реализуйте функции для решения следующих задач.
  * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подстверждения.
  * рекурсия будет хвостовой если:
  *   1. рекурсия реализуется в одном направлении
  *   2. вызов рекурсивной функции будет последней операцией перед возвратом
  */
object RecursiveFunctions {

  def length[A](as: List[A]): Int = {
    @tailrec
    def loop(rem: List[A], agg: Int): Int = rem match {
      case Cons(_, tail) => loop(tail, agg + 1)
      case Nil()         => agg
    }

    loop(as, 0)
  }

  /* a) Напишите функцию которая записывает в обратном порядке список:
   *        def reverse[A](list: List[A]): List[A]
   */



  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testReverse[A](list: List[A]): List[A] =  {
    @tailrec
    def loop(rem: List[A], num: List[A]): List[A]
    = rem match {
      case Nil() => num
      case Cons(x, y) => loop (y, Cons(x, num) )
    }
    loop(list, Nil())
  }


  /* b) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */



  // используйте функцию из пункта  (b) здесь, не изменяйте сигнатуру
  def testMap[A, B](list: List[A], f: A => B): List[B] =  {
    @tailrec
    def mapLoop(l: List[A], num: List[B]): List[B] = l match {
      case Cons(x, y) => mapLoop(y, Cons(f(x), num))
      case Nil() => testReverse(num)
    }
    mapLoop(list,Nil())
  }
  
  /* c) Напишите функцию, которая присоединяет один список к другому:
   *        def append[A](l: List[A], r: List[A]): List[A]*/
  // используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру
  def Append[A](l: List[A], r: List[A]): List[A] =
    l match {
      case Nil() => r
      case Cons(h, t) => Cons(h, Append(t, r))
    }
  def testAppend[A](l: List[A], r: List[A]): List[A] = Append(l, r);


  /* d) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   * 
   *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в 
   *    списке. Поэтому вы создаете List[List[B]]. 
   */



  // используйте функцию из пункта  (d) здесь, не изменяйте сигнатуру
  def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] = {
    @tailrec
    def flatMapLoop(l: List[A],num: List[B]): List[B] = l match {
      case Cons(x, y) => flatMapLoop(y, testAppend(f(x), num))
      case Nil() => testReverse(num)
    }
    flatMapLoop(list, Nil())
  }

  /* e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему? */
  //  sealed trait Tree[A]
  //  def Sum[T](t: Tree[T], f: T => Tree[T]): Int = t match {
  //    case arg(l, r) => Sum(l, f) + Sum(r, f)
  //  }
}
