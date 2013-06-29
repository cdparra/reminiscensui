// @SOURCE:/Users/cristhian/Projects/lifeparticipation/reminiscens/explorelife/api/restfulReminiscens/conf/routes
// @HASH:1c282d46196798cebb7ac6a5e7088666b3996384
// @DATE:Fri Jun 28 19:26:46 CEST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+"""))))
        

// @LINE:12
private[this] lazy val controllers_UM_getUsers2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
        

// @LINE:13
private[this] lazy val controllers_UM_getUser3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("uid", """[^/]+"""))))
        

// @LINE:14
private[this] lazy val controllers_UM_createUser4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
        

// @LINE:15
private[this] lazy val controllers_UM_updateUser5 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("uid", """[^/]+"""))))
        

// @LINE:16
private[this] lazy val controllers_UM_deleteUser6 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("uid", """[^/]+"""))))
        

// @LINE:17
private[this] lazy val controllers_UM_getSessions7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("session"))))
        

// @LINE:18
private[this] lazy val controllers_UM_createSession8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("session"))))
        

// @LINE:19
private[this] lazy val controllers_UM_updateSession9 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("session/"),DynamicPart("sid", """[^/]+"""))))
        

// @LINE:20
private[this] lazy val controllers_UM_deleteSession10 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("session/"),DynamicPart("sid", """[^/]+"""))))
        

// @LINE:23
private[this] lazy val controllers_PersonalReminiscence_getPerson11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""))))
        

// @LINE:24
private[this] lazy val controllers_PersonalReminiscence_getPersonFriends12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/friends"))))
        

// @LINE:25
private[this] lazy val controllers_PersonalReminiscence_getPersonTimeline13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/timeline"))))
        

// @LINE:26
private[this] lazy val controllers_PersonalReminiscence_synchronizePersonTimeline14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/timeline"))))
        

// @LINE:27
private[this] lazy val controllers_PersonalReminiscence_getLifeStory15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/lifestory/"),DynamicPart("lsid", """[^/]+"""))))
        

// @LINE:28
private[this] lazy val controllers_PersonalReminiscence_createLifeStory16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/lifestory"))))
        

// @LINE:29
private[this] lazy val controllers_PersonalReminiscence_updateLifeStory17 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/lifestory/"),DynamicPart("lsid", """[^/]+"""))))
        

// @LINE:30
private[this] lazy val controllers_PersonalReminiscence_deleteLifeStory18 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/lifestory/"),DynamicPart("lsid", """[^/]+"""))))
        

// @LINE:31
private[this] lazy val controllers_PersonalReminiscence_getMementoAll19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/memento"))))
        

// @LINE:32
private[this] lazy val controllers_PersonalReminiscence_getMemento20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/memento/"),DynamicPart("mid", """[^/]+"""))))
        

// @LINE:33
private[this] lazy val controllers_PersonalReminiscence_createMemento21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/memento/"),DynamicPart("mid", """[^/]+"""))))
        

// @LINE:34
private[this] lazy val controllers_PersonalReminiscence_updateMemento22 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/memento/"),DynamicPart("mid", """[^/]+"""))))
        

// @LINE:35
private[this] lazy val controllers_PersonalReminiscence_deleteMemento23 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("person/"),DynamicPart("id", """[^/]+"""),StaticPart("/memento/"),DynamicPart("mid", """[^/]+"""))))
        

// @LINE:39
private[this] lazy val controllers_ContextualReminiscence_getContext24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""))))
        

// @LINE:40
private[this] lazy val controllers_ContextualReminiscence_getContextCurators25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/curators"))))
        

// @LINE:41
private[this] lazy val controllers_ContextualReminiscence_getContextMemento26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/memento/"),DynamicPart("mid", """[^/]+"""))))
        

// @LINE:42
private[this] lazy val controllers_ContextualReminiscence_createContextMemento27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/memento"))))
        

// @LINE:43
private[this] lazy val controllers_ContextualReminiscence_updateContextMemento28 = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/memento"))))
        

// @LINE:44
private[this] lazy val controllers_ContextualReminiscence_deleteContextMemento29 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/memento/"),DynamicPart("mid", """[^/]+"""))))
        

// @LINE:45
private[this] lazy val controllers_ContextualReminiscence_getContextQuestions30 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/question"))))
        

// @LINE:46
private[this] lazy val controllers_ContextualReminiscence_getContextQuestionsForDecade31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/question/"),DynamicPart("decade", """[^/]+"""))))
        

// @LINE:47
private[this] lazy val controllers_ContextualReminiscence_getContextQuestionsByCurators32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/question/curated"))))
        

// @LINE:48
private[this] lazy val controllers_ContextualReminiscence_createContextCuratedQuestions33 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("context/"),DynamicPart("cid", """[^/]+"""),StaticPart("/question"))))
        

// @LINE:51
private[this] lazy val controllers_Questions_getGeneralQuestionsForYear34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("question/"),DynamicPart("byear", """[^/]+"""),StaticPart("/"),DynamicPart("fyear", """[^/]+"""),StaticPart("/"),DynamicPart("lang", """[^/]+"""))))
        

// @LINE:52
private[this] lazy val controllers_Questions_getGeneralQuestionsForLifeChapter35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("question/"),DynamicPart("chapter", """[^/]+"""),StaticPart("/"),DynamicPart("lang", """[^/]+"""))))
        

// @LINE:55
private[this] lazy val controllers_Memento_getRandomMemento36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("memento/random/"),DynamicPart("lang", """[^/]+"""))))
        

// @LINE:56
private[this] lazy val controllers_Memento_getMemento37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("memento/"),DynamicPart("mid", """[^/]+"""))))
        

// @LINE:57
private[this] lazy val controllers_Memento_getMementoList38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("memento/"),DynamicPart("decade", """[^/]+"""),StaticPart("/"),DynamicPart("place", """[^/]+"""),StaticPart("/"),DynamicPart("lat", """[^/]+"""),StaticPart("/"),DynamicPart("lon", """[^/]+"""),StaticPart("/"),DynamicPart("rad", """[^/]+"""),StaticPart("/"),DynamicPart("lang", """[^/]+"""))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""controllers.UM.getUsers()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$uid<[^/]+>""","""controllers.UM.getUser(uid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""controllers.UM.createUser()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$uid<[^/]+>""","""controllers.UM.updateUser(uid:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$uid<[^/]+>""","""controllers.UM.deleteUser(uid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """session""","""controllers.UM.getSessions()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """session""","""controllers.UM.createSession()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """session/$sid<[^/]+>""","""controllers.UM.updateSession(sid:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """session/$sid<[^/]+>""","""controllers.UM.deleteSession(sid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>""","""controllers.PersonalReminiscence.getPerson(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/friends""","""controllers.PersonalReminiscence.getPersonFriends(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/timeline""","""controllers.PersonalReminiscence.getPersonTimeline(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/timeline""","""controllers.PersonalReminiscence.synchronizePersonTimeline(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>""","""controllers.PersonalReminiscence.getLifeStory(id:Long, lsid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/lifestory""","""controllers.PersonalReminiscence.createLifeStory(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>""","""controllers.PersonalReminiscence.updateLifeStory(id:Long, lsid:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>""","""controllers.PersonalReminiscence.deleteLifeStory(id:Long, lsid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/memento""","""controllers.PersonalReminiscence.getMementoAll(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/memento/$mid<[^/]+>""","""controllers.PersonalReminiscence.getMemento(id:Long, mid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/memento/$mid<[^/]+>""","""controllers.PersonalReminiscence.createMemento(id:Long, mid:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/memento/$mid<[^/]+>""","""controllers.PersonalReminiscence.updateMemento(id:Long, mid:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """person/$id<[^/]+>/memento/$mid<[^/]+>""","""controllers.PersonalReminiscence.deleteMemento(id:Long, mid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>""","""controllers.ContextualReminiscence.getContext(cid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/curators""","""controllers.ContextualReminiscence.getContextCurators(cid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/memento/$mid<[^/]+>""","""controllers.ContextualReminiscence.getContextMemento(cid:Long, mid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/memento""","""controllers.ContextualReminiscence.createContextMemento(cid:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/memento""","""controllers.ContextualReminiscence.updateContextMemento(cid:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/memento/$mid<[^/]+>""","""controllers.ContextualReminiscence.deleteContextMemento(cid:Long, mid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/question""","""controllers.ContextualReminiscence.getContextQuestions(cid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/question/$decade<[^/]+>""","""controllers.ContextualReminiscence.getContextQuestionsForDecade(cid:Long, decade:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/question/curated""","""controllers.ContextualReminiscence.getContextQuestionsByCurators(cid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """context/$cid<[^/]+>/question""","""controllers.ContextualReminiscence.createContextCuratedQuestions(cid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """question/$byear<[^/]+>/$fyear<[^/]+>/$lang<[^/]+>""","""controllers.Questions.getGeneralQuestionsForYear(byear:Long, fyear:Long, lang:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """question/$chapter<[^/]+>/$lang<[^/]+>""","""controllers.Questions.getGeneralQuestionsForLifeChapter(chapter:String, lang:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """memento/random/$lang<[^/]+>""","""controllers.Memento.getRandomMemento(lang:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """memento/$mid<[^/]+>""","""controllers.Memento.getMemento(mid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """memento/$decade<[^/]+>/$place<[^/]+>/$lat<[^/]+>/$lon<[^/]+>/$rad<[^/]+>/$lang<[^/]+>""","""controllers.Memento.getMementoList(decade:Long, place:String, lat:Double, lon:Double, rad:Long, lang:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:12
case controllers_UM_getUsers2(params) => {
   call { 
        invokeHandler(controllers.UM.getUsers(), HandlerDef(this, "controllers.UM", "getUsers", Nil,"GET", """ User and Session Management""", Routes.prefix + """user"""))
   }
}
        

// @LINE:13
case controllers_UM_getUser3(params) => {
   call(params.fromPath[Long]("uid", None)) { (uid) =>
        invokeHandler(controllers.UM.getUser(uid), HandlerDef(this, "controllers.UM", "getUser", Seq(classOf[Long]),"GET", """""", Routes.prefix + """user/$uid<[^/]+>"""))
   }
}
        

// @LINE:14
case controllers_UM_createUser4(params) => {
   call { 
        invokeHandler(controllers.UM.createUser(), HandlerDef(this, "controllers.UM", "createUser", Nil,"POST", """""", Routes.prefix + """user"""))
   }
}
        

// @LINE:15
case controllers_UM_updateUser5(params) => {
   call(params.fromPath[Long]("uid", None)) { (uid) =>
        invokeHandler(controllers.UM.updateUser(uid), HandlerDef(this, "controllers.UM", "updateUser", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """user/$uid<[^/]+>"""))
   }
}
        

// @LINE:16
case controllers_UM_deleteUser6(params) => {
   call(params.fromPath[Long]("uid", None)) { (uid) =>
        invokeHandler(controllers.UM.deleteUser(uid), HandlerDef(this, "controllers.UM", "deleteUser", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """user/$uid<[^/]+>"""))
   }
}
        

// @LINE:17
case controllers_UM_getSessions7(params) => {
   call { 
        invokeHandler(controllers.UM.getSessions(), HandlerDef(this, "controllers.UM", "getSessions", Nil,"GET", """""", Routes.prefix + """session"""))
   }
}
        

// @LINE:18
case controllers_UM_createSession8(params) => {
   call { 
        invokeHandler(controllers.UM.createSession(), HandlerDef(this, "controllers.UM", "createSession", Nil,"POST", """""", Routes.prefix + """session"""))
   }
}
        

// @LINE:19
case controllers_UM_updateSession9(params) => {
   call(params.fromPath[Long]("sid", None)) { (sid) =>
        invokeHandler(controllers.UM.updateSession(sid), HandlerDef(this, "controllers.UM", "updateSession", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """session/$sid<[^/]+>"""))
   }
}
        

// @LINE:20
case controllers_UM_deleteSession10(params) => {
   call(params.fromPath[Long]("sid", None)) { (sid) =>
        invokeHandler(controllers.UM.deleteSession(sid), HandlerDef(this, "controllers.UM", "deleteSession", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """session/$sid<[^/]+>"""))
   }
}
        

// @LINE:23
case controllers_PersonalReminiscence_getPerson11(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.PersonalReminiscence.getPerson(id), HandlerDef(this, "controllers.PersonalReminiscence", "getPerson", Seq(classOf[Long]),"GET", """ People, Life Stories and Timeline""", Routes.prefix + """person/$id<[^/]+>"""))
   }
}
        

// @LINE:24
case controllers_PersonalReminiscence_getPersonFriends12(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.PersonalReminiscence.getPersonFriends(id), HandlerDef(this, "controllers.PersonalReminiscence", "getPersonFriends", Seq(classOf[Long]),"GET", """""", Routes.prefix + """person/$id<[^/]+>/friends"""))
   }
}
        

// @LINE:25
case controllers_PersonalReminiscence_getPersonTimeline13(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.PersonalReminiscence.getPersonTimeline(id), HandlerDef(this, "controllers.PersonalReminiscence", "getPersonTimeline", Seq(classOf[Long]),"GET", """""", Routes.prefix + """person/$id<[^/]+>/timeline"""))
   }
}
        

// @LINE:26
case controllers_PersonalReminiscence_synchronizePersonTimeline14(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.PersonalReminiscence.synchronizePersonTimeline(id), HandlerDef(this, "controllers.PersonalReminiscence", "synchronizePersonTimeline", Seq(classOf[Long]),"POST", """""", Routes.prefix + """person/$id<[^/]+>/timeline"""))
   }
}
        

// @LINE:27
case controllers_PersonalReminiscence_getLifeStory15(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[Long]("lsid", None)) { (id, lsid) =>
        invokeHandler(controllers.PersonalReminiscence.getLifeStory(id, lsid), HandlerDef(this, "controllers.PersonalReminiscence", "getLifeStory", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>"""))
   }
}
        

// @LINE:28
case controllers_PersonalReminiscence_createLifeStory16(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.PersonalReminiscence.createLifeStory(id), HandlerDef(this, "controllers.PersonalReminiscence", "createLifeStory", Seq(classOf[Long]),"POST", """""", Routes.prefix + """person/$id<[^/]+>/lifestory"""))
   }
}
        

// @LINE:29
case controllers_PersonalReminiscence_updateLifeStory17(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[Long]("lsid", None)) { (id, lsid) =>
        invokeHandler(controllers.PersonalReminiscence.updateLifeStory(id, lsid), HandlerDef(this, "controllers.PersonalReminiscence", "updateLifeStory", Seq(classOf[Long], classOf[Long]),"PUT", """""", Routes.prefix + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>"""))
   }
}
        

// @LINE:30
case controllers_PersonalReminiscence_deleteLifeStory18(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[Long]("lsid", None)) { (id, lsid) =>
        invokeHandler(controllers.PersonalReminiscence.deleteLifeStory(id, lsid), HandlerDef(this, "controllers.PersonalReminiscence", "deleteLifeStory", Seq(classOf[Long], classOf[Long]),"DELETE", """""", Routes.prefix + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>"""))
   }
}
        

// @LINE:31
case controllers_PersonalReminiscence_getMementoAll19(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.PersonalReminiscence.getMementoAll(id), HandlerDef(this, "controllers.PersonalReminiscence", "getMementoAll", Seq(classOf[Long]),"GET", """""", Routes.prefix + """person/$id<[^/]+>/memento"""))
   }
}
        

// @LINE:32
case controllers_PersonalReminiscence_getMemento20(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[Long]("mid", None)) { (id, mid) =>
        invokeHandler(controllers.PersonalReminiscence.getMemento(id, mid), HandlerDef(this, "controllers.PersonalReminiscence", "getMemento", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """person/$id<[^/]+>/memento/$mid<[^/]+>"""))
   }
}
        

// @LINE:33
case controllers_PersonalReminiscence_createMemento21(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[Long]("mid", None)) { (id, mid) =>
        invokeHandler(controllers.PersonalReminiscence.createMemento(id, mid), HandlerDef(this, "controllers.PersonalReminiscence", "createMemento", Seq(classOf[Long], classOf[Long]),"POST", """""", Routes.prefix + """person/$id<[^/]+>/memento/$mid<[^/]+>"""))
   }
}
        

// @LINE:34
case controllers_PersonalReminiscence_updateMemento22(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[Long]("mid", None)) { (id, mid) =>
        invokeHandler(controllers.PersonalReminiscence.updateMemento(id, mid), HandlerDef(this, "controllers.PersonalReminiscence", "updateMemento", Seq(classOf[Long], classOf[Long]),"PUT", """""", Routes.prefix + """person/$id<[^/]+>/memento/$mid<[^/]+>"""))
   }
}
        

// @LINE:35
case controllers_PersonalReminiscence_deleteMemento23(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[Long]("mid", None)) { (id, mid) =>
        invokeHandler(controllers.PersonalReminiscence.deleteMemento(id, mid), HandlerDef(this, "controllers.PersonalReminiscence", "deleteMemento", Seq(classOf[Long], classOf[Long]),"DELETE", """""", Routes.prefix + """person/$id<[^/]+>/memento/$mid<[^/]+>"""))
   }
}
        

// @LINE:39
case controllers_ContextualReminiscence_getContext24(params) => {
   call(params.fromPath[Long]("cid", None)) { (cid) =>
        invokeHandler(controllers.ContextualReminiscence.getContext(cid), HandlerDef(this, "controllers.ContextualReminiscence", "getContext", Seq(classOf[Long]),"GET", """ Contextual Reminiscence""", Routes.prefix + """context/$cid<[^/]+>"""))
   }
}
        

// @LINE:40
case controllers_ContextualReminiscence_getContextCurators25(params) => {
   call(params.fromPath[Long]("cid", None)) { (cid) =>
        invokeHandler(controllers.ContextualReminiscence.getContextCurators(cid), HandlerDef(this, "controllers.ContextualReminiscence", "getContextCurators", Seq(classOf[Long]),"GET", """""", Routes.prefix + """context/$cid<[^/]+>/curators"""))
   }
}
        

// @LINE:41
case controllers_ContextualReminiscence_getContextMemento26(params) => {
   call(params.fromPath[Long]("cid", None), params.fromPath[Long]("mid", None)) { (cid, mid) =>
        invokeHandler(controllers.ContextualReminiscence.getContextMemento(cid, mid), HandlerDef(this, "controllers.ContextualReminiscence", "getContextMemento", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """context/$cid<[^/]+>/memento/$mid<[^/]+>"""))
   }
}
        

// @LINE:42
case controllers_ContextualReminiscence_createContextMemento27(params) => {
   call(params.fromPath[Long]("cid", None)) { (cid) =>
        invokeHandler(controllers.ContextualReminiscence.createContextMemento(cid), HandlerDef(this, "controllers.ContextualReminiscence", "createContextMemento", Seq(classOf[Long]),"POST", """""", Routes.prefix + """context/$cid<[^/]+>/memento"""))
   }
}
        

// @LINE:43
case controllers_ContextualReminiscence_updateContextMemento28(params) => {
   call(params.fromPath[Long]("cid", None)) { (cid) =>
        invokeHandler(controllers.ContextualReminiscence.updateContextMemento(cid), HandlerDef(this, "controllers.ContextualReminiscence", "updateContextMemento", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """context/$cid<[^/]+>/memento"""))
   }
}
        

// @LINE:44
case controllers_ContextualReminiscence_deleteContextMemento29(params) => {
   call(params.fromPath[Long]("cid", None), params.fromPath[Long]("mid", None)) { (cid, mid) =>
        invokeHandler(controllers.ContextualReminiscence.deleteContextMemento(cid, mid), HandlerDef(this, "controllers.ContextualReminiscence", "deleteContextMemento", Seq(classOf[Long], classOf[Long]),"DELETE", """""", Routes.prefix + """context/$cid<[^/]+>/memento/$mid<[^/]+>"""))
   }
}
        

// @LINE:45
case controllers_ContextualReminiscence_getContextQuestions30(params) => {
   call(params.fromPath[Long]("cid", None)) { (cid) =>
        invokeHandler(controllers.ContextualReminiscence.getContextQuestions(cid), HandlerDef(this, "controllers.ContextualReminiscence", "getContextQuestions", Seq(classOf[Long]),"GET", """""", Routes.prefix + """context/$cid<[^/]+>/question"""))
   }
}
        

// @LINE:46
case controllers_ContextualReminiscence_getContextQuestionsForDecade31(params) => {
   call(params.fromPath[Long]("cid", None), params.fromPath[Long]("decade", None)) { (cid, decade) =>
        invokeHandler(controllers.ContextualReminiscence.getContextQuestionsForDecade(cid, decade), HandlerDef(this, "controllers.ContextualReminiscence", "getContextQuestionsForDecade", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """context/$cid<[^/]+>/question/$decade<[^/]+>"""))
   }
}
        

// @LINE:47
case controllers_ContextualReminiscence_getContextQuestionsByCurators32(params) => {
   call(params.fromPath[Long]("cid", None)) { (cid) =>
        invokeHandler(controllers.ContextualReminiscence.getContextQuestionsByCurators(cid), HandlerDef(this, "controllers.ContextualReminiscence", "getContextQuestionsByCurators", Seq(classOf[Long]),"GET", """""", Routes.prefix + """context/$cid<[^/]+>/question/curated"""))
   }
}
        

// @LINE:48
case controllers_ContextualReminiscence_createContextCuratedQuestions33(params) => {
   call(params.fromPath[Long]("cid", None)) { (cid) =>
        invokeHandler(controllers.ContextualReminiscence.createContextCuratedQuestions(cid), HandlerDef(this, "controllers.ContextualReminiscence", "createContextCuratedQuestions", Seq(classOf[Long]),"POST", """""", Routes.prefix + """context/$cid<[^/]+>/question"""))
   }
}
        

// @LINE:51
case controllers_Questions_getGeneralQuestionsForYear34(params) => {
   call(params.fromPath[Long]("byear", None), params.fromPath[Long]("fyear", None), params.fromPath[String]("lang", None)) { (byear, fyear, lang) =>
        invokeHandler(controllers.Questions.getGeneralQuestionsForYear(byear, fyear, lang), HandlerDef(this, "controllers.Questions", "getGeneralQuestionsForYear", Seq(classOf[Long], classOf[Long], classOf[String]),"GET", """ General Questions""", Routes.prefix + """question/$byear<[^/]+>/$fyear<[^/]+>/$lang<[^/]+>"""))
   }
}
        

// @LINE:52
case controllers_Questions_getGeneralQuestionsForLifeChapter35(params) => {
   call(params.fromPath[String]("chapter", None), params.fromPath[String]("lang", None)) { (chapter, lang) =>
        invokeHandler(controllers.Questions.getGeneralQuestionsForLifeChapter(chapter, lang), HandlerDef(this, "controllers.Questions", "getGeneralQuestionsForLifeChapter", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """question/$chapter<[^/]+>/$lang<[^/]+>"""))
   }
}
        

// @LINE:55
case controllers_Memento_getRandomMemento36(params) => {
   call(params.fromPath[String]("lang", None)) { (lang) =>
        invokeHandler(controllers.Memento.getRandomMemento(lang), HandlerDef(this, "controllers.Memento", "getRandomMemento", Seq(classOf[String]),"GET", """ General Public Mementos API (lifecontext proxy)""", Routes.prefix + """memento/random/$lang<[^/]+>"""))
   }
}
        

// @LINE:56
case controllers_Memento_getMemento37(params) => {
   call(params.fromPath[Long]("mid", None)) { (mid) =>
        invokeHandler(controllers.Memento.getMemento(mid), HandlerDef(this, "controllers.Memento", "getMemento", Seq(classOf[Long]),"GET", """""", Routes.prefix + """memento/$mid<[^/]+>"""))
   }
}
        

// @LINE:57
case controllers_Memento_getMementoList38(params) => {
   call(params.fromPath[Long]("decade", None), params.fromPath[String]("place", None), params.fromPath[Double]("lat", None), params.fromPath[Double]("lon", None), params.fromPath[Long]("rad", None), params.fromPath[String]("lang", None)) { (decade, place, lat, lon, rad, lang) =>
        invokeHandler(controllers.Memento.getMementoList(decade, place, lat, lon, rad, lang), HandlerDef(this, "controllers.Memento", "getMementoList", Seq(classOf[Long], classOf[String], classOf[Double], classOf[Double], classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """memento/$decade<[^/]+>/$place<[^/]+>/$lat<[^/]+>/$lon<[^/]+>/$rad<[^/]+>/$lang<[^/]+>"""))
   }
}
        
}
    
}
        