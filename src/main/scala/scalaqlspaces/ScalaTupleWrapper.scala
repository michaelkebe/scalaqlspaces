package scalaqlspaces

import info.collide.sqlspaces.client.TupleSpace
import info.collide.sqlspaces.commons.Tuple

class ScalaTupleSpaceWrapper(ts: TupleSpace) {
/*
  private def scalaTuple2tsTuple[T1](t:Tuple1[T1]) = {
    val tst = new Tuple
    tst add t._1
    tst
  }
*/
  private def scalaTuple2tsTuple[T1, T2](t:Tuple2[T1, T2]) = {
    val tst = new Tuple
    tst add t._1; tst add t._2
    tst
  }
/*
  private def scalaTuple2tsTuple[T1, T2, T3](t:Tuple3[T1, T2, T3]) = {
    val tst = new Tuple
    tst add t._1; tst add t._2; tst add t._3
    tst
  }
  private def scalaTuple2tsTuple[T1, T2, T3, T4](t:Tuple4[T1, T2, T3, T4]) = {
    val tst = new Tuple
    tst add t._1; tst add t._2; tst add t._3; tst add t._4
    tst
  }
*/
/*
  def <<[T](t: Tuple1[T]) = {
    ts write scalaTuple2tsTuple(t)
  }
*/
  def <<[T1, T2](t: Tuple2[T1, T2]) = {
    ts write scalaTuple2tsTuple(t)
  }
/*
  def <<[T1, T2, T3](t: Tuple3[T1, T2, T3]) = {
    ts write scalaTuple2tsTuple(t)
  }
  def <<[T1, T2, T3, T4](t: Tuple4[T1, T2, T3, T4]) = {
    ts write scalaTuple2tsTuple(t)
  }
  def typedTake[T1](t: Tuple, dummy: Int = 0): Option[Tuple1[T1]] = {
    val rt = ts take t
    if (rt == null) None
    else Some(Tuple1(getFieldAs[T1](rt, 0)))
  }
  def typedTake[T1, T2](t: Tuple)(implicit m: Manifest[T1]): Option[Tuple2[T1, T2]] = {
    val rt = ts take t
    if (rt == null) None
    else Some((getFieldAs[T1](rt, 0), getFieldAs[T2](rt, 1)))
  }
  def typedTake[T1, T2, T3](t: Tuple): Option[Tuple3[T1, T2, T3]] = {
    val rt = ts take t
    if (rt == null) None
    else Some((getFieldAs[T1](rt, 0), getFieldAs[T2](rt, 1), getFieldAs[T3](rt, 2)))
  }
  private def getFieldAs[T](t: Tuple, i: Int) = t.getField(i).getValue.asInstanceOf[T]
*/
}
