name := "simplaex-hadoop-aws"
organization := "com.simplaex"

version := "2.7.3"
 
scalaVersion := "2.11.8"

crossPaths := false
crossScalaVersions := Seq(scalaVersion.value, "2.10.6")

licenses += ("Apache-2.0", url("http://opensource.org/licenses/apache-2.0"))

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "11.0.2",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.10.77",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.3",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.2.3",
  "org.apache.hadoop" % "hadoop-common" % "2.7.3" % Configurations.Provided
)

resolvers += "splx".at("http://simplaex-dependencies.s3-website-us-east-1.amazonaws.com/releases")

sources in (Compile, doc) := Seq.empty

publishMavenStyle := true

publishTo := {
  if (isSnapshot.value) {
    Some("Simplaex Snapshots" at "s3://simplaex-dependencies.s3.amazonaws.com/snapshots")
  } else {
    Some("Simplaex Releases" at "s3://simplaex-dependencies.s3.amazonaws.com/releases")
  }
}

