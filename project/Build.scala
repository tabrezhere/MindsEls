import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName = "the-app"
  val appVersion = "1.0-SNAPSHOT"

  def settings(theName: String) = Seq(
    name := theName,
    organization := "com.myweb",
    version := appVersion,
    scalaVersion := "2.11.6",
    doc in Compile <<= target.map(_ / "none"),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-g:line",
      "-language:reflectiveCalls",
      "-language:postfixOps",
      "-language:implicitConversions"))
  // Settings for the app, i.e. the root project
  //val appSettings = settings(appName) ++: Seq(
  //resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
  //)

  val appDependencies = Seq(
    "org.webjars" %% "webjars-play" % "2.3.0-3",
    "org.webjars" % "bootstrap" % "3.3.2",
    "org.webjars" % "toastr" % "2.1.0",
    "org.webjars" % "angularjs" % "1.3.13",
    "org.webjars" % "font-awesome" % "4.3.0-1",
    "org.webjars" % "jquery" % "2.1.3",
    "com.mohiva" %% "play-silhouette" % "1.1-SNAPSHOT",
    "net.codingwell" %% "scala-guice" % "4.0.0-beta4",
//    "org.squeryl" %% "squeryl" % "0.9.5-6",
    "com.typesafe.play" %% "anorm" % "2.3.8",
    "com.typesafe.play" %% "play-jdbc" % "2.3.8",
    "mysql" % "mysql-connector-java" % "5.1.34",
    "com.typesafe" %% "play-plugins-mailer" % "2.1-RC2",
    "com.amazonaws" % "aws-java-sdk" % "1.10.1",
    "org.codemonkey.simplejavamail" % "simple-java-mail" % "2.1")

  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(
    resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
    version := appVersion,
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-g:line",
      "-unchecked",
      "-language:reflectiveCalls",
      "-language:postfixOps",
      "-language:implicitConversions"),
    libraryDependencies ++= appDependencies)

}
