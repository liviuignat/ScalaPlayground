name := "hello-scala"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
  "com.novocode" % "junit-interface" % "0.9" % "test")
    