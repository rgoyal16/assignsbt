name := "assignsbt"

version := "0.1"

scalaVersion := "2.12.12"
lazy val common = project.in(file("common"))
  .settings(
    name := "common",
    libraryDependencies ++=Seq(
      "io.github.embeddedkafka" %% "embedded-kafka" % "3.0.0" % Test,
      "com.softwaremill.sttp.client" %% "json4s" % "2.2.9",
      "org.scalactic" %% "scalactic" % "3.3.0-SNAP3",
      "org.typelevel" %% "discipline-scalatest" % "2.1.5" % Test,
      "org.markushauck" %% "mockitoscala" % "0.3.0"
    ))

lazy val actor = project.in(file("actor"))
  .settings(
    name := "actor",
    libraryDependencies ++=Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.16",
      "com.typesafe.akka" %% "akka-stream" % "2.6.14",
      "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.16",
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.16" % Test,
      "org.typelevel" %% "discipline-scalatest" % "2.1.5" % Test

    ))

lazy val root = project.in(file(".")).aggregate(common,actor)