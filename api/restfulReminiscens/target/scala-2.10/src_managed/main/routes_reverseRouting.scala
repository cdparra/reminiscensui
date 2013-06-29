// @SOURCE:/Users/cristhian/Projects/lifeparticipation/reminiscens/explorelife/api/restfulReminiscens/conf/routes
// @HASH:1c282d46196798cebb7ac6a5e7088666b3996384
// @DATE:Fri Jun 28 19:26:46 CEST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:52
// @LINE:51
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseMemento {
    

// @LINE:56
def getMemento(mid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "memento/" + implicitly[PathBindable[Long]].unbind("mid", mid))
}
                                                

// @LINE:55
def getRandomMemento(lang:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "memento/random/" + implicitly[PathBindable[String]].unbind("lang", lang))
}
                                                

// @LINE:57
def getMementoList(decade:Long, place:String, lat:Double, lon:Double, rad:Long, lang:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "memento/" + implicitly[PathBindable[Long]].unbind("decade", decade) + "/" + implicitly[PathBindable[String]].unbind("place", place) + "/" + implicitly[PathBindable[Double]].unbind("lat", lat) + "/" + implicitly[PathBindable[Double]].unbind("lon", lon) + "/" + implicitly[PathBindable[Long]].unbind("rad", rad) + "/" + implicitly[PathBindable[String]].unbind("lang", lang))
}
                                                
    
}
                          

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseUM {
    

// @LINE:13
def getUser(uid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("uid", uid))
}
                                                

// @LINE:16
def deleteUser(uid:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("uid", uid))
}
                                                

// @LINE:20
def deleteSession(sid:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "session/" + implicitly[PathBindable[Long]].unbind("sid", sid))
}
                                                

// @LINE:18
def createSession(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "session")
}
                                                

// @LINE:12
def getUsers(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user")
}
                                                

// @LINE:17
def getSessions(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "session")
}
                                                

// @LINE:15
def updateUser(uid:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[Long]].unbind("uid", uid))
}
                                                

// @LINE:19
def updateSession(sid:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "session/" + implicitly[PathBindable[Long]].unbind("sid", sid))
}
                                                

// @LINE:14
def createUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user")
}
                                                
    
}
                          

// @LINE:52
// @LINE:51
class ReverseQuestions {
    

// @LINE:51
def getGeneralQuestionsForYear(byear:Long, fyear:Long, lang:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "question/" + implicitly[PathBindable[Long]].unbind("byear", byear) + "/" + implicitly[PathBindable[Long]].unbind("fyear", fyear) + "/" + implicitly[PathBindable[String]].unbind("lang", lang))
}
                                                

// @LINE:52
def getGeneralQuestionsForLifeChapter(chapter:String, lang:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "question/" + implicitly[PathBindable[String]].unbind("chapter", chapter) + "/" + implicitly[PathBindable[String]].unbind("lang", lang))
}
                                                
    
}
                          

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReverseContextualReminiscence {
    

// @LINE:47
def getContextQuestionsByCurators(cid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/question/curated")
}
                                                

// @LINE:41
def getContextMemento(cid:Long, mid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/memento/" + implicitly[PathBindable[Long]].unbind("mid", mid))
}
                                                

// @LINE:42
def createContextMemento(cid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/memento")
}
                                                

// @LINE:43
def updateContextMemento(cid:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/memento")
}
                                                

// @LINE:46
def getContextQuestionsForDecade(cid:Long, decade:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/question/" + implicitly[PathBindable[Long]].unbind("decade", decade))
}
                                                

// @LINE:39
def getContext(cid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid))
}
                                                

// @LINE:44
def deleteContextMemento(cid:Long, mid:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/memento/" + implicitly[PathBindable[Long]].unbind("mid", mid))
}
                                                

// @LINE:48
def createContextCuratedQuestions(cid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/question")
}
                                                

// @LINE:40
def getContextCurators(cid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/curators")
}
                                                

// @LINE:45
def getContextQuestions(cid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "context/" + implicitly[PathBindable[Long]].unbind("cid", cid) + "/question")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReversePersonalReminiscence {
    

// @LINE:23
def getPerson(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:34
def updateMemento(id:Long, mid:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/memento/" + implicitly[PathBindable[Long]].unbind("mid", mid))
}
                                                

// @LINE:31
def getMementoAll(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/memento")
}
                                                

// @LINE:30
def deleteLifeStory(id:Long, lsid:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/lifestory/" + implicitly[PathBindable[Long]].unbind("lsid", lsid))
}
                                                

// @LINE:29
def updateLifeStory(id:Long, lsid:Long): Call = {
   Call("PUT", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/lifestory/" + implicitly[PathBindable[Long]].unbind("lsid", lsid))
}
                                                

// @LINE:32
def getMemento(id:Long, mid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/memento/" + implicitly[PathBindable[Long]].unbind("mid", mid))
}
                                                

// @LINE:35
def deleteMemento(id:Long, mid:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/memento/" + implicitly[PathBindable[Long]].unbind("mid", mid))
}
                                                

// @LINE:24
def getPersonFriends(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/friends")
}
                                                

// @LINE:27
def getLifeStory(id:Long, lsid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/lifestory/" + implicitly[PathBindable[Long]].unbind("lsid", lsid))
}
                                                

// @LINE:33
def createMemento(id:Long, mid:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/memento/" + implicitly[PathBindable[Long]].unbind("mid", mid))
}
                                                

// @LINE:25
def getPersonTimeline(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/timeline")
}
                                                

// @LINE:28
def createLifeStory(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/lifestory")
}
                                                

// @LINE:26
def synchronizePersonTimeline(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[Long]].unbind("id", id) + "/timeline")
}
                                                
    
}
                          
}
                  


// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:52
// @LINE:51
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseMemento {
    

// @LINE:56
def getMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Memento.getMemento",
   """
      function(mid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "memento/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid)})
      }
   """
)
                        

// @LINE:55
def getRandomMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Memento.getRandomMemento",
   """
      function(lang) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "memento/random/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("lang", lang)})
      }
   """
)
                        

// @LINE:57
def getMementoList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Memento.getMementoList",
   """
      function(decade,place,lat,lon,rad,lang) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "memento/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("decade", decade) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("place", place) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("lat", lat) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("lon", lon) + "/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("rad", rad) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("lang", lang)})
      }
   """
)
                        
    
}
              

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseUM {
    

// @LINE:13
def getUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.getUser",
   """
      function(uid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("uid", uid)})
      }
   """
)
                        

// @LINE:16
def deleteUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.deleteUser",
   """
      function(uid) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("uid", uid)})
      }
   """
)
                        

// @LINE:20
def deleteSession : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.deleteSession",
   """
      function(sid) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "session/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid)})
      }
   """
)
                        

// @LINE:18
def createSession : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.createSession",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "session"})
      }
   """
)
                        

// @LINE:12
def getUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.getUsers",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        

// @LINE:17
def getSessions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.getSessions",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "session"})
      }
   """
)
                        

// @LINE:15
def updateUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.updateUser",
   """
      function(uid) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("uid", uid)})
      }
   """
)
                        

// @LINE:19
def updateSession : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.updateSession",
   """
      function(sid) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "session/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid)})
      }
   """
)
                        

// @LINE:14
def createUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UM.createUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        
    
}
              

// @LINE:52
// @LINE:51
class ReverseQuestions {
    

// @LINE:51
def getGeneralQuestionsForYear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Questions.getGeneralQuestionsForYear",
   """
      function(byear,fyear,lang) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "question/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("byear", byear) + "/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("fyear", fyear) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("lang", lang)})
      }
   """
)
                        

// @LINE:52
def getGeneralQuestionsForLifeChapter : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Questions.getGeneralQuestionsForLifeChapter",
   """
      function(chapter,lang) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "question/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("chapter", chapter) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("lang", lang)})
      }
   """
)
                        
    
}
              

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReverseContextualReminiscence {
    

// @LINE:47
def getContextQuestionsByCurators : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.getContextQuestionsByCurators",
   """
      function(cid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/question/curated"})
      }
   """
)
                        

// @LINE:41
def getContextMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.getContextMemento",
   """
      function(cid,mid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/memento/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid)})
      }
   """
)
                        

// @LINE:42
def createContextMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.createContextMemento",
   """
      function(cid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/memento"})
      }
   """
)
                        

// @LINE:43
def updateContextMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.updateContextMemento",
   """
      function(cid) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/memento"})
      }
   """
)
                        

// @LINE:46
def getContextQuestionsForDecade : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.getContextQuestionsForDecade",
   """
      function(cid,decade) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/question/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("decade", decade)})
      }
   """
)
                        

// @LINE:39
def getContext : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.getContext",
   """
      function(cid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid)})
      }
   """
)
                        

// @LINE:44
def deleteContextMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.deleteContextMemento",
   """
      function(cid,mid) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/memento/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid)})
      }
   """
)
                        

// @LINE:48
def createContextCuratedQuestions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.createContextCuratedQuestions",
   """
      function(cid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/question"})
      }
   """
)
                        

// @LINE:40
def getContextCurators : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.getContextCurators",
   """
      function(cid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/curators"})
      }
   """
)
                        

// @LINE:45
def getContextQuestions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ContextualReminiscence.getContextQuestions",
   """
      function(cid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "context/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("cid", cid) + "/question"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReversePersonalReminiscence {
    

// @LINE:23
def getPerson : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.getPerson",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:34
def updateMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.updateMemento",
   """
      function(id,mid) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/memento/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid)})
      }
   """
)
                        

// @LINE:31
def getMementoAll : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.getMementoAll",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/memento"})
      }
   """
)
                        

// @LINE:30
def deleteLifeStory : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.deleteLifeStory",
   """
      function(id,lsid) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/lifestory/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("lsid", lsid)})
      }
   """
)
                        

// @LINE:29
def updateLifeStory : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.updateLifeStory",
   """
      function(id,lsid) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/lifestory/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("lsid", lsid)})
      }
   """
)
                        

// @LINE:32
def getMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.getMemento",
   """
      function(id,mid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/memento/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid)})
      }
   """
)
                        

// @LINE:35
def deleteMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.deleteMemento",
   """
      function(id,mid) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/memento/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid)})
      }
   """
)
                        

// @LINE:24
def getPersonFriends : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.getPersonFriends",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/friends"})
      }
   """
)
                        

// @LINE:27
def getLifeStory : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.getLifeStory",
   """
      function(id,lsid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/lifestory/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("lsid", lsid)})
      }
   """
)
                        

// @LINE:33
def createMemento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.createMemento",
   """
      function(id,mid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/memento/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid)})
      }
   """
)
                        

// @LINE:25
def getPersonTimeline : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.getPersonTimeline",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/timeline"})
      }
   """
)
                        

// @LINE:28
def createLifeStory : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.createLifeStory",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/lifestory"})
      }
   """
)
                        

// @LINE:26
def synchronizePersonTimeline : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PersonalReminiscence.synchronizePersonTimeline",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/timeline"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:52
// @LINE:51
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:57
// @LINE:56
// @LINE:55
class ReverseMemento {
    

// @LINE:56
def getMemento(mid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Memento.getMemento(mid), HandlerDef(this, "controllers.Memento", "getMemento", Seq(classOf[Long]), "GET", """""", _prefix + """memento/$mid<[^/]+>""")
)
                      

// @LINE:55
def getRandomMemento(lang:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Memento.getRandomMemento(lang), HandlerDef(this, "controllers.Memento", "getRandomMemento", Seq(classOf[String]), "GET", """ General Public Mementos API (lifecontext proxy)""", _prefix + """memento/random/$lang<[^/]+>""")
)
                      

// @LINE:57
def getMementoList(decade:Long, place:String, lat:Double, lon:Double, rad:Long, lang:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Memento.getMementoList(decade, place, lat, lon, rad, lang), HandlerDef(this, "controllers.Memento", "getMementoList", Seq(classOf[Long], classOf[String], classOf[Double], classOf[Double], classOf[Long], classOf[String]), "GET", """""", _prefix + """memento/$decade<[^/]+>/$place<[^/]+>/$lat<[^/]+>/$lon<[^/]+>/$rad<[^/]+>/$lang<[^/]+>""")
)
                      
    
}
                          

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseUM {
    

// @LINE:13
def getUser(uid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.getUser(uid), HandlerDef(this, "controllers.UM", "getUser", Seq(classOf[Long]), "GET", """""", _prefix + """user/$uid<[^/]+>""")
)
                      

// @LINE:16
def deleteUser(uid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.deleteUser(uid), HandlerDef(this, "controllers.UM", "deleteUser", Seq(classOf[Long]), "DELETE", """""", _prefix + """user/$uid<[^/]+>""")
)
                      

// @LINE:20
def deleteSession(sid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.deleteSession(sid), HandlerDef(this, "controllers.UM", "deleteSession", Seq(classOf[Long]), "DELETE", """""", _prefix + """session/$sid<[^/]+>""")
)
                      

// @LINE:18
def createSession(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.createSession(), HandlerDef(this, "controllers.UM", "createSession", Seq(), "POST", """""", _prefix + """session""")
)
                      

// @LINE:12
def getUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.getUsers(), HandlerDef(this, "controllers.UM", "getUsers", Seq(), "GET", """ User and Session Management""", _prefix + """user""")
)
                      

// @LINE:17
def getSessions(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.getSessions(), HandlerDef(this, "controllers.UM", "getSessions", Seq(), "GET", """""", _prefix + """session""")
)
                      

// @LINE:15
def updateUser(uid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.updateUser(uid), HandlerDef(this, "controllers.UM", "updateUser", Seq(classOf[Long]), "PUT", """""", _prefix + """user/$uid<[^/]+>""")
)
                      

// @LINE:19
def updateSession(sid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.updateSession(sid), HandlerDef(this, "controllers.UM", "updateSession", Seq(classOf[Long]), "PUT", """""", _prefix + """session/$sid<[^/]+>""")
)
                      

// @LINE:14
def createUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UM.createUser(), HandlerDef(this, "controllers.UM", "createUser", Seq(), "POST", """""", _prefix + """user""")
)
                      
    
}
                          

// @LINE:52
// @LINE:51
class ReverseQuestions {
    

// @LINE:51
def getGeneralQuestionsForYear(byear:Long, fyear:Long, lang:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Questions.getGeneralQuestionsForYear(byear, fyear, lang), HandlerDef(this, "controllers.Questions", "getGeneralQuestionsForYear", Seq(classOf[Long], classOf[Long], classOf[String]), "GET", """ General Questions""", _prefix + """question/$byear<[^/]+>/$fyear<[^/]+>/$lang<[^/]+>""")
)
                      

// @LINE:52
def getGeneralQuestionsForLifeChapter(chapter:String, lang:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Questions.getGeneralQuestionsForLifeChapter(chapter, lang), HandlerDef(this, "controllers.Questions", "getGeneralQuestionsForLifeChapter", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """question/$chapter<[^/]+>/$lang<[^/]+>""")
)
                      
    
}
                          

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReverseContextualReminiscence {
    

// @LINE:47
def getContextQuestionsByCurators(cid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.getContextQuestionsByCurators(cid), HandlerDef(this, "controllers.ContextualReminiscence", "getContextQuestionsByCurators", Seq(classOf[Long]), "GET", """""", _prefix + """context/$cid<[^/]+>/question/curated""")
)
                      

// @LINE:41
def getContextMemento(cid:Long, mid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.getContextMemento(cid, mid), HandlerDef(this, "controllers.ContextualReminiscence", "getContextMemento", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """context/$cid<[^/]+>/memento/$mid<[^/]+>""")
)
                      

// @LINE:42
def createContextMemento(cid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.createContextMemento(cid), HandlerDef(this, "controllers.ContextualReminiscence", "createContextMemento", Seq(classOf[Long]), "POST", """""", _prefix + """context/$cid<[^/]+>/memento""")
)
                      

// @LINE:43
def updateContextMemento(cid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.updateContextMemento(cid), HandlerDef(this, "controllers.ContextualReminiscence", "updateContextMemento", Seq(classOf[Long]), "PUT", """""", _prefix + """context/$cid<[^/]+>/memento""")
)
                      

// @LINE:46
def getContextQuestionsForDecade(cid:Long, decade:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.getContextQuestionsForDecade(cid, decade), HandlerDef(this, "controllers.ContextualReminiscence", "getContextQuestionsForDecade", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """context/$cid<[^/]+>/question/$decade<[^/]+>""")
)
                      

// @LINE:39
def getContext(cid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.getContext(cid), HandlerDef(this, "controllers.ContextualReminiscence", "getContext", Seq(classOf[Long]), "GET", """ Contextual Reminiscence""", _prefix + """context/$cid<[^/]+>""")
)
                      

// @LINE:44
def deleteContextMemento(cid:Long, mid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.deleteContextMemento(cid, mid), HandlerDef(this, "controllers.ContextualReminiscence", "deleteContextMemento", Seq(classOf[Long], classOf[Long]), "DELETE", """""", _prefix + """context/$cid<[^/]+>/memento/$mid<[^/]+>""")
)
                      

// @LINE:48
def createContextCuratedQuestions(cid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.createContextCuratedQuestions(cid), HandlerDef(this, "controllers.ContextualReminiscence", "createContextCuratedQuestions", Seq(classOf[Long]), "POST", """""", _prefix + """context/$cid<[^/]+>/question""")
)
                      

// @LINE:40
def getContextCurators(cid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.getContextCurators(cid), HandlerDef(this, "controllers.ContextualReminiscence", "getContextCurators", Seq(classOf[Long]), "GET", """""", _prefix + """context/$cid<[^/]+>/curators""")
)
                      

// @LINE:45
def getContextQuestions(cid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ContextualReminiscence.getContextQuestions(cid), HandlerDef(this, "controllers.ContextualReminiscence", "getContextQuestions", Seq(classOf[Long]), "GET", """""", _prefix + """context/$cid<[^/]+>/question""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReversePersonalReminiscence {
    

// @LINE:23
def getPerson(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.getPerson(id), HandlerDef(this, "controllers.PersonalReminiscence", "getPerson", Seq(classOf[Long]), "GET", """ People, Life Stories and Timeline""", _prefix + """person/$id<[^/]+>""")
)
                      

// @LINE:34
def updateMemento(id:Long, mid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.updateMemento(id, mid), HandlerDef(this, "controllers.PersonalReminiscence", "updateMemento", Seq(classOf[Long], classOf[Long]), "PUT", """""", _prefix + """person/$id<[^/]+>/memento/$mid<[^/]+>""")
)
                      

// @LINE:31
def getMementoAll(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.getMementoAll(id), HandlerDef(this, "controllers.PersonalReminiscence", "getMementoAll", Seq(classOf[Long]), "GET", """""", _prefix + """person/$id<[^/]+>/memento""")
)
                      

// @LINE:30
def deleteLifeStory(id:Long, lsid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.deleteLifeStory(id, lsid), HandlerDef(this, "controllers.PersonalReminiscence", "deleteLifeStory", Seq(classOf[Long], classOf[Long]), "DELETE", """""", _prefix + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>""")
)
                      

// @LINE:29
def updateLifeStory(id:Long, lsid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.updateLifeStory(id, lsid), HandlerDef(this, "controllers.PersonalReminiscence", "updateLifeStory", Seq(classOf[Long], classOf[Long]), "PUT", """""", _prefix + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>""")
)
                      

// @LINE:32
def getMemento(id:Long, mid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.getMemento(id, mid), HandlerDef(this, "controllers.PersonalReminiscence", "getMemento", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """person/$id<[^/]+>/memento/$mid<[^/]+>""")
)
                      

// @LINE:35
def deleteMemento(id:Long, mid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.deleteMemento(id, mid), HandlerDef(this, "controllers.PersonalReminiscence", "deleteMemento", Seq(classOf[Long], classOf[Long]), "DELETE", """""", _prefix + """person/$id<[^/]+>/memento/$mid<[^/]+>""")
)
                      

// @LINE:24
def getPersonFriends(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.getPersonFriends(id), HandlerDef(this, "controllers.PersonalReminiscence", "getPersonFriends", Seq(classOf[Long]), "GET", """""", _prefix + """person/$id<[^/]+>/friends""")
)
                      

// @LINE:27
def getLifeStory(id:Long, lsid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.getLifeStory(id, lsid), HandlerDef(this, "controllers.PersonalReminiscence", "getLifeStory", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """person/$id<[^/]+>/lifestory/$lsid<[^/]+>""")
)
                      

// @LINE:33
def createMemento(id:Long, mid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.createMemento(id, mid), HandlerDef(this, "controllers.PersonalReminiscence", "createMemento", Seq(classOf[Long], classOf[Long]), "POST", """""", _prefix + """person/$id<[^/]+>/memento/$mid<[^/]+>""")
)
                      

// @LINE:25
def getPersonTimeline(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.getPersonTimeline(id), HandlerDef(this, "controllers.PersonalReminiscence", "getPersonTimeline", Seq(classOf[Long]), "GET", """""", _prefix + """person/$id<[^/]+>/timeline""")
)
                      

// @LINE:28
def createLifeStory(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.createLifeStory(id), HandlerDef(this, "controllers.PersonalReminiscence", "createLifeStory", Seq(classOf[Long]), "POST", """""", _prefix + """person/$id<[^/]+>/lifestory""")
)
                      

// @LINE:26
def synchronizePersonTimeline(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PersonalReminiscence.synchronizePersonTimeline(id), HandlerDef(this, "controllers.PersonalReminiscence", "synchronizePersonTimeline", Seq(classOf[Long]), "POST", """""", _prefix + """person/$id<[^/]+>/timeline""")
)
                      
    
}
                          
}
                  
      