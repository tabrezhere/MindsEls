// @SOURCE:E:/PlayWorkspace/tabrez/test jar/Eonline_22_15_tab/Eonline_22_15_tab/conf/routes
// @HASH:f1f71601291a1f113f3ddc5cce02ae89daf20fb5
// @DATE:Tue Dec 15 17:47:28 IST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:7
private[this] lazy val controllers_ApplicationController_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_ApplicationController_index0_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ApplicationController]).index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "index", Nil,"GET", """""", Routes.prefix + """"""))
        

// @LINE:11
private[this] lazy val controllers_RestUserController_authenticate1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signin/credentials"))))
private[this] lazy val controllers_RestUserController_authenticate1_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).authenticate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "authenticate", Nil,"POST", """ Login/SignUp""", Routes.prefix + """auth/signin/credentials"""))
        

// @LINE:12
private[this] lazy val controllers_RestSignUpController_signUpForCampusAdmin2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signUpForCampusAdmin"))))
private[this] lazy val controllers_RestSignUpController_signUpForCampusAdmin2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForCampusAdmin,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForCampusAdmin", Nil,"POST", """""", Routes.prefix + """auth/signUpForCampusAdmin"""))
        

// @LINE:13
private[this] lazy val controllers_RestSignUpController_signUp3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signup"))))
private[this] lazy val controllers_RestSignUpController_signUp3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUp,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUp", Nil,"POST", """""", Routes.prefix + """auth/signup"""))
        

// @LINE:14
private[this] lazy val controllers_RestSignUpController_signUpForStudent4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signUpForStudent"))))
private[this] lazy val controllers_RestSignUpController_signUpForStudent4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForStudent,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForStudent", Nil,"POST", """""", Routes.prefix + """auth/signUpForStudent"""))
        

// @LINE:15
private[this] lazy val controllers_RestSignUpController_signUpForGuardian5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signUpForGuardian"))))
private[this] lazy val controllers_RestSignUpController_signUpForGuardian5_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForGuardian,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForGuardian", Nil,"POST", """""", Routes.prefix + """auth/signUpForGuardian"""))
        

// @LINE:16
private[this] lazy val controllers_RestSignUpController_signUpForStaff6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signUpForStaff"))))
private[this] lazy val controllers_RestSignUpController_signUpForStaff6_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForStaff,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForStaff", Nil,"POST", """""", Routes.prefix + """auth/signUpForStaff"""))
        

// @LINE:17
private[this] lazy val controllers_RestSignUpController_signUpForDriver7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signUpForDriver"))))
private[this] lazy val controllers_RestSignUpController_signUpForDriver7_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForDriver,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForDriver", Nil,"POST", """""", Routes.prefix + """auth/signUpForDriver"""))
        

// @LINE:18
private[this] lazy val controllers_RestSignUpController_createVehicleCompleteDetail8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/createVehicleDetail"))))
private[this] lazy val controllers_RestSignUpController_createVehicleCompleteDetail8_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createVehicleCompleteDetail,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "createVehicleCompleteDetail", Nil,"POST", """""", Routes.prefix + """auth/createVehicleDetail"""))
        

// @LINE:19
private[this] lazy val controllers_RestSignUpController_signUpForLibrarian9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signUpForLibrarian"))))
private[this] lazy val controllers_RestSignUpController_signUpForLibrarian9_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForLibrarian,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForLibrarian", Nil,"POST", """""", Routes.prefix + """auth/signUpForLibrarian"""))
        

// @LINE:20
private[this] lazy val controllers_RestSignUpController_createbook10_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/createbook"))))
private[this] lazy val controllers_RestSignUpController_createbook10_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createbook,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "createbook", Nil,"POST", """""", Routes.prefix + """auth/createbook"""))
        

// @LINE:21
private[this] lazy val controllers_RestSignUpController_medicalCreate11_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/medicalCreate"))))
private[this] lazy val controllers_RestSignUpController_medicalCreate11_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).medicalCreate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "medicalCreate", Nil,"POST", """""", Routes.prefix + """auth/medicalCreate"""))
        

// @LINE:22
private[this] lazy val controllers_RestSignUpController_campusCreate12_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/campusCreate"))))
private[this] lazy val controllers_RestSignUpController_campusCreate12_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusCreate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "campusCreate", Nil,"POST", """""", Routes.prefix + """auth/campusCreate"""))
        

// @LINE:23
private[this] lazy val controllers_RestSignUpController_signOut13_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/signout"))))
private[this] lazy val controllers_RestSignUpController_signOut13_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signOut,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signOut", Nil,"POST", """""", Routes.prefix + """auth/signout"""))
        

// @LINE:24
private[this] lazy val controllers_RestSignUpController_bookIssue14_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/bookIssue"))))
private[this] lazy val controllers_RestSignUpController_bookIssue14_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookIssue,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "bookIssue", Nil,"POST", """""", Routes.prefix + """auth/bookIssue"""))
        

// @LINE:25
private[this] lazy val controllers_RestSignUpController_assignmentcreate15_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/assignmentcreate"))))
private[this] lazy val controllers_RestSignUpController_assignmentcreate15_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).assignmentcreate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "assignmentcreate", Nil,"POST", """""", Routes.prefix + """auth/assignmentcreate"""))
        

// @LINE:26
private[this] lazy val controllers_RestSignUpController_eventCreate16_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/eventcreate"))))
private[this] lazy val controllers_RestSignUpController_eventCreate16_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).eventCreate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "eventCreate", Nil,"POST", """""", Routes.prefix + """auth/eventcreate"""))
        

// @LINE:27
private[this] lazy val controllers_RestSignUpController_schoolNews17_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/schoolNews"))))
private[this] lazy val controllers_RestSignUpController_schoolNews17_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).schoolNews,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "schoolNews", Nil,"POST", """""", Routes.prefix + """auth/schoolNews"""))
        

// @LINE:28
private[this] lazy val controllers_RestSignUpController_exam18_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/exam"))))
private[this] lazy val controllers_RestSignUpController_exam18_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).exam,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "exam", Nil,"POST", """""", Routes.prefix + """auth/exam"""))
        

// @LINE:29
private[this] lazy val controllers_RestSignUpController_marks19_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/marks"))))
private[this] lazy val controllers_RestSignUpController_marks19_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).marks,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "marks", Nil,"POST", """""", Routes.prefix + """auth/marks"""))
        

// @LINE:30
private[this] lazy val controllers_RestSignUpController_StaffClassMapping20_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/staffClassMapping"))))
private[this] lazy val controllers_RestSignUpController_StaffClassMapping20_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).StaffClassMapping,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "StaffClassMapping", Nil,"POST", """""", Routes.prefix + """auth/staffClassMapping"""))
        

// @LINE:31
private[this] lazy val controllers_RestSignUpController_campusUpdate21_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/campusUpdate"))))
private[this] lazy val controllers_RestSignUpController_campusUpdate21_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "campusUpdate", Nil,"POST", """""", Routes.prefix + """auth/campusUpdate"""))
        

// @LINE:32
private[this] lazy val controllers_RestSignUpController_organizationUpdate22_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/organizationUpdate"))))
private[this] lazy val controllers_RestSignUpController_organizationUpdate22_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).organizationUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "organizationUpdate", Nil,"POST", """""", Routes.prefix + """auth/organizationUpdate"""))
        

// @LINE:33
private[this] lazy val controllers_RestSignUpController_assignmentUpdate23_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/assignmentUpdate"))))
private[this] lazy val controllers_RestSignUpController_assignmentUpdate23_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).assignmentUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "assignmentUpdate", Nil,"POST", """""", Routes.prefix + """auth/assignmentUpdate"""))
        

// @LINE:34
private[this] lazy val controllers_RestSignUpController_holidayUpdate24_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/holidayUpdate"))))
private[this] lazy val controllers_RestSignUpController_holidayUpdate24_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).holidayUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "holidayUpdate", Nil,"POST", """""", Routes.prefix + """auth/holidayUpdate"""))
        

// @LINE:35
private[this] lazy val controllers_RestSignUpController_schoolUpdate25_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/schoolUpdate"))))
private[this] lazy val controllers_RestSignUpController_schoolUpdate25_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).schoolUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "schoolUpdate", Nil,"POST", """""", Routes.prefix + """auth/schoolUpdate"""))
        

// @LINE:36
private[this] lazy val controllers_RestSignUpController_newsUpdate26_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/newsUpdate"))))
private[this] lazy val controllers_RestSignUpController_newsUpdate26_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).newsUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "newsUpdate", Nil,"POST", """""", Routes.prefix + """auth/newsUpdate"""))
        

// @LINE:37
private[this] lazy val controllers_RestSignUpController_eventUpdate27_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/eventUpdate"))))
private[this] lazy val controllers_RestSignUpController_eventUpdate27_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).eventUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "eventUpdate", Nil,"POST", """""", Routes.prefix + """auth/eventUpdate"""))
        

// @LINE:38
private[this] lazy val controllers_RestSignUpController_marksUpdate28_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/marksUpdate"))))
private[this] lazy val controllers_RestSignUpController_marksUpdate28_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).marksUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "marksUpdate", Nil,"POST", """""", Routes.prefix + """auth/marksUpdate"""))
        

// @LINE:39
private[this] lazy val controllers_RestSignUpController_medicalUpdate29_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/medicalUpdate"))))
private[this] lazy val controllers_RestSignUpController_medicalUpdate29_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).medicalUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "medicalUpdate", Nil,"POST", """""", Routes.prefix + """auth/medicalUpdate"""))
        

// @LINE:40
private[this] lazy val controllers_RestSignUpController_bookUpdate30_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/bookUpdate"))))
private[this] lazy val controllers_RestSignUpController_bookUpdate30_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "bookUpdate", Nil,"POST", """""", Routes.prefix + """auth/bookUpdate"""))
        

// @LINE:41
private[this] lazy val controllers_RestSignUpController_bookIssueUpdate31_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/bookIssueUpdate"))))
private[this] lazy val controllers_RestSignUpController_bookIssueUpdate31_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookIssueUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "bookIssueUpdate", Nil,"POST", """""", Routes.prefix + """auth/bookIssueUpdate"""))
        

// @LINE:42
private[this] lazy val controllers_RestSignUpController_librarianUpdate32_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/librarianUpdate"))))
private[this] lazy val controllers_RestSignUpController_librarianUpdate32_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).librarianUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "librarianUpdate", Nil,"POST", """""", Routes.prefix + """auth/librarianUpdate"""))
        

// @LINE:43
private[this] lazy val controllers_RestSignUpController_driverUpdate33_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/driverUpdate"))))
private[this] lazy val controllers_RestSignUpController_driverUpdate33_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).driverUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "driverUpdate", Nil,"POST", """""", Routes.prefix + """auth/driverUpdate"""))
        

// @LINE:44
private[this] lazy val controllers_RestSignUpController_campusadminUpdate34_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/campusadminUpdate"))))
private[this] lazy val controllers_RestSignUpController_campusadminUpdate34_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusadminUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "campusadminUpdate", Nil,"POST", """""", Routes.prefix + """auth/campusadminUpdate"""))
        

// @LINE:45
private[this] lazy val controllers_RestSignUpController_staffUpdate35_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/staffUpdate"))))
private[this] lazy val controllers_RestSignUpController_staffUpdate35_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).staffUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "staffUpdate", Nil,"POST", """""", Routes.prefix + """auth/staffUpdate"""))
        

// @LINE:46
private[this] lazy val controllers_RestSignUpController_guardianUpdate36_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/guardianUpdate"))))
private[this] lazy val controllers_RestSignUpController_guardianUpdate36_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).guardianUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "guardianUpdate", Nil,"POST", """""", Routes.prefix + """auth/guardianUpdate"""))
        

// @LINE:47
private[this] lazy val controllers_RestSignUpController_studentUpdate37_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/studentUpdate"))))
private[this] lazy val controllers_RestSignUpController_studentUpdate37_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).studentUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "studentUpdate", Nil,"POST", """""", Routes.prefix + """auth/studentUpdate"""))
        

// @LINE:48
private[this] lazy val controllers_RestSignUpController_vehicleUpdate38_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/vehicleUpdate"))))
private[this] lazy val controllers_RestSignUpController_vehicleUpdate38_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).vehicleUpdate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "vehicleUpdate", Nil,"POST", """""", Routes.prefix + """auth/vehicleUpdate"""))
        

// @LINE:51
private[this] lazy val controllers_RestSignUpController_uploadfile39_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/fileupload"))))
private[this] lazy val controllers_RestSignUpController_uploadfile39_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).uploadfile,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "uploadfile", Nil,"POST", """POST    /upload          								 @controllers.RestSignUpController.upload
POST    /auth/createFileUpload                          @controllers.RestSignUpController.upload""", Routes.prefix + """auth/fileupload"""))
        

// @LINE:52
private[this] lazy val controllers_RestSignUpController_sendSMS40_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/sendSMS"))))
private[this] lazy val controllers_RestSignUpController_sendSMS40_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).sendSMS,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "sendSMS", Nil,"POST", """""", Routes.prefix + """auth/sendSMS"""))
        

// @LINE:53
private[this] lazy val controllers_RestSignUpController_createResultByStdAdmNum41_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/createResultByStdAdmNum/"),DynamicPart("stdAdmNum", """[^/]+""",true))))
private[this] lazy val controllers_RestSignUpController_createResultByStdAdmNum41_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createResultByStdAdmNum(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "createResultByStdAdmNum", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/createResultByStdAdmNum/$stdAdmNum<[^/]+>"""))
        

// @LINE:58
private[this] lazy val controllers_MiscController_getUserRolesList42_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/userRoles"))))
private[this] lazy val controllers_MiscController_getUserRolesList42_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getUserRolesList,
HandlerDef(this.getClass.getClassLoader, "", "controllers.MiscController", "getUserRolesList", Nil,"GET", """GET/auth/createStudentAttendance/:attendanceUserList    @controllers.RestSignUpController.createStudentAttendance(attendanceUserList : List[AttendanceUser])""", Routes.prefix + """auth/userRoles"""))
        

// @LINE:59
private[this] lazy val controllers_MiscController_getAllOrganization43_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAllOganization"))))
private[this] lazy val controllers_MiscController_getAllOrganization43_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getAllOrganization,
HandlerDef(this.getClass.getClassLoader, "", "controllers.MiscController", "getAllOrganization", Nil,"GET", """""", Routes.prefix + """auth/getAllOganization"""))
        

// @LINE:60
private[this] lazy val controllers_MiscController_getAllCampusByOrganizationId44_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAllCampusByOrganizationId/"),DynamicPart("orgId", """[^/]+""",true))))
private[this] lazy val controllers_MiscController_getAllCampusByOrganizationId44_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getAllCampusByOrganizationId(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.MiscController", "getAllCampusByOrganizationId", Seq(classOf[Int]),"GET", """""", Routes.prefix + """auth/getAllCampusByOrganizationId/$orgId<[^/]+>"""))
        

// @LINE:61
private[this] lazy val controllers_RestUserController_getUserById45_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getUserById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getUserById45_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getUserById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getUserById/$id<[^/]+>"""))
        

// @LINE:62
private[this] lazy val controllers_RestUserController_getUserLoginByEmail46_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getUserLoginByEmail/"),DynamicPart("email", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getUserLoginByEmail46_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserLoginByEmail(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getUserLoginByEmail", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getUserLoginByEmail/$email<[^/]+>"""))
        

// @LINE:63
private[this] lazy val controllers_RestUserController_getUserContextById47_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getUserContextById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getUserContextById47_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserContextById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getUserContextById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getUserContextById/$id<[^/]+>"""))
        

// @LINE:64
private[this] lazy val controllers_RestUserController_getContextById48_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getContextById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getContextById48_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getContextById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getContextById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getContextById/$id<[^/]+>"""))
        

// @LINE:65
private[this] lazy val controllers_RestUserController_getStaffDetailById49_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStaffDetailsById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStaffDetailById49_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffDetailById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffDetailById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStaffDetailsById/$id<[^/]+>"""))
        

// @LINE:66
private[this] lazy val controllers_RestUserController_getStudentDetailsById50_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentDetailsById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentDetailsById50_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentDetailsById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentDetailsById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStudentDetailsById/$id<[^/]+>"""))
        

// @LINE:67
private[this] lazy val controllers_RestUserController_getStudentUserByFirstname51_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentUserByFirstname/"),DynamicPart("Firstname", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentUserByFirstname51_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserByFirstname(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentUserByFirstname", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getStudentUserByFirstname/$Firstname<[^/]+>"""))
        

// @LINE:68
private[this] lazy val controllers_RestUserController_getGuardianDetailsById52_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getGuardianDetailsById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getGuardianDetailsById52_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianDetailsById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getGuardianDetailsById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getGuardianDetailsById/$id<[^/]+>"""))
        

// @LINE:69
private[this] lazy val controllers_RestUserController_updateStudentDetailsById53_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/updateStudentDetails/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_updateStudentDetailsById53_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).updateStudentDetailsById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "updateStudentDetailsById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/updateStudentDetails/$id<[^/]+>"""))
        

// @LINE:70
private[this] lazy val controllers_RestUserController_deleteUserDetailsById54_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/deleteUserDetailsById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_deleteUserDetailsById54_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).deleteUserDetailsById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "deleteUserDetailsById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/deleteUserDetailsById/$id<[^/]+>"""))
        

// @LINE:72
private[this] lazy val controllers_RestUserController_getStudentUserById55_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentUserById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentUserById55_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentUserById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStudentUserById/$id<[^/]+>"""))
        

// @LINE:73
private[this] lazy val controllers_RestUserController_getStaffUserById56_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStaffUserById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStaffUserById56_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffUserById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffUserById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStaffUserById/$id<[^/]+>"""))
        

// @LINE:74
private[this] lazy val controllers_RestUserController_getGuardianUserById57_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getGuardianUserById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getGuardianUserById57_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianUserById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getGuardianUserById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getGuardianUserById/$id<[^/]+>"""))
        

// @LINE:75
private[this] lazy val controllers_RestUserController_getAllGuardianListByCampusId58_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAllGuardianListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getAllGuardianListByCampusId58_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllGuardianListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAllGuardianListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getAllGuardianListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:76
private[this] lazy val controllers_RestUserController_getStudentUserListByCampusId59_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentUserListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentUserListByCampusId59_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentUserListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStudentUserListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:77
private[this] lazy val controllers_RestUserController_getStaffUserListByCampusId60_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStaffUserListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStaffUserListByCampusId60_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffUserListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffUserListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStaffUserListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:78
private[this] lazy val controllers_RestUserController_getAllClassesByCampusId61_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAllClassesByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getAllClassesByCampusId61_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllClassesByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAllClassesByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getAllClassesByCampusId/$campusId<[^/]+>"""))
        

// @LINE:79
private[this] lazy val controllers_RestUserController_getStudentListByClassId62_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentListByClassId/"),DynamicPart("classId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentListByClassId62_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentListByClassId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentListByClassId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStudentListByClassId/$classId<[^/]+>"""))
        

// @LINE:80
private[this] lazy val controllers_RestUserController_termTypeList63_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/termTypeList"))))
private[this] lazy val controllers_RestUserController_termTypeList63_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).termTypeList,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "termTypeList", Nil,"GET", """""", Routes.prefix + """auth/termTypeList"""))
        

// @LINE:81
private[this] lazy val controllers_RestUserController_getVehicleListByCampusId64_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getVehicleListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getVehicleListByCampusId64_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getVehicleListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getVehicleListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:82
private[this] lazy val controllers_RestUserController_getDriverListByCampusId65_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getDriverListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getDriverListByCampusId65_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getDriverListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getDriverListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getDriverListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:85
private[this] lazy val controllers_RestUserController_getSubjectIdBySubjectName66_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getSubjectIdBySubjectName/"),DynamicPart("subjectName", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getSubjectIdBySubjectName66_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectIdBySubjectName(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSubjectIdBySubjectName", Seq(classOf[String]),"GET", """GET     /auth/createAttendance/:classId                 @controllers.RestUserController.createAttendance(classId: Long)
GET     /auth/getVehicledetails/:id                     @controllers.RestUserController.getVehicledetailsById(id : Long)""", Routes.prefix + """auth/getSubjectIdBySubjectName/$subjectName<[^/]+>"""))
        

// @LINE:86
private[this] lazy val controllers_RestUserController_getAllSubjectList67_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAllSubjectList"))))
private[this] lazy val controllers_RestUserController_getAllSubjectList67_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllSubjectList,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAllSubjectList", Nil,"GET", """""", Routes.prefix + """auth/getAllSubjectList"""))
        

// @LINE:87
private[this] lazy val controllers_RestUserController_getSubjectsById68_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getSubjectsById/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getSubjectsById68_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectsById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSubjectsById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getSubjectsById/$id<[^/]+>"""))
        

// @LINE:88
private[this] lazy val controllers_RestUserController_getSubjectsByClassId69_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getSubjectsByClassId/"),DynamicPart("classId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getSubjectsByClassId69_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectsByClassId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSubjectsByClassId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getSubjectsByClassId/$classId<[^/]+>"""))
        

// @LINE:89
private[this] lazy val controllers_RestUserController_forgetpassword70_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/forgetpassword/"),DynamicPart("email", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_forgetpassword70_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).forgetpassword(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "forgetpassword", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/forgetpassword/$email<[^/]+>"""))
        

// @LINE:90
private[this] lazy val controllers_RestUserController_restPasswordKey71_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/updatePassword"))))
private[this] lazy val controllers_RestUserController_restPasswordKey71_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).restPasswordKey,
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "restPasswordKey", Nil,"GET", """""", Routes.prefix + """auth/updatePassword"""))
        

// @LINE:91
private[this] lazy val controllers_RestUserController_getVehicleRouteAndStopDetailsByVhId72_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getVehicleRouteAndStopDetailsByVhId/"),DynamicPart("vid", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getVehicleRouteAndStopDetailsByVhId72_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleRouteAndStopDetailsByVhId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getVehicleRouteAndStopDetailsByVhId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getVehicleRouteAndStopDetailsByVhId/$vid<[^/]+>"""))
        

// @LINE:92
private[this] lazy val controllers_RestUserController_getLibrariansListByCampusId73_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getLibrariansListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getLibrariansListByCampusId73_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getLibrariansListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getLibrariansListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getLibrariansListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:93
private[this] lazy val controllers_RestUserController_getMedicalDetailByUserId74_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getMedicalDetailByUserId/"),DynamicPart("userId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getMedicalDetailByUserId74_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMedicalDetailByUserId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMedicalDetailByUserId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getMedicalDetailByUserId/$userId<[^/]+>"""))
        

// @LINE:94
private[this] lazy val controllers_RestUserController_getMedicalDetailListByCampusId75_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getMedicalDetailListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getMedicalDetailListByCampusId75_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMedicalDetailListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMedicalDetailListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getMedicalDetailListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:95
private[this] lazy val controllers_RestUserController_getBookListByCampusId76_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getBookListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getBookListByCampusId76_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getBookListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getBookListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getBookListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:96
private[this] lazy val controllers_RestUserController_getStudentAttendenceListByClassId77_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentAttendenceListByClassId/"),DynamicPart("classId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentAttendenceListByClassId77_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentAttendenceListByClassId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentAttendenceListByClassId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStudentAttendenceListByClassId/$classId<[^/]+>"""))
        

// @LINE:97
private[this] lazy val controllers_RestUserController_getAssignmentByClassId78_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAssignmentByClassId/"),DynamicPart("cid", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getAssignmentByClassId78_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAssignmentByClassId(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAssignmentByClassId", Seq(classOf[Int]),"GET", """""", Routes.prefix + """auth/getAssignmentByClassId/$cid<[^/]+>"""))
        

// @LINE:98
private[this] lazy val controllers_RestUserController_getListOfStudentByCampusIdWhoHasTakenBooks79_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getListOfStudentByCampusIdWhoHasTakenBooks/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getListOfStudentByCampusIdWhoHasTakenBooks79_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getListOfStudentByCampusIdWhoHasTakenBooks(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getListOfStudentByCampusIdWhoHasTakenBooks", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getListOfStudentByCampusIdWhoHasTakenBooks/$campusId<[^/]+>"""))
        

// @LINE:100
private[this] lazy val controllers_RestUserController_getStudentDetailByStdAdmNum80_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentDetailByStdAdmNum/"),DynamicPart("admNum", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentDetailByStdAdmNum80_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentDetailByStdAdmNum(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentDetailByStdAdmNum", Seq(classOf[String]),"GET", """GET		/auth/getStudentWhoHasReturnBook/:stdUserId		 @controllers.RestUserController.getStudentWhoHasReturnBook(stdUserId : Long)""", Routes.prefix + """auth/getStudentDetailByStdAdmNum/$admNum<[^/]+>"""))
        

// @LINE:101
private[this] lazy val controllers_RestUserController_getGuardianUserByStudentAdmissionNumber81_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getGuardianUserByStudentAdmissionNumber/"),DynamicPart("stdadmissionno", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getGuardianUserByStudentAdmissionNumber81_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianUserByStudentAdmissionNumber(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getGuardianUserByStudentAdmissionNumber", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getGuardianUserByStudentAdmissionNumber/$stdadmissionno<[^/]+>"""))
        

// @LINE:102
private[this] lazy val controllers_RestUserController_getStudentMedicalDetailsByStudentAdmNum82_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentMedicalDetailsByStudentAdmNum/"),DynamicPart("stdadmissionno", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentMedicalDetailsByStudentAdmNum82_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentMedicalDetailsByStudentAdmNum(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentMedicalDetailsByStudentAdmNum", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getStudentMedicalDetailsByStudentAdmNum/$stdadmissionno<[^/]+>"""))
        

// @LINE:103
private[this] lazy val controllers_RestUserController_getStudentVehicleDetailsByStudentAdmNum83_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentVehicleDetailsByStudentAdmNum/"),DynamicPart("stdadmissionno", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentVehicleDetailsByStudentAdmNum83_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentVehicleDetailsByStudentAdmNum(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentVehicleDetailsByStudentAdmNum", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getStudentVehicleDetailsByStudentAdmNum/$stdadmissionno<[^/]+>"""))
        

// @LINE:104
private[this] lazy val controllers_RestUserController_getStudentEventDetailsByAdmissionNumber84_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentEventDetailsByAdmissionNumber/"),DynamicPart("stdadmissionno", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentEventDetailsByAdmissionNumber84_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentEventDetailsByAdmissionNumber(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentEventDetailsByAdmissionNumber", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getStudentEventDetailsByAdmissionNumber/$stdadmissionno<[^/]+>"""))
        

// @LINE:105
private[this] lazy val controllers_RestUserController_getEventListByCampusId85_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getEventListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getEventListByCampusId85_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getEventListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getEventListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getEventListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:106
private[this] lazy val controllers_RestUserController_getHolidaysByCampusId86_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getHolidaysByCampusID/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getHolidaysByCampusId86_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getHolidaysByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getHolidaysByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getHolidaysByCampusID/$campusId<[^/]+>"""))
        

// @LINE:107
private[this] lazy val controllers_RestUserController_getSchoolListByCampusId87_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getSchoolsInformationByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getSchoolListByCampusId87_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolListByCampusId(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSchoolListByCampusId", Seq(classOf[Int]),"GET", """""", Routes.prefix + """auth/getSchoolsInformationByCampusId/$campusId<[^/]+>"""))
        

// @LINE:108
private[this] lazy val controllers_RestUserController_getAttendanceByStdAdmNoByMonthNoAndByStatus88_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAttendanceByStdAdmNoByMonthNoAndByStatus/"),DynamicPart("stdAdmNum", """[^/]+""",true),StaticPart("/"),DynamicPart("monthNum", """[^/]+""",true),StaticPart("/"),DynamicPart("status", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getAttendanceByStdAdmNoByMonthNoAndByStatus88_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNoByMonthNoAndByStatus(fakeValue[String], fakeValue[Int], fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAttendanceByStdAdmNoByMonthNoAndByStatus", Seq(classOf[String], classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """auth/getAttendanceByStdAdmNoByMonthNoAndByStatus/$stdAdmNum<[^/]+>/$monthNum<[^/]+>/$status<[^/]+>"""))
        

// @LINE:109
private[this] lazy val controllers_RestUserController_getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus89_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authgetAttendanceByStdAdmNoByFrmDateByToDateAndByStatus/"),DynamicPart("stdAdmNum", """[^/]+""",true),StaticPart("/"),DynamicPart("fromDate", """[^/]+""",true),StaticPart("/"),DynamicPart("toDate", """[^/]+""",true),StaticPart("/"),DynamicPart("status", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus89_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus", Seq(classOf[String], classOf[String], classOf[String], classOf[Int]),"GET", """""", Routes.prefix + """authgetAttendanceByStdAdmNoByFrmDateByToDateAndByStatus/$stdAdmNum<[^/]+>/$fromDate<[^/]+>/$toDate<[^/]+>/$status<[^/]+>"""))
        

// @LINE:110
private[this] lazy val controllers_RestUserController_getAttendanceByStdAdmNo90_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAttendanceByStdAdmNo/"),DynamicPart("stdAdmNum", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getAttendanceByStdAdmNo90_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNo(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAttendanceByStdAdmNo", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getAttendanceByStdAdmNo/$stdAdmNum<[^/]+>"""))
        

// @LINE:111
private[this] lazy val controllers_RestUserController_getStudentPeriviousDetailByStdAdmNum91_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStudentPeriviousDetailByStdAdmNum/"),DynamicPart("stdAdmNum", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStudentPeriviousDetailByStdAdmNum91_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentPeriviousDetailByStdAdmNum(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentPeriviousDetailByStdAdmNum", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getStudentPeriviousDetailByStdAdmNum/$stdAdmNum<[^/]+>"""))
        

// @LINE:112
private[this] lazy val controllers_RestUserController_getSchoolNewsListBySchoolId92_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getSchoolNewsListBySchoolId/"),DynamicPart("schoolId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getSchoolNewsListBySchoolId92_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolNewsListBySchoolId(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSchoolNewsListBySchoolId", Seq(classOf[Int]),"GET", """""", Routes.prefix + """auth/getSchoolNewsListBySchoolId/$schoolId<[^/]+>"""))
        

// @LINE:113
private[this] lazy val controllers_RestUserController_getSchoolNewsListByCampusId93_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getSchoolNewsListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getSchoolNewsListByCampusId93_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolNewsListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSchoolNewsListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getSchoolNewsListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:114
private[this] lazy val controllers_RestUserController_getExamDetailsByExamId94_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getExamDetailsByExamId/"),DynamicPart("examId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getExamDetailsByExamId94_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamDetailsByExamId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getExamDetailsByExamId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getExamDetailsByExamId/$examId<[^/]+>"""))
        

// @LINE:115
private[this] lazy val controllers_RestUserController_getEventDetailByEventId95_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getEventDetailByEventId/"),DynamicPart("eventId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getEventDetailByEventId95_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getEventDetailByEventId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getEventDetailByEventId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getEventDetailByEventId/$eventId<[^/]+>"""))
        

// @LINE:116
private[this] lazy val controllers_RestUserController_getExamTimeTableById96_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getExamTimeTableById/"),DynamicPart("ettId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getExamTimeTableById96_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getExamTimeTableById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getExamTimeTableById/$ettId<[^/]+>"""))
        

// @LINE:117
private[this] lazy val controllers_RestUserController_getExamTimeTableByExamId97_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getExamTimeTableByExamId/"),DynamicPart("examId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getExamTimeTableByExamId97_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableByExamId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getExamTimeTableByExamId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getExamTimeTableByExamId/$examId<[^/]+>"""))
        

// @LINE:118
private[this] lazy val controllers_RestUserController_getExamTimeTableByClassId98_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getExamTimeTableByClassId/"),DynamicPart("classId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getExamTimeTableByClassId98_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableByClassId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getExamTimeTableByClassId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getExamTimeTableByClassId/$classId<[^/]+>"""))
        

// @LINE:119
private[this] lazy val controllers_RestUserController_getClassTimeTableByClassId99_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getClassTimeTableByClassId/"),DynamicPart("classId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getClassTimeTableByClassId99_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getClassTimeTableByClassId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getClassTimeTableByClassId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getClassTimeTableByClassId/$classId<[^/]+>"""))
        

// @LINE:120
private[this] lazy val controllers_RestUserController_getMarksDetailBySubjectId100_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getMarksDetailBySubjectId/"),DynamicPart("subjectId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getMarksDetailBySubjectId100_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksDetailBySubjectId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMarksDetailBySubjectId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getMarksDetailBySubjectId/$subjectId<[^/]+>"""))
        

// @LINE:121
private[this] lazy val controllers_RestUserController_getMarksListByclassId101_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getMarksListByclassId/"),DynamicPart("classId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getMarksListByclassId101_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksListByclassId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMarksListByclassId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getMarksListByclassId/$classId<[^/]+>"""))
        

// @LINE:122
private[this] lazy val controllers_RestUserController_getMarksListByStdAdmNum102_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getMarksListByStdAdmNum/"),DynamicPart("stdAdmNum", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getMarksListByStdAdmNum102_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksListByStdAdmNum(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMarksListByStdAdmNum", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getMarksListByStdAdmNum/$stdAdmNum<[^/]+>"""))
        

// @LINE:123
private[this] lazy val controllers_RestUserController_getStaffTimeTableByClassId103_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStaffTimeTableByClassId/"),DynamicPart("classId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStaffTimeTableByClassId103_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffTimeTableByClassId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffTimeTableByClassId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStaffTimeTableByClassId/$classId<[^/]+>"""))
        

// @LINE:124
private[this] lazy val controllers_RestUserController_getClassListByStaffUserId104_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getClassListByStaffUserId/"),DynamicPart("userId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getClassListByStaffUserId104_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getClassListByStaffUserId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getClassListByStaffUserId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getClassListByStaffUserId/$userId<[^/]+>"""))
        

// @LINE:125
private[this] lazy val controllers_RestUserController_getStaffListByClassId105_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getStaffListByClassId/"),DynamicPart("classId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getStaffListByClassId105_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffListByClassId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffListByClassId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getStaffListByClassId/$classId<[^/]+>"""))
        

// @LINE:126
private[this] lazy val controllers_RestUserController_getVehicleTypeListByCampusId106_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getVehicleTypeListByCampusId/"),DynamicPart("campusId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getVehicleTypeListByCampusId106_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleTypeListByCampusId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getVehicleTypeListByCampusId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getVehicleTypeListByCampusId/$campusId<[^/]+>"""))
        

// @LINE:127
private[this] lazy val controllers_RestUserController_getVehicleDetailByStaffUserId107_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getVehicleDetailByStaffUserId/"),DynamicPart("userId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getVehicleDetailByStaffUserId107_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleDetailByStaffUserId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getVehicleDetailByStaffUserId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getVehicleDetailByStaffUserId/$userId<[^/]+>"""))
        

// @LINE:128
private[this] lazy val controllers_RestUserController_getAssignmentByStaffUserId108_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getAssignmentByStaffUserId/"),DynamicPart("userId", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getAssignmentByStaffUserId108_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAssignmentByStaffUserId(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAssignmentByStaffUserId", Seq(classOf[Long]),"GET", """""", Routes.prefix + """auth/getAssignmentByStaffUserId/$userId<[^/]+>"""))
        

// @LINE:129
private[this] lazy val controllers_RestUserController_getImage109_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("auth/getImage/"),DynamicPart("key", """[^/]+""",true))))
private[this] lazy val controllers_RestUserController_getImage109_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getImage(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getImage", Seq(classOf[String]),"GET", """""", Routes.prefix + """auth/getImage/$key<[^/]+>"""))
        

// @LINE:141
private[this] lazy val controllers_Assets_at110_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at110_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""@controllers.ApplicationController@.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signin/credentials""","""@controllers.RestUserController@.authenticate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signUpForCampusAdmin""","""@controllers.RestSignUpController@.signUpForCampusAdmin"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signup""","""@controllers.RestSignUpController@.signUp"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signUpForStudent""","""@controllers.RestSignUpController@.signUpForStudent"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signUpForGuardian""","""@controllers.RestSignUpController@.signUpForGuardian"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signUpForStaff""","""@controllers.RestSignUpController@.signUpForStaff"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signUpForDriver""","""@controllers.RestSignUpController@.signUpForDriver"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/createVehicleDetail""","""@controllers.RestSignUpController@.createVehicleCompleteDetail"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signUpForLibrarian""","""@controllers.RestSignUpController@.signUpForLibrarian"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/createbook""","""@controllers.RestSignUpController@.createbook"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/medicalCreate""","""@controllers.RestSignUpController@.medicalCreate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/campusCreate""","""@controllers.RestSignUpController@.campusCreate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/signout""","""@controllers.RestSignUpController@.signOut"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/bookIssue""","""@controllers.RestSignUpController@.bookIssue"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/assignmentcreate""","""@controllers.RestSignUpController@.assignmentcreate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/eventcreate""","""@controllers.RestSignUpController@.eventCreate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/schoolNews""","""@controllers.RestSignUpController@.schoolNews"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/exam""","""@controllers.RestSignUpController@.exam"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/marks""","""@controllers.RestSignUpController@.marks"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/staffClassMapping""","""@controllers.RestSignUpController@.StaffClassMapping"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/campusUpdate""","""@controllers.RestSignUpController@.campusUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/organizationUpdate""","""@controllers.RestSignUpController@.organizationUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/assignmentUpdate""","""@controllers.RestSignUpController@.assignmentUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/holidayUpdate""","""@controllers.RestSignUpController@.holidayUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/schoolUpdate""","""@controllers.RestSignUpController@.schoolUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/newsUpdate""","""@controllers.RestSignUpController@.newsUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/eventUpdate""","""@controllers.RestSignUpController@.eventUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/marksUpdate""","""@controllers.RestSignUpController@.marksUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/medicalUpdate""","""@controllers.RestSignUpController@.medicalUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/bookUpdate""","""@controllers.RestSignUpController@.bookUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/bookIssueUpdate""","""@controllers.RestSignUpController@.bookIssueUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/librarianUpdate""","""@controllers.RestSignUpController@.librarianUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/driverUpdate""","""@controllers.RestSignUpController@.driverUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/campusadminUpdate""","""@controllers.RestSignUpController@.campusadminUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/staffUpdate""","""@controllers.RestSignUpController@.staffUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/guardianUpdate""","""@controllers.RestSignUpController@.guardianUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/studentUpdate""","""@controllers.RestSignUpController@.studentUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/vehicleUpdate""","""@controllers.RestSignUpController@.vehicleUpdate"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/fileupload""","""@controllers.RestSignUpController@.uploadfile"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/sendSMS""","""@controllers.RestSignUpController@.sendSMS"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/createResultByStdAdmNum/$stdAdmNum<[^/]+>""","""@controllers.RestSignUpController@.createResultByStdAdmNum(stdAdmNum:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/userRoles""","""@controllers.MiscController@.getUserRolesList"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAllOganization""","""@controllers.MiscController@.getAllOrganization"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAllCampusByOrganizationId/$orgId<[^/]+>""","""@controllers.MiscController@.getAllCampusByOrganizationId(orgId:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getUserById/$id<[^/]+>""","""@controllers.RestUserController@.getUserById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getUserLoginByEmail/$email<[^/]+>""","""@controllers.RestUserController@.getUserLoginByEmail(email:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getUserContextById/$id<[^/]+>""","""@controllers.RestUserController@.getUserContextById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getContextById/$id<[^/]+>""","""@controllers.RestUserController@.getContextById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStaffDetailsById/$id<[^/]+>""","""@controllers.RestUserController@.getStaffDetailById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentDetailsById/$id<[^/]+>""","""@controllers.RestUserController@.getStudentDetailsById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentUserByFirstname/$Firstname<[^/]+>""","""@controllers.RestUserController@.getStudentUserByFirstname(Firstname:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getGuardianDetailsById/$id<[^/]+>""","""@controllers.RestUserController@.getGuardianDetailsById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/updateStudentDetails/$id<[^/]+>""","""@controllers.RestUserController@.updateStudentDetailsById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/deleteUserDetailsById/$id<[^/]+>""","""@controllers.RestUserController@.deleteUserDetailsById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentUserById/$id<[^/]+>""","""@controllers.RestUserController@.getStudentUserById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStaffUserById/$id<[^/]+>""","""@controllers.RestUserController@.getStaffUserById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getGuardianUserById/$id<[^/]+>""","""@controllers.RestUserController@.getGuardianUserById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAllGuardianListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getAllGuardianListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentUserListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getStudentUserListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStaffUserListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getStaffUserListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAllClassesByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getAllClassesByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentListByClassId/$classId<[^/]+>""","""@controllers.RestUserController@.getStudentListByClassId(classId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/termTypeList""","""@controllers.RestUserController@.termTypeList"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getVehicleListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getVehicleListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getDriverListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getDriverListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getSubjectIdBySubjectName/$subjectName<[^/]+>""","""@controllers.RestUserController@.getSubjectIdBySubjectName(subjectName:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAllSubjectList""","""@controllers.RestUserController@.getAllSubjectList"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getSubjectsById/$id<[^/]+>""","""@controllers.RestUserController@.getSubjectsById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getSubjectsByClassId/$classId<[^/]+>""","""@controllers.RestUserController@.getSubjectsByClassId(classId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/forgetpassword/$email<[^/]+>""","""@controllers.RestUserController@.forgetpassword(email:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/updatePassword""","""@controllers.RestUserController@.restPasswordKey"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getVehicleRouteAndStopDetailsByVhId/$vid<[^/]+>""","""@controllers.RestUserController@.getVehicleRouteAndStopDetailsByVhId(vid:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getLibrariansListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getLibrariansListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getMedicalDetailByUserId/$userId<[^/]+>""","""@controllers.RestUserController@.getMedicalDetailByUserId(userId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getMedicalDetailListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getMedicalDetailListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getBookListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getBookListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentAttendenceListByClassId/$classId<[^/]+>""","""@controllers.RestUserController@.getStudentAttendenceListByClassId(classId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAssignmentByClassId/$cid<[^/]+>""","""@controllers.RestUserController@.getAssignmentByClassId(cid:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getListOfStudentByCampusIdWhoHasTakenBooks/$campusId<[^/]+>""","""@controllers.RestUserController@.getListOfStudentByCampusIdWhoHasTakenBooks(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentDetailByStdAdmNum/$admNum<[^/]+>""","""@controllers.RestUserController@.getStudentDetailByStdAdmNum(admNum:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getGuardianUserByStudentAdmissionNumber/$stdadmissionno<[^/]+>""","""@controllers.RestUserController@.getGuardianUserByStudentAdmissionNumber(stdadmissionno:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentMedicalDetailsByStudentAdmNum/$stdadmissionno<[^/]+>""","""@controllers.RestUserController@.getStudentMedicalDetailsByStudentAdmNum(stdadmissionno:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentVehicleDetailsByStudentAdmNum/$stdadmissionno<[^/]+>""","""@controllers.RestUserController@.getStudentVehicleDetailsByStudentAdmNum(stdadmissionno:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentEventDetailsByAdmissionNumber/$stdadmissionno<[^/]+>""","""@controllers.RestUserController@.getStudentEventDetailsByAdmissionNumber(stdadmissionno:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getEventListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getEventListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getHolidaysByCampusID/$campusId<[^/]+>""","""@controllers.RestUserController@.getHolidaysByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getSchoolsInformationByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getSchoolListByCampusId(campusId:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAttendanceByStdAdmNoByMonthNoAndByStatus/$stdAdmNum<[^/]+>/$monthNum<[^/]+>/$status<[^/]+>""","""@controllers.RestUserController@.getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum:String, monthNum:Int, status:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authgetAttendanceByStdAdmNoByFrmDateByToDateAndByStatus/$stdAdmNum<[^/]+>/$fromDate<[^/]+>/$toDate<[^/]+>/$status<[^/]+>""","""@controllers.RestUserController@.getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum:String, fromDate:String, toDate:String, status:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAttendanceByStdAdmNo/$stdAdmNum<[^/]+>""","""@controllers.RestUserController@.getAttendanceByStdAdmNo(stdAdmNum:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStudentPeriviousDetailByStdAdmNum/$stdAdmNum<[^/]+>""","""@controllers.RestUserController@.getStudentPeriviousDetailByStdAdmNum(stdAdmNum:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getSchoolNewsListBySchoolId/$schoolId<[^/]+>""","""@controllers.RestUserController@.getSchoolNewsListBySchoolId(schoolId:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getSchoolNewsListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getSchoolNewsListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getExamDetailsByExamId/$examId<[^/]+>""","""@controllers.RestUserController@.getExamDetailsByExamId(examId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getEventDetailByEventId/$eventId<[^/]+>""","""@controllers.RestUserController@.getEventDetailByEventId(eventId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getExamTimeTableById/$ettId<[^/]+>""","""@controllers.RestUserController@.getExamTimeTableById(ettId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getExamTimeTableByExamId/$examId<[^/]+>""","""@controllers.RestUserController@.getExamTimeTableByExamId(examId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getExamTimeTableByClassId/$classId<[^/]+>""","""@controllers.RestUserController@.getExamTimeTableByClassId(classId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getClassTimeTableByClassId/$classId<[^/]+>""","""@controllers.RestUserController@.getClassTimeTableByClassId(classId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getMarksDetailBySubjectId/$subjectId<[^/]+>""","""@controllers.RestUserController@.getMarksDetailBySubjectId(subjectId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getMarksListByclassId/$classId<[^/]+>""","""@controllers.RestUserController@.getMarksListByclassId(classId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getMarksListByStdAdmNum/$stdAdmNum<[^/]+>""","""@controllers.RestUserController@.getMarksListByStdAdmNum(stdAdmNum:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStaffTimeTableByClassId/$classId<[^/]+>""","""@controllers.RestUserController@.getStaffTimeTableByClassId(classId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getClassListByStaffUserId/$userId<[^/]+>""","""@controllers.RestUserController@.getClassListByStaffUserId(userId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getStaffListByClassId/$classId<[^/]+>""","""@controllers.RestUserController@.getStaffListByClassId(classId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getVehicleTypeListByCampusId/$campusId<[^/]+>""","""@controllers.RestUserController@.getVehicleTypeListByCampusId(campusId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getVehicleDetailByStaffUserId/$userId<[^/]+>""","""@controllers.RestUserController@.getVehicleDetailByStaffUserId(userId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getAssignmentByStaffUserId/$userId<[^/]+>""","""@controllers.RestUserController@.getAssignmentByStaffUserId(userId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """auth/getImage/$key<[^/]+>""","""@controllers.RestUserController@.getImage(key:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:7
case controllers_ApplicationController_index0_route(params) => {
   call { 
        controllers_ApplicationController_index0_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ApplicationController]).index)
   }
}
        

// @LINE:11
case controllers_RestUserController_authenticate1_route(params) => {
   call { 
        controllers_RestUserController_authenticate1_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).authenticate)
   }
}
        

// @LINE:12
case controllers_RestSignUpController_signUpForCampusAdmin2_route(params) => {
   call { 
        controllers_RestSignUpController_signUpForCampusAdmin2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForCampusAdmin)
   }
}
        

// @LINE:13
case controllers_RestSignUpController_signUp3_route(params) => {
   call { 
        controllers_RestSignUpController_signUp3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUp)
   }
}
        

// @LINE:14
case controllers_RestSignUpController_signUpForStudent4_route(params) => {
   call { 
        controllers_RestSignUpController_signUpForStudent4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForStudent)
   }
}
        

// @LINE:15
case controllers_RestSignUpController_signUpForGuardian5_route(params) => {
   call { 
        controllers_RestSignUpController_signUpForGuardian5_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForGuardian)
   }
}
        

// @LINE:16
case controllers_RestSignUpController_signUpForStaff6_route(params) => {
   call { 
        controllers_RestSignUpController_signUpForStaff6_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForStaff)
   }
}
        

// @LINE:17
case controllers_RestSignUpController_signUpForDriver7_route(params) => {
   call { 
        controllers_RestSignUpController_signUpForDriver7_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForDriver)
   }
}
        

// @LINE:18
case controllers_RestSignUpController_createVehicleCompleteDetail8_route(params) => {
   call { 
        controllers_RestSignUpController_createVehicleCompleteDetail8_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createVehicleCompleteDetail)
   }
}
        

// @LINE:19
case controllers_RestSignUpController_signUpForLibrarian9_route(params) => {
   call { 
        controllers_RestSignUpController_signUpForLibrarian9_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForLibrarian)
   }
}
        

// @LINE:20
case controllers_RestSignUpController_createbook10_route(params) => {
   call { 
        controllers_RestSignUpController_createbook10_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createbook)
   }
}
        

// @LINE:21
case controllers_RestSignUpController_medicalCreate11_route(params) => {
   call { 
        controllers_RestSignUpController_medicalCreate11_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).medicalCreate)
   }
}
        

// @LINE:22
case controllers_RestSignUpController_campusCreate12_route(params) => {
   call { 
        controllers_RestSignUpController_campusCreate12_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusCreate)
   }
}
        

// @LINE:23
case controllers_RestSignUpController_signOut13_route(params) => {
   call { 
        controllers_RestSignUpController_signOut13_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signOut)
   }
}
        

// @LINE:24
case controllers_RestSignUpController_bookIssue14_route(params) => {
   call { 
        controllers_RestSignUpController_bookIssue14_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookIssue)
   }
}
        

// @LINE:25
case controllers_RestSignUpController_assignmentcreate15_route(params) => {
   call { 
        controllers_RestSignUpController_assignmentcreate15_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).assignmentcreate)
   }
}
        

// @LINE:26
case controllers_RestSignUpController_eventCreate16_route(params) => {
   call { 
        controllers_RestSignUpController_eventCreate16_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).eventCreate)
   }
}
        

// @LINE:27
case controllers_RestSignUpController_schoolNews17_route(params) => {
   call { 
        controllers_RestSignUpController_schoolNews17_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).schoolNews)
   }
}
        

// @LINE:28
case controllers_RestSignUpController_exam18_route(params) => {
   call { 
        controllers_RestSignUpController_exam18_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).exam)
   }
}
        

// @LINE:29
case controllers_RestSignUpController_marks19_route(params) => {
   call { 
        controllers_RestSignUpController_marks19_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).marks)
   }
}
        

// @LINE:30
case controllers_RestSignUpController_StaffClassMapping20_route(params) => {
   call { 
        controllers_RestSignUpController_StaffClassMapping20_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).StaffClassMapping)
   }
}
        

// @LINE:31
case controllers_RestSignUpController_campusUpdate21_route(params) => {
   call { 
        controllers_RestSignUpController_campusUpdate21_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusUpdate)
   }
}
        

// @LINE:32
case controllers_RestSignUpController_organizationUpdate22_route(params) => {
   call { 
        controllers_RestSignUpController_organizationUpdate22_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).organizationUpdate)
   }
}
        

// @LINE:33
case controllers_RestSignUpController_assignmentUpdate23_route(params) => {
   call { 
        controllers_RestSignUpController_assignmentUpdate23_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).assignmentUpdate)
   }
}
        

// @LINE:34
case controllers_RestSignUpController_holidayUpdate24_route(params) => {
   call { 
        controllers_RestSignUpController_holidayUpdate24_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).holidayUpdate)
   }
}
        

// @LINE:35
case controllers_RestSignUpController_schoolUpdate25_route(params) => {
   call { 
        controllers_RestSignUpController_schoolUpdate25_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).schoolUpdate)
   }
}
        

// @LINE:36
case controllers_RestSignUpController_newsUpdate26_route(params) => {
   call { 
        controllers_RestSignUpController_newsUpdate26_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).newsUpdate)
   }
}
        

// @LINE:37
case controllers_RestSignUpController_eventUpdate27_route(params) => {
   call { 
        controllers_RestSignUpController_eventUpdate27_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).eventUpdate)
   }
}
        

// @LINE:38
case controllers_RestSignUpController_marksUpdate28_route(params) => {
   call { 
        controllers_RestSignUpController_marksUpdate28_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).marksUpdate)
   }
}
        

// @LINE:39
case controllers_RestSignUpController_medicalUpdate29_route(params) => {
   call { 
        controllers_RestSignUpController_medicalUpdate29_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).medicalUpdate)
   }
}
        

// @LINE:40
case controllers_RestSignUpController_bookUpdate30_route(params) => {
   call { 
        controllers_RestSignUpController_bookUpdate30_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookUpdate)
   }
}
        

// @LINE:41
case controllers_RestSignUpController_bookIssueUpdate31_route(params) => {
   call { 
        controllers_RestSignUpController_bookIssueUpdate31_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookIssueUpdate)
   }
}
        

// @LINE:42
case controllers_RestSignUpController_librarianUpdate32_route(params) => {
   call { 
        controllers_RestSignUpController_librarianUpdate32_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).librarianUpdate)
   }
}
        

// @LINE:43
case controllers_RestSignUpController_driverUpdate33_route(params) => {
   call { 
        controllers_RestSignUpController_driverUpdate33_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).driverUpdate)
   }
}
        

// @LINE:44
case controllers_RestSignUpController_campusadminUpdate34_route(params) => {
   call { 
        controllers_RestSignUpController_campusadminUpdate34_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusadminUpdate)
   }
}
        

// @LINE:45
case controllers_RestSignUpController_staffUpdate35_route(params) => {
   call { 
        controllers_RestSignUpController_staffUpdate35_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).staffUpdate)
   }
}
        

// @LINE:46
case controllers_RestSignUpController_guardianUpdate36_route(params) => {
   call { 
        controllers_RestSignUpController_guardianUpdate36_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).guardianUpdate)
   }
}
        

// @LINE:47
case controllers_RestSignUpController_studentUpdate37_route(params) => {
   call { 
        controllers_RestSignUpController_studentUpdate37_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).studentUpdate)
   }
}
        

// @LINE:48
case controllers_RestSignUpController_vehicleUpdate38_route(params) => {
   call { 
        controllers_RestSignUpController_vehicleUpdate38_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).vehicleUpdate)
   }
}
        

// @LINE:51
case controllers_RestSignUpController_uploadfile39_route(params) => {
   call { 
        controllers_RestSignUpController_uploadfile39_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).uploadfile)
   }
}
        

// @LINE:52
case controllers_RestSignUpController_sendSMS40_route(params) => {
   call { 
        controllers_RestSignUpController_sendSMS40_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).sendSMS)
   }
}
        

// @LINE:53
case controllers_RestSignUpController_createResultByStdAdmNum41_route(params) => {
   call(params.fromPath[String]("stdAdmNum", None)) { (stdAdmNum) =>
        controllers_RestSignUpController_createResultByStdAdmNum41_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createResultByStdAdmNum(stdAdmNum))
   }
}
        

// @LINE:58
case controllers_MiscController_getUserRolesList42_route(params) => {
   call { 
        controllers_MiscController_getUserRolesList42_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getUserRolesList)
   }
}
        

// @LINE:59
case controllers_MiscController_getAllOrganization43_route(params) => {
   call { 
        controllers_MiscController_getAllOrganization43_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getAllOrganization)
   }
}
        

// @LINE:60
case controllers_MiscController_getAllCampusByOrganizationId44_route(params) => {
   call(params.fromPath[Int]("orgId", None)) { (orgId) =>
        controllers_MiscController_getAllCampusByOrganizationId44_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getAllCampusByOrganizationId(orgId))
   }
}
        

// @LINE:61
case controllers_RestUserController_getUserById45_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getUserById45_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserById(id))
   }
}
        

// @LINE:62
case controllers_RestUserController_getUserLoginByEmail46_route(params) => {
   call(params.fromPath[String]("email", None)) { (email) =>
        controllers_RestUserController_getUserLoginByEmail46_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserLoginByEmail(email))
   }
}
        

// @LINE:63
case controllers_RestUserController_getUserContextById47_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getUserContextById47_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserContextById(id))
   }
}
        

// @LINE:64
case controllers_RestUserController_getContextById48_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getContextById48_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getContextById(id))
   }
}
        

// @LINE:65
case controllers_RestUserController_getStaffDetailById49_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getStaffDetailById49_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffDetailById(id))
   }
}
        

// @LINE:66
case controllers_RestUserController_getStudentDetailsById50_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getStudentDetailsById50_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentDetailsById(id))
   }
}
        

// @LINE:67
case controllers_RestUserController_getStudentUserByFirstname51_route(params) => {
   call(params.fromPath[String]("Firstname", None)) { (Firstname) =>
        controllers_RestUserController_getStudentUserByFirstname51_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserByFirstname(Firstname))
   }
}
        

// @LINE:68
case controllers_RestUserController_getGuardianDetailsById52_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getGuardianDetailsById52_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianDetailsById(id))
   }
}
        

// @LINE:69
case controllers_RestUserController_updateStudentDetailsById53_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_updateStudentDetailsById53_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).updateStudentDetailsById(id))
   }
}
        

// @LINE:70
case controllers_RestUserController_deleteUserDetailsById54_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_deleteUserDetailsById54_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).deleteUserDetailsById(id))
   }
}
        

// @LINE:72
case controllers_RestUserController_getStudentUserById55_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getStudentUserById55_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserById(id))
   }
}
        

// @LINE:73
case controllers_RestUserController_getStaffUserById56_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getStaffUserById56_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffUserById(id))
   }
}
        

// @LINE:74
case controllers_RestUserController_getGuardianUserById57_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getGuardianUserById57_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianUserById(id))
   }
}
        

// @LINE:75
case controllers_RestUserController_getAllGuardianListByCampusId58_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getAllGuardianListByCampusId58_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllGuardianListByCampusId(campusId))
   }
}
        

// @LINE:76
case controllers_RestUserController_getStudentUserListByCampusId59_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getStudentUserListByCampusId59_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserListByCampusId(campusId))
   }
}
        

// @LINE:77
case controllers_RestUserController_getStaffUserListByCampusId60_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getStaffUserListByCampusId60_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffUserListByCampusId(campusId))
   }
}
        

// @LINE:78
case controllers_RestUserController_getAllClassesByCampusId61_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getAllClassesByCampusId61_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllClassesByCampusId(campusId))
   }
}
        

// @LINE:79
case controllers_RestUserController_getStudentListByClassId62_route(params) => {
   call(params.fromPath[Long]("classId", None)) { (classId) =>
        controllers_RestUserController_getStudentListByClassId62_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentListByClassId(classId))
   }
}
        

// @LINE:80
case controllers_RestUserController_termTypeList63_route(params) => {
   call { 
        controllers_RestUserController_termTypeList63_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).termTypeList)
   }
}
        

// @LINE:81
case controllers_RestUserController_getVehicleListByCampusId64_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getVehicleListByCampusId64_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleListByCampusId(campusId))
   }
}
        

// @LINE:82
case controllers_RestUserController_getDriverListByCampusId65_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getDriverListByCampusId65_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getDriverListByCampusId(campusId))
   }
}
        

// @LINE:85
case controllers_RestUserController_getSubjectIdBySubjectName66_route(params) => {
   call(params.fromPath[String]("subjectName", None)) { (subjectName) =>
        controllers_RestUserController_getSubjectIdBySubjectName66_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectIdBySubjectName(subjectName))
   }
}
        

// @LINE:86
case controllers_RestUserController_getAllSubjectList67_route(params) => {
   call { 
        controllers_RestUserController_getAllSubjectList67_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllSubjectList)
   }
}
        

// @LINE:87
case controllers_RestUserController_getSubjectsById68_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RestUserController_getSubjectsById68_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectsById(id))
   }
}
        

// @LINE:88
case controllers_RestUserController_getSubjectsByClassId69_route(params) => {
   call(params.fromPath[Long]("classId", None)) { (classId) =>
        controllers_RestUserController_getSubjectsByClassId69_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectsByClassId(classId))
   }
}
        

// @LINE:89
case controllers_RestUserController_forgetpassword70_route(params) => {
   call(params.fromPath[String]("email", None)) { (email) =>
        controllers_RestUserController_forgetpassword70_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).forgetpassword(email))
   }
}
        

// @LINE:90
case controllers_RestUserController_restPasswordKey71_route(params) => {
   call { 
        controllers_RestUserController_restPasswordKey71_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).restPasswordKey)
   }
}
        

// @LINE:91
case controllers_RestUserController_getVehicleRouteAndStopDetailsByVhId72_route(params) => {
   call(params.fromPath[Long]("vid", None)) { (vid) =>
        controllers_RestUserController_getVehicleRouteAndStopDetailsByVhId72_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleRouteAndStopDetailsByVhId(vid))
   }
}
        

// @LINE:92
case controllers_RestUserController_getLibrariansListByCampusId73_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getLibrariansListByCampusId73_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getLibrariansListByCampusId(campusId))
   }
}
        

// @LINE:93
case controllers_RestUserController_getMedicalDetailByUserId74_route(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_RestUserController_getMedicalDetailByUserId74_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMedicalDetailByUserId(userId))
   }
}
        

// @LINE:94
case controllers_RestUserController_getMedicalDetailListByCampusId75_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getMedicalDetailListByCampusId75_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMedicalDetailListByCampusId(campusId))
   }
}
        

// @LINE:95
case controllers_RestUserController_getBookListByCampusId76_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getBookListByCampusId76_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getBookListByCampusId(campusId))
   }
}
        

// @LINE:96
case controllers_RestUserController_getStudentAttendenceListByClassId77_route(params) => {
   call(params.fromPath[Long]("classId", None)) { (classId) =>
        controllers_RestUserController_getStudentAttendenceListByClassId77_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentAttendenceListByClassId(classId))
   }
}
        

// @LINE:97
case controllers_RestUserController_getAssignmentByClassId78_route(params) => {
   call(params.fromPath[Int]("cid", None)) { (cid) =>
        controllers_RestUserController_getAssignmentByClassId78_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAssignmentByClassId(cid))
   }
}
        

// @LINE:98
case controllers_RestUserController_getListOfStudentByCampusIdWhoHasTakenBooks79_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getListOfStudentByCampusIdWhoHasTakenBooks79_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getListOfStudentByCampusIdWhoHasTakenBooks(campusId))
   }
}
        

// @LINE:100
case controllers_RestUserController_getStudentDetailByStdAdmNum80_route(params) => {
   call(params.fromPath[String]("admNum", None)) { (admNum) =>
        controllers_RestUserController_getStudentDetailByStdAdmNum80_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentDetailByStdAdmNum(admNum))
   }
}
        

// @LINE:101
case controllers_RestUserController_getGuardianUserByStudentAdmissionNumber81_route(params) => {
   call(params.fromPath[String]("stdadmissionno", None)) { (stdadmissionno) =>
        controllers_RestUserController_getGuardianUserByStudentAdmissionNumber81_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianUserByStudentAdmissionNumber(stdadmissionno))
   }
}
        

// @LINE:102
case controllers_RestUserController_getStudentMedicalDetailsByStudentAdmNum82_route(params) => {
   call(params.fromPath[String]("stdadmissionno", None)) { (stdadmissionno) =>
        controllers_RestUserController_getStudentMedicalDetailsByStudentAdmNum82_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentMedicalDetailsByStudentAdmNum(stdadmissionno))
   }
}
        

// @LINE:103
case controllers_RestUserController_getStudentVehicleDetailsByStudentAdmNum83_route(params) => {
   call(params.fromPath[String]("stdadmissionno", None)) { (stdadmissionno) =>
        controllers_RestUserController_getStudentVehicleDetailsByStudentAdmNum83_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentVehicleDetailsByStudentAdmNum(stdadmissionno))
   }
}
        

// @LINE:104
case controllers_RestUserController_getStudentEventDetailsByAdmissionNumber84_route(params) => {
   call(params.fromPath[String]("stdadmissionno", None)) { (stdadmissionno) =>
        controllers_RestUserController_getStudentEventDetailsByAdmissionNumber84_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentEventDetailsByAdmissionNumber(stdadmissionno))
   }
}
        

// @LINE:105
case controllers_RestUserController_getEventListByCampusId85_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getEventListByCampusId85_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getEventListByCampusId(campusId))
   }
}
        

// @LINE:106
case controllers_RestUserController_getHolidaysByCampusId86_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getHolidaysByCampusId86_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getHolidaysByCampusId(campusId))
   }
}
        

// @LINE:107
case controllers_RestUserController_getSchoolListByCampusId87_route(params) => {
   call(params.fromPath[Int]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getSchoolListByCampusId87_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolListByCampusId(campusId))
   }
}
        

// @LINE:108
case controllers_RestUserController_getAttendanceByStdAdmNoByMonthNoAndByStatus88_route(params) => {
   call(params.fromPath[String]("stdAdmNum", None), params.fromPath[Int]("monthNum", None), params.fromPath[Int]("status", None)) { (stdAdmNum, monthNum, status) =>
        controllers_RestUserController_getAttendanceByStdAdmNoByMonthNoAndByStatus88_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum, monthNum, status))
   }
}
        

// @LINE:109
case controllers_RestUserController_getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus89_route(params) => {
   call(params.fromPath[String]("stdAdmNum", None), params.fromPath[String]("fromDate", None), params.fromPath[String]("toDate", None), params.fromPath[Int]("status", None)) { (stdAdmNum, fromDate, toDate, status) =>
        controllers_RestUserController_getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus89_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum, fromDate, toDate, status))
   }
}
        

// @LINE:110
case controllers_RestUserController_getAttendanceByStdAdmNo90_route(params) => {
   call(params.fromPath[String]("stdAdmNum", None)) { (stdAdmNum) =>
        controllers_RestUserController_getAttendanceByStdAdmNo90_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNo(stdAdmNum))
   }
}
        

// @LINE:111
case controllers_RestUserController_getStudentPeriviousDetailByStdAdmNum91_route(params) => {
   call(params.fromPath[String]("stdAdmNum", None)) { (stdAdmNum) =>
        controllers_RestUserController_getStudentPeriviousDetailByStdAdmNum91_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentPeriviousDetailByStdAdmNum(stdAdmNum))
   }
}
        

// @LINE:112
case controllers_RestUserController_getSchoolNewsListBySchoolId92_route(params) => {
   call(params.fromPath[Int]("schoolId", None)) { (schoolId) =>
        controllers_RestUserController_getSchoolNewsListBySchoolId92_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolNewsListBySchoolId(schoolId))
   }
}
        

// @LINE:113
case controllers_RestUserController_getSchoolNewsListByCampusId93_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getSchoolNewsListByCampusId93_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolNewsListByCampusId(campusId))
   }
}
        

// @LINE:114
case controllers_RestUserController_getExamDetailsByExamId94_route(params) => {
   call(params.fromPath[Long]("examId", None)) { (examId) =>
        controllers_RestUserController_getExamDetailsByExamId94_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamDetailsByExamId(examId))
   }
}
        

// @LINE:115
case controllers_RestUserController_getEventDetailByEventId95_route(params) => {
   call(params.fromPath[Long]("eventId", None)) { (eventId) =>
        controllers_RestUserController_getEventDetailByEventId95_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getEventDetailByEventId(eventId))
   }
}
        

// @LINE:116
case controllers_RestUserController_getExamTimeTableById96_route(params) => {
   call(params.fromPath[Long]("ettId", None)) { (ettId) =>
        controllers_RestUserController_getExamTimeTableById96_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableById(ettId))
   }
}
        

// @LINE:117
case controllers_RestUserController_getExamTimeTableByExamId97_route(params) => {
   call(params.fromPath[Long]("examId", None)) { (examId) =>
        controllers_RestUserController_getExamTimeTableByExamId97_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableByExamId(examId))
   }
}
        

// @LINE:118
case controllers_RestUserController_getExamTimeTableByClassId98_route(params) => {
   call(params.fromPath[Long]("classId", None)) { (classId) =>
        controllers_RestUserController_getExamTimeTableByClassId98_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableByClassId(classId))
   }
}
        

// @LINE:119
case controllers_RestUserController_getClassTimeTableByClassId99_route(params) => {
   call(params.fromPath[Long]("classId", None)) { (classId) =>
        controllers_RestUserController_getClassTimeTableByClassId99_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getClassTimeTableByClassId(classId))
   }
}
        

// @LINE:120
case controllers_RestUserController_getMarksDetailBySubjectId100_route(params) => {
   call(params.fromPath[Long]("subjectId", None)) { (subjectId) =>
        controllers_RestUserController_getMarksDetailBySubjectId100_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksDetailBySubjectId(subjectId))
   }
}
        

// @LINE:121
case controllers_RestUserController_getMarksListByclassId101_route(params) => {
   call(params.fromPath[Long]("classId", None)) { (classId) =>
        controllers_RestUserController_getMarksListByclassId101_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksListByclassId(classId))
   }
}
        

// @LINE:122
case controllers_RestUserController_getMarksListByStdAdmNum102_route(params) => {
   call(params.fromPath[String]("stdAdmNum", None)) { (stdAdmNum) =>
        controllers_RestUserController_getMarksListByStdAdmNum102_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksListByStdAdmNum(stdAdmNum))
   }
}
        

// @LINE:123
case controllers_RestUserController_getStaffTimeTableByClassId103_route(params) => {
   call(params.fromPath[Long]("classId", None)) { (classId) =>
        controllers_RestUserController_getStaffTimeTableByClassId103_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffTimeTableByClassId(classId))
   }
}
        

// @LINE:124
case controllers_RestUserController_getClassListByStaffUserId104_route(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_RestUserController_getClassListByStaffUserId104_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getClassListByStaffUserId(userId))
   }
}
        

// @LINE:125
case controllers_RestUserController_getStaffListByClassId105_route(params) => {
   call(params.fromPath[Long]("classId", None)) { (classId) =>
        controllers_RestUserController_getStaffListByClassId105_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffListByClassId(classId))
   }
}
        

// @LINE:126
case controllers_RestUserController_getVehicleTypeListByCampusId106_route(params) => {
   call(params.fromPath[Long]("campusId", None)) { (campusId) =>
        controllers_RestUserController_getVehicleTypeListByCampusId106_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleTypeListByCampusId(campusId))
   }
}
        

// @LINE:127
case controllers_RestUserController_getVehicleDetailByStaffUserId107_route(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_RestUserController_getVehicleDetailByStaffUserId107_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleDetailByStaffUserId(userId))
   }
}
        

// @LINE:128
case controllers_RestUserController_getAssignmentByStaffUserId108_route(params) => {
   call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_RestUserController_getAssignmentByStaffUserId108_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAssignmentByStaffUserId(userId))
   }
}
        

// @LINE:129
case controllers_RestUserController_getImage109_route(params) => {
   call(params.fromPath[String]("key", None)) { (key) =>
        controllers_RestUserController_getImage109_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getImage(key))
   }
}
        

// @LINE:141
case controllers_Assets_at110_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at110_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     