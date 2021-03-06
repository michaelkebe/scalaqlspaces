package scalaqlspaces

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import info.collide.sqlspaces.client.TupleSpace
import info.collide.sqlspaces.commons.Tuple

/*
 * Currently you have to start the SQLSpaces separately server to run these tests.
 */
class ScalaqlSpacesTest extends FlatSpec with ShouldMatchers {

  "The ScalaTupleSpaceWrapper" should "allow writing Tuple2 tuples into the TupleSpace" in {
    val ts = new TupleSpace
    ts << ("A", 1)
    
    val resultTuple = ts.read(new Tuple(classOf[String], classOf[Int]))
    resultTuple.getField(0).getValue.asInstanceOf[String] should equal ("A")
    resultTuple.getField(1).getValue.asInstanceOf[Int] should equal (1)
  }

  it should "allow writing Tuple1 tuples into the TupleSpace" in {
    val ts = new TupleSpace
    ts << Tuple1("B")

    val resultTuple = ts.read(new Tuple(classOf[String]))
    resultTuple.getField(0).getValue.asInstanceOf[String] should equal ("B")
  }

  it should "allow writing Tuple3 tuples into the TupleSpace" in {
    val ts = new TupleSpace
    ts << ("String", 3.14, true)

    val resultTuple = ts.read(new Tuple(classOf[String], classOf[Double], classOf[Boolean]))
    resultTuple.getField(0).getValue.asInstanceOf[String] should equal ("String")
    resultTuple.getField(1).getValue.asInstanceOf[Double] should equal (3.14)
    resultTuple.getField(2).getValue.asInstanceOf[Boolean] should equal (true)
  }

  it should "allow writing Tuple4 tuples into the TupleSpace" in {
    val ts = new TupleSpace
    ts << ("String", 3.14, true, 9.81F)

    val resultTuple = ts.read(new Tuple(classOf[String], classOf[Double], classOf[Boolean], classOf[Float]))
    resultTuple.getField(0).getValue.asInstanceOf[String] should equal ("String")
    resultTuple.getField(1).getValue.asInstanceOf[Double] should equal (3.14)
    resultTuple.getField(2).getValue.asInstanceOf[Boolean] should equal (true)
    resultTuple.getField(3).getValue.asInstanceOf[Float] should equal (9.81F)
  }

  it should "return a typed scala Tuple3" in {
    val ts = new TupleSpace
    ts << ("Hello", true, 42)
    
    val templateTuple = new Tuple(classOf[String], classOf[Boolean], classOf[Int])
    // this extra specification of the type should be removed, if possible in scala...
    ts.typedTake[String, Boolean, Int](templateTuple) match {
      case Some(resultTuple) => {
        resultTuple._1 should equal ("Hello")
        resultTuple._1.getClass should equal (classOf[String])
        resultTuple._2 should equal (true)
        resultTuple._3 should equal (42)
      }
      case None => fail()
    }
  }

  it should "return None if tempate tuple does not match" in {
    val ts = new TupleSpace
    ts << ("Hello", true, 42)

    val templateTuple = new Tuple("Bye", classOf[Boolean], classOf[Int])
    ts.typedTake[String, Boolean, Int](templateTuple) match {
      case Some(resultTuple) => fail("Found tuple: " + resultTuple.toString)
      case None => // Success
    }
  }

}

