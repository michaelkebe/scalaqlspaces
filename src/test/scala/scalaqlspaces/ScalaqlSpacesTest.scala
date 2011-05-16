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

}

