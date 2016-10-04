name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, SbtWeb)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  cache,
  javaWs
)

// https://mvnrepository.com/artifact/com.hp.hpl.jena/jena

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "anorm" 				% "2.4.0",
  "org.webjars" 		%% "webjars-play" 		% "2.4.0-1",
  "org.webjars" 		%  "bootstrap" 			% "3.1.1-2",
  "org.webjars"       %  "flat-ui"            % "bcaf2de95e",
  "org.webjars" 		%  "react" 				% "0.13.3",
  "org.webjars" 		%  "marked" 			% "0.3.2"
)
libraryDependencies += "com.hp.hpl.jena" % "jena" % "2.6.4"
// https://mvnrepository.com/artifact/org.apache.jena/jena-arq
libraryDependencies += "org.apache.jena" % "jena-arq" % "3.1.0"
libraryDependencies += "org.apache.jena" % "jena-core" % "3.1.0"


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

enablePlugins(SbtNativePackager)

fork in run := true

fork in run := true

fork in run := true

fork in run := true