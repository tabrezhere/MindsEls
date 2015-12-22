package models.daos


import play.api.Application
import dtos.UserDTO
import models.users.User
import models.users.UserLogin
import models.users.UserContext
import security.models.StaffDetail
import security.models.GuardianDetail
import models.commons.Context
import security.models.StudentDetail
import models.users.StudentUser
import models.users.StaffUser
import models.users.GuardianUser
import java.util.Date
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
import scala.concurrent.impl.Future
import security.models.DriverDetail
import models.users.VehicleDetail
import models.users.RouteDetail
import models.users.StopDetail
import security.models.CreateVehicleDetail
import dtos.VehicleDetailDTO
import models.users.CreateVehicleDetailUser
import models.users.Librarian
import models.users.LibrarianUser
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
import models.users.School
import models.users.Holiday
import models.users.Assignment
import models.users.AssignmentUser
import models.users.VehicleType
import models.users.BokCategories
import models.users.Events
import models.users.AttendanceUser
import models.users.AttendanceCommon
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
import play.api.mvc.Request
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
//import com.sun.jna.Library

trait UserDAO {
  def byId(id: Long): Option[UserDTO]
  def byUserName(username: String): Option[UserDTO]
  def getContextByUserId(id :Long) : UserContext
  
   def getStdDetailByStdAdmissionNumberAndCampusId(Studentadminno : String,campusId : Long) : Option[StudentUser]
  
 /* def byStaffName(username: String): Option[StaffDTO]*/
  
  def create(username: String, firstName: String, middleName: String, lastName: String, DOB : String,Gender : String, address1 : String, address2 : String, city : String, state :String): UserDTO
  
  //def createVehicle(Vehicle_no : String, Vehicle_code : String, No_of_Seat : Int, Maximum_capacity : Int,insurance : String,tax_remitted : String,permit : String, status : String,Vehicle_type_id : Int) : VehicleDetailDTO
  
  def getCampusDetailsByCampusId(id : Long) : Campus
  
  def getOrganizationDetailByOrgId(id : Long) : Organization
  
  def update(user: UserDTO): Unit
  def delete(userId: Long): Boolean
  
  def createUserLogin(userLogin : UserLogin) : UserLogin
  
  def createUserContext(userContext : UserContext) : UserContext
  
  def createStaffDetails(staffDetails : StaffDetail) : StaffDetail
  
  def createGuardianDetails(guardianDetails : GuardianDetail) : GuardianDetail
  
  def createStudentDetails(studentDetails : StudentDetail) : StudentDetail
   
 // def viewStaffDetails(staffDetails : StaffDetail) : StaffDetail
  
  /*def getUserLoginByUserId(userId : Long) : UserLogin
  
  def getstaffLoginByUserId(id : Long) : UserLogin
  
  def getUserContextByUSerId(id : Long) : UserContext*/
  
  //def getStaffDetailsByUserContextId(user_contextid : Long) : StaffDetail
  
  def getUserById(userId : Long) : UserDTO
  
   def getUserLoginByEmail(email : String) : UserLogin
   
   def getUserContextById(id : Long) : UserContext
   
   def getContextById(id : Long) : Context
   
   def getStaffDetailById(user_contextid : Long) : StaffDetail
   
   def getStudentDetailsById(id : Long) : StudentDetail
   
   def getGuardianDetailsById(id : Long) : GuardianDetail
   
   // Update
  /* def updateStaffDetails(id : Long) : StaffDetail*/
   
   def updateStudentDetails(id : Long) : StudentDetail 
   
   def updateSD(studentDetail : StudentDetail,id : Long) : Unit
   
   /*def updateGuardianDetails(id : Long ) : GuardianDetail
   
   def updateGD(guardian : GuardianDetail, id : Long) : GuardianDetail
   */
   def deleteUserDetailsById(id : Long) : StudentDetail
   
   def deleteUD(studentDetail : StudentDetail,id : Long) : Unit
   
   def getStudentUserByUserId(id : Long) : StudentUser
   def getStaffUserByUserId(id : Long) : StaffUser
   def getFromDBCampusAdminUserById(id : Long) : CampusAdminUser
   def getGuardianUserByUserId(id : Long) : GuardianUser
   
   def getAllGuardianListByCampusId(campusId : Long) : List[GuardianUser] 
   
   def getLibrarianUserByUserId(id : Long) : LibrarianUser
   def getDriverUserByUserId(id : Long) : DriverUser
   def getStudentUserListByCampusId(campusId : Long) : List[StudentUser]
   def getStaffUserListByCampusId(campusId : Long) : List[StaffUser]
   def getAllClassesByCampusId(campusId : Long) : List[Class]
   def getStdDetailByStdAdmissionNumber(number : String) : Option[StudentDetail]
  
   def createStuGuarMapping(student_Guardian_MappingDetails : Student_Guardian_Mapping) : Student_Guardian_Mapping
   
   def getTermType() : List[TermType]
   
   def getClassById(id : Long) : Class
   
   def insertStudentClassMap(studentClassMap : StudentClassMapping) : StudentClassMapping
   
   def getTermDetails(termTypeId : Long) : Term
   
   def saveUserTermDetails(userTermDetails : UserTerm) : UserTerm
   
   def getStudentAttendenceCommonListByClassId(classId : Long) : List[AttendanceCommon]
   
   //getStudentListByClassId
  def getStudentListByClassId(classId : Long) : List[StudentUser]
  
  def createStudentAttendence(attendance : AttendanceList) : AttendanceList
   
   def getCourseById(id : Long) : Course
   
   def saveCourseStaff(courseStaffDetails : CourseStaffMapping) : CourseStaffMapping

  /* def createAttendence(AttendenceDetails : AttendanceList) : AttendanceList*/
   
   def getStudentUserByFirstname(Firstname : String) : StudentUser
   
   def getStdAdmNumbers(fathername : String) : Student_Guardian_Mapping
   
   def getVehicleListByCampusId(campusId : Long) :  List[CreateVehicleDetailUser]
  
  def getDriverListByCampusId(campusId : Long) : List[DriverUser]
  
   def getVehicleListByCampusIdDriverId(campusId : Long,dId : Long) :  List[VehicleDetail]
   
   def byEmail(email : String) : Option[UserLogin]
  
  def getValidPasswordResetKey(userId: Long): Option[String]
  
   def savePasswordResetKey(userId: Long, hash: String): Unit
   
   def getUserByResetKey(key : String) : Option[UserLogin]
  
  def saveRestPassword(userId : Long,key : String) : Unit
  
  def changePassword(userId : Long,newpassword : String) : Unit
  
  def getStudentClassMapListByClassId(classId : Long) : List[StudentClassMapping]
  
  def createDriverDetails(driverDetails : DriverDetail) : DriverDetail
  
  def createVehicleDetails(vdetails : VehicleDetail) : VehicleDetail
  
  def createRouteDetails(routeDetails : RouteDetail) : RouteDetail
  
  def createStopDetail(stopDetail : StopDetail) : StopDetail
  
  def getDriverByDLno(DLno : String) : DriverDetail
  
  def getVehicleAndRoutesByVhId(vid : Option[Long]) : CreateVehicleDetailUser
  
  def getStopDetailsByRouteId(routeId : Int) : List[StopDetail]
  
  def getStdAdmNumberList(userId : Long) : List[Student_Guardian_Mapping]
  
  def saveLibrarian(librarian : Librarian) : Librarian
  
  def getLibrariansListByCampusId(campusId : Long) : List[LibrarianUser] 
  
  def createAuthor(authorDetail:Author):Author
  
  def createbookDetail(bookDetail:Book):Book
  
  def createbookAuthorDetails(bid : Int,aid : Int) : Unit
  
  def getBookId(id : Int) : BookCategories
  
  def getBookListByCampusId(campusId : Long) : List[CreateBookUser]
  
   def createbookCategories(bid : Int,bcid : Int) : Unit
   
   def createMedical(medical : Medical) : Medical
   
   def createEvent(event : Events) : Events
   
   def createCampus(campus : Campus) : Campus
   
    def getMedicalDetailByUserId(userId : Long) : Medical
    
    def getMedicalDetailListByCampusId(campusId : Long) : List[Medical]
  
  def createBookIssue(bookIssue : BookIssue) : Unit
  
  def getStudentUserByStdAdmissionNo(stdAdmissionNumbers : String) : StudentUser
  
  def createAssignment(assignment : Assignment) : Assignment
  
  def getAssignmentByClassId(cid : Int) : List[AssignmentUser]
  
//  def getCompleteVehicleDetail(createVehicleDetail : CreateVehicleDetail) : CreateVehicleDetail

  def createOrganization(organization : Organization) : Organization

   def createSchool(school : School) : School

   def createHoliday(holiday : Holiday) : Holiday
   
   def getVehicleTypeById(id : Int) : VehicleType
   
   def getbookCategoriesBybookCategorieId(bcid : Int) : BokCategories
   
   def getCampusIdByUserIdFromUserContext(userId : Long) : UserContext
   
   def getListOfStudentByCampusIdWhoHasTakenBooks(campusId : Long) : List[StudentUser]
  
  def updateStudentWhoHasReturnBook(bookIssueReturn : BookIssue) : Unit
  
  def getStudentWhoHasReturnBookByStdUserId(stdUserId : Long) : BookIssue
  
  def getStdUserByStdAdmissionNumber(studentAdmNum : String) : StudentUser
  
  def getGuardianUserByStudentAdmissionNumber(stdadmissionno : String) : List[GuardianUser]
  
  def getStudentPeriviousDetailByStdAdmNum(stdAdmNum : String) : List[StdClassTerm]
  
  def getStudentMedicalDetailsByStudentUserId(user_id : Long) : Medical
  
  def getStudentVehicleDetailsById(vdId : Option[Long]) : CreateVehicleDetailUser
  
  def getStudentEventDetailsByStudentUserId(studId : Long) : Events
  
  def getEventListBycmapusId(campusId : Long) : List[Events]
  
   def getHoliday(campusId:Long):List[Holiday]
   
   def getSchoolList(campusId:Int):List[School]
  
  def getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum : String,monthNum : Int,status : Int) : List[AttendanceList]
  
  def getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum : String,fromDate : Date,toDate : Date,status : Int) : List[AttendanceList]
  
  def getAttendanceByStdAdmNo(stdAdmNum : String) : List[AttendanceList]
  
  def insertSchoolNews(schoolNews : SchoolNews) : SchoolNews
  
  def getSchoolNewsListBySchoolId(schoolId : Int) : List[SchoolNews]
  
  def getSchoolNewsListByCampusId(campusId : Long) : List[SchoolNews]
  
  def insertExam(exam : Exam) : Exam
  
  def getExamDetailByExamId(examId : Long) : Exam
  
  def insertExamClassMap(examClassMap : ExamClassMap) : ExamClassMap
  
  def getExamDetailsByExamId(examId : Long) : ExamInfo
  
  def getSubjectListByClassId(classId : Long) : List[SubjectMaster]
  
  def createExamTimeTable(examTimeTable : ExamTimeTable) : ExamTimeTable
  
  def createClassTimeTable(classTimeTable : ClassTimeTable) : ClassTimeTable
  
  def getEventMasterById(evId : Long) : EventsMaster
  
  def getEventDetailByEventId(evId : Long) : EventsUser
  
   def getSubjectListById(id:Long): SubjectMaster
   
   def getAllSubjectList : List[SubjectMaster]
  
  def getSubjectIdBySubjectName(subjectName : String) : SubjectMaster
  
  def saveStaffSubjectMap(staffSubjectMap : StaffSubjectMap) : StaffSubjectMap

  def insertSubjectClassMap(subjectClassMap:SubjectClassMap) :SubjectClassMap
  
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
  
    def getVehicleIdByStaffUserId(userId : Long) : StaffDetail
    
    def checkForSubjectAndStaffUserIdWithClass(classId : Long,subjectId : Long,userId : Long) : Option[MappingStaffClassSubject]
    
    def getSubjectIdByStaffUserId(userId : Long) : StaffSubjectMap
   
   def uploadFile(request: Request[MultipartFormData[TemporaryFile]]): String 
   
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
