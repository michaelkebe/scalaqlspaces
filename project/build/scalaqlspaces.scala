import sbt._

class scalaqlspacesProject(info: ProjectInfo) extends DefaultProject(info) {
  val collideRepository = "Collide Maven Repository" at "http://mvn.collide.info/content/repositories/releases"
  val sqlSpaces = "info.collide" % "sqlspaces-client" % "3.10.0"
  val scalaTest = "org.scalatest" % "scalatest_2.9.0" % "1.4.1"
}

