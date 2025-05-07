val scala3Version = "3.6.4"
val akkaVersion = "2.8.8"

name := "hulk-scala3"
version := "0.1.0-SNAPSHOT"

scalaVersion := scala3Version

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

libraryDependencies ++= Seq(
  "org.scalameta" %% "munit" % "1.0.0" % Test,
  "com.typesafe.akka" %% "akka-actor" % "2.8.8",
  "com.typesafe.akka" %% "akka-slf4j"   % "2.8.8"
)