package object scalaqlspaces {
  import info.collide.sqlspaces.client.TupleSpace
  implicit def tupleSpace2ScalaTupleSpaceWrapper(ts: TupleSpace) = new ScalaTupleSpaceWrapper(ts)
}

