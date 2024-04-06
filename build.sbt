ThisBuild / version := "1.0"
ThisBuild / scalaVersion := "2.12.18"
ThisBuild / organization := "symonarch"

val spinalVersion = "1.10.1"
val spinalCore = "com.github.spinalhdl" %% "spinalhdl-core" % spinalVersion
val spinalLib = "com.github.spinalhdl" %% "spinalhdl-lib" % spinalVersion
val spinalIdslPlugin = compilerPlugin("com.github.spinalhdl" %% "spinalhdl-idsl-plugin" % spinalVersion)

lazy val projectname = (project in file("."))
  .settings(
    name := "symonarch",
    Compile / scalaSource := baseDirectory.value / "src" / "spinal",
    libraryDependencies ++= Seq(spinalCore, spinalLib, spinalIdslPlugin)
  )
