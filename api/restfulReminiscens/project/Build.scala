import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "restfulReminiscens"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "mysql" % "mysql-connector-java" % "5.1.18",
    "be.objectify"  %%  "deadbolt-java"     % "2.1-SNAPSHOT",
    "com.feth"      %%  "play-authenticate" % "0.2.5-SNAPSHOT",
    "net.sf.dozer" % "dozer" % "5.4.0",
    "com.typesafe" %% "play-plugins-mailer" % "2.1.0",
    javaCore,
    javaJdbc,
    javaEbean,
    "org.jadira.usertype" % "usertype.jodatime" % "1.8",
    "org.hibernate" % "hibernate-annotations" % "3.5.6-Final"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    resolvers += Resolver.url("Objectify Play Repository (release)", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
    resolvers += Resolver.url("Objectify Play Repository (snapshot)", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns),

    resolvers += Resolver.url("play-easymail (release)", url("http://joscha.github.com/play-easymail/repo/releases/"))(Resolver.ivyStylePatterns),
    resolvers += Resolver.url("play-easymail (snapshot)", url("http://joscha.github.com/play-easymail/repo/snapshots/"))(Resolver.ivyStylePatterns),

    resolvers += Resolver.url("play-authenticate (release)", url("http://joscha.github.com/play-authenticate/repo/releases/"))(Resolver.ivyStylePatterns),
    resolvers += Resolver.url("play-authenticate (snapshot)", url("http://joscha.github.com/play-authenticate/repo/snapshots/"))(Resolver.ivyStylePatterns)
    )
}
