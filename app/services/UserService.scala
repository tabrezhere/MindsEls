package services


import com.mohiva.play.silhouette.core.providers.CommonSocialProfile
import com.mohiva.play.silhouette.core.services.AuthInfo
import com.mohiva.play.silhouette.core.services.IdentityService
import dtos.UserDTO
import models.commons.Context
import models.users.GuardianUser
import models.users.StaffUser
import models.users.StudentUser
import models.users.User
import models.users.UserContext
import models.users.UserLogin
import security.models.GuardianDetail
import security.models.StaffDetail
import security.models.StudentDetail
import models.users.StudentUser
import models.users.StaffUser
import models.users.GuardianUser
import models.users.Class
import models.users.Student_Guardian_Mapping
import models.users.TermType
import models.users.Term
import models.users.StudentClassMapping
import models.users.UserTerm
import models.users.Course
import models.users.CourseStaff
import models.users.CourseStaffMapping
import models.users.AttendanceList
import models.users.VehicleDetail
import com.mohiva.play.silhouette.core.LoginInfo
import security.models.DriverDetail
import models.users.VehicleDetail
import models.users.RouteDetail
import models.users.StopDetail
import security.models.CreateVehicleDetail
import models.users.CreateVehicleDetailUser
import models.users.Librarian
import models.users.LibrarianUser
import scala.concurrent.Future
import models.users.Author
import models.users.Book
import models.users.BookAuthor
import models.users.BookCategories
import models.users.Medical
import models.commons.Campus
import models.users.DriverUser
import models.users.CreateBookUser
import models.users.BookIssue
import models.users.Organization
import models.users.Assignment
import models.users.AssignmentUser
import models.users.School
import models.users.Holiday
import models.users.VehicleType
import models.users.BokCategories
import models.users.Events
import models.users.AttendanceUser
import models.users.AttendanceCommon
import java.util.Date
import models.users.AttendanceDOIAndUpdatedOn
import models.users.StdClassTerm
import models.users.SchoolNews
import models.users.Exam
import models.users.ExamClassMap
import models.users.ExamInfo
import models.users.SubjectMaster
import models.users.ExamTimeTable
import models.users.EventsMaster
import models.users.EventsUser
import models.users.SubjectClassMap
import models.users.ClassTimeTable
import models.users.ExamCompleteInfo
import models.users.ClassWithSubjectClassMap
import models.users.Marks
import models.users.MarksUser
import models.users.StudentUserMarks
import models.users.MarksStudent
import models.users.StudentMarks
import models.users.FinalResult
import java.io.File
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData
import play.api.mvc.Request
import models.users.CampusAdminUser
import models.users.StaffSubjectMap
import models.users.StaffClassMap
import models.users.SubjectClassStaffMap
import models.users.MappingStaffClassSubject
import models.users.ClassListForStaff
import models.users.StaffDetailsForClass
import models.users.Staff
import models.users.StudentDetailForGuardian
import models.users.DriverInfo
import models.users.Guardian

/*case class UserService*/

/**
 * Handles actions to users.
 */

trait UserService extends IdentityService[User] {

  /**
   * Saves a user.
   *
   * @param user The user to save.
   * @return The saved user.
   */
  def save(user: User): Future[User]

  def createVehicleDetails(vdetails : VehicleDetail) : VehicleDetail
  
  def createRouteDetails(routeDetails : RouteDetail) : RouteDetail
  
  def createStopDetail(stopDetail : StopDetail) : StopDetail
  
  def getDriverByDLno(DLno : String) : DriverDetail
  /**
   * Saves the social profile for a user.
   *
   * If a user exists for this profile then update the user, otherwise create a new user with the given profile.
   *
   * @param profile The social profile to save.
   * @return The user for whom the profile was saved.
   */
  def save[A <: AuthInfo](profile: CommonSocialProfile): Future[User]

  def getCampusDetailsByCampusId(id : Long) : Campus
  
  def getOrganizationDetailByOrgId(id : Long) : Organization
  /**
   * Link a social social profile on a user.
   *
   *
   * @param profile The social profile to save.
   * @return The user for whom the profile was saved.
   */
  def link[A <: AuthInfo](user: User, profile: CommonSocialProfile): Future[User]
  
  
  def saveUserLogin(userLogin : UserLogin): Future[UserLogin]
  
  def saveUserContext(userContext : UserContext): Future[UserContext]
  
  def saveStaffDetails(staffDetails: StaffDetail) : Future[StaffDetail]
  
   def saveGuardianDetails(guardianDetails: GuardianDetail) : Future[GuardianDetail]
  
  def saveStudentDetails(studentDetails : StudentDetail) : Future[StudentDetail]
  
  //def getUserLoginByUserId(user : User) : Future[UserLogin]
  //def getUserContextByUSerId(user :User) : Future[UserContext]
 // def getStaffDetailsByUserContextId(userContext : UserContext) : Future[StaffDetail]
  
  //getUserById
  def getUserById(userId : Long) : Future[UserDTO]
  
  //getUserLoginByEmail
   def getUserLoginByEmail(email : String) : Future[UserLogin]
  
  
  //getUserContextById
  def getUserContextById(id : Long) : Future[UserContext]
  
  //getContextById
   def getContextById(id : Long) : Future[Context]
  
  def getContextByUserId(id : Long) :UserContext  
  //getStaffDetailById
  def getStaffDetailById(user_contextid : Long) : Future[StaffDetail]
  
  // getStudentDetailsById(id)
  def getStudentDetailsById(id : Long) : Future[StudentDetail]
  
  
  //getGuardianDetails
  def getGuardianDetailsById(id : Long) : Future[GuardianDetail]
  
  
  //updateStaffDetails
  /*def updateStaffDetails(id : Long) : Future[StaffDetail]*/
  
  //updateStudentDetails
  def updateStudentDetails(id : Long) : Future[StudentDetail]
  
  //updateGuardianDetails
  /*def updateGuardianDetails(id : Long) : Future[GuardianDetail]*/
  
  def deleteUserDetailsById(id: Long) : Future[StudentDetail]
  
  def getFromDBStudentUserById(id : Long) : StudentUser
  
  def getFromDBStaffUserById(id : Long) : StaffUser
  
  def getFromDBGuardianUserById(id : Long) : GuardianUser
  
  def getFromDBCampusAdminUserById(id : Long) : CampusAdminUser
  
  def getFromDBLibrarianUserById(id : Long) : LibrarianUser
  
  def getFromDBDriverUserById(id : Long) : DriverUser 
  
  def getStudentUserById(id : Long) : Future[StudentUser]
  
  def getStudentUserByFirstname(Firstname : String) : Future[StudentUser]
  
  //def getStudentUserByFatherName(ffname : String) : Future[StudentUser]
  
  def getstdFatherName(fathername : String) : Future[Student_Guardian_Mapping]
  
  def getStaffUserById(id : Long) : Future[StaffUser]
  
  def getGuardianUserById(id : Long) : GuardianUser
  
  def getAllGuardianListByCampusId(campusId : Long) : List[GuardianUser]
  
  def getStudentUserListByCampusId(campusId : Long) : Future[List[StudentUser]]
  
  def getStaffUserListByCampusId(campusId : Long) : Future[List[StaffUser]]
  
   //getAllClassesByCompusId(campusId)
  def getAllClassesByCampusId(campusId : Long) : List[Class]
  
  //myArray
  def getStdDetailByStdAdmissionNumber(number : String) : Option[StudentDetail]
  
  def createStuGuarMapping(student_Guardian_MappingDetails : Student_Guardian_Mapping) : Student_Guardian_Mapping
  
  def getTermType() : Future[List[TermType]]
  
  def getClassById(id : Long) : Class
  
  def insertStudentClassMap(studentClassMap : StudentClassMapping) : Future[StudentClassMapping]
  
  def getTermDetails(termTypeId : Long) : Term
  
  def saveUserTermDetails(userTermDetails : UserTerm) : Future[UserTerm]
  
 //getStudentListByClassId
  def getStudentListByClassId(classId : Long) : Future[List[StudentUser]]
  
  def createStudentAttendence(attendance : AttendanceList) : AttendanceList
  
  def getStudentAttendenceListByClassId(classId : Long) : List[AttendanceCommon]
   
  def getCourseById(id : Long) : Course
  
  def saveCourseStaff(courseStaffDetails : CourseStaffMapping) : Future[CourseStaffMapping]
  
  def getVehicleListByCampusId(campusId : Long) :  Future[List[CreateVehicleDetailUser]]
  
  def getDriverListByCampusId(campusId : Long) :  Future[List[DriverUser]]
  
  def getVehicleListByCampusIdDriverId(campusId : Long,dId : Long) :  Future[List[VehicleDetail]]
  
  def getPasswordRestKey(email : String) : Future[String]
  
  def getLoginInfoByRestKey(key : String) : Future[LoginInfo]
  
  def sendPasswordResetInstructions(key : String,email: String): Future[Unit]
  
  def saveRestPassword(userId : Long,key : String) : Future[Unit]
  
  def changePassword(userId : Long,newpassword : String) : Future[Unit]
  
  def getStudentClassMapListByClassId(classId : Long) : List[StudentClassMapping]
  
  def saveDriverDetails(driverDetails : DriverDetail) : Future[DriverDetail]
  
 def getVehicleAndRoutesByVhId(vid : Option[Long]) :  CreateVehicleDetailUser
 
 def getStopDetailsByRouteId(routeId : Int) : List[StopDetail]
  
 def getStdAdmNumberList(userId : Long) : List[Student_Guardian_Mapping] 
  
 def saveLibrarian(librarian : Librarian) : Future[Librarian]
  
 def getLibrariansListByCampusId(campusId : Long) : Future[List[LibrarianUser]]
  
  def createAuthor(authorDetail : Author) : Author
  
  def createbookDetail(bookDetail : Book) : Book
  
  def createbookAuthorDetails(bid : Int,aid : Int) : Unit
  
  def getBookId(id : Int) : BookCategories
  
  def getBookListByCampusId(campusId : Long) : Future[List[CreateBookUser]]
  
  def createbookCategories(bid : Int,bcid : Int) : Unit
  
  def createMedical(medical : Medical) : Medical
  
  def createEvent(event : Events) : Events
  
  def createCampus(campus : Campus) : Campus
  
  def getMedicalDetailByUserId(userId : Long) : Future[Medical]
  
  def getMedicalDetailListByCampusId(campusId : Long) : Future[List[Medical]]
  
  def createBookIssue(bookIssue : BookIssue) : Unit
  
  def getStudentUserByStdAdmissionNo(stdAdmissionNumbers : String) : StudentUser
  
  def createAssignment(assignment : Assignment) : Assignment
  
  def getAssignmentByClassId(cid : Int) : List[AssignmentUser]
  
// def getDriverDetailByUserId(user_id : Long) : DriverDetail
  
//  def getCompleteVehicleDetail(createVehicleDetail : CreateVehicleDetail) : CreateVehicleDetail

  def createOrganization(organization:Organization):Organization

  def createSchool(school:School):School

  def createHoliday(holiday:Holiday):Holiday
  
  def getVehicleTypeById(id : Int) : VehicleType
  
   def getHolidaysListByCampusId(campusId:Long):Future[List[Holiday]]
   
  def getSchoolListByCampusId(campusId:Int):Future[List[School]]
  
  def getbookCategoriesBybookCategorieId(bcid : Int) : BokCategories
  
  def getCampusIdByUserIdFromUserContext(userId : Long) : UserContext
  
  def getListOfStudentByCampusIdWhoHasTakenBooks(campusId : Long) : List[StudentUser]
  
  def updateStudentWhoHasReturnBook(bookIssueReturn : BookIssue) : Unit
  
  def getStudentWhoHasReturnBookByStdUserId(stdUserId : Long) : BookIssue
  
  def getStdUserByStdAdmissionNumber(studentAdmNum : String) : StudentUser
  
  def getGuardianUserByStudentAdmissionNumber(stdadmissionno : String) : List[GuardianUser]
  
  def getStudentMedicalDetailsByStudentUserId(user_id : Long) : Medical
  
  def getStudentVehicleDetailsById(vdId : Option[Long]) : CreateVehicleDetailUser
  
  def getStudentEventDetailsByStudentUserId(studId : Long) : Events
  
  def getEventListBycmapusId(campusId : Long) : List[Events]
  
  def getStdDetailByStdAdmissionNumberAndCampusId(Studentadminno : String,campusId : Long) : Option[StudentUser]
  
  def getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum : String,monthNum : Int,status : Int) : List[AttendanceList]
  
  def getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum : String,fromDate : Date,toDate : Date,status : Int) : List[AttendanceList]
  
  def getAttendanceByStdAdmNo(stdAdmNum : String) : List[AttendanceList]
  
  def getStudentPeriviousDetailByStdAdmNum(stdAdmNum : String) : List[StdClassTerm]
  
  def insertSchoolNews(schoolNews : SchoolNews) : SchoolNews
  
   def getSchoolNewsListBySchoolId(schoolId : Int) : List[SchoolNews]
  
  def getSchoolNewsListByCampusId(campusId : Long) : List[SchoolNews]
  
  def insertExam(exam : Exam) : Exam
  
  def getExamDetailByExamId(examId : Long) : Exam
  
  def insertExamClassMap(examClassMap : ExamClassMap) : ExamClassMap
  
  def insertSubjectClassMap(subjectClassMap:SubjectClassMap):SubjectClassMap
  
  def getExamDetailsByExamId(examId : Long) : ExamInfo
  
  def getSubjectListByClassId(classId : Long) : List[SubjectMaster]
  
  def createExamTimeTable(examTimeTable : ExamTimeTable) : ExamTimeTable
  
  def createClassTimeTable(classTimeTable : ClassTimeTable) : ClassTimeTable
  
  def getEventMasterById(evId : Long) : EventsMaster
  
  def getEventDetailByEventId(evId : Long) : EventsUser
  
  def getSubjectsById(id:Long) : SubjectMaster
  
  def getAllSubjectList : List[SubjectMaster]
  
  def getSubjectIdBySubjectName(subjectName : String) : SubjectMaster
  
  def saveStaffSubjectMap(staffSubjectMap : StaffSubjectMap) : Future[StaffSubjectMap]
  
  def getExamTimeTableById(ettId : Long) : ExamTimeTable
  
  def getExamTimeTableByExamId(examId : Long) : ExamTimeTable
  
  def getExamTimeTableByClassId(classId : Long) : List[ExamCompleteInfo]
  
  def getClassTimeTableByClassId(classId : Long) : List[ClassTimeTable]
  
  def saveMarks(marks : Marks) : Marks
  
  def getMarksDetailBySubjectId(subjectId : Long) : List[MarksUser]
  
  def getMarksListByclassId(classId : Long) : List[MarksUser]
  
  def getStudentDetailsForMarksByStdAdmNum(stdAdmNum : String) : StudentMarks
  
  def getMarksListByStdAdmNum(stdAdmNum : String) : List[MarksStudent]
  
  def saveResult(result : FinalResult) : FinalResult
  
  def getStudentResultByUserId(userId : Long) : FinalResult
  
  def saveStaffClassMap(staffClassMap : StaffClassMap) : StaffClassMap
  
  def getMappingStaffClassSubjectByClassIdAndUserId(classId : Long,userId : Long) : MappingStaffClassSubject
  
  def getSubjectClassStaffMapByClassId(classId : Long) : List[SubjectClassStaffMap]
  
  def getStudentCount : Long
  
  def getStaffCount : Long
  
  def getClassCount : Long
  
  def getSubjectCount : Long
  
  def getExamCount : Long
  
  def getLibrarianCount : Long
  
  def getVehicleCount : Long
  
  def getHolidayCount : Long
  
  def getEventCount : Long
  
  def getClassListByStaffUserId(userId : Long) : List[ClassListForStaff]
  
  def getStaffListByClassId(classId : Long) : List[StaffDetailsForClass]
  
  def getVehicleTypeListByCampusId(campusId : Long) : List[VehicleType]
  
  def uploadFile(request: Request[MultipartFormData[TemporaryFile]]): String
  
  def getVehicleIdByStaffUserId(userId : Long) : StaffDetail
  
  def checkForSubjectAndStaffUserIdWithClass(classId : Long,subjectId : Long,userId : Long) : Option[MappingStaffClassSubject]
  
  def getSubjectIdByStaffUserId(userId : Long) : StaffSubjectMap
  
  def SendRegistrationMail(email:String):Future[Unit]
  
  def getAssignmentByStaffUserId(userId : Long) : List[AssignmentUser]
  
  def campusUpdate(campus : Campus ,cmId : Long) : Unit
  
  def organizationUpdate(organization : Organization,organizationId : Long) : Unit
  
  def getStudentDetailForGuardianByStdAdminNum(stdadmissionno : String) : Option[StudentDetailForGuardian]
  
  def getCountForBooksAvailableByBookId(bookId : Int) : Book
  
  def getListCountForBookAndBookIssueBook(id : Int) : Long
  
  def getCountForBooksTakenByStudentUserId(userId : Long) : Long
  
  def getCheckForSameBookAssignToSameStudentUserByBookIdAndByUserId(bookid : Int,user_id : Long) : Long
  
  def updateBooksRecordByBookId(id : Long,bookCount : Long) : Unit
  
   def checkForCampusName(campusName : String) : Campus
   
   def checkForCampusId(campusId : Long) : Campus
   
   def checkForAssignmentId(assignmentId : Int) : Assignment
   
   def assignmentUpdate(assignment : Assignment,assignmentId : Int) : Unit
   
   def checkForHolidayId(holidayId : Int) : Holiday
   
   def holidayUpdate(holiday : Holiday,holidayId : Int) : Unit
   
   def checkForSchoolId(schoolLogoId : Int) : School
   
   def schoolUpdate(school : School,schoolLogoId : Int) : Unit
   
   def checkForNewsId(newsId : Int) : SchoolNews
   
   def newsUpdate(schoolNews : SchoolNews,newsId : Int) : Unit
   
   def checkForeventId(eventId : Int) : Events
   
   def eventUpdate(event : Events,eventId : Int) : Unit
   
   def checkForMarksId(marksId : Int) : Marks
   
   def marksUpdate(marks : Marks,marksId : Int) : Unit
   
   def checkForMedicalId(medicalId : Int) : Medical
   
   def medicalUpdate(medical : Medical,medicalId : Int) : Unit
   
   def checkForAuthorId(authorId : Int) : Author
  
   def checkForBookId(bookId : Int) : Book
   
   def authortUpdate(authorDetail : Author,authorId : Int) : Unit
  
   def bookUpdate(bookDetail : Book,bookId : Int) : Unit
   
   def updateBookAuthorDetails(bookId : Int,authorId : Int) : Unit
   
   def updateBookCategories(bookId : Int,bookCategoriesId : Int) : Unit
   
   def checkForBookIssueId(bookIssueId : Int) : BookIssue
   
   def bookIssueUpdate(bookIssue : BookIssue,bookIssueId : Int) : Unit
   
   
   def checkForUserId(userId : Long) : UserDTO
   
   def checkForUserLoginId(userLoginId : Long) : UserLogin
   
   def checkForUserContextId(userContextId : Long) : UserContext
   
   def checkForLibrarianId(librarianId : Long) : Librarian
   
   def userUpdate(user : User,userId : Long) : Unit
   
   def userLoginUpdate(userLogin : UserLogin,userLoginId : Long) : Unit
   
   def updateUserContext(userContext : UserContext,userContextId : Long) : Unit
   
   def updateLibrarian(librarian : Librarian,librarianId : Long) : Unit
   
    def getUserLoginIdByUserId(userId : Long) : UserLogin 
  
    def getUserContextIdByUserIdANDContextId(userId : Long, contextId : Long) : UserContext
  
    def getDriverIdByUserId(userId : Long) : DriverInfo
    
    def updateDriver(driverDetails : DriverInfo,driverId : Long) : Unit
    
    def getStaffDetailByUserId(userId : Long) : Staff
    
    def getStaffSubjectMapByUserId(userId : Long) : StaffSubjectMap
    
    def updateStaff(staffDetails : Staff,staffId : Long) : Unit
    
    def updateStaffSubjectMap(staffSubjectMap : StaffSubjectMap,stfSubMapId : Long) : Unit
    
    def getGuardainDetailByUserId(userId : Long) : GuardianDetail
    
    def updateGuardianDetails(guardianDetails : GuardianDetail,guardainDetailId : Long) : Unit
    
    def getStudentDetailByUserId(studentUserId : Long) : StudentDetail
    
    def getStudentClassMapDetailByUserId(userId : Long) : StudentClassMapping
    
    def getUserTermDetailByUserId(userId : Long) : UserTerm
    
    def updateStudentDetails(studentDetail : StudentDetail,studentId : Long) : Unit
    
    def updateStudentClassMap(studentClassMap : StudentClassMapping,studentClassMapId : Long) : Unit
    
    def updateUserTermDetails(userTermDetails : UserTerm,userTermId : Long) : Unit
    
    def getVehicleDetailByVehicleId(vehicleId : Long) : VehicleDetail
    
    def getRouteDetailByVehicleId(vehicleId : Long) : RouteDetail
    
    def getStopDetailByRouteId(routeId : Long) : List[StopDetail]
    
    def vehicleDetailsUpdate(vehicleDetail : VehicleDetail,vehicleId : Long) : Unit
    
    def updateRoute(route : RouteDetail,routeDetailId : Long) : Unit
    
    def updateStopDetail(stop : StopDetail,stopDetailId : Long) : Unit
  
}