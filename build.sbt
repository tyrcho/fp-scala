
val exercises = scalaProject("exercises", Seq(upickle))
val forcomp = scalaProject("forcomp")
val funsets = scalaProject("funsets")
val objsets = scalaProject("objsets", Seq(parserCombinators))
val paths = scalaProject("paths")
val practice = scalaProject("practice")
val recursivity = scalaProject("recursivity")
val samples = scalaProject("samples")

def scalaProject(id: String, extraDeps: Seq[ModuleID] = Nil) =
  Project(id = id, base = file(id))
    .settings(
      baseDirectory in test := file(id),
      fork := true,
      organization := "info.daviot",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.12.6",
      libraryDependencies ++= extraDeps,
      libraryDependencies += scalaTest
    )


lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test

lazy val parserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"
lazy val upickle = "com.lihaoyi" %% "upickle" % "0.5.1"
