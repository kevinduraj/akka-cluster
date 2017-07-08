name := "akka-cluster"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

val akka = "2.3.11"

libraryDependencies ++= Seq(
  "com.typesafe.akka"          %%  "akka-actor"                            % akka,
  "com.typesafe.akka"          %% "akka-cluster"                           % akka,
  "com.typesafe.akka"          %% "akka-remote"                            % akka,
  "com.typesafe.akka"          %% "akka-contrib"                           % akka,
  "com.typesafe.akka"          %%  "akka-slf4j"                            % akka
)

