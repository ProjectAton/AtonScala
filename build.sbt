name := """aton-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  // jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test
)

libraryDependencies += "com.typesafe.slick" % "slick_2.11" % "3.1.1"
libraryDependencies += "com.typesafe.play" % "play-slick-evolutions_2.11" % "2.0.0"
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.10"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.38"

// Webjars (Javascript)
libraryDependencies ++= Seq(
  "org.webjars" % "bootstrap" % "3.3.6",
  "org.webjars" % "jquery" % "2.2.1"
)


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


fork in run := true