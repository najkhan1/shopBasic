ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "FruitShopBasket"
  )

val scalaTest = "3.2.12"
val typeSafeConfig = "1.4.2"
val typeSafeLogging = "3.9.5"
val logger = "1.7.36"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % scalaTest % "test",
  "com.typesafe" % "config" % typeSafeConfig,
  "com.typesafe.scala-logging" %% "scala-logging" % typeSafeLogging,
  "org.slf4j" % "slf4j-api" % logger,
  "org.slf4j" % "slf4j-simple" % logger

)