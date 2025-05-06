val scala3Version = "3.6.4"
val akkaVersion = "2.8.8"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hulk-scala3",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,


    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      "com.typesafe.akka" %% "akka-actor" % akkaVersion
    )
  )
