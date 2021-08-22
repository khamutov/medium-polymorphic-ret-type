scalaVersion := "2.12.7"

name := "poly"
organization := "ru.khamutov"
version := "1.0"

libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.1.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test
libraryDependencies += "org.scalamock" %% "scalamock" % "4.1.0" % Test

