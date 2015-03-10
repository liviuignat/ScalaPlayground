name := "hello-scala"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "com.novocode" % "junit-interface" % "0.9" % "test")

ScoverageSbtPlugin.instrumentSettings

CoverallsPlugin.coverallsSettings
    