// @SOURCE:E:/PlayWorkspace/tabrez/test jar/Eonline_22_15_tab/Eonline_22_15_tab/conf/routes
// @HASH:f1f71601291a1f113f3ddc5cce02ae89daf20fb5
// @DATE:Tue Dec 15 17:47:28 IST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:141
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:53
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
// @LINE:38
// @LINE:37
// @LINE:36
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
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
package controllers {

// @LINE:141
class ReverseAssets {


// @LINE:141
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:60
// @LINE:59
// @LINE:58
class ReverseMiscController {


// @LINE:59
def getAllOrganization(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAllOganization")
}
                        

// @LINE:58
def getUserRolesList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/userRoles")
}
                        

// @LINE:60
def getAllCampusByOrganizationId(orgId:Int): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAllCampusByOrganizationId/" + implicitly[PathBindable[Int]].unbind("orgId", orgId))
}
                        

}
                          

// @LINE:7
class ReverseApplicationController {


// @LINE:7
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          

// @LINE:53
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
// @LINE:38
// @LINE:37
// @LINE:36
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
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseRestSignUpController {


// @LINE:15
def signUpForGuardian(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signUpForGuardian")
}
                        

// @LINE:31
def campusUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/campusUpdate")
}
                        

// @LINE:39
def medicalUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/medicalUpdate")
}
                        

// @LINE:47
def studentUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/studentUpdate")
}
                        

// @LINE:13
def signUp(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signup")
}
                        

// @LINE:27
def schoolNews(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/schoolNews")
}
                        

// @LINE:20
def createbook(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/createbook")
}
                        

// @LINE:29
def marks(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/marks")
}
                        

// @LINE:32
def organizationUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/organizationUpdate")
}
                        

// @LINE:35
def schoolUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/schoolUpdate")
}
                        

// @LINE:28
def exam(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/exam")
}
                        

// @LINE:52
def sendSMS(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/sendSMS")
}
                        

// @LINE:23
def signOut(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signout")
}
                        

// @LINE:16
def signUpForStaff(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signUpForStaff")
}
                        

// @LINE:25
def assignmentcreate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/assignmentcreate")
}
                        

// @LINE:14
def signUpForStudent(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signUpForStudent")
}
                        

// @LINE:41
def bookIssueUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/bookIssueUpdate")
}
                        

// @LINE:34
def holidayUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/holidayUpdate")
}
                        

// @LINE:38
def marksUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/marksUpdate")
}
                        

// @LINE:45
def staffUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/staffUpdate")
}
                        

// @LINE:22
def campusCreate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/campusCreate")
}
                        

// @LINE:37
def eventUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/eventUpdate")
}
                        

// @LINE:12
def signUpForCampusAdmin(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signUpForCampusAdmin")
}
                        

// @LINE:26
def eventCreate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/eventcreate")
}
                        

// @LINE:43
def driverUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/driverUpdate")
}
                        

// @LINE:18
def createVehicleCompleteDetail(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/createVehicleDetail")
}
                        

// @LINE:30
def StaffClassMapping(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/staffClassMapping")
}
                        

// @LINE:44
def campusadminUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/campusadminUpdate")
}
                        

// @LINE:53
def createResultByStdAdmNum(stdAdmNum:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/createResultByStdAdmNum/" + implicitly[PathBindable[String]].unbind("stdAdmNum", dynamicString(stdAdmNum)))
}
                        

// @LINE:40
def bookUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/bookUpdate")
}
                        

// @LINE:46
def guardianUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/guardianUpdate")
}
                        

// @LINE:51
def uploadfile(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/fileupload")
}
                        

// @LINE:33
def assignmentUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/assignmentUpdate")
}
                        

// @LINE:48
def vehicleUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/vehicleUpdate")
}
                        

// @LINE:17
def signUpForDriver(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signUpForDriver")
}
                        

// @LINE:42
def librarianUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/librarianUpdate")
}
                        

// @LINE:36
def newsUpdate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/newsUpdate")
}
                        

// @LINE:19
def signUpForLibrarian(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signUpForLibrarian")
}
                        

// @LINE:24
def bookIssue(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/bookIssue")
}
                        

// @LINE:21
def medicalCreate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/medicalCreate")
}
                        

}
                          

// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:11
class ReverseRestUserController {


// @LINE:95
def getBookListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getBookListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:90
def restPasswordKey(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/updatePassword")
}
                        

// @LINE:117
def getExamTimeTableByExamId(examId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getExamTimeTableByExamId/" + implicitly[PathBindable[Long]].unbind("examId", examId))
}
                        

// @LINE:124
def getClassListByStaffUserId(userId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getClassListByStaffUserId/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                        

// @LINE:107
def getSchoolListByCampusId(campusId:Int): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getSchoolsInformationByCampusId/" + implicitly[PathBindable[Int]].unbind("campusId", campusId))
}
                        

// @LINE:114
def getExamDetailsByExamId(examId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getExamDetailsByExamId/" + implicitly[PathBindable[Long]].unbind("examId", examId))
}
                        

// @LINE:79
def getStudentListByClassId(classId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentListByClassId/" + implicitly[PathBindable[Long]].unbind("classId", classId))
}
                        

// @LINE:72
def getStudentUserById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentUserById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:103
def getStudentVehicleDetailsByStudentAdmNum(stdadmissionno:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentVehicleDetailsByStudentAdmNum/" + implicitly[PathBindable[String]].unbind("stdadmissionno", dynamicString(stdadmissionno)))
}
                        

// @LINE:74
def getGuardianUserById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getGuardianUserById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:126
def getVehicleTypeListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getVehicleTypeListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:100
def getStudentDetailByStdAdmNum(admNum:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentDetailByStdAdmNum/" + implicitly[PathBindable[String]].unbind("admNum", dynamicString(admNum)))
}
                        

// @LINE:120
def getMarksDetailBySubjectId(subjectId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getMarksDetailBySubjectId/" + implicitly[PathBindable[Long]].unbind("subjectId", subjectId))
}
                        

// @LINE:73
def getStaffUserById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStaffUserById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:63
def getUserContextById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getUserContextById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:94
def getMedicalDetailListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getMedicalDetailListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:115
def getEventDetailByEventId(eventId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getEventDetailByEventId/" + implicitly[PathBindable[Long]].unbind("eventId", eventId))
}
                        

// @LINE:121
def getMarksListByclassId(classId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getMarksListByclassId/" + implicitly[PathBindable[Long]].unbind("classId", classId))
}
                        

// @LINE:91
def getVehicleRouteAndStopDetailsByVhId(vid:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getVehicleRouteAndStopDetailsByVhId/" + implicitly[PathBindable[Long]].unbind("vid", vid))
}
                        

// @LINE:98
def getListOfStudentByCampusIdWhoHasTakenBooks(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getListOfStudentByCampusIdWhoHasTakenBooks/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:65
def getStaffDetailById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStaffDetailsById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:61
def getUserById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getUserById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:86
def getAllSubjectList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAllSubjectList")
}
                        

// @LINE:119
def getClassTimeTableByClassId(classId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getClassTimeTableByClassId/" + implicitly[PathBindable[Long]].unbind("classId", classId))
}
                        

// @LINE:68
def getGuardianDetailsById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getGuardianDetailsById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:105
def getEventListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getEventListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:112
def getSchoolNewsListBySchoolId(schoolId:Int): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getSchoolNewsListBySchoolId/" + implicitly[PathBindable[Int]].unbind("schoolId", schoolId))
}
                        

// @LINE:82
def getDriverListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getDriverListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:70
def deleteUserDetailsById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/deleteUserDetailsById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:78
def getAllClassesByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAllClassesByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:97
def getAssignmentByClassId(cid:Int): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAssignmentByClassId/" + implicitly[PathBindable[Int]].unbind("cid", cid))
}
                        

// @LINE:85
def getSubjectIdBySubjectName(subjectName:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getSubjectIdBySubjectName/" + implicitly[PathBindable[String]].unbind("subjectName", dynamicString(subjectName)))
}
                        

// @LINE:88
def getSubjectsByClassId(classId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getSubjectsByClassId/" + implicitly[PathBindable[Long]].unbind("classId", classId))
}
                        

// @LINE:93
def getMedicalDetailByUserId(userId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getMedicalDetailByUserId/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                        

// @LINE:122
def getMarksListByStdAdmNum(stdAdmNum:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getMarksListByStdAdmNum/" + implicitly[PathBindable[String]].unbind("stdAdmNum", dynamicString(stdAdmNum)))
}
                        

// @LINE:89
def forgetpassword(email:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/forgetpassword/" + implicitly[PathBindable[String]].unbind("email", dynamicString(email)))
}
                        

// @LINE:109
def getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum:String, fromDate:String, toDate:String, status:Int): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "authgetAttendanceByStdAdmNoByFrmDateByToDateAndByStatus/" + implicitly[PathBindable[String]].unbind("stdAdmNum", dynamicString(stdAdmNum)) + "/" + implicitly[PathBindable[String]].unbind("fromDate", dynamicString(fromDate)) + "/" + implicitly[PathBindable[String]].unbind("toDate", dynamicString(toDate)) + "/" + implicitly[PathBindable[Int]].unbind("status", status))
}
                        

// @LINE:113
def getSchoolNewsListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getSchoolNewsListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:128
def getAssignmentByStaffUserId(userId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAssignmentByStaffUserId/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                        

// @LINE:101
def getGuardianUserByStudentAdmissionNumber(stdadmissionno:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getGuardianUserByStudentAdmissionNumber/" + implicitly[PathBindable[String]].unbind("stdadmissionno", dynamicString(stdadmissionno)))
}
                        

// @LINE:102
def getStudentMedicalDetailsByStudentAdmNum(stdadmissionno:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentMedicalDetailsByStudentAdmNum/" + implicitly[PathBindable[String]].unbind("stdadmissionno", dynamicString(stdadmissionno)))
}
                        

// @LINE:104
def getStudentEventDetailsByAdmissionNumber(stdadmissionno:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentEventDetailsByAdmissionNumber/" + implicitly[PathBindable[String]].unbind("stdadmissionno", dynamicString(stdadmissionno)))
}
                        

// @LINE:123
def getStaffTimeTableByClassId(classId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStaffTimeTableByClassId/" + implicitly[PathBindable[Long]].unbind("classId", classId))
}
                        

// @LINE:96
def getStudentAttendenceListByClassId(classId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentAttendenceListByClassId/" + implicitly[PathBindable[Long]].unbind("classId", classId))
}
                        

// @LINE:69
def updateStudentDetailsById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/updateStudentDetails/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:125
def getStaffListByClassId(classId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStaffListByClassId/" + implicitly[PathBindable[Long]].unbind("classId", classId))
}
                        

// @LINE:81
def getVehicleListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getVehicleListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:129
def getImage(key:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getImage/" + implicitly[PathBindable[String]].unbind("key", dynamicString(key)))
}
                        

// @LINE:67
def getStudentUserByFirstname(Firstname:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentUserByFirstname/" + implicitly[PathBindable[String]].unbind("Firstname", dynamicString(Firstname)))
}
                        

// @LINE:77
def getStaffUserListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStaffUserListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:62
def getUserLoginByEmail(email:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getUserLoginByEmail/" + implicitly[PathBindable[String]].unbind("email", dynamicString(email)))
}
                        

// @LINE:87
def getSubjectsById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getSubjectsById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:66
def getStudentDetailsById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentDetailsById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:76
def getStudentUserListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentUserListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:110
def getAttendanceByStdAdmNo(stdAdmNum:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAttendanceByStdAdmNo/" + implicitly[PathBindable[String]].unbind("stdAdmNum", dynamicString(stdAdmNum)))
}
                        

// @LINE:106
def getHolidaysByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getHolidaysByCampusID/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:116
def getExamTimeTableById(ettId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getExamTimeTableById/" + implicitly[PathBindable[Long]].unbind("ettId", ettId))
}
                        

// @LINE:127
def getVehicleDetailByStaffUserId(userId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getVehicleDetailByStaffUserId/" + implicitly[PathBindable[Long]].unbind("userId", userId))
}
                        

// @LINE:111
def getStudentPeriviousDetailByStdAdmNum(stdAdmNum:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getStudentPeriviousDetailByStdAdmNum/" + implicitly[PathBindable[String]].unbind("stdAdmNum", dynamicString(stdAdmNum)))
}
                        

// @LINE:108
def getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum:String, monthNum:Int, status:Int): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAttendanceByStdAdmNoByMonthNoAndByStatus/" + implicitly[PathBindable[String]].unbind("stdAdmNum", dynamicString(stdAdmNum)) + "/" + implicitly[PathBindable[Int]].unbind("monthNum", monthNum) + "/" + implicitly[PathBindable[Int]].unbind("status", status))
}
                        

// @LINE:11
def authenticate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "auth/signin/credentials")
}
                        

// @LINE:92
def getLibrariansListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getLibrariansListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:80
def termTypeList(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/termTypeList")
}
                        

// @LINE:75
def getAllGuardianListByCampusId(campusId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getAllGuardianListByCampusId/" + implicitly[PathBindable[Long]].unbind("campusId", campusId))
}
                        

// @LINE:64
def getContextById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getContextById/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:118
def getExamTimeTableByClassId(classId:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "auth/getExamTimeTableByClassId/" + implicitly[PathBindable[Long]].unbind("classId", classId))
}
                        

}
                          
}
                  


// @LINE:141
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:53
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
// @LINE:38
// @LINE:37
// @LINE:36
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
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:141
class ReverseAssets {


// @LINE:141
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:60
// @LINE:59
// @LINE:58
class ReverseMiscController {


// @LINE:59
def getAllOrganization : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MiscController.getAllOrganization",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAllOganization"})
      }
   """
)
                        

// @LINE:58
def getUserRolesList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MiscController.getUserRolesList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/userRoles"})
      }
   """
)
                        

// @LINE:60
def getAllCampusByOrganizationId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MiscController.getAllCampusByOrganizationId",
   """
      function(orgId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAllCampusByOrganizationId/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("orgId", orgId)})
      }
   """
)
                        

}
              

// @LINE:7
class ReverseApplicationController {


// @LINE:7
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              

// @LINE:53
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
// @LINE:38
// @LINE:37
// @LINE:36
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
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseRestSignUpController {


// @LINE:15
def signUpForGuardian : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.signUpForGuardian",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signUpForGuardian"})
      }
   """
)
                        

// @LINE:31
def campusUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.campusUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/campusUpdate"})
      }
   """
)
                        

// @LINE:39
def medicalUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.medicalUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/medicalUpdate"})
      }
   """
)
                        

// @LINE:47
def studentUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.studentUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/studentUpdate"})
      }
   """
)
                        

// @LINE:13
def signUp : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.signUp",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signup"})
      }
   """
)
                        

// @LINE:27
def schoolNews : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.schoolNews",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/schoolNews"})
      }
   """
)
                        

// @LINE:20
def createbook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.createbook",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/createbook"})
      }
   """
)
                        

// @LINE:29
def marks : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.marks",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/marks"})
      }
   """
)
                        

// @LINE:32
def organizationUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.organizationUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/organizationUpdate"})
      }
   """
)
                        

// @LINE:35
def schoolUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.schoolUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/schoolUpdate"})
      }
   """
)
                        

// @LINE:28
def exam : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.exam",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/exam"})
      }
   """
)
                        

// @LINE:52
def sendSMS : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.sendSMS",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/sendSMS"})
      }
   """
)
                        

// @LINE:23
def signOut : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.signOut",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signout"})
      }
   """
)
                        

// @LINE:16
def signUpForStaff : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.signUpForStaff",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signUpForStaff"})
      }
   """
)
                        

// @LINE:25
def assignmentcreate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.assignmentcreate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/assignmentcreate"})
      }
   """
)
                        

// @LINE:14
def signUpForStudent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.signUpForStudent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signUpForStudent"})
      }
   """
)
                        

// @LINE:41
def bookIssueUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.bookIssueUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/bookIssueUpdate"})
      }
   """
)
                        

// @LINE:34
def holidayUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.holidayUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/holidayUpdate"})
      }
   """
)
                        

// @LINE:38
def marksUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.marksUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/marksUpdate"})
      }
   """
)
                        

// @LINE:45
def staffUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.staffUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/staffUpdate"})
      }
   """
)
                        

// @LINE:22
def campusCreate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.campusCreate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/campusCreate"})
      }
   """
)
                        

// @LINE:37
def eventUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.eventUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/eventUpdate"})
      }
   """
)
                        

// @LINE:12
def signUpForCampusAdmin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.signUpForCampusAdmin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signUpForCampusAdmin"})
      }
   """
)
                        

// @LINE:26
def eventCreate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.eventCreate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/eventcreate"})
      }
   """
)
                        

// @LINE:43
def driverUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.driverUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/driverUpdate"})
      }
   """
)
                        

// @LINE:18
def createVehicleCompleteDetail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.createVehicleCompleteDetail",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/createVehicleDetail"})
      }
   """
)
                        

// @LINE:30
def StaffClassMapping : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.StaffClassMapping",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/staffClassMapping"})
      }
   """
)
                        

// @LINE:44
def campusadminUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.campusadminUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/campusadminUpdate"})
      }
   """
)
                        

// @LINE:53
def createResultByStdAdmNum : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.createResultByStdAdmNum",
   """
      function(stdAdmNum) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/createResultByStdAdmNum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdAdmNum", encodeURIComponent(stdAdmNum))})
      }
   """
)
                        

// @LINE:40
def bookUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.bookUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/bookUpdate"})
      }
   """
)
                        

// @LINE:46
def guardianUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.guardianUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/guardianUpdate"})
      }
   """
)
                        

// @LINE:51
def uploadfile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.uploadfile",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/fileupload"})
      }
   """
)
                        

// @LINE:33
def assignmentUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.assignmentUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/assignmentUpdate"})
      }
   """
)
                        

// @LINE:48
def vehicleUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.vehicleUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/vehicleUpdate"})
      }
   """
)
                        

// @LINE:17
def signUpForDriver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.signUpForDriver",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signUpForDriver"})
      }
   """
)
                        

// @LINE:42
def librarianUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.librarianUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/librarianUpdate"})
      }
   """
)
                        

// @LINE:36
def newsUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.newsUpdate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/newsUpdate"})
      }
   """
)
                        

// @LINE:19
def signUpForLibrarian : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.signUpForLibrarian",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signUpForLibrarian"})
      }
   """
)
                        

// @LINE:24
def bookIssue : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.bookIssue",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/bookIssue"})
      }
   """
)
                        

// @LINE:21
def medicalCreate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestSignUpController.medicalCreate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/medicalCreate"})
      }
   """
)
                        

}
              

// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:11
class ReverseRestUserController {


// @LINE:95
def getBookListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getBookListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getBookListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:90
def restPasswordKey : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.restPasswordKey",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/updatePassword"})
      }
   """
)
                        

// @LINE:117
def getExamTimeTableByExamId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getExamTimeTableByExamId",
   """
      function(examId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getExamTimeTableByExamId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("examId", examId)})
      }
   """
)
                        

// @LINE:124
def getClassListByStaffUserId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getClassListByStaffUserId",
   """
      function(userId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getClassListByStaffUserId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        

// @LINE:107
def getSchoolListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getSchoolListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getSchoolsInformationByCampusId/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:114
def getExamDetailsByExamId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getExamDetailsByExamId",
   """
      function(examId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getExamDetailsByExamId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("examId", examId)})
      }
   """
)
                        

// @LINE:79
def getStudentListByClassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentListByClassId",
   """
      function(classId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentListByClassId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("classId", classId)})
      }
   """
)
                        

// @LINE:72
def getStudentUserById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentUserById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentUserById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:103
def getStudentVehicleDetailsByStudentAdmNum : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentVehicleDetailsByStudentAdmNum",
   """
      function(stdadmissionno) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentVehicleDetailsByStudentAdmNum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdadmissionno", encodeURIComponent(stdadmissionno))})
      }
   """
)
                        

// @LINE:74
def getGuardianUserById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getGuardianUserById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getGuardianUserById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:126
def getVehicleTypeListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getVehicleTypeListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getVehicleTypeListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:100
def getStudentDetailByStdAdmNum : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentDetailByStdAdmNum",
   """
      function(admNum) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentDetailByStdAdmNum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("admNum", encodeURIComponent(admNum))})
      }
   """
)
                        

// @LINE:120
def getMarksDetailBySubjectId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getMarksDetailBySubjectId",
   """
      function(subjectId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getMarksDetailBySubjectId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("subjectId", subjectId)})
      }
   """
)
                        

// @LINE:73
def getStaffUserById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStaffUserById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStaffUserById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:63
def getUserContextById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getUserContextById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getUserContextById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:94
def getMedicalDetailListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getMedicalDetailListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getMedicalDetailListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:115
def getEventDetailByEventId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getEventDetailByEventId",
   """
      function(eventId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getEventDetailByEventId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("eventId", eventId)})
      }
   """
)
                        

// @LINE:121
def getMarksListByclassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getMarksListByclassId",
   """
      function(classId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getMarksListByclassId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("classId", classId)})
      }
   """
)
                        

// @LINE:91
def getVehicleRouteAndStopDetailsByVhId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getVehicleRouteAndStopDetailsByVhId",
   """
      function(vid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getVehicleRouteAndStopDetailsByVhId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("vid", vid)})
      }
   """
)
                        

// @LINE:98
def getListOfStudentByCampusIdWhoHasTakenBooks : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getListOfStudentByCampusIdWhoHasTakenBooks",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getListOfStudentByCampusIdWhoHasTakenBooks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:65
def getStaffDetailById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStaffDetailById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStaffDetailsById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:61
def getUserById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getUserById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getUserById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:86
def getAllSubjectList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getAllSubjectList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAllSubjectList"})
      }
   """
)
                        

// @LINE:119
def getClassTimeTableByClassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getClassTimeTableByClassId",
   """
      function(classId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getClassTimeTableByClassId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("classId", classId)})
      }
   """
)
                        

// @LINE:68
def getGuardianDetailsById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getGuardianDetailsById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getGuardianDetailsById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:105
def getEventListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getEventListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getEventListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:112
def getSchoolNewsListBySchoolId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getSchoolNewsListBySchoolId",
   """
      function(schoolId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getSchoolNewsListBySchoolId/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("schoolId", schoolId)})
      }
   """
)
                        

// @LINE:82
def getDriverListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getDriverListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getDriverListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:70
def deleteUserDetailsById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.deleteUserDetailsById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/deleteUserDetailsById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:78
def getAllClassesByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getAllClassesByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAllClassesByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:97
def getAssignmentByClassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getAssignmentByClassId",
   """
      function(cid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAssignmentByClassId/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("cid", cid)})
      }
   """
)
                        

// @LINE:85
def getSubjectIdBySubjectName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getSubjectIdBySubjectName",
   """
      function(subjectName) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getSubjectIdBySubjectName/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("subjectName", encodeURIComponent(subjectName))})
      }
   """
)
                        

// @LINE:88
def getSubjectsByClassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getSubjectsByClassId",
   """
      function(classId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getSubjectsByClassId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("classId", classId)})
      }
   """
)
                        

// @LINE:93
def getMedicalDetailByUserId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getMedicalDetailByUserId",
   """
      function(userId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getMedicalDetailByUserId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        

// @LINE:122
def getMarksListByStdAdmNum : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getMarksListByStdAdmNum",
   """
      function(stdAdmNum) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getMarksListByStdAdmNum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdAdmNum", encodeURIComponent(stdAdmNum))})
      }
   """
)
                        

// @LINE:89
def forgetpassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.forgetpassword",
   """
      function(email) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/forgetpassword/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("email", encodeURIComponent(email))})
      }
   """
)
                        

// @LINE:109
def getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus",
   """
      function(stdAdmNum,fromDate,toDate,status) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authgetAttendanceByStdAdmNoByFrmDateByToDateAndByStatus/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdAdmNum", encodeURIComponent(stdAdmNum)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("fromDate", encodeURIComponent(fromDate)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("toDate", encodeURIComponent(toDate)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("status", status)})
      }
   """
)
                        

// @LINE:113
def getSchoolNewsListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getSchoolNewsListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getSchoolNewsListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:128
def getAssignmentByStaffUserId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getAssignmentByStaffUserId",
   """
      function(userId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAssignmentByStaffUserId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        

// @LINE:101
def getGuardianUserByStudentAdmissionNumber : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getGuardianUserByStudentAdmissionNumber",
   """
      function(stdadmissionno) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getGuardianUserByStudentAdmissionNumber/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdadmissionno", encodeURIComponent(stdadmissionno))})
      }
   """
)
                        

// @LINE:102
def getStudentMedicalDetailsByStudentAdmNum : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentMedicalDetailsByStudentAdmNum",
   """
      function(stdadmissionno) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentMedicalDetailsByStudentAdmNum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdadmissionno", encodeURIComponent(stdadmissionno))})
      }
   """
)
                        

// @LINE:104
def getStudentEventDetailsByAdmissionNumber : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentEventDetailsByAdmissionNumber",
   """
      function(stdadmissionno) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentEventDetailsByAdmissionNumber/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdadmissionno", encodeURIComponent(stdadmissionno))})
      }
   """
)
                        

// @LINE:123
def getStaffTimeTableByClassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStaffTimeTableByClassId",
   """
      function(classId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStaffTimeTableByClassId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("classId", classId)})
      }
   """
)
                        

// @LINE:96
def getStudentAttendenceListByClassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentAttendenceListByClassId",
   """
      function(classId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentAttendenceListByClassId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("classId", classId)})
      }
   """
)
                        

// @LINE:69
def updateStudentDetailsById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.updateStudentDetailsById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/updateStudentDetails/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:125
def getStaffListByClassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStaffListByClassId",
   """
      function(classId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStaffListByClassId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("classId", classId)})
      }
   """
)
                        

// @LINE:81
def getVehicleListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getVehicleListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getVehicleListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:129
def getImage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getImage",
   """
      function(key) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getImage/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("key", encodeURIComponent(key))})
      }
   """
)
                        

// @LINE:67
def getStudentUserByFirstname : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentUserByFirstname",
   """
      function(Firstname) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentUserByFirstname/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("Firstname", encodeURIComponent(Firstname))})
      }
   """
)
                        

// @LINE:77
def getStaffUserListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStaffUserListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStaffUserListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:62
def getUserLoginByEmail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getUserLoginByEmail",
   """
      function(email) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getUserLoginByEmail/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("email", encodeURIComponent(email))})
      }
   """
)
                        

// @LINE:87
def getSubjectsById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getSubjectsById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getSubjectsById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:66
def getStudentDetailsById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentDetailsById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentDetailsById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:76
def getStudentUserListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentUserListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentUserListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:110
def getAttendanceByStdAdmNo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getAttendanceByStdAdmNo",
   """
      function(stdAdmNum) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAttendanceByStdAdmNo/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdAdmNum", encodeURIComponent(stdAdmNum))})
      }
   """
)
                        

// @LINE:106
def getHolidaysByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getHolidaysByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getHolidaysByCampusID/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:116
def getExamTimeTableById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getExamTimeTableById",
   """
      function(ettId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getExamTimeTableById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("ettId", ettId)})
      }
   """
)
                        

// @LINE:127
def getVehicleDetailByStaffUserId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getVehicleDetailByStaffUserId",
   """
      function(userId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getVehicleDetailByStaffUserId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId)})
      }
   """
)
                        

// @LINE:111
def getStudentPeriviousDetailByStdAdmNum : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getStudentPeriviousDetailByStdAdmNum",
   """
      function(stdAdmNum) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getStudentPeriviousDetailByStdAdmNum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdAdmNum", encodeURIComponent(stdAdmNum))})
      }
   """
)
                        

// @LINE:108
def getAttendanceByStdAdmNoByMonthNoAndByStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getAttendanceByStdAdmNoByMonthNoAndByStatus",
   """
      function(stdAdmNum,monthNum,status) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAttendanceByStdAdmNoByMonthNoAndByStatus/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stdAdmNum", encodeURIComponent(stdAdmNum)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("monthNum", monthNum) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("status", status)})
      }
   """
)
                        

// @LINE:11
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/signin/credentials"})
      }
   """
)
                        

// @LINE:92
def getLibrariansListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getLibrariansListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getLibrariansListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:80
def termTypeList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.termTypeList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/termTypeList"})
      }
   """
)
                        

// @LINE:75
def getAllGuardianListByCampusId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getAllGuardianListByCampusId",
   """
      function(campusId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getAllGuardianListByCampusId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("campusId", campusId)})
      }
   """
)
                        

// @LINE:64
def getContextById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getContextById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getContextById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:118
def getExamTimeTableByClassId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RestUserController.getExamTimeTableByClassId",
   """
      function(classId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "auth/getExamTimeTableByClassId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("classId", classId)})
      }
   """
)
                        

}
              
}
        


// @LINE:141
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:53
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
// @LINE:38
// @LINE:37
// @LINE:36
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
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
package controllers.ref {


// @LINE:141
class ReverseAssets {


// @LINE:141
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:60
// @LINE:59
// @LINE:58
class ReverseMiscController {


// @LINE:59
def getAllOrganization(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getAllOrganization(), HandlerDef(this.getClass.getClassLoader, "", "controllers.MiscController", "getAllOrganization", Seq(), "GET", """""", _prefix + """auth/getAllOganization""")
)
                      

// @LINE:58
def getUserRolesList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getUserRolesList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.MiscController", "getUserRolesList", Seq(), "GET", """GET/auth/createStudentAttendance/:attendanceUserList    @controllers.RestSignUpController.createStudentAttendance(attendanceUserList : List[AttendanceUser])""", _prefix + """auth/userRoles""")
)
                      

// @LINE:60
def getAllCampusByOrganizationId(orgId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.MiscController]).getAllCampusByOrganizationId(orgId), HandlerDef(this.getClass.getClassLoader, "", "controllers.MiscController", "getAllCampusByOrganizationId", Seq(classOf[Int]), "GET", """""", _prefix + """auth/getAllCampusByOrganizationId/$orgId<[^/]+>""")
)
                      

}
                          

// @LINE:7
class ReverseApplicationController {


// @LINE:7
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ApplicationController]).index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "index", Seq(), "GET", """""", _prefix + """""")
)
                      

}
                          

// @LINE:53
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
// @LINE:38
// @LINE:37
// @LINE:36
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
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
class ReverseRestSignUpController {


// @LINE:15
def signUpForGuardian(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForGuardian(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForGuardian", Seq(), "POST", """""", _prefix + """auth/signUpForGuardian""")
)
                      

// @LINE:31
def campusUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "campusUpdate", Seq(), "POST", """""", _prefix + """auth/campusUpdate""")
)
                      

// @LINE:39
def medicalUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).medicalUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "medicalUpdate", Seq(), "POST", """""", _prefix + """auth/medicalUpdate""")
)
                      

// @LINE:47
def studentUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).studentUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "studentUpdate", Seq(), "POST", """""", _prefix + """auth/studentUpdate""")
)
                      

// @LINE:13
def signUp(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUp(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUp", Seq(), "POST", """""", _prefix + """auth/signup""")
)
                      

// @LINE:27
def schoolNews(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).schoolNews(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "schoolNews", Seq(), "POST", """""", _prefix + """auth/schoolNews""")
)
                      

// @LINE:20
def createbook(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createbook(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "createbook", Seq(), "POST", """""", _prefix + """auth/createbook""")
)
                      

// @LINE:29
def marks(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).marks(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "marks", Seq(), "POST", """""", _prefix + """auth/marks""")
)
                      

// @LINE:32
def organizationUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).organizationUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "organizationUpdate", Seq(), "POST", """""", _prefix + """auth/organizationUpdate""")
)
                      

// @LINE:35
def schoolUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).schoolUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "schoolUpdate", Seq(), "POST", """""", _prefix + """auth/schoolUpdate""")
)
                      

// @LINE:28
def exam(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).exam(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "exam", Seq(), "POST", """""", _prefix + """auth/exam""")
)
                      

// @LINE:52
def sendSMS(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).sendSMS(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "sendSMS", Seq(), "POST", """""", _prefix + """auth/sendSMS""")
)
                      

// @LINE:23
def signOut(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signOut(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signOut", Seq(), "POST", """""", _prefix + """auth/signout""")
)
                      

// @LINE:16
def signUpForStaff(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForStaff(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForStaff", Seq(), "POST", """""", _prefix + """auth/signUpForStaff""")
)
                      

// @LINE:25
def assignmentcreate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).assignmentcreate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "assignmentcreate", Seq(), "POST", """""", _prefix + """auth/assignmentcreate""")
)
                      

// @LINE:14
def signUpForStudent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForStudent(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForStudent", Seq(), "POST", """""", _prefix + """auth/signUpForStudent""")
)
                      

// @LINE:41
def bookIssueUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookIssueUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "bookIssueUpdate", Seq(), "POST", """""", _prefix + """auth/bookIssueUpdate""")
)
                      

// @LINE:34
def holidayUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).holidayUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "holidayUpdate", Seq(), "POST", """""", _prefix + """auth/holidayUpdate""")
)
                      

// @LINE:38
def marksUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).marksUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "marksUpdate", Seq(), "POST", """""", _prefix + """auth/marksUpdate""")
)
                      

// @LINE:45
def staffUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).staffUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "staffUpdate", Seq(), "POST", """""", _prefix + """auth/staffUpdate""")
)
                      

// @LINE:22
def campusCreate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusCreate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "campusCreate", Seq(), "POST", """""", _prefix + """auth/campusCreate""")
)
                      

// @LINE:37
def eventUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).eventUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "eventUpdate", Seq(), "POST", """""", _prefix + """auth/eventUpdate""")
)
                      

// @LINE:12
def signUpForCampusAdmin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForCampusAdmin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForCampusAdmin", Seq(), "POST", """""", _prefix + """auth/signUpForCampusAdmin""")
)
                      

// @LINE:26
def eventCreate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).eventCreate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "eventCreate", Seq(), "POST", """""", _prefix + """auth/eventcreate""")
)
                      

// @LINE:43
def driverUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).driverUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "driverUpdate", Seq(), "POST", """""", _prefix + """auth/driverUpdate""")
)
                      

// @LINE:18
def createVehicleCompleteDetail(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createVehicleCompleteDetail(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "createVehicleCompleteDetail", Seq(), "POST", """""", _prefix + """auth/createVehicleDetail""")
)
                      

// @LINE:30
def StaffClassMapping(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).StaffClassMapping(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "StaffClassMapping", Seq(), "POST", """""", _prefix + """auth/staffClassMapping""")
)
                      

// @LINE:44
def campusadminUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).campusadminUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "campusadminUpdate", Seq(), "POST", """""", _prefix + """auth/campusadminUpdate""")
)
                      

// @LINE:53
def createResultByStdAdmNum(stdAdmNum:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).createResultByStdAdmNum(stdAdmNum), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "createResultByStdAdmNum", Seq(classOf[String]), "GET", """""", _prefix + """auth/createResultByStdAdmNum/$stdAdmNum<[^/]+>""")
)
                      

// @LINE:40
def bookUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "bookUpdate", Seq(), "POST", """""", _prefix + """auth/bookUpdate""")
)
                      

// @LINE:46
def guardianUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).guardianUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "guardianUpdate", Seq(), "POST", """""", _prefix + """auth/guardianUpdate""")
)
                      

// @LINE:51
def uploadfile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).uploadfile(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "uploadfile", Seq(), "POST", """POST    /upload          								 @controllers.RestSignUpController.upload
POST    /auth/createFileUpload                          @controllers.RestSignUpController.upload""", _prefix + """auth/fileupload""")
)
                      

// @LINE:33
def assignmentUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).assignmentUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "assignmentUpdate", Seq(), "POST", """""", _prefix + """auth/assignmentUpdate""")
)
                      

// @LINE:48
def vehicleUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).vehicleUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "vehicleUpdate", Seq(), "POST", """""", _prefix + """auth/vehicleUpdate""")
)
                      

// @LINE:17
def signUpForDriver(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForDriver(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForDriver", Seq(), "POST", """""", _prefix + """auth/signUpForDriver""")
)
                      

// @LINE:42
def librarianUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).librarianUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "librarianUpdate", Seq(), "POST", """""", _prefix + """auth/librarianUpdate""")
)
                      

// @LINE:36
def newsUpdate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).newsUpdate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "newsUpdate", Seq(), "POST", """""", _prefix + """auth/newsUpdate""")
)
                      

// @LINE:19
def signUpForLibrarian(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).signUpForLibrarian(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "signUpForLibrarian", Seq(), "POST", """""", _prefix + """auth/signUpForLibrarian""")
)
                      

// @LINE:24
def bookIssue(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).bookIssue(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "bookIssue", Seq(), "POST", """""", _prefix + """auth/bookIssue""")
)
                      

// @LINE:21
def medicalCreate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestSignUpController]).medicalCreate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestSignUpController", "medicalCreate", Seq(), "POST", """""", _prefix + """auth/medicalCreate""")
)
                      

}
                          

// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:11
class ReverseRestUserController {


// @LINE:95
def getBookListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getBookListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getBookListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getBookListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:90
def restPasswordKey(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).restPasswordKey(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "restPasswordKey", Seq(), "GET", """""", _prefix + """auth/updatePassword""")
)
                      

// @LINE:117
def getExamTimeTableByExamId(examId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableByExamId(examId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getExamTimeTableByExamId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getExamTimeTableByExamId/$examId<[^/]+>""")
)
                      

// @LINE:124
def getClassListByStaffUserId(userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getClassListByStaffUserId(userId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getClassListByStaffUserId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getClassListByStaffUserId/$userId<[^/]+>""")
)
                      

// @LINE:107
def getSchoolListByCampusId(campusId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSchoolListByCampusId", Seq(classOf[Int]), "GET", """""", _prefix + """auth/getSchoolsInformationByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:114
def getExamDetailsByExamId(examId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamDetailsByExamId(examId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getExamDetailsByExamId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getExamDetailsByExamId/$examId<[^/]+>""")
)
                      

// @LINE:79
def getStudentListByClassId(classId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentListByClassId(classId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentListByClassId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStudentListByClassId/$classId<[^/]+>""")
)
                      

// @LINE:72
def getStudentUserById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentUserById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStudentUserById/$id<[^/]+>""")
)
                      

// @LINE:103
def getStudentVehicleDetailsByStudentAdmNum(stdadmissionno:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentVehicleDetailsByStudentAdmNum(stdadmissionno), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentVehicleDetailsByStudentAdmNum", Seq(classOf[String]), "GET", """""", _prefix + """auth/getStudentVehicleDetailsByStudentAdmNum/$stdadmissionno<[^/]+>""")
)
                      

// @LINE:74
def getGuardianUserById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianUserById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getGuardianUserById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getGuardianUserById/$id<[^/]+>""")
)
                      

// @LINE:126
def getVehicleTypeListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleTypeListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getVehicleTypeListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getVehicleTypeListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:100
def getStudentDetailByStdAdmNum(admNum:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentDetailByStdAdmNum(admNum), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentDetailByStdAdmNum", Seq(classOf[String]), "GET", """GET		/auth/getStudentWhoHasReturnBook/:stdUserId		 @controllers.RestUserController.getStudentWhoHasReturnBook(stdUserId : Long)""", _prefix + """auth/getStudentDetailByStdAdmNum/$admNum<[^/]+>""")
)
                      

// @LINE:120
def getMarksDetailBySubjectId(subjectId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksDetailBySubjectId(subjectId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMarksDetailBySubjectId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getMarksDetailBySubjectId/$subjectId<[^/]+>""")
)
                      

// @LINE:73
def getStaffUserById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffUserById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffUserById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStaffUserById/$id<[^/]+>""")
)
                      

// @LINE:63
def getUserContextById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserContextById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getUserContextById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getUserContextById/$id<[^/]+>""")
)
                      

// @LINE:94
def getMedicalDetailListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMedicalDetailListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMedicalDetailListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getMedicalDetailListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:115
def getEventDetailByEventId(eventId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getEventDetailByEventId(eventId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getEventDetailByEventId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getEventDetailByEventId/$eventId<[^/]+>""")
)
                      

// @LINE:121
def getMarksListByclassId(classId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksListByclassId(classId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMarksListByclassId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getMarksListByclassId/$classId<[^/]+>""")
)
                      

// @LINE:91
def getVehicleRouteAndStopDetailsByVhId(vid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleRouteAndStopDetailsByVhId(vid), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getVehicleRouteAndStopDetailsByVhId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getVehicleRouteAndStopDetailsByVhId/$vid<[^/]+>""")
)
                      

// @LINE:98
def getListOfStudentByCampusIdWhoHasTakenBooks(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getListOfStudentByCampusIdWhoHasTakenBooks(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getListOfStudentByCampusIdWhoHasTakenBooks", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getListOfStudentByCampusIdWhoHasTakenBooks/$campusId<[^/]+>""")
)
                      

// @LINE:65
def getStaffDetailById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffDetailById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffDetailById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStaffDetailsById/$id<[^/]+>""")
)
                      

// @LINE:61
def getUserById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getUserById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getUserById/$id<[^/]+>""")
)
                      

// @LINE:86
def getAllSubjectList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllSubjectList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAllSubjectList", Seq(), "GET", """""", _prefix + """auth/getAllSubjectList""")
)
                      

// @LINE:119
def getClassTimeTableByClassId(classId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getClassTimeTableByClassId(classId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getClassTimeTableByClassId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getClassTimeTableByClassId/$classId<[^/]+>""")
)
                      

// @LINE:68
def getGuardianDetailsById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianDetailsById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getGuardianDetailsById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getGuardianDetailsById/$id<[^/]+>""")
)
                      

// @LINE:105
def getEventListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getEventListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getEventListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getEventListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:112
def getSchoolNewsListBySchoolId(schoolId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolNewsListBySchoolId(schoolId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSchoolNewsListBySchoolId", Seq(classOf[Int]), "GET", """""", _prefix + """auth/getSchoolNewsListBySchoolId/$schoolId<[^/]+>""")
)
                      

// @LINE:82
def getDriverListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getDriverListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getDriverListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getDriverListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:70
def deleteUserDetailsById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).deleteUserDetailsById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "deleteUserDetailsById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/deleteUserDetailsById/$id<[^/]+>""")
)
                      

// @LINE:78
def getAllClassesByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllClassesByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAllClassesByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getAllClassesByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:97
def getAssignmentByClassId(cid:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAssignmentByClassId(cid), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAssignmentByClassId", Seq(classOf[Int]), "GET", """""", _prefix + """auth/getAssignmentByClassId/$cid<[^/]+>""")
)
                      

// @LINE:85
def getSubjectIdBySubjectName(subjectName:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectIdBySubjectName(subjectName), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSubjectIdBySubjectName", Seq(classOf[String]), "GET", """GET     /auth/createAttendance/:classId                 @controllers.RestUserController.createAttendance(classId: Long)
GET     /auth/getVehicledetails/:id                     @controllers.RestUserController.getVehicledetailsById(id : Long)""", _prefix + """auth/getSubjectIdBySubjectName/$subjectName<[^/]+>""")
)
                      

// @LINE:88
def getSubjectsByClassId(classId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectsByClassId(classId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSubjectsByClassId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getSubjectsByClassId/$classId<[^/]+>""")
)
                      

// @LINE:93
def getMedicalDetailByUserId(userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMedicalDetailByUserId(userId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMedicalDetailByUserId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getMedicalDetailByUserId/$userId<[^/]+>""")
)
                      

// @LINE:122
def getMarksListByStdAdmNum(stdAdmNum:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getMarksListByStdAdmNum(stdAdmNum), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getMarksListByStdAdmNum", Seq(classOf[String]), "GET", """""", _prefix + """auth/getMarksListByStdAdmNum/$stdAdmNum<[^/]+>""")
)
                      

// @LINE:89
def forgetpassword(email:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).forgetpassword(email), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "forgetpassword", Seq(classOf[String]), "GET", """""", _prefix + """auth/forgetpassword/$email<[^/]+>""")
)
                      

// @LINE:109
def getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum:String, fromDate:String, toDate:String, status:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(stdAdmNum, fromDate, toDate, status), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus", Seq(classOf[String], classOf[String], classOf[String], classOf[Int]), "GET", """""", _prefix + """authgetAttendanceByStdAdmNoByFrmDateByToDateAndByStatus/$stdAdmNum<[^/]+>/$fromDate<[^/]+>/$toDate<[^/]+>/$status<[^/]+>""")
)
                      

// @LINE:113
def getSchoolNewsListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSchoolNewsListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSchoolNewsListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getSchoolNewsListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:128
def getAssignmentByStaffUserId(userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAssignmentByStaffUserId(userId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAssignmentByStaffUserId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getAssignmentByStaffUserId/$userId<[^/]+>""")
)
                      

// @LINE:101
def getGuardianUserByStudentAdmissionNumber(stdadmissionno:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getGuardianUserByStudentAdmissionNumber(stdadmissionno), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getGuardianUserByStudentAdmissionNumber", Seq(classOf[String]), "GET", """""", _prefix + """auth/getGuardianUserByStudentAdmissionNumber/$stdadmissionno<[^/]+>""")
)
                      

// @LINE:102
def getStudentMedicalDetailsByStudentAdmNum(stdadmissionno:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentMedicalDetailsByStudentAdmNum(stdadmissionno), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentMedicalDetailsByStudentAdmNum", Seq(classOf[String]), "GET", """""", _prefix + """auth/getStudentMedicalDetailsByStudentAdmNum/$stdadmissionno<[^/]+>""")
)
                      

// @LINE:104
def getStudentEventDetailsByAdmissionNumber(stdadmissionno:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentEventDetailsByAdmissionNumber(stdadmissionno), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentEventDetailsByAdmissionNumber", Seq(classOf[String]), "GET", """""", _prefix + """auth/getStudentEventDetailsByAdmissionNumber/$stdadmissionno<[^/]+>""")
)
                      

// @LINE:123
def getStaffTimeTableByClassId(classId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffTimeTableByClassId(classId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffTimeTableByClassId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStaffTimeTableByClassId/$classId<[^/]+>""")
)
                      

// @LINE:96
def getStudentAttendenceListByClassId(classId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentAttendenceListByClassId(classId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentAttendenceListByClassId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStudentAttendenceListByClassId/$classId<[^/]+>""")
)
                      

// @LINE:69
def updateStudentDetailsById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).updateStudentDetailsById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "updateStudentDetailsById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/updateStudentDetails/$id<[^/]+>""")
)
                      

// @LINE:125
def getStaffListByClassId(classId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffListByClassId(classId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffListByClassId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStaffListByClassId/$classId<[^/]+>""")
)
                      

// @LINE:81
def getVehicleListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getVehicleListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getVehicleListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:129
def getImage(key:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getImage(key), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getImage", Seq(classOf[String]), "GET", """""", _prefix + """auth/getImage/$key<[^/]+>""")
)
                      

// @LINE:67
def getStudentUserByFirstname(Firstname:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserByFirstname(Firstname), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentUserByFirstname", Seq(classOf[String]), "GET", """""", _prefix + """auth/getStudentUserByFirstname/$Firstname<[^/]+>""")
)
                      

// @LINE:77
def getStaffUserListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStaffUserListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStaffUserListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStaffUserListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:62
def getUserLoginByEmail(email:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getUserLoginByEmail(email), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getUserLoginByEmail", Seq(classOf[String]), "GET", """""", _prefix + """auth/getUserLoginByEmail/$email<[^/]+>""")
)
                      

// @LINE:87
def getSubjectsById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getSubjectsById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getSubjectsById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getSubjectsById/$id<[^/]+>""")
)
                      

// @LINE:66
def getStudentDetailsById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentDetailsById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentDetailsById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStudentDetailsById/$id<[^/]+>""")
)
                      

// @LINE:76
def getStudentUserListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentUserListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentUserListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getStudentUserListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:110
def getAttendanceByStdAdmNo(stdAdmNum:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNo(stdAdmNum), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAttendanceByStdAdmNo", Seq(classOf[String]), "GET", """""", _prefix + """auth/getAttendanceByStdAdmNo/$stdAdmNum<[^/]+>""")
)
                      

// @LINE:106
def getHolidaysByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getHolidaysByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getHolidaysByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getHolidaysByCampusID/$campusId<[^/]+>""")
)
                      

// @LINE:116
def getExamTimeTableById(ettId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableById(ettId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getExamTimeTableById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getExamTimeTableById/$ettId<[^/]+>""")
)
                      

// @LINE:127
def getVehicleDetailByStaffUserId(userId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getVehicleDetailByStaffUserId(userId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getVehicleDetailByStaffUserId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getVehicleDetailByStaffUserId/$userId<[^/]+>""")
)
                      

// @LINE:111
def getStudentPeriviousDetailByStdAdmNum(stdAdmNum:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getStudentPeriviousDetailByStdAdmNum(stdAdmNum), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getStudentPeriviousDetailByStdAdmNum", Seq(classOf[String]), "GET", """""", _prefix + """auth/getStudentPeriviousDetailByStdAdmNum/$stdAdmNum<[^/]+>""")
)
                      

// @LINE:108
def getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum:String, monthNum:Int, status:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAttendanceByStdAdmNoByMonthNoAndByStatus(stdAdmNum, monthNum, status), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAttendanceByStdAdmNoByMonthNoAndByStatus", Seq(classOf[String], classOf[Int], classOf[Int]), "GET", """""", _prefix + """auth/getAttendanceByStdAdmNoByMonthNoAndByStatus/$stdAdmNum<[^/]+>/$monthNum<[^/]+>/$status<[^/]+>""")
)
                      

// @LINE:11
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).authenticate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "authenticate", Seq(), "POST", """ Login/SignUp""", _prefix + """auth/signin/credentials""")
)
                      

// @LINE:92
def getLibrariansListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getLibrariansListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getLibrariansListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getLibrariansListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:80
def termTypeList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).termTypeList(), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "termTypeList", Seq(), "GET", """""", _prefix + """auth/termTypeList""")
)
                      

// @LINE:75
def getAllGuardianListByCampusId(campusId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getAllGuardianListByCampusId(campusId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getAllGuardianListByCampusId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getAllGuardianListByCampusId/$campusId<[^/]+>""")
)
                      

// @LINE:64
def getContextById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getContextById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getContextById", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getContextById/$id<[^/]+>""")
)
                      

// @LINE:118
def getExamTimeTableByClassId(classId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.RestUserController]).getExamTimeTableByClassId(classId), HandlerDef(this.getClass.getClassLoader, "", "controllers.RestUserController", "getExamTimeTableByClassId", Seq(classOf[Long]), "GET", """""", _prefix + """auth/getExamTimeTableByClassId/$classId<[^/]+>""")
)
                      

}
                          
}
        
    