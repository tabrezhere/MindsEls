package services

import java.util.UUID
import models.users.Student_Guardian_Mapping
import javax.inject.Inject
import play.api.libs.concurrent.Execution.Implicits._
import com.mohiva.play.silhouette.core.LoginInfo
import com.mohiva.play.silhouette.core.services.AuthInfo
import com.mohiva.play.silhouette.core.providers.CommonSocialProfile
import scala.concurrent.Future
import scala.collection.mutable
import models.users._
import models.daos.UserDAO
import security.models.StaffDetail
import security.models.GuardianDetail
import security.models.StudentDetail
import dtos.UserDTO
import models.commons.Context
import com.mohiva.play.silhouette.core.providers.CredentialsProvider
import javax.inject.Inject
import play.api.libs.concurrent.Execution.Implicits._
import play.api.Play.current
import scala.concurrent.Future
import com.typesafe.plugin._
import anorm._
import security.models.DriverDetail
import security.models.CreateVehicleDetail
import models.commons.Campus
import java.util.Date
import play.api._



import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData
import play.api.mvc.Request

import com.amazonaws.AmazonClientException
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient
import com.amazonaws.services.simpleemail.model.Body
import com.amazonaws.services.simpleemail.model.Content
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message
import com.amazonaws.services.simpleemail.model.SendEmailRequest

//import dtos.UserDTO

/**
 * BASIC IMPLEMENTATION
 * Handles actions to users.
 *
 * @param userDAO The user DAO implementation.
 */
class UserServiceImpl @Inject() (userDAO: UserDAO) extends UserService {

  private val log: Logger = Logger(this.getClass)
   /**
   * Retrieves a user that matches the specified login info.
   *
   * @param loginInfo The login info to retrieve a user.
   * @return The retrieved user or None if no user could be retrieved for the given login info.
   */
  def retrieve(loginInfo: LoginInfo): Future[Option[User]] = Future {
    println("UserServiceImpl.retrieve started")
    loginInfo.providerID match {
      case "credentials" =>
        println("UserServiceImpl.retrieve called byUserName")
        userDAO.byUserName(loginInfo.providerKey).map(User(_))
      case _ =>
        //TODO: logging unsupported provider
        //TODO: either return failed future with reason
        None
    }
    
  }
  
  def getStdDetailByStdAdmissionNumberAndCampusId(Studentadminno : String,campusId : Long) : Option[StudentUser] = {
    userDAO.getStdDetailByStdAdmissionNumberAndCampusId(Studentadminno,campusId)
  }
    
  def getCampusDetailsByCampusId(id : Long) : Campus = {
    userDAO.getCampusDetailsByCampusId(id)
  }
  
  def getOrganizationDetailByOrgId(id : Long) : Organization = {
     userDAO.getOrganizationDetailByOrgId(id)
  }
  
    def getDriverByDLno(DLno : String) : DriverDetail = {
      userDAO.getDriverByDLno(DLno)
    }
    
    /*def createVehicleDetailsByVehicleType(vehicleDetails : VehicleDetail) : Future[Option[VehicleDetail]] = Future {
      println("UserServiceImpl.retrieve started")
    vehicleDetails match {
      case vehicleDetails =>
        println("UserServiceImpl.retrieve called byUserName")
        userDAO.createVehicleDetailsByVehicleType(vehicleDetails).map(VehicleDetail(_, _, _, _, _, _, _, _, _, _))
      case _ =>
        //TODO: logging unsupported provider
        //TODO: either return failed future with reason
        None
    }
    }*/
    /*
     * 
     * Retrieve Staff Infromation
     * 
     
    
    def retrieve(loginInfo: LoginInfo): Future[Option[User]] = Future {
    println("UserServiceImpl.retrieve started")
    loginInfo.providerID match {
      case "credentials" =>
        println("UserServiceImpl.retrieve called byUserName")
        userDAO.byStaffName(loginInfo.providerKey).map(User(_))
      case _ =>
        //TODO: logging unsupported provider
        //TODO: either return failed future with reason
        None
    }*/
    
    /*
    UserServiceImpl.users.find {
      case (id, user) => user.loginInfo == loginInfo || user.socials.map(_.find(li => li == loginInfo)).isDefined
    }.map(_._2)
    * 
    */
 

  /**
   * Saves a user.
   *
   * @param user The user to save.
   * @return The saved user.
   */
  def save(user: User): Future[User] = Future {
    println("UserServiceImpl.save started in Future")
    if (user.id == 0) {
      println("UserServiceImpl.save create")
      val u = User(userDAO.create(user.username, user.firstName.get, user.middleName.get, user.lastName.get,user.DOB.get,user.Gender.get,user.address1.get, user.address2.get,user.city.get, user.state.get))
      println("UserServiceImpl.save exit1")
      u
    } else {
      println("UserServiceImpl.save update")
     // userDAO.update(UserDTO(user))
      println("UserServiceImpl.save exit2 in Future")
      user
    }
  }
  
  
  /*def createVehicleDetailsByVehicleType(vdetails : VehicleDetail) : Future[VehicleDetail] = Future{
    println("UserServiceImpl.save started in Future")
    if (vdetails.id == 0) {
      println("UserServiceImpl.save create")
      val vd = VehicleDetail(userDAO.createVehicle(vdetails.Vehicle_no, vdetails.Vehicle_code, vdetails.No_of_Seat, vdetails.Maximum_capacity, vdetails.insurance, vdetails.tax_remitted, vdetails.permit, vdetails.status, vdetails.Vehicle_type_id))
      println("UserServiceImpl.save exit1")
      vd
    } else {
      println("UserServiceImpl.save update")
     // userDAO.update(UserDTO(user))
      println("UserServiceImpl.save exit2 in Future")
      vdetails
    }
  }*/
  
  /**
   * Save UserLogin
   */
  
  def saveUserLogin(userLogin : UserLogin): Future[UserLogin] = Future {
     println("UserServiceImpl.saveUserLogin started in Future")
     if(userLogin.id == 0){
       println("UserServiceImpl.saveUserLogin create")
       val ul = userDAO.createUserLogin(userLogin)
      println("UserServiceImpl.saveUserLogin exit1")
       ul
     }else {
        println("UserServiceImpl.saveUserLogin update")
     // userDAO.update(UserDTO(user))
      println("UserServiceImpl.saveUserLogin exit2 in Future")
     userLogin
     }    
  }
  
  
  /**
   * Save UserContext
   */
  
  
  def saveUserContext(userContext : UserContext): Future[UserContext] = Future {
     println("UserServiceImpl.saveUserLogin started in Future")
     if(userContext.id == 0){
       println("UserServiceImpl.saveUserLogin create")
       val ul = userDAO.createUserContext(userContext)
      println("UserServiceImpl.saveUserContext exit1")
       ul
     }else {
        println("UserServiceImpl.saveUserContext update")
     // userDAO.update(UserDTO(user))
      println("UserServiceImpl.saveUserLogin exit2 in Future")
     userContext
     }
  }
  
  

  /**
   * Saves the social profile for a user.
   *
   * If a user exists for this profile then update the user, otherwise create a new user with the given profile.
   *
   * @param profile The social profile to save.
   * @return The user for whom the profile was saved.
   */
  def save[A <: AuthInfo](profile: CommonSocialProfile) = {
    retrieve(profile.loginInfo).flatMap {
      case Some(user) => // Update user with profile
        val u: User = user.copy(
          firstName = profile.firstName,
          middleName = profile.fullName,
          lastName = profile.lastName)
        //          username = 
        //          email = profile.email,
        //          avatarUrl = profile.avatarURL)
        save(u)
      case None => // Insert a new user
        //println("we are here")
        val u = User(
          id = 0,
          loginInfo = profile.loginInfo,
          username = profile.loginInfo.providerID,
          //          username = profile.loginInfo.providerKey,
         
            firstName = profile.firstName,
            lastName = profile.lastName,
            middleName = profile.fullName,
            DOB = None,
            Gender = None,
            address1 = None,
            address2 = None,
            city = None,
            state = None,
            Deleted = None) //          email = profile.email,
            //          avatarUrl = profile.avatarURL
            
        save(u)
    }
  }

  
  /**
   * Save StaffDetails
   */
  
  
  def saveStaffDetails(staffDetails : StaffDetail): Future[StaffDetail] = Future {
     println("UserServiceImpl.saveUserLogin started in Future")
     if(staffDetails.id == 0){
       println("UserServiceImpl.saveStaffDetails create")
       val ul = userDAO.createStaffDetails(staffDetails)
      println("UserServiceImpl.saveUserLogin exit1")
       ul
     }else {
        println("UserServiceImpl.saveUserContext update")
     // userDAO.update(UserDTO(user))
      println("UserServiceImpl.saveUserLogin exit2 in Future")
     staffDetails
     }
  }
  
  
  
   /*
   * saveStudentDetails
   */
  def saveStudentDetails(studentDetails : StudentDetail) : Future[StudentDetail] = Future {
    println("UserServiceImpl.saveUserLogin started in Future")
     if(studentDetails.id == 0){
       println("UserServiceImpl.studentDetails create")
       val sd = userDAO.createStudentDetails(studentDetails)
      println("UserServiceImpl.saveUserLogin exit1")
       sd
     }else {
        println("UserServiceImpl.saveUserContext update")
     // userDAO.update(UserDTO(user))
      println("UserServiceImpl.saveUserLogin exit2 in Future")
     studentDetails
     }
  }
  
  
  
  
  
  
  /*
   * 
   * GuardianDetails
   * 
   */
  
  
   def saveGuardianDetails(guardianDetails : GuardianDetail): Future[GuardianDetail] = Future {
     println("UserServiceImpl.saveUserLogin started in Future")
     if(guardianDetails.id == 0){
       println("UserServiceImpl.saveStaffDetails create")
       val ul = userDAO.createGuardianDetails(guardianDetails)
      println("UserServiceImpl.saveUserLogin exit1")
       ul
     }else {
        println("UserServiceImpl.saveUserContext update")
     // userDAO.update(UserDTO(user))
      println("UserServiceImpl.saveUserLogin exit2 in Future")
     guardianDetails
     }
  }
  
  
  /**
   * Link a social social profile on a user.
   *
   * 
   * 
   *
   * @param profile The social profile to save.
   * @return The user for whom the profile was saved.
   */
  def link[A <: AuthInfo](user: User, profile: CommonSocialProfile): Future[User] = {
    val s = user.socials.getOrElse(Seq())
    val u = user.copy(socials = Some(s :+ profile.loginInfo))
    save(u)
  }
  
  
  /*def getUserLoginByUserId(user : User) : Future[UserLogin] = Future {
    
    println("UserServiceImpl.getUserLoginByUserId started")
    println(s"user.id")
    val ul=userDAO.getUserLoginByUserId(user.id)
    println("UserServiceImpl.getUserLoginByUserId exit1")
    ul
 
  }
  
  def getUserContextByUSerId(user :User) : Future[UserContext] = Future {
    
     println("UserServiceImpl.getUserContextByUSerId started")
     println(s"user.id")
     val uc=userDAO.getUserContextByUSerId(user.id)
     println("UserServiceImpl.getUserLoginByUserId exit1")
     uc
    
  }
  
  def getStaffDetailsByUserContextId(userContext : UserContext) : Future[StaffDetail] = Future{
     println("UserServiceImpl.getStaffDetailsByUserContextId started")
     println(s"userContext.id")
     val sd=userDAO.getStaffDetailsByUserContextId(userContext.id)
     println("UserServiceImpl.getUserLoginByUserId exit1")
     sd
    
  }
  */
  
  def getUserById(userId : Long) : Future[UserDTO] = Future {
    // println(userId"user.userId")
    userDAO.getUserById(userId)
  }
  
  def getUserLoginByEmail(email : String) : Future[UserLogin] = Future {
   userDAO.getUserLoginByEmail(email)
  }
  
  //getUserContextById
  def getUserContextById(id : Long) : Future[UserContext] = Future {
      userDAO.getUserContextById(id)
   }
   
   //getContextById
   def getContextById(id : Long) : Future[Context] = Future {
     userDAO.getContextById(id)
   }
   
   def getContextByUserId(id : Long) : UserContext = {
     userDAO.getContextByUserId(id)
   }
   
   //getStaffDetailById
    def getStaffDetailById(user_contextid : Long) : Future[StaffDetail] = Future {
       userDAO.getStaffDetailById(user_contextid)
    }
    
    // getStudentDetailsById
    def getStudentDetailsById(id : Long) : Future[StudentDetail] = Future {
      userDAO.getStudentDetailsById(id)
    }
    
    def getStudentUserByFirstname(Firstname : String) : Future[StudentUser] = Future {
      userDAO.getStudentUserByFirstname(Firstname)
    }
    
    /*def getStudentUserByFatherName(ffname : String) : Future[List[StudentUser]] = Future {
      var stdGdMap = getstdFatherName(ffname)
      var stdNoSplit : Array[String] = stdGdMap.stdadmissionno.split(',')
      
             
         userDAO.getStdDetailByStdAdmNumber(stdNoSplit)
     
    }*/
    
    //getstdFatherName(ffname)
    def getstdFatherName(fathername : String) : Future[Student_Guardian_Mapping] = Future {
      println(" User Service IMPL Father Name : "+fathername)
      userDAO.getStdAdmNumbers(fathername)
    }
    
    //getGuardianDetails
     def getGuardianDetailsById(id : Long) : Future[GuardianDetail] = Future {
        userDAO.getGuardianDetailsById(id)
     }
     
     
     //Updates
     
    /* def updateStaffDetails(id : Long) : Future[StaffDetail] = Future {
       userDAO.updateStaffDetails(id)
     }*/
     
     def updateStudentDetails(id : Long) : Future[StudentDetail] = Future {
       val std= userDAO.updateStudentDetails(id)
       userDAO.updateSD(std,id)
       std
      
     } 
     
    /* def updateGuardianDetails(id : Long) : Future[GuardianDetail] = Future {
       val gd = userDAO.updateGuardianDetails(id)
       
       userDAO.updateGD(gd,id)
       
       gd
     }*/
     
      def deleteUserDetailsById(id: Long) : Future[StudentDetail] = Future {
        val sd = userDAO.deleteUserDetailsById(id)
        userDAO.deleteUD(sd,id)
         sd
      }
      
      def getFromDBStudentUserById(id : Long) : StudentUser= {        
        userDAO.getStudentUserByUserId(id)
      }
      
      def getFromDBStaffUserById(id : Long) : StaffUser = {
        userDAO.getStaffUserByUserId(id)
      }
      
       def getFromDBGuardianUserById(id : Long) : GuardianUser = {
        userDAO.getGuardianUserByUserId(id)
      }
      
      def getFromDBCampusAdminUserById(id : Long) : CampusAdminUser = {
        userDAO.getFromDBCampusAdminUserById(id)
      }
      
      def getFromDBLibrarianUserById(id : Long) : LibrarianUser = {
        userDAO.getLibrarianUserByUserId(id)
      }
  
      def getFromDBDriverUserById(id : Long) : DriverUser = {
        userDAO.getDriverUserByUserId(id)
      }
      
      def getStudentUserById(id : Long) : Future[StudentUser]= Future{        
        userDAO.getStudentUserByUserId(id)
      }
      
      def getStaffUserById(id : Long) : Future[StaffUser] = Future{
        userDAO.getStaffUserByUserId(id)
      }
      
      def getGuardianUserById(id : Long) : GuardianUser = {
        userDAO.getGuardianUserByUserId(id)
      }
      
      def getAllGuardianListByCampusId(campusId : Long) : List[GuardianUser] = {
        userDAO.getAllGuardianListByCampusId(campusId)
      }
      
      def getStudentUserListByCampusId(campusId : Long) : Future[List[StudentUser]] = Future {
        userDAO.getStudentUserListByCampusId(campusId)
      }
      
      def getStaffUserListByCampusId(campusId : Long) : Future[List[StaffUser]] = Future {
        userDAO.getStaffUserListByCampusId(campusId)
      }
      
      def getAllClassesByCampusId(campusId : Long) : List[Class] =  {
         userDAO.getAllClassesByCampusId(campusId)
      }
      
      def getStdDetailByStdAdmissionNumber(number : String) : Option[StudentDetail] =  {
        userDAO.getStdDetailByStdAdmissionNumber(number)
      }
      
      def createStuGuarMapping(student_Guardian_MappingDetails : Student_Guardian_Mapping) : Student_Guardian_Mapping = {
        userDAO.createStuGuarMapping(student_Guardian_MappingDetails)
      }
      
      def getTermType() : Future[List[TermType]] = Future{
        userDAO.getTermType()
      }
      
      def getClassById(id : Long) : Class = {
        userDAO.getClassById(id)
      }
      
      def insertStudentClassMap(studentClassMap : StudentClassMapping) : Future[StudentClassMapping] = Future {
        userDAO.insertStudentClassMap(studentClassMap)
      }
      
      def getTermDetails(termTypeId : Long) : Term = {
        userDAO.getTermDetails(termTypeId)
      }
     def saveUserTermDetails(userTermDetails : UserTerm) : Future[UserTerm] = Future {
       userDAO.saveUserTermDetails(userTermDetails)
     }
     
     
      //getStudentListByClassId
     
     def getStudentListByClassId(classId : Long) : Future[List[StudentUser]] = Future {
        userDAO.getStudentListByClassId(classId)
      }
     
     def getStudentAttendenceListByClassId(classId : Long) : List[AttendanceCommon] = {
       userDAO.getStudentAttendenceCommonListByClassId(classId)
     }
     
     //createStudentAttendence(attendanceList)
     def createStudentAttendence(attendance : AttendanceList) : AttendanceList =  {
        userDAO.createStudentAttendence(attendance)
      }
     
     def getCourseById(id : Long) : Course = {
       userDAO.getCourseById(id)
     }
     
     
     def saveCourseStaff(courseStaffDetails : CourseStaffMapping) : Future[CourseStaffMapping] = Future {
         userDAO.saveCourseStaff(courseStaffDetails)
     }
     
     def getVehicleListByCampusId(campusId : Long) :  Future[List[CreateVehicleDetailUser]] = Future {
         userDAO.getVehicleListByCampusId(campusId)
     }
     
     def getDriverListByCampusId(campusId : Long) :  Future[List[DriverUser]] = Future {
           userDAO.getDriverListByCampusId(campusId)
     }
     
     def getVehicleListByCampusIdDriverId(campusId : Long,dId : Long) :  Future[List[VehicleDetail]] = Future {
           userDAO.getVehicleListByCampusIdDriverId(campusId,dId)
     }
     
     def getPasswordRestKey(email : String) : Future[String] = Future[String] {
       userDAO.byEmail(email) match {
      case Some(user) => userDAO.getValidPasswordResetKey(user.id).getOrElse[String] {
        import java.security.MessageDigest
        import util.Random
         val md5Bytes = MessageDigest.getInstance("MD5").digest((user.id.toString + Random.nextString(255)).getBytes)
        val key = md5Bytes.map("%02X".format(_)).mkString

        // println(s"key length ${key.length()}")
        // val key = Random.nextString(255)
        userDAO.savePasswordResetKey(user.id, key)
        key
      }
     }
     }
     
     def getLoginInfoByRestKey(key : String) : Future[LoginInfo] = Future {
         userDAO.getUserByResetKey(key).map{ u =>
              LoginInfo(CredentialsProvider.toString(), u.email)
              }.get
     }
     
    override def sendPasswordResetInstructions(key : String,email: String): Future[Unit] = Future {
    val ctx = s"sending forgot password email, email [$email]"
    val user = userDAO.byEmail(email) match {
      case Some(u) => u
    }
    val FROM = current.configuration.getString("email.from").get // Replace with your "From" address. This address must be verified.
    val TO = email // Replace with a "To" address. If you have not yet requested
    // production access, this address must be verified.
    
    val BODY = "WELCOME TO MINDS".toString
    val SUBJECT = "Reset password at theApp.com"
    // Construct an object to contain the recipient address.
   /* val destination: Destination = new Destination().withToAddresses(TO)*/

    // Create the subject and body of the message.
    /*val subject = new Content().withData(SUBJECT)
    val textBody = new Content().withData(BODY)
    val body = new Body().withHtml(textBody)
*/
    // Create a message with the specified subject and body.
    /*val message = new Message().withSubject(subject).withBody(body)*/

    // Assemble the email.
   /* val request = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message)*/
    /*println("email notifier")
    val mail=use[MailerPlugin].email
    println(" MAIL : "+mail)
    mail.setSubject(SUBJECT)
    mail.addRecipient(TO)
    mail.addFrom(FROM)
    mail.send(key)
    println("email notifier end")*/
val destination = new Destination().withToAddresses(TO)
    val subject = new Content().withData(SUBJECT)
    val textBody = new Content().withData(BODY)
    val body = new Body().withText(textBody)
 
    val message = new Message().withSubject(subject).withBody(body)
    val request = new SendEmailRequest().withSource(FROM).withDestination(destination)
      .withMessage(message)
    try {
      println("Attempting to send an email through Amazon SES by using the AWS SDK for scala...")
      var credentials: AWSCredentials = null
      credentials = new ProfileCredentialsProvider("default").getCredentials
      val client = new AmazonSimpleEmailServiceClient(credentials)
      val REGION = Region.getRegion(Regions.US_EAST_1)
      client.setRegion(REGION)
      client.sendEmail(request)
      println("Email sent!")
    } catch {
      case ex: Exception => {
        println("The email was not sent.")
        println("Error message: " + ex.getMessage)
      }
    }
  

   /* val credentials:AWSCredentials = new AWSCredentials {
      override def getAWSAccessKeyId: String = current.configuration.getString("AWSAccessKeyId").get
      override def getAWSSecretKey: String = current.configuration.getString("AWSSecretKey").get
      println(" getAWSAccessKeyId : "+getAWSAccessKeyId)
    println(" getAWSSecretKey : "+getAWSSecretKey)
    }
*/
    // Instantiate an Amazon SES client, which will make the service call with the supplied AWS credentials.
    //val client = new AmazonSimpleEmailServiceClient(credentials)

    // Choose the AWS region of the Amazon SES endpoint you want to connect to. Note that your production
    // access status, sending limits, and Amazon SES identity-related settings are specific to a given
    // AWS region, so be sure to select an AWS region in which you set up Amazon SES. Here, we are using
    // the US East (N. Virginia) region. Examples of other regions that Amazon SES supports are US_WEST_2
    // and EU_WEST_1. For a complete list, see http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html
   // val REGION = Region.getRegion(Regions.US_EAST_1)
    
    
    //client.setRegion(REGION)
    println("========================================")
    println(" From Email : "+FROM)
    println(" To Email : "+TO)
    //println(" Message : "+message)
    //println(" request : "+request)
    //println(" credentials AWS : "+credentials)
    //println(" client : "+client)
    //sprintln(" REGION : "+REGION)
    //println(" Subject : "+subject)
    //println(" Body : "+body)
   // println("Destination : "+destination)
    
    println("========================================")
    //client.sendEmail(request)
  }
    
    def saveRestPassword(userId : Long,key : String) : Future[Unit] = Future {
      userDAO.saveRestPassword(userId,key)
    }
         
    def changePassword(userId : Long,newpassword : String) : Future[Unit] = Future {
      userDAO.changePassword(userId,newpassword)
    }
    
    def getStudentClassMapListByClassId(classId : Long) : List[StudentClassMapping] = {
      userDAO.getStudentClassMapListByClassId(classId)
    }
     
  
    def saveDriverDetails(driverDetails : DriverDetail) : Future[DriverDetail] = Future {
    println("UserServiceImpl.saveUserLogin started in Future")
     if(driverDetails.id == 0){
       println("UserServiceImpl.studentDetails create")
       val dd = userDAO.createDriverDetails(driverDetails)
      println("UserServiceImpl.saveUserLogin exit1")
       dd
     }else {
      println("UserServiceImpl.saveUserLogin exit2 in Future")
     driverDetails
     }
  }
    
    
  
  def createVehicleDetails(vdetails : VehicleDetail) : VehicleDetail = {
    userDAO.createVehicleDetails(vdetails)
  }
  
  def getStopDetailsByRouteId(routeId : Int) : List[StopDetail] = {
    userDAO.getStopDetailsByRouteId(routeId)
  }
  
  def getStdAdmNumberList(userId : Long) : List[Student_Guardian_Mapping] = {
    userDAO.getStdAdmNumberList(userId)
  }
  def createRouteDetails(routeDetails : RouteDetail) : RouteDetail = {
     userDAO.createRouteDetails(routeDetails)
  }
  
  def createStopDetail(stopDetail : StopDetail) : StopDetail = {
    userDAO.createStopDetail(stopDetail)
  }
 
 def getVehicleAndRoutesByVhId(vid : Option[Long]) :  CreateVehicleDetailUser = {
    userDAO.getVehicleAndRoutesByVhId(vid)
  }
 
 def saveLibrarian(librarian : Librarian) : Future[Librarian] = Future{
    userDAO.saveLibrarian(librarian)
 }
  
 def getLibrariansListByCampusId(campusId : Long) : Future[List[LibrarianUser]] = Future{
   userDAO.getLibrariansListByCampusId(campusId)
 }
 
 def createAuthor(authorDetail : Author) : Author = {
   userDAO.createAuthor(authorDetail)
 }
  
  def createbookDetail(bookDetail : Book) : Book = {
    userDAO.createbookDetail(bookDetail)
  }
  
  def createbookAuthorDetails(bid : Int,aid : Int) : Unit ={
    userDAO.createbookAuthorDetails(bid,aid)
  }
  
  def getBookId(id : Int) : BookCategories = {
    userDAO.getBookId(id)
  }
  
  def getBookListByCampusId(campusId : Long) : Future[List[CreateBookUser]] = Future{
    userDAO.getBookListByCampusId(campusId)
  }
  
  def createbookCategories(bid : Int,bcid : Int) : Unit ={
    userDAO.createbookCategories(bid,bcid)
  }
  
  def createMedical(medical : Medical) : Medical = {
    userDAO.createMedical(medical)
  }
  
  def createEvent(event : Events) : Events = {
    userDAO.createEvent(event)
  }
  
  def createCampus(campus : Campus) : Campus = {
    userDAO.createCampus(campus)
  }
  
  def getMedicalDetailByUserId(userId : Long) : Future[Medical] = Future {
      userDAO.getMedicalDetailByUserId(userId)
  }
  
  def getMedicalDetailListByCampusId(campusId : Long) : Future[List[Medical]] = Future {
    userDAO.getMedicalDetailListByCampusId(campusId)
  }
  
  def createBookIssue(bookIssue : BookIssue) : Unit = {
    userDAO.createBookIssue(bookIssue)
  }
  
  def getStudentUserByStdAdmissionNo(stdAdmissionNumbers : String) : StudentUser = {
    userDAO.getStudentUserByStdAdmissionNo(stdAdmissionNumbers)
  }
  
  def createAssignment(assignment : Assignment) : Assignment = {
    userDAO.createAssignment(assignment)
  }
  
  def getAssignmentByClassId(cid : Int) : List[AssignmentUser] = {
    userDAO.getAssignmentByClassId(cid)
  }
  def createOrganization(organization : Organization) : Organization = {
    userDAO.createOrganization(organization)
  }
  // createSchool

    def createSchool(school:School) : School = {
    userDAO.createSchool(school)
  }
def getHolidaysListByCampusId(campusId:Long):Future[List[Holiday]]=Future
{
   userDAO.getHoliday(campusId)
}

 def getSchoolListByCampusId(campusId:Int):Future[List[School]]=Future
{
   userDAO.getSchoolList(campusId)
}
//  createHoliday
def createHoliday(holiday:Holiday) : Holiday = {
userDAO.createHoliday(holiday)
}

def getVehicleTypeById(id : Int) : VehicleType = {
  userDAO.getVehicleTypeById(id)
}

def getbookCategoriesBybookCategorieId(bcid : Int) : BokCategories = {
  userDAO.getbookCategoriesBybookCategorieId(bcid)
}

def getCampusIdByUserIdFromUserContext(userId : Long) : UserContext = {
  userDAO.getCampusIdByUserIdFromUserContext(userId)
}

def getListOfStudentByCampusIdWhoHasTakenBooks(campusId : Long) : List[StudentUser] = {
  userDAO.getListOfStudentByCampusIdWhoHasTakenBooks(campusId)
}

def getStudentWhoHasReturnBookByStdUserId(stdUserId : Long) : BookIssue = {
  userDAO.getStudentWhoHasReturnBookByStdUserId(stdUserId)
}

def updateStudentWhoHasReturnBook(bookIssueReturn : BookIssue) : Unit = {
  userDAO.updateStudentWhoHasReturnBook(bookIssueReturn)
}

def getStdUserByStdAdmissionNumber(studentAdmNum : String) : StudentUser = {
  userDAO.getStdUserByStdAdmissionNumber(studentAdmNum)
}

def getGuardianUserByStudentAdmissionNumber(stdadmissionno : String) : List[GuardianUser] = {
  userDAO.getGuardianUserByStudentAdmissionNumber(stdadmissionno)
}

def getStudentMedicalDetailsByStudentUserId(user_id : Long) : Medical = {
  userDAO.getStudentMedicalDetailsByStudentUserId(user_id)
}

def getStudentVehicleDetailsById(vdId : Option[Long]) : CreateVehicleDetailUser = {
  userDAO.getStudentVehicleDetailsById(vdId)
}

def getStudentEventDetailsByStudentUserId(studId : Long) : Events = {
  userDAO.getStudentEventDetailsByStudentUserId(studId)
}

def getEventListBycmapusId(campusId : Long) : List[Events] = {
  userDAO.getEventListBycmapusId(campusId)
}

def getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum : String,monthNum : Int,status : Int) : List[AttendanceList] = {
  userDAO.getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum,monthNum,status)
}

def getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum : String,fromDate : Date,toDate : Date,status : Int) : List[AttendanceList] = {
  userDAO.getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum,fromDate,toDate,status)  
}

def getAttendanceByStdAdmNo(stdAdmNum : String) : List[AttendanceList] = {
  userDAO.getAttendanceByStdAdmNo(stdAdmNum)
}

def getStudentPeriviousDetailByStdAdmNum(stdAdmNum : String) : List[StdClassTerm] = {
  userDAO. getStudentPeriviousDetailByStdAdmNum(stdAdmNum)
}

def insertSchoolNews(schoolNews : SchoolNews) : SchoolNews = {
  userDAO.insertSchoolNews(schoolNews)
}

def getSchoolNewsListBySchoolId(schoolId : Int) : List[SchoolNews] = {
  userDAO.getSchoolNewsListBySchoolId(schoolId)
}

def getSchoolNewsListByCampusId(campusId : Long) : List[SchoolNews] = {
  userDAO.getSchoolNewsListByCampusId(campusId)
}

def insertExam(exam : Exam) : Exam = {
  userDAO.insertExam(exam)
}

def getExamDetailByExamId(examId : Long) : Exam = {
  userDAO.getExamDetailByExamId(examId)
}

def insertExamClassMap(examClassMap : ExamClassMap) : ExamClassMap = {
  userDAO.insertExamClassMap(examClassMap)
}

//insertSubjectClassMap
def insertSubjectClassMap(subjectClassMap : SubjectClassMap) : SubjectClassMap = {
  userDAO.insertSubjectClassMap(subjectClassMap)
}
def getExamDetailsByExamId(examId : Long) : ExamInfo = {
  userDAO.getExamDetailsByExamId(examId)
}

def getSubjectListByClassId(classId : Long) : List[SubjectMaster] = {
  userDAO.getSubjectListByClassId(classId)
}

def createExamTimeTable(examTimeTable : ExamTimeTable) : ExamTimeTable = {
  userDAO.createExamTimeTable(examTimeTable)
}

def createClassTimeTable(classTimeTable : ClassTimeTable) : ClassTimeTable = {
  userDAO.createClassTimeTable(classTimeTable)
}

def getSubjectsById(id:Long): SubjectMaster = {
  userDAO.getSubjectListById(id)
}

def getAllSubjectList : List[SubjectMaster] = {
  userDAO.getAllSubjectList
}

def getSubjectIdBySubjectName(subjectName : String) : SubjectMaster = {
  userDAO.getSubjectIdBySubjectName(subjectName)
}

def saveStaffSubjectMap(staffSubjectMap : StaffSubjectMap) : Future[StaffSubjectMap] = Future{
  userDAO.saveStaffSubjectMap(staffSubjectMap)
}

def getEventMasterById(evId : Long) : EventsMaster = {
  userDAO.getEventMasterById(evId)
}

def getEventDetailByEventId(evId : Long) : EventsUser = {
  userDAO.getEventDetailByEventId(evId)
}

def getExamTimeTableById(ettId : Long) : ExamTimeTable = {
  userDAO.getExamTimeTableById(ettId)
}

def getExamTimeTableByExamId(examId : Long) : ExamTimeTable = {
  userDAO.getExamTimeTableByExamId(examId)
}

def getExamTimeTableByClassId(classId : Long) : List[ExamCompleteInfo] = {
  userDAO.getExamTimeTableByClassId(classId)
}

def getClassTimeTableByClassId(classId : Long) : List[ClassTimeTable] = {
  userDAO.getClassTimeTableByClassId(classId)
}

def saveMarks(marks : Marks) : Marks = {
  userDAO.saveMarks(marks)
}

def getMarksDetailBySubjectId(subjectId : Long) : List[MarksUser] = {
  userDAO.getMarksDetailBySubjectId(subjectId)
}

def getMarksListByclassId(classId : Long) : List[MarksUser] = {
  userDAO.getMarksListByclassId(classId)
}

def getStudentDetailsForMarksByStdAdmNum(stdAdmNum : String) : StudentMarks = {
   userDAO.getStudentDetailsForMarksByStdAdmNum(stdAdmNum)
}
  
  def getMarksListByStdAdmNum(stdAdmNum : String) : List[MarksStudent] = {
    userDAO.getMarksListByStdAdmNum(stdAdmNum)
  }
  
  def saveResult(result : FinalResult) : FinalResult = {
    userDAO.saveResult(result)
  }
  
  def getStudentResultByUserId(userId : Long) : FinalResult = {
    userDAO.getStudentResultByUserId(userId)
  }
   def uploadFile(request: Request[MultipartFormData[TemporaryFile]]): String = {
    println("enterd into userserveimpl")
    userDAO.uploadFile(request)
  }
  def saveStaffClassMap(staffClassMap : StaffClassMap) : StaffClassMap = {
    userDAO.saveStaffClassMap(staffClassMap)
  }
  
  def getMappingStaffClassSubjectByClassIdAndUserId(classId : Long,userId : Long) : MappingStaffClassSubject = {
    userDAO.getMappingStaffClassSubjectByClassIdAndUserId(classId,userId)
  }
  
  def getSubjectClassStaffMapByClassId(classId : Long) : List[SubjectClassStaffMap] = {
    userDAO.getSubjectClassStaffMapByClassId(classId)
  }
  
  def getStudentCount : Long = {
   userDAO.getStudentCount
  }

  def getStaffCount : Long = {
    userDAO.getStaffCount
  }
  
  def getClassCount : Long = {
    userDAO.getClassCount
  }
  
  def getSubjectCount : Long = {
    userDAO.getSubjectCount
  }
  
  def getExamCount : Long = {
    userDAO.getExamCount
  }
  
  def getLibrarianCount : Long = {
    userDAO.getLibrarianCount
  }
  
  def getVehicleCount : Long = {
    userDAO.getVehicleCount
  }
  
  def getHolidayCount : Long = {
    userDAO.getHolidayCount
  }
  
  def getEventCount : Long = {
    userDAO.getEventCount
  }
  
  
  def getClassListByStaffUserId(userId : Long) : List[ClassListForStaff] = {
    userDAO.getClassListByStaffUserId(userId)
  }
  
  def getStaffListByClassId(classId : Long) : List[StaffDetailsForClass] = {
    userDAO.getStaffListByClassId(classId)
  }
  
  def getVehicleTypeListByCampusId(campusId : Long) : List[VehicleType] = {
    userDAO.getVehicleTypeListByCampusId(campusId)
  }
  
  def getVehicleIdByStaffUserId(userId : Long) : StaffDetail = {
    userDAO.getVehicleIdByStaffUserId(userId)
  }
  
  def checkForSubjectAndStaffUserIdWithClass(classId : Long,subjectId : Long,userId : Long) : Option[MappingStaffClassSubject] = {
    userDAO.checkForSubjectAndStaffUserIdWithClass(classId,subjectId,userId)
  }
  
  def getSubjectIdByStaffUserId(userId : Long) : StaffSubjectMap = {
    userDAO.getSubjectIdByStaffUserId(userId)
  }
  
   def SendRegistrationMail(email: String): Future[Unit] = Future {
    val ctx = s"sending forgot password email, email [$email]"
    val user = userDAO.byEmail(email) match {
      case Some(u) => u
    }
    val FROM = current.configuration.getString("email.from").get // Replace with your "From" address. This address must be verified.
    val TO = email 
    
    val BODY = "WELCOME-TO-MINDS-ElS"
    val SUBJECT = "Registration Successful"
    
    /*println("email notifier")
    val mail=use[MailerPlugin].email
    println(" MAIL : "+mail)
    mail.setSubject(SUBJECT)
    mail.addRecipient(TO)
    mail.addFrom(FROM)
    mail.send(BODY)
    println("email notifier end")*/

val destination = new Destination().withToAddresses(TO)
    val subject = new Content().withData(SUBJECT)
    val textBody = new Content().withData(BODY)
    val body = new Body().withText(textBody)
 
    val message = new Message().withSubject(subject).withBody(body)
    val request = new SendEmailRequest().withSource(FROM).withDestination(destination)
      .withMessage(message)
    try {
      println("Attempting to send an email through Amazon SES by using the AWS SDK for scala...")
      var credentials: AWSCredentials = null
      credentials = new ProfileCredentialsProvider("default").getCredentials
      val client = new AmazonSimpleEmailServiceClient(credentials)
     /* val REGION = Region.getRegion(Regions.US_EAST_1)
      client.setRegion(REGION)*/
      client.sendEmail(request)
      println("Email sent!")
    } catch {
      case ex: Exception => {
        println("The email was not sent.")
        println("Error message: " + ex.getMessage)
      }
    }
  
   
    
   
    println("========================================")
    println(" From Email : "+FROM)
    println(" To Email : "+TO)
    
    println("========================================")
    //client.sendEmail(request)
  }
   
   
   
   def getAssignmentByStaffUserId(userId : Long) : List[AssignmentUser] = {
       
        println("UserServiceImpl.Assignment User Retrived getAssignmentByStaffUserId")
        userDAO.getAssignmentByStaffUserId(userId)
     
   }
   
   /*
    * def retrieve(loginInfo: LoginInfo): Future[Option[User]] = Future {
    println("UserServiceImpl.retrieve started")
    loginInfo.providerID match {
      case "credentials" =>
        println("UserServiceImpl.retrieve called byUserName")
        userDAO.byUserName(loginInfo.providerKey).map(User(_))
      case _ =>
        //TODO: logging unsupported provider
        //TODO: either return failed future with reason
        None
    }
    
  }
    */
   
   def campusUpdate(campus : Campus ,cmId : Long) : Unit = {
     
        println("UserServiceImpl.retrieve called byUserName")
        userDAO.campusUpdate(campus,cmId)
      
    // userDAO.campusUpdate(campus,cmId)
   }
   
   def organizationUpdate(organization : Organization,organizationId : Long) : Unit = {
     userDAO.organizationUpdate(organization,organizationId)
   }
   
   def getStudentDetailForGuardianByStdAdminNum(stdadmissionno : String) : Option[StudentDetailForGuardian] = {
     userDAO.getStudentDetailForGuardianByStdAdminNum(stdadmissionno)
   }
   
   def getCountForBooksAvailableByBookId(bookId : Int) : Book = {
     userDAO.getCountForBooksAvailableByBookId(bookId)
   }
   
   def getListCountForBookAndBookIssueBook(id : Int) : Long = {
     userDAO.getListCountForBookAndBookIssueBook(id)
   }
   
   def getCountForBooksTakenByStudentUserId(userId : Long) : Long = {
     userDAO.getCountForBooksTakenByStudentUserId(userId)
   }
   
   def getCheckForSameBookAssignToSameStudentUserByBookIdAndByUserId(bookid : Int,user_id : Long) : Long = {
     userDAO.getCheckForSameBookAssignToSameStudentUserByBookIdAndByUserId(bookid,user_id)
   }
   
   def updateBooksRecordByBookId(id : Long,bookCount : Long) : Unit = {
     userDAO.updateBooksRecordByBookId(id,bookCount)
   }
   
    def checkForCampusName(campusName : String) : Campus = {
      userDAO.checkForCampusName(campusName)
    }
    
    def checkForCampusId(campusId : Long) : Campus = {
      userDAO.checkForCampusId(campusId)
    }
    
    def checkForAssignmentId(assignmentId : Int) : Assignment = {
      userDAO.checkForAssignmentId(assignmentId)
    }
   
   def assignmentUpdate(assignment : Assignment,assignmentId : Int) : Unit = {
     userDAO.assignmentUpdate(assignment,assignmentId)
   }
   
   def checkForHolidayId(holidayId : Int) : Holiday = {
     userDAO.checkForHolidayId(holidayId)
   }
   
   def holidayUpdate(holiday : Holiday,holidayId : Int) : Unit = {
     userDAO.holidayUpdate(holiday,holidayId)
   }
   
   def checkForSchoolId(schoolLogoId : Int) : School = {
     userDAO.checkForSchoolId(schoolLogoId)
   }
   
   def schoolUpdate(school : School,schoolLogoId : Int) : Unit = {
     userDAO.schoolUpdate(school,schoolLogoId)
   }
   
   def checkForNewsId(newsId : Int) : SchoolNews = {
     userDAO.checkForNewsId(newsId)
   }
   
   def newsUpdate(schoolNews : SchoolNews,newsId : Int) : Unit = {
     userDAO.newsUpdate(schoolNews,newsId)
   }
   
   def checkForeventId(eventId : Int) : Events = {
     userDAO.checkForeventId(eventId)
   }
   
   def eventUpdate(event : Events,eventId : Int) : Unit = {
     userDAO.eventUpdate(event,eventId)
   }
   
   def checkForMarksId(marksId : Int) : Marks = {
     userDAO.checkForMarksId(marksId)
   }
   
   def marksUpdate(marks : Marks,marksId : Int) : Unit = {
     userDAO.marksUpdate(marks,marksId)
   }
   
   def checkForMedicalId(medicalId : Int) : Medical = {
     userDAO.checkForMedicalId(medicalId)
   }
   
   def medicalUpdate(medical : Medical,medicalId : Int) : Unit = {
     userDAO.medicalUpdate(medical,medicalId) 
   }
   
   def checkForAuthorId(authorId : Int) : Author = {
     userDAO.checkForAuthorId(authorId)
   }
  
   def checkForBookId(bookId : Int) : Book = {
     userDAO.checkForBookId(bookId)
   }
   
   def authortUpdate(authorDetail : Author,authorId : Int) : Unit = {
     userDAO.authortUpdate(authorDetail,authorId)
   }
  
   def bookUpdate(bookDetail : Book,bookId : Int) : Unit = {
     userDAO.bookUpdate(bookDetail,bookId)
   }
   
   def updateBookAuthorDetails(bookId : Int,authorId : Int) : Unit = {
     userDAO.updateBookAuthorDetails(bookId,authorId)
   }
   
   def updateBookCategories(bookId : Int,bookCategoriesId : Int) : Unit = {
     userDAO.updateBookCategories(bookId,bookCategoriesId)
   }
   
   def checkForBookIssueId(bookIssueId : Int) : BookIssue = {
     userDAO.checkForBookIssueId(bookIssueId)
   }
   
   def bookIssueUpdate(bookIssue : BookIssue,bookIssueId : Int) : Unit = {
     userDAO.bookIssueUpdate(bookIssue,bookIssueId)
   }
   
   def checkForUserId(userId : Long) : UserDTO = {
     userDAO.checkForUserId(userId)
   }
   
   def checkForUserLoginId(userLoginId : Long) : UserLogin = {
     userDAO.checkForUserLoginId(userLoginId)
   }
   
   def checkForUserContextId(userContextId : Long) : UserContext = {
     userDAO.checkForUserContextId(userContextId)
   }
   
   def checkForLibrarianId(librarianId : Long) : Librarian = {
     userDAO.checkForLibrarianId(librarianId)
   }
   
   def userUpdate(user : User,userId : Long) : Unit = {
     userDAO.userUpdate(user,userId)
   }
   
   def userLoginUpdate(userLogin : UserLogin,userLoginId : Long) : Unit = {
     userDAO.userLoginUpdate(userLogin,userLoginId)
   }
   
   def updateUserContext(userContext : UserContext,userContextId : Long) : Unit = {
     userDAO.updateUserContext(userContext,userContextId)
   }
   
   def updateLibrarian(librarian : Librarian,librarianId : Long) : Unit = {
     userDAO.updateLibrarian(librarian,librarianId)
   }
   
   def getUserLoginIdByUserId(userId : Long) : UserLogin = {
     userDAO.getUserLoginIdByUserId(userId)
   }
  
    def getUserContextIdByUserIdANDContextId(userId : Long, contextId : Long) : UserContext = {
      userDAO.getUserContextIdByUserIdANDContextId(userId,contextId)
    }
  
    def getDriverIdByUserId(userId : Long) : DriverInfo = {
      userDAO.getDriverIdByUserId(userId)
    }
    
    def updateDriver(driverDetails : DriverInfo,driverId : Long) : Unit = {
      userDAO.updateDriver(driverDetails,driverId)
    }
    
    def getStaffDetailByUserId(userId : Long) : Staff = {
      userDAO.getStaffDetailByUserId(userId)
    }
    
    def getStaffSubjectMapByUserId(userId : Long) : StaffSubjectMap = {
      userDAO.getStaffSubjectMapByUserId(userId)
    }
    
    def updateStaff(staffDetails : Staff,staffId : Long) : Unit = {
      userDAO.updateStaff(staffDetails,staffId)
    }
    
    def updateStaffSubjectMap(staffSubjectMap : StaffSubjectMap,stfSubMapId : Long) : Unit = {
      userDAO.updateStaffSubjectMap(staffSubjectMap,stfSubMapId)
    }
    
    def getGuardainDetailByUserId(userId : Long) : GuardianDetail = {
      userDAO.getGuardainDetailByUserId(userId)
    }
    
    def updateGuardianDetails(guardianDetails : GuardianDetail,guardainDetailId : Long) : Unit = {
      userDAO.updateGuardianDetails(guardianDetails,guardainDetailId)
    }
    
    def getStudentDetailByUserId(studentUserId : Long) : StudentDetail = {
      userDAO.getStudentDetailByUserId(studentUserId)
    }
    
    def getStudentClassMapDetailByUserId(userId : Long) : StudentClassMapping = {
      userDAO.getStudentClassMapDetailByUserId(userId)
    }
    
    def getUserTermDetailByUserId(userId : Long) : UserTerm = {
      userDAO.getUserTermDetailByUserId(userId)
    }
    
    def updateStudentDetails(studentDetail : StudentDetail,studentId : Long) : Unit = {
      userDAO.updateStudentDetails(studentDetail,studentId)
    }
    
    def updateStudentClassMap(studentClassMap : StudentClassMapping,studentClassMapId : Long) : Unit = {
      userDAO.updateStudentClassMap(studentClassMap,studentClassMapId)
    }
    
    def updateUserTermDetails(userTermDetails : UserTerm,userTermId : Long) : Unit = {
      userDAO.updateUserTermDetails(userTermDetails,userTermId)
    }
    
    def getVehicleDetailByVehicleId(vehicleId : Long) : VehicleDetail = {
      userDAO.getVehicleDetailByVehicleId(vehicleId)
    }
    
    def getRouteDetailByVehicleId(vehicleId : Long) : RouteDetail = {
      userDAO.getRouteDetailByVehicleId(vehicleId)
    }
    
    def getStopDetailByRouteId(routeId : Long) : List[StopDetail] = {
      userDAO.getStopDetailByRouteId(routeId)
    }
    
    def vehicleDetailsUpdate(vehicleDetail : VehicleDetail,vehicleId : Long) : Unit = {
      userDAO.vehicleDetailsUpdate(vehicleDetail,vehicleId)
    }
    
    def updateRoute(route : RouteDetail,routeDetailId : Long) : Unit = {
      userDAO.updateRoute(route,routeDetailId)
    }
    
    def updateStopDetail(stop : StopDetail,stopDetailId : Long) : Unit = {
      userDAO.updateStopDetail(stop,stopDetailId)
    }
}
