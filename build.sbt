name := "tapir-playground"

ThisBuild / scalaVersion := "2.13.6"

val api = project
val service = project.dependsOn(api)
