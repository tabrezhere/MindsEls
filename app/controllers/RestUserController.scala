package controllers


import models.users.User
import services.UserService
import javax.inject.Inject
import utils.responses.rest._
import services.UserService
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.concurrent.Execution.Implicits._
import com.mohiva.play.silhouette.core._
import com.mohiva.play.silhouette.core.providers._
import com.mohiva.play.silhouette.core.exceptions._
import com.mohiva.play.silhouette.core.services.AuthInfoService
import com.mohiva.play.silhouette.contrib.authenticators.HeaderAuthenticator
import scala.concurrent.{ Future }
import com.mohiva.play.silhouette.contrib.authenticators.CookieAuthenticator
import security.models._
import Json.toJson
import models.users.UserContext
import models.commons.Context
import models.users.StudentUser
import models.users.UserLogin
import models.users.StudentUser
import models.users.StaffUser
import models.authorizations.ParentGuardianUser
import models.users.AttendanceList
import models.users.VehicleDetail
import models.users.UserLogin
import models.services.UrlService
import com.mohiva.play.silhouette.core.utils.PasswordHasher
import models.users.StudentClassMapping
import models.users.LibrarianUser
import models.users.StopDetail
import models.users.VehicleRouteStopDetails
import models.users.Medical
import models.users.DriverUser
import models.authorizations.Role
import models.authorizations.LibrarianUserRole
import models.authorizations.DriverRole
import models.users.TermType
import models.users.GuardianStudentDetails
import scala.collection.mutable.ListBuffer
import models.users.School
import models.users.AttendanceCommon
import models.users.AttendanceUser
import java.util.Calendar
import java.util.Date
import models.users.AttendanceWithDOIAndUpdatedOnList
import models.users.SchoolNews
import models.users.StdClassTerm
import models.users.Student_Guardian_Mapping
import models.users.SubjectMaster
import models.users.SubjectMaster
import models.users.ClassWithSubjectClassMap
import models.users.StudentUserMarks
import models.users.MarksStudent
import models.users.FinalResult
import models.users.StaffTimeTableWithSubjectMasterWithClassTimeTable
import models.users.SubjectClassStaffMap
import models.users.CampusAdminUserWithCount
import models.users.StaffCompleteVehicleDetail
import models.users.StudentDetailForGuardian
import models.users.GuadianUserWithStudentDetail
import models.users.GuardianUserWithStudentInfo
import com.amazonaws.auth.AWSCredentials
import java.io.InputStream
import java.io.BufferedReader
import com.amazonaws.services.s3.AmazonS3Client
import java.io.InputStreamReader
import scala.util.control.Breaks._
import java.nio.file.{Paths, Files}
import play.api.Play.current
import com.amazonaws.services.s3.model.GetObjectRequest
import java.io.OutputStream
import java.io.FileOutputStream
import com.amazonaws.util.json._
import java.io.ByteArrayOutputStream
import scala.concurrent.duration._
import play.api.libs.concurrent.Execution.Implicits._
import play.libs.Akka

import akka.actor._
import scala.concurrent.duration._
import play.api.libs.concurrent.Execution.Implicits._
//import models.services.EmailNotificationService
/*
 * 
import models.users.User
import services.UserService
import javax.inject.Inject
import utils.responses.rest._
import services.UserService
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.concurrent.Execution.Implicits._
import com.mohiva.play.silhouette.core._
import com.mohiva.play.silhouette.core.providers._
import com.mohiva.play.silhouette.core.exceptions._
import com.mohiva.play.silhouette.core.services.AuthInfoService
import com.mohiva.play.silhouette.contrib.authenticators.HeaderAuthenticator
import scala.concurrent.{ Future }
import com.mohiva.play.silhouette.contrib.authenticators.CookieAuthenticator
import security.models._
import Json.toJson
import models.users.UserContext
import models.commons.Context
import models.users.StudentUser
import models.users.UserLogin
import models.users.StudentUser
import models.users.StaffUser
import models.authorizations.ParentGuardianUser
import models.users.AttendanceList
import models.users.VehicleDetail
import models.users.UserLogin
import models.services.UrlService
import com.mohiva.play.silhouette.core.utils.PasswordHasher
import models.users.StudentClassMapping
import models.users.LibrarianUser
import models.users.StopDetail
import models.users.VehicleRouteStopDetails
 */


class RestUserController @Inject() (
  implicit val env: Environment[User, CookieAuthenticator],
  val userService: UserService,
  val authInfoService: AuthInfoService,
  val passwordHashar: PasswordHasher
  ) extends Silhouette[User, CookieAuthenticator]  {
  
  implicit val restCredentialFormat = security.formatters.json.CredentialFormat.restFormat
  
  def authenticate = Action.async(parse.json){ implicit request =>
    
   request.body.validate[Credentials] match {
      case JsSuccess(credentials, _) =>
        (env.providers.get(CredentialsProvider.Credentials) match {
          case Some(p: CredentialsProvider) => p.authenticate(credentials)
          case _                            => Future.failed(new AuthenticationException(s"Cannot find credentials provider"))
        }).flatMap { loginInfo =>
          userService.retrieve(loginInfo).flatMap {
            case Some(user) => env.authenticatorService.create(user).flatMap { authenticator =>
              import security.models.Token.restFormat
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              println(" User ID : "+user.id)
         
              val userContext = userService.getContextByUserId(user.id)
              println(" context got is : "+userContext.contextId)
              if(userContext.contextId==3)
              {
                println("Campus Admin entered")
                val campusAdminUserDetail = userService.getFromDBCampusAdminUserById(user.id)
                val stdCount = userService.getStudentCount
                val stfCount = userService.getStaffCount
                val clsCount = userService.getClassCount
                val subCount = userService.getSubjectCount
                val exmCount = userService.getExamCount
                val libCount = userService.getLibrarianCount
                val vehcleCount = userService.getVehicleCount
                val hlydayCount = userService.getHolidayCount
                val evntCount = userService.getEventCount
                println(" Student Count : "+stdCount)
                val campusAdminUserWithCount = CampusAdminUserWithCount(campusAdminUser = campusAdminUserDetail, studentCount = stdCount,
                staffCount = stfCount,classCount = clsCount,subjectCount = subCount,examCount = exmCount,librarianCount = libCount,
                vehicleCount = vehcleCount,holidayCount = hlydayCount, eventCount = evntCount)
                val  response=Ok(Json.toJson(MsgOK("You have been Logged-in up succesfully1.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "campusAdminUserWithCount" -> campusAdminUserWithCount))))
                 env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id)) ))
              
              }
              else
              if(userContext.contextId==4)
              {
                println("studnet entered")
                val studentuser = userService.getFromDBStudentUserById(user.id)
                val  response=Ok(Json.toJson(MsgOK("You have been Logged-in up succesfully1.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "studentuser" -> studentuser))))
                 env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id)) ))
              
              }
              else
              if(userContext.contextId==5)
              {
                println("staff entered")
                val staffuser = userService.getFromDBStaffUserById(user.id)
                val  response=Ok(Json.toJson(MsgOK("You have been Logged-in up succesfully2.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "staffuser" -> staffuser))))
                 env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id)) ))
              
              }
              else
                if(userContext.contextId==6)
                {
                    println("Parent/Guardian User : ",ParentGuardianUser)
                    val guardianuser = userService.getFromDBGuardianUserById(user.id)
                    val getStudentGuardianMap = userService.getStdAdmNumberList(guardianuser.user_id)

                    var admissionNumbersSplit : Array[String] = null
                    for(studentGuardianMapList <- getStudentGuardianMap)
                    admissionNumbersSplit = studentGuardianMapList.stdadmissionno.split(',')
                  
                    var getStudentUserList = new ListBuffer[StudentUser]()
                    
                    for(stdAdmissionNumber <- admissionNumbersSplit)
                    {
                     val getStudentUserTemp = userService.getStudentUserByStdAdmissionNo(stdAdmissionNumber)
                     getStudentUserList += getStudentUserTemp
                    }
                    
              
                    
                    val guardianStudentDetails = GuardianStudentDetails(id = guardianuser.id,email=guardianuser.email,firstName = guardianuser.firstName,lastName = guardianuser.lastName,
            middleName = guardianuser.middleName,address1=guardianuser.address1,address2=guardianuser.address2,city=guardianuser.city,state=guardianuser.state,
            Deleted = guardianuser.Deleted,context = guardianuser.context, user_id = guardianuser.user_id,relationship = guardianuser.relationship,mobile=guardianuser.mobile,
            income =guardianuser.income,education=guardianuser.education,campusId=guardianuser.campusId,campusName=guardianuser.campusName,orgId=guardianuser.orgId,
            orgName=guardianuser.orgName,studentDetailsList=getStudentUserList)
                   
                    
                  
                    val  response=Ok(Json.toJson(MsgOK("You have been Logged-in up succesfully2.", Json.obj(
	                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
	                "guardianStudentDetails" -> guardianStudentDetails))))
                 env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id)) ))
                }
              else
                if(userContext.contextId==8)
                {
                    println("Librarian User : "+LibrarianUserRole)
                    val librarianuser = userService.getFromDBLibrarianUserById(user.id)
                  
                    val  response=Ok(Json.toJson(MsgOK("You have been Logged-in up succesfully2.", Json.obj(
                  "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                  "librarianuser" -> librarianuser))))
                 env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id)) ))
                }
                else
                if(userContext.contextId==9)
                {
                    println("Driver User : "+DriverRole)
                    val driveruser = userService.getFromDBDriverUserById(user.id)
                  
                    val  response=Ok(Json.toJson(MsgOK("You have been Logged-in up succesfully2.", Json.obj(
                  "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                  "driveruser" -> driveruser))))
                 env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id)) ))
                }
              else
              {      
                println("general User",user)
                val response = Ok(Json.toJson(MsgOK("You have been Logged-in up succesfully.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "user" ->user))))
                println("ok got its User : ",user)
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id)) ))
              }
           }            
            case None =>
              Future.failed(new AuthenticationException("Couldn't find user"))
          }
        }.recoverWith(exceptionHandler)
      case JsError(e) => Future.successful(BadRequest(Json.toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }    
  }
  
  
  /*def getStaffView = Action.async(parse.json){ implicit request =>
    
   request.body.validate[Credentials] match {
      case JsSuccess(credentials, _) =>
        (env.providers.get(CredentialsProvider.Credentials) match {
          case Some(p: CredentialsProvider) => p.authenticate(credentials)
          case _                            => Future.failed(new AuthenticationException(s"Cannot find credentials provider"))
        }).flatMap { loginInfo =>
          userService.retrieve(loginInfo).flatMap {
            case Some(user) => env.authenticatorService.create(user).flatMap { authenticator =>
              import security.models.Token.restFormat
              env.eventBus.publish(LoginEvent(user, request, request2lang))
              
              val userLogin = userService.getUserLoginByUserId(user)
              
              val userContext = userService.getUserContextByUSerId(user)
              
              val staffDetails = userService.getStaffDetailsByUserContextId(userContext)
              
              val response = Ok(Json.toJson(MsgOK(" Perticular Staff Details are available.", Json.obj(
                "session" -> Token(token = authenticator.id, expiresOn = authenticator.expirationDate),
                "user" -> user,
                "userLogin" -> userLogin,
                "staffDetails" -> staffDetails))))
              env.authenticatorService.init(authenticator, Future.successful(response.withCookies(Cookie("XSRF-TOKEN",authenticator.id)) ))
            }
            case None =>
              Future.failed(new AuthenticationException("Couldn't find user"))
          }
        }.recoverWith(exceptionHandler)
      case JsError(e) => Future.successful(BadRequest(Json.toJson(MsgERR("Error", JsError.toFlatJson(e)))))
    }  
    
}*/
  
 def getUserById(userId : Long) = Action.async { request =>
    userService.getUserById(userId).map { user =>
       Ok(toJson(user))
      //Ok.sendFile(welcome.jpeg, 2, "welcome", onClose)
    }
  }
  
  
  def getUserLoginByEmail(email:String) = Action.async { request => 
    userService.getUserLoginByEmail(email).map { userLogin =>
      Ok(toJson(userLogin))
    }
  }
  
  //getUserContextById
   def getUserContextById(id:Long) = Action.async { request =>
    userService.getUserContextById(id).map { userContext =>
      Ok(toJson(userContext))
    }
  }
   
  //getContextById
  def getContextById(id:Long) = Action.async { request =>
    userService.getContextById(id).map { context =>
      Ok(toJson(context))
    }
  }
  
  //getStaffDetailById
  
  def getStaffDetailById(user_contextid:Long) = Action.async { request =>
    userService.getStaffDetailById(user_contextid).map { staffDetial =>
      Ok(toJson(staffDetial))
    }
  }
  
  //getStudentDetails
  def getStudentDetailsById(id:Long) = Action.async { request =>
    
    userService.getStudentDetailsById(id).map { studentDetail =>
      Ok(toJson(studentDetail))
    }
  }

  
  //getGuardianDetails  
  def getGuardianDetailsById(id:Long) = Action.async { request =>
    
    userService.getGuardianDetailsById(id).map { guardianDetail =>
      Ok(toJson(guardianDetail))
    }
  }
  
  //updateStaffDetailsById
 /* def updateStaffDetailsById() = Action.async { request =>
    val id = 22
    userService.updateStaffDetails(id).map { staffDetail =>
      Ok(toJson(staffDetail))
    }
  }*/
  
  //updateStudentDetailsById
   def updateStudentDetailsById(id:Long) = Action.async { request =>
    
    userService.updateStudentDetails(id).map { studentDetail =>
      Ok(toJson(studentDetail))
    }
  }
   
   //updateGuardianDetailsById
   /*def updateGuardianDetailsById = Action.async { request =>
    val id = 32
    userService.updateGuardianDetails(id).map { guardianDetail =>
      Ok(toJson(guardianDetail))
    }
  }*/
   
   def deleteUserDetailsById(id:Long) = Action.async { request =>
     
   userService.deleteUserDetailsById(id).map { studentDetail =>
      Ok(toJson(studentDetail))
   }
   
}
   
   /**
    * Get Student Object along with its details in single StudentUser onject
    * param = userid
    * return = StudentUser 
    */
   
  def getStudentUserById(userId : Long) = Action.async{  request =>
     //val userId = 18
      userService.getStudentUserById(userId).map { studentUser =>
      	Ok(toJson(studentUser))
      }    
  }
  
  /**
   *  Get Staff Object along with its details in single StaffUser object
   *   param=userid
   *   return = StaffUser
   */
  
  def getStaffUserById(userId:Long) = Action.async{  request =>
    userService.getStaffUserById(userId).map { staffUser =>
      Ok(toJson(staffUser))      
    }    
  }
  
  /**
   *  Get Guardian/Parent Object along with its details in sungle GuardianUser object
   *   param = userid
   *   return = GuardianUser
   */
  //getAllClassesByCompusId
    def getAllClassesByCampusId(campusId:Long) = Action.async{ request =>
    val classList = userService.getAllClassesByCampusId(campusId)
    Future(Ok(toJson(classList)))
    }
    
  def getGuardianUserById(userId : Long) = Action.async{ request =>
    val guardianUser = userService.getGuardianUserById(userId)
      Future(Ok(toJson(guardianUser)))       
  }
  
  def getAllGuardianListByCampusId(campusId : Long) = Action.async{ request =>
    
    val guardianUserList = userService.getAllGuardianListByCampusId(campusId)
    var guardianUserWithStudent = new ListBuffer[GuardianUserWithStudentInfo]()
    var i : Int = 0
    for(guardianUser <- guardianUserList){
      var admissionNumbersSplit : Array[String] = null
      var getStudentUserList = new ListBuffer[Option[StudentDetailForGuardian]]()
      println(" Guardian User Id : "+guardianUser.user_id)
      admissionNumbersSplit = guardianUser.stdadmissionno.split(',')
      println(" Splited Values For Student Admission Number : "+admissionNumbersSplit)
        for(stdAdmissionNumber <- admissionNumbersSplit)
        {
             val stdDetailsForGuardian = userService.getStudentDetailForGuardianByStdAdminNum(stdAdmissionNumber)
             getStudentUserList += stdDetailsForGuardian
        }
      val guardianUserWithStudentInfo = GuardianUserWithStudentInfo(id = guardianUser.id,email=guardianUser.email,firstName = guardianUser.firstName,
      lastName = guardianUser.lastName,middleName = guardianUser.middleName,address1=guardianUser.address1,address2=guardianUser.address2,city=guardianUser.city,
      state=guardianUser.state,Deleted = guardianUser.Deleted,context = guardianUser.context, user_id = guardianUser.user_id,relationship = guardianUser.relationship,
      mobile=guardianUser.mobile,income =guardianUser.income,education=guardianUser.education,studentInfo = getStudentUserList,campusId=guardianUser.campusId,
      campusName=guardianUser.campusName,orgId=guardianUser.orgId,orgName=guardianUser.orgName)
      guardianUserWithStudent += guardianUserWithStudentInfo
    }
      Future(Ok(toJson(guardianUserWithStudent)))       
  }
  
  def getStudentUserListByCampusId(campusId : Long) = Action.async{ request =>
    userService.getStudentUserListByCampusId(campusId).map { studentUserList =>
      Ok(toJson(studentUserList))      
    }    
  }
  
  def getStaffUserListByCampusId(campusId : Long) = Action.async{ request =>
    userService.getStaffUserListByCampusId(campusId).map { staffUserList =>
      Ok(toJson(staffUserList))
    }
    
  }
  def getStudentListByClassId(classId:Long) = Action.async{ request =>
  
    userService.getStudentListByClassId(classId).map{ attendanceList =>
      Ok(toJson(attendanceList))
    }
  }
  
  //createAttendance
  
  /*def createAttendance(classId :Long) = Action.async{ request =>
   
    
    var studentClassMap : StudentClassMapping = null
     var stdid : Long = studentClassMap.user_id
    userService.createattendanceList(stdid,classId).map{ attendanceList =>
      Ok(toJson(attendanceList))
    }  
  }*/
  
  def getStudentUserByFirstname(Firstname : String) = Action.async{ request =>
    
    userService.getStudentUserByFirstname(Firstname).map{ StudentUser =>
      Ok(toJson(StudentUser))
  }
  }
  
  
  def getstdFatherName(ffname:String) = Action.async{ request => 
           
          userService.getstdFatherName(ffname).map{ Student_Guardian_Mapping =>
            Ok(toJson(Student_Guardian_Mapping))
      }
  }
  
  
  def getVehicleListByCampusId(campusId : Long) = Action.async { request => 
          userService.getVehicleListByCampusId(campusId).map{ CreateVehicleDetailUser =>
            //changePassword()
            Ok(toJson(CreateVehicleDetailUser))
      } 
  }
  
   def getDriverListByCampusId(campusId : Long) = Action.async { request =>  
          userService.getDriverListByCampusId(campusId).map{ DriverUser =>
            Ok(toJson(DriverUser))
      } 
  }
   
   //getVehicleListByCampusIdDriverId
  def getVehicleListByCampusIdDriverId(campusId : Long,dId : Long) = Action.async { request => 
          userService.getVehicleListByCampusIdDriverId(campusId,dId).map{ VehicleDetails =>
            //changePassword()
            Ok(toJson(VehicleDetails))
      } 
  }
  
  
  //Forget Password
  def forgetpassword(email:String) = Action.async{implicit request => 
         
           userService.getPasswordRestKey(email).map{ UserLogin =>
            Ok(toJson(UserLogin))
          } 
  }
  //Reset Password
  def restPasswordKey = Action.async{implicit request => 
          val key : String = "FBBE4861A6D610DFD3CC58D821815C85"
          println(" Rest Password Key : "+key)
           userService.getLoginInfoByRestKey(key).map{ LoginInfo =>
             sendMailByAWS()
             saveRestPassword()   
            Ok(toJson(LoginInfo))
          } 
  }
  
  
  def sendMailByAWS() : Unit = {
    val email : String = "mailshareef786@gmail.com"
    val key : String = "FBBE4861A6D610DFD3CC58D821815C85"
    userService.sendPasswordResetInstructions(key,email)
  }
  
  def saveRestPassword() : Unit = {
    val key : String = "FBBE4861A6D610DFD3CC58D821815C85"
    val id : Long = 9
    userService.saveRestPassword(id,key)
  }
  
  def changePassword() : Unit = {
    val userId : Long = 9
    val newpassword : String = "1"
    userService.changePassword(userId : Long,newpassword :String)
  }
  
  def getStudentAttendenceListByClassId(classId : Long) = Action.async { request =>
    val attendanceCommonList = userService.getStudentAttendenceListByClassId(classId)
    var attendanceUserList = new ListBuffer[AttendanceUser]()
    
    for(attendanceTemp <- attendanceCommonList){
     var attendanceUser = AttendanceUser(
          id = 0,stud_id = attendanceTemp.user_id,Studentadminno = attendanceTemp.Studentadminno,Firstname = attendanceTemp.Firstname,
          remark = None,status = 1,DOI = Calendar.getInstance().getTime(),updatedon = Calendar.getInstance().getTime(),
          className = attendanceTemp.className,campusName = attendanceTemp.campusName,orgName = attendanceTemp.orgName)
     
     attendanceUserList += attendanceUser  
    }
     Future(Ok(toJson(attendanceUserList)))
  }
  
  
 
  /*def createStudentAttendenceListByClassId(cid:Long) = Action.async { request =>
   
    val stdClassMap  = userService.getStudentClassMapListByClassId(cid)
    println(" stdClassMap Details : "+stdClassMap)
    //var getStudentUserList : List[StudentUser] = Nil
    var attandenceList : List[AttendanceList] = Nil
    var stdId : Long = 0
    for(stdmap <- stdClassMap)
    {
      //stdId = stdNo.user_id
      attandenceList = userService.createStudentAttendenceListByClassIdAndByUserId(stdmap.user_id,stdmap.class_id)
    }
   Future(Ok(toJson(attandenceList)))
  }*/
  
  //def createStudentAttendenceListByClassIdAndByUserId()
  def getVehicleRouteAndStopDetailsByVhId(vid : Long)  =  Action.async{  request =>
      val vehicleId : Option[Long] = Option(vid)
      println(" Controller : "+vid)
      val vehicleRouteDetails = userService.getVehicleAndRoutesByVhId(vehicleId)
      val stopDetailsList = userService.getStopDetailsByRouteId(vehicleRouteDetails.rdId)
      
      var vehicleRouteStopDetails = VehicleRouteStopDetails(id=vehicleRouteDetails.id,Vehicle_no=vehicleRouteDetails.Vehicle_no,Vehicle_code=vehicleRouteDetails.Vehicle_code,
               No_of_Seat = vehicleRouteDetails.No_of_Seat, Maximum_capacity=vehicleRouteDetails.Maximum_capacity,insurance= vehicleRouteDetails.insurance,
               tax_remitted=vehicleRouteDetails.tax_remitted,permit=vehicleRouteDetails.permit,status=vehicleRouteDetails.status,
               Vehicle_type_id=vehicleRouteDetails.Vehicle_type_id,RouteId=vehicleRouteDetails.rdId,No_of_Stops=vehicleRouteDetails.No_of_Stops,
               Route_Name=vehicleRouteDetails.routeName,StopDetailsList=stopDetailsList)
      
     
     Future(Ok(toJson(vehicleRouteStopDetails)))
    
     }     
   
   /*def getStudentListByGuardianUserId(id : Long) = Action.async { request =>
     val getGuardianUser = userService.getGuardianUserById(id)
     val getStudentGuardianMap = userService.getStdAdmNumberList(getGuardianUser.user_id)
     
     val guardianStudentDetails = GuardianStudentDetails(id = getGuardianUser.id,email=getGuardianUser.email,firstName = getGuardianUser.firstName,lastName = getGuardianUser.lastName,
            middleName = getGuardianUser.middleName,address1=getGuardianUser.address1,address2=getGuardianUser.address2,city=getGuardianUser.city,state=getGuardianUser.state,
            Deleted = getGuardianUser.Deleted,context = getGuardianUser.context, user_id = getGuardianUser.user_id,relationship = getGuardianUser.relationship,mobile=getGuardianUser.mobile,
            income =getGuardianUser.income,education=getGuardianUser.education,campusId=getGuardianUser.campusId,campusName=getGuardianUser.campusName,orgId=getGuardianUser.orgId,
            orgName=getGuardianUser.orgName,studentDetailsList=getStudentGuardianMap)
     //val getStudentUserList = userService.getStudentList
     Future(Ok(toJson(guardianStudentDetails)))
   }*/
 
 def getLibrariansListByCampusId(campusId : Long) = Action.async{ request =>
   println(" Controller campusId : "+campusId)
      userService.getLibrariansListByCampusId(campusId).map {  LibrarianUser =>
      Ok(toJson(LibrarianUser))
   }
 }
 
 def getHolidaysByCampusId(campusId : Long)= Action.async{ request =>
   println(" Controller campusId : "+campusId)
      userService.getHolidaysListByCampusId(campusId).map {Holiday =>
      Ok(toJson(Holiday))
   }
 }
 
 def getSchoolListByCampusId(campusId:Int)=Action.async{ request =>
    println(" Controller campusId : "+campusId)
      userService.getSchoolListByCampusId(campusId).map {School =>
      Ok(toJson(School))
   }
 }

 def getMedicalDetailByUserId(userId : Long) = Action.async{ request =>
   println(" Medical User Id : "+userId)
      userService.getMedicalDetailByUserId(userId).map {  Medical =>
      Ok(toJson(Medical))
   }
 }
 
 def getMedicalDetailListByCampusId(campusId : Long) = Action.async{ request =>
   println(" Medical List By campusId Id : "+campusId)
      userService.getMedicalDetailListByCampusId(campusId).map {  Medical =>
      Ok(toJson(Medical))
   }
 }
 
 def getBookListByCampusId(campusId : Long) =  Action.async{ request =>
   println(" Book List By Campus Id : "+campusId)
      userService.getBookListByCampusId(campusId).map {  CreateBookUser =>
      Ok(toJson(CreateBookUser))
   }
 }
 
  /*def getBookListByCampusId(campusId : Long) =  Action.async{ request =>
   println(" Medical List By campusId Id : "+campusId)
      userService.getBookListByCampusId(campusId).map {  CreateBookUser =>
      Ok(toJson(CreateBookUser))
   }
 }*/
 
 def termTypeList  =  Action.async{ request =>
       userService.getTermType().map { TermType =>
          Ok(toJson(TermType))
         }
       }
 
 def getAssignmentByClassId(cid : Int) = Action.async{ request =>
   val assignmentByClass = userService.getAssignmentByClassId(cid)
   index
   Future(Ok(toJson(assignmentByClass)))
 }
 
 //getSubjectListByClassId
  def getSubjectsByClassId(classId:Long) = Action.async{ request =>
  
   val subjectsListById= userService.getSubjectListByClassId(classId)
      Future(Ok(toJson(subjectsListById)))
      }
  
  
  //getSubjectListById
  def getSubjectsById(Id:Long) = Action.async{ request =>
   val subjectById= userService.getSubjectsById(Id)
      Future(Ok(toJson(subjectById)))
      }
  
  def getAllSubjectList = Action.async{ request =>
   val allSubjectList= userService.getAllSubjectList
      Future(Ok(toJson(allSubjectList)))
      }
  
  def getSubjectIdBySubjectName(subjectName : String) = Action.async{ request =>
   val subjectId = userService.getSubjectIdBySubjectName(subjectName)
      Future(Ok(toJson(subjectId)))
     }
 
 def getListOfStudentByCampusIdWhoHasTakenBooks(campusId : Long) = Action.async { request =>
    val listOfStudentWhoHasTakenBooks = userService.getListOfStudentByCampusIdWhoHasTakenBooks(campusId)
   Future(Ok(toJson(listOfStudentWhoHasTakenBooks)))
 }
 
 def getStudentWhoHasReturnBook(stdUserId : Long) = Action.async { request =>
   val bookIssueReturn = userService.getStudentWhoHasReturnBookByStdUserId(stdUserId)
   val updateStudentWhoHasReturnBook = userService.updateStudentWhoHasReturnBook(bookIssueReturn)
   Future(Ok(toJson(bookIssueReturn)))
 }
 
 def getStudentDetailByStdAdmNum(admNum : String) = Action.async { request =>
  val studentUser = userService.getStdUserByStdAdmissionNumber(admNum)
  Future(Ok(toJson(studentUser)))
 }
 
 def getGuardianUserByStudentAdmissionNumber(stdadmissionno : String) = Action.async { request =>
   val guardianUse = userService.getGuardianUserByStudentAdmissionNumber(stdadmissionno)
  Future(Ok(toJson(guardianUse)))
 }
 
 def getStudentMedicalDetailsByStudentAdmNum(stdadmissionno : String) = Action.async { request =>
   val studentUser = userService.getStdUserByStdAdmissionNumber(stdadmissionno)
   val medicalDetails = userService.getStudentMedicalDetailsByStudentUserId(studentUser.user_id)
   Future(Ok(toJson(medicalDetails)))
 }
 
 def getStudentVehicleDetailsByStudentAdmNum(stdadmissionno : String) = Action.async { request =>
   val studentUser = userService.getStdUserByStdAdmissionNumber(stdadmissionno)
   val vehicleDetails = userService.getStudentVehicleDetailsById(studentUser.vehicleId)
   Future(Ok(toJson(vehicleDetails)))
 }
 
 def getStudentEventDetailsByAdmissionNumber(stdadmissionno : String) = Action.async { request =>
   val studentUser = userService.getStdUserByStdAdmissionNumber(stdadmissionno)
   val eventDetails = userService.getStudentEventDetailsByStudentUserId(studentUser.user_id)
   Future(Ok(toJson(eventDetails)))
 }
 
 
 def getEventListByCampusId(campusId : Long) = Action.async { request =>
   val eventList = userService.getEventListBycmapusId(campusId)
   Future(Ok(toJson(eventList)))
 }
 
 def getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum : String,monthNum : Int,status : Int) = Action.async { request =>
   val getAttendanceListByMonth = userService.getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum,monthNum,status)
   /*val getDOIAndUpdatedOn = userService.getDOIAndUpdatedOnByStdAdmNoByMonthNoAndByStatus(stdAdmNum,monthNum,status)
   val attendanceWithDOIAndUpdatedOnList = AttendanceWithDOIAndUpdatedOnList(id=getAttendanceListByMonth.id,stud_id=getAttendanceListByMonth.stud_id,
       Studentadminno = getAttendanceListByMonth.Studentadminno,remark=getAttendanceListByMonth.remark, status = getAttendanceListByMonth.status,
       attendanceDOIAndUpdatedOn = getDOIAndUpdatedOn)*/
   Future(Ok(toJson(getAttendanceListByMonth)))
 }
 
 def getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum : String,fromDate : String,toDate : String,status : Int) = Action.async { request =>
   val format1 = new java.text.SimpleDateFormat("yyyy-MM-dd")
   format1.format(new java.util.Date())
   val frmDate : Date = format1.parse(fromDate)
   val format2 = new java.text.SimpleDateFormat("yyyy-MM-dd")
   format2.format(new java.util.Date())
   val tDate : Date = format2.parse(toDate)
   val getAttendanceListBetweenTwoDates = userService.getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum,frmDate,tDate,status)
   Future(Ok(toJson(getAttendanceListBetweenTwoDates)))
 }
 
 def getAttendanceByStdAdmNo(stdAdmNum : String) = Action.async { request =>
   val attendance = userService.getAttendanceByStdAdmNo(stdAdmNum)
   Future(Ok(toJson(attendance)))
 }
 
 def getStudentPeriviousDetailByStdAdmNum(stdAdmNum : String) = Action.async { request =>
   val stdClassTermList = userService.getStudentPeriviousDetailByStdAdmNum(stdAdmNum)
   val studentClassTermList = new ListBuffer[StdClassTerm]()
   for(stdClassTerm <- stdClassTermList)
   {
     var sClassTerm = stdClassTerm
     sClassTerm.termStartDate = stdClassTerm.termStartDate.toString()
     sClassTerm.termEndDate = stdClassTerm.termEndDate.toString()
     studentClassTermList += sClassTerm
   }
   Future(Ok(toJson(studentClassTermList)))
 }
 
 def getSchoolNewsListBySchoolId(schoolId : Int) = Action.async { request =>
   val schoolNewsList = userService.getSchoolNewsListBySchoolId(schoolId)
   var getSchoolNewsList = new ListBuffer[SchoolNews]()
   for(schoolNews <- schoolNewsList){
     var schoolNws = schoolNews
     schoolNws.newsDate = schoolNews.newsDate.toString()
     getSchoolNewsList += schoolNws
   }
   Future(Ok(toJson(getSchoolNewsList)))
 }
 
 def getSchoolNewsListByCampusId(campusId : Long) = Action.async { request =>
   val schoolNewsList = userService.getSchoolNewsListByCampusId(campusId)
   var getSchoolNewsList = new ListBuffer[SchoolNews]()
   for(schoolNews <- schoolNewsList){
     var schoolNws = schoolNews
     schoolNws.newsDate = schoolNews.newsDate.toString()
     getSchoolNewsList += schoolNws
   }
   Future(Ok(toJson(getSchoolNewsList)))
 }
 
  def getExamDetailsByExamId(examId : Long) = Action.async { request =>
    val examDetail = userService.getExamDetailsByExamId(examId)
   Future(Ok(toJson(examDetail)))
 }
  
 def getEventDetailByEventId(evId : Long) = Action.async { request =>
    val eventUser = userService.getEventDetailByEventId(evId)
   Future(Ok(toJson(eventUser)))
 }
 
 def getExamTimeTableById(ettId : Long) = Action.async { request =>
   val examTimeTable = userService.getExamTimeTableById(ettId)
   Future(Ok(toJson(examTimeTable)))
 }
 
 def getExamTimeTableByExamId(examId : Long) = Action.async { request =>
   val examTimeTable = userService.getExamTimeTableByExamId(examId)
   Future(Ok(toJson(examTimeTable)))
 } 
 
 def getExamTimeTableByClassId(classId : Long) = Action.async{ request =>
   val examTimeTable = userService.getExamTimeTableByClassId(classId)
   Future(Ok(toJson(examTimeTable)))
 }
 
 

 def getClassTimeTableByClassId(classId : Long) = Action.async { request =>
   var classTimeTableList = userService.getClassTimeTableByClassId(classId)
   var subjectMasterList = userService.getSubjectListByClassId(classId)
   var classWithSubjectClassMap = ClassWithSubjectClassMap(classTimeTable = classTimeTableList ,subjectMaster=subjectMasterList)
   Future(Ok(toJson(classWithSubjectClassMap)))
 }
 
 def getStaffTimeTableByClassId(classId : Long) = Action.async { request =>
   var classTimeTableList = userService.getClassTimeTableByClassId(classId)
   var subjectMasterList = userService.getSubjectListByClassId(classId)
   var subjectClassStaffMapping = userService.getSubjectClassStaffMapByClassId(classId)
   val staffTimeTable = StaffTimeTableWithSubjectMasterWithClassTimeTable(classTimeTable = classTimeTableList ,
       subjectMaster=subjectMasterList, subjectClassStaffMap = subjectClassStaffMapping)
   Future(Ok(toJson(staffTimeTable)))
 }
 
 def getMarksDetailBySubjectId(subjectId : Long) = Action.async { request =>
   val marks = userService.getMarksDetailBySubjectId(subjectId)
   Future(Ok(toJson(marks)))
 }
 
 def getMarksListByclassId(classId : Long) = Action.async { implicit request =>
   val marks = userService.getMarksListByclassId(classId)
   Future(Ok(toJson(marks)))
 }
 
 def getMarksListByStdAdmNum(stdAdmNum : String) = Action.async { implicit request =>
   val studentDetailsForMarks = userService.getStudentDetailsForMarksByStdAdmNum(stdAdmNum)
   val marksList = userService.getMarksListByStdAdmNum(stdAdmNum)
   val result = userService.getStudentResultByUserId(studentDetailsForMarks.userId)
   val studentUserMarks = StudentUserMarks(firstName = studentDetailsForMarks.firstName, lastName = studentDetailsForMarks.lastName,
       middleName = studentDetailsForMarks.middleName,userId = studentDetailsForMarks.userId, 
       Studentadminno = studentDetailsForMarks.Studentadminno,contactNumber = studentDetailsForMarks.contactNumber,
       className = studentDetailsForMarks.className,campusName = studentDetailsForMarks.campusName,
       orgName = studentDetailsForMarks.orgName,examName = studentDetailsForMarks.examName,marksStudent = marksList, result = result)
   Future(Ok(toJson(studentUserMarks)))
 }
 
 
 def getClassListByStaffUserId(userId : Long) = Action.async { implicit request =>
   val classListBystfUserId = userService.getClassListByStaffUserId(userId)
   Future(Ok(toJson(classListBystfUserId)))
 }
 
 def getStaffListByClassId(classId : Long) = Action.async { implicit request =>
   val staffListByClassId = userService.getStaffListByClassId(classId)
   Future(Ok(toJson(staffListByClassId)))
 }
 
 def getVehicleTypeListByCampusId(campusId : Long) = Action.async { implicit request =>
   val vehicleTypeList = userService.getVehicleTypeListByCampusId(campusId)
   Future(Ok(toJson(vehicleTypeList)))
 }
 
 def getVehicleDetailByStaffUserId(userId : Long) = Action.async { implicit request => 
   val vehicleDetail = userService.getVehicleIdByStaffUserId(userId)
   
   if(vehicleDetail.vehicleId == null){
     val staffCompleteVehicleDetail = "No Vehicle Has Been Assigned to this Satff"
     Future(Ok(toJson(staffCompleteVehicleDetail)))
   }
   else{
     val vehicleRouteDetails = userService.getVehicleAndRoutesByVhId(vehicleDetail.vehicleId)
   val stopDetails = userService.getStopDetailsByRouteId(vehicleRouteDetails.rdId)
   val vehicleTypeDetail = userService.getVehicleTypeById(vehicleRouteDetails.Vehicle_type_id)
   val staffCompleteVehicleDetail = StaffCompleteVehicleDetail(staffDetail = vehicleDetail, vehicleDetail = vehicleRouteDetails,
       StopDetailsList = stopDetails, vehicleType = vehicleTypeDetail)  
       Future(Ok(toJson(staffCompleteVehicleDetail)))
   }
   
   
 }
 
 
 def getAssignmentByStaffUserId(userId : Long) = Action.async { implicit request => 
   val assignment = userService.getAssignmentByStaffUserId(userId)
   Future(Ok(toJson(assignment)))
 }
 
 //get image
 
 
 def  getImage(key:String)= Action.async { implicit request =>
   val existingBucketName: String = "shrikanth";
  val keyName : String ="/"+key;
  println("enetered into getimage method")
 
  val credentials:AWSCredentials = new AWSCredentials 
  {
    
    val getAWSAccessKeyId: String = current.configuration.getString("AWSAccessKeyId").get
     val getAWSSecretKey: String = current.configuration.getString("AWSSecretKey").get
    }
         val client = new AmazonS3Client(credentials)
         val s3object = client.getObject(new GetObjectRequest(existingBucketName, keyName));
         var imagedata : java.io.InputStream = null
         if(s3object.getKey.equals(keyName))
             {
           imagedata=  displayTextInputStream(s3object.getObjectContent());
           val  baos = new ByteArrayOutputStream();  
  //  ImageIO.write(imagedata, "jpg", baos);  
  //  return ok(baos.toByteArray()).as("image/jpg"); 
           val url:String="http://d3gz659922w10o.cloudfront.net/"+keyName;
     Ok(views.html.index())
   
             }
         /*val writer = new OutputStreamWriter(new FileOutputStream());
        writer.write("abcdefghijklmnopqrstuvwxyz\n");*/
  Future(Ok(toJson("success"+imagedata)))  
        }
   def  displayTextInputStream(input:InputStream):InputStream= {
   
      // Read one text line at a time and display.
        val reader = new BufferedReader(new 
            InputStreamReader(input));
        while (true) {
            val line:String = reader.readLine();
            if (line == null) break;

            System.out.println("    " + line);
        }
        
        System.out.println();
        return input
    }
   
   def index = Action {

    // say hello
    //logger.info("Hello, world")
     println("hello, index action started")
    //logger.info("hello, index action started")

    val Tick = "tick"
    val Tack = "tack"

    val tickActor = Akka.system.actorOf(Props(new Actor {
      def receive = {
        case Tick => println("that still ticks!")
        case Tack => println("... 7 seconds after start, only once")
      }
    }))

    // Repeat every 5 seconds, start 5 seconds after start
    Akka.system.scheduler.schedule(
      5 seconds,
      5 seconds,
      tickActor,
      Tick
    )

    // do only once, 7 seconds after start
    Akka.system.scheduler.scheduleOnce(7 seconds, tickActor, Tack)
    println(" End Of Index File ")
    Ok(views.html.index())
  }
   
   
 //def getGuardianUserListByStdAdmNum
 
 /* def createVehicleDetailsByVehicleType = Action.async{ request =>
    val vtypeId : Long = 1
    val vid : Long = 1
    userService.getVehicledetailsById(vid).map { VehicleDetails =>
      userService.createVehicleDetailsByVehicleType(VehicleDetails)
       Ok(toJson(VehicleDetails))
    }
  }*/
  
  
  /*def getStudentUserByFatherName = SecuredAction.async{ request => 
          val ffname : String = "Amar" 
          userService.getStudentUserByFatherName(ffname).map{ StudentUser =>
            Ok(toJson(StudentUser))
      }
  }*/
  
  /*def createAttendenceStd() = { 
  var AttendenceDetails = AttendanceList(id = 0,stud_id=StdId, Firstname = "ABC" , remark = "Absent", status = 1, DOI = "2015-06-01",updatedon="2015-06-20 12:31:46")
  AttendenceDetails = userService.createAttendence(AttendenceDetails)
 // println("ABC")
  //println(" Done Attedence")
  }*/
  
}