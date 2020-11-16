name := "cs434-project"
organization in ThisBuild := "com.physicube"
scalaVersion in ThisBuild := "2.11.12"

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
    
)

