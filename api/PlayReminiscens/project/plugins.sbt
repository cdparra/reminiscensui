// Comment to get more information during initialization
logLevel := Level.Warn

scalaVersion := "2.9.2"

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.1.0")


resolvers += {
  "remeniuk repo" at "http://remeniuk.github.com/maven"
  "clib repo" at "http://cilib.net/maven"
}

//libraryDependencies += {
//  "com.wordnik" %% "swagger-play2" "2.10" "1.2.1-SNAPSHOT"
//}

libraryDependencies += {
  "org.netbeans" %% "sbt-netbeans-plugin" % "0.1.5"
}
