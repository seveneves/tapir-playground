libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-akka-http-server" % "0.20.0-M10"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.8"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.10"
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.6.18"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % IntegrationTest
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-sttp-client" % "0.20.0-M10" % IntegrationTest

configs(IntegrationTest)
Defaults.itSettings
