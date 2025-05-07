val scala3Version = "3.6.4"
val akkaVersion = "2.8.8"

name := "hulk-scala3"
version := "1.0"

scalaVersion := scala3Version

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j"   % akkaVersion
)