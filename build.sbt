name := "cs434-project"
organization in ThisBuild := "com.physicube"
scalaVersion in ThisBuild := "2.12.8"

// PROJECTS

lazy val root = project
    .in(file("."))
    .aggregate(master, slave)

lazy val master = project
    .settings(
        name := "master",
        libraryDependencies ++= commonDependencies
    ).enablePlugins(JavaAppPackaging)

lazy val slave = project
    .settings(
        name := "slave",
        libraryDependencies ++= commonDependencies
    ).enablePlugins(JavaAppPackaging)

// DEPENDENCIES
lazy val dependencies = 
    new {

    }



lazy val commonDependencies = Seq(
    "org.apache.logging.log4j" %% "log4j-api-scala" % "11.0",
    "org.apache.logging.log4j" % "log4j-api" % "2.11.0",
    "org.apache.logging.log4j" % "log4j-core" % "2.11.0" % Runtime,
    "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
)

PB.targets in Compile := Seq(
    scalapb.gen() -> (sourceManaged in Compile).value / "scalapb"
)
