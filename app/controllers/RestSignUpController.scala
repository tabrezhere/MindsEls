package controllers

import com.mohiva.play.silhouette.core.Environment
import models.users.User
import com.mohiva.play.silhouette.contrib.authenticators.CookieAuthenticator
import services.UserService
import com.mohiva.play.silhouette.core.services.AuthInfoService
import com.mohiva.play.silhouette.core.services.AvatarService
import com.mohiva.play.silhouette.core.utils.PasswordHasher
import com.mohiva.play.silhouette.core.Silhouette
import com.google.inject.Inject
import play.api.mvc.Action
import security.models.SignUp
import play.api.libs.json._
import play.api.libs.json.Json.toJson
import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.providers.CredentialsProvider
import com.mohiva.play.silhouette.core.SignUpEvent
import com.mohiva.play.silhouette.core.LoginEvent
import play.api.libs.json.JsError
import scala.concurrent.Future
import utils.responses.rest.MsgOK
import security.models.Token
import utils.responses.rest.MsgERR
import play.api.mvc.Cookie
import play.api.libs.concurrent.Execution.Implicits._
import com.mohiva.play.silhouette.core.LogoutEvent
import play.api.mvc.Result
import models.authorizations.SimpleUser
import models.users.UserLogin
import models.users.UserContext
import security.models.StaffDetail
import security.models.GuardianDetail
import security.models.StudentDetail
import models.commons.Context
import models.users.StudentUser
import models.users.GuardianUser
import models.users.StaffUser
import security.models.StudentSignUp
import security.models.StaffSignUp
import security.models.GuardianSignUp
import scala.collection.mutable.ArrayBuffer
import models.users.StudentClassMapping
import models.users.Term
import models.users.TermType
import models.users.UserTerm
import models.users.Class
import models.users.Student_Guardian_Mapping
import models.users.CourseStaffMapping
import security.models.DriverSignUp
import security.models.DriverDetail
import models.users.DriverUser
import security.models.CreateVehicleDetail
import models.users.VehicleDetail
import models.users.RouteDetail
import models.users.StopDetail
import models.users.CreateVehicleDetailUser
import security.models.LibrarianSignUp
import models.users.Librarian
import models.users.LibrarianUser
import models.users.Author
import models.users.Book
import models.users.BookAuthor
import models.users.BookCategories
import security.models.CreateBookDetail
import models.users.CreateBookUser
import security.models.MedicalCreate
import security.models.MedicalUpdate
import models.users.Medical
import security.models.CreateCampus
import models.commons.Campus
import models.services.MiscService
import models.services.MiscService
import security.models.CreateBookIssue
import models.users.BookIssue
import models.users.Organization
import security.models.OrganizationCreate
import security.models.OrganizationCreate
import security.models.SchoolCreate
import models.users.School
import security.models.HolidayCreate
import models.users.Holiday
import security.models.AssignmentCreate
import models.users.AssignmentUser
import models.users.Assignment
import models.users.VehicleType
import models.users.BokCategories
import security.models.EventCreate
import models.users.Events
import scala.collection.mutable.ListBuffer
import models.users.AttendanceUser
import models.users.AttendanceList
import security.models.SchoolNewsDetail
import models.users.SchoolNews
import security.models.ExamDetail
import models.users.Exam
import models.users.ExamClassMap
import models.users.ExamInfo
import security.models.ExamTimeTableDetail
import models.users.ExamTimeTable
import java.util.Calendar
import security.models.SubjectDetail
import models.users.SubjectClassMap
import models.users.EventsUser
import security.models.CLassTimeTableDetail
import models.users.ClassTimeTable
import security.models.MarksDetails
import models.users.Marks
import models.users.MarksStudent
import models.users.FinalResult
import security.models.CampusAdminSignUp
import models.users.CampusAdminUser
import models.users.StaffSubjectMap
import security.models.StaffTimeTable
import models.users.StaffClassMap
import java.net._
import java.net.HttpURLConnection
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import security.models.UpdateCampus
import security.models.OrganizationUpdate
import security.models.SendSMS
import models.users.SendMessage
import java.io.InputStream
import java.util.StringTokenizer
import org.slf4j.Logger
import security.models.AssignmentUpdate
import security.models.HolidayUpdate
import security.models.SchoolUpdate
import security.models.NewsUpdate
import security.models.EventUpdate
import security.models.MarksUpdate
import security.models.BookUpdate
import security.models.BookIssueUpdate
import security.models.LibrarianUpdate
import security.models.DriverUpdate
import models.users.DriverInfo
import security.models.CampusAdminUpdate
import security.models.StaffUpdate
import models.users.Staff
import security.models.GuardianUpdate
import security.models.StudentUpdate
import security.models.VehicleUpdate


//import ASPSnippets.SmsAPI

class RestSignUpController @Inject() (
  implicit val env: Environment[User, CookieAuthenticator],
  val userService: UserService,
  val miscService : MiscService,
  val authInfoService: AuthInfoService,
  val avatarService: AvatarService,
  val passwordHasher: PasswordHasher) extends Silhouette[User, CookieAuthenticator] {

  
  //val logger = Logger("com.alvinalexander.logging.Foo1")
  logger.info("Hello, world")
    
  //val logger = Logger(this.getClass())
  /**
   * The formats for read json represent user
   */
  //  implicit val restFormat = formatters.json.UserFormats.restFormat
  //  implicit val signUpFormat = Json.format[SignUp]

  /**
   * Registers a new user.
   *
   * receive call with json like this:
   * 	{
   * 		"password": "",
   * 		"identifier": "",
   *  		"firstName": "",
   *    	"lastName": "",
   *     	"fullName": ""
   * 	}
   *
   * @return The result to display.
   */
  def signUp = Action.async(parse.json) { implicit request =>
    request.body.validate[SignUp] match {
      case JsSuccess(signUp, _) =>
        val loginInfo = LoginInfo(CredentialsProvider.Credentials, signUp.identifier)
        (userService.retrieve(loginInfo).map {
          case None => /* user not already exists */
            val authInfo = passwordHasher.hash(signUp.password)
            val user = createUser(loginInfo, signUp)
           
            println(s"user created: $user")
            (for {
              user <- userService.save(user)              // Save User Object
              userLogin = createUserLogin(user,loginInfo,signUp)
              userLogin <- userService.saveUserLogin(userLogin)            // Save User_Login object   
              userContext = createUserContext(user,signUp,userLogin)        
              userContext <- userService.saveUserContext(userContext)	    // insert user_context mapping object
              authInfo <- authInfoService.save(loginInfo, authInfo)
              authenticator <- env.authenticatorService.create(user)
            } yield {
              println(s"yield1")
              env.eventBus.publish(SignUpEvent(user, request, request2lang))              
              println(s"yield2")
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              println(s"yield3")
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "user" -> user))))
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id))))
            }).flatMap { r => r }
          case Some(u) => /* user already exists! */
            Future.successful(Conflict(toJson(MsgERR("User with such username already exists"))))
        }).flatMap { r => r }
      case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }
  }

  
  /**
   *  signUp for staff and its details
   */
  
  
  def signUpForStaff = Action.async(parse.json) { implicit request =>
    val emailResult = null
    request.body.validate[StaffSignUp] match {
      case JsSuccess(staffSignUp, _) =>
        val loginInfo = LoginInfo(CredentialsProvider.Credentials, staffSignUp.identifier)
        (userService.retrieve(loginInfo).map {
          case None =>  /* user not already exists */
            val authInfo = passwordHasher.hash(staffSignUp.password)
            val user = User(id = 0,username = staffSignUp.identifier,loginInfo = loginInfo,firstName = staffSignUp.firstName,middleName = staffSignUp.middleName,
		    lastName = staffSignUp.lastName, DOB = staffSignUp.DOB,Gender = staffSignUp.Gender,address1 = staffSignUp.address1,address2 = staffSignUp.address2,
		    city = staffSignUp.city,state = staffSignUp.state,Deleted = null,roles = Set(SimpleUser)) 
           
            println(s"user created: $user")
            (for {
              user <- userService.save(user)              // Save User Object              
              userLogin = UserLogin(id = 0,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = staffSignUp.phoneNumber)   
              userLogin <- userService.saveUserLogin(userLogin)            // Save User_Login object   
	            emailResult = userService.SendRegistrationMail(userLogin.email)
              userContext =  UserContext(id=0,userId = user.id,contextId = staffSignUp.contextId,campusId = staffSignUp.campusId)  
              userContext <- userService.saveUserContext(userContext)     // insert user_context mapping object
              staffDetails = createStaffDetails(userContext,staffSignUp.vehicleId)
              staffDetails <- userService.saveStaffDetails(staffDetails)
              subjectId = userService.getSubjectIdBySubjectName(staffSignUp.subjectName)
              staffSubjectMap = StaffSubjectMap(id=0,subjectId = subjectId.id, userId = user.id)
              staffSubjectMap <- userService.saveStaffSubjectMap(staffSubjectMap)
              /*courseDetails = userService.getCourseById(id=1)
              courseStaffDetails =  CourseStaffMapping(id=0,role_name= staffSignUp.role_name,course_id = courseDetails.id,staffDetails.user_id)
              courseStaff <- userService.saveCourseStaff(courseStaffDetails)*/
              context <- userService.getContextById(userContext.contextId)      // get context of the user
              getCampusDetails = userService.getCampusDetailsByCampusId(userContext.campusId)
              getOrganizationDetail = userService.getOrganizationDetailByOrgId(getCampusDetails.organization_id)
              staffUser = createStaffUser(user,userLogin,context,staffDetails,staffSignUp.subjectName,getCampusDetails,getOrganizationDetail)                
              authInfo <- authInfoService.save(loginInfo, authInfo)
              authenticator <- env.authenticatorService.create(user)
            } yield {
              println(s"yield1")
              env.eventBus.publish(SignUpEvent(user, request, request2lang))
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              println(s"yield3")
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "staffUser" -> staffUser))))
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id))))
            }).flatMap { r => r }
          case Some(u) => /* user already exists!*/ 
            Future.successful(Conflict(toJson(MsgERR("User with such username already exists"))))
        }).flatMap { r => r }
      case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }
  }
  
  //staffUpdate
 def staffUpdate   = Action.async(parse.json) { implicit request =>
    request.body.validate[StaffUpdate] match {
        case JsSuccess(staffUpdate, _) =>
          val userDetail = userService.checkForUserId(staffUpdate.userId)
          val userLoginDetail = userService.getUserLoginIdByUserId(userDetail.id)
          val userContextId = userService.getUserContextIdByUserIdANDContextId(userDetail.id, staffUpdate.contextId)
          val staffDetail = userService.getStaffDetailByUserId(userDetail.id)
          val stfSubMap = userService.getStaffSubjectMapByUserId(userDetail.id)
          val loginInfo = LoginInfo(CredentialsProvider.Credentials, staffUpdate.identifier)
          try{
              if((userDetail) != None){
              println(" Staff Update started ")
              
              val user = User(id = userDetail.id,username = staffUpdate.identifier,loginInfo = loginInfo,firstName = staffUpdate.firstName,middleName = staffUpdate.middleName,
              lastName = staffUpdate.lastName, DOB = staffUpdate.DOB,Gender = staffUpdate.Gender,address1 = staffUpdate.address1,address2 = staffUpdate.address2,
              city = staffUpdate.city,state = staffUpdate.state,Deleted = null,roles = Set(SimpleUser)) 
              val userResult = userService.userUpdate(user,staffUpdate.userId)
              
              val userLogin = UserLogin(id = userLoginDetail.id,userId = userDetail.id,verified = 1,email = loginInfo.providerKey,phoneNumber = staffUpdate.phoneNumber)
              val userLoginResult = userService.userLoginUpdate(userLogin,userLoginDetail.id)
              
              val userContext =  UserContext(id = userContextId.id,userId = userDetail.id,contextId = userContextId.contextId,campusId = staffUpdate.campusId)  
              val userContextResult = userService.updateUserContext(userContext,userContextId.id) 
              
              val staffDetails = Staff(id=staffDetail.id,userId = userDetail.id,vehicleId=staffUpdate.vehicleId)
              val staffDetailsResult = userService.updateStaff(staffDetails,staffDetail.id)
              
              val subjectId = userService.getSubjectIdBySubjectName(staffUpdate.subjectName)
              val staffSubjectMap = StaffSubjectMap(id=stfSubMap.id,subjectId = subjectId.id, userId = userDetail.id)
              val staffSubjectMapResult = userService.updateStaffSubjectMap(staffSubjectMap,staffSubjectMap.id)
              
              
              Future.successful(Ok(toJson(MsgOK("Staff details has been updated succesfully."))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Staff details Id does not exist"))))
              }
          }catch{
            
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Any of the details should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error "))))
          }
    }
   }  
  
  def signUpForCampusAdmin = Action.async(parse.json) { implicit request =>
    val emailResult = null
    request.body.validate[CampusAdminSignUp] match {
      case JsSuccess(campusAdminSignUp, _) =>
        val loginInfo = LoginInfo(CredentialsProvider.Credentials, campusAdminSignUp.identifier)
        (userService.retrieve(loginInfo).map {
          case None =>  /* user not already exists */
            val authInfo = passwordHasher.hash(campusAdminSignUp.password)
            val user = User(id = 0,username = campusAdminSignUp.identifier,loginInfo = loginInfo,firstName = campusAdminSignUp.firstName,
                middleName = campusAdminSignUp.middleName,lastName = campusAdminSignUp.lastName, DOB = campusAdminSignUp.DOB,Gender = campusAdminSignUp.Gender,
                address1 = campusAdminSignUp.address1,address2 = campusAdminSignUp.address2,city = campusAdminSignUp.city,state = campusAdminSignUp.state,Deleted = null,roles = Set(SimpleUser)) 
           
            println(s"user created: $user")
            (for {
              user <- userService.save(user)              // Save User Object              
              userLogin = UserLogin(id = 0,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = campusAdminSignUp.phoneNumber)   
              userLogin <- userService.saveUserLogin(userLogin)            // Save User_Login object
              emailResult = userService.SendRegistrationMail(userLogin.email)
              userContext =  UserContext(id=0,userId = user.id,contextId = campusAdminSignUp.contextId,campusId = campusAdminSignUp.campusId)  
              userContext <- userService.saveUserContext(userContext)     // insert user_context mapping object
              context <- userService.getContextById(userContext.contextId)      // get context of the user
              getCampusDetails = userService.getCampusDetailsByCampusId(userContext.campusId)
              getOrganizationDetail = userService.getOrganizationDetailByOrgId(getCampusDetails.organization_id)
              campusAdminUser = createCampusAdminUser(user,userLogin,context,getCampusDetails,getOrganizationDetail)                
              authInfo <- authInfoService.save(loginInfo, authInfo)
              authenticator <- env.authenticatorService.create(user)
            } yield {
              println(s"yield1")
              env.eventBus.publish(SignUpEvent(user, request, request2lang))
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              println(s"yield3")
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "campusAdminUser" -> campusAdminUser))))
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id))))
            }).flatMap { r => r }
          case Some(u) => /* user already exists!*/ 
            Future.successful(Conflict(toJson(MsgERR("User with such username already exists"))))
        }).flatMap { r => r }
      case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }
  }
  
  //campusadminUpdate
  def campusadminUpdate   = Action.async(parse.json) { implicit request =>
    request.body.validate[CampusAdminUpdate] match {
        case JsSuccess(campusAdminUpdate, _) =>
          val userDetail = userService.checkForUserId(campusAdminUpdate.userId)
          val userLoginDetail = userService.getUserLoginIdByUserId(userDetail.id)
          val userContextId = userService.getUserContextIdByUserIdANDContextId(userDetail.id, campusAdminUpdate.contextId)
          val loginInfo = LoginInfo(CredentialsProvider.Credentials, campusAdminUpdate.identifier)
          try{
              if((userDetail) != None){
              println(" Campus Admin Update started ")
              
              val user = User(id = campusAdminUpdate.userId,username = campusAdminUpdate.identifier,loginInfo = loginInfo,firstName = campusAdminUpdate.firstName,middleName = campusAdminUpdate.middleName,
              lastName = campusAdminUpdate.lastName, DOB = campusAdminUpdate.DOB,Gender = campusAdminUpdate.Gender,address1 = campusAdminUpdate.address1,address2 = campusAdminUpdate.address2,
              city = campusAdminUpdate.city,state = campusAdminUpdate.state,Deleted = null,roles = Set(SimpleUser)) 
              val userResult = userService.userUpdate(user,campusAdminUpdate.userId)
              
              val userLogin = UserLogin(id = userDetail.id,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = campusAdminUpdate.phoneNumber)
              val userLoginResult = userService.userLoginUpdate(userLogin,userLoginDetail.id)
              
              val userContext =  UserContext(id = userContextId.id,userId = campusAdminUpdate.userId,contextId = campusAdminUpdate.contextId,campusId = campusAdminUpdate.campusId)  
              val userContextResult = userService.updateUserContext(userContext,userContextId.id) 
              
              
              Future.successful(Ok(toJson(MsgOK("Campus Admin details has been updated succesfully."))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Campus Admin details Id does not exist"))))
              }
          }catch{
            
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Any of the details should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error "))))
          }
    }
   }
  /*
   * signUpForLibrarian
   */
  
   def signUpForLibrarian = Action.async(parse.json) { implicit request =>
     val emailResult = null
    request.body.validate[LibrarianSignUp] match {
      case JsSuccess(librarianSignUp, _) =>
        val loginInfo = LoginInfo(CredentialsProvider.Credentials, librarianSignUp.identifier)
        (userService.retrieve(loginInfo).map {
          case None =>  /* user not already exists */
            val authInfo = passwordHasher.hash(librarianSignUp.password)
            val user = User(id = 0,username = librarianSignUp.identifier,loginInfo = loginInfo,firstName = librarianSignUp.firstName,middleName = librarianSignUp.middleName,
            lastName = librarianSignUp.lastName, DOB = librarianSignUp.DOB,Gender = librarianSignUp.Gender,address1 = librarianSignUp.address1,address2 = librarianSignUp.address2,
            city = librarianSignUp.city,state = librarianSignUp.state,Deleted = null,roles = Set(SimpleUser)) 
           
            println(s"user created: $user")
            (for {
              user <- userService.save(user)              // Save User Object              
              userLogin = UserLogin(id = 0,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = librarianSignUp.phoneNumber)   
              userLogin <- userService.saveUserLogin(userLogin)            // Save User_Login object
              emailResult = userService.SendRegistrationMail(userLogin.email)
              userContext =  UserContext(id=0,userId = user.id,contextId = 8,campusId = librarianSignUp.campusId)  
              userContext <- userService.saveUserContext(userContext)     // insert user_context mapping object
              librarian = createLibrarian(userContext)
              librarian <- userService.saveLibrarian(librarian)
              
              //courseDetails <- userService.getCourseById(id=1)
              
              /*courseStaffDetails =  CourseStaffMapping(id=0,staffSignUp.role_name,courseDetails.id,staffDetails.user_id)
              courseStaff <- userService.saveCourseStaff(courseStaffDetails)*/
              
              context <- userService.getContextById(userContext.contextId)      // get context of the user
              getCampusDetails = userService.getCampusDetailsByCampusId(userContext.campusId)
              getOrganizationDetail = userService.getOrganizationDetailByOrgId(getCampusDetails.organization_id)
              librarianUser = createLibrarianUser(user,userLogin,context,librarian,getCampusDetails,getOrganizationDetail)                
              authInfo <- authInfoService.save(loginInfo, authInfo)
              authenticator <- env.authenticatorService.create(user)
            } yield {
              println(s"yield1")
              env.eventBus.publish(SignUpEvent(user, request, request2lang))
              println(s"yield2")
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              println(s"yield3")
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),"librarianUser" -> librarianUser))))
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id))))
            }).flatMap { r => r }
          case Some(u) => /* user already exists!*/ 
            Future.successful(Conflict(toJson(MsgERR("User with such username already exists"))))
        }).flatMap { r => r }
      case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }
   }
   
 
 
   
   
   
//librarian Update
   def librarianUpdate   = Action.async(parse.json) { implicit request =>
    request.body.validate[LibrarianUpdate] match {
        case JsSuccess(libUpdate, _) =>
          val userDetail = userService.checkForUserId(libUpdate.userId)
          val userLoginDetail = userService.getUserLoginIdByUserId(userDetail.id)
          val userContextId = userService.getUserContextIdByUserIdANDContextId(userDetail.id, libUpdate.contextId)
          val loginInfo = LoginInfo(CredentialsProvider.Credentials, libUpdate.identifier)
          val librarianIdCheck = userService.checkForLibrarianId(libUpdate.librarianId)
          //val loginInfo = LoginInfo(CredentialsProvider.Credentials, libUpdate.identifier)
          try{
              if(librarianIdCheck != None){
              println(" Librarian Update started ")
              
              val user = User(id = libUpdate.userId,username = libUpdate.identifier,loginInfo = loginInfo,firstName = libUpdate.firstName,middleName = libUpdate.middleName,
              lastName = libUpdate.lastName, DOB = libUpdate.DOB,Gender = libUpdate.Gender,address1 = libUpdate.address1,address2 = libUpdate.address2,
              city = libUpdate.city,state = libUpdate.state,Deleted = null,roles = Set(SimpleUser)) 
              val userResult = userService.userUpdate(user,libUpdate.userId)
              
              val userLogin = UserLogin(id = libUpdate.userLoginId,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = libUpdate.phoneNumber)
              val userLoginResult = userService.userLoginUpdate(userLogin,libUpdate.userLoginId)
              
              val userContext =  UserContext(id=libUpdate.userContextId,userId = libUpdate.userId,contextId = libUpdate.contextId,campusId = libUpdate.campusId)  
              val userContextResult = userService.updateUserContext(userContext,libUpdate.userContextId) 
              
              val librarian = Librarian(id=libUpdate.librarianId,user_id = libUpdate.userId)
              val librarianResult = userService.updateLibrarian(librarian,libUpdate.librarianId)
              
              
              Future.successful(Ok(toJson(MsgOK("Librarian details has been updated succesfully."))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Librarian details Id does not exist"))))
              }
          }catch{
            
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Any of the Book details should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error "))))
          }
   }
}
   
def checkByUserIdUserLoginIdUserContextId(userId : Long,userLoginId : Long,userContextId : Long) : Unit = {
          var flag = false
          val userIdCheck = userService.checkForUserId(userId)
          val userLoginIdCheck = userService.checkForUserLoginId(userLoginId)
          val userContextIdCheck = userService.checkForUserContextId(userContextId)
          if((userIdCheck,userLoginIdCheck,userContextIdCheck) != None){
            flag = true
          }
          
}


//campusCreate
def campusCreate = Action.async(parse.json) { implicit request =>
   println(" Campus Create Started")
    request.body.validate[CreateCampus] match {
        case JsSuccess(createCampus, _) =>
              println(" Create Campus Begins ")
              try{
                  val campusNameCheck = userService.checkForCampusName(createCampus.campus_name)
                  if(campusNameCheck == None){
                      println(" CreateCampus Begins ")
                      var campus = Campus(id = 0,campus_name = createCampus.campus_name,campusAddress = createCampus.campusAddress,
                      campusLocation = createCampus.campusLocation,organization_id = createCampus.organization_id)
                      campus = userService.createCampus(campus)
                      Future.successful(Ok(toJson(MsgOK("Details of Campus has been created succesfully."+campus))))
                  }
                  else{
                      //Logger.ROOT_LOGGER_NAME.
                     logger.info("Campus Name already exists")
                     Future.successful(Ok(toJson(MsgERR("Campus Name Already Exist : "+campusNameCheck.campus_name))))
                }
              }catch{
                
                case e : Exception => //Logger.info("Campus is having some exceptions : " + e)
                        //Future.successful(Ok(toJson(MsgOK("Campus Name should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Any of the field should not be null"))))
              }
                      
   }
}

def campusUpdate = Action.async(parse.json) { implicit request =>
   println(" Campus Update First")
    request.body.validate[UpdateCampus] match {
        case JsSuccess(updateCampus, _) =>
          try{
              val campusIdCheck = userService.checkForCampusId(updateCampus.campusId)
              if(campusIdCheck != None){
              println(" Campus Update is started")
              var campus = Campus(id = updateCampus.campusId,campus_name = updateCampus.campus_name,campusAddress = updateCampus.campusAddress,
                                campusLocation = updateCampus.campusLocation,organization_id = updateCampus.organization_id)
              val result = userService.campusUpdate(campus,updateCampus.campusId)
              Future.successful(Ok(toJson(MsgOK("Campus has been updated succesfully."+result))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Campus Id does not exist : "+campusIdCheck.id))))
              }
          }catch{
            
            case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Campus Name should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error"))))
          }
              
              //case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
   }
}
   
 def createbook = Action.async(parse.json) { implicit request =>
     println(" createbook ")
     request.body.validate[CreateBookDetail] match {
        case JsSuccess(createBookDetail, _) =>
              println(" createbook Testing ")
              var authorDetail = Author(id=0,First_Name = createBookDetail.First_Name,Last_Name = createBookDetail.Last_Name)
                    authorDetail = userService.createAuthor(authorDetail)                     
                    var bookDetail=Book(id =0,ISBN =createBookDetail.ISBN,Book_title =createBookDetail.Book_title,
                        date_of_publication=createBookDetail.date_of_publication, 
                        bookCount = createBookDetail.bookCount,campusId = createBookDetail.campusId)
                    bookDetail=userService.createbookDetail(bookDetail)
                    val bookAuthorDetails = BookAuthor(bookDetail.id,authorDetail.id)
                    val resultBA=userService.createbookAuthorDetails(bookDetail.id,authorDetail.id)
                    print("\n BOOK CATEGORY ID FROM KEY BOARD : "+createBookDetail.Book_Categories_id+"\n\n")
                    val bookCategoriesMap=BookCategories(bookDetail.id,createBookDetail.Book_Categories_id)
                    val resultBC=userService.createbookCategories(bookDetail.id,bookCategoriesMap.Book_Categories_id)
                    val bookCategories = userService.getbookCategoriesBybookCategorieId(bookCategoriesMap.Book_Categories_id)
                    val createBookUser = createBookUserDetail(authorDetail,bookDetail,bookCategoriesMap,bookCategories)
                    val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                    "createBookUser" -> createBookUser))))
                    Future.successful(Ok(toJson(MsgOK("Book Details has been created succesfully."+createBookUser))))
                    
                 case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
 
 //bookUpdate
 def bookUpdate   = Action.async(parse.json) { implicit request =>
    request.body.validate[BookUpdate] match {
        case JsSuccess(updateBook, _) =>
          val authorIdCheck = userService.checkForAuthorId(updateBook.authorId)
          val bookIdCheck = userService.checkForBookId(updateBook.bookId)
          try{
              if((authorIdCheck,bookIdCheck) != None){
              println(" Book Update started ")
              var authorDetail = Author(id=updateBook.authorId,First_Name = updateBook.First_Name,Last_Name = updateBook.Last_Name)
              val authorResult = userService.authortUpdate(authorDetail,updateBook.authorId)
              var bookDetail=Book(id =updateBook.bookId,ISBN =updateBook.ISBN,Book_title =updateBook.Book_title,date_of_publication=updateBook.date_of_publication,
                  bookCount = updateBook.bookCount,campusId = updateBook.campusId)
              val bookResult = userService.bookUpdate(bookDetail,updateBook.bookId)
              val bookAuthorDetails = BookAuthor(bookDetail.id,authorDetail.id)
              val bookAuthorResult=userService.updateBookAuthorDetails(updateBook.bookId,updateBook.authorId)
              val bookCategoriesMap=BookCategories(updateBook.bookId,updateBook.Book_Categories_id)
              val bookCategoriesResult=userService.updateBookCategories(updateBook.bookId,bookCategoriesMap.Book_Categories_id)
              
              Future.successful(Ok(toJson(MsgOK("Book details has been updated succesfully."))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Book details Id does not exist : "))))
              }
          }catch{
            
            case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Any of the Book details should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error : "))))
          }
   }
}
 
 def bookIssue = Action.async(parse.json) {
   implicit request =>
     println(" CreateBookIssue ")
     request.body.validate[CreateBookIssue] match {
        case JsSuccess(createBookIssue, _) =>
             var countForBooksAvailable = userService.getCountForBooksAvailableByBookId(createBookIssue.bookid)
             println(" Book Count : "+countForBooksAvailable.bookCount)
             var listCount = userService.getListCountForBookAndBookIssueBook(countForBooksAvailable.id)
             println(" List Count : "+listCount)
             println(" Total Books Count : "+countForBooksAvailable.bookCount)
             val count = countForBooksAvailable.bookCount - listCount
             println(" Count : "+count)
             if(count > 0){
                 var countForBooksTaken = userService.getCountForBooksTakenByStudentUserId(createBookIssue.user_id)
                 println(" Number of book taken by student : "+countForBooksTaken)
                 if(countForBooksTaken < 3){
                     var checkForSameBookIssueToSameStudent = userService.getCheckForSameBookAssignToSameStudentUserByBookIdAndByUserId(createBookIssue.bookid,createBookIssue.user_id)
                     println(" checkForSameBookIssueToSameStudent : "+checkForSameBookIssueToSameStudent)
                     if(checkForSameBookIssueToSameStudent == 0){
                           println(" createBookIssue Testing ")
                           val bookIssue=BookIssue( id = 0,stdUserId = createBookIssue.user_id,bookid = createBookIssue.bookid,
                           date_issued = createBookIssue.date_issued,date_due_for_return = createBookIssue.date_due_for_return,
                           date_returned = createBookIssue.date_returned,amount_of_fine = createBookIssue.amount_of_fine,
                           libUserId = createBookIssue.libUserId,bookReturnFlag = 1,libRetId = createBookIssue.libRetId)
                           val unitResult=userService.createBookIssue(bookIssue)
                           //val bookUpdate = userService.updateBooksRecordByBookId(createBookIssue.bookid,countForBooksAvailable.bookCount)
                           val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                           "bookIssue" -> bookIssue))))
                           Future.successful(Ok(toJson(MsgOK("Book has been issued for the student succesfully....!"))))
                     }
                     else{
                       Future.successful(Ok(toJson(MsgOK("Book is alread issued to given Student User"))))
                     }
                 }
                 else{
                   Future.successful(Ok(toJson(MsgOK("We cant issues more than three books to same student"))))
                 }
             }
             else{
               Future.successful(Ok(toJson(MsgOK("All books are issued to students no book is for issue"))))
             }
        case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }  
 }
 
//bookIssueUpdate
 def bookIssueUpdate = Action.async(parse.json) { implicit request =>
    request.body.validate[BookIssueUpdate] match {
        case JsSuccess(updateBookIssue, _) =>
          val bookIssueIdCheck = userService.checkForBookIssueId(updateBookIssue.bookIssueId)
          try{
              if(bookIssueIdCheck != None){
              println(" Book Issue Update started ")
              val bookIssue=BookIssue( id = updateBookIssue.bookIssueId,stdUserId = updateBookIssue.user_id,bookid = updateBookIssue.bookid,
                           date_issued = updateBookIssue.date_issued,date_due_for_return = updateBookIssue.date_due_for_return,
                           date_returned = updateBookIssue.date_returned,amount_of_fine = updateBookIssue.amount_of_fine,
                           libUserId = updateBookIssue.libUserId,bookReturnFlag = 1,libRetId = updateBookIssue.libRetId)
              val bookIssueUpdateResult=userService.bookIssueUpdate(bookIssue,updateBookIssue.bookIssueId)
              
              Future.successful(Ok(toJson(MsgOK("Book Issue details has been updated succesfully."))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Book Issue details Id does not exist : "))))
              }
          }catch{
            
            case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Any of the Book details should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error : "))))
         } 
   }
 }
 
  
//assignmentcreate
def assignmentcreate = Action.async(parse.json) {
   implicit request =>
     println(" AssignmentCreate ")
     request.body.validate[AssignmentCreate] match {
        case JsSuccess(assignmentCreate, _) =>
             println(" AssignmentCreate Started ")
             var assignment=Assignment( id = 0, assignment_name = assignmentCreate.assignment_name, max_score = assignmentCreate.max_score, 
                 sequence = assignmentCreate.sequence, due_date = assignmentCreate.due_date,remindar_date = assignmentCreate.remindar_date,
                 subjectId = assignmentCreate.subjectId, classId = assignmentCreate.classId)
             assignment=userService.createAssignment(assignment)
             //val courseDetail =  userService.getCourseById(assignment.course_id)
             val subject = userService.getSubjectsById(assignmentCreate.subjectId)
             val classDetail = userService.getClassById(assignmentCreate.classId)
             val getCampus = userService.getCampusDetailsByCampusId(classDetail.campus_id)
             val getOrganization = userService.getOrganizationDetailByOrgId(getCampus.organization_id)
             val assignmentDetails = AssignmentUser (id = assignment.id,assignment_name = assignment.assignment_name,
                    max_score = assignment.max_score,sequence = assignment.sequence,due_date = assignment.due_date,
                    remindar_date = assignment.remindar_date,subjectId = assignment.subjectId,subjectName = subject.subjectName,
                    classId =classDetail.id, class_name = classDetail.class_name,cmId = classDetail.campus_id,campus_name = getCampus.campus_name,
                    oId = getCampus.organization_id,name = getOrganization.name) 
             val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
             "assignmentDetails" -> assignmentDetails))))
             Future.successful(Ok(toJson(MsgOK(" "+assignmentDetails+" Assignment created"))))
             case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }


def assignmentUpdate   = Action.async(parse.json) { implicit request =>
    request.body.validate[AssignmentUpdate] match {
        case JsSuccess(assignmentUpdate, _) =>
          val assignmentIdCheck = userService.checkForAssignmentId(assignmentUpdate.assignmentId)
          try{
              if(assignmentIdCheck != None){
              println(" Assignment Update started ")
              var assignment = Assignment(id = assignmentUpdate.assignmentId, assignment_name = assignmentUpdate.assignment_name, 
                                  max_score = assignmentUpdate.max_score, sequence = assignmentUpdate.sequence,due_date = assignmentUpdate.due_date, 
                                  remindar_date = assignmentUpdate.remindar_date, subjectId = assignmentUpdate.subjectId,classId = assignmentUpdate.classId)
              val result = userService.assignmentUpdate(assignment,assignmentUpdate.assignmentId)
              Future.successful(Ok(toJson(MsgOK("Assignment has been updated succesfully."+result))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Assignment Id does not exist : "+assignmentUpdate.assignmentId))))
              }
          }catch{
            
            case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Campus Name should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error : "+assignmentIdCheck))))
          }
   }
}

  
  /*
   * signUpForStudent
   */
   def signUpForStudent = Action.async(parse.json) { implicit request =>
     val emailResult = null
    request.body.validate[StudentSignUp] match {
      case JsSuccess(studentSignUp, _) =>
        val loginInfo = LoginInfo(CredentialsProvider.Credentials, studentSignUp.identifier)
        
        val studentAdmissionNumberCheck = userService.getStdDetailByStdAdmissionNumberAndCampusId(studentSignUp.Studentadminno,studentSignUp.campusId)
        var stdAdmNoPresent = false
        var StdNumberPresent:String = "Student Admission Number Already Exist : "
        if(studentAdmissionNumberCheck==None){         
          stdAdmNoPresent=true
          println(" student Admission number Not present : "+studentSignUp.Studentadminno)
        }
        else{
          StdNumberPresent ++= studentSignUp.Studentadminno
        }
        if(stdAdmNoPresent)
        {
        (userService.retrieve(loginInfo).map {
          case None =>  /* user not already exists */
            val authInfo = passwordHasher.hash(studentSignUp.password)
            val user = User(id = 0,username = studentSignUp.identifier,loginInfo = loginInfo,firstName = studentSignUp.firstName,middleName = studentSignUp.middleName,
			    lastName = studentSignUp.lastName, DOB = studentSignUp.DOB,Gender = studentSignUp.Gender,address1 = studentSignUp.address1,address2 = studentSignUp.address2,
			    city = studentSignUp.city,state = studentSignUp.state,Deleted = null,roles = Set(SimpleUser))             
            println(s"user created: $user")
            (for {
              user <- userService.save(user)              // Save User Object
              userLogin = UserLogin(id = 0,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = studentSignUp.phoneNumber)              
              userLogin <- userService.saveUserLogin(userLogin)
              // Save User_Login object  
              emailResult = userService.SendRegistrationMail(userLogin.email)
              userContext =  UserContext(id=0,userId = user.id,contextId = studentSignUp.contextId,campusId = studentSignUp.campusId)              
              userContext <- userService.saveUserContext(userContext)     // insert user_context mapping object
              studentDetails =StudentDetail(id=0,user_id = userContext.userId,Studentadminno=studentSignUp.Studentadminno,
                  vehicleId = studentSignUp.vehicleId)
              studentDetails <- userService.saveStudentDetails(studentDetails)               
              context <- userService.getContextById(userContext.contextId)      // get context of the user
              getCampusDetails = userService.getCampusDetailsByCampusId(userContext.campusId)
              getOrganizationDetail = userService.getOrganizationDetailByOrgId(getCampusDetails.organization_id)
              //classObject = userService.getClassById(studentSignUp.classId)
              classObject = userService.getClassById(studentSignUp.classId)
              
              studentUser = createStudentUser(user,userLogin,context,studentDetails,classObject,getCampusDetails,getOrganizationDetail/*,termTypeDetails,termDetails*/)
              
              // insert data to student_class table
              studentClassMap = StudentClassMapping(id=0,user_id=studentDetails.user_id,class_id=classObject.id)
              studentClass <- userService.insertStudentClassMap(studentClassMap)
              //termTypeDetails = TermType(id=0,studentSignUp.termType)
             //termTypeDetails <- userService.getTermType(id=1)
              
              
              //termDetails = Term(id=0,start_date=studentSignUp.termStartDate,end_date=studentSignUp.termEndDate,deleted=0,term_type_id=termTypeDetails.id,campus_id=studentSignUp.campusId, active=1)
              //termDetails <- userService.getTermDetails(termTypeDetails.id)
              
             
              // insert data to user_term table
              userTermDetails = UserTerm(id=0,user_id=studentDetails.user_id,term_id=classObject.term_id,active=1,deleted=classObject.deleted)
              userTermDetails <- userService.saveUserTermDetails(userTermDetails)
              
              authInfo <- authInfoService.save(loginInfo, authInfo)
              authenticator <- env.authenticatorService.create(user)
            } yield {
              println(s"yield1")
              env.eventBus.publish(SignUpEvent(user, request, request2lang))
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),"studentUser" -> studentUser))))
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id))))
            }).flatMap { r => r }
          case Some(u) => /* user already exists!*/ 
            Future.successful(Conflict(toJson(MsgERR("User with such username already exists"))))
        }).flatMap { r => r }
        }
        else
        {
          Future.successful(Conflict(toJson(MsgERR(StdNumberPresent))))
        }
      case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }
  }  
  
   
   //studentUpdate
   def studentUpdate = Action.async(parse.json) { implicit request =>
    request.body.validate[StudentUpdate] match {
      case JsSuccess(studentInfo, _) =>         
          val userDetail = userService.checkForUserId(studentInfo.userId)
          val userLoginDetail = userService.getUserLoginIdByUserId(userDetail.id)
          val userContextId = userService.getUserContextIdByUserIdANDContextId(userDetail.id, studentInfo.contextId)
          val studentDetail = userService.getStudentDetailByUserId(userDetail.id)
          val studentClassMapDetail = userService.getStudentClassMapDetailByUserId(userDetail.id)
          val userTermDetail = userService.getUserTermDetailByUserId(userDetail.id)
          val loginInfo = LoginInfo(CredentialsProvider.Credentials, studentInfo.identifier)
          try{
              if((userDetail) != None){
              println(" Student Update started ")
              
              val user = User(id = userDetail.id,username = studentInfo.identifier,loginInfo = loginInfo,firstName = studentInfo.firstName,middleName = studentInfo.middleName,
              lastName = studentInfo.lastName, DOB = studentInfo.DOB,Gender = studentInfo.Gender,address1 = studentInfo.address1,address2 = studentInfo.address2,
              city = studentInfo.city,state = studentInfo.state,Deleted = null,roles = Set(SimpleUser)) 
              val userResult = userService.userUpdate(user,userDetail.id)
              
              val userLogin = UserLogin(id = userLoginDetail.id,userId = userDetail.id,verified = 1,email = loginInfo.providerKey,phoneNumber = studentInfo.phoneNumber)
              val userLoginResult = userService.userLoginUpdate(userLogin,userLoginDetail.id)
              
              val userContext =  UserContext(id = userContextId.id,userId = userDetail.id,contextId = userContextId.contextId,campusId = studentInfo.campusId)  
              val userContextResult = userService.updateUserContext(userContext,userContextId.id) 
              
              val classObject = userService.getClassById(studentInfo.classId)
              
              val studentDetails =StudentDetail(id=studentDetail.id,user_id = studentDetail.user_id,Studentadminno=studentInfo.Studentadminno,
                  vehicleId = studentInfo.vehicleId)
              val studentDetailsUpdateResult = userService.updateStudentDetails(studentDetails,studentDetail.id)  
              
              val studentClassMap = StudentClassMapping(id=studentClassMapDetail.id,user_id=studentClassMapDetail.user_id,class_id=classObject.id)
              val studentClassUpdateResult = userService.updateStudentClassMap(studentClassMap,studentClassMapDetail.id)
              
              val userTermDetails = UserTerm(id=userTermDetail.id,user_id=userTermDetail.user_id,term_id=classObject.term_id,active=1,deleted=classObject.deleted)
              val userTermUpdateResult = userService.updateUserTermDetails(userTermDetails,userTermDetail.id)
              
              
              
              Future.successful(Ok(toJson(MsgOK("Student details has been updated succesfully."))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Student details Id does not exist"))))
              }
          }catch{
            
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Any of the details should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error "))))
          }    
     }  
   }
   
  
  /***
   * 
   * Guardian Details
   * 
   */
   
   def signUpForGuardian = Action.async(parse.json) { implicit request =>
    request.body.validate[GuardianSignUp] match {
      case JsSuccess(guardiansignUp, _) =>
        val loginInfo = LoginInfo(CredentialsProvider.Credentials, guardiansignUp.identifier)
        var stdNoSplit : Array[String] = guardiansignUp.stdadmissionno.split(',')
        var stdNoNotPresent = false
        var badStdNumbers:String = "Student Admission Number Not Present are : "
        for(stdNo <- stdNoSplit){          
        val std_details = userService.getStdDetailByStdAdmissionNumber(stdNo)
	      if(std_details==None){	       
	        stdNoNotPresent=true
	        badStdNumbers ++= stdNo+", "
	      }
        }
        println("flag student number : "+stdNoNotPresent)
        println("Bad Student Admission Numbers are : " + badStdNumbers)
        
       if(!stdNoNotPresent){
        (userService.retrieve(loginInfo).map {
          case None =>  /* user not already exists */
            val authInfo = passwordHasher.hash(guardiansignUp.password)
            val user = User(id = 0,username = guardiansignUp.identifier,loginInfo = loginInfo,firstName = guardiansignUp.firstName,middleName = guardiansignUp.middleName,
			    lastName = guardiansignUp.lastName, DOB = guardiansignUp.DOB,Gender = guardiansignUp.Gender,address1 = guardiansignUp.address1,address2 = guardiansignUp.address2,
			    city = guardiansignUp.city,state = guardiansignUp.state,Deleted = null,roles = Set(SimpleUser))
           val email1:String=loginInfo.providerKey
           var i = 0
           // println(" Student Details = "+stdDetail)
            println(s"user created: $user")
            (for {
              
              user <- userService.save(user)              // Save User Object
              userLogin = UserLogin(id = 0,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = guardiansignUp.phoneNumber)
              userLogin <- userService.saveUserLogin(userLogin)            // Save User_Login object   
              userContext =  UserContext(id=0,userId = user.id,contextId = 6,campusId = guardiansignUp.campusId)   
              userContext <- userService.saveUserContext(userContext)     // insert user_context mapping object
              guardianDetails = GuardianDetail(id = 0,user_id = userContext.userId,relationship = guardiansignUp.relationship ,mobile = guardiansignUp.mobile,income = guardiansignUp.income,
                  education = guardiansignUp.education,stdadmissionno = guardiansignUp.stdadmissionno)
              guardianDetails <- userService.saveGuardianDetails(guardianDetails)
              context <- userService.getContextById(userContext.contextId)      // get context of the user
              getCampusDetails = userService.getCampusDetailsByCampusId(userContext.campusId)
              getOrganizationDetail = userService.getOrganizationDetailByOrgId(getCampusDetails.organization_id)
              guardianUser = createGuardianUser(user,userLogin,context,guardianDetails,getCampusDetails,getOrganizationDetail)  
              msgResp = insertStudentGuardianMapping(stdNoSplit,guardianDetails,userContext)
              authInfo <- authInfoService.save(loginInfo, authInfo)
              authenticator <- env.authenticatorService.create(user)
            } yield {
              println(s"yield1")
              env.eventBus.publish(SignUpEvent(user, request, request2lang))
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "guardianUser" -> guardianUser))))
                SendRegistrationMail(email1);
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id))))
            }).flatMap { r => r }
          case Some(u) => /* user already exists!*/ 
            Future.successful(Conflict(toJson(MsgERR("User with such username already exists"))))
        }).flatMap { r => r }
       } // END_IF
       else{
         Future.successful(Conflict(toJson(MsgERR(badStdNumbers))))
       }        
      case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }
  }
   
   protected def insertStudentGuardianMapping(stdNoSplit : Array[String],guardianDetails : GuardianDetail,userContext : UserContext): Unit = {
      for(stdNo <- stdNoSplit){          
        var student_Guardian_MappingDetails = Student_Guardian_Mapping(id=0,gid=guardianDetails.id,stdadmissionno= stdNo,user_id=userContext.userId)
        student_Guardian_MappingDetails = userService.createStuGuarMapping(student_Guardian_MappingDetails)
     }
   }
   
  //guardianUpdate
   def guardianUpdate = Action.async(parse.json) { implicit request =>
    request.body.validate[GuardianUpdate] match {
        case JsSuccess(guardianUpdate, _) =>
          var stdNoSplit : Array[String] = guardianUpdate.stdadmissionno.split(',')
        var stdNoNotPresent = false
        var badStdNumbers:String = "Student Admission Number Not Present are : "
        for(stdNo <- stdNoSplit){          
        val std_details = userService.getStdDetailByStdAdmissionNumber(stdNo)
        if(std_details==None){         
          stdNoNotPresent=true
          badStdNumbers ++= stdNo+", "
        }
        }
        println("flag student number : "+stdNoNotPresent)
        println("Bad Student Admission Numbers are : " + badStdNumbers)
        if(!stdNoNotPresent){
          val userDetail = userService.checkForUserId(guardianUpdate.userId)
          val userLoginDetail = userService.getUserLoginIdByUserId(userDetail.id)
          val userContextId = userService.getUserContextIdByUserIdANDContextId(userDetail.id, guardianUpdate.contextId)
          val guardainDetail = userService.getGuardainDetailByUserId(userDetail.id)
          val loginInfo = LoginInfo(CredentialsProvider.Credentials, guardianUpdate.identifier)
          try{
              if((userDetail) != None){
              println(" Staff Update started ")
              
              val user = User(id = userDetail.id,username = guardianUpdate.identifier,loginInfo = loginInfo,firstName = guardianUpdate.firstName,middleName = guardianUpdate.middleName,
              lastName = guardianUpdate.lastName, DOB = guardianUpdate.DOB,Gender = guardianUpdate.Gender,address1 = guardianUpdate.address1,address2 = guardianUpdate.address2,
              city = guardianUpdate.city,state = guardianUpdate.state,Deleted = null,roles = Set(SimpleUser)) 
              val userResult = userService.userUpdate(user,userDetail.id)
              
              val userLogin = UserLogin(id = userLoginDetail.id,userId = userDetail.id,verified = 1,email = loginInfo.providerKey,phoneNumber = guardianUpdate.phoneNumber)
              val userLoginResult = userService.userLoginUpdate(userLogin,userLoginDetail.id)
              
              val userContext =  UserContext(id = userContextId.id,userId = userDetail.id,contextId = userContextId.contextId,campusId = guardianUpdate.campusId)  
              val userContextResult = userService.updateUserContext(userContext,userContextId.id) 
              
              val guardianDetails = GuardianDetail(id = guardainDetail.id,user_id = userDetail.id,relationship = guardianUpdate.relationship ,mobile = guardianUpdate.mobile,income = guardianUpdate.income,
                  education = guardianUpdate.education,stdadmissionno = guardianUpdate.stdadmissionno)
              val guardianDetailsUpdateResult = userService.updateGuardianDetails(guardianDetails,guardainDetail.id)
              
              
              Future.successful(Ok(toJson(MsgOK("Staff details has been updated succesfully."))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Staff details Id does not exist"))))
              }
          }catch{
            
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Any of the details should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error "))))
          }
    } else{
         Future.successful(Conflict(toJson(MsgERR(badStdNumbers))))
       }     
   }  
   }
   
   
   def signUpForDriver = Action.async(parse.json) { implicit request =>
     val emailResult = null
    request.body.validate[DriverSignUp] match {
      case JsSuccess(driverSignUp, _) =>
        val loginInfo = LoginInfo(CredentialsProvider.Credentials, driverSignUp.identifier)
        (userService.retrieve(loginInfo).map {
          case None =>  /* user not already exists */
            val authInfo = passwordHasher.hash(driverSignUp.password)
            val user = User(id = 0,username = driverSignUp.identifier,loginInfo = loginInfo,firstName = driverSignUp.firstName,middleName = driverSignUp.middleName,
          lastName = driverSignUp.lastName, DOB = driverSignUp.DOB,Gender = driverSignUp.Gender,address1 = driverSignUp.address1,address2 = driverSignUp.address2,
          city = driverSignUp.city,state = driverSignUp.state,Deleted = null,roles = Set(SimpleUser))             
            println(s"user created: $user")
            (for {
              user <- userService.save(user)              // Save User Object
              userLogin = UserLogin(id = 0,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = driverSignUp.phoneNumber)              
              userLogin <- userService.saveUserLogin(userLogin)            // Save User_Login object
              emailResult = userService.SendRegistrationMail(userLogin.email)
              userContext =  UserContext(id=0,userId = user.id,contextId = 9,campusId = driverSignUp.campusId)              
              userContext <- userService.saveUserContext(userContext)     // insert user_context mapping object
              driverDetails = DriverDetail(id = 0, DLno = driverSignUp.DLno, user_id=userContext.userId,vehicleid=driverSignUp.vehicleid)
              driverDetails <- userService.saveDriverDetails(driverDetails)               
              context <- userService.getContextById(userContext.contextId) 
              getCampusDetails = userService.getCampusDetailsByCampusId(userContext.campusId)
              getOrganizationDetail = userService.getOrganizationDetailByOrgId(getCampusDetails.organization_id)
              driverUser = createDriverUser(user,userLogin,context,driverDetails,getCampusDetails,getOrganizationDetail)
              authInfo <- authInfoService.save(loginInfo, authInfo)
              authenticator <- env.authenticatorService.create(user)
            } yield {
              println(s"yield1")
              env.eventBus.publish(SignUpEvent(user, request, request2lang))
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),"driverUser" -> driverUser))))
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id))))
            }).flatMap { r => r }
          case Some(u) =>  
            Future.successful(Conflict(toJson(MsgERR("User with such username already exists"))))
        }).flatMap { r => r }
      case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }
  } 
   
   
//driverUpdate
   def driverUpdate   = Action.async(parse.json) { implicit request =>
    request.body.validate[DriverUpdate] match {
        case JsSuccess(driverUpdate, _) =>
          val userIdCheck = userService.checkForUserId(driverUpdate.userId)
          val userLoginId = userService.getUserLoginIdByUserId(userIdCheck.id)
          val userContextId = userService.getUserContextIdByUserIdANDContextId(driverUpdate.userId, driverUpdate.contextId)
          val driverIdCheck = userService.getDriverIdByUserId(driverUpdate.userId)
          val loginInfo = LoginInfo(CredentialsProvider.Credentials, driverUpdate.identifier)
          try{
              if((userIdCheck) != None){
              println(" Librarian Update started ")
              
              val user = User(id = driverUpdate.userId,username = driverUpdate.identifier,loginInfo = loginInfo,firstName = driverUpdate.firstName,middleName = driverUpdate.middleName,
              lastName = driverUpdate.lastName, DOB = driverUpdate.DOB,Gender = driverUpdate.Gender,address1 = driverUpdate.address1,address2 = driverUpdate.address2,
              city = driverUpdate.city,state = driverUpdate.state,Deleted = null,roles = Set(SimpleUser)) 
              val userResult = userService.userUpdate(user,driverUpdate.userId)
              
              val userLogin = UserLogin(id = userLoginId.id,userId = user.id,verified = 1,email = loginInfo.providerKey,phoneNumber = driverUpdate.phoneNumber)
              val userLoginResult = userService.userLoginUpdate(userLogin,userLoginId.id)
              
              val userContext =  UserContext(id = userContextId.id,userId = driverUpdate.userId,contextId = 8,campusId = driverUpdate.campusId)  
              val userContextResult = userService.updateUserContext(userContext,userContextId.id) 
              
              val driverDetails = DriverInfo(id = driverIdCheck.id, DLno = driverUpdate.DLno, user_id=driverUpdate.userId,vehicleid=driverUpdate.vehicleid)
              val driverResult = userService.updateDriver(driverDetails,driverIdCheck.id)
              
              
              Future.successful(Ok(toJson(MsgOK("Drver details has been updated succesfully."))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Driver details Id does not exist"))))
              }
          }catch{
            
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(Ok(toJson(MsgOK("Any of the Book details should not be null"))))
                        Future.successful(BadRequest(toJson(MsgERR("Error "))))
          }
    }
   }
 
   
   def createVehicleCompleteDetail = Action.async(parse.json) {implicit request =>
     println(" createVehicleCompleteDetail ")
     request.body.validate[CreateVehicleDetail] match {
        case JsSuccess(createVehicleDetail, _) =>
          var vehicleType = userService.getVehicleTypeById(createVehicleDetail.Vehicle_type_id)
          var check : Boolean = true
          if(vehicleType == None)
            check = false
            if(check)
            {
              println(" Testing ")
                    var vehicleDetails = VehicleDetail(id=0,Vehicle_no = createVehicleDetail.Vehicle_no,
                        Vehicle_code = createVehicleDetail.Vehicle_code, No_of_Seat = createVehicleDetail.No_of_Seat,
                        Maximum_capacity = createVehicleDetail.Maximum_capacity, insurance = createVehicleDetail.insurance,
                        tax_remitted = createVehicleDetail.tax_remitted, permit = createVehicleDetail.permit, status = createVehicleDetail.status,
                        Vehicle_type_id = createVehicleDetail.Vehicle_type_id, campusId = createVehicleDetail.campusId)
                    vehicleDetails = userService.createVehicleDetails(vehicleDetails) 
                    var routeDetails = saveRouteDetail(createVehicleDetail,vehicleDetails)
                    routeDetails = userService.createRouteDetails(routeDetails)
                    var i : Int = 0
                    var num : Int = routeDetails.No_of_Stops
                    var stopDetail = saveStopDetail(createVehicleDetail,routeDetails)
                    var stopNameSplit : Array[String] = createVehicleDetail.Stop_Name.split(',')
                    var stopFareSplit : Array[String] = createVehicleDetail.fare.split(',')
                    var arivalMorning : Array[String] = createVehicleDetail.Arival_Mrng.split(',')
                    var departureMorning : Array[String] = createVehicleDetail.Departure_Mrng.split(',')
                    var arivalEvening : Array[String] = createVehicleDetail.Arival_Evng.split(',')
                    var departureEvening : Array[String] = createVehicleDetail.Departure_Evng.split(',')
                    var count1,count2,count3,count4,count5 : Int = 0
                    //val vehicleType = userService.getVehicleTypeById(vehicleDetails.Vehicle_type_id)
                    for(stpName <- stopNameSplit)
                    {
                      println(stpName+" ")
                      count1 = count1+1
                      //stpNameArray[i]=stpName
                    }
                    for(arivalMor <- arivalMorning){
                      println(arivalMor+" ")
                      count2 +=1
                    }
                    for(departureMor <- departureMorning){
                      println(departureMor+" ")
                      count3 +=1
                    }
                    for(arivalEve <- arivalEvening){
                      println(arivalEve+" ")
                      count4 +=1
                    }
                    for(departureEve <- departureEvening){
                      println(departureEve+" ")
                      count5 +=1
                    }
                    for(stpFare <- stopFareSplit)
                    {
                      println(stpFare+" ")
                    }
                    println(" Number of stops : "+num)
                    println(" Number of stop names : "+count1)
                    if(num == count1)
                    {
                            for(i <- 0 to (num-1))
                            {
                              stopDetail.Stop_Name = stopNameSplit(i)
                              stopDetail.fare = stopFareSplit(i)  
                              stopDetail.Arival_Mrng = arivalMorning(i)
                              stopDetail.Departure_Mrng = departureMorning(i)
                              stopDetail.Arival_Evng = arivalEvening(i)
                              stopDetail.Departure_Evng = departureEvening(i)
                              stopDetail = userService.createStopDetail(stopDetail)
                            } 
                    }
                    else
                    {
                            Future.successful(BadRequest(toJson(MsgERR(" Please check Number of stops should be equal to Number of stop names"))))
                    }
                    var createVehicleDetailUser = createVDUser(vehicleDetails,routeDetails,stopDetail,vehicleType)
                    val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                    "createVehicleDetailUser" -> createVehicleDetailUser))))
                    Future.successful(Ok(toJson(MsgOK("Details of vehicle has been created succesfully."+createVehicleDetailUser))))
            }
            else{
               Future.successful(Conflict(toJson(MsgERR(" Please Provide Correct Vehicle Type Id its Not Valid"))))
            }
                    case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
   }
   
   //vehicleUpdate
   def vehicleUpdate = Action.async(parse.json) { implicit request =>
     request.body.validate[VehicleUpdate] match {
        case JsSuccess(vehicleUpdate, _) =>
          val vehicleObject = userService.getVehicleDetailByVehicleId(vehicleUpdate.vehicleId)
          val vehcileTypeObject = userService.getVehicleTypeById(vehicleObject.Vehicle_type_id)
          val routeDetailObject = userService.getRouteDetailByVehicleId(vehicleObject.id)
          val stopDetailObjectList = userService.getStopDetailByRouteId(routeDetailObject.rdId)
          try{
              if(vehicleObject != None){
                println(" Vehicle Update started ")
                 val vehicleDetail = VehicleDetail(id=vehicleObject.id,Vehicle_no = vehicleUpdate.Vehicle_no,
                        Vehicle_code = vehicleUpdate.Vehicle_code, No_of_Seat = vehicleUpdate.No_of_Seat,
                        Maximum_capacity = vehicleUpdate.Maximum_capacity, insurance = vehicleUpdate.insurance,
                        tax_remitted = vehicleUpdate.tax_remitted, permit = vehicleUpdate.permit, status = vehicleUpdate.status,
                        Vehicle_type_id = vehicleUpdate.Vehicle_type_id, campusId = vehicleUpdate.campusId)
                  val resultVehicleDetails = userService.vehicleDetailsUpdate(vehicleDetail,vehicleObject.id)
                  
                  val route = RouteDetail(rdId=routeDetailObject.rdId, Route_Name = vehicleUpdate.Route_Name, No_of_Stops = vehicleUpdate.No_of_Stops,
                              Vehicle_id = vehicleObject.id) 
                  val resultRouteUpdate = userService.updateRoute(route,routeDetailObject.rdId)  
                  
                  var i,j : Int = 0
                  var num : Int = vehicleUpdate.No_of_Stops
                  var stopNameSplit : Array[String] = vehicleUpdate.Stop_Name.split(',')
                  var stopFareSplit : Array[String] = vehicleUpdate.fare.split(',')
                  var arivalMorning : Array[String] = vehicleUpdate.Arival_Mrng.split(',')
                  var departureMorning : Array[String] = vehicleUpdate.Departure_Mrng.split(',')
                  var arivalEvening : Array[String] = vehicleUpdate.Arival_Evng.split(',')
                  var departureEvening : Array[String] = vehicleUpdate.Departure_Evng.split(',')
                  var count1,count2,count3,count4,count5 : Int = 0
                  for(stpName <- stopNameSplit)
                    {
                      println(stpName+" ")
                      count1 = count1+1
                      //stpNameArray[i]=stpName
                    }
                    for(arivalMor <- arivalMorning){
                      println(arivalMor+" ")
                      count2 +=1
                    }
                    for(departureMor <- departureMorning){
                      println(departureMor+" ")
                      count3 +=1
                    }
                    for(arivalEve <- arivalEvening){
                      println(arivalEve+" ")
                      count4 +=1
                    }
                    for(departureEve <- departureEvening){
                      println(departureEve+" ")
                      count5 +=1
                    }
                    for(stpFare <- stopFareSplit)
                    {
                      println(stpFare+" ")
                    }
                    //j <- 0 to (num-1) && 
                    println(" Number of stops : "+num)
                    println(" Number of stop names : "+count1)
                    i = stopDetailObjectList.size
                    println(" Size of Stop List : "+i+" No_of_Stops : "+num+" Stop Name Count : "+count1)
                    if(num == count1)
                    {
                      for(stopDetailObject <- stopDetailObjectList)
                      {
                  var stop = StopDetail(id=stopDetailObject.id, Stop_Name = stopNameSplit(j), fare = stopFareSplit(j), 
                             Arival_Mrng = arivalMorning(j), Departure_Mrng = departureMorning(j), 
                             Arival_Evng = arivalEvening(j), Departure_Evng = departureEvening(j),
                             Route_details_id = routeDetailObject.rdId)  
                             println(" J value From Stop Detail : "+j)
                             j+=1
                             println(" Stop Object : "+stop)
                  var stopUdateResult = userService.updateStopDetail(stop,stopDetailObject.id)
                      }
                    }
                    else
                    {
                            Future.successful(BadRequest(toJson(MsgERR(" Please check Number of stops should be equal to Number of stop names"))))
                    }
  
  
                  Future.successful(Ok(toJson(MsgOK("Vehicle has been updated succesfully...!"))))
              }    
              else{
                Future.successful(Ok(toJson(MsgERR("Vehicle Id does not exist : "))))
              }
          }catch{
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                       Future.successful(BadRequest(toJson(MsgERR("Any of the field should not be null (OR) Vehicle Id Does Not Exist"))))
     }
     }
 }
   
   
  /*
   * medicalCreate
   */
   def medicalCreate = Action.async(parse.json) { implicit request =>
     println(" medicalCreate ")
     request.body.validate[MedicalCreate] match {
        case JsSuccess(medicalCreate, _) =>
              println(" MedicalCreate Testing ")
              //var context = userService.getContextById(userContext.contextId) 
              //var userLogin = userService.getUser
              var medical = Medical(id=0,user_id = medicalCreate.userId,Bloodgroup = medicalCreate.Bloodgroup,
                  height = medicalCreate.height,weight = medicalCreate.weight, ailment = medicalCreate.ailment,
                  Doctorname=medicalCreate.Doctorname,Doctor_address=medicalCreate.Doctor_address,Mobile=medicalCreate.Mobile)
              medical = userService.createMedical(medical) 
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
              "medical" -> medical))))
              Future.successful(Ok(toJson(MsgOK("Medical Details has been created succesfully."))))
              case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
   
 //medicalUpdate
   def medicalUpdate = Action.async(parse.json) { implicit request =>
     request.body.validate[MedicalUpdate] match {
        case JsSuccess(medicalEdit, _) =>
          try{
             val medicalIdCheck = userService.checkForMedicalId(medicalEdit.medicalId)
              if(medicalIdCheck != None){
                println(" Medical Update started ")
                 var medical = Medical(id=medicalEdit.medicalId,user_id = medicalEdit.userId,Bloodgroup = medicalEdit.Bloodgroup,
                  height = medicalEdit.height,weight = medicalEdit.weight, ailment = medicalEdit.ailment,
                  Doctorname=medicalEdit.Doctorname,Doctor_address=medicalEdit.Doctor_address,Mobile=medicalEdit.Mobile)
                  val result = userService.medicalUpdate(medical,medicalEdit.medicalId)
                  Future.successful(Ok(toJson(MsgOK("Medical has been updated succesfully...!"+result))))
              }    
              else{
                Future.successful(Ok(toJson(MsgERR("Marks Id does not exist : "+medicalEdit.medicalId))))
              }
          }catch{
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                       Future.successful(BadRequest(toJson(MsgERR("Any of the field should not be null (OR) Medical Id Does Not Exist"))))
     }
     }
 }
 
 //file upload
 
 def uploadfile = Action(parse.multipartFormData) { implicit request =>
   println("yes enter into upload file")
    val result = userService.uploadFile(request)
     Ok(toJson(result))
  }
 
 
 def sendSMS = Action.async(parse.json) { implicit request =>
     println(" send SMS ")
     request.body.validate[SendSMS] match {
        case JsSuccess(sendsms, _) =>
              println(" Send SMS Started ")
              var sendMessage =  sendMessageMethod(sendsms.phonenumber, sendsms.message)
              //val result = sendMessage(sendsms.phonenumber.toString(), sendsms.message)
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
              "sendMessage" -> "welcome to MSG Service"))))
              Future.successful(Ok(toJson(MsgOK("Message has been sent succesfully."))))
              case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
 
 def sendMessageMethod(phoneNumber : Long,message1 : String) : Unit = {
    val st = new StringTokenizer(message1, " ");
    val sb = new StringBuffer();
    while(st.hasMoreElements()){
        sb.append(st.nextElement()).append("%20");
   }
   if(message1.contains(" ")){
     println(" If Block Message 1 : "+message1)
   }
   else{
     println(" Else Block Message 1 : "+message1)
   }
    val recipient: String  = phoneNumber.toString()
    println(" sendMessageMethod Phone Number : "+recipient)
    val  message : String  = sb.toString().trim();
    println(" sendMessageMethod Message : "+message)
    val username: String  = "Minds";
    val password: String  = "1358919004";
    val originator:String= "+440987654321";
    val sendername:String ="MINDSI";
    val mobileno:String  = phoneNumber.toString()
    println(" Enterd into send sms")
    val requestUrl:String = " http://bulksms.mysmsmantra.com:8080/WebSMS/SMSAPI.jsp?username=" +username+ "&password=" +password+ "&sendername=" +sendername+ "&mobileno=" +mobileno+ "&message=" +message.trim()+"";
    println(" Rquest Url : "+requestUrl)
    val url = new URL(requestUrl);
    val conn = url.openConnection.asInstanceOf[HttpURLConnection]
    println("Connection Result : "+conn.getResponseMessage());
    conn.disconnect()
    println(" Message Rocks")
  }
 
 
 
         
def buildRequestString(targetPhoneNo : String,  msg : String) : String = {
         println(" welcome from BuildRequestString Method ")
         val _userName = "9986064613"
         val _password = "1234554321"
         val _url = "http://smsapi.cikly.in/index.php" 
         val charset = "UTF-8";
         val params = new Array[String](5);
         params(0) = _userName;
         params(1) = _password;
         params(2) = msg;
         params(3) = targetPhoneNo;
         params(4) = "smsapi.cikly.in";
         //val query : String = "uid="+params(0)+"&pwd="+params(1)+"&msg="+params(2)+"&phone="+params(3)+"&provider="+params(4) 
         /*URLEncoder.encode(params(0) charset) 
         URLEncoder.encode(params(1) charset) 
         URLEncoder.encode(params(2) charset) 
         URLEncoder.encode(params(3) charset) 
         URLEncoder.encode(params(4) charset)*/
         val query = String.format("uid=%s&pwd=%s&msg=%s&phone=%s&provider=%s",
         URLEncoder.encode(params(0),charset),
         URLEncoder.encode(params(1),charset),
         URLEncoder.encode(params(2),charset),
         URLEncoder.encode(params(3),charset),
         URLEncoder.encode(params(4),charset)
);       
         
         println(" Query : "+query)
         println(" Message From Site2SMS : "+msg)
         println(" SMS Rocks from buildRequest ")
         query
 }
def sendMessage(reciever : String, msg : String) : Unit = {
         val _url = "http://smsapi.cikly.in/index.php" 
         val charset = "UTF-8";
         println(" Hello!hello You are in sendMessage");
         val connection : URLConnection = new URL(_url + "?" + buildRequestString(reciever,msg)).openConnection();
         println(" SMS Rocks from SendMessage : "+connection)
         connection.setRequestProperty("Accept-Charset",charset);
 }
         
/*//sendsms
 
  def loginForm = Form(mapping("phonenumber" -> text)
      (LoginRequest.apply)(LoginRequest.unapply))
  
  case class LoginRequest(phonenumber:String)
 
 def sendsms = Action.async { implicit request =>
    val loginRequest = loginForm.bindFromRequest.get
    Ok(s"username: '${loginRequest.phonenumber}")
    val recipient: String  = loginRequest.phonenumber
    val  message : String  = "Greetings Welcome To Minds ELS Enjoy Karo";
    val username: String  = "Minds";
    val password: String  = "1358919004";
    val originator:String= "+440987654321";
    val sendername:String ="MINDSI";
    val mobileno:String  =loginRequest.phonenumber;
    println("enterd into send sms")
    val requestUrl:String = " http://bulksms.mysmsmantra.com:8080/WebSMS/SMSAPI.jsp?username=" +username+ "&password=" +password+ "&sendername=" +sendername+ "&mobileno=" +mobileno+ "&message=" +message+"";
    println(requestUrl)
    val url = new URL(requestUrl);
    val conn = url.openConnection.asInstanceOf[HttpURLConnection]
    System.out.println(conn.getResponseMessage());
    conn.disconnect()
    Future(Ok(toJson("Message sent successfully.....!")))
  }*/
    
  
 
   
   //subjectsListById
   
   def subject = Action.async(parse.json) { implicit request =>
     println(" Subject Create ")
     request.body.validate[SubjectDetail] match {
        case JsSuccess(subjectDetail, _) =>
              println(" SubjectDetail Testing ")
              var subject = userService.getSubjectsById(subjectDetail.subjectId)
              var subjectClassMap = SubjectClassMap(SubClassId=subjectDetail.SubClassId,subjectId=subjectDetail.subjectId,classId=subjectDetail.classId)
              subjectClassMap = userService.insertSubjectClassMap(subjectClassMap)
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
              "SubjectClassMap" -> subjectClassMap))))
              Future.successful(Ok(toJson(MsgOK("Subject Details has been created succesfully."))))
              case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }

   
//exam
def exam = Action.async(parse.json) { implicit request =>
     println(" Exam Create ")
     request.body.validate[ExamDetail] match {
        case JsSuccess(examDetail, _) =>
              println(" ExamDetail Testing ")
              var exam = userService.getExamDetailByExamId(examDetail.examId)
              var examClassMap = ExamClassMap(ecmId = 0,examId = exam.id,classId = examDetail.classId,
                  termId = examDetail.termId, createdAt = exam.createAt,updateAt = exam.updateAt)
              examClassMap = userService.insertExamClassMap(examClassMap)
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
              "examClassMap" -> examClassMap))))
              Future.successful(Ok(toJson(MsgOK("Exam Details has been created succesfully."))))
              case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }



 def examTimeTable(examTimeTableDetailList : List[ExamTimeTableDetail]) = Action.async { request =>
    for(examTimeTableDetail <- examTimeTableDetailList){
      var examTimeTable = ExamTimeTable(
         id = 0,ecmapId = examTimeTableDetail.ecmapId,subjectId = examTimeTableDetail.subjectId,
                  examDate = examTimeTableDetail.examDate,fromTime = examTimeTableDetail.fromTime, toTime = examTimeTableDetail.toTime,
                  status = examTimeTableDetail.status, createdAt = Calendar.getInstance().getTime().toString(),
                  updatedAt = Calendar.getInstance().getTime().toString())
          examTimeTable = userService.createExamTimeTable(examTimeTable)
         // attendanceListSimple += attendance
    }
    Future(Ok(toJson("Exam Time Table created successfully.....!")))
  }
 
 //marks
 def marks = Action.async(parse.json) { implicit request =>
     println(" Marks Create ")
     request.body.validate[MarksDetails] match {
        case JsSuccess(marksDetail, _) =>
              println(" MarksDetail Testing ")
              var marks = Marks(id = 0, ecmId = marksDetail.ecmId,studentId = marksDetail.studentId,subjectId = marksDetail.subjectId,
                  maxMarks = marksDetail.maxMarks,minMarks = marksDetail.minMarks,marksObtained = marksDetail.marksObtained, 
                  marksInWords = marksDetail.marksInWords, remarks = marksDetail.remarks)
              marks = userService.saveMarks(marks)
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
              "marks" -> marks))))
              Future.successful(Ok(toJson(MsgOK("Marks Details has been created succesfully."+marks))))
              case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
 
 
 
 //marksUpdate
 def marksUpdate = Action.async(parse.json) { implicit request =>
     request.body.validate[MarksUpdate] match {
        case JsSuccess(marksUpdate, _) =>
          try{
             val marksIdCheck = userService.checkForMarksId(marksUpdate.marksId)
              if(marksIdCheck != None){
                println(" Marks Update started ")
                 var marks = Marks(id = marksUpdate.marksId, ecmId = marksUpdate.ecmId,studentId = marksUpdate.studentId,
                     subjectId = marksUpdate.subjectId,maxMarks = marksUpdate.maxMarks,minMarks = marksUpdate.minMarks,
                     marksObtained = marksUpdate.marksObtained, marksInWords = marksUpdate.marksInWords, remarks = marksUpdate.remarks)
                  val result = userService.marksUpdate(marks,marksUpdate.marksId)
                  Future.successful(Ok(toJson(MsgOK("Marks has been updated succesfully...!"+result))))
              }    
              else{
                Future.successful(Ok(toJson(MsgERR("Marks Id does not exist : "+marksUpdate.marksId))))
              }
          }catch{
           case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                       Future.successful(BadRequest(toJson(MsgERR("Any of the field should not be null (OR) Marks Id Does Not Exist"))))
     }
     }
 }
 
 
 
 //StaffClassMapping
 def StaffClassMapping = Action.async(parse.json) { implicit request =>
     println(" Staff Time Table Creation started ")
     request.body.validate[StaffTimeTable] match {
        case JsSuccess(staffTimeTable, _) =>
        var checkForStaffSubjectMap = userService.getSubjectIdByStaffUserId(staffTimeTable.staffId)
        println(checkForStaffSubjectMap+" : checkForStaffSubjectMap ")
        if(checkForStaffSubjectMap.subjectId == staffTimeTable.subjectId){
                var checkForSubjectAndStaffUserIdWithClass = userService.checkForSubjectAndStaffUserIdWithClass(staffTimeTable.classId,
                staffTimeTable.subjectId,staffTimeTable.staffId)
                println("Result : "+checkForSubjectAndStaffUserIdWithClass)
                if(checkForSubjectAndStaffUserIdWithClass == None)
                {
                        println("IF BLOCK STARTED")
                        var subjectClassStaffMap = userService.getMappingStaffClassSubjectByClassIdAndUserId(staffTimeTable.classId,staffTimeTable.staffId)
                        println("\n SubjectClassId : "+subjectClassStaffMap.subjectClassId+"\n StaffUserId : "+staffTimeTable.staffId)
                        var staffClassMap = StaffClassMap(id = 0, classId = subjectClassStaffMap.classId,userId = staffTimeTable.staffId)
                        
                        staffClassMap = userService.saveStaffClassMap(staffClassMap)
                        val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                        "staffClassMap" -> staffClassMap))))
                        Future.successful(Ok(toJson(MsgOK("Staff Class Map has been created succesfully."))))
                }else{
                       var result = "Please Provided Correct ClassId,SubjectId and StaffUserId Bcz Already Assigned Same Staff for Same Subject for Same Class At Same Time"
                       Future.successful(Conflict(toJson(MsgERR(result+""))))
               }
          }else{
            var result = "Selected Staff Dosen't Handle Given SubjectId"
            Future.successful(Conflict(toJson(MsgERR(result))))
          }
        case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
 
  def classTimeTable(cLassTimeTableDetailList : List[CLassTimeTableDetail]) = Action.async { request =>
    for(cLassTimeTableDetail <- cLassTimeTableDetailList){
      var cLassTimeTable = ClassTimeTable(
         id = 0,classId = cLassTimeTableDetail.classId,
         Day = cLassTimeTableDetail.Day,
         pOne = cLassTimeTableDetail.pOne,
         pTwo = cLassTimeTableDetail.pTwo,
         pThree = cLassTimeTableDetail.pThree,
         pFour = cLassTimeTableDetail.pFour,
         pFive = cLassTimeTableDetail.pFive,
         pSix = cLassTimeTableDetail.pSix,
         pSeven = cLassTimeTableDetail.pSeven,
         pEight = cLassTimeTableDetail.pEight,
         createdAt = Calendar.getInstance().getTime().toString(),
         updatedAt = Calendar.getInstance().getTime().toString())
         cLassTimeTable = userService.createClassTimeTable(cLassTimeTable)
    }
    Future(Ok(toJson("Class Time Table created successfully.....!")))
  }
 
 
//eventcreate
 def eventCreate = Action.async(parse.json) { implicit request =>
     println(" eventCreate ")
     request.body.validate[EventCreate] match {
        case JsSuccess(eventCreate, _) =>
              println(" EventCreate Testing ")
              val eventMaster = userService.getEventMasterById(eventCreate.evId)
              var eventObject = Events(id=0,evId=eventCreate.evId,startDate = eventCreate.startDate,endDate = eventCreate.endDate,
                  studUserId=eventCreate.studId, campusId = eventCreate.campusId,messageFlag = 0)
              eventObject = userService.createEvent(eventObject) 
              var eventUser = EventsUser(id=eventObject.id,evId=eventCreate.evId,name = eventMaster.Name, desc = eventMaster.desc,
                  startDate = eventCreate.startDate,endDate = eventCreate.endDate,studUserId=eventCreate.studId, 
                  campusId = eventCreate.campusId, status = eventMaster.status, messageFlag = eventObject.messageFlag)
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
              "eventUser" -> eventUser))))
              Future.successful(Ok(toJson(MsgOK("Events Detail has been created succesfully."+eventUser))))
              case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
 
 //eventUpdate
 def eventUpdate = Action.async(parse.json) { implicit request =>
     request.body.validate[EventUpdate] match {
        case JsSuccess(event, _) =>
              println(" Event Update ")
              try{
             val eventIdCheck = userService.checkForeventId(event.eventId)
              if(eventIdCheck != None){
                println(" Event Update started ")
                 var eventObject = Events(id=event.eventId,evId=event.evId,startDate = event.startDate,
                  endDate = event.endDate,studUserId=event.studId, campusId = event.campusId,messageFlag = 0)
                  val result = userService.eventUpdate(eventObject,event.eventId)
                  Future.successful(Ok(toJson(MsgOK("Events has been updated succesfully...!"+result))))
              }    
              else{
                Future.successful(Ok(toJson(MsgERR("Event Id does not exist : "+event.eventId))))
              }
          }catch{
            case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(BadRequest(toJson(MsgERR("Any of the field should not be null (OR) Event Id Does Not Exist"))))
     }
     }
 }
 
 
 
 
 //schoolNews
   def schoolNews = Action.async(parse.json) { implicit request =>
     println(" schoolNews ")
     request.body.validate[SchoolNewsDetail] match {
        case JsSuccess(schoolNewsDetail, _) =>
              println(" School News Testing ")
              var schoolNews = SchoolNews(id=0,schoolId = schoolNewsDetail.schoolId,headLines = schoolNewsDetail.headLines,
                  newsDesc=schoolNewsDetail.newsDesc,newsDate=schoolNewsDetail.newsDate.toString(), status = schoolNewsDetail.status)
              schoolNews = userService.insertSchoolNews(schoolNews) 
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
              "schoolNews" -> schoolNews))))
              Future.successful(Ok(toJson(MsgOK("School News Detail has been created succesfully."+schoolNews))))
              case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
 
//newsUpdate
   def newsUpdate = Action.async(parse.json) { implicit request =>
  println("News Update Started")
     request.body.validate[NewsUpdate] match {
        case JsSuccess(news, _) =>
          try{
             val newsIdCheck = userService.checkForNewsId(news.newsId)
              if(newsIdCheck != None){
                println(" School News Update started ")
              var schoolNews = SchoolNews(id=news.newsId,schoolId = news.schoolId,headLines = news.headLines,
                  newsDesc=news.newsDesc,newsDate=news.newsDate.toString(), status = news.status)
                  val result = userService.newsUpdate(schoolNews,news.newsId)
                  Future.successful(Ok(toJson(MsgOK("School News has been updated succesfully...!"+result))))
              }    
              else{
                Future.successful(Ok(toJson(MsgERR("News Id does not exist : "+news.newsId))))
              }
          }catch{
            
            case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(BadRequest(toJson(MsgERR("Any of the field should not be null (OR) News Id Does Not Exist : "))))
     }
  }
}
   
   
 //createOrganization 
   def createOrganization = Action.async(parse.json) { implicit request =>
     println(" OrgnizationCreate ")
     request.body.validate[OrganizationCreate] match {
        case JsSuccess(organizationCreate, _) =>
              println(" OrganizationCreate Testing ")
              var organization = Organization(id=0,name=organizationCreate.name,Type=organizationCreate.Type,
                  activated=organizationCreate.activated,paid=organizationCreate.paid,deleted=organizationCreate.deleted)
               organization  = userService.createOrganization(organization)
               val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
               "organization" -> organization))))
               Future.successful(Ok(toJson(MsgOK("Details of Organization has been created succesfully."+organization))))
               case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
   
//organizationUpdate
def organizationUpdate = Action.async(parse.json) { implicit request =>
     println(" Organization Update ")
     request.body.validate[OrganizationUpdate] match {
        case JsSuccess(organizationUpdate, _) =>
              println(" Organization Update Testing ")
              var organization = Organization(id=organizationUpdate.organizationId,name=organizationUpdate.name,Type=organizationUpdate.Type,
                  activated=organizationUpdate.activated,paid=organizationUpdate.paid,deleted=organizationUpdate.deleted)
               println(" CreateUpdate Begins ")
              val result = userService.organizationUpdate(organization,organizationUpdate.organizationId)
               val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
               "organization" -> organization))))
               Future.successful(Ok(toJson(MsgOK("Organization has been updated succesfully...!"+result))))
               case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }

 //school
def createSchool = Action.async(parse.json) { implicit request =>
     println(" SchoolCreate ")
     request.body.validate[SchoolCreate] match {
        case JsSuccess(schoolCreate, _) =>
              println(" SchoolCreate Testing ")
              var school = School(id=0,Photo_file_name=schoolCreate.Photo_file_name,Photo_Content_Type=schoolCreate.Photo_Content_Type,Photo_file_Size=schoolCreate.Photo_file_Size,Photo_data_blob=schoolCreate.Photo_data_blob,
                  Campus_ID=schoolCreate.Campus_ID,holidayId = schoolCreate.holidayId)
             
                   school  = userService.createSchool(school) 
                    
                   
                    val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj(
                    "school" -> school))))
                    Future.successful(Ok(toJson(MsgOK("Details of School has been created succesfully."))))
                    
                 case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }


//schoolUpdate
def schoolUpdate = Action.async(parse.json) { implicit request =>
     request.body.validate[SchoolUpdate] match {
        case JsSuccess(schoolData, _) =>
        //  val SchoolIdCheck = userService.checkForSchoolId(schoolData.schoolLogoId)
            //try{
             // if(SchoolIdCheck != None){
              println(" School Update started ")
              var school = School(id=schoolData.schoolLogoId,Photo_file_name=schoolData.Photo_file_name,
                  Photo_Content_Type=schoolData.Photo_Content_Type, Photo_file_Size=schoolData.Photo_file_Size,
                  Photo_data_blob=schoolData.Photo_data_blob, Campus_ID=schoolData.Campus_ID,holidayId = schoolData.holidayId)
              val result = userService.schoolUpdate(school,schoolData.schoolLogoId)
              Future.successful(Ok(toJson(MsgOK("School Details has been updated succesfully."+result))))
             // }
            //  else{
            //    Future.successful(Ok(toJson(MsgERR("School Id does not exist : "+schoolData.schoolLogoId))))
            //  }
         // }catch{
            
            case JsError(e) => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(BadRequest(toJson(MsgERR("Any of the field should not be null (OR) School Id Does Not Exist : "))))
    // }
     }
 }


//holidayUpdate
def holidayUpdate = Action.async(parse.json) { implicit request =>
  println("Holiday Update Started")
     request.body.validate[HolidayUpdate] match {
        case JsSuccess(holidayData, _) =>
          try{
             val holidayIdCheck = userService.checkForHolidayId(holidayData.hoildayId)
              if(holidayIdCheck != None){
              println(" Holiday Update started ")
              var holiday = Holiday(hId = holidayIdCheck.hId, holidayDate = holidayData.holidayDate, 
                  holidayName = holidayData.holidayName, hoildayDesc = holidayData.hoildayDesc,
                  campusId = holidayData.campusId,messageFlag=0)
              val result = userService.holidayUpdate(holiday,holidayIdCheck.hId)
              Future.successful(Ok(toJson(MsgOK("Holiday has been updated succesfully."+result))))
              }
              else{
                Future.successful(Ok(toJson(MsgERR("Holiday Id does not exist : "+holidayData.hoildayId))))
              }
          }catch{
            
            case e : Exception => //Logger.error("Campus is having some exceptions : " + e)
                        Future.successful(BadRequest(toJson(MsgERR("Any of the field should not be null (OR) Holiday Id Does Not Exist : "))))
     }
  }
}


def createHoliday = Action.async(parse.json) { implicit request =>
     println(" HolidayCreate ")
     request.body.validate[HolidayCreate] match {
        case JsSuccess(holidayCreate, _) =>
              println(" HolidayCreate Testing ")
              var holiday = Holiday(hId = 0, holidayDate = holidayCreate.holidayDate, holidayName = holidayCreate.holidayName, hoildayDesc = holidayCreate.hoildayDesc,
                  campusId = holidayCreate.campusId,messageFlag=0)
              holiday  = userService.createHoliday(holiday) 
              val response = Ok(toJson(MsgOK("You have been signed up succesfully.", Json.obj("holiday" -> holiday))))
              Future.successful(Ok(toJson(MsgOK("Holiday Details has been created succesfully."+holiday))))
              case JsError(e) => Future.successful(BadRequest(toJson(MsgERR("Error", JsError.toFlatJson(e)))))
     }
 }
   

 def createStudentAttendance(attendanceUserList : List[AttendanceUser]) = Action.async { request =>
   // var attendanceListSimple = new ListBuffer[AttendanceList]()
    for(attendancelistTemp <- attendanceUserList){
      var attendance = AttendanceList(
         id = attendancelistTemp.id,stud_id = attendancelistTemp.stud_id,Studentadminno = attendancelistTemp.Studentadminno,
         remark = attendancelistTemp.remark,status = attendancelistTemp.status,DOI = attendancelistTemp.DOI.toString(),
         updatedon = attendancelistTemp.updatedon.toString())
         attendance = userService.createStudentAttendence(attendance)  
         // attendanceListSimple += attendance
    }
    Future(Ok(toJson("Attendance created successfully.....!")))
  }
 
 def convert(number : Long) : String = {
   
        if (number == 0) { return "Zero"; }
      var snumber : String = number.toString()
    
    if (number == 1) { return "One"; }

      snumber = number.toString()
    if (number == 2) { return "Two"; }

      snumber = number.toString()
    
    if (number == 3) { return "Three"; }

      snumber = number.toString()
    if (number == 4) { return "Four"; }

      snumber = number.toString()
    
    if (number == 5) { return "Five"; }

      snumber = number.toString()
    if (number == 6) { return "Six"; }

      snumber = number.toString()
    
    if (number == 7) { return "Seven"; }

      snumber = number.toString()
    if (number == 8) { return "Eight"; }

      snumber = number.toString()
    
    if (number == 9) { return "Nine"; }

      snumber = number.toString()
    return snumber;
 }
 
 def numberToWords(number : Long) : String = {
      var num = number
      var words : String = ""
      System.out.println(" Enter the number : "+num);
      var sum = new Array[Long](10)
      var i : Int = 0
      while(num != 0){
        sum(i) = (num%10)
              num = num/10
              i += 1
        }
      System.out.println(" i : "+i);
      i -=1;
      while(i != -1){
        words = words +convert(sum(i))+" "
        i -= 1
      }
      words
      
 }
 def createResultByStdAdmNum(stdAdmNum : String)  = Action.async { implicit request =>
   var marksList = userService.getMarksListByStdAdmNum(stdAdmNum)
   var marksInFigure : String = null
   println("Marks List : "+marksList)
   var avg : Double = 0
   var count : Int = 0
   var marksObtainAdd, marksMinAdd, marksMaxAdd, userId : Long = 0
   var marksObtainCal : Long = 0
   var remarks : String = "pass"
   for(marks <- marksList){
     userId = marks.userId
     marksObtainAdd  += marks.marksObtained
     marksMinAdd  += marks.minMarks
     marksMaxAdd  += marks.maxMarks
     if(remarks.equalsIgnoreCase("fail")){
       remarks = "fail"
     }
     count += 1
     println(" Count : "+count)
   }
   marksObtainCal = marksObtainAdd
   marksInFigure = numberToWords(marksObtainCal)
   avg = marksObtainAdd/count
   var result = FinalResult(resultId = 0,dateOfResult = "",userId = userId,totalMaxMarks = marksMaxAdd,totalMinMarks = marksMinAdd,
       totalMarksObtained = marksObtainAdd, marksInWords = marksInFigure, resultClass  = remarks,average = avg)
   result = userService.saveResult(result)
   
    Future(Ok(toJson("Result Created Successfully.....!"+result)))
 }
 
   
   /**
   * Handles the Sign Out action.
   *
   * @return The result to display.
   */
  def signOut = UserAwareAction.async { implicit request =>
    request.identity match {
      case Some(identity) =>
        env.authenticatorService.create(identity).flatMap { authenticator =>
          env.eventBus.publish(LogoutEvent(identity, request, request2lang))
          val response: Result = Ok(toJson(MsgOK("logout completed")))
          env.authenticatorService.discard(authenticator, Future.successful(response /*.withCookies(Cookie("XSRF-TOKEN",authenticator.id))*/ ))
        }
      case None => Future.successful(Ok(toJson(MsgOK("Logout completed"))))
    }
  }

  
    def SendRegistrationMail(email:String) : Unit = {
           userService.SendRegistrationMail(email).map{ UserLogin =>
          } 
  }
  
  /**
   * Create an User object
   */
  protected def createUser(loginInfo: LoginInfo, signUp: SignUp): User = {
    println("create user----")
    User(
      id = 0,
      username = signUp.identifier,
      loginInfo = loginInfo,
      firstName = signUp.firstName,
      middleName = signUp.middleName,
	    lastName = signUp.lastName,
	    DOB = signUp.DOB,
      Gender = signUp.Gender,
	    address1 = signUp.address1,
	    address2 = signUp.address2,
	    city = signUp.city,
	    state = signUp.state,
      Deleted = null,
      roles = Set(SimpleUser))
  }
  
  
  
  /**
   * Create an User_Login object
   */
  protected def createUserLogin(user:User ,loginInfo: LoginInfo, signUp:SignUp): UserLogin = {
    println("create userlogin ----")
    
    UserLogin(
      id = 0,
      userId = user.id,
      verified = 1,
      email = loginInfo.providerKey,
	  phoneNumber = signUp.phoneNumber)
  }
  
  /**
   * Create an User_Context object
   */
  protected def createUserContext(user:User, signUp:SignUp, userLogin:UserLogin): UserContext = {
    println("create user_context ----")
    
    UserContext(
    		id=0,
    		userId = user.id,
    		contextId = signUp.contextId,
    		campusId = signUp.campusId)
    
  }
  
  /**
   * Create an Staff_Context object
   */
  protected def createStaffDetails(userContext : UserContext,vehicleId : Option[Long]): StaffDetail = {
    println("create staff_details ----")
    
    StaffDetail(id=0,user_id = userContext.userId,vehicleId=vehicleId)
    
  }
  
  /**
   * 
   */
  
  protected def createLibrarian(userContext:UserContext): Librarian = {
    println("create staff_details ----")
    
    Librarian(id=0,user_id = userContext.userId)
    
  }
  
  
  
  /*
   * createStudentDetails(userContext)
   */
/*   protected def createStudentDetails(userContext : UserContext): StudentDetail = {
    println("create staff_details ----")
    
    StudentDetail(id=0,user_id = userContext.userId,Studentadminno="123",vehicleId=1)
    
  }*/
  
  
  /**
   * Create a Guardian_Context Object 
   * 
   */
  /*protected def createGuardianDetails(userContext:UserContext): GuardianDetail = {
    println("create Guardian_details ----")
    
    GuardianDetail(id = 0,user_id = userContext.userId,relationship = "abc",mobile = 998606,income = "Ten Thousand",education = "MCA")
    
  }*/
   
  //createStudentUser(user,userLogin,context,studentDetails,classObject,getCampusDetails,getOrganizationDetail
  protected def createStudentUser(user: User,userLogin: UserLogin,context: Context,studentDetails: StudentDetail,classObject : Class, getCampusDetails : Campus,getOrganizationDetail : Organization/*,termType : TermType,termDetails : Term*/): StudentUser = {
    println("create StudentUser Object to send into json response  ----")
    
    StudentUser(
      id=user.id,
      email = user.username, 
      firstName = user.firstName,
      lastName = user.lastName,
      middleName = user.middleName,
      address1 = user.address1,
      address2 = user.address2,
      city = user.city,
      state = user.state,
      Deleted = user.Deleted ,
      context = context.context,
      user_id = studentDetails.user_id,
      Studentadminno = studentDetails.Studentadminno,
      phoneNumber = userLogin.phoneNumber,
      class_id=classObject.id,
      className = classObject.class_name,
      campusId = getCampusDetails.id,
      campusName = getCampusDetails.campus_name,
      orgId = getOrganizationDetail.id,
      orgName = getOrganizationDetail.name,
      vehicleId=studentDetails.vehicleId/*,
      termType=termType.term_type,
      termStartDate=termDetails.start_date,
      termEndDate=termDetails.end_date*/
    )
    
  }
  
  
  
   /*
    *  id : Long, 
    Vehicle_no : String, 
    Vehicle_code : String,
    No_of_Seat : Int, 
    Maximum_capacity : Int, 
    insurance : String,
    tax_remitted : String,
    permit : String,
    status : String, 
    Vehicle_type_id : Int,
    Route_Name : String,
    No_of_Stops : Int,
    Stop_Name : String,
    fare : String,
    Arival_Mrng : String,
    Departure_Mrng : String,
    Arival_Evng : String,
    Departure_Evng : String
    */
   
  
  
  
  protected def saveRouteDetail(createVehicleDetail : CreateVehicleDetail,vehicleDetails : VehicleDetail): RouteDetail = {
    RouteDetail(
    rdId=0,
    Route_Name = createVehicleDetail.Route_Name,
    No_of_Stops = createVehicleDetail.No_of_Stops,
    Vehicle_id = vehicleDetails.id) 
  }
  
   protected def saveStopDetail(createVehicleDetail : CreateVehicleDetail,routeDetail : RouteDetail) : StopDetail = {
    StopDetail(
    id=0,
    Stop_Name = createVehicleDetail.Stop_Name,
    fare = createVehicleDetail.fare,
    Arival_Mrng = createVehicleDetail.Arival_Mrng,
    Departure_Mrng = createVehicleDetail.Departure_Mrng,
    Arival_Evng = createVehicleDetail.Arival_Evng,
    Departure_Evng = createVehicleDetail.Departure_Evng,
    Route_details_id = routeDetail.rdId)
  }
  
  //createDriverUser(user,userLogin,context,driverDetails)
  protected def createDriverUser(user : User, userLogin : UserLogin, context : Context, driverDetails : DriverDetail,
      getCampusDetails : Campus,getOrganizationDetail : Organization): DriverUser = {
    println("create DriverUser Object to send into json response  ----")
    
    DriverUser(
      id=driverDetails.id,
      email = user.username, 
      firstName = user.firstName,
      lastName = user.lastName,
      middleName = user.middleName,
      address1 = user.address1,
      address2 = user.address2,
      city = user.city,
      state = user.state,
      Deleted = user.Deleted ,
      context = context.context,
      phoneNumber = userLogin.phoneNumber,
      user_id = driverDetails.user_id,
      DLno = driverDetails.DLno,
      vehicleid=driverDetails.vehicleid,
      campusId = getCampusDetails.id,
      campusName = getCampusDetails.campus_name,
      orgId = getOrganizationDetail.id,
      orgName = getOrganizationDetail.name
    )
    
  }
  //createStaffUser(user,userLogin,context,staffDetails,courseStaff,getCampusDetails,getOrganizationDetail)
  protected def createStaffUser(user: User,userLogin: UserLogin,context: Context,staffDetail: StaffDetail,subjectName : String,
      getCampusDetails : Campus,getOrganizationDetail : Organization): StaffUser = {
    println("create StudentUser Object to send into json response  ----")
    
    StaffUser(
      id=user.id,
      email = user.username,
      firstName = user.firstName,
      lastName = user.lastName,
      middleName = user.middleName,
      address1 = user.address1,
      address2 = user.address2,
      city = user.city,
      state = user.state,
      Deleted = user.Deleted ,
      context = context.context,
      user_id = staffDetail.user_id,
      subjectName = subjectName,
      phoneNumber = userLogin.phoneNumber,
      campusId = getCampusDetails.id,
      campusName = getCampusDetails.campus_name,
      orgId = getOrganizationDetail.id,
      orgName = getOrganizationDetail.name,
      vehicleId=staffDetail.vehicleId
    )
    
  }
  
  protected def createCampusAdminUser(user: User,userLogin: UserLogin,context: Context,getCampusDetails : Campus,getOrganizationDetail : Organization): CampusAdminUser = {
    println("create createCampusAdminUser Object to send into json response  ----")
    
    CampusAdminUser(
      id=user.id,
      email = user.username,
      firstName = user.firstName,
      lastName = user.lastName,
      middleName = user.middleName,
      address1 = user.address1,
      address2 = user.address2,
      city = user.city,
      state = user.state,
      Deleted = user.Deleted ,
      context = context.context,
      phoneNumber = userLogin.phoneNumber,
      campusId = getCampusDetails.id,
      campusName = getCampusDetails.campus_name,
      orgId = getOrganizationDetail.id,
      orgName = getOrganizationDetail.name
      )
    
  }
  
  //createBookUser(authorDetail,bookDetail)
  protected def createBookUserDetail(authorDetail : Author,bookDetail : Book, bookCategories : BookCategories,bookCategories1 : BokCategories ) : CreateBookUser = {
    println("create StudentUser Object to send into json response  ----")
    
    CreateBookUser(
      id = bookDetail.id,
      First_Name = authorDetail.First_Name, 
      Last_Name = authorDetail.Last_Name, 
      ISBN = bookDetail.ISBN,
      Book_title = bookDetail.Book_title, 
      date_of_publication = bookDetail.date_of_publication,
      bookCount = bookDetail.bookCount,
      Book_Categories_id = bookCategories.Book_Categories_id,
      bookCategoriesName = bookCategories1.Categories_name
    )
    
  }
  
   protected def createLibrarianUser(user: User,userLogin: UserLogin,context: Context,librarian: Librarian, getCampusDetails : Campus,getOrganizationDetail : Organization): LibrarianUser = {
    println("create StudentUser Object to send into json response  ----")
    
    LibrarianUser(
      id=user.id,
      email = user.username,
      firstName = user.firstName,
      lastName = user.lastName,
      middleName = user.middleName,
      address1 = user.address1,
      address2 = user.address2,
      city = user.city,
      state = user.state,
      Deleted = user.Deleted ,
      context = context.context,
      user_id = librarian.user_id ,
      phoneNumber = userLogin.phoneNumber,
      campusId = getCampusDetails.id,
      campusName = getCampusDetails.campus_name,
      orgId = getOrganizationDetail.id,
      orgName = getOrganizationDetail.name
    )
    
  }
  
  //  createGuardianUser
   protected def createGuardianUser(user: User,userLogin: UserLogin,context: Context,guardianDetails: GuardianDetail, getCampusDetails : Campus,getOrganizationDetail : Organization): GuardianUser = {
    println("create StudentUser Object to send into json response  ----")
    
    GuardianUser(
      id=user.id,
      email = user.username,
      firstName = user.firstName,
      lastName = user.lastName,
      middleName = user.middleName,
      address1 = user.address1,
      address2 = user.address2,
      city = user.city,
      state = user.state,
      Deleted = user.Deleted ,
      context = context.context,
      user_id = guardianDetails.user_id,
      relationship = guardianDetails.relationship,
      mobile = guardianDetails.mobile,
      income = guardianDetails.income,
      education = guardianDetails.education,
      stdadmissionno = guardianDetails.stdadmissionno,
      campusId = getCampusDetails.id,
      campusName = getCampusDetails.campus_name,
      orgId = getOrganizationDetail.id,
      orgName = getOrganizationDetail.name
    )
    
  }
   
   protected def createVDUser(vehicleDetails : VehicleDetail, routeDetails : RouteDetail, stopDetail : StopDetail, vehicleType : VehicleType) : CreateVehicleDetailUser = {
     println("create StudentUser Object to send into json response  ----")
    
    CreateVehicleDetailUser(
    id=vehicleDetails.id,
    Vehicle_no = vehicleDetails.Vehicle_no, 
    Vehicle_code = vehicleDetails.Vehicle_code,
    No_of_Seat = vehicleDetails.No_of_Seat, 
    Maximum_capacity = vehicleDetails.Maximum_capacity, 
    insurance = vehicleDetails.insurance,
    tax_remitted = vehicleDetails.tax_remitted,
    permit = vehicleDetails.permit,
    status = vehicleDetails.status, 
    Vehicle_type_id = vehicleDetails.Vehicle_type_id,
    vehicleName = vehicleType.vehicleName,
    rdId = routeDetails.rdId,
    routeName = routeDetails.Route_Name,
    campusId = vehicleDetails.campusId,
    No_of_Stops = routeDetails.No_of_Stops /*,
    Stop_Name = stopDetail.Stop_Name,
    fare = stopDetail.fare,
    Arival_Mrng = stopDetail.Arival_Mrng,
    Departure_Mrng = stopDetail.Departure_Mrng,
    Arival_Evng =stopDetail.Arival_Evng,
    Departure_Evng = stopDetail.Departure_Evng*/
    )
   }
   

}