package models.daos

import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import dtos.UserDTO
import models.users.User
import java.util.Calendar
import models.users.UserLogin
import models.users.UserContext
import security.models.StaffDetail
import security.models.GuardianDetail
import models.commons.Context
import security.models.StudentDetail
import models.users.Staff
import dtos.StaffDTO
import dtos.StudentDTO
import dtos.GuardianDTO
import security.models.StudentDetail
import models.users.StudentUser
import models.users.StaffUser
import models.users.GuardianUser
import models.users.Class
import models.users.TermType
import models.users.StudentClassMapping
import models.users.Term
import models.users.UserTerm
import models.users.Student_Guardian_Mapping
import models.users.AttendanceList
import models.users.Course
import models.users.Course
import models.users.CourseStaff
import models.users.CourseStaffMapping
import models.users.VehicleDetail
import com.mohiva.play.silhouette.core.utils.PasswordHasher
import org.mindrot.jbcrypt.BCrypt
import security.models.DriverDetail
import models.users.RouteDetail
import models.users.StopDetail
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
import models.users.Assignment
import models.users.AssignmentUser
import models.users.School
import models.users.Holiday
import models.users.VehicleType
import models.users.BokCategories
import models.users.Events
import java.io.InputStream
import java.io.FileInputStream
import java.io.File
import models.users.AttendanceUser
import models.users.AttendanceCommon
import models.users.AttendanceDOIAndUpdatedOn
import models.users.StdClassTerm
import models.users.SchoolNews
import models.users.Exam
import models.users.ExamClassMap
import models.users.ExamInfo
import org.joda.time.DateTime
import java.util.Date
import models.users.SubjectMaster
import models.users.ExamTimeTable
import java.sql.Timestamp
import models.users.EventsMaster
import models.users.EventsUser
import models.users.SubjectClassMap
import models.users.ClassTimeTable
import models.users.ExamCompleteInfo
import models.users.Marks
import models.users.MarksUser
import models.users.StudentUserMarks
import models.users.MarksStudent
import models.users.StudentMarks
import models.users.FinalResult
import java.io.File
import play.api.Logger
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData
import play.api.mvc.Request
import java.util.UUID
import play.api.Play
import play.api.Play.current
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.services.s3.model.PutObjectRequest
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.FileInputStream
import play.api.Logger
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.Bucket
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.model.ObjectListing
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.S3ObjectSummary
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.util.IOUtils
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.S3ObjectInputStream
import play.api.Play.current
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import java.util.UUID
import java.io.File
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.InputStream
import scala.util.control.Breaks._
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.BufferedOutputStream
import com.amazonaws.util.IOUtils
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.S3ObjectInputStream
import models.users.CampusAdminUser
import models.users.StaffSubjectMap
import models.users.StaffClassMap
import models.users.SubjectClassStaffMap
import models.users.MappingStaffClassSubject
import models.users.ClassListForStaff
import models.users.StaffDetailsForClass
import models.users.StudentDetailForGuardian
import models.users.DriverInfo



class UserDAOImpl extends UserDAO {
  
   private val log: Logger = Logger(this.getClass)

 
    val UserSimple = {
	  get[Long]("id") ~     
    get[String]("Firstname") ~
    get[Option[String]]("Firstname") ~
    get[Option[String]]("MiddleName") ~
    get[Option[String]]("Lastname") ~
    get[Option[Date]]("DOB") ~
    get[Option[String]]("Gender") ~
    get[Option[String]]("Address1") ~
    get[Option[String]]("Address2") ~
    get[Option[String]]("City") ~
    get[Option[String]]("State") ~
    get[Option[Long]]("Deleted") map {
        case (id ~ un ~ fn ~ mn ~ln ~ dob ~ gen ~ add1 ~ add2 ~ cty ~ st ~ del) => 
          UserDTO(id = id, username = un ,firstName = fn, middleName = mn,lastName = ln, DOB = Option(dob.toString()), Gender = gen, address1 = add1, address2 = add2, city = cty, state = st, Deleted = del)
      }
  }
  
  val UserLoginSimple = {
    get[Long]("ulogId") ~
    get[String]("email") ~
    get[Option[Long]]("phone_number") ~
    get[Int]("verified") ~
    get[Long]("user_id") map {      
      case(id ~ em ~ pn ~ v ~ uid) => UserLogin(id = id, email = em, phoneNumber = pn, verified = v, userId = uid)
    }
    
  }
  
  val CreateStuGuarMapping = {
    get[Long]("id") ~
    get[Long]("gid") ~
    get[String]("stdadmissionno") ~
    get[Long]("user_id") map {      
      case(id ~ gid ~ stdgm ~ uid) => Student_Guardian_Mapping(id = id, gid = gid, stdadmissionno = stdgm, user_id = uid)
    }  
  }
  
 //CreateVehicleDetails 
  val CreateVehicleDetails = {
    get[Long]("vdId") ~
   get[String]("Vehicle_no") ~
    get[String]("Vehicle_code") ~
    get[Int]("No_of_Seat") ~
    get[Int]("Maximum_capacity") ~
    get[String]("insurance") ~
    get[String]("tax_remitted") ~
    get[String]("permit") ~
    get[String]("status") ~
    get[Int]("Vehicle_type_id") ~
    get[Long]("campusId")map {      
      case(id ~ vno ~ vcd ~ nos ~ maxc ~ ins ~ tax ~ per ~ stat ~ vtyp ~ cmpid ) => VehicleDetail(id = id, Vehicle_no = vno, Vehicle_code = vcd, No_of_Seat = nos,
          Maximum_capacity = maxc, insurance=ins,tax_remitted=tax, permit=per, status=stat,Vehicle_type_id=vtyp, campusId = cmpid)
    }  
  }
  
  val CreateRouteDetail = {
    get[Int]("rdId") ~
    get[String]("Route_Name") ~
    get[Int]("No_of_Stops") ~
    get[Long]("Vehicle_id") map {
      case(id ~ rnm ~ nos ~ vid) => RouteDetail(rdId = id, Route_Name = rnm, No_of_Stops = nos,Vehicle_id = vid)
    }
  }
  //SchoolNewsSimple
  val SchoolNewsSimple = {    
      get[Long]("id") ~
      get[Int]("schoolId") ~
      get[String]("headlines") ~
      get[String]("newsdesc") ~
      get[Date]("newsdate") ~
      get[Int]("status") map {
        case(id ~ sid ~ hln ~ nwsdes ~ nwsdt ~ st) => SchoolNews(id = id, schoolId = sid ,headLines = hln, newsDesc = nwsdes, newsDate= nwsdt.toString(),status = st)
      }
  }
  
  //ExamSimple
  val ExamSimple = {    
      get[Long]("examId") ~
      get[String]("examName") ~
      get[Int]("termId") ~
      get[Date]("createAt") ~
      get[Date]("updateAt") map {
        case(id ~ enm ~ ttid ~ cat ~ uat) => Exam(id = id, examName = enm ,termtypeId = ttid, createAt = cat.toString(), updateAt = uat.toString())
      }
  }
  
  //SubjectSimple
  val SubjectSimple = {    
      get[Long]("subId") ~
      get[String]("subjectName") ~
      get[Date]("createdOn") ~
      get[Date]("updatedOn") map {
        case(id ~ snm ~ cat ~ uat) => SubjectMaster(id = id, subjectName = snm ,createdOn = cat.toString(), updatedOn = uat.toString())
      }
  }
  
  //ExamInfoSimple
   val ExamInfoSimple = {    
      get[Long]("examId") ~
      get[String]("examName") ~
      get[Long]("termId") ~
      get[Long]("classId") ~
      get[String]("class_name") map {
        case(id ~ enm ~ tid ~ cid ~ cnm) => ExamInfo(examId = id, examName = enm ,termId = tid, classId = cid, className = cnm)
      }
  }
  
    //ExamClassMapSimple
  val ExamClassMapSimple = { 
      get[Long]("ecmId") ~
      get[Long]("examId") ~
      get[Long]("classId") ~
      get[Int]("termId") ~
      get[Date]("createdAt") ~
      get[Date]("updateAt") map {
        case(id ~ exid ~ cid ~ tid ~ cat ~ uat) => ExamClassMap(ecmId = id, examId = exid ,classId = cid, termId = tid,
            createdAt = cat.toString(), updateAt = uat.toString())
      }
  }
  
  //StaffSubjectMapSimple
  val StaffSubjectMapSimple = { 
      get[Long]("stfSubMapId") ~
      get[Long]("subId") ~
      get[Long]("userId") map {
        case(id ~ sid ~ uid) => StaffSubjectMap(id = id, subjectId = sid ,userId = uid)
      }
  }
  
  //StaffClassMapSimple
   val StaffClassMapSimple = { 
      get[Long]("stfClsMapId") ~
      get[Long]("classId") ~
      get[Long]("userId") map {
        case(id ~ scmid ~ uid) => StaffClassMap(id = id, classId = scmid ,userId = uid)
      }
  }
   
  //ClassListForStaffSimple
   val ClassListForStaffSimple = {
      get[Long]("id") ~
      get[String]("class_name") map {
        case(id ~ clsnm) => ClassListForStaff(classId = id, className = clsnm)
      }
   }
   
   //StaffDetailsForClassSimple
   val StaffDetailsForClassSimple = {
     get[Long]("id") ~
     get[String]("class_name") ~ 
     get[Long]("userId") ~ 
     get[String]("firstname") ~
     get[Long]("subId") ~
     get[String]("subjectName") map {
        case(id ~ clsnm ~ uid ~ fnm ~ sid ~ snm) => StaffDetailsForClass(classId = id,className = clsnm,staffUserId = uid,
                  firstName = fnm,subjectId = sid,subjectName = snm)
      }
   }
   
   
   //SubjectClassStaffMap
   val SubjectClassStaffMapSimple = {
     get[String]("firstname") ~ 
     get[Long]("user_id") ~
     get[Long]("classId") ~
     get[String]("class_name") ~
     get[Long]("subjectId") ~
     get[String]("subjectName") ~
     get[Long]("vehicleId") ~
     get[String]("vehicle_no") ~
     get[Long]("campus_id") ~
     get[String]("campus_name") ~
     get[Long]("organization_id") ~
     get[String]("name") map {
       case(fnm ~ uid ~ clsid ~ cnm ~ subid ~ subnm ~ vid ~ vno ~ cmpid ~ cmpnm ~ oid ~ onm) =>
         SubjectClassStaffMap(firstname = fnm,user_id = uid,classId = clsid,class_name = cnm,subjectId = subid,subjectName = subnm,
                vehicleId = vid,vehicle_no = vno,campus_id = cmpid,campus_name = cmpnm,organization_id = oid,name = onm)
     }
   }
   
   //MappingStaffClassSubjectSimple
    val MappingStaffClassSubjectSimple = {
      get[Long]("subClassId") ~
      get[Long]("subjectId") ~
      get[Long]("classId") ~
      get[Long]("stfSubMapId") ~
      get[Long]("userId")  map {
       case(subclsid ~ subid ~ clsid ~ stfsubid ~ uid) =>
         MappingStaffClassSubject(subjectClassId = subclsid,subjectId = subid,classId = clsid,staffSubjectId = stfsubid,
             userId = uid)
     }
   }
  //ExamTimeTableSimple
  val ExamTimeTableSimple = { 
      get[Long]("EttId") ~
      get[Long]("subId") ~
      get[Long]("ecmapId") ~
      get[Date]("examDate") ~
      get[String]("fromTime") ~
      get[String]("toTime") ~
      get[Int]("status") ~
      get[Date]("createdAt") ~
      get[Date]("updatedAt") map {
        case(etid ~ sid ~ ecmid  ~ edt ~ frmtm ~ totm ~ st ~ ctat ~ utat) => ExamTimeTable(id = etid, subjectId = sid, ecmapId = ecmid,
        examDate = edt.toString(),fromTime = frmtm.toString(),toTime = totm.toString(), status = st, createdAt = ctat.toString(),
        updatedAt = utat.toString())
      }
  }
  
  //ExamCompleteInfoSimple
  val ExamCompleteInfoSimple = {
    get[Long]("EttId") ~
      get[Long]("subjectId") ~
      get[String]("subjectName") ~
      get[Long]("ecmapId") ~
      get[Long]("classId") ~
      get[String]("class_name") ~
      get[Long]("termId") ~
      get[String]("term_type") ~
      get[Date]("examDate") ~
      get[String]("fromTime") ~
      get[String]("toTime") ~
      get[Int]("status") ~
      get[Date]("createdAt") ~
      get[Date]("updatedAt") map {
        case(etid ~ sid ~ snm ~ ecmid ~ cid ~ cnm ~ tid ~ tnm ~ edt ~ frmtm ~ totm ~ st ~ ctat ~ utat) => ExamCompleteInfo(EttId = etid,subjectId = sid,
        subjectName = snm, ecmapId = ecmid, classId = cid, class_name = cnm, termId = tid, term_type = tnm,examDate = edt.toString(),
        fromTime = frmtm.toString(),toTime = totm.toString(), status = st, createdAt = ctat.toString(),updatedAt = utat.toString())
      }
  }
  
  val ClassTimeTableSimple = { 
      get[Long]("TtId") ~
      get[Long]("classId") ~
      get[String]("Day") ~
      get[Long]("Pone") ~
      get[Long]("Ptwo") ~
      get[Long]("Pthree") ~
      get[Long]("Pfour") ~
      get[Long]("Pfive") ~
      get[Long]("Psix") ~
      get[Long]("Pseven") ~
      get[Long]("Peight") ~
      get[Date]("createdAt") ~
      get[Date]("updatedAt") map {
        case(id ~ cid ~ day ~ p1 ~ p2 ~ p3 ~ p4 ~ p5 ~ p6 ~ p7 ~ p8 ~ ctat ~ utat) => ClassTimeTable(id = id,classId = cid,
            Day = day,pOne =p1, pTwo = p2, pThree = p3, pFour = p4, pFive =p5, pSix = p6, pSeven = p7, pEight = p8,
            createdAt = ctat.toString(),updatedAt = utat.toString())
      }
  }
  
  val MarksSimple = { 
      get[Long]("mId") ~
      get[Long]("ecmId") ~
      get[Long]("userId") ~
      get[Long]("subjectId") ~
      get[Long]("maxMarks") ~
      get[Long]("minMarks") ~
      get[Long]("marksObtained") ~
      get[String]("marksInWords") ~
      get[String]("remarks") map {
        case(id ~ ecid ~ stdId ~ subId ~ maxm ~ minm ~ mrksObt ~ mrksWrd ~ rem) => Marks(id = id,ecmId = ecid,studentId = stdId,
            subjectId =subId, maxMarks = maxm, minMarks = minm, marksObtained = mrksObt, marksInWords = mrksWrd,remarks = rem)
      }
  }
  
  val FinalResultSimple = {
      get[Long]("resId") ~
      get[Date]("dateOfResult") ~
      get[Long]("userId") ~
      get[Long]("totalMaxMarks") ~
      get[Long]("totalMinMarks") ~
      get[Long]("totalMarksObtained") ~
      get[String]("marksInWords") ~
      get[String]("resultClass") ~
      get[Double]("average")  map {
        case(id ~ dtres ~ uid ~ tolmax ~ tolmin ~ tolmrk ~ wrds ~ rescls ~ avg) => 
          FinalResult(resultId = id,dateOfResult = dtres.toString(),userId = uid,
            totalMaxMarks = tolmax,totalMinMarks = tolmin, totalMarksObtained = tolmrk, marksInWords = wrds, resultClass = rescls, average = avg)
      }
  }
  
  val MarksUserSimple = {
          get[Long]("mId") ~
          get[Long]("examId") ~
          get[String]("examName") ~
          get[Long]("id") ~
          get[String]("class_name") ~
          get[Long]("userId") ~
          get[String]("Firstname") ~
          get[Long]("subjectId") ~
          get[String]("subjectName") ~
          get[Long]("maxMarks") ~
          get[Long]("minMarks") ~
          get[Long]("marksObtained") ~
          get[String]("marksInWords") ~
          get[String]("remarks") map {
        case(id ~ exmId ~ exmnm ~ clsId ~ clsnm ~ usrId ~ fnm ~ subId ~ subnm ~  maxm ~ minm ~ mrksObt ~ mrksWrd ~ rem) =>
         MarksUser(marksId = id, examId = exmId, examName = exmnm, classId = clsId, className = clsnm, studentId = usrId, studentName = fnm,
        subjectId = subId, subjectName = subnm, maxMarks = maxm, minMarks = minm, marksObtained = mrksObt, marksInWords = mrksWrd,remarks = rem)
      }
  }
  
  val MarksStudentSimple = {
            get[Long]("id") ~
            get[String]("subjectName") ~
            get[Long]("maxMarks") ~
            get[Long]("minMarks") ~
            get[Long]("marksObtained") ~
            get[String]("marksInWords") ~
            get[String]("remarks") map {
        case(uid ~ subnm ~  maxm ~ minm ~ mrksObt ~ mrksWrd ~ rem) =>
         MarksStudent(userId = uid,subjectName = subnm, maxMarks = maxm, minMarks = minm, marksObtained = mrksObt, marksInWords = mrksWrd,remarks = rem)
      }
  }
  
  val StudentMarksSimple = {
            get[Option[String]]("Firstname") ~
            get[Option[String]]("Lastname") ~
            get[Option[String]]("Middlename") ~
            get[Long]("user_id") ~
            get[String]("studentadminno") ~
            get[Long]("Mobile") ~
            get[String]("class_name") ~
            get[String]("campus_name") ~
            get[String]("name") ~
            get[String]("examName") map {
        case(fnm ~ lnm ~ mnm ~ uid ~ stdadm ~ mob ~ clsnm ~ cnm ~  orgnm ~ enm) =>
         StudentMarks(firstName = fnm, lastName = lnm, middleName = mnm, userId = uid, Studentadminno = stdadm,
         contactNumber = mob, className = clsnm,campusName = cnm, orgName = orgnm, examName = enm)
      }
  }
  
  /*val ClassWithSubjectMapSimple = {
    get[Long]("subId") ~
    get[String]("subjectName") ~
    get[Long]("id") ~
    get[String]("class_name") map {
        case(sid ~ snm ~ cid ~ cnm) => ClassWithSubjectClassMap(subjectId = sid,subjectName = snm,classId = cid, className = cnm)
  }
  }*/
  
  val OrganizationSimple = {    
      get[Int]("oId") ~
      get[String]("name") ~
      get[String]("Type") ~
      get[Int]("activated") ~
      get[Int]("paid") ~
      get[Int]("deleted") map {
        case(oId ~ nm ~ typ ~ act ~ pad ~ del) => Organization(id = oId, name = nm,Type = typ, activated = act, paid= pad,deleted = del)
      }
  }
  
  val CampusSimple = {    
      get[Int]("cmId") ~
      get[String]("campus_name") ~
      get[String]("campusAddress") ~
      get[String]("campusLocation") ~
      get[Int]("organization_id")  map {
        case(cmId ~ cps ~ cmpAdd ~ cmpLoc ~ orgId) => Campus(id = cmId, campus_name = cps,campusAddress = cmpAdd, campusLocation = cmpLoc, organization_id= orgId)
      }
  }
  
  //SubjectClassMapSimple
  val SubjectClassMapSimple = { 
      get[Long]("SubClassId") ~
      get[Long]("subjectId") ~
      get[Long]("classId") map {
        case(id ~ subid ~ cid) => SubjectClassMap(SubClassId = id, subjectId = subid ,classId = cid)
      }
  }
  
  val CreateStopDetail = {
    get[Int]("id") ~
 get[String]("Stop_Name") ~
 get[String]("fare") ~
 get[String]("Arival_Mrng") ~
 get[String]("Departure_Mrng") ~
 get[String]("Arival_Evng") ~ 
 get[String]("Departure_Evng") ~
 get[Int]("Route_details_id") map {
      case(id ~ snm ~ fr ~ am ~ dm ~ ae ~ de ~ rdid) => StopDetail(id = id, Stop_Name = snm, fare = fr, Arival_Mrng = am,
          Departure_Mrng = dm, Arival_Evng=ae,Departure_Evng=de, Route_details_id=rdid)
    }
  }
  
 
  val insertStudentClassMap = {
    get[Long]("id") ~
    get[Long]("user_id") ~
    get[Long]("class_id")map {      
      case(id ~ uid ~ cid) => StudentClassMapping(id = id, user_id = uid, class_id = cid)
    }  
  }
  
   val CreateTermType = {
    get[Long]("id") ~
    get[String]("term_type") map {      
      case(id ~ ttype) => TermType(id = id, term_type = ttype)
    }  
  }
   
  val BookIssueSimple = {
    get[Int]("id") ~
    get[Long]("stdUserId") ~
    get[Int]("bookid") ~
    get[Date]("date_issued") ~
    get[Date]("date_due_for_return") ~
    get[Option[Date]]("date_returned") ~
    get[Option[Int]]("amount_of_fine") ~
    get[Long]("libUserId") ~
    get[Int]("bookReturnFlag") ~
    get[Option[Long]]("libRetId") map {
      case(id ~ stu ~ bk ~ di ~ ddr ~ dr ~ amt ~ libu ~ bkrtflg ~ libru) =>
        BookIssue( id = id,stdUserId = stu, bookid = bk, date_issued = di.toString(),date_due_for_return = ddr.toString(),
            date_returned = Option(dr.toString()),amount_of_fine = amt,libUserId = libu,bookReturnFlag = bkrtflg, libRetId = libru) 
    } 
  }
   
   val CreateUserTerm = {
    get[Long]("id") ~
    get[Long]("user_id") ~
    get[Int]("term_id") ~
    get[Int]("active") ~ 
    get[Int]("deleted") map {      
      case(id ~ uid ~ tid ~ act ~ del) => UserTerm(id = id, user_id = uid, term_id = tid, active = act, deleted = del)
    }  
  }
  
   val UserContextSimple = {
    get[Long]("id") ~
    get[Long]("user_id") ~
    get[Long]("context_id") ~
    get[Long]("campus_id")  map {      
      case(id ~ uid ~ cid ~ campid ) => UserContext(id = id, userId = uid, contextId = cid, campusId = campid)
    } 
  }
   
   //contextSimple
    val contextSimple = {
    get[Int]("id") ~
    get[String]("context") map {      
      case(id ~ ctx ) => Context(id = id, context = ctx)
    }
    
  }
   
   
   val StaffDetailsSimple = {
    get[Long]("id") ~
    get[Long]("user_id")~
     get[Option[Long]]("vehicleId") map {      
      case(id ~ ucid ~ vid ) => StaffDetail(id = id, user_id = ucid,vehicleId=vid)
    }   
  }
   
   val StaffSimple = {
    get[Long]("id") ~
    get[Long]("user_id")~
     get[Option[Long]]("vehicleId") map {      
      case(id ~ ucid ~ vid ) => Staff(id = id, userId = ucid,vehicleId=vid)
    }   
  }
   
  //def saveLibrarian(librarian : Librarian) : Librarian
   val LibrarianSimple = {
    get[Int]("libId") ~
    get[Long]("user_id")  map {      
      case(id ~ uid  ) => Librarian(id = id, user_id = uid)
    }   
  }
   
   
  val studentDetailsSimple = {
    get[Long]("sdId") ~
    get[Long]("user_id") ~
    get[String]("Studentadminno")~
    get[Option[Long]]("vehicleId")  map {      
      case(id ~ ucid ~ stno ~ vhi) => StudentDetail(id = id, user_id = ucid, Studentadminno = stno,vehicleId=vhi)
    } 
  }
  
  val driverDetailsSimple = {
    get[Long]("dId") ~
    get[String]("DLno") ~
    get[Long]("user_id") ~
    get[Int]("vehicleId")  map {      
      case(id ~ dlno ~ uid ~ vid ) => DriverDetail(id = id, DLno = dlno, user_id = uid,vehicleid=vid)
    } 
  }
  
   val driverSimple = {
    get[Long]("dId") ~
    get[String]("DLno") ~
    get[Long]("user_id") ~
    get[Int]("vehicleId")  map {      
      case(id ~ dlno ~ uid ~ vid ) => DriverInfo(id = id, DLno = dlno, user_id = uid,vehicleid=vid)
    } 
  }
      
   val GuardianDetailsSimple = {
    get[Long]("gId") ~
    get[Long]("user_id") ~
    get[String]("relationship") ~
    get[Long]("mobile") ~
    get[String]("income") ~
    get[String]("education") ~
    get[String]("stdadmissionno") map {      
      case(gid ~ ucid ~ rel ~ mob ~ in ~ edu ~ stdadm) => GuardianDetail(id = gid, user_id = ucid, relationship = rel, mobile = mob, income = in, education = edu, stdadmissionno = stdadm)
    }
    
  }
   //authorDetailSimple
   
   val AuthorDetailSimple = {
    get[Int]("id") ~
    get[String]("First_Name") ~
    get[String]("Last_Name") map {      
      case(id ~ fnme ~ lnme  ) => Author(id = id, First_Name = fnme, Last_Name = lnme)
    } 
  }
   
   //id : Int,ISBN : String,Book_title : String,date_of_publication:Date
   val BookSimple = {
    get[Int]("id") ~
    get[String]("ISBN") ~
    get[String]("Book_title") ~
    get[Date]("date_of_publication") ~
    get[Long]("bookCount") ~
    get[Long]("campusId") map {      
      case(id ~ isbn ~ btl ~ dop ~ bokdel ~ cmpid) => Book(id = id, ISBN = isbn, Book_title = btl,date_of_publication=dop.toString(), bookCount = bokdel,campusId=cmpid)
    }
   }
   
   // Medical
   val MedicalSimple = {
    get[Long]("id") ~
    get[Long]("user_id") ~
    get[String]("Bloodgroup") ~
    get[Float]("height") ~
    get[Float]("weight") ~
    get[String]("ailment") ~
    get[String]("Doctorname") ~
    get[String]("Doctor_address") ~
    get[Option[Long]]("Mobile") map {      
      case(id ~ uid ~ bg ~ ht ~ wt ~ ail ~ dnm ~ dadd ~ mob) => Medical(id = id, user_id = uid,Bloodgroup = bg,
          height = ht,weight = wt,ailment = ail,Doctorname=dnm, Doctor_address=dadd, Mobile=mob )
    }
   }
   
   //createEvent
   val EventSimple = {
    get[Int]("eId") ~
    get[Long]("evId") ~
    get[Date]("startDate") ~
    get[Date]("endDate") ~
    get[Long]("studId") ~ 
    get[Long]("campusId") ~
    get[Int]("messageFlag") map {      
      case(id ~ evId ~ sd ~ ed ~ suid ~ cid ~ msg) => Events(id = id,evId=evId ,startDate = sd.toString(), endDate = ed.toString(), studUserId=suid, campusId = cid, messageFlag = msg)
    }
   }
   
   val EventMasterSimple = {
     get[Long]("evId") ~
     get[String]("Name") ~
     get[String]("desc") ~
     get[Long]("campusId") ~
     get[Int]("status")map {      
      case(id ~ nm ~ dsc ~ cid ~ st) => EventsMaster(evId = id,Name=nm ,desc = dsc, campusId = cid, status=st)
     }
   }
   
   val EventUserSimple = {
    get[Int]("eId") ~
    get[Long]("evId") ~
    get[String]("Name") ~
    get[String]("desc") ~
    get[Date]("startDate") ~
    get[Date]("endDate") ~
    get[Long]("studId") ~ 
    get[Long]("campusId") ~
    get[Int]("status") ~
    get[Int]("messageFlag")map {      
      case(id ~ evId ~ nm ~ dsc  ~ sd ~ ed ~ suid ~ cid ~ st ~ msg) => EventsUser(id = id,evId=evId,name=nm,desc=dsc,startDate=sd.toString(),
          endDate=ed.toString(),studUserId=suid,campusId = cid,status = st, messageFlag = msg)
       }
     }
   
   //StdClassTermSimple
   val StdClassTermSimple = {
      get[String]("Studentadminno") ~
      get[String]("Firstname") ~
      get[String]("class_name") ~
      get[String]("term_type") ~
      get[Date]("start_date") ~ 
      get[Date]("end_date") map {
        case(snm ~ fnm ~ cnm ~ tt ~ sd ~ ed) => StdClassTerm(studentAdminNo = snm,studentName = fnm,className = cnm, termTypeName = tt,
            termStartDate = sd.toString(), termEndDate = ed.toString())
      }
   }
   
   val AssignmentUserSimple = {
    get[Int]("id") ~
    get[String]("assignment_name") ~
    get[Long]("max_score") ~
    get[Int]("sequence") ~
    get[Date]("due_date") ~
    get[Date]("remindar_date") ~
    get[Long]("subjectId") ~
    get[String]("subjectName") ~
    get[Long]("classId") ~
    get[String]("class_name") ~
    get[Long]("cmId") ~
    get[String]("campus_name") ~
    get[Long]("oId") ~
    get[String]("name") map {      
      case(id ~ asgnm ~ msc ~ seq ~ ddt ~ rdt ~ subId ~ subNm ~ clsId ~ clsNm ~ cmid ~ cmnm ~ oid ~ onm) => 
        AssignmentUser(id = id, assignment_name = asgnm, max_score = msc,sequence=seq, due_date=ddt.toString(),
            remindar_date=rdt.toString(),subjectId = subId,subjectName = subNm, classId = clsId, class_name = clsNm, cmId = cmid, 
            campus_name = cmnm, oId = oid, name = onm)
    }
   }
   //AssignmentSimple
   val AssignmentSimple = {
    get[Int]("id") ~
    get[String]("assignment_name") ~
    get[Long]("max_score") ~
    get[Int]("sequence") ~
    get[Date]("due_date") ~
    get[Date]("remindar_date") ~
    get[Long]("subjectId") ~
    get[Long]("classId") map {      
      case(id ~ asgnm ~ msc ~ seq ~ ddt ~ rdt ~ subid ~ clsid ) => 
        Assignment(id = id, assignment_name = asgnm, max_score = msc,sequence=seq, due_date=ddt.toString(),
            remindar_date=rdt.toString(), subjectId = subid, classId = clsid)
    }
   }
   
   //BookAuthorSimple
   val BookAuthorSimple = {
      get[Int]("Books_id") ~
      get[Int]("Authors_id") map {      
      case(bid ~ aid  ) => BookAuthor(Books_id = bid, Authors_id = aid)
    }

   }
   
   //BookCategoriesSimple
   val BookCategoriesSimple = {
      get[Int]("Books_id") ~
      get[Int]("Book_Categories_id") map {      
      case(bid ~ cid  ) => BookCategories(Books_id = bid, Book_Categories_id = cid)
      }
   }
   
   //OrganizationDetailsSimple
  val OrganizationDetailsSimple  = {
      get[Int]("oId") ~
      get[String]("name")~
      get[String]("Type")~
      get[Int]("activated")~
      get[Int]("paid")~
      get[Int]("deleted") map {      
      case(id ~ nme ~typ ~act ~pd ~ del  ) => Organization(id=id,name=nme,Type=typ,activated=act,paid=pd,deleted=del)
      }
   }
  
  //vehicle_type
  val VehicleTypeSimple = {
    get[Int]("id") ~
    get[String]("Vehicle_type") map {
      case(id ~ vnm) => VehicleType(id = id,vehicleName = vnm)
    }
  }
  
  //BookCategorySimple
  
  val BookCategorySimple = {
    get[Int]("id") ~
    get[String]("Categories_name") map {
      case(id ~ bcnm) => BokCategories(id = id,Categories_name = bcnm)
    }
  }
    //SchoolSimple

  val SchoolSimple = {    
      get[Int]("id") ~
      get[String]("Photo_file_name") ~
      get[String]("Photo_Content_Type") ~
      get[String]("Photo_file_Size") ~
      get[String]("Photo_data_blob")~
      get[Long]("Campus_ID") ~ 
      get[Int]("holidayId") map {
        case(id ~ pfn ~ pct ~ pfs ~ pdb ~ cid ~ hid) => School(id = id, Photo_file_name = pfn,Photo_Content_Type = pct, Photo_file_Size = pfs, Photo_data_blob= pdb,Campus_ID=cid, holidayId = hid)
      }
  }
   //HolidaySimple

val HolidaySimple = {    
      get[Int]("hId") ~
      get[Date]("holidayDate") ~
      get[String]("holidayName") ~
      get[String]("hoildayDesc") ~
      get[Long]("campusId") ~
      get[Int]("messageFlag")map {
        case(id ~ hd ~ hn ~ hdes ~ cmpid ~ msgFlag) => Holiday(hId = id, holidayDate = hd.toString(),holidayName = hn,
            hoildayDesc = hdes,campusId = cmpid,messageFlag = msgFlag)
      }
   }
   

  override def byId(id: Long): Option[UserDTO] = DB.withConnection { implicit conn =>
    SQL("""
        SELECT
          `u`.`id`,
          `u`.`username`,
          `u`.`first_name`,
          `u`.`last_name`,
          `u`.`nice_name`
        FROM
          `users` `u`
        WHERE
          `u`.`id` = {id}
      """).on('id -> id).using(UserSimple).singleOpt()
  }

  override def byUserName(emailid: String): Option[UserDTO] = DB.withConnection { implicit conn =>
    println(" byUserName UserDAO IMPL Email ID : "+emailid)
    SQL("""
        SELECT
          `user`.`id`,
          `user_login`.`email`,
          `user`.`Firstname`,
          `user`.`MiddleName`,
          `user`.`Lastname`,
          `user`.`DOB`,
          `user`.`Gender`,
          `user`.`Address1`,
          `user`.`Address2`,
          `user`.`City`,
          `user`.`State`,
          `user`.`Deleted`
          FROM
          `user`,`user_login`,`user_context`,`context`
           WHERE
             `user_login`.`email` = {emailid}
           AND `user_login`.`user_id` = `user`.`id`
           AND `user_context`.`user_id` =  `user`.`id`
           AND `context`.`id` = `user_context`.`context_id` 
      """).on('emailid -> emailid).as(UserSimple singleOpt)
    
  }
  
  
  //getContextByUserId
  def getContextByUserId(id : Long) : UserContext =  DB.withConnection { implicit conn =>
      println("UserDAOImpl.getContextByUserId begin ",id)
    val c = SQL("""
    select
     `uc`.`id`,`uc`.`user_id`,`uc`.`context_id`,`uc`.`campus_id` 
      from 
         `user_context` `uc` 
      where 
         `uc`.`user_id`={id} 
        """).on('id -> id).as(UserContextSimple singleOpt).get
      println("UserDAOImpl.getContextByUserId finished")
     c
   }
  
  
  

  override def delete(id: Long): Boolean = DB.withConnection { implicit conn =>
    SQL("""
        DELETE FROM `users` WHERE `id` = {id} 
      """).on('id -> id).executeUpdate() > 0
  }

  def create(username: String, firstName: String, middleName: String, lastName: String, DOB : String,Gender : String, address1 : String, address2 : String, city: String, state : String): UserDTO = {
    val id = DB.withConnection { implicit conn =>

      println("UserDAOImpl.create started")
      val id = SQL("""
      INSERT INTO `user`
        (`Firstname`, `MiddleName`, `Lastname`,`DOB`,`Gender`,`Address1`,`Address2`,`City`,`State`,`Createat`,`Updatedat`,`Deleted`)
      VALUES
        ({Firstname}, {MiddleName}, {Lastname},{DOB},{Gender}, {Address1}, {Address2}, {City}, {State}, {Createat}, {Updatedat}, {Deleted})
      """) on (
        'Firstname -> firstName.toString(),
        'MiddleName -> lastName.toString(),
        'Lastname -> middleName.toString(),
        'DOB -> DOB,
        'Gender -> Gender.toString(),
        'Address1 -> address1.toString(),
        'Address2 -> address2.toString(),
        'City -> city.toString(),
        'State -> state.toString(),
        'Createat -> Calendar.getInstance().getTime(),
        'Updatedat -> Calendar.getInstance().getTime(),
        'Deleted -> 1L
        ) executeInsert (scalar[Long] single)

      id
    }

    DB.withConnection { implicit conn =>
      println("UserDAOImpl.create center")
      val u = (SQL("""
        SELECT
          `u`.`id`,`u`.`Firstname`,      
          `u`.`Firstname`,
          `u`.`MiddleName`, 
          `u`.`Lastname`,
          `u`.`DOB`, 
          `u`.`Gender`,          
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,          
          `u`.`State`,
           `u`.`Deleted`  
        FROM
          `user` `u`
        WHERE
          `u`.`id` = {id}
      """).on('id -> id).as(UserSimple singleOpt)).get
      println("UserDAOImpl.create finished")
      u
    }
  }

  def update(user: UserDTO): Unit = DB.withConnection { implicit conn =>
    SQL("""
      UPDATE `users` SET
        `username` = {username}, `first_name` = {first_name}, `last_name` = {last_name}, `nice_name` = {nice_name}
      WHERE
        `id` = {id}
      """) on (
      'username -> user.username,
      'first_name -> user.firstName,
      'last_name -> user.lastName,
      'nice_name -> user.middleName,
      'id -> user.id) executeUpdate ()
  }
  
  
  def createUserLogin(userLogin: UserLogin) : UserLogin = {
    
    // convert phone numbe string to long   
   
    /*val phString : String = userLogin.phoneNumber.getOrElse("")
    val phLong = phString.toLong
    println(s"phone number in string format : $phString")
    println(s"phone number in long format : $phLong")*/
    
     val ulogId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createUserLogin started")
        
         val ulogId = SQL("""
      INSERT INTO `user_login`
        (`email`, `phone_number`, `verified`,`user_id`)
      VALUES
        ({email}, {phone_number}, {verified}, {user_id})
      """) on (
        'email -> userLogin.email,
        'phone_number -> userLogin.phoneNumber,
        'verified -> userLogin.verified,
        'user_id -> userLogin.userId
        ) executeInsert (scalar[Long] single)

      ulogId       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createUserLogin center")
      val ul = (SQL("""
        SELECT
          `ul`.`ulogId`,   
          `ul`.`email`,
          `ul`.`phone_number`,
          `ul`.`verified`,          
          `ul`.`user_id`          
        FROM
          `user_login` `ul`
        WHERE
          `ul`.`ulogId` = {ulogId}
      """).on('ulogId -> ulogId).as(UserLoginSimple singleOpt)).get
      println("UserDAOImpl.createUserLogin finished")
      ul
    }
    
  }
  
  /**
   *  UserContext
   */
  
   def createUserContext(userContext: UserContext) : UserContext = {
     val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createUserContext started")
        
         val id = SQL("""
      INSERT INTO `user_context`
        (`user_id`, `context_id`, `campus_id`)
      VALUES
        ({user_id}, {context_id}, {campus_id})
      """) on (
        'user_id -> userContext.userId,
        'context_id -> userContext.contextId,
        'campus_id -> userContext.campusId
        ) executeInsert (scalar[Long] single)

      id       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createUserContext center")
      val uc = (SQL("""
        SELECT
          `uc`.`id`,   
          `uc`.`user_id`,
          `uc`.`context_id`,
          `uc`.`campus_id`          
        FROM
          `user_context` `uc`
        WHERE
          `uc`.`id` = {id}
      """).on('id -> id).as(UserContextSimple singleOpt)).get
      println("UserDAOImpl.createUserLogin finished")
      uc
    }
    
  }
   
   
   /*******************/
   
   
   
   
   /**
   *  StaffDetails
   */
  
   def createStaffDetails(staffDetails: StaffDetail) : StaffDetail = {
     val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createStaffDetails started")
        
         val id = SQL("""
      INSERT INTO `staff_details`
        (`user_id`,`vehicleId`)
      VALUES
        ({user_id},{vehicleId})
      """) on (
        
        'user_id -> staffDetails.user_id,
        'vehicleId->staffDetails.vehicleId
        ) executeInsert (scalar[Long] single)

      id       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createStaffDetailst center")
      val sd = (SQL("""
        SELECT
          `sd`.`id`,   
          `sd`.`user_id`,
          `sd`.`vehicleid`       
        FROM
          `staff_details` `sd`
        WHERE
          `sd`.`id` = {id}
      """).on('id -> id).as(StaffDetailsSimple singleOpt)).get
      println("UserDAOImpl.createStaffDetails finished")
      sd
    }
    
  }
   
   /*
    * def saveLibrarian(librarian : Librarian) : Librarian
    */
   
   def saveLibrarian(librarian : Librarian) : Librarian = {
      val libId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createLibrarian started")
        
         val libId = SQL("""
      INSERT INTO `librarian`
        (`user_id`)
      VALUES
        ({user_id})
      """) on (
        
        'user_id -> librarian.user_id
        ) executeInsert (scalar[Long] single)

      libId       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createLibrarian center")
      val libdet = (SQL("""
        SELECT
          `lib`.`libId`,   
          `lib`.`user_id`       
        FROM
          `librarian` `lib`
        WHERE
          `lib`.`libId` = {libId}
      """).on('libId -> libId).as(LibrarianSimple singleOpt)).get
      println("UserDAOImpl.createLibrarian finished")
      libdet
    }
   }
   /*
    * def createStudentDetails(studentDetails : StudentDetail) : StudentDetail
    */
   def createStudentDetails(studentDetails : StudentDetail) : StudentDetail = {
     
     val sdId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createStudentDetails started")
        
         val sdId = SQL("""
      INSERT INTO `Student_Details`
        (`user_id`, `Studentadminno`,`vehicleId`)
      VALUES
        ({user_id}, {Studentadminno},{vehicleId})
      """) on (
         'user_id -> studentDetails.user_id,
        'Studentadminno -> studentDetails.Studentadminno,
        'vehicleId-> studentDetails.vehicleId
        ) executeInsert (scalar[Long] single)

      sdId       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createStudentDetails center")
      val uc = (SQL("""
        SELECT
          `stdDet`.`sdId`,   
          `stdDet`.`user_id`,
          `stdDet`.`Studentadminno`,
          `stdDet`.`vehicleId`
    
        FROM
          `Student_Details` `stdDet`
        WHERE
          `stdDet`.`sdId` = {sdId}
      """).on('sdId -> sdId).as(studentDetailsSimple singleOpt)).get
      println("UserDAOImpl.createStudentDetails finished")
      uc
    }   
     
   }
   
   /**
   *  GuardianDetails
   */
  
   def createGuardianDetails(guardianDetails: GuardianDetail) : GuardianDetail = {
     val gId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createStaffDetails started")
        
         val gId = SQL("""
      INSERT INTO `guardian`
        (`user_id`,`relationship`,`mobile`,`income`,`education`,`stdadmissionno`)
      VALUES
        ({user_id},{relationship},{mobile},{income},{education},{stdadmissionno})
      """) on (
        
        'user_id -> guardianDetails.user_id,
        'relationship -> guardianDetails.relationship,
        'mobile -> guardianDetails.mobile,
        'income -> guardianDetails.income,
        'education -> guardianDetails.education,
        'stdadmissionno -> guardianDetails.stdadmissionno
        ) executeInsert (scalar[Long] single)

      gId       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createguardianDetails center")
      val gd = (SQL("""
        SELECT
          `gd`.`gId`,   
          `gd`.`user_id`,
          `gd`.`relationship`,
          `gd`.`mobile`,   
          `gd`.`income`,
          `gd`.`education`,
          `gd`.`stdadmissionno`       
        FROM
          `guardian` `gd`
        WHERE
          `gd`.`gId` = {gId}
      """).on('gId -> gId).as(GuardianDetailsSimple singleOpt)).get
      println("UserDAOImpl.createguardianDetails finished")
      gd
    }
    
  }
   
   
   /*
    * def viewStaffDetails(staffDetails : StaffDetail) : StaffDetail
    */
   /*def viewStaffDetails(staffDetail: StaffDetail) : StaffDetail = {
     val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createStaffDetails started")
        
        val sd = (SQL("""
        SELECT
          `sd`.`id`,   
          `sd`.`user_id`       
        FROM
          `staff_details` `sd`
        WHERE
          `sd`.`id` = {id}
      """).on('id -> id).as(viewStaffDetailsSimple singleOpt)).get
      println("UserDAOImpl.createStaffDetails finished")
      sd
    }
    
  }*/
   
   
     
   
   def getUserLoginByUserId(userId : Long) : UserLogin = {
     
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getUserLoginByUserId center")
      val ul = (SQL("""
        SELECT
          `ul`.`ulogId`,   
          `ul`.`email`,
          `ul`.`phone_number`,
           `ul`.`verified`,   
          `ul`.`user_id`       
        FROM
          `user_login` `ul`
        WHERE
          `ul`.`user_id` = {userId}
      """).on('userId -> userId).as(UserLoginSimple singleOpt)).get
      println("UserDAOImpl.getUserLoginByUserId finished")
      ul
    }
     
   }
   
   //AttendanceSimple
   
   val AttendanceSimple = {
     
     get[Long]("atdId") ~
     get[Long]("stud_id") ~ 
     get[String]("Studentadminno") ~
     get[Option[String]]("remark") ~
     get[Int]("status") ~
     get[Date]("DOI") ~ 
     get[Date]("updatedon") map {       
       case(id ~ stuid ~ stad ~ pr ~ ab ~ dt ~ upd) => AttendanceList(id=id,stud_id=stuid,Studentadminno=stad,remark=pr,status=ab,
           DOI=dt.toString(),updatedon=upd.toString())
      }      
   }
   
   val AttendanceDOISimple = {
     get[Date]("DOI") ~ 
     get[Date]("updatedon") map {       
       case(dt ~ upd) => AttendanceDOIAndUpdatedOn(DOI=dt,updatedOn=upd)
      }      
   }
   
   val AttendanceUserSimple = {
     
     get[Long]("atdId") ~
     get[Long]("stud_id") ~ 
     get[String]("Studentadminno") ~
     get[String]("Firstname") ~
     get[Option[String]]("remark") ~
     get[Int]("status") ~
     get[Date]("DOI") ~ 
     get[Date]("updatedon") ~
     get[String]("class_name") ~
     get[String]("campus_name") ~
     get[String]("name")map {       
       case(id ~ stuid ~ stad ~ fnm ~ pr ~ ab ~ dt ~ upd ~ clsnm ~ cmpnm ~ orgnm) => AttendanceUser(id=id,stud_id=stuid,Studentadminno=stad,
           Firstname=fnm,remark=pr,status=ab,DOI=dt,updatedon=upd,className=clsnm,campusName=cmpnm,orgName=orgnm)
      }      
   }
   
   val AttendanceCommonSimple = {
     get[Long]("user_id") ~ 
     get[String]("Studentadminno") ~
     get[String]("Firstname") ~
     get[String]("class_name") ~
     get[String]("campus_name") ~
     get[String]("name")map {       
       case(uid ~ stad ~ fnm ~ clsnm ~ cmpnm ~ orgnm) => AttendanceCommon(user_id=uid,Studentadminno=stad,Firstname=fnm,className=clsnm,campusName=cmpnm,orgName=orgnm)
      }      
   }
   
   val StudentUserSimple = {
     
      get[Long]("id") ~
      get[String]("email") ~      
      get[Option[String]]("firstName") ~
      get[Option[String]]("lastName") ~
      get[Option[String]]("middleName") ~
      get[Option[String]]("address1") ~
      get[Option[String]]("address2") ~
      get[Option[String]]("city") ~
      get[Option[String]]("state") ~
      get[Option[Long]]("Deleted") ~
      get[String]("context") ~
      get[Long]("user_id") ~
      get[String]("Studentadminno") ~
      get[Option[Long]]("phone_number") ~
      get[Long] ("class_id") ~
      get[String]("class_name") ~
      get[Long] ("cmId") ~
      get[String]("campus_name") ~
      get[Long]("oId") ~
      get[String]("name") ~
      get[Option[Long]]("vehicleId")map {       
       case(id ~ un ~ fn ~ ln ~ mn ~ ad1 ~ ad2 ~ cty ~ st ~ del ~ ctxt ~ ucid ~ stdno ~ phno ~ clsid ~ clsnm ~ cmpid ~ cmpnm ~ orgid ~ orgnm ~ vid/* ~ ttyp ~ tst ~ tend*/) => 
         StudentUser(id=id,email=un,firstName=fn,lastName=ln,middleName=mn,address1=ad1,address2=ad2,city=cty,state=st,Deleted=del,
             context=ctxt,/*detailsId=dtlid,*/user_id=ucid,Studentadminno=stdno, phoneNumber = phno, class_id = clsid,
             className = clsnm, campusId = cmpid,campusName=cmpnm,orgId=orgid,orgName=orgnm,vehicleId=vid/*,termType = ttyp, termStartDate = tst, termEndDate = tend*/)
      }      
   }
   
   
   //StudentDetailForGuardianSimple
   val StudentDetailForGuardianSimple = {
       
      get[Option[String]]("firstName") ~
      get[Option[String]]("middleName") ~
      get[Option[String]]("lastName") ~
      get[String]("Studentadminno")map {       
       case(fn ~ mn ~ ln ~ stdno) => 
         StudentDetailForGuardian(firstName=fn,middleName=mn,lastName=ln,stdAdmissionNumber=stdno)
      }      
   }
   
   
   //driverUserSimple
   val driverUserSimple = {
     
      get[Long]("dId") ~
      get[String]("email") ~      
      get[Option[String]]("firstName") ~
      get[Option[String]]("lastName") ~
      get[Option[String]]("middleName") ~
      get[Option[String]]("address1") ~
      get[Option[String]]("address2") ~
      get[Option[String]]("city") ~
      get[Option[String]]("state") ~
      get[Option[Long]]("Deleted") ~
      get[String]("context") ~
      get[Long]("user_id") ~
      get[Option[Long]]("phone_number") ~
      get[String] ("DLno") ~
      get[Int]("vehicleId") ~
      get[Long] ("cmId") ~
      get[String]("campus_name") ~
      get[Long]("oId") ~
      get[String]("name")map {       
       case(id ~ un ~ fn ~ ln ~ mn ~ ad1 ~ ad2 ~ cty ~ st ~ del ~ ctxt ~ ucid ~ phno ~ dlno  ~ vid ~ cmpid ~ cmpnm ~ orgid ~ orgnm) => DriverUser(id=id,email=un,firstName=fn,lastName=ln,middleName=mn,address1=ad1,address2=ad2,city=cty,state=st,Deleted=del,context=ctxt,user_id=ucid,phoneNumber = phno,DLno = dlno,vehicleid = vid, campusId = cmpid,campusName=cmpnm,orgId=orgid,orgName=orgnm)
      }      
   }
    val StaffUserSimple = {
     get[Long]("id") ~
     get[String]("email") ~      
     get[Option[String]]("firstName") ~
     get[Option[String]]("lastName") ~
     get[Option[String]]("middleName") ~
     get[Option[String]]("address1") ~
      get[Option[String]]("address2") ~
      get[Option[String]]("city") ~
      get[Option[String]]("state") ~
      get[Option[Long]]("Deleted") ~
      get[String]("context") ~
     /* get[Long]("detailsId") ~*/
      get[Long]("user_id") ~
      get[String]("subjectName") ~
      get[Option[Long]]("phone_number") ~
      get[Long] ("cmId") ~
      get[String]("campus_name") ~
      get[Long]("oId") ~
      get[String]("name") ~
      get[Option[Long]]("vehicleId") map {       
       case(id ~ un ~ fn ~ ln ~ mn ~ ad1 ~ ad2 ~ cty ~ st ~ del ~ ctxt /*~ dtlid*/ ~ ucid ~ subnm ~ phno ~ cmpid ~ cmpnm ~ orgid ~ orgnm ~ vid) => 
         StaffUser(id=id,email=un,firstName=fn,lastName=ln,middleName=mn,address1=ad1,address2=ad2,city=cty,state=st,Deleted=del,context=ctxt,
         /*detailsId=dtlid,*/user_id=ucid,subjectName = subnm, phoneNumber=phno, campusId = cmpid,campusName=cmpnm,orgId=orgid,orgName=orgnm,vehicleId=vid)
      }      
   }
    //CampusAdminUserSimple
    val CampusAdminUserSimple = {
     get[Long]("id") ~
     get[String]("email") ~      
     get[Option[String]]("firstName") ~
     get[Option[String]]("lastName") ~
     get[Option[String]]("middleName") ~
     get[Option[String]]("address1") ~
      get[Option[String]]("address2") ~
      get[Option[String]]("city") ~
      get[Option[String]]("state") ~
      get[Option[Long]]("Deleted") ~
      get[String]("context") ~
      get[Option[Long]]("phone_number") ~
      get[Long] ("cmId") ~
      get[String]("campus_name") ~
      get[Long]("oId") ~
      get[String]("name")map {       
       case(id ~ un ~ fn ~ ln ~ mn ~ ad1 ~ ad2 ~ cty ~ st ~ del ~ ctxt ~ phno ~ cmpid ~ cmpnm ~ orgid ~ orgnm) => 
         CampusAdminUser(id=id,email=un,firstName=fn,lastName=ln,middleName=mn,address1=ad1,address2=ad2,city=cty,state=st,
             Deleted=del,context=ctxt,phoneNumber=phno,campusId = cmpid,campusName=cmpnm,orgId=orgid,orgName=orgnm)
      }      
   }
    
    val StaffUserListSimple = {
     
     get[Long]("id") ~
     get[String]("email") ~      
     get[Option[String]]("firstName") ~
     get[Option[String]]("lastName") ~
     get[Option[String]]("middleName") ~
     get[Option[String]]("address1") ~
      get[Option[String]]("address2") ~
      get[Option[String]]("city") ~
      get[Option[String]]("state") ~
      get[Option[Long]]("Deleted") ~
      get[String]("context") ~
     /* get[Long]("detailsId") ~*/
      get[Long]("user_id") ~
      get[String]("subjectName") ~
      get[Option[Long]]("phone_number") ~
      get[Long] ("id") ~
      get[String]("campus_name") ~
      get[Long]("id") ~
      get[String]("name") ~
      get[Option[Long]]("vehicleId") map {       
       case(id ~ un ~ fn ~ ln ~ mn ~ ad1 ~ ad2 ~ cty ~ st ~ del ~ ctxt /*~ dtlid*/ ~ ucid ~ subnm ~ phno ~  cmpid ~ cmpnm ~ orgid ~ orgnm ~ vid) => 
         StaffUser(id=id,email=un,firstName=fn,lastName=ln,middleName=mn,address1=ad1,address2=ad2,city=cty,state=st,Deleted=del,
             context=ctxt,user_id=ucid,subjectName = subnm, phoneNumber=phno, campusId = cmpid,
             campusName=cmpnm,orgId=orgid,orgName=orgnm,vehicleId=vid)
      }      
   }
    
    //LibrarianUserSimple
    val LibrarianUserSimple = {
     
     get[Long]("libId") ~
     get[String]("email") ~      
     get[Option[String]]("firstName") ~
     get[Option[String]]("lastName") ~
     get[Option[String]]("middleName") ~
     get[Option[String]]("address1") ~
     get[Option[String]]("address2") ~
     get[Option[String]]("city") ~
     get[Option[String]]("state") ~
     get[Option[Long]]("Deleted") ~
     get[String]("context") ~
     get[Long]("user_id") ~
     get[Option[Long]]("phone_number") ~
     get[Long] ("cmId") ~
     get[String]("campus_name") ~
     get[Long]("oId") ~
     get[String]("name") map {       
       case(id ~ un ~ fn ~ ln ~ mn ~ ad1 ~ ad2 ~ cty ~ st ~ del ~ ctxt ~ ucid ~ phno ~ cmpid ~ cmpnm ~ orgid ~ orgnm) => LibrarianUser(id=id,email=un,firstName=fn,lastName=ln,middleName=mn,address1=ad1,address2=ad2,city=cty,state=st,Deleted=del,context=ctxt,user_id=ucid, phoneNumber=phno, campusId = cmpid,campusName=cmpnm,orgId=orgid,orgName=orgnm)
      }      
   }
    
    
    //CreateBookUserSimple
    val CreateBookUserSimple = {
     get[Int]("id") ~
     get[String]("ISBN") ~
     get[String]("Book_title") ~
     get[Date]("date_of_publication") ~
     get[Long]("bookCount") ~
     get[String]("First_Name") ~
     get[String]("Last_Name") ~
     get[Int]("Book_Categories_id") ~
     get[String]("Categories_name") map {       
       case(id ~ isbn ~ bt ~ dp ~ bc ~ fn ~ ln ~ cid ~ cnm) => CreateBookUser(id = id,ISBN = isbn, Book_title = bt,date_of_publication = dp.toString(),bookCount = bc,First_Name = fn, Last_Name = ln,Book_Categories_id = cid,bookCategoriesName = cnm)
    }
    }
    
   val ClassSimple = {
     get[Long]("id") ~
     get[Int]("campus_id") ~
     get[Int]("term_id") ~
     get[String]("class_name") ~
     get[Int]("deleted") map {
       case(id ~ cpid ~ tid ~ cnm ~ del) => Class(id=id, campus_id=cpid, term_id=tid, class_name=cnm, deleted=del)
     }
   }
   
    val CourseSimple = {
     get[Int]("id") ~
     get[String]("course_name") ~
     get[Int]("deleted") ~
     get[Long]("class_id") ~
     get[Int]("course_id") map {
       case(id ~ crnm ~ del ~ cid ~ crid) => Course(id=id, course_name=crnm, deleted=del, class_id=cid, course_id=crid)
     }
   }
   
   val TermSimple = {
     get[Long]("id") ~
     get[Date]("start_date") ~
     get[Date]("end_date") ~
     get[Int]("deleted") ~
     get[Int]("term_type_id") ~
     get[Int]("campus_id") ~
     get[Int]("active") map {
       case(id ~ std ~ endd ~ del ~ ttyp ~ cpid ~ act) => Term(id=id, start_date=std, end_date=endd, deleted=del, term_type_id=ttyp,campus_id=cpid,active=act)
     }
   }
   
   
   
    
    
     val GuardianUserSimple = {
     
      get[Long]("gId") ~
      get[String]("email") ~      
      get[Option[String]]("firstName") ~
      get[Option[String]]("lastName") ~
      get[Option[String]]("middleName") ~
      get[Option[String]]("address1") ~
      get[Option[String]]("address2") ~
      get[Option[String]]("city") ~
      get[Option[String]]("state") ~
      get[Option[Long]]("Deleted") ~
      get[String]("context") ~
      get[Long]("user_id") ~
      get[String]("relationship") ~
      get[Long]("mobile") ~
      get[String]("income") ~
      get[String]("education") ~
      get[String]("stdadmissionno") ~
      get[Long] ("cmId") ~
      get[String]("campus_name") ~
      get[Long]("oId") ~
      get[String]("name") map {       
      case(id ~ un ~ fn ~ ln ~ mn ~ ad1 ~ ad2 ~ cty ~ st ~ del ~ ctxt ~ ucid ~ rel ~ mbl ~ inc ~ edu ~ stdadm ~ cmpid ~ cmpnm ~ orgid ~ orgnm) => 
         GuardianUser(id=id,email=un,firstName=fn,lastName=ln,middleName=mn,address1=ad1,address2=ad2,city=cty,state=st,Deleted=del,context=ctxt,
             user_id=ucid,relationship=rel,mobile=mbl,income=inc,education=edu, stdadmissionno=stdadm, campusId = cmpid,campusName=cmpnm,orgId=orgid,orgName=orgnm)
      }      
   }
     
     
     /*
      * id : Long, 
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
    DLno : String,
    Stop_Name : String,
    fare : String,
    Arival_Mrng : String,
    Departure_Mrng : String,
    Arival_Evng : String,
    Departure_Evng : String
      */
     /* val VehilceDetailUserSimple = {
     
      get[Long]("id") ~
      get[String]("Vehicle_no") ~      
      get[String]("Vehicle_code") ~
      get[Int]("No_of_Seat") ~
      get[Int]("Maximum_capacity") ~
      get[String]("insurance") ~
      get[String]("tax_remitted") ~
      get[String]("permit") ~
      get[String]("status") ~
      get[Int]("Vehicle_type_id") ~
      get[String]("Route_Name") ~
      get[Int]("No_of_Stops") ~
      get[String]("Stop_Name") ~
      get[String]("fare") ~
      get[String]("Arival_Mrng") ~
      get[String]("Departure_Mrng") ~
      get[String]("Arival_Evng") ~
      get[String]("Departure_Evng") map {       
       case(id ~ vno ~ vcd ~ nos ~ mc ~ ins ~ txr ~ per ~ st ~ vtid ~ rnm ~ nstp ~ stnm ~ far ~ am ~ dm ~ ae ~ de) => 
         CreateVehicleDetailUser(id=id, Vehicle_no=vno, Vehicle_code=vcd, No_of_Seat=nos, Maximum_capacity=mc, insurance=ins,
                                 tax_remitted=txr, permit=per, status=st, Vehicle_type_id=vtid, Route_Name=rnm, No_of_Stops=nstp,
                                  Stop_Name=stnm, fare=far, Arival_Mrng=am, Departure_Mrng=dm,  Arival_Evng=ae, Departure_Evng=de)
      }      
   }*/
     
     val VehilceDetailUserSimple = {
     
      get[Long]("vdId") ~
      get[String]("Vehicle_no") ~      
      get[String]("Vehicle_code") ~
      get[Int]("No_of_Seat") ~
      get[Int]("Maximum_capacity") ~
      get[String]("insurance") ~
      get[String]("tax_remitted") ~
      get[String]("permit") ~
      get[String]("status") ~
      get[Int]("Vehicle_type_id") ~
      get[String]("Vehicle_type") ~
      get[Int]("rdId") ~
      get[String]("Route_Name") ~
      get[Long]("campusId") ~
      get[Int]("No_of_Stops") map {       
       case(id ~ vno ~ vcd ~ nos ~ mc ~ ins ~ txr ~ per ~ st ~ vtid ~ vnm ~ rid ~ rnm ~ cid ~ noOfStops ) => 
         CreateVehicleDetailUser(id=id, Vehicle_no=vno, Vehicle_code=vcd, No_of_Seat=nos, Maximum_capacity=mc, insurance=ins,
               tax_remitted=txr, permit=per, status=st, Vehicle_type_id=vtid, vehicleName=vnm, rdId=rid, routeName = rnm, campusId = cid, No_of_Stops = noOfStops)
      }      
   }
     
   def getLibrarianUserByUserId(user_id : Long) : LibrarianUser = DB.withConnection { implicit conn =>
    val libu = (SQL("""
        SELECT DISTINCT
          `lib`.`libId`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `lib`.`user_id`,
          `ul`.`phone_number`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`
        FROM
          `user` `u`,`user_login` `ul`,`campus` `camp`, `user_context` `uc`,`librarian` `lib`,`context` `c`,`organization` `org`
        WHERE
          `lib`.`user_id` = {user_id}
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `uc`.`context_id` = 8
          AND `u`.`id`= `uc`.`user_id`
          AND `ul`.`user_id` = `uc`.`user_id`
          AND `lib`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`

        
     """).on('user_id -> user_id).as(LibrarianUserSimple singleOpt)).get
      println("UserDAOImpl.getLibrarianUserById finished")
      libu
  }
   def getDriverUserByUserId(user_id : Long) : DriverUser = DB.withConnection { implicit conn =>
      val dridl = (SQL("""
         SELECT DISTINCT
          `dridl`.`dId`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,
          `uc`.`user_id`,
          `ul`.`phone_number`,   
          `dridl`.`DLno`,
          `dridl`.`vehicleId`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`
          
        FROM
          `driver_details` `dridl`,`campus` `camp`, `user` `u`,`user_login` `ul`,
          `user_context` `uc`,`context` `c`,`organization` `org`,`vehicle_details` `vdl`
         WHERE
           `dridl`.`user_id` = {user_id}
           AND `camp`.`cmId` = `uc`.`campus_id`
           AND `uc`.`context_id` = 9
           AND `u`.`id`= `uc`.`user_id`
           AND `ul`.`user_id` = `uc`.`user_id`
           AND `dridl`.`user_id` = `uc`.`user_id`
           AND `c`.`id` = `uc`.`context_id`
           AND `camp`.`cmId` = `uc`.`campus_id`
           AND `camp`.`organization_id` = `org`.`oId`
           AND `vdl`.`vdId` = `dridl`.`vehicleId`   
       """).on('user_id -> user_id).as(driverUserSimple singleOpt)).get
         println("\n UserDAOImpl.getDriverUserById finished")
      dridl
      }  

     
     
   def getGuardianUserByUserId(user_id : Long) : GuardianUser ={
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getGuardianUserById center")
      val gdu = (SQL("""
        SELECT
          `gu`.`gId`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `gu`.`user_id`,
          `gu`.`relationship`,
          `gu`.`mobile`,
          `gu`.`income`,
          `gu`.`education`,
          `gu`.`stdadmissionno`,
          `camp`.`cmId`,
          `camp`.campus_name,
          `org`.`oId`,
          `org`.name
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`guardian` `gu`,`context` `c`, `campus` `camp`,`organization` `org`
        WHERE
          `gu`.`user_id`={user_id}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `gu`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.organization_id = `org`.`oId`
          
      """).on('user_id -> user_id).as(GuardianUserSimple singleOpt)).get
      println("UserDAOImpl.getGuardianUserById finished")
      gdu
    } 
  }
   
   def getAllGuardianListByCampusId(cmId : Long) : List[GuardianUser]  = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getAllGuardianListByCampusId started")
      val gdu = (SQL("""
        SELECT
          `gu`.`gId`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `gu`.`user_id`,
          `gu`.`relationship`,
          `gu`.`mobile`,
          `gu`.`income`,
          `gu`.`education`,
          `gu`.`stdadmissionno`,
          `camp`.`cmId`,
          `camp`.campus_name,
          `org`.`oId`,
          `org`.name
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`guardian` `gu`,`context` `c`, `campus` `camp`,`organization` `org`
        WHERE
          `camp`.`cmId`={cmId}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `gu`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.organization_id = `org`.`oId`
          
      """).on('cmId -> cmId).as(GuardianUserSimple *))
      println("UserDAOImpl.getAllGuardianListByCampusId finished")
      gdu
      }
   }
   def getStudentUserByUserId(id : Long) : StudentUser = {
     print(" USER ID : "+id)
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentUserById Started")
      val su = (SQL("""
        SELECT DISTINCT
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,
          `ul`.`user_id`,          
          `sd`.`studentadminno`,
          `ul`.`phone_number`,
          `sc`.`class_id`,
          `cls`.`class_name`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`,
          `sd`.`vehicleId`
          
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`student_details` `sd`,`context` `c`, 
      `class` `cls`,`student_class` `sc`,`campus` `camp`,`organization` `org`,
      `vehicle_details` `vdl`,`user_term` `ut`,`term` `trm`
        WHERE
          `u`.`id`= {id}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND `sc`.`class_id` =`cls`.`id`
          AND `sc`.`user_id` = `u`.`id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`
          AND `sc`.`class_id` = `cls`.`id`
          AND `vdl`.`campusId` = `uc`.`campus_id`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `ut`.`active` = `trm`.`active`
          AND `trm`.`active` = 1         
      """).on('id -> id).as(StudentUserSimple singleOpt)).get
      println("UserDAOImpl.getStudentUserById finished")
      su
    }
     
   }
   
   def getStudentUserListByCampusId(cmId : Long) : List[StudentUser] = DB.withConnection { implicit conn =>
     println(" CampusId : "+cmId)
    SQL("""
       SELECT DISTINCT
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `sd`.`user_id`,
          `sd`.`studentadminno`,
          `ul`.`phone_number`,
          `sc`.`class_id`,
          `cls`.`class_name`,
          `camp`.`cmId`,
          `camp`.campus_name,
          `org`.oId,
          `org`.name,
          `sd`.`vehicleId`
        FROM
          `user` `u`,`user_login` `ul`,`campus` `camp`, `user_context` `uc`,`student_details` `sd`,
           `context` `c`,`student_class` `sc`,`organization` `org`, `class` `cls`,
           `vehicle_details` `vdl`,`user_term` `ut`,`term` `trm`
        WHERE
        `camp`.`cmId` = {cmId}
        AND `camp`.`cmId` = `uc`.`campus_id`
        AND `uc`.`context_id` = 4
        AND `u`.`id`= `uc`.`user_id`
        AND `ul`.`user_id` = `uc`.`user_id`
        AND `sd`.`user_id` = `uc`.`user_id`
        AND `c`.`id` = `uc`.`context_id`
        AND `camp`.`cmId` = `uc`.`campus_id`
        AND `camp`.organization_id = `org`.`oId`
        AND `sc`.`class_id` = `cls`.`id`
        AND `vdl`.`campusId` = `uc`.`campus_id`  
        AND `ut`.`user_id` = `sd`.`user_id`
        AND `ut`.`term_id` = `trm`.`id`
        AND `ut`.`active` = `trm`.`active`
        AND `trm`.`active` = 1
      """).on('cmId -> cmId).as(StudentUserSimple *)
  }
   
   def getStaffUserListByCampusId(cmId : Long) : List[StaffUser] = DB.withConnection { implicit conn =>
    SQL("""
        SELECT DISTINCT
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `sd`.`user_id`,
          `sm`.`subjectName`,
          `ul`.`phone_number`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`,
          `sd`.`vehicleId`
        FROM
          `user` `u`,`user_login` `ul`,`campus` `camp`, `user_context` `uc`,`staff_details` `sd`,`context` `c`,
          `organization` `org`,`vehicle_details` `vdl`,`subject_master` `sm`,`staff_subject_map` `ssm`,`term` `trm`
        WHERE
          `camp`.`cmId` = {cmId}
        AND `trm`.`campus_id` = `camp`.`cmId`
        AND `trm`.`active` = 1
        AND `uc`.`context_id` = 5
        AND `camp`.`cmId` = `uc`.`campus_id`
        AND `u`.`id`= `uc`.`user_id`
        AND `ul`.`user_id` = `uc`.`user_id`
        AND `sd`.`user_id` = `uc`.`user_id`
        AND `c`.`id` = `uc`.`context_id`
        AND `camp`.`cmId` = `uc`.`campus_id`
        AND `camp`.`organization_id` = `org`.`oId`
        AND `vdl`.`campusId` = `uc`.`campus_id`
        AND `ssm`.`userId` = `sd`.`user_id`
        AND `sm`.`subId` = `ssm`.`subId`
        
      """) on ('cmId -> cmId) as (StaffUserListSimple *)
  }
   
   
   def getAllClassesByCampusId(cmId : Long) : List[Class] = DB.withConnection { implicit conn => 
     SQL("""
        SELECT 
           `c`.`id`,
           `c`.`campus_id`,
           `c`.`term_id`,
           `c`.`class_name`,
           `c`.`deleted`,
           `camp`.`campus_name`,
           `camp`.`organization_id`
         FROM
           `class` `c`, `campus` `camp`, `term` `trm`
         WHERE
           `camp`.`cmId` = 1
           AND `camp`.`cmId` = `c`.`campus_id` 
           AND `c`.`term_id` = `trm`.`id`
           AND `trm`.`active` = 1
        """) on('cmId -> cmId) as (ClassSimple *)
   }
   
   
  def getStaffUserByUserId(user_id : Long) : StaffUser = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStaffUserById center")
      val su = (SQL("""
       SELECT 
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `sd`.`user_id`,
          `sm`.`subjectName`,
          `ul`.`phone_number`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`,
          `sd`.`vehicleId`
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`staff_details` `sd`,`context` `c`,`campus` `camp`,`organization` `org`, 
           `subject_master` `sm`,`staff_subject_map` `ssm`, `term` `trm`
        WHERE
          `sd`.`user_id`= {user_id}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `trm`.`campus_id` = `camp`.`cmId`
          AND `trm`.`active` = 1
          AND `camp`.`organization_id` = `org`.`oId`
          AND `ssm`.`userId` = `sd`.`user_id`
          AND `sm`.`subId` = `ssm`.`subId`
             
          
      """).on('user_id -> user_id).as(StaffUserSimple singleOpt)).get
      println("UserDAOImpl.getStaffUserById finished")
      su
    }
    
  }
  
  
  def getFromDBCampusAdminUserById(id : Long) : CampusAdminUser = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getFromDBCampusAdminUserById sta")
      val cau = (SQL("""
        SELECT 
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `ul`.`phone_number`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`context` `c`,`campus` `camp`,`organization` `org` 
        WHERE
           `u`.`id`={id}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `ul`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.organization_id = `org`.`oId`
      """).on('id -> id).as(CampusAdminUserSimple singleOpt)).get
      println("UserDAOImpl.getStaffUserById finished")
      cau
    }
  }
  
  
   
   def getstaffLoginByUserId(user_context : Long) : UserLogin = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getstaffLoginByUserId center")
      val ul = (SQL("""
        SELECT
          `ul`.`ulogId`,   
          `ul`.`email`,
          `ul`.`phone_number`,
          `ul`.`verified`,   
          `ul`.`user_id`       
        FROM
          `user_login` `ul`
        WHERE
          `ul`.`user_id` = {id}
      """).on('id -> user_context).as(UserLoginSimple singleOpt)).get
      println("UserDAOImpl.getstaffLoginByUserId finished")
      ul
    }
   }
   
   
    def getUserContextByUSerId(id : Long) : UserContext = {
      
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getUserContextByUSerId center")
      val uc = (SQL("""
        SELECT
          `uc`.`id`,   
          `uc`.`user_id`,
          `uc`.`context_id`,
          `uc`.`campus_id`          
        FROM
          `user_context` `uc`
        WHERE
          `uc`.`user_id` = {id}
      """).on('id -> id).as(UserContextSimple singleOpt)).get
      println("UserDAOImpl.getUserContextByUSerId finished")
      uc
    }
      
    }
   
   
   
   def getStaffDetailsByUserContextId(user_id : Long) : StaffDetail = {
    
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStaffDetailsByUserContextId center")
      val sd = (SQL("""
        SELECT
          `sd`.`id`,   
          `sd`.`user_id`,
          `sd`.`vehicleId`       
        FROM
          `staff_details` `sd`
        WHERE
          `sd`.`user_id` = {user_id}
      """).on('user_id -> user_id).as(StaffDetailsSimple singleOpt)).get
      println("UserDAOImpl.getStaffDetailsByUserContextId finished")
      sd
    }
     
   }
   
   def getUserById(userId: Long) : UserDTO = DB.withConnection { implicit conn =>
     
    val u= (SQL("""
        SELECT
          `u`.`id`,
          `u`.`Firstname`,      
          `u`.`Firstname`,
          `u`.`MiddleName`,
          `u`.`Lastname`,
          `u`.`DOB`,
          `u`.`Gender`,          
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,          
          `u`.`State`,
          `u`.`Deleted`          
        FROM
          `user` `u`
        WHERE
          `u`.`id` = {id}
      """).on('id -> userId).as(UserSimple singleOpt)).get     
      u
   }
   
   
     
   def getUserLoginByEmail(email : String) : UserLogin = DB.withConnection { implicit conn =>
     
      val ul = (SQL("""
        SELECT
          `ul`.`ulogId`,   
          `ul`.`email`,
          `ul`.`phone_number`,
          `ul`.`verified`,          
          `ul`.`user_id`          
        FROM
          `user_login` `ul`
        WHERE
          `ul`.`email` = {email}
      """).on('email -> email).as(UserLoginSimple singleOpt)).get
      println("UserDAOImpl.getUserLoginByEmail finished")
      ul     
   }
   
    def getUserContextById(id : Long) : UserContext = DB.withConnection { implicit conn =>
      println("UserDAOImpl.createUserContext center")
      val uc = (SQL("""
        SELECT
          `uc`.`id`,   
          `uc`.`user_id`,
          `uc`.`context_id`,
          `uc`.`campus_id`          
        FROM
          `user_context` `uc`
        WHERE
          `uc`.`id` = {id}
      """).on('id -> id).as(UserContextSimple singleOpt)).get
      println("UserDAOImpl.createUserLogin finished")
      uc
    }
   
   def getContextById(id : Long) : Context =  DB.withConnection { implicit conn =>
     
      val c = (SQL("""
        SELECT
          `c`.`id`,   
          `c`.`context`          
        FROM
          `context` `c`
        WHERE
          `c`.`id` = {id}
      """).on('id -> id).as(contextSimple singleOpt)).get
      println("UserDAOImpl.getContextById finished")
      c     
   }
   
   def getStaffDetailById(id : Long) : StaffDetail = DB.withConnection { implicit conn => 
     val sd = (SQL("""
        SELECT
          `sd`.`id`,   
          `sd`.`user_id`,
          `sd`.`vehicleId`       
        FROM
          `staff_details` `sd`
        WHERE
          `sd`.`id` = {id}
      """).on('id -> id).as(StaffDetailsSimple singleOpt)).get
      println("UserDAOImpl.createStaffDetails finished")
      sd
    }
   
    def getStudentDetailsById(sdId : Long) : StudentDetail = DB.withConnection { implicit conn =>
      val uc = (SQL("""
        SELECT
          `stdDet`.`sdId`,   
          `stdDet`.`user_id`,
          `stdDet`.`Studentadminno`,
          `stdDet`.`vehicleId`,
          `stdDet`.`eventId` 
        FROM
          `Student_Details` `stdDet`, `user_term` `ut`,`term` `trm`
        WHERE
          `stdDet`.`sdId` = {sdId}
          AND `stdDet`.`user_id` = `ut`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1
      """).on('sdId -> sdId).as(studentDetailsSimple singleOpt)).get
      uc
    }   
   
   
   
   def getGuardianDetailsById(gId : Long) : GuardianDetail = DB.withConnection { implicit conn =>
      println("UserDAOImpl.createguardianDetails center")
      val gd = (SQL("""
        SELECT
          `gd`.`gId`,   
          `gd`.`user_id`,
          `gd`.`relationship`,
          `gd`.`mobile`,   
          `gd`.`income`,
          `gd`.`education`,
          `gd`.`stdadmissionno`       
        FROM
          `guardian` `gd`
        WHERE
          `gd`.`gId` = {gId}
      """).on('gId -> gId).as(GuardianDetailsSimple singleOpt)).get
      println("UserDAOImpl.createguardianDetails finished")
      gd
    }
   
   
   //Update
   
   /*def updateStaffDetails(id : Long) : StaffDetail = DB.withConnection { implicit conn => 
     val sd = (SQL("""
        SELECT
          `sd`.`id`,   
          `sd`.`user_id`       
        FROM
          `staff_details` `sd`
        WHERE
          `sd`.`user_id` = {user_id}
      """).on('user_id -> id).as(StaffDetailsSimple singleOpt)).get
      println("UserDAOImpl.createStaffDetails finished")
      sd
    }
   def update(staff : StaffDTO): Unit = DB.withConnection { implicit conn =>
    SQL("""
      UPDATE `staff_details` SET
       `user_id` = {user_id}
      WHERE
        `id` = {id}
      """) on (
      'user_id -> staff.user_id,
      'id -> staff.id) executeUpdate ()
  } */
   
   def updateStudentDetails(id : Long) : StudentDetail = DB.withConnection { implicit conn =>
     println("update select student started")
      val uc = (SQL("""
        SELECT
          `stdDet`.`sdId`,   
          `stdDet`.`user_id`,
          `stdDet`.`Studentadminno`,
          `stdDet`.`vehicleId`,
          `stdDet`.`eventId`     
        FROM
          `Student_Details` `stdDet`
        WHERE
          `stdDet`.`user_id` = {user_id}
      """).on('user_id -> id).as(studentDetailsSimple singleOpt)).get
      println("update select student finished")
      uc
      
    }   
   
    def updateSD(student : StudentDetail, id : Long): Unit = DB.withConnection { implicit conn =>
      println("update rocks student")
    val Studentadminno="reg1897"
    val res = SQL("""
      UPDATE `student_details` SET
       `Studentadminno` = {Studentadminno}
      WHERE
        `user_id` = {user_id}
      """) on (
       'Studentadminno -> Studentadminno,
      'user_id -> id) executeUpdate ()
      println(res,"update rocks finished",Studentadminno)
  } 
   /*
    * 
    */
   
  /* def updateGuardianDetails(id : Long ) : GuardianDetail =  DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateguardianDetails center")
      val gd = (SQL("""
        SELECT
          `gd`.`id`,   
          `gd`.`user_id`,
          `gd`.`relationship`,
           `gd`.`mobile`,   
          `gd`.`income`,
          `gd`.`education`       
        FROM
          `guardian` `gd`
        WHERE
          `gd`.`user_id` = {user_id}
      """).on('user_id -> id).as(GuardianDetailsSimple singleOpt)).get
      println("UserDAOImpl.updateguardianDetails finished")
      gd
    }
    def updateGD(guardian : GuardianDetail, id : Long): GuardianDetail = DB.withConnection { implicit conn =>
      println(" Update Rocks")
       var relationship : String = "Mother"
      var  mobile : Long = 7406
      var income : String = "one rupees"
      var education : String = "Faraan Rocks"

     println("updateguardianDetails last")
    SQL("""
      UPDATE `guardian` SET
       `relationship` = {relationship},
       `mobile` = {mobile},
       `income` = {income},
       `education` = {education}
      WHERE
        `user_id` = {user_id}
      """) on (
          'relationship -> guardian.relationship,
          'mobile-> guardian.mobile,
          'income -> guardian.income,
          'education -> guardian.education,
          'user_id -> id)executeUpdate ()
  }
    */
    
    def deleteUserDetailsById(id : Long) : StudentDetail = DB.withConnection { implicit conn =>
      println("UserDAOImpl.deleteStudentDetailDetailsById center")
      val sd = (SQL("""
        SELECT
          `sd`.`id`,   
          `sd`.`user_id`,
          `sd`.`Studentadminno`      
        FROM
          `student_details` `sd`
        WHERE
          `sd`.`user_id` = {user_id}
      """).on('user_id -> id).as(studentDetailsSimple singleOpt)).get
      println("UserDAOImpl.deleteStudentDetailDetailsById finished")
      sd
    }
    
       
     override def deleteUD(studentDetail : StudentDetail, id : Long) : Unit = DB.withConnection { implicit conn =>
       println("UserDAOImpl.delete Rocks Begin")
      val res = SQL("""
        DELETE FROM `student_details` WHERE `user_id` = {user_id} 
      """).on('user_id -> id).executeUpdate() > 0
      println(res,"UserDAOImpl.delete Rocks End")
  }
     
  def getStdDetailByStdAdmissionNumber(Studentadminno : String) : Option[StudentDetail] = DB.withConnection { implicit  conn => 
    println("UserDAOImpl.getStdDetailByStdAdmissionNumber Started : "+Studentadminno)
      val sd = (SQL("""
       SELECT
          `stdDet`.`sdId`,   
          `stdDet`.`user_id`,
          `stdDet`.`Studentadminno`,
          `stdDet`.`vehicleId`,
          `stdDet`.`eventId` 
        FROM
          `Student_Details` `stdDet`, `user_term` `ut`,`term` `trm`
        WHERE
          `stdDet`.`Studentadminno` = {Studentadminno}
          AND `stdDet`.`user_id` = `ut`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active`=1
      """).on('Studentadminno -> Studentadminno).as(studentDetailsSimple singleOpt))
      println("UserDAOImpl.getStdDetailByStdAdmissionNumber Rock finished")
      sd
  }
  
  
  
  def createStuGuarMapping(student_Guardian_MappingDetails : Student_Guardian_Mapping) : Student_Guardian_Mapping = {
    
    val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createStuGuarMapping started")
        
         val id = SQL("""
      INSERT INTO `student_guardian_mapping`
        (`gid`, `stdadmissionno`, `user_id`)
      VALUES
        ({gid}, {stdadmissionno}, {user_id})
      """) on (
        'gid -> student_Guardian_MappingDetails.gid,
        'stdadmissionno -> student_Guardian_MappingDetails.stdadmissionno,
        'user_id -> student_Guardian_MappingDetails.user_id
        ) executeInsert (scalar[Long] single)

      id       
     }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.createStuGuarMapping center")
      val sgm = (SQL("""
        SELECT
          `sgm`.`id`,   
          `sgm`.`gid`,
          `sgm`.`stdadmissionno`,        
          `sgm`.`user_id`          
        FROM
          `student_guardian_mapping` `sgm`
        WHERE
          `sgm`.`id` = {id}
      """).on('id -> id).as(CreateStuGuarMapping singleOpt)).get
      println("UserDAOImpl.createStuGuarMapping finished")
      sgm
    }
  }
  
  def getTermType() : List[TermType] = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createTermType started")
        val ttyp = (SQL("""
        SELECT
          `ttyp`.`id`,   
          `ttyp`.`term_type`          
        FROM
          `term_type` `ttyp`
        
      """).as(CreateTermType *))
      println("UserDAOImpl.createTermType finished")
      ttyp
    }
  
  
  
  def getClassById(id : Long) : Class = DB.withConnection { implicit  conn => 
    println("UserDAOImpl.getClassById Started")
      val cls = (SQL("""
        SELECT
          `cls`.`id`,   
          `cls`.`campus_id`,
          `cls`.`term_id`,
          `cls`.`class_name`,
          `cls`.`deleted`
        FROM
          `Class` `cls`
        WHERE
          `cls`.`id` = {id}
      """).on('id -> id).as(ClassSimple singleOpt)).get
      println("UserDAOImpl.getClassById Rock finished")
      cls
    
  }
  
  def getTermDetails(termTypeId : Long) : Term = DB.withConnection { implicit  conn => 
    println("UserDAOImpl.getTermDetails Started")
      val trm = (SQL("""
        SELECT
          `trm`.`id`,   
          `trm`.`start_date`,
          `trm`.`end_date`,
          `trm`.`deleted`,
          `trm`.`term_type_id`,
          `trm`.`campus_id`,
          `trm`.`active`
        FROM
          `term` `trm`
        WHERE
          `trm`.`term_type_id` = {term_type_id}
      """).on('term_type_id -> termTypeId).as(TermSimple singleOpt)).get
      println("UserDAOImpl.getTermDetails Rock finished")
      trm 
     }
  
  
  def insertStudentClassMap(studentClassMap : StudentClassMapping) : StudentClassMapping = {
    
    val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.insertStudentClassMap started")
        
         val id = SQL("""
      INSERT INTO `student_class`
        (`user_id`,`class_id`)
      VALUES
        ({user_id},{class_id})
      """) on (
        'user_id -> studentClassMap.user_id,
        'class_id -> studentClassMap.class_id) executeInsert (scalar[Long] single)
      id       
     }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.insertStudentClassMap center")
      val sgm = (SQL("""
        SELECT
          `stdcls`.`id`,   
          `stdcls`.`user_id`,
          `stdcls`.`class_id`         
        FROM
          `student_class` `stdcls`
        WHERE
          `stdcls`.`id` = {id}
      """).on('id -> id).as(insertStudentClassMap singleOpt)).get
      println("UserDAOImpl.insertStudentClassMap finished")
      sgm
    }
  }
  
  
  def saveUserTermDetails(userTermDetails : UserTerm) : UserTerm = {
    val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.getUserTermDetails started")
        
         val id = SQL("""
      INSERT INTO `user_term`
        (`user_id`,`term_id`,`active`,`deleted`)
      VALUES
        ({user_id},{term_id},{active},{deleted})
      """) on (
        'id -> userTermDetails.id,
        'user_id -> userTermDetails.user_id,
        'term_id -> userTermDetails.term_id,
        'active -> userTermDetails.active,
        'deleted -> userTermDetails.deleted
        ) executeInsert (scalar[Long] single)

      id       
     }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getUserTermDetails center")
      val ut = (SQL("""
        SELECT
          `ut`.`id`,   
          `ut`.`user_id`,
          `ut`.`term_id`,
          `ut`.`active`,
          `ut`.`deleted`          
        FROM
          `user_term` `ut`
        WHERE
          `ut`.`id` = {id}
      """).on('id -> id).as(CreateUserTerm singleOpt)).get
      println("UserDAOImpl.getUserTermDetails finished")
      ut
    }
  }
    //getStudentListByClassId
  def getStudentListByClassId(class_id:Long) : List[StudentUser] = DB.withConnection { implicit  conn => 
    println("UserDAOImpl.getStudentListByClassId Started : "+class_id)
       val adlst = (SQL("""
         SELECT DISTINCT
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `sd`.`user_id`,
          `sd`.`studentadminno`,
          `ul`.`phone_number`,
          `sc`.`class_id`,
          `cls`.`class_name`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`,
          `sd`.`vehicleId`
          
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`student_details` `sd`,
          `context` `c`, `class` `cls`,`student_class` `sc`,`campus` `camp`,`organization` `org`,
          `vehicle_details` `vdl`,`user_term` `ut`,`term` `trm`
        WHERE
          `sc`.`class_id`= {class_id}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND  `sc`.`class_id` =`cls`.`id`
          AND `sc`.`user_id` = `u`.`id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1
          
      """).on('class_id -> class_id).as(StudentUserSimple *))
      println("UserDAOImpl.getStudentListByClassId finished")
      adlst
     }
   //createStudentAttendence1(attendanceList:AttendanceList):
   
    def createStudentAttendence(attendance : AttendanceList) : AttendanceList = DB.withConnection { implicit  conn =>
    
    val atdId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createStudentAttendenceList started")
        
        SQL("""
      INSERT INTO `attendence`
        (`stud_id`,`Studentadminno`,`remark`,`status`,`DOI`,`updatedon`)
      VALUES
        ({stud_id},{Studentadminno},{remark},{status},{DOI},{updatedon})
      """) on (
        'stud_id ->attendance.stud_id,
        'Studentadminno -> attendance.Studentadminno,
        'remark->attendance.remark,
        'status->attendance.status,
        'DOI->Calendar.getInstance().getTime(),
        'updatedon-> Calendar.getInstance().getTime()) executeInsert (scalar[Long] single)
  
     }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.createStudentAttendenceList center")
      val sgm = (SQL("""
        SELECT
          `attend`.`atdId`,   
          `attend`.`stud_id`,
          `attend`.`Studentadminno`,
          `attend`.`remark`,
          `attend`.`status` ,
          `attend`.`DOI`,
          `attend`.`updatedon`           
        FROM
          `attendence` `attend`
         WHERE
           `attend`.`atdId` = {atdId}
          """).on('atdId -> atdId).as(AttendanceSimple singleOpt)).get
          println("UserDAOImpl.createStudentAttendenceList finished")
          sgm
    }
  }
    def getStudentAttendenceCommonListByClassId(id : Long) : List[AttendanceCommon] = {
       DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentAttendenceListByClassId center")
      val adlist = (SQL("""
        SELECT   
          `sc`.`user_id`,
          `std_detail`.`studentadminno`,
          `u`.`Firstname`,
          `cls`.`class_name`,
          `camp`.`campus_name`,
          `org`.`name`           
        FROM
          `class` `cls`,`campus` `camp`,`organization` `org`,`student_class` `sc`,
          `user` `u`,`student_details` `std_detail`,`user_term` `ut`,`term` `trm`
         WHERE
           `cls`.`id` = 1
           AND `cls`.`campus_id` = `camp`.`cmId`
           AND `camp`.`organization_id` = `org`.`oId`
           AND `sc`.`class_id` = `cls`.`id` 
           AND `u`.`id` = `sc`.`user_id`
           AND `sc`.`user_id` = `std_detail`.`user_id`
           AND `std_detail`.`user_id` = `ut`.`user_id`
           AND `ut`.`term_id` = `trm`.`id`
           AND `trm`.`active`=1
          """).on('id -> id).as(AttendanceCommonSimple *))
          println("UserDAOImpl.getStudentAttendenceListByClassId finished")
          adlist
    }
    }
    
  def getCourseById(id : Long) : Course = DB.withConnection { implicit conn =>
      println("UserDAOImpl.getCourseById Started")
      val cur = (SQL("""
        SELECT
          `cur`.`id`,   
          `cur`.`course_name`,
          `cur`.`deleted`,
          `cur`.`class_id`,
          `cur`.`course_id`          
        FROM
          `course` `cur`
        WHERE
          `cur`.`id` = {id}
      """).on('id -> id).as(CourseSimple singleOpt)).get
      println("UserDAOImpl.getCourseById finished")
      cur
    }

def saveCourseStaff(courseStaffDetails : CourseStaffMapping) : CourseStaffMapping  = {
    val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.saveCourseStaff started")
        
         val id = SQL("""
      INSERT INTO `course_staff`
        (`role_name`,`course_id`,`user_id`)
      VALUES
        ({role_name},{course_id},{user_id})
      """) on (
        'id -> courseStaffDetails.id,
        'role_name -> courseStaffDetails.role_name,
        'course_id -> courseStaffDetails.course_id,
        'user_id -> courseStaffDetails.user_id
        ) executeInsert (scalar[Long] single)

      id       
     }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.saveCourseStaff center")
      val curstf = (SQL("""
        SELECT
          `curstf`.`id`,   
          `curstf`.`role_name`,
          `curstf`.`course_id`,
          `curstf`.`user_id`          
        FROM
          `course_staff` `curstf`
        WHERE
          `curstf`.`id` = {id}
      """).on('id -> id).as(CreateCourseStaff singleOpt)).get
      println("UserDAOImpl.saveCourseStaff finished")
      curstf
    }
  }

val CreateCourseStaff = {
    get[Long]("id") ~
    get[String]("role_name") ~
    get[Int]("course_id") ~
    get[Long]("user_id")  map {      
      case(id ~ rol ~ cid ~ uid ) => CourseStaffMapping(id = id, role_name = rol, course_id = cid, user_id = uid)
    } 
  }



def createAttendence(AttendenceDetails : AttendanceList) : AttendanceList = {
    val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createAttendence started")
        
         val id = SQL("""
      INSERT INTO `attendence`
        (`stud_id`,`remark`,`status`,`DOI`,`updatedon`)
      VALUES
        ({stud_id},{remark},{status},{DOI},{updatedon})
      """) on (
        'id -> AttendenceDetails.id,
        'stud_id -> AttendenceDetails.stud_id,
        'remark -> AttendenceDetails.remark,
        'status -> AttendenceDetails.status,
        'DOI -> AttendenceDetails.DOI,
        'updatedon -> AttendenceDetails.updatedon
        ) executeInsert (scalar[Long] single)
      id       
     }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.createAttendence center")
      val attend = (SQL("""
        SELECT
          `attend`.`id`,   
          `attend`.`stud_id`,
          `attend`.`remark`,
          `attend`.`status`
          `attend`.`DOI`,
          `attend`.`updatedon`          
          
        FROM
          `attendence` `attend`
        WHERE
          `attend`.`id` = {id}
      """).on('id -> id).as(AttendanceSimple singleOpt)).get
      println("UserDAOImpl.saveCourseStaff finished")
      attend
    }
}

/*
 * get[Long]("id") ~
      get[String]("email") ~      
      get[Option[String]]("firstName") ~
      get[Option[String]]("lastName") ~
      get[Option[String]]("middleName") ~
      get[Option[String]]("address1") ~
      get[Option[String]]("address2") ~
      get[Option[String]]("city") ~
      get[Option[String]]("state") ~
      get[Option[Long]]("Deleted") ~
      get[String]("context") ~
      get[Long]("user_id") ~
      get[String]("Studentadminno") ~
      get[Option[Long]]("phone_number") ~
      get[Long] ("class_id") ~
      get[String]("class_name") ~
      get[Long] ("cmId") ~
      get[String]("campus_name") ~
      get[Long]("oId") ~
      get[String]("name") ~
      get[Int]("vdId")
 */
    
    def getStudentUserByFirstname(Firstname : String) : StudentUser =  {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentUserByFirstname center")
      val su = (SQL("""
        SELECT DISTINCT
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `sd`.`user_id`,
          `sd`.`studentadminno`,
          `ul`.`phone_number`,
          `sc`.`class_id`,
          `cls`.`class_name`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`,
          `sd`.`vehicleId`
          
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`student_details` `sd`,`context` `c`, `class` `cls`,`student_class` `sc`,
          `campus` `camp`,`organization` `org`,`vehicle_details` `vdl`,`user_term` `ut`,`term` `trm`
        WHERE
          `u`.`Firstname`={Firstname}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND  `sc`.`class_id` =`cls`.`id`
          AND `sc`.`user_id` = `u`.`id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1
          
      """).on('Firstname -> Firstname).as(StudentUserSimple singleOpt)).get
      println("UserDAOImpl.getStudentUserByFirstname finished")
      su
    }  
   }
    
    
    def getStdAdmNumbers(fathername : String) : Student_Guardian_Mapping = {
      
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStdAdmNumbers center")
      val su = (SQL("""
        SELECT DISTINCT
          `sgm`.`id`,
          `sgm`.`gid`,
          `sgm`.`stdadmissionno`,
          `sgm`.`user_id`
          
        FROM
          `student_guardian_mapping` `sgm`, `user` `u`
        WHERE
          `u`.`Firstname`={fathername}
          AND `sgm`.`user_id` = `u`.`id`
          
      """).on('fathername -> fathername).as(CreateStuGuarMapping singleOpt)).get
      println("UserDAOImpl.getStdAdmNumbers finished")
      su
    }  
   
    }
    
    
     def getVehicleListByCampusId(cmId : Long) :  List[CreateVehicleDetailUser] = {
      print("\n Campus ID : "+cmId)
      DB.withConnection { implicit conn =>
      println("\n UserDAOImpl.getVehicleListByCampusId Start")
      val vdl = (SQL("""
        SELECT DISTINCT
          `vdl`.`vdId`,
          `vdl`.`Vehicle_no`,
          `vdl`.`Vehicle_code`,
          `vdl`.`No_of_Seat`,
          `vdl`.`Maximum_capacity`,
          `vdl`.`insurance`,
          `vdl`.`tax_remitted`,
          `vdl`.`permit`,
          `vdl`.`status`,
          `vdl`.`Vehicle_type_id`,
          `vtyp`.`Vehicle_type`,
          `rtd`.`rdId`,
          `rtd`.`Route_Name`,
          `vdl`.`campusId`,
          `rtd`.`No_of_Stops`
          
        FROM
          `vehicle_details` `vdl`,`campus` `cmp`,`vehicle_type` `vtyp`,`route_details` `rtd`
        WHERE
    		  `cmp`.`cmId`={cmId}
          AND `cmp`.`cmId`=`vdl`.`campusId`
          AND `rtd`.`Vehicle_id` =  `vdl`.`vdId`
      """).on('cmId -> cmId).as(VehilceDetailUserSimple *))
      println("\n UserDAOImpl.getVehicleListByCampusId finished")
      vdl
      }  
    }
    
     
     def getVehicleListByCampusIdDriverId(cmId : Long,dId : Long) :  List[VehicleDetail] = {
      print("\n Campus ID : "+cmId)
      DB.withConnection { implicit conn =>
      println("\n UserDAOImpl.getVehicleListByCampusIdDriverId Start")
      val vdl = (SQL("""
        SELECT DISTINCT
          `vdl`.`vdId`,
          `vdl`.`Vehicle_no`,
          `vdl`.`Vehicle_code`,
          `vdl`.`No_of_Seat`,
          `vdl`.`Maximum_capacity`,
          `vdl`.`insurance`,
          `vdl`.`tax_remitted`,
          `vdl`.`permit`,
          `vdl`.`status`,
          `vdl`.`Vehicle_type_id`,
          `vdl`.`campusId`
          
        FROM
          `vehicle_details` `vdl`,`campus` `cmp`,`driver_details` `dri`
        WHERE
          `cmp`.`cmId`={cmId}
           
           AND `dri`.`dId`={dId}
           AND `vdl`.`campusId` = `cmp`.`cmId`
           AND `dri`.`vehicleId` = `vdl`.`vdId`
      """).on('cmId -> cmId,'dId -> dId).as(CreateVehicleDetails *))
      println("\n UserDAOImpl.getVehicleListByCampusIdDriverId finished")
      vdl
      }  
    }
     
     
    def getDriverListByCampusId(cmId : Long) : List[DriverUser] = {
      print("\n Campus ID : "+cmId)
      DB.withConnection { implicit conn =>
      println("\n UserDAOImpl.getDriverListByCampusId Start")
      val vdl = (SQL("""
         SELECT DISTINCT
          `dridl`.`dId`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,
          `uc`.`user_id`,
          `ul`.`phone_number`,   
          `dridl`.`DLno`,
          `dridl`.`vehicleid`,
          `camp`.`cmId`,
          `camp`.campus_name,
          `org`.`oId`,
          `org`.name
          
        FROM
          `driver_details` `dridl`,`campus` `camp`, `user` `u`,`user_login` `ul`,`user_context` `uc`,`context` `c`,`organization` `org`
         WHERE
           `camp`.`cmId` = {cmId}
        AND `camp`.`cmId` = `uc`.`campus_id`
        AND `uc`.`context_id` = 9
        AND `u`.`id`= `uc`.`user_id`
        AND `ul`.`user_id` = `uc`.`user_id`
        AND `dridl`.`user_id` = `uc`.`user_id`
        AND `c`.`id` = `uc`.`context_id`
        AND `camp`.`cmId` = `uc`.`campus_id`
        AND `camp`.organization_id = `org`.`oId`   
      """).on('cmId -> cmId).as(driverUserSimple *))
      println("\n UserDAOImpl.getDriverListByCampusId finished")
      vdl
      }  
    }
    
    def byEmail(email : String) : Option[UserLogin] = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getVehicledetails Start")
      val ul = (SQL("""
        SELECT 
          *
        FROM
          `user_login` `ul`
        WHERE
          `ul`.`email`={email} 
      """).on('email -> email).as(UserLoginSimple singleOpt))
      println("UserDAOImpl.getVehicledetails finished")
      ul
      }  
    }
    
    def getValidPasswordResetKey(userId: Long): Option[String] = DB.withConnection { implicit conn =>
    val hours = current.configuration.getString("resetLinkValidHours").get
    println(" HOURS : "+hours)
    SQL("""
         DELETE FROM `resetkeys` WHERE `created` < DATE_SUB(CURDATE(), INTERVAL {hours} HOUR)
      """).on{'hours -> hours}.execute()
      println(" DELETED OVER")
    SQL("""
      SELECT `key` FROM `resetkeys` WHERE `user_id`={user_id}
      """).on('user_id -> userId).using(SqlParser.str("key")).singleOpt
  }
    
    override def savePasswordResetKey(userId: Long, key: String): Unit = DB.withConnection { implicit conn =>
    SQL("""
      INSERT INTO `resetkeys` (`user_id`, `key`) VALUES ({user_id}, {key})
      """).on('user_id -> userId, 'key -> key).executeInsert()
  }
    
  override def getUserByResetKey(key: String): Option[UserLogin] = DB.withConnection { implicit conn =>
                  SQL("""
                  SELECT
                  `user_id`
                  FROM
                  `resetkeys`
                  WHERE
                  `key` = {key}
                  """).on('key -> key).using(SqlParser.long("user_id")).singleOpt.flatMap { id =>
                  byUserId(id)
              }
     }
  def byUserId(ulogId: Long): Option[UserLogin] = DB.withConnection { implicit conn =>
    SQL("""
      SELECT
        *
      FROM
        `user_login`
      WHERE
        `ulogId` = {ulogId}
    """).on('ulogId -> ulogId).as(UserLoginSimple singleOpt)
  }
  
  
  override def saveRestPassword(userId : Long,key : String) : Unit = DB.withConnection { implicit conn =>
    println(" ======================================================================== ")
    println(" USER CHECK : "+userId)
    var password = BCrypt.hashpw(key, BCrypt.gensalt(16))
    println(" Start DAO IMPL Key : "+key)
    password = password.toString()
    SQL("""
      UPDATE `user` SET
      `password` = {password}
      WHERE
        `id` = {id}
      """) on (
       'password -> password,
      'id -> userId) executeUpdate ()
      println(" End DAO IMPL hashedValue ")
  }
  
  
  def changePassword(userId : Long,newpassword : String) : Unit = DB.withConnection { implicit conn =>
    println(" Change Password Begins : "+newpassword)
    var password = BCrypt.hashpw(newpassword, BCrypt.gensalt(16))
    password = password.toString()
    println(" USER ID : "+userId)
    SQL("""
      UPDATE `user` SET
      `password` = {password}
      WHERE
        `id` = {id}
      """) on (
       'password -> password,
       'id -> userId) executeUpdate ()
      println(" Change Password hashedValue Rocks ")
  }
  
  
  def getStudentClassMapListByClassId(classId : Long) : List[StudentClassMapping] = DB.withConnection { implicit conn =>
    println(" CLass ID : "+classId)
      println(" getStudentClassMapListByClassId Start")
     SQL("""
        SELECT
          `stdcls`.`id`,   
          `stdcls`.`user_id`,
          `stdcls`.`class_id`         
        FROM
          `student_class` `stdcls`,`user_term` `ut`,`term` `trm`
        WHERE
          `stdcls`.`class_id`={class_id} 
          AND `stdcls`.`user_id` = `ut`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active`=1
          
      """).on('class_id -> classId).as(insertStudentClassMap *)
     
      
      }  
  
  
  def createDriverDetails(driverDetails : DriverDetail) : DriverDetail = {
    val dId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createDriverDetails started")
        
         val dId = SQL("""
      INSERT INTO `driver_details`
        (`DLno`,`user_id`, `vehicleId`)
      VALUES
        ({DLno},{user_id}, {vehicleId})
      """) on (
         'DLno -> driverDetails.DLno,
        'user_id -> driverDetails.user_id,
        'vehicleId -> driverDetails.vehicleid
        ) executeInsert (scalar[Long] single)

      dId       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createDriverDetails center")
      val dd = (SQL("""
        SELECT
          `driDet`.`dId`,   
          `driDet`.`DLno`,
          `driDet`.`user_id`,
          `driDet`.`vehicleId`     
        FROM
          `driver_details` `driDet`
        WHERE
          `driDet`.`dId` = {dId}
      """).on('dId -> dId).as(driverDetailsSimple singleOpt)).get
      println("UserDAOImpl.createDriverDetails finished")
      dd
    }   

  }
  
  
  def createVehicleDetails(vdetails : VehicleDetail) : VehicleDetail = {
    val vdId : Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.Create Vehicle Details started")
        
         val vdId = SQL("""
      INSERT INTO `vehicle_details`
        (`Vehicle_no`,`Vehicle_code`, `No_of_Seat`, `Maximum_capacity`, `insurance`, `tax_remitted`, `permit`, `status`, `Vehicle_type_id`,`campusId`)
      VALUES
        ({Vehicle_no},{Vehicle_code}, {No_of_Seat}, {Maximum_capacity}, {insurance}, {tax_remitted}, {permit}, {status}, {Vehicle_type_id},{campusId})
      """) on (
         'Vehicle_no -> vdetails.Vehicle_no,
        'Vehicle_code -> vdetails.Vehicle_code,
        'No_of_Seat -> vdetails.No_of_Seat,
        'Maximum_capacity -> vdetails.Maximum_capacity,
        'insurance -> vdetails.insurance,
        'tax_remitted -> vdetails.tax_remitted,
        'permit -> vdetails.permit,
        'status -> vdetails.status,
        'Vehicle_type_id -> vdetails.Vehicle_type_id,
        'campusId -> vdetails.campusId
        ) executeInsert (scalar[Long] single)

      vdId       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.Create Vehicle Details center : "+vdId)
      val vd = (SQL("""
        SELECT
          `vdet`.`vdId`,   
          `vdet`.`Vehicle_no`,
          `vdet`.`Vehicle_code`,
          `vdet`.`No_of_Seat`,
          `vdet`.`Maximum_capacity`,   
          `vdet`.`insurance`,
          `vdet`.`tax_remitted`,
          `vdet`.`permit`,
          `vdet`.`status`,
          `vdet`.`Vehicle_type_id`,
          `vdet`.`campusId`
        FROM
          `vehicle_details` `vdet`
        WHERE
          `vdet`.`vdId` = {vdId}
      """).on('vdId -> vdId).as(CreateVehicleDetails singleOpt)).get
      println("UserDAOImpl.Create Vehicle Details finished")
      vd
    }   

  }

  def createRouteDetails(routeDetails : RouteDetail) : RouteDetail = {
    val rdId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.Create Route Detail started")
        
         val rdId = SQL("""
      INSERT INTO `route_details`
        (`Route_Name`,`No_of_Stops`, `Vehicle_id`)
      VALUES
        ({Route_Name},{No_of_Stops}, {Vehicle_id})
      """) on (
         'Route_Name -> routeDetails.Route_Name,
        'No_of_Stops -> routeDetails.No_of_Stops,
        'Vehicle_id -> routeDetails.Vehicle_id
        ) executeInsert (scalar[Long] single)

      rdId       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.Create Route Detail center")
      val rdet = (SQL("""
        SELECT
          `rdet`.`rdId`,   
          `rdet`.`Route_Name`,
          `rdet`.`No_of_Stops`,
          `rdet`.`Vehicle_id`
        FROM
          `route_details` `rdet`
        WHERE
          `rdet`.`rdId` = {rdId}
      """).on('rdId -> rdId).as(CreateRouteDetail singleOpt)).get
      println("UserDAOImpl.Create Route Detail finished")
      rdet
    }   

  }
  
  def createStopDetail(stopDetail : StopDetail) : StopDetail = {
    val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.Create Stop Detail started")
        
         val id = SQL("""
      INSERT INTO `stop_details`
        (`Stop_Name`,`fare`, `Arival_Mrng`, `Departure_Mrng`, `Arival_Evng`, `Departure_Evng`, `Route_details_id`)
      VALUES
        ({Stop_Name},{fare}, {Arival_Mrng}, {Departure_Mrng}, {Arival_Evng}, {Departure_Evng}, {Route_details_id})
      """) on (
         'Stop_Name -> stopDetail.Stop_Name,
        'fare -> stopDetail.fare,
        'Arival_Mrng -> stopDetail.Arival_Mrng,
        'Departure_Mrng -> stopDetail.Departure_Mrng,
        'Arival_Evng -> stopDetail.Arival_Evng,
        'Departure_Evng -> stopDetail.Departure_Evng,
        'Route_details_id -> stopDetail.Route_details_id
        ) executeInsert (scalar[Long] single)

      id       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.Create Stop Detail center")
      val stpdet = (SQL("""
        SELECT
          `stpdet`.`id`,   
          `stpdet`.`Stop_Name`,
          `stpdet`.`fare`,
          `stpdet`.`Arival_Mrng`,
          `stpdet`.`Departure_Mrng`,   
          `stpdet`.`Arival_Evng`,
          `stpdet`.`Departure_Evng`,
          `stpdet`.`Route_details_id`
        FROM
          `stop_details` `stpdet`
        WHERE
          `stpdet`.`id` = {id}
      """).on('id -> id).as(CreateStopDetail singleOpt)).get
      println("UserDAOImpl.Create Stop Detail finished")
      stpdet
    }   

  }
  
  
  def getStopDetailsByRouteId(rdId : Int) : List[StopDetail] = {
    println("rdid = "+rdId)
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.Create Stop Detail getStopDetailsByRouteId")
      val stpdet = (SQL("""
        SELECT
          `stpdet`.`id`,   
          `stpdet`.`Stop_Name`,
          `stpdet`.`fare`,
          `stpdet`.`Arival_Mrng`,
          `stpdet`.`Departure_Mrng`,   
          `stpdet`.`Arival_Evng`,
          `stpdet`.`Departure_Evng`,
          `stpdet`.`Route_details_id`
        FROM
         `route_details` `rdet`, `stop_details` `stpdet`
        WHERE
          `rdet`.`rdId` = {rdId}
           AND `rdet`.`rdId` = `stpdet`.`Route_details_id`
      """).on('rdId -> rdId).as(CreateStopDetail *))
      println("UserDAOImpl.get Stop Details by Route Id")
      stpdet
    }
    
  }
  
  def getStdAdmNumberList(user_id : Long) : List[Student_Guardian_Mapping] = {
     println("userId = "+user_id)
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.Get Detail of StdAdmNumberList start")
      val sgm = (SQL("""
        SELECT
          `sgm`.`id`,   
          `sgm`.`gid`,
          `sgm`.`stdadmissionno`,        
          `sgm`.`user_id`          
        FROM
          `student_guardian_mapping` `sgm`,`user_term` `ut`,`term` `trm`, `student_details` `sd`
        WHERE
          `sgm`.`user_id` = {user_id}
          AND `sd`.`Studentadminno` = `sgm`.`stdadmissionno`
          AND `sd`.`user_id` = `ut`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active`=1
      """).on('user_id -> user_id).as(CreateStuGuarMapping *))
      println("UserDAOImpl.getStdAdmNumberList start")
      sgm
    }
  }
  
  
  def getDriverByDLno(DLno : String) : DriverDetail = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getDriverByDLno Start")
      val vdl = (SQL("""
        SELECT DISTINCT
          `vdl`.`dId`,
          `vdl`.`DLno`,
          `vdl`.`user_id`,
          `vdl`.`vehicleid`
          
        FROM
          `driver_details` `vdl`
        WHERE
          `vdl`.`DLno`={DLno} 
      """).on('DLno -> DLno).as(driverDetailsSimple singleOpt)).get
      println("UserDAOImpl.getDriverByDLno finished")
      vdl
      }  
    }
  
  def getVehicleAndRoutesByVhId(vdId : Option[Long]) : CreateVehicleDetailUser  = {
    println(" DAOImpl vid : "+vdId)
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getCreateVehicleDetailDlno Started")
      val gvdu = (SQL("""
       SELECT Distinct
          `vdet`.`vdId`,
          `vdet`.`Vehicle_no`,
          `vdet`.`Vehicle_code`,
          `vdet`.`No_of_Seat`,
          `vdet`.`Maximum_capacity`,   
          `vdet`.`insurance`,
          `vdet`.`tax_remitted`,
          `vdet`.`permit`,
          `vdet`.`status`,  
          `vdet`.`Vehicle_type_id`,
          `vtyp`.`Vehicle_type`,
          `rdet`.`rdId`,
          `rdet`.`Route_Name`,
          `vdet`.`campusId`,
          `rdet`.`No_of_Stops`
          
          
        FROM
         `vehicle_details` `vdet`,`route_details` `rdet`,`driver_details` `dd`,
         `vehicle_type` `vtyp`, `campus` `camp`,`term` `trm`
        WHERE
          `vdet`.`vdId` = {vdId}
          AND `vdet`.`vdId` = `rdet`.`Vehicle_id`
          AND `dd`.`vehicleid` = `vdet`.`Vehicle_type_id`
          AND `vdet`.`campusId` = `camp`.`cmId`
          AND `camp`.`cmId` = `trm`.`campus_id`
          AND `trm`.`active` = 1
        
      """).on('vdId -> vdId).as(VehilceDetailUserSimple singleOpt)).get
      println("UserDAOImpl.getCreateVehicleDetailDlno finished")
      gvdu
    } 
  }
  
  
  
  def getLibrariansListByCampusId(cmId : Long) : List[LibrarianUser] = DB.withConnection { implicit conn =>
    SQL("""
        SELECT DISTINCT
          `lib`.`libId`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `ul`.`user_id`,
          `ul`.`phone_number`,
          `camp`.`cmId`,
          `camp`.campus_name,
          `org`.`oId`,
          `org`.name
        FROM
          `user` `u`,`user_login` `ul`,`campus` `camp`, `user_context` `uc`,`librarian` `lib`,`context` `c`,
          `organization` `org`, `term` `trm`
        WHERE
          `camp`.`cmId` = {cmId}
          AND `camp`.`cmId` = `trm`.`campus_id`
          AND `trm`.`active` = 1
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `uc`.`context_id` = 8
          AND `u`.`id`= `uc`.`user_id`
          AND `ul`.`user_id` = `uc`.`user_id`
          AND `lib`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.organization_id = `org`.`oId`
        
      """) on ('cmId -> cmId) as (LibrarianUserSimple *)
  }
  
  
  def createAuthor(authorDetail : Author) : Author = {
  val id = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createAuthor started")
        
         val id = SQL("""
      INSERT INTO `authors`
        (`First_Name`, `Last_Name`)
      VALUES
        ({First_Name}, {Last_Name})
      """) on (
         'First_Name -> authorDetail.First_Name,
        'Last_Name -> authorDetail.Last_Name
        ) executeInsert (scalar[Long] single)

      id       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createAuthor center")
      val dd = (SQL("""
        SELECT
          `auth`.`id`,   
          `auth`.`First_Name`,
          `auth`.`Last_Name`     
        FROM
          `authors` `auth`
        WHERE
          `auth`.`id` = {id}
      """).on('id -> id).as(AuthorDetailSimple singleOpt)).get
      println("UserDAOImpl.createAuthor finished")
      dd
    } 
  }
  
  /*
   * id : Int,ISBN : String,Book_title : String,date_of_publication:Date
   */
  
  def createbookDetail(bookDetail : Book) : Book  = {
  val id = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createbookDetail started")
        
         val id = SQL("""
      INSERT INTO `books`
        (`ISBN`, `Book_title`, `date_of_publication`,`bookCount`,`campusId`)
      VALUES
        ({ISBN}, {Book_title},{date_of_publication},{bookCount},{campusId})
      """) on (
        'ISBN -> bookDetail.ISBN,
        'Book_title -> bookDetail.Book_title,
        'date_of_publication -> bookDetail.date_of_publication,
        'bookCount -> bookDetail.bookCount,
        'campusId -> bookDetail.campusId
        ) executeInsert (scalar[Long] single)

      id       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createbookDetail center")
      val bd = (SQL("""
        SELECT
          `book`.`id`,
          `book`.`ISBN`,   
          `book`.`Book_title`,
          `book`.`date_of_publication`,
          `book`.`bookCount`,
          `book`.`campusId`     
        FROM
          `books` `book`
        WHERE
          `book`.`id` = {id}
      """).on('id -> id).as(BookSimple singleOpt)).get
      println("UserDAOImpl.createbookDetail finished")
      bd
    } 
  }
  
  
  def createbookAuthorDetails(bid : Int,aid : Int) : Unit = {
     DB.withConnection { implicit conn =>
        println("UserDAOImpl.createbookAuthorDetails started")
      SQL("""
      INSERT INTO `books_authors_mapping`
        (`Books_id`, `Authors_id`)
      VALUES
        ({Books_id}, {Authors_id})
      """) on ('Books_id ->bid,'Authors_id -> aid) executeInsert()

     }
  }
  
  def getBookId(Books_id : Int) : BookCategories = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getBookId start"+Books_id)
      val dd = (SQL("""
        SELECT
          `books_book_categories_mapping`.`Books_id`,
          `books_book_categories_mapping`.`Book_Categories_id`   
        FROM
          `books_book_categories_mapping` 
        WHERE
          `books_book_categories_mapping`.`Books_id` = {Books_id}
      """).on('Books_id -> Books_id).as(BookCategoriesSimple singleOpt)).get
      println("UserDAOImpl.getBookId finished")
      dd
    }
  }
  
   def createbookCategories(bid : Int,bcid : Int) : Unit = {
      DB.withConnection { implicit conn =>
        println("UserDAOImpl.createbookCategories started")
          val bc = (SQL("""
      INSERT INTO `books_book_categories_mapping`
        (`Books_id`, `Book_Categories_id`)
      VALUES
        ({Books_id}, {Book_Categories_id})
      """) on ('Books_id ->bid,'Book_Categories_id ->bcid))executeInsert ()
      println("UserDAOImpl.createbookCategories end")
  } 
  }
   
  def getBookListByCampusId(campusId : Long) : List[CreateBookUser] = DB.withConnection { implicit conn =>
    SQL("""
        SELECT DISTINCT
          `bk`.`id`,`bk`.`ISBN`,`bk`.`Book_title`,`bk`.`date_of_publication`,`bk`.`bookCount`,
          `auth`.`First_Name`,`auth`.`Last_Name`,`bcmap`.`Book_Categories_id`,`bkc`.`Categories_name`
        FROM
          `books` `bk`,`books_authors_mapping` `bauth`,`book_categories` `bkc`,
          `books_book_categories_mapping` `bcmap`, `authors` `auth`,`campus` `camp`
        WHERE
          `bk`.`campusId` = {campusId}
          AND `bk`.`campusId` = `camp`.`cmId`
          AND `bk`.`id` = `bauth`.`Books_id`
          AND `auth`.`id` = `bauth`.`Authors_id`
          AND `bcmap`.`Books_id` = `bk`.`id`
          AND `bcmap`.`Book_Categories_id` =  `bkc`.`id`
               
      """) on ('campusId -> campusId) as (CreateBookUserSimple *)
  }
   
    def createMedical(medical : Medical) : Medical = {
       val id = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createMedical started")
          val id = SQL("""
      INSERT INTO `medical_details`
        (`user_id`, `Bloodgroup`,`height`,`weight`,`ailment`,`Doctorname`, `Doctor_address`, `Mobile`)
      VALUES
        ({user_id}, {Bloodgroup},{height},{weight},{ailment},{Doctorname},{Doctor_address},{Mobile})
      """) on (
          'user_id ->medical.user_id,
          'Bloodgroup ->medical.Bloodgroup,
          'height -> medical.height,
          'weight -> medical.weight,
          'ailment -> medical.ailment,
          'Doctorname -> medical.Doctorname,
          'Doctor_address -> medical.Doctor_address,
          'Mobile -> medical.Mobile
          )executeInsert (scalar[Long] single)  
   id       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createMedical center")
      val dd = (SQL("""
        SELECT
          `md`.`id`,
          `md`.`user_id`,
          `md`.`Bloodgroup`,
          `md`.`height`,
          `md`.`weight`,
          `md`.`ailment`,
          `md`.`Doctorname`,
          `md`.`Doctor_address`, 
          `md`.`Mobile`
        FROM
          `medical_details` `md`
        WHERE
         `md`.`id` = {id}
      """).on('id -> id).as(MedicalSimple singleOpt)).get
      println("UserDAOImpl.createMedical finished")
      dd
    } 
   }
    
    implicit def str2date(str: String) = DateTime
    .parse(str)
    
   def createEvent(event : Events) : Events = {
       val eId = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createEvent started")
                       
      val eId = SQL("""
      INSERT INTO `events_details`
        (`evId`,`startDate`, `endDate`, `studId`,`campusId`,`messageFlag`)
      VALUES
        ({evId},{startDate}, {endDate},{studId},{campusId},{messageFlag})
      """) on ('evId -> event.evId,
          'startDate ->event.startDate,
          'endDate ->event.endDate,
          'studId -> event.studUserId,
          'campusId -> event.campusId,
          'messageFlag -> event.messageFlag
          )executeInsert (scalar[Long] single)  
   eId       
     }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createEvent center")
      val ed = (SQL("""
        SELECT
         `eId`,
         `evId`,
         `startDate`,
         `endDate`, 
         `studId`,
         `campusId`,
         `messageFlag`
        FROM
          `events_details`
        WHERE
         `eId` = {eId}
      """).on('eId -> eId).as(EventSimple singleOpt)).get
      println("UserDAOImpl.createEvent finished")
      ed
    } 
   }
   
   
   
    def createCampus(campus : Campus) : Campus = {
       val cmId = DB.withConnection { implicit conn =>
       println("UserDAOImpl.createCampus started")
          val cmId = SQL("""
      INSERT INTO `campus`
        (`campus_name`, `campusAddress`, `campusLocation`, `organization_id`)
      VALUES
        ({campus_name}, {campusAddress},{campusLocation},{organization_id})
      """) on (
          'campus_name ->campus.campus_name,
          'campusAddress ->campus.campusAddress,
          'campusLocation -> campus.campusLocation,
          'organization_id -> campus.organization_id
          )executeInsert (scalar[Long] single)
          cmId
    }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.createCampus center")
      val dd = (SQL("""
        SELECT
         *   
        FROM
          `campus`
        WHERE
         `cmId` = {cmId}
      """).on('cmId -> cmId).as(CampusSimple singleOpt)).get
      println("UserDAOImpl.createCampus finished")
      dd
    } 
    }
    
    
    def createBookIssue(bookIssue : BookIssue) : Unit = {
       DB.withConnection { implicit conn =>
       println("UserDAOImpl.createBookIssue started")
       SQL("""
      INSERT INTO `books_issued`
        (`stdUserId`, `bookid`, `date_issued`, `date_due_for_return`,`date_returned`,`amount_of_fine`,`libUserId`,`bookReturnFlag`,`libRetId`)
      VALUES
        ({stdUserId}, {bookid},{date_issued},{date_due_for_return},{date_returned},{amount_of_fine},{libUserId},{bookReturnFlag},{libRetId})
      """) on (
          'stdUserId ->bookIssue.stdUserId,
          'bookid ->bookIssue.bookid,
          'date_issued -> bookIssue.date_issued,
          'date_due_for_return -> bookIssue.date_due_for_return,
          'date_returned -> bookIssue.date_returned,
          'amount_of_fine -> bookIssue.amount_of_fine,
          'libUserId -> bookIssue.libUserId,
          'bookReturnFlag -> bookIssue.bookReturnFlag,
          'libRetId -> bookIssue.libRetId
          )executeInsert (scalar[Long] single)
         print("UserDAOImpl.createBookIssue end")
    }
    }
    def getMedicalDetailByUserId(user_id : Long) : Medical = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getMedicalDetailByUserId started : "+user_id)
      val dd = (SQL("""
           SELECT
          `md`.`id`,
          `md`.`user_id`,
          `md`.`Bloodgroup`,
          `md`.`height`,
          `md`.`weight`,
          `md`.`ailment`,
          `md`.`Doctorname`,
          `md`.`Doctor_address`, 
          `md`.`Mobile`
        FROM
          `medical_details` `md`, `student_details` `sd`, `user_term` `ut`, `term` `trm`
        WHERE
          `md`.`user_id` = {user_id}
          AND `sd`.`user_id` = `md`.`user_id`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active`=1
      """).on('user_id -> user_id).as(MedicalSimple singleOpt)).get
      println("UserDAOImpl.getMedicalDetailByUserId finished")
      dd
    } 
    }
    
    //.as(MedicalSimple singleOpt)).get
    //.as(get[Option[String]]("something") ?).getOrElse(None)
    
    
    def getMedicalDetailListByCampusId(cmId : Long) : List[Medical] = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getMedicalDetailListByCampusId started")
      val dd = (SQL("""
       SELECT
          `md`.`id`,
          `md`.`user_id`,
          `md`.`Bloodgroup`,
          `md`.`height`,
          `md`.`weight`,
          `md`.`ailment`,
          `md`.`Doctorname`,
          `md`.`Doctor_address`, 
          `md`.`Mobile` 
        FROM
          `medical_details` `md`,`campus` `cmp`, `student_details` `sd`, `user_term` `ut`, `term` `trm`,
      `user_context` `uc`
        WHERE
          `cmp`.`cmId` = {cmId}
          AND `uc`.`campus_id` = `cmp`.`cmId`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `md`.`user_id` = `sd`.`user_id`
          AND `ut`.`user_id` = `md`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active`=1
      """).on('cmId -> cmId).as(MedicalSimple *))
      println("UserDAOImpl.getMedicalDetailListByCampusId finished")
      dd
    } 
    }
    
    def getCampusDetailsByCampusId(cmId : Long) : Campus = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getCampusDetailsByCampusId started")
      val dd = (SQL("""
        SELECT
         *   
        FROM
          `campus`
        WHERE
         `campus`.`cmId` = {cmId}
      """).on('cmId -> cmId).as(CampusSimple singleOpt)).get
      println("UserDAOImpl.getCampusDetailsByCampusId finished")
      dd
    } 
    }
    
    def getOrganizationDetailByOrgId(oId : Long) : Organization = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getOrganizationDetailByOrgId started")
      val dd = (SQL("""
        SELECT
         *   
        FROM
          `organization`
        WHERE
         `organization`.`oId` = {oId}
      """).on('oId -> oId).as(OrganizationSimple singleOpt)).get
      println("UserDAOImpl.getOrganizationDetailByOrgId finished")
      dd
    } 
    }
    
    def getStudentUserByStdAdmissionNo(Studentadminno : String) : StudentUser = {
      DB.withConnection { implicit conn =>
        println(" Start getStudentUserListByStdAdmissionNo : "+Studentadminno)
       val su = (SQL(""" 
        SELECT DISTINCT
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `sd`.`user_id`,
          `sd`.`studentadminno`,
          `ul`.`phone_number`,
          `sc`.`class_id`,
          `cls`.`class_name`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`,
          `sd`.`vehicleId`
          
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`student_details` `sd`,`context` `c`,`class` `cls`,
          `student_class` `sc`,`campus` `camp`,`organization` `org`,`vehicle_details` `vdl`,`user_term` `ut`,`term` `trm`
        WHERE
          `sd`.`Studentadminno`={Studentadminno}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND  `sc`.`class_id` =`cls`.`id`
          AND `sc`.`user_id` = `u`.`id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1
          
      """).on('Studentadminno -> Studentadminno).as(StudentUserSimple singleOpt)).get
      println("UserDAOImpl.getStudentUserListByStdAdmissionNo finished")
      su
      
      }
    }
   
    def createAssignment(assignment : Assignment) : Assignment = {
       val id : Long = DB.withConnection { implicit conn =>
       println("UserDAOImpl.createAssignment started")
       val id = SQL("""
      INSERT INTO `assignment`
        (`assignment_name`, `max_score`, `sequence`, `due_date`,`remindar_date`,`subjectId`,`classId`)
      VALUES
        ({assignment_name}, {max_score},{sequence},{due_date},{remindar_date},{subjectId},{classId})
      """) on (
          'assignment_name ->assignment.assignment_name,
          'max_score ->assignment.max_score,
          'sequence -> assignment.sequence,
          'due_date -> assignment.due_date,
          'remindar_date -> assignment.remindar_date,
          'subjectId -> assignment.subjectId,
          'classId -> assignment.classId
          )executeInsert (scalar[Long] single) 
     id
        }
       DB.withConnection { implicit conn =>
      println("UserDAOImpl.createAssignment center")
      val dd = (SQL("""
        SELECT
         *   
        FROM
          `assignment`
        WHERE
         `id` = {id}
      """).on('id -> id).as(AssignmentSimple singleOpt)).get
      println("UserDAOImpl.createAssignment finished")
      dd
    } 
    }
  
    
    
    def getAssignmentByClassId(id : Int) : List[AssignmentUser] = {
       DB.withConnection { implicit conn =>
      println("UserDAOImpl.createAssignment center")
      val dd = (SQL("""
       SELECT
         `asg`.`id`,
         `asg`.`assignment_name`,
         `asg`.`max_score`,
         `asg`.`sequence`,
         `asg`.`due_date`,
         `asg`.`remindar_date`,
         `asg`.`subjectId`,
         `sub`.`subjectName`,
         `asg`.`classId`,
         `cls`.`class_name`,
         `camp`.`cmId`,
         `camp`.`campus_name`,
         `org`.`oId`,
         `org`.`name`   
        FROM
          `assignment` `asg`,`subject_master` `sub`,`class` `cls`,
          `campus` `camp`,`organization` `org`,`term` `trm`
        WHERE
         `cls`.`id` = {id}
         AND `asg`.`classId` = `cls`.`id`
         AND `cls`.`campus_id` = `camp`.`cmId`
         AND `sub`.`subId` = `asg`.`subjectId`
         AND `camp`.`organization_id` = `org`.`oId`
         AND `cls`.`term_id` = `trm`.`id`
         AND `trm`.`active` = 1
      """).on('id -> id).as(AssignmentUserSimple *))
      println("UserDAOImpl.createAssignment finished")
      dd
    }
  } 
    
    //createSchool


     def createSchool(school : School) : School = {
       val id = DB.withConnection { implicit conn =>
       println("UserDAOImpl.createSchool started Photo : "+school.Photo_data_blob)
       val Photo_data_blob : InputStream = new FileInputStream(new File(school.Photo_data_blob))
          val id = SQL("""
      INSERT INTO `school_logo`
        (`Photo_file_name`, `Photo_Content_Type`, `Photo_file_Size`, `Photo_data_blob`,`Campus_ID`,`holidayId`)
      VALUES
        ({Photo_file_name}, {Photo_Content_Type},{Photo_file_Size},{Photo_data_blob},{Campus_ID},{holidayId})
      """) on (
          'Photo_file_name ->school.Photo_file_name,
          'Photo_Content_Type ->school.Photo_Content_Type,
          'Photo_file_Size -> school.Photo_file_Size,
          'Photo_data_blob -> school.Photo_data_blob,
          'Campus_ID->school.Campus_ID,
          'holidayId -> school.holidayId
          )executeInsert (scalar[Long] single)
          id
    }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.createSchool center")
      val sd = (SQL("""
        SELECT
         *   
        FROM
          `school_logo`
        WHERE
         `id` = {id}
      """).on('id -> id).as(SchoolSimple singleOpt)).get
      println("UserDAOImpl.createSchool finished")
      sd
    } 
    }

    //createHoliday

     def createHoliday(holiday:Holiday):Holiday= {
       val hId = DB.withConnection { implicit conn =>
       println("UserDAOImpl.createHoliday started")
          val hId = SQL("""
      INSERT INTO `holidays`
        (`holidayDate`, `holidayName`, `hoildayDesc`,`campusId`,`messageFlag`)
      VALUES
        ({holidayDate},{holidayName},{hoildayDesc},{campusId},{messageFlag})
      """) on (
          'holidayDate ->holiday.holidayDate,
          'holidayName -> holiday.holidayName,
          'hoildayDesc -> holiday.hoildayDesc,
          'campusId -> holiday.campusId,
          'messageFlag -> holiday.messageFlag
          )executeInsert (scalar[Long] single)
      hId
    }
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.createSchool center : "+hId)
      val hd = (SQL("""
        SELECT
         `holidays`.`hId`,
         `holidays`.`holidayDate`,
         `holidays`.`holidayName`,
         `holidays`.`hoildayDesc`,
         `holidays`.`campusId`,
         `holidays`.`messageFlag`
        FROM
          `holidays`
        WHERE
         `hId` = {hId}
      """).on('hId -> hId).as(HolidaySimple singleOpt)).get
      println("UserDAOImpl.createHoliday finished")
      hd
    } 
    }
     def createOrganization (organization:Organization):Organization = {
     val oId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createOrganization started")
        
         val oId = SQL("""
      INSERT INTO `organization`
        (`name`,`Type`,`activated`,`paid`,`deleted`)
      VALUES
        ({name},{Type},{activated},{paid},{deleted})
      """) on ('oId -> organization.id,
        'name -> organization.name,
        'Type->  organization.Type,
        'activated -> organization.activated,
        'paid -> organization.paid,
        'deleted -> organization.deleted
        ) executeInsert (scalar[Long] single)
      oId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createOrganization center")
      val orgd = (SQL("""
        SELECT
          *
        FROM
          `organization` `org`
        WHERE
          `org`.`oId` = {oId}
      """).on('oId -> oId).as(OrganizationDetailsSimple singleOpt)).get
      println("UserDAOImpl.createOrganization finished")
      orgd
    }
    
  }
def getHoliday(campusId:Long):List[Holiday]= {
       println("campusId is"+campusId)
       DB.withConnection { implicit conn =>
      println("UserDAOImpl.HolidayDetailByCampusId started")
      val dd = (SQL("""
        SELECT distinctrow
         `hl`.`hId`,
         `hl`.`holidayDate`,
         `hl`.`holidayName`,
         `hl`.`hoildayDesc`,
         `hl`.`campusId`,
         `hl`.`messageFlag`  
        FROM
          `holidays` `hl`, `class` `cls`, `term` `trm`
        WHERE
         `hl`.`campusId` = {campusId}
         AND `hl`.`campusId` = `cls`.`campus_id`
         AND `cls`.`term_id` = `trm`.`id`
         AND `trm`.`active` = 1
      """).on('campusId -> campusId).as(HolidaySimple *))
      println("UserDAOImpl.HolidayDetailByCampusId finished")
      dd
    } 
    }
     
     def getSchoolList(Campus_ID:Int): List[School]={
       println("campusId is"+Campus_ID)
       
       DB.withConnection { implicit conn =>
      println("UserDAOImpl.SchoolDetailByCampusId started")
      val dd = (SQL("""
        SELECT distinctrow
         *
        FROM
          `school_logo`  , `campus` 
        WHERE
         `school_logo`.`Campus_ID` = {Campus_ID}
      """).on('Campus_ID -> Campus_ID).as(SchoolSimple *))
      println("UserDAOImpl.getschoolDetailByUserId finished")
      dd
    } 
       
     }
   
  def getVehicleTypeById(id : Int) : VehicleType = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getVehicleTypeById started")
      val vtyp = (SQL("""
        SELECT
          *
        FROM
          `vehicle_type`
        WHERE
          `id` = {id}
      """).on('id -> id).as(VehicleTypeSimple singleOpt)).get
      println("UserDAOImpl.vehicle_type finished")
      vtyp
    }
  }
  
  def getbookCategoriesBybookCategorieId(id : Int) : BokCategories = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getbookCategoriesBybookCategorieId started")
      val vtyp = (SQL("""
        SELECT
          *
        FROM
          `book_categories`
        WHERE
          `id` = {id}
      """).on('id -> id).as(BookCategorySimple singleOpt)).get
      println("UserDAOImpl.getbookCategoriesBybookCategorieId finished")
      vtyp
    }
  }
  
  def getCampusIdByUserIdFromUserContext(user_id : Long) : UserContext = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getCampusIdByUserIdFromUserContext begin "+user_id)
    val uc = (SQL("""
    select
     `uc`.`id`,`uc`.`user_id`,`uc`.`context_id`,`uc`.`campus_id` 
      from 
         `user_context` `uc` 
      where 
         `uc`.`user_id`={user_id} 
        """).on('user_id -> user_id).as(UserContextSimple singleOpt)).get
      println("UserDAOImpl.getCampusIdByUserIdFromUserContext finished")
     uc
    }
  }
  
  def getListOfStudentByCampusIdWhoHasTakenBooks(cmId : Long) : List[StudentUser] = {
    DB.withConnection { implicit conn =>
    println(" CampusId : "+cmId)
    SQL("""
              SELECT DISTINCT
          `u`.`id`,
          `ul`.`email`,
          `u`.`Firstname`,
          `u`.`Lastname`,
          `u`.`Middlename`,
          `u`.`Address1`,
          `u`.`Address2`,
          `u`.`City`,
          `u`.`State`,
          `u`.`Deleted`,
          `c`.`context`,          
          `sd`.`user_id`,
          `sd`.`studentadminno`,
          `ul`.`phone_number`,
          `sc`.`class_id`,
          `cls`.`class_name`,
          `camp`.`cmId`,
          `camp`.`campus_name`,
          `org`.`oId`,
          `org`.`name`,
          `sd`.`vehicleId`
        FROM
          `user` `u`,`user_login` `ul`,`campus` `camp`, `user_context` `uc`,`student_details` `sd`,
          `context` `c`,`student_class` `sc`,`organization` `org`, `class` `cls`, `vehicle_details` `vdl`,
          `books_issued` `bki`,`user_term` `ut`,`term` `trm`
        WHERE
        `camp`.`cmId` = {cmId}
        AND `camp`.`cmId` = `uc`.`campus_id`
        AND `uc`.`context_id` = 4
        AND `u`.`id`= `uc`.`user_id`
        AND `ul`.`user_id` = `uc`.`user_id`
        AND `sd`.`user_id` = `uc`.`user_id`
        AND `c`.`id` = `uc`.`context_id`
        AND `camp`.`cmId` = `uc`.`campus_id`
        AND `camp`.`organization_id` = `org`.`oId`
        AND `sc`.`class_id` = `cls`.`id`
        AND `bki`.`stdUserId` = `sd`.`user_id`
        AND `ut`.`user_id` = `sd`.`user_id`
        AND `ut`.`term_id` = `trm`.`id`
        AND `trm`.`active` = 1
      """) on('cmId -> cmId) as (StudentUserSimple *)
  }
  }
  
  def getStudentWhoHasReturnBookByStdUserId(stdUserId : Long) : BookIssue = {
     DB.withConnection { implicit conn =>
    println(" getStudentWhoHasReturnBookByStdUserId Started : "+stdUserId)
    val bki = SQL("""
        select * FROM books_issued WHERE stdUserId = {stdUserId}
     """).on('stdUserId -> stdUserId).as(BookIssueSimple singleOpt).get
      println("UserDAOImpl.getStudentWhoHasReturnBookByStdUserId finished")
     bki
  }
}
  
  def updateStudentWhoHasReturnBook(bookIssueReturn : BookIssue) : Unit = DB.withConnection { implicit conn =>
    println("updateStudentWhoHasReturnBook started")
    val libRetId = 24
    val amount_of_fine = 123
    val date_returned = "2015-12-15"
    val result = SQL("""
      UPDATE `books_issued` SET
        `stdUserId` = {stdUserId}, 
        `bookid` = {bookid},
        `date_issued` = {date_issued}, 
        `date_due_for_return` = {date_due_for_return},
        `date_returned` = {date_returned},
        `amount_of_fine` = {amount_of_fine}, 
        `libUserId` = {libUserId},
        `libRetId` = {libRetId}
      WHERE
        `stdUserId` = {stdUserId}
      """) on (
      'stdUserId -> bookIssueReturn.stdUserId,
      'bookid -> bookIssueReturn.bookid,
      'date_issued -> bookIssueReturn.date_issued,
      'date_due_for_return -> bookIssueReturn.date_due_for_return,
      'date_returned -> date_returned,
      'amount_of_fine -> amount_of_fine,
      'libUserId -> bookIssueReturn.libUserId,
      'libRetId -> libRetId,
      'id -> bookIssueReturn.id) executeUpdate ()
      println(result+" : updateStudentWhoHasReturnBook finished : "+libRetId+" : "+date_returned)
  }
  
  def getStdUserByStdAdmissionNumber(Studentadminno : String) : StudentUser = DB.withConnection { implicit  conn => 
    println("UserDAOImpl.getStdUserByStdAdmissionNumber Started : "+Studentadminno)
      val sd = (SQL("""
          SELECT DISTINCT
          `u`.`id`,`ul`.`email`,`u`.`Firstname`,`u`.`Lastname`,`u`.`Middlename`,`u`.`Address1`,`u`.`Address2`,`u`.`City`,
          `u`.`State`,`u`.`Deleted`,`c`.`context`,`ul`.`user_id`,`sd`.`studentadminno`,`ul`.`phone_number`,`sc`.`class_id`,
          `cls`.`class_name`,`camp`.`cmId`,`camp`.campus_name,`org`.`oId`,`org`.`name`,`sd`.`vehicleId`
          
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`student_details` `sd`,`context` `c`, `class` `cls`,
          `student_class` `sc`,`campus` `camp`,`organization` `org`,`vehicle_details` `vdl`,`user_term` `ut`,`term` `trm`
        WHERE
          `sd`.`Studentadminno` = {Studentadminno}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND  `sc`.`class_id` =`cls`.`id`
          AND `sc`.`user_id` = `u`.`id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1 
      """).on('Studentadminno -> Studentadminno).as(StudentUserSimple singleOpt)).get
      println("UserDAOImpl.getStdUserByStdAdmissionNumber Rock finished")
      sd
  }
  
  def getGuardianUserByStudentAdmissionNumber(stdadmissionno : String) : List[GuardianUser] ={ 
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getGuardianUserById started : "+stdadmissionno)
      val gdu = (SQL("""
        SELECT
           `gu`.`gId`,`ul`.`email`,`u`.`Firstname`,`u`.`Lastname`,`u`.`Middlename`,`u`.`Address1`,
           `u`.`Address2`,`u`.`City`,`u`.`State`,`u`.`Deleted`,`c`.`context`,`gu`.`user_id`,`gu`.`relationship`,
           `gu`.`mobile`,`gu`.`income`,`gu`.`education`,`gu`.`stdadmissionno`,`camp`.`cmId`,`camp`.`campus_name`,
           `org`.`oId`,`org`.`name`
        FROM
           `user` `u`,`user_login` `ul`,`user_context` `uc`,`guardian` `gu`,`context` `c`, `campus` `camp`,
           `organization` `org`, `student_guardian_mapping` `stdgud`,`user_term` `ut`,`term` `trm`, `student_details` `sd`
        WHERE
           `stdgud`.`stdadmissionno`= {stdadmissionno}
           AND `gu`.`user_id` = `stdgud`.`user_id`
           AND `gu`.`user_id` = `uc`.`user_id`
           AND `ul`.`user_id` = `u`.`id`
           AND `uc`.`user_id` = `u`.`id`
           AND `c`.`id` = `uc`.`context_id`
           AND `camp`.`cmId` = `uc`.`campus_id`
           AND `camp`.`organization_id` = `org`.`oId`
           AND `sd`.`Studentadminno` = `stdgud`.`stdadmissionno`
           AND `sd`.`user_id` = `ut`.`user_id`
           AND `ut`.`term_id` = `trm`.`id`
           AND `trm`.`active`=1
          
      """).on('stdadmissionno -> stdadmissionno).as(GuardianUserSimple *))
      println("UserDAOImpl.getGuardianUserById finished")
      gdu
    } 
  }
  
  def getStudentMedicalDetailsByStudentUserId(user_id : Long) : Medical = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentMedicalDetailsByStudentUserId started : "+user_id)
      val md = (SQL("""
        SELECT
           `md`.`id`,
           `md`.`user_id`,
           `md`.`Bloodgroup`,
           `md`.`height`,
           `md`.`weight`,
           `md`.`ailment`,
           `md`.`Doctorname`,
           `md`.`Doctor_address`, 
           `md`.`Mobile`  
        FROM
          `medical_details` `md`,`user_term` `ut`,`term` `trm`
        WHERE
         `md`.`user_id` = {user_id}
         AND `md`.`user_id` = `ut`.`user_id`
         AND `ut`.`term_id` = `trm`.`id`
         AND `trm`.`active`=1
        
      """).on('user_id -> user_id).as(MedicalSimple singleOpt)).get
      println("UserDAOImpl.getStudentMedicalDetailsByStudentUserId finished")
      md
    } 
  }
  
  def getStudentVehicleDetailsById(vdId : Option[Long]) : CreateVehicleDetailUser = {
      print("\n Vehicle ID : "+vdId)
      DB.withConnection { implicit conn =>
      println("\n UserDAOImpl.getStudentVehicleDetailsById Start")
      val vdl = (SQL("""
        SELECT DISTINCT
          `vdl`.`vdId`,
          `vdl`.`Vehicle_no`,
          `vdl`.`Vehicle_code`,
          `vdl`.`No_of_Seat`,
          `vdl`.`Maximum_capacity`,
          `vdl`.`insurance`,
          `vdl`.`tax_remitted`,
          `vdl`.`permit`,
          `vdl`.`status`,
          `vdl`.`Vehicle_type_id`,
          `vtyp`.`Vehicle_type`,
          `rtd`.`rdId`,
          `rtd`.`Route_Name`,
          `vdl`.`campusId`,
          `rtd`.`No_of_Stops`
          
        FROM
          `vehicle_details` `vdl`,`campus` `cmp`,`vehicle_type` `vtyp`,
          `route_details` `rtd`,`student_details` `sd`, `user_term` `ut`, `term` `trm`
        WHERE
          `vdl`.`vdId`= {vdId}
          AND `cmp`.`cmId`=`vdl`.`campusId`
          AND `rtd`.`Vehicle_id` =  `vdl`.`vdId`
          AND `sd`.`vehicleid` = `vdl`.`vdId`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active`=1
      """).on('vdId -> vdId).as(VehilceDetailUserSimple singleOpt)).get
      println("\n UserDAOImpl.getStudentVehicleDetailsById finished")
      vdl
      }  
    }
  def getStudentEventDetailsByStudentUserId(studId : Long) = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentEventDetailsByStudentUserId started : "+studId)
      val ed = (SQL("""
        SELECT
         `evd`.`eId`,
         `evd`.`evId`,
         `evd`.`startDate`,
         `evd`.`endDate`, 
         `evd`.`studId`,
         `evd`.`campusId`
         `evd`.`messageFlag`  
        FROM
          `events_details` `evd`, `student_details` `sd`, `user_term` `ut`, `term` `trm`
        WHERE
         `evd`.`studId` = {studId}
         AND `sd`.`user_id` = `evd`.`studId`
         AND `ut`.`user_id` = `sd`.`user_id`
         AND `ut`.`term_id` = `trm`.`id`
         AND `trm`.`active`=1
      """).on('studId -> studId).as(EventSimple singleOpt)).get
      println("UserDAOImpl.getStudentEventDetailsByStudentUserId finished")
      ed
    } 
  }
  
  def getEventListBycmapusId(campusId : Long) : List[Events] = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getEventListBycmapusId started : "+campusId)
      val ed = (SQL("""
        SELECT
         `evd`.`eId`,
         `evd`.`evId`,
         `evd`.`startDate`,
         `evd`.`endDate`, 
         `evd`.`studId`,
         `evd`.`campusId`   
        FROM
          `events_details` `evd`, `class` `cls`, `term` `trm`
        WHERE
         `evd`.`campusId` = {campusId}
         AND `cls`.`campus_id` = `evd`.`campusId`
         AND `trm`.`id` = `cls`.`term_id`
         AND `trm`.`active` = 1
      """).on('campusId -> campusId).as(EventSimple *))
      println("UserDAOImpl.getEventListBycmapusId finished")
      ed
    } 
  }
  
   def getStdDetailByStdAdmissionNumberAndCampusId(Studentadminno : String,cmId : Long) : Option[StudentUser]  = {
      DB.withConnection { implicit conn =>
        println(" Start getStdDetailByStdAdmissionNumberAndCampusId started : "+Studentadminno+ " campus Id : "+cmId)
       val su = (SQL(""" 
   SELECT DISTINCT
          `u`.`id`,`ul`.`email`,`u`.`Firstname`,`u`.`Lastname`,`u`.`Middlename`,`u`.`Address1`,`u`.`Address2`,`u`.`City`,
          `u`.`State`,`u`.`Deleted`,`c`.`context`,`ul`.`user_id`,`sd`.`studentadminno`,`ul`.`phone_number`,`sc`.`class_id`,
          `cls`.`class_name`,`camp`.`cmId`,`camp`.campus_name,`org`.`oId`,`org`.`name`,`sd`.`vehicleId`
          
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`student_details` `sd`,`context` `c`, `class` `cls`,
          `student_class` `sc`,`campus` `camp`,`organization` `org`,`vehicle_details` `vdl`,`user_term` `ut`,`term` `trm`
        WHERE
          `sd`.`Studentadminno` = {Studentadminno}
          AND `camp`.`cmId` = {cmId}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND  `sc`.`class_id` =`cls`.`id`
          AND `sc`.`user_id` = `u`.`id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`
          AND `sd`.`user_id` = `ut`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1
         
          
      """).on('Studentadminno -> Studentadminno, 'cmId -> cmId).as(StudentUserSimple singleOpt))
      println("UserDAOImpl.getStdDetailByStdAdmissionNumberAndCampusId finished")
      su
      
      }
    }
  
   def getAttendanceByStdAdmNoByMonthNoAndByStatus(Studentadminno : String,DOI : Int,status : Int) : List[AttendanceList] = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getAttendanceByStdAdmNoByMonthNoAndByStatus started")
      val atlst = (SQL("""
        SELECT
          `atnd`.`atdId`,   
          `atnd`.`stud_id`,
          `atnd`.`Studentadminno`,
          `atnd`.`remark`,
          `atnd`.`status` ,
          `atnd`.`DOI`,
          `atnd`.`updatedon`           
        FROM
          `attendence` `atnd`,`student_details` `sd`, `user_term` `ut`, `term` `trm`
         WHERE
           `atnd`.`Studentadminno` = {Studentadminno}
           AND `sd`.`Studentadminno` = `atnd`.`Studentadminno`
           AND month(`atnd`.`DOI`) = {DOI}
           AND `atnd`.`status` = {status}
           AND `ut`.`user_id` = `sd`.`user_id`
           AND `ut`.`term_id` = `trm`.`id`
           AND `trm`.`active`=1
          
          """).on('Studentadminno -> Studentadminno,'DOI -> DOI,'status ->status).as(AttendanceSimple *))
          println("UserDAOImpl.getAttendanceByStdAdmNoByMonthNoAndByStatus finished")
          atlst
    }
   }
   
   def getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus(Studentadminno : String,frmDate : Date,updatedon : Date,status : Int) : List[AttendanceList] = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus started")
      val atlst = (SQL("""
        SELECT
          `atnd`.`atdId`,   
          `atnd`.`stud_id`,
          `atnd`.`Studentadminno`,
          `atnd`.`remark`,
          `atnd`.`status` ,
          `atnd`.`DOI`,
          `atnd`.`updatedon`           
        FROM
          `attendence` `atnd`,`student_details` `sd`, `user_term` `ut`, `term` `trm`
         WHERE
           `atnd`.`Studentadminno` = {Studentadminno}
           AND `sd`.`Studentadminno` = `atnd`.`Studentadminno`
           AND `atnd`.`DOI` between {DOI} and {updatedon}
           AND `atnd`.`status` = {status}
           AND `ut`.`user_id` = `sd`.`user_id`
           AND `ut`.`term_id` = `trm`.`id`
           AND `trm`.`active`=1
          
          """).on('Studentadminno -> Studentadminno,'DOI -> frmDate,'updatedon -> updatedon,'status ->status).as(AttendanceSimple *))
          println("UserDAOImpl.getAttendanceByStdAdmNoByFrmDateByToDateAndByStatus finished")
          atlst
    }
   }
   
   def getAttendanceByStdAdmNo(stdAdmNum : String) : List[AttendanceList] = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getAttendanceByStdAdmNo started")
      val atlst = (SQL("""
        SELECT
          `atnd`.`atdId`,   
          `atnd`.`stud_id`,
          `atnd`.`Studentadminno`,
          `atnd`.`remark`,
          `atnd`.`status` ,
          `atnd`.`DOI`,
          `atnd`.`updatedon`           
        FROM
          `attendence` `atnd`,`student_details` `sd`, `user_term` `ut`, `term` `trm`
         WHERE
           `atnd`.`Studentadminno` = {Studentadminno}
           AND `sd`.`Studentadminno` = `atnd`.`Studentadminno`
           AND `ut`.`user_id` = `sd`.`user_id`
           AND `ut`.`term_id` = `trm`.`id`
           AND `trm`.`active` = 1
          """).on('Studentadminno -> stdAdmNum).as(AttendanceSimple *))
          println("UserDAOImpl.getAttendanceByStdAdmNo finished")
          atlst
     }
   }
   
   def getStudentPeriviousDetailByStdAdmNum(stdAdmNum : String) : List[StdClassTerm] = {
     DB.withConnection { implicit conn =>  
       println(" getStudentPeriviousDetailByStdAdmNum started : "+stdAdmNum)
       val sct = (SQL(""" 
                  select distinctrow
                      usr.Firstname,
                      sd.Studentadminno,
                      ut.user_id,
                      sc.class_id,
                      cls.class_name,
                      trm.start_date,
                      trm.end_date,
                      trmt.term_type
                  from 
                      student_details sd,student_class sc,class cls,term trm,user_term ut,term_type trmt,user usr
                  where 
                       sd.Studentadminno = {Studentadminno}
                       AND sd.user_id = sc.user_id
                       AND cls.term_id = trm.id
                       AND trm.id = ut.term_id
                       AND ut.active =  0
                       AND usr.id = sd.user_id
                       AND trmt.id = trm.term_type_id
      """).on('Studentadminno -> stdAdmNum).as(StdClassTermSimple *))
      println(" getStudentPeriviousDetailByStdAdmNum finish ")
      sct
     }
   }
   
   def insertSchoolNews(schoolNews : SchoolNews) : SchoolNews = {
      val id:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.insertSchoolNews started")
        
         val id = SQL("""
      INSERT INTO `school_news`
        (`schoolId`,`headlines`,`newsdesc`,`newsdate`,`status`)
      VALUES
        ({schoolId},{headlines},{newsdesc},{newsdate},{status})
      """) on ('schoolId -> schoolNews.schoolId,
        'headlines -> schoolNews.headLines,
        'newsdesc->  schoolNews.newsDesc,
        'newsdate -> schoolNews.newsDate,
        'status -> schoolNews.status
        ) executeInsert (scalar[Long] single)
      id      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.insertSchoolNews center")
      val snws = (SQL("""
        SELECT
          *
        FROM
          `school_news` `snws`
        WHERE
          `snws`.`id` = {id}
      """).on('id -> id).as(SchoolNewsSimple singleOpt)).get
      println("UserDAOImpl.insertSchoolNews finished")
      snws
    }
   }
   
   def getSchoolNewsListBySchoolId(schoolId : Int) : List[SchoolNews] = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getSchoolNewsListBySchoolId started")
      val snws = (SQL("""
        SELECT distinctrow
          `snws`.`id`,
          `snws`.`schoolId`,
          `snws`.`headlines`,
          `snws`.`newsdesc`,
          `snws`.`newsdate`,
          `snws`.`status`
        FROM
          `school_news` `snws`, `school_logo` `sl`, `class` `cls`, `term` `trm`
        WHERE
          `snws`.`schoolId` = {schoolId}
           AND `snws`.`schoolId` = `sl`.`id`
           AND `sl`.`Campus_ID` = `cls`.`campus_id`
           AND `cls`.`term_id` = `trm`.`id`
           AND `trm`.`active` = 1
       
      """).on('schoolId -> schoolId).as(SchoolNewsSimple *))
      println("UserDAOImpl.getSchoolNewsListBySchoolId finished")
      snws
    }
   }
   
   def getSchoolNewsListByCampusId(campusId : Long) : List[SchoolNews] = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getSchoolNewsListByCampusId started")
      val snws = (SQL("""
        SELECT distinctrow
          `snws`.`id`,
          `snws`.`schoolId`,
          `snws`.`headlines`,
          `snws`.`newsdesc`,
          `snws`.`newsdate`,
          `snws`.`status`
        FROM
          `school_news` `snws`, `school_logo` `sl`, `class` `cls`, `term` `trm`
        WHERE
          `sl`.`Campus_ID` = {Campus_ID}
          AND `cls`.`campus_id` = `sl`.`Campus_ID`
          AND `trm`.`id` = `cls`.`term_id`
          AND `trm`.`active` = 1
          AND `snws`.`schoolId` = `sl`.`id`
      """).on('Campus_ID -> campusId).as(SchoolNewsSimple *))
      println("UserDAOImpl.getSchoolNewsListByCampusId finished")
      snws
    }
   }
   
   def insertExam(exam : Exam) : Exam = {
     val examId:Long = DB.withConnection { implicit conn =>
       /*val format1 = new java.text.SimpleDateFormat("yyyy-MM-dd")
       format1.format(new java.util.Date())
       var updateAt : Option[Date] = Option(format1.parse(exam.updateAt.get))
       println(" Date from String : "+updateAt)*/
        println("UserDAOImpl.insertExam started")
         val examId = SQL("""
      INSERT INTO `exam_master`
        (`examName`,`termtypeId`,`createAt`,`updateAt`)
      VALUES
        ({examName},{termtypeId},{createAt},{updateAt})
      """) on ('examName -> exam.examName,
        'termtypeId -> exam.termtypeId,
        'createAt->  Calendar.getInstance().getTime(),
        'updateAt -> Calendar.getInstance().getTime()
        ) executeInsert (scalar[Long] single)
      examId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.insertExam center")
      val exm = (SQL("""
        SELECT
          *
        FROM
          `exam_master` `exmst`
        WHERE
          `exmst`.`examId` = {examId}
      """).on('examId -> examId).as(ExamSimple singleOpt)).get
      println("UserDAOImpl.insertExam finished")
      exm
    }
   }
   
   
   def insertExamClassMap(examClassMap : ExamClassMap) : ExamClassMap = {
      val ecmId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.insertExamClassMap started")
         val ecmId = SQL("""
      INSERT INTO `exam_class_mapping`
        (`examId`,`classId`,`termId`,`createdAt`,`updateAt`)
      VALUES
        ({examId},{classId},{termId},{createdAt},{updateAt})
      """) on ('examId -> examClassMap.examId,
        'classId -> examClassMap.classId,
        'termId -> examClassMap.termId,
        'createdAt->  examClassMap.createdAt,
        'updateAt -> examClassMap.updateAt
        ) executeInsert (scalar[Long] single)
      ecmId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.insertExamClassMap center")
      val ecmap = (SQL("""
        SELECT
          *
        FROM
          `exam_class_mapping` `ecm`
        WHERE
          `ecm`.`ecmId` = {ecmId}
      """).on('ecmId -> ecmId).as(ExamClassMapSimple singleOpt)).get
      println("UserDAOImpl.insertExamClassMap finished")
      ecmap
      }
   }
   
   def getExamDetailByExamId(examId : Long) : Exam = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getExamDetailByExamId started")
      val exm = (SQL("""
        SELECT
          `exmst`.`examId`,
          `exmst`.`examName`,
          `exmst`.`termId`,
          `exmst`.`createAt`,
          `exmst`.`updateAt`
        FROM
          `exam_master` `exmst`, `term` `trm`
        WHERE
          `exmst`.`examId` = {examId}
          AND `exmst`.`termId` = `trm`.`id`
          AND `trm`.`active` = 1
          
      """).on('examId -> examId).as(ExamSimple singleOpt)).get
      println("UserDAOImpl.getExamDetailByExamId finished")
      exm
    }
   }
   
   def getSubjectListById(subId : Long) : SubjectMaster = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getSubjectListById started")
      val subject = (SQL("""
        SELECT
          `sub`.`subId`,
          `sub`.`subjectName`,
          `sub`.`createdOn`,
          `sub`.`updatedOn`
        FROM
          `subject_master` `sub`
        WHERE
          `sub`.`subId` = {subId}
          
      """).on('subId -> subId).as(SubjectSimple singleOpt)).get
      println("UserDAOImpl.getSubjectListById finished")
      subject
    }
   }
   
   
   def getAllSubjectList : List[SubjectMaster] = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getAllSubjectList started")
      val subject = (SQL("""
        SELECT
          `sub`.`subId`,
          `sub`.`subjectName`,
          `sub`.`createdOn`,
          `sub`.`updatedOn`
        FROM
          `subject_master` `sub`
       """).as(SubjectSimple *))
      println("UserDAOImpl.getAllSubjectList finished")
      subject
    }
   }
   
   def getSubjectIdBySubjectName(subjectName : String) : SubjectMaster = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getSubjectIdBySubjectName started")
      val subject = (SQL("""
        SELECT
          `sub`.`subId`,
          `sub`.`subjectName`,
          `sub`.`createdOn`,
          `sub`.`updatedOn`
        FROM
          `subject_master` `sub`
         WHERE
          `sub`.`subjectName` = {subjectName}        
       """).on('subjectName -> subjectName).as(SubjectSimple singleOpt)).get
      println("UserDAOImpl.getSubjectIdBySubjectName finished")
      subject
    }
   }
   
   
   def saveStaffSubjectMap(staffSubjectMap : StaffSubjectMap) : StaffSubjectMap = {
     val ssubmapId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.saveStaffSubjectMap started")
         val ssubmapId = SQL("""
      INSERT INTO `staff_subject_map`
        (`subId`,`userId`)
      VALUES
        ({subId},{userId})
      """) on ('subId -> staffSubjectMap.subjectId,
        'userId -> staffSubjectMap.userId
        ) executeInsert (scalar[Long] single)
      ssubmapId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.saveStaffSubjectMap center")
      val ssmap = (SQL("""
        SELECT
          *
        FROM
          `staff_subject_map` `ssm`
        WHERE
          `ssm`.`stfSubMapId` = {stfSubMapId}
      """).on('stfSubMapId -> ssubmapId).as(StaffSubjectMapSimple singleOpt)).get
      println("UserDAOImpl.saveStaffSubjectMap finished")
      ssmap
      }
   }
   
   //insertSubjectClassMap
   
   def insertSubjectClassMap(subjectClassMap : SubjectClassMap) : SubjectClassMap = {
      val ecmId:Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.insertSubjectClassMap started")
         val ecmId = SQL("""
      INSERT INTO `subject_class_mapping`
        (`SubClassId`,`subjectId`,`classId`)
      VALUES
        ({SubClassId},{subjectId},{classId})
      """) on ('SubClassId -> subjectClassMap.SubClassId,
        'subjectId -> subjectClassMap.subjectId,
        'classId -> subjectClassMap.classId
        ) executeInsert (scalar[Long] single)
      ecmId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.insertSubjectClassMap center")
      val ecmap = (SQL("""
        SELECT
          *
        FROM
          `subject_class_mapping` `ecm`
        WHERE
          `ecm`.`ecmId` = {ecmId}
      """).on('ecmId -> ecmId).as(SubjectClassMapSimple singleOpt)).get
      println("UserDAOImpl.insertSubjectClassMap finished")
      ecmap
      }
   }
   
   
   def getExamDetailsByExamId(examId : Long) : ExamInfo = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getExamDetailsByExamId started")
      val exminfo = (SQL("""
               select 
                      em.examId,
                      em.examName,
                      em.termId,
                      ecm.classId,
                      cls.class_name
                 from 
                      exam_class_mapping ecm,exam_master em , class cls, term trm
                where 
                      ecm.examId = {examId} 
                      AND ecm.examId = em.examId
                      AND cls.term_id = ecm.termId
                      AND trm.id = cls.term_id
                      AND trm.active = 1
                 """).on('examId -> examId).as(ExamInfoSimple singleOpt)).get
      println("UserDAOImpl.getExamDetailsByExamId finished")
      exminfo
   }
}
   
   def getSubjectListByClassId(classId : Long) : List[SubjectMaster] = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getSubjectListByClassId started")
      val exm = (SQL("""
        SELECT
          `sub`.`subId`,
          `sub`.`subjectName`,
          `sub`.`createdOn`,
          `sub`.`updatedOn`
        FROM
          `subject_master` `sub`, `subject_class_mapping` `scmap`, `class` `cls`,`term` `trm`
        WHERE
          `scmap`.`classId` = {classId}
          AND `sub`.`subId` = `scmap`.`subjectId`
          AND `cls`.`id` = `scmap`.`classId`
          AND `trm`.`id` = `cls`.`term_id`
          AND `trm`.`active` = 1
      """).on('classId -> classId).as(SubjectSimple *))
      println("UserDAOImpl.getSubjectListByClassId finished")
      exm
    }
   }
   
   def createExamTimeTable(examTimeTable : ExamTimeTable) : ExamTimeTable = {
     val EttId = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createExamTimeTable started")
         val EttId = SQL("""
      INSERT INTO `examtimetable`
        (`ecmapId`,`subId`,`examDate`,`fromTime`,`toTime`,`status`,`createdAt`,`updatedAt`)
      VALUES
        ({ecmapId},{subId},{examDate},{fromTime},{toTime},{status},{createdAt},{updatedAt})
      """) on (
         'ecmapId -> examTimeTable.ecmapId,
         'subId -> examTimeTable.subjectId,
        'examDate -> examTimeTable.examDate,
        'fromTime -> examTimeTable.fromTime,
        'toTime->  examTimeTable.toTime,
        'status -> examTimeTable.status,
        'createdAt -> examTimeTable.createdAt,
        'updatedAt -> examTimeTable.updatedAt
        ) executeInsert (scalar[Long] single)
      EttId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createExamTimeTable center")
      val Ettdt = (SQL("""
        SELECT
          `ett`.`EttId`,
          `ett`.`ecmapId`,
          `ett`.`subId`,
          `ett`.`examDate`,
          `ett`.`fromTime`,
          `ett`.`toTime`,
          `ett`.`status`,
          `ett`.`createdAt`,
          `ett`.`updatedAt`
        FROM
          `examtimetable` `ett`
        WHERE
          `ett`.`EttId` = {EttId}
      """).on('EttId -> EttId).as(ExamTimeTableSimple singleOpt)).get
      println("UserDAOImpl.createExamTimeTable finished")
      Ettdt
      }
   }
   
   
   def createClassTimeTable(classTimeTable : ClassTimeTable) : ClassTimeTable = {
     val TtId : Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.createClassTimeTable started")
         val TtId = SQL("""
      INSERT INTO `class_timetable`
        (`classId`,`Day`,`Pone`,`Ptwo`,`Pthree`,`Pfour`,`Pfive`,`Psix`,`Pseven`,`Peight`,`createdAt`,`updatedAt`)
      VALUES
        ({classId},{Day},{Pone},{Ptwo},{Pthree},{Pfour},{Pfive},{Psix},{Pseven},{Peight},{createdAt},{updatedAt})
      """) on (
         'classId -> classTimeTable.classId,
         'Day -> classTimeTable.Day,
        'Pone -> classTimeTable.pOne,
        'Ptwo -> classTimeTable.pTwo,
        'Pthree->  classTimeTable.pThree,
        'Pfour -> classTimeTable.pFour,
        'Pfive -> classTimeTable.pFive,
        'Psix -> classTimeTable.pSix,
        'Pseven->  classTimeTable.pSeven,
        'Peight -> classTimeTable.pEight,
        'createdAt -> classTimeTable.createdAt,
        'updatedAt -> classTimeTable.updatedAt
        ) executeInsert (scalar[Long] single)
      TtId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.createClassTimeTable center")
      val ttDel = (SQL("""
        SELECT
          *
        FROM
          `class_timetable` `ctt`
        WHERE
          `ctt`.`TtId` = {TtId}
      """).on('TtId -> TtId).as(ClassTimeTableSimple singleOpt)).get
      println("UserDAOImpl.createClassTimeTable finished")
      ttDel
      }
   }
   
   def getEventMasterById(evId : Long) : EventsMaster = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getEventMasterById started")
      val em = (SQL("""
        SELECT
         *
        FROM
          `events_master` 
        WHERE
         `evId` = {evId}
      """).on('evId -> evId).as(EventMasterSimple singleOpt)).get
      println("UserDAOImpl.getEventMasterById finished")
      em
      }
   } 
   
  def getEventDetailByEventId(evId : Long) : EventsUser = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getEventDetailByEventId started")
      val eusr = (SQL("""
       SELECT
        `evd`.`eId`,
        `evd`.`evId`,
        `evm`.`Name`,
        `evm`.`desc`,
        `evd`.`startDate`,
        `evd`.`endDate`,
        `evd`.`studId`,
        `evd`.`campusId`,
        `evm`.`status`,
        `evd`.`messageFlag`
        FROM
          `events_master` `evm`, `events_details` `evd`,`class` `cls`, `term` `trm`
        WHERE
         `evd`.`evId` = {evId}
         AND `evd`.`evId` = `evm`.`evId`
         AND `cls`.`campus_id` = `evd`.`campusId`
         AND `trm`.`id` = `cls`.`term_id`
         AND `trm`.`active` = 1
      """).on('evId -> evId).as(EventUserSimple singleOpt)).get
      println("UserDAOImpl.getEventDetailByEventId finished")
      eusr
      }
  }
  
 def getExamTimeTableById(EttId : Long) : ExamTimeTable = {
   DB.withConnection { implicit conn =>
      println("UserDAOImpl.getExamTimeTableById started")
      val exmtt = (SQL("""
        SELECT
            ett.EttId,
            ett.subId,
            ett.ecmapId,
            ett.examDate,
            ett.fromTime,
            ett.toTime,
            ett.status,
            ett.createdAt,
            ett.updatedAt
        FROM
          examtimetable ett, exam_class_mapping ecmap, term trm
        WHERE
         ett.EttId = {EttId}
         AND ecmap.ecmId = ett.EttId
         AND trm.id = ecmap.termId
         AND trm.active = 1
      """).on('EttId -> EttId).as(ExamTimeTableSimple singleOpt)).get
      println("UserDAOImpl.getExamTimeTableById finished")
      exmtt
      }
 }
 
 def getExamTimeTableByExamId(examId : Long) : ExamTimeTable = {
   DB.withConnection { implicit conn =>
      println("UserDAOImpl.getExamTimeTableByExamId started")
      val exmtt = (SQL("""
        SELECT
            ett.EttId,
            ett.subId,
            ett.ecmapId,
            ett.examDate,
            ett.fromTime,
            ett.toTime,
            ett.status,
            ett.createdAt,
            ett.updatedAt
        FROM
          examtimetable ett, exam_class_mapping ecm, exam_master em, term trm
        WHERE
         em.examId = {examId}
         AND em.examId = ecm.examId
         AND ecm.ecmId = ett.ecmapId
         AND trm.id = ecm.termId
         AND trm.active = 1
      """).on('examId -> examId).as(ExamTimeTableSimple singleOpt)).get
      println("UserDAOImpl.getExamTimeTableByExamId finished")
      exmtt
      }
 }
 
 def getExamTimeTableByClassId(classId : Long) : List[ExamCompleteInfo] = {
   DB.withConnection { implicit conn =>
      println("UserDAOImpl.getExamTimeTableByClassId started")
      val ecinfo = (SQL("""
        SELECT      
              ett.EttId,scm.subjectId, sm.subjectName, ett.ecmapId, ecm.classId, cls.class_name,ecm.termId,
              ty.term_type, ett.examDate,ett.fromTime,ett.toTime,ett.status,ett.createdAt,ett.updatedAt
        FROM
              examtimetable ett, exam_class_mapping ecm, exam_master em,subject_class_mapping scm, 
              class cls, term trm, subject_master sm,term_type ty
        WHERE
              scm.classId = {classId}
              AND cls.id = scm.classId
              AND ecm.classId = scm.classId
              AND ecm.termId = em.termId
              AND em.termId = trm.id
              AND ecm.examId = em.examId
              AND ecm.ecmId = ett.ecmapId
              AND ett.subId = scm.subjectId
              AND scm.subjectId = sm.subId
              AND trm.term_type_id = ty.id
              AND trm.active = 1
      """).on('classId -> classId).as(ExamCompleteInfoSimple *))
      println("UserDAOImpl.getExamTimeTableByClassId finished")
      ecinfo
      }
 }
 
 def getClassTimeTableByClassId(classId : Long) : List[ClassTimeTable] = {
   DB.withConnection { implicit conn =>
      println("UserDAOImpl.createClassTimeTable started")
      val ttDel = (SQL("""
        SELECT
          `ctt`.`TtId`,`ctt`.`classId`,`ctt`.`Day`,`ctt`.`Pone`,`ctt`.`Ptwo`,`ctt`.`Pthree`,`ctt`.`Pfour`,`ctt`.`Pfive`,
          `ctt`.`Psix`,`ctt`.`Pseven`,`ctt`.`Peight`,`ctt`.`createdAt`,`ctt`.`updatedAt`
        FROM
          `class_timetable` `ctt` , `class` `cls`, `term` `trm`
        WHERE
          `ctt`.`classId` = {classId}
          AND `ctt`.`classId` = `cls`.`id`
          AND `cls`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1
      """).on('classId -> classId).as(ClassTimeTableSimple *))
      println("UserDAOImpl.createClassTimeTable finished")
      ttDel
      }
 }
 
 def saveMarks(marks : Marks) : Marks = {
   val mId : Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.saveMarks started")
         val mId = SQL("""
      INSERT INTO `marks`
        (`ecmId`,`userId`,`subjectId`,`maxMarks`,`minMarks`,`marksObtained`,`marksInWords`,`remarks`)
      VALUES
        ({ecmId},{userId},{subjectId},{maxMarks},{minMarks},{marksObtained},{marksInWords},{remarks})
      """) on (
         'ecmId -> marks.ecmId,
         'userId -> marks.studentId,
         'subjectId -> marks.subjectId,
         'maxMarks -> marks.maxMarks,
         'minMarks->  marks.minMarks,
         'marksObtained -> marks.marksObtained,
         'marksInWords -> marks.marksInWords,
         'remarks -> marks.remarks
        ) executeInsert (scalar[Long] single)
      mId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.saveMarks center")
      val mrksDel = (SQL("""
        SELECT
          `mrks`.`mId`,
          `mrks`.`ecmId`,
          `mrks`.`userId`,
          `mrks`.`subjectId`,
          `mrks`.`maxMarks`,
          `mrks`.`minMarks`,
          `mrks`.`marksObtained`,
          `mrks`.`marksInWords`,  
          `mrks`.`remarks`
        FROM
          `marks` `mrks`
        WHERE
          `mrks`.`mId` = {mId}
      """).on('mId -> mId).as(MarksSimple singleOpt)).get
      println("UserDAOImpl.saveMarks finished")
      mrksDel
      }
 }
 
 def getMarksDetailBySubjectId(subjectId : Long) : List[MarksUser] = {
   DB.withConnection { implicit conn =>
      println("UserDAOImpl.getMarksDetailBySubjectId started")
      val mrksDel = (SQL("""
        select 
          `mrks`.`mId`,
          `ecm`.`examId`,
          `exm`.`examName`,
          `cls`.`id`,
          `cls`.`class_name`,
          `mrks`.`userId`,
          `usr`.`Firstname`,
          `mrks`.`subjectId`,
          `sm`.`subjectName`,
          `mrks`.`maxMarks`,
          `mrks`.`minMarks`,
          `mrks`.`marksObtained`,
          `mrks`.`marksInWords`,  
          `mrks`.`remarks`
          from 
          marks mrks, exam_class_mapping ecm, class cls, term trm, subject_master sm, exam_master exm, user usr
          where mrks.subjectId = {subjectId}
          AND sm.subId = mrks.subjectId
          AND mrks.ecmId = ecm.ecmId
          AND ecm.examId = exm.examId
          AND usr.id = mrks.userId
          AND ecm.classId = cls.id
          AND ecm.termId = trm.id
          AND trm.active = 1
      """).on('subjectId -> subjectId).as(MarksUserSimple *))
      println("UserDAOImpl.getMarksDetailBySubjectId finished")
      mrksDel
      }
 }
 
 def getMarksListByclassId(classId : Long) : List[MarksUser] = {
   DB.withConnection { implicit conn =>
      println("UserDAOImpl.getMarksDetailBySubjectId started")
      val mrksDel = (SQL("""
        select 
          `mrks`.`mId`,
          `ecm`.`examId`,
          `exm`.`examName`,
          `cls`.`id`,
          `cls`.`class_name`,
          `mrks`.`userId`,
          `usr`.`Firstname`,
          `mrks`.`subjectId`,
          `sm`.`subjectName`,
          `mrks`.`maxMarks`,
          `mrks`.`minMarks`,
          `mrks`.`marksObtained`,
          `mrks`.`marksInWords`,  
          `mrks`.`remarks`
        from 
          marks mrks, exam_class_mapping ecm, class cls, term trm, subject_master sm, exam_master exm, user usr
        where cls.id = {id}
          AND sm.subId = mrks.subjectId
          AND mrks.ecmId = ecm.ecmId
          AND ecm.examId = exm.examId
          AND usr.id = mrks.userId
          AND ecm.classId = cls.id
          AND ecm.termId = trm.id
          AND trm.active = 1
      """).on('id -> classId).as(MarksUserSimple *))
      println("UserDAOImpl.getMarksDetailBySubjectId finished")
      mrksDel
      }
 }
 
 def getStudentDetailsForMarksByStdAdmNum(Studentadminno : String) : StudentMarks = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentDetailsForMarksByStdAdmNum started")
      val stdMarks = (SQL("""
          SELECT DISTINCT
            `u`.`Firstname`,
            `u`.`Lastname`,
            `u`.`Middlename`,
            `sd`.`user_id`,
            `sd`.`studentadminno`,
            `gd`.`Mobile`,
            `cls`.`class_name`,
            `camp`.`campus_name`,
            `org`.`name`,
            `exm`.`examName`
          
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`student_details` `sd`,`context` `c`,`class` `cls`,
          `student_class` `sc`,`campus` `camp`,`organization` `org`,`user_term` `ut`,`term` `trm`, `guardian` `gd`,
           `exam_master` `exm`, `exam_class_mapping` `ecm`
        WHERE
          `sd`.`Studentadminno`= {Studentadminno}
          AND `gd`.`stdadmissionno` = `sd`.`Studentadminno`
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND  `sc`.`class_id` =`cls`.`id`
          AND `sc`.`user_id` = `u`.`id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`
          AND `ecm`.`examId` = `exm`.`examId`
          AND `ecm`.`classId` = `cls`.`id`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1
       """).on('Studentadminno -> Studentadminno).as(StudentMarksSimple singleOpt)).get
      println("UserDAOImpl.getStudentDetailsForMarksByStdAdmNum finished")
      stdMarks
      }
 }
  
 def getMarksListByStdAdmNum(Studentadminno : String) : List[MarksStudent] = {
   DB.withConnection { implicit conn =>
      println("UserDAOImpl.getMarksListByStdAdmNum started")
      val mrksStd = (SQL("""
                select 
                      `usr`.`id`,
                      `sm`.`subjectName`,
                      `mrks`.`maxMarks`,
                      `mrks`.`minMarks`,
                      `mrks`.`marksObtained`,
                      `mrks`.`marksInWords`,  
                      `mrks`.`remarks`
               from 
                      `marks` `mrks`, `exam_class_mapping` `ecm`, `class` `cls`, `term` `trm`, `subject_master` `sm`,
                      `exam_master` `exm`, `user` `usr`,`student_details` `sd`

                      where `sd`.`Studentadminno` = {Studentadminno}
                      AND `sm`.`subId` = `mrks`.`subjectId`
                      AND `mrks`.`ecmId` = `ecm`.`ecmId`
                      AND `ecm`.`examId` = `exm`.`examId`
                      AND `usr`.`id` = `mrks`.`userId`
                      AND `ecm`.`classId` = `cls`.`id`
                      AND `ecm`.`termId` = `trm`.`id`
                      AND `trm`.`active` = 1
       """).on('Studentadminno -> Studentadminno).as(MarksStudentSimple *))
      println("UserDAOImpl.getMarksListByStdAdmNum finished")
      mrksStd
      }
 }
 
  def saveResult(finalResult : FinalResult) : FinalResult = {
    val resId : Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.saveResult started")
         val resId = SQL("""
      INSERT INTO `result`
        (`dateOfResult`,`userId`,`totalMaxMarks`,`totalMinMarks`,`totalMarksObtained`,`marksInWords`,`resultClass`,`average`)
      VALUES
        ({dateOfResult},{userId},{totalMaxMarks},{totalMinMarks},{totalMarksObtained},{marksInWords},{resultClass},{average})
      """) on (
         'dateOfResult -> Calendar.getInstance().getTime(),
         'userId -> finalResult.userId,
         'totalMaxMarks -> finalResult.totalMaxMarks,
         'totalMinMarks -> finalResult.totalMinMarks,
         'totalMarksObtained -> finalResult.totalMarksObtained,
         'marksInWords -> finalResult.marksInWords,
         'resultClass -> finalResult.resultClass,
         'average->  finalResult.average
        ) executeInsert (scalar[Long] single)
      resId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.saveResult center")
      val resDel = (SQL("""
        SELECT
          `res`.`resId`,
          `res`.`dateOfResult`,
          `res`.`userId`,
          `res`.`totalMaxMarks`,
          `res`.`totalMinMarks`,
          `res`.`totalMarksObtained`,
          `res`.`marksInWords`,
          `res`.`resultClass`,
          `res`.`average`
        FROM
          `result` `res`
        WHERE
          `res`.`resId` = {resId}
      """).on('resId -> resId).as(FinalResultSimple singleOpt)).get
      println("UserDAOImpl.saveResult finished")
      resDel
      }
  }
  
  def getStudentResultByUserId(userId : Long) : FinalResult = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentResultByUserId started")
      val finalRes = (SQL("""
        SELECT
          `res`.`resId`,
          `res`.`dateOfResult`,
          `res`.`userId`,
          `res`.`totalMaxMarks`,
          `res`.`totalMinMarks`,
          `res`.`totalMarksObtained`,
          `res`.`marksInWords`,
          `res`.`resultClass`,
          `res`.`average`
        FROM
          `result` `res`
        WHERE
          `res`.`userId` = {userId}
      """).on('userId -> userId).as(FinalResultSimple singleOpt)).get
      println("UserDAOImpl.getStudentResultByUserId finished")
      finalRes
      }
  }
  
  def saveStaffClassMap(staffClassMap : StaffClassMap) : StaffClassMap = {
    val stfClsMapId : Long = DB.withConnection { implicit conn =>
        println("UserDAOImpl.saveStaffClassMap started")
         val stfClsMapId = SQL("""
      INSERT INTO `staff_class_map`
        (`classId`,`userId`)
      VALUES
        ({classId},{userId})
      """) on (
         'classId -> staffClassMap.classId,
         'userId -> staffClassMap.userId
        ) executeInsert (scalar[Long] single)
      stfClsMapId      
      }
     
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.saveStaffClassMap center")
      val staffclsmap = (SQL("""
        SELECT
          `scmap`.`stfClsMapId`,
          `scmap`.`classId`,
          `scmap`.`userId`
        FROM
          `staff_class_map` `scmap`
        WHERE
          `scmap`.`stfClsMapId` = {stfClsMapId}
      """).on('stfClsMapId -> stfClsMapId).as(StaffClassMapSimple singleOpt)).get
      println("UserDAOImpl.saveStaffClassMap finished")
      staffclsmap
      }
  }
  
  def getMappingStaffClassSubjectByClassIdAndUserId(classId : Long,userId : Long) : MappingStaffClassSubject = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getMappingStaffClassSubjectByClassIdAndUserId started")
      val subclsstfmap = (SQL("""
        select distinct
            `scm`.`subClassId`, 
            `scm`.`subjectId`,
            `scm`.`classId`,
            `ssm`.`stfSubMapId`,
            `ssm`.`userId`
        from 
            `subject_class_mapping` `scm`, `staff_subject_map` `ssm`
        where 
              `scm`.`classId` = {classId}
              AND `ssm`.`userId` = {userId}
              AND `scm`.`subjectId` = `ssm`.`subId`
      """).on('classId -> classId,'userId -> userId).as(MappingStaffClassSubjectSimple singleOpt)).get
      println("UserDAOImpl.getMappingStaffClassSubjectByClassIdAndUserId finished")
      subclsstfmap
      }
  } 
  
  def checkForSubjectAndStaffUserIdWithClass(classId : Long,subjectId : Long,userId : Long) : Option[MappingStaffClassSubject] = DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForSubjectAndStaffUserIdWithClass started")
      val subclsstfmap = (SQL("""
          select distinct
            `scm`.`subClassId`, 
            `scm`.`subjectId`,
            `scm`.`classId`,
            `ssm`.`stfSubMapId`,
            `ssm`.`userId`
          from 
            `subject_class_mapping` `scm`, `staff_subject_map` `ssm`, `staff_class_map` `stfclsmap`
          where 
            `scm`.`classId` = {classId}
            AND `stfclsmap`.`classId` = `scm`.`classId`
            AND `ssm`.`userId` = {userId}
            AND `scm`.`subjectId` = {subjectId}
            AND `scm`.`subjectId` = `ssm`.`subId`
            AND `stfclsmap`.`userId` = `ssm`.`userId`
      """).on('classId -> classId,'userId -> userId,'subjectId -> subjectId).as(MappingStaffClassSubjectSimple singleOpt))
      println("UserDAOImpl.checkForSubjectAndStaffUserIdWithClass finished")
      subclsstfmap
      }
  
  
     
  def getSubjectIdByStaffUserId(userId : Long) : StaffSubjectMap = {
    
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getSubjectIdByStaffUserId Started")
      val ssmap = (SQL("""
        SELECT
          *
        FROM
          `staff_subject_map` `ssm`
        WHERE
          `ssm`.`userId` = {userId}
      """).on('userId -> userId).as(StaffSubjectMapSimple singleOpt)).get
      println("UserDAOImpl.getSubjectIdByStaffUserId Finished")
      ssmap
      }
  }
  
  def getSubjectClassStaffMapByClassId(classId : Long) : List[SubjectClassStaffMap] = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getSubjectClassStaffMapByClassIdAndUserId started")
      val subclsstfmap = (SQL("""
          select 
              `u`.`firstname`,
              `sd`.`user_id`,
              `scm`.`classId`,
              `cls`.`class_name`,
              `scm`.`subjectId`,
              `sm`.`subjectName`,
              `sd`.`vehicleId`,
              `v`.`vehicle_no`,
              `cls`.`campus_id`,
              `cmp`.`campus_name`,
              `cmp`.`organization_id`,
              `org`.`name` 
         from
              `subject_class_mapping` `scm`, `staff_subject_map` `ssm`,`staff_details` `sd`, `staff_class_map` `stfcm`, 
              `subject_master` `sm`,`class` `cls`, `user` `u`,`campus` `cmp`, `vehicle_details` `v`, `organization` `org`,
              `term` `trm`
         where 
              `scm`.`classId` = {classId}
              AND `ssm`.`subId` = `scm`.`subjectId` 
              AND `sd`.`user_id` = `ssm`.`userId`
              AND `stfcm`.`userId` = `sd`.`user_id`
              AND `u`.`id` = `stfcm`.`userId`
              AND `scm`.`subjectId` = `sm`.`subId`
              AND `stfcm`.`classId` = `scm`.`classId`
              AND `scm`.`classId` = `cls`.`id`
              ANd `cls`.`campus_id` = `cmp`.`cmId`
              AND `cmp`.`cmId` = `trm`.`campus_id`
              AND `trm`.`active` = 1
              AND `cmp`.`organization_id` = `org`.`oId`
              AND `sd`.`vehicleId` = `v`.`vdId`            
      """).on('classId -> classId).as(SubjectClassStaffMapSimple *))
      println("UserDAOImpl.getSubjectClassStaffMapByClassIdAndUserId finished")
      subclsstfmap
      }
  }
  
  
  def getStudentCount : Long = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentCount started")
      val stdCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          student_details
      """).as(scalar[Long].single)
      println("UserDAOImpl.getStudentCount finished")
     stdCnt
    }
  }
  
  def getStaffCount : Long = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStaffCount started")
      val stfCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          staff_details
      """).as(scalar[Long].single)
      println("UserDAOImpl.getStaffCount finished")
     stfCnt
    }
  }
  
  def getClassCount : Long = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getClassCount started")
      val clsCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          class
      """).as(scalar[Long].single)
      println("UserDAOImpl.getClassCount finished")
     clsCnt
    }
  }
  
  def getSubjectCount : Long = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getSubjectCount started")
      val subCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          subject_master
      """).as(scalar[Long].single)
      println("UserDAOImpl.getSubjectCount finished")
     subCnt
    }
  }
  
  def getExamCount : Long = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getExamCount started")
      val exmCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          exam_master
      """).as(scalar[Long].single)
      println("UserDAOImpl.getExamCount finished")
     exmCnt
    }
  }
  
  def getLibrarianCount : Long = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getLibrarianCount started")
      val libCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          librarian
      """).as(scalar[Long].single)
      println("UserDAOImpl.getLibrarianCount finished")
     libCnt
    }
  }
  
  def getVehicleCount : Long = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getVehicleCount started")
      val vtyCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          vehicle_type
      """).as(scalar[Long].single)
      println("UserDAOImpl.getVehicleCount finished")
     vtyCnt
    }
  }
  
  def getHolidayCount : Long = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getHolidayCount started")
      val hlyCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          holidays
      """).as(scalar[Long].single)
      println("UserDAOImpl.getHolidayCount finished")
     hlyCnt
    }
  }
  
  def getEventCount : Long = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getEventCount started")
      val entCnt : Long = SQL("""
      SELECT 
          COUNT(*)
      FROM
          events_master
      """).as(scalar[Long].single)
      println("UserDAOImpl.getEventCount finished")
     entCnt
    }
  }
  
  def getClassListByStaffUserId(userId : Long) : List[ClassListForStaff] = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getClassListByStaffUserId started")
      val clsStf = (SQL("""
        select distinct
             cls.id, cls.class_name
        from 
            staff_class_map scm, staff_details sd, user urs, class cls, subject_class_mapping subcm
        where 
             scm.userId = {userId}
            AND urs.id = scm.userId
            AND subcm.classId = cls.id
      """).on('userId -> userId).as(ClassListForStaffSimple *))
      println("UserDAOImpl.getClassListByStaffUserId finished")
      clsStf
      }
  }
  
  def getStaffListByClassId(classId : Long) : List[StaffDetailsForClass] = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStaffListByClassId started")
      val stfCls = (SQL("""
        select 
            distinct cls.id, cls.class_name, scm.userId, usr.firstname,sub.subId, sub.subjectName
        from 
            staff_class_map scm, staff_details sd, class cls, 
            subject_class_mapping subcm, staff_subject_map ssm,user usr, subject_master sub
        where
            subcm.classId = {classId}
            AND scm.userId = ssm.userId
            AND subcm.classId = cls.id
            AND scm.classId = subcm.classId
            AND ssm.subId = subcm.subjectId
            AND usr.id = ssm.userId
            AND ssm.subId = sub.subId
      """).on('classId -> classId).as(StaffDetailsForClassSimple *))
      println("UserDAOImpl.getStaffListByClassId finished")
      stfCls
      }
  }
  
   def getVehicleTypeListByCampusId(campusId : Long) : List[VehicleType] = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getVehicleTypeListByCampusId started")
      val vtype = (SQL("""
        select 
              distinct vt.id, vt.vehicle_type 
        from 
              vehicle_type vt, vehicle_details vd, campus camp
        where 
              vd.campusId = {campusId}
              AND camp.cmId = vd.campusId
              AND vt.id = vd.vehicle_type_id
            
      """).on('campusId -> campusId).as(VehicleTypeSimple *))
      println("UserDAOImpl.getVehicleTypeListByCampusId finished")
      vtype
      }
   }
   
   def getVehicleIdByStaffUserId(userId : Long) : StaffDetail = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getVehicleIdByStaffUserId started")
      val vtype = (SQL("""
        select 
              * 
        from 
              staff_details
        where 
              user_id = {user_id}
            
      """).on('user_id -> userId).as(StaffDetailsSimple singleOpt)).get
      println("UserDAOImpl.getVehicleIdByStaffUserId finished")
      vtype
      }
   }
   
   //Uploading of File into AWS
   
def uploadFile(request: Request[MultipartFormData[TemporaryFile]]): String = {
    log.error("Called uploadFile function" + request)
   
     
    request.body.file("picture").map { picture =>
    import java.io.File
      val filename = picture.filename
      var path:String=picture.ref.file.getPath
      val length:BigInt=filename.length()
      println("length is"+length)
      var uniqueFile = new File(s"$filename")
     
 println(path)
     
  val credentials:AWSCredentials = new AWSCredentials 
  {
    
    val getAWSAccessKeyId: String = current.configuration.getString("AWSAccessKeyId").get
     val getAWSSecretKey: String = current.configuration.getString("AWSSecretKey").get
    }
         val client = new AmazonS3Client(credentials)
          val getBucketName: String = current.configuration.getString("AWSBucket").get
         val bucketName =getBucketName
       val  key:String = filename


 val   amazonFileUploadLocationOriginal:String=bucketName+"/";
        System.out.println("===========================================");
        System.out.println("Getting Started with Amazon S3"); 
        System.out.println("===========================================\n");

     
  val stream = new FileInputStream(path);
  val objectMetadata = new ObjectMetadata();
  val putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, key, stream, objectMetadata);
  val result = client.putObject(putObjectRequest);
  System.out.println("Etag:" + result.getETag() + "-->" + result);
        //download()
  //getImage("1234Glb")
     
  s"File uploaded on S3 with Key : ${key}"
       

    
     }.getOrElse {
      "Missing file"
     }
  }
 
//Download an File From AWS
  
  def download() : Unit = {
       
            val existingBucketName: String = "shrikanth";
            val keyName : String ="/"+"shri123.docx";
            
           
            val credentials:AWSCredentials = new AWSCredentials{ 
                    val getAWSAccessKeyId: String = current.configuration.getString("AWSAccessKeyId").get
                    val getAWSSecretKey: String = current.configuration.getString("AWSSecretKey").get
            }
                   
            val client = new AmazonS3Client(credentials)
            val request = new GetObjectRequest(existingBucketName,keyName);
            val S3Object  = client.getObject(request);
            val objectContent = S3Object.getObjectContent();
            IOUtils.copy(objectContent, new FileOutputStream("C://Users//Public//Documents//keyName"));
            System.out.println("done");
  }
  
  
  
  def getAssignmentByStaffUserId(user_id : Long) : List[AssignmentUser] = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.getAssignmentByStaffUserId Started")
      val dd = (SQL("""
       SELECT
         `asg`.`id`,
         `asg`.`assignment_name`,
         `asg`.`max_score`,
         `asg`.`sequence`,
         `asg`.`due_date`,
         `asg`.`remindar_date`,
         `asg`.`subjectId`,
         `sub`.`subjectName`,
         `asg`.`classId`,
         `cls`.`class_name`,
         `camp`.`cmId`,
         `camp`.`campus_name`,
         `org`.`oId`,
         `org`.`name`   
      FROM
          `assignment` `asg`,`subject_master` `sub`,`class` `cls`,`campus` `camp`,`organization` `org`,`term` `trm`,
          `staff_class_map` `scm`, `staff_subject_map` `ssm`,`staff_details` `sd`
      WHERE
         `sd`.`user_id` = {user_id}
         AND `ssm`.`userId` = `sd`.`user_id`
         AND `scm`.`userId` = `ssm`.`userId`
         AND `ssm`.`subId` = `sub`.`subId`
         AND `sub`.`subId` = `asg`.`subjectId`
         AND `asg`.`classId` = `cls`.`id`
         AND `scm`.`classId` = `asg`.`classId`
         AND `cls`.`campus_id` = `camp`.`cmId`
         AND `camp`.`organization_id` = `org`.`oId`
         AND `cls`.`term_id` = `trm`.`id`
         AND `trm`.`active` = 1
      """).on('user_id -> user_id).as(AssignmentUserSimple *))
      println("UserDAOImpl.getAssignmentByStaffUserId Finish")
      dd
      }
    }
  
    def campusUpdate(campus : Campus ,cmId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("Campus Update Started")
      val res : Long = SQL("""
      UPDATE `campus` `cmp` SET
       `cmp`.`campus_name` = {campus_name},
       `cmp`.`organization_id` = {organization_id},
       `cmp`.`campusAddress` = {campusAddress},
       `cmp`.`campusLocation` = {campusLocation}
      WHERE
        `cmp`.`cmId` = {cmId}
      """) on (
        'campus_name -> campus.campus_name,
        'organization_id -> campus.organization_id,
        'campusAddress -> campus.campusAddress,
        'campusLocation -> campus.campusLocation,
        'cmId -> campus.id) executeUpdate ()
      println(res,"Campus Update Rocks")
      }
    }
    
    def organizationUpdate(organization : Organization,organizationId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("Organization Update Started : "+organizationId)
      val res : Long = SQL("""
      UPDATE `organization` `org` SET
       `org`.`name` = {name},
       `org`.`Type` = {Type},
       `org`.`activated` = {activated},
       `org`.`paid` = {paid},
       `org`.`deleted` = {deleted}
      WHERE
        `org`.`oId` = {oId}
      """) on (
        'name -> organization.name,
        'Type -> organization.Type,
        'activated -> organization.activated,
        'paid -> organization.paid,
        'deleted -> organization.deleted,
        'oId -> organizationId) executeUpdate ()
      println(res,"Organization Update Rocks")
      } 
    }
    
    def getStudentDetailForGuardianByStdAdminNum(Studentadminno : String) : Option[StudentDetailForGuardian] = {
      DB.withConnection { implicit  conn => 
      println("UserDAOImpl.getStudentDetailForGuardianByStdAdminNum Started : "+Studentadminno)
      val sd = (SQL("""
          SELECT DISTINCT
          `u`.`Firstname`,`u`.`Middlename`,`u`.`Lastname`,`sd`.`studentadminno`     
        FROM
          `user` `u`,`user_login` `ul`,`user_context` `uc`,`student_details` `sd`,`context` `c`, `class` `cls`,
          `student_class` `sc`,`campus` `camp`,`organization` `org`,`vehicle_details` `vdl`,`user_term` `ut`,`term` `trm`
        WHERE
          `sd`.`Studentadminno` = {Studentadminno}
          AND `ul`.`user_id` = `u`.`id`
          AND `uc`.`user_id` = `u`.`id`
          AND `sd`.`user_id` = `uc`.`user_id`
          AND `c`.`id` = `uc`.`context_id`
          AND  `sc`.`class_id` =`cls`.`id`
          AND `sc`.`user_id` = `u`.`id`
          AND `camp`.`cmId` = `uc`.`campus_id`
          AND `camp`.`organization_id` = `org`.`oId`
          AND `ut`.`user_id` = `sd`.`user_id`
          AND `ut`.`term_id` = `trm`.`id`
          AND `trm`.`active` = 1 
      """).on('Studentadminno -> Studentadminno).as(StudentDetailForGuardianSimple singleOpt))
      println("UserDAOImpl.getStudentDetailForGuardianByStdAdminNum Rock finished")
      sd
        }
    }
    
    def getCountForBooksAvailableByBookId(bookId : Int) : Book = {
       DB.withConnection { implicit conn =>
      println("UserDAOImpl.getCountForBooksAvailableByBookId started")
      val bd = (SQL("""
        SELECT
          `book`.`id`,
          `book`.`ISBN`,   
          `book`.`Book_title`,
          `book`.`date_of_publication`,
          `book`.`bookCount`,
          `book`.`campusId`     
        FROM
          `books` `book`
        WHERE
          `book`.`id` = {id}
      """).on('id -> bookId).as(BookSimple singleOpt)).get
      println("UserDAOImpl.getCountForBooksAvailableByBookId finished")
      bd
       }
    }
   
    def getListCountForBookAndBookIssueBook(id : Int) : Long = {
      DB.withConnection { implicit conn =>
      println(" getListCountForBookAndBookIssueBook Started : "+id)
      val bki : Long = SQL("""
        SELECT count(*) 
        FROM `books_issued` `bki`,`books` `bk` 
        WHERE 
        `bk`.`id`={id}
        AND `bki`.`bookid` = `bk`.`id`  
        AND `bki`.`bookReturnFlag` = 1
     """).on('id -> id).as(scalar[Long].single)
      println("UserDAOImpl.getListCountForBookAndBookIssueBook finished")
     bki
      }
    }
    
    def getCountForBooksTakenByStudentUserId(stdUserId : Long) : Long = {
      DB.withConnection { implicit conn =>
      println(" getCountForBooksTakenByStudentUserId Started : "+stdUserId)
      val bki : Long = SQL("""
        select COUNT(*) FROM books_issued WHERE stdUserId = {stdUserId} AND bookReturnFlag = 1
     """).on('stdUserId -> stdUserId).as(scalar[Long].single)
      println("UserDAOImpl.getCountForBooksTakenByStudentUserId finished")
     bki
        }
    }
    
    def getCheckForSameBookAssignToSameStudentUserByBookIdAndByUserId(bookid : Int,user_id : Long) : Long = {
       DB.withConnection { implicit conn =>
      println(" getCheckForSameBookAssignToSameStudentUserByBookIdAndByUserId Started : "+bookid+" userId : "+user_id)
      val bki = SQL("""
                    SELECT COUNT(*) 
                    FROM  `books_issued` 
                    WHERE 
                    `stdUserId` = {stdUserId} 
                    AND bookid = {bookid}
         """).on('stdUserId -> user_id,'bookid -> bookid).as(scalar[Long].single)
      println("UserDAOImpl.getCheckForSameBookAssignToSameStudentUserByBookIdAndByUserId finished")
     bki
        }
      }
   
    def updateBooksRecordByBookId(id : Long,bookCount1 : Long) : Unit = DB.withConnection { implicit conn =>
      val bookCount = bookCount1 - 1
      println("updateBooksRecordByBookId Started : "+bookCount)
      val result = SQL("""
      UPDATE `books` `book` SET
          `book`.`id` = {id},
          `book`.`bookCount` = {bookCount}
        WHERE
          `book`.`id` = {id}
      """) on (
      'id -> id,
      'bookCount -> bookCount) executeUpdate ()
      println(println(result,"updateBooksRecordByBookId Rocks"))
  }
    def checkForCampusName(campusName : String) : Campus = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForCampusName Started")
      val dd = (SQL("""
        SELECT
         *   
        FROM
          `campus`
        WHERE
         `campus_name` = {campus_name}
      """).on('campus_name -> campusName).as(CampusSimple singleOpt)).get
      println("UserDAOImpl.checkForCampusName finished")
      dd
        }
    }
    
    def checkForCampusId(campusId : Long) : Campus = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForCampusId Started")
      val dd = (SQL("""
        SELECT
         *   
        FROM
          `campus`
        WHERE
         `cmId` = {cmId}
      """).on('cmId -> campusId).as(CampusSimple singleOpt)).get
      println("UserDAOImpl.checkForCampusId finished")
      dd
        }
    }
    
    def checkForAssignmentId(assignmentId : Int) : Assignment = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForAssignmentId Started")
      val assign = (SQL("""
        SELECT
         *   
        FROM
          `assignment`
        WHERE
         `id` = {id}
      """).on('id -> assignmentId).as(AssignmentSimple singleOpt)).get
      println("UserDAOImpl.checkForAssignmentId finished")
      assign
      }
    }
    
   
   def assignmentUpdate(assignment : Assignment,assignmentId : Int) : Unit = {
     DB.withConnection { implicit conn =>
      println("Assignment Update Started : "+assignmentId)
      val res : Long = SQL("""
      UPDATE `assignment` `assign` SET
       `assign`.`assignment_name` = {assignment_name},
       `assign`.`max_score` = {max_score},
       `assign`.`sequence` = {sequence},
       `assign`.`due_date` = {due_date},
       `assign`.`remindar_date` = {remindar_date},
       `assign`.`subjectId` = {subjectId},
       `assign`.`classId` = {classId}
      WHERE
        `assign`.`id` = {id}
      """) on (
        'assignment_name -> assignment.assignment_name,
        'max_score -> assignment.max_score,
        'sequence -> assignment.sequence,
        'due_date -> assignment.due_date,
        'remindar_date -> assignment.remindar_date,
        'subjectId -> assignment.subjectId,
        'classId -> assignment.classId,
        'id -> assignmentId) executeUpdate ()
      println(res,"Assignment Update Rocks")
      } 
   }
   
   def checkForHolidayId(holidayId : Int) : Holiday = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForHolidayId Started : "+holidayId)
      val hd = (SQL("""
        SELECT
         `holidays`.`hId`,
         `holidays`.`holidayDate`,
         `holidays`.`holidayName`,
         `holidays`.`hoildayDesc`,
         `holidays`.`campusId`
        FROM
          `holidays`
        WHERE
         `hId` = {hId}
      """).on('hId -> holidayId).as(HolidaySimple singleOpt)).get
      println("UserDAOImpl.checkForHolidayId finished")
      hd
    } 
   }
   
   def holidayUpdate(holiday : Holiday,holidayId : Int) : Unit = {
     DB.withConnection { implicit conn =>
      println("Holiday Update Started : "+holidayId)
      val res : Long = SQL("""
      UPDATE `holidays` SET
       `holidays`.`holidayDate` = {holidayDate},
       `holidays`.`holidayName` = {holidayName},
       `holidays`.`hoildayDesc` = {hoildayDesc},
       `holidays`.`campusId` = {campusId},
       `holidays`.`messageFlag` = {messageFlag}
      WHERE
        `holidays`.`hId` = {hId}
      """) on (
        'holidayDate -> holiday.holidayDate,
        'holidayName -> holiday.holidayName,
        'hoildayDesc -> holiday.hoildayDesc,
        'campusId -> holiday.campusId,
        'messageFlag -> holiday.messageFlag,
        'hId -> holidayId) executeUpdate ()
      println(res,"Holiday Update Rocks")
      } 
   }
   
   def checkForSchoolId(schoolLogoId : Int) : School = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForSchoolId started")
      val sd = (SQL("""
        SELECT
         *   
        FROM
          `school_logo`
        WHERE
         `id` = {id}
      """).on('id -> schoolLogoId).as(SchoolSimple singleOpt)).get
      println("UserDAOImpl.checkForSchoolId finished")
      sd
    } 
   }
   
   def schoolUpdate(school : School,schoolLogoId : Int) : Unit = {
     DB.withConnection { implicit conn =>
      println("School Update Started : "+schoolLogoId)
      val res : Long = SQL("""
      UPDATE `school_logo` SET
       `school_logo`.`Photo_file_name` = {Photo_file_name},
       `school_logo`.`Photo_Content_Type` = {Photo_Content_Type},
       `school_logo`.`Photo_file_Size` = {Photo_file_Size},
       `school_logo`.`Photo_data_blob` = {Photo_data_blob},
       `school_logo`.`Campus_ID` = {Campus_ID},
       `school_logo`.`holidayId` = {holidayId}
      WHERE
        `school_logo`.`id` = {id}
      """) on (
        'Photo_file_name -> school.Photo_file_name,
        'Photo_Content_Type -> school.Photo_Content_Type,
        'Photo_file_Size -> school.Photo_file_Size,
        'Photo_data_blob -> school.Photo_data_blob, 
        'Campus_ID -> school.Campus_ID,
        'holidayId -> school.holidayId,
        'id -> schoolLogoId) executeUpdate ()
      println(res,"School Update Rocks")
      } 
   }
   
   def checkForNewsId(newsId : Int) : SchoolNews = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForNewsId started")
      val snws = (SQL("""
        SELECT
          *
        FROM
          `school_news` `snws`
        WHERE
          `snws`.`id` = {id}
      """).on('id -> newsId).as(SchoolNewsSimple singleOpt)).get
      println("UserDAOImpl.checkForNewsId finished")
      snws
    }
   }
   /*
    * get[Long]("id") ~
      get[Int]("schoolId") ~
      get[String]("headlines") ~
      get[String]("newsdesc") ~
      get[Date]("newsdate") ~
      get[Int]("status")
    */
   def newsUpdate(schoolNews : SchoolNews,newsId : Int) : Unit = {
     DB.withConnection { implicit conn =>
      println("News Update Started : "+newsId)
      val res : Long = SQL("""
      UPDATE `school_news` `snws` SET
       `snws`.`schoolId` = {schoolId},
       `snws`.`headlines` = {headlines},
       `snws`.`newsdesc` = {newsdesc},
       `snws`.`newsdate` = {newsdate},
       `snws`.`status` = {status}
      WHERE
        `snws`.`id` = {id}
      """) on (
        'schoolId -> schoolNews.schoolId,
        'headlines -> schoolNews.headLines,
        'newsdesc -> schoolNews.newsDesc,
        'newsdate -> schoolNews.newsDate, 
        'status -> schoolNews.status,
        'id -> newsId) executeUpdate ()
      println(res,"News Update Rocks")
      } 
   }
   
   def checkForeventId(eventId : Int) : Events = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForeventId started")
      val ed = (SQL("""
        SELECT
         `eId`,
         `evId`,
         `startDate`,
         `endDate`, 
         `studId`,
         `campusId`
        FROM
          `events_details`
        WHERE
         `eId` = {eId}
      """).on('eId -> eventId).as(EventSimple singleOpt)).get
      println("UserDAOImpl.checkForeventId finished")
      ed
    } 
   }
   
   def eventUpdate(event : Events,eventId : Int) : Unit = {
     DB.withConnection { implicit conn =>
      println("Event Update Started : "+eventId)
      val res : Long = SQL("""
      UPDATE `events_details` `evn` SET
       `evn`.`evId` = {evId},
       `evn`.`startDate` = {startDate},
       `evn`.`endDate` = {endDate},
       `evn`.`studId` = {studId},
       `evn`.`campusId` = {campusId},
       `evn`.`messageFlag` = {messageFlag}
      WHERE
        `evn`.`eId` = {eId}
      """) on (
        'evId -> event.evId,
        'startDate -> event.startDate,
        'endDate -> event.endDate, 
        'studId -> event.studUserId,
        'campusId -> event.campusId,
        'messageFlag -> event.messageFlag,
        'eId -> eventId) executeUpdate ()
      println(res,"Event Update Rocks")
      } 
   }
   
  def checkForMarksId(marksId : Int) : Marks = {
    DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForMarksId Started")
      val mrksDel = (SQL("""
        SELECT
          `mrks`.`mId`,
          `mrks`.`ecmId`,
          `mrks`.`userId`,
          `mrks`.`subjectId`,
          `mrks`.`maxMarks`,
          `mrks`.`minMarks`,
          `mrks`.`marksObtained`,
          `mrks`.`marksInWords`,  
          `mrks`.`remarks`
        FROM
          `marks` `mrks`
        WHERE
          `mrks`.`mId` = {mId}
      """).on('mId -> marksId).as(MarksSimple singleOpt)).get
      println("UserDAOImpl.checkForMarksId finished")
      mrksDel
      }
  }
   
   def marksUpdate(marks : Marks,marksId : Int) : Unit = {
     DB.withConnection { implicit conn =>
      println("Marks Update Started : "+marksId)
      val res : Long = SQL("""
      UPDATE `marks` `mrks` SET
          `mrks`.`ecmId` = {ecmId},
          `mrks`.`userId` = {userId},
          `mrks`.`subjectId` = {subjectId},
          `mrks`.`maxMarks` = {maxMarks},
          `mrks`.`minMarks` = {minMarks},
          `mrks`.`marksObtained` = {marksObtained},
          `mrks`.`marksInWords` = {marksInWords},  
          `mrks`.`remarks` = {remarks}
      WHERE
        `mrks`.`mId` = {mId}
      """) on (
        'ecmId -> marks.ecmId,
        'userId -> marks.studentId,
        'subjectId -> marks.subjectId, 
        'maxMarks -> marks.maxMarks,
        'minMarks -> marks.minMarks,
        'marksObtained -> marks.marksObtained,
        'marksInWords -> marks.marksInWords,
        'remarks -> marks.remarks,
        'mId -> marksId) executeUpdate ()
      println(res,"Marks Update Rocks")
      } 
   }
   
   def checkForMedicalId(medicalId : Int) : Medical = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForMedicalId started")
      val dd = (SQL("""
        SELECT
          `md`.`id`,
          `md`.`user_id`,
          `md`.`Bloodgroup`,
          `md`.`height`,
          `md`.`weight`,
          `md`.`ailment`,
          `md`.`Doctorname`,
          `md`.`Doctor_address`, 
          `md`.`Mobile`
        FROM
          `medical_details` `md`
        WHERE
         `md`.`id` = {id}
      """).on('id -> medicalId).as(MedicalSimple singleOpt)).get
      println("UserDAOImpl.checkForMedicalId finished")
      dd
    } 
   }
   
   def medicalUpdate(medical : Medical,medicalId : Int) : Unit = {
     DB.withConnection { implicit conn =>
      println("Medical Update Started : "+medicalId)
      val res : Long = SQL("""
      UPDATE `medical_details` `md` SET
          `md`.`user_id` = {user_id},
          `md`.`Bloodgroup` = {Bloodgroup},
          `md`.`height` = {height},
          `md`.`weight` = {weight},
          `md`.`ailment` = {ailment},
          `md`.`Doctorname` = {Doctorname},
          `md`.`Doctor_address` = {Doctor_address}, 
          `md`.`Mobile` = {Mobile}
      WHERE
        `md`.`id` = {id}
      """) on (
        'user_id -> medical.user_id,
        'Bloodgroup -> medical.Bloodgroup,
        'height -> medical.height, 
        'weight -> medical.weight,
        'ailment -> medical.ailment,
        'Doctorname -> medical.Doctorname,
        'Doctor_address -> medical.Doctor_address,
        'Mobile -> medical.Mobile,
        'id -> medicalId) executeUpdate ()
      println(res,"Medical Update Rocks")
      } 
   }
   
   def checkForAuthorId(authorId : Int) : Author = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForAuthorId started")
      val auth = (SQL("""
        SELECT
          `auth`.`id`,   
          `auth`.`First_Name`,
          `auth`.`Last_Name`     
        FROM
          `authors` `auth`
        WHERE
          `auth`.`id` = {id}
      """).on('id -> authorId).as(AuthorDetailSimple singleOpt)).get
      println("UserDAOImpl.checkForAuthorId finished")
      auth
    } 
   }
  
   def checkForBookId(bookId : Int) : Book = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForBookId started")
      val bd = (SQL("""
        SELECT
          `book`.`id`,
          `book`.`ISBN`,   
          `book`.`Book_title`,
          `book`.`date_of_publication`,
          `book`.`bookCount`,
          `book`.`campusId`     
        FROM
          `books` `book`
        WHERE
          `book`.`id` = {id}
      """).on('id -> bookId).as(BookSimple singleOpt)).get
      println("UserDAOImpl.checkForBookId finished")
      bd
    } 
   }
   
   def authortUpdate(authorDetail : Author,authorId : Int) : Unit = {
      DB.withConnection { implicit conn =>
      println("Author Update Started : "+authorId)
      val res : Long = SQL("""
      UPDATE `authors` `auth` SET
          `auth`.`First_Name` = {First_Name},
          `auth`.`Last_Name` = {Last_Name}     
      WHERE
        `auth`.`id` = {id}
      """) on (
        'First_Name -> authorDetail.First_Name,
        'Last_Name -> authorDetail.Last_Name,
        'id -> authorId) executeUpdate ()
      println(res,"Author Update Rocks")
      } 
   }
  
   def bookUpdate(bookDetail : Book,bookId : Int) : Unit = {
     DB.withConnection { implicit conn =>
      println("Book Update Started : "+bookId)
      val res : Long = SQL("""
      UPDATE `books` `book` SET
          `book`.`ISBN` = {ISBN},   
          `book`.`Book_title` = {Book_title},
          `book`.`date_of_publication` = {date_of_publication},
          `book`.`bookCount` = {bookCount},
          `book`.`campusId` = {campusId}  
      WHERE
        `book`.`id` = {id}
      """) on (
        'ISBN -> bookDetail.ISBN,
        'Book_title -> bookDetail.Book_title,
        'date_of_publication -> bookDetail.date_of_publication, 
        'bookCount -> bookDetail.bookCount,
        'campusId -> bookDetail.campusId,
        'id -> bookId) executeUpdate ()
      println(res,"Book Update Rocks")
      } 
   }
   
   def updateBookAuthorDetails(bookId : Int,authorId : Int) : Unit = {
     DB.withConnection { implicit conn =>
        println("UserDAOImpl.updateBookAuthorDetails started")
      SQL("""
      update `books_authors_mapping` SET
        `Books_id` = {Books_id}, 
        `Authors_id` = {Authors_id}
        where
        `Books_id` = {Books_id}
        AND
        `Authors_id` = {Authors_id}
      """) on ('Books_id ->bookId,'Authors_id -> authorId) executeInsert()
        println("UserDAOImpl.updateBookAuthorDetails finished")
     }
   }
   
   def updateBookCategories(bookId : Int,bookCategoriesId : Int) : Unit = {
     DB.withConnection { implicit conn =>
        println("UserDAOImpl.updateBookCategories started")
          val bc = (SQL("""
      update `books_book_categories_mapping` SET
        `Books_id` = {Books_id},
        `Book_Categories_id` = {Book_Categories_id}
        where
        `Books_id` = {Books_id}
        AND
        `Book_Categories_id` = {Book_Categories_id}
      """) on ('Books_id ->bookId,'Book_Categories_id ->bookCategoriesId))executeInsert ()
      println("UserDAOImpl.updateBookCategories end")
     }
   }
   
   def checkForBookIssueId(bookIssueId : Int) : BookIssue ={
     DB.withConnection { implicit conn =>
       println("UserDAOImpl.checkForBookIssueId started")
       val bookisu = (SQL("""
        select 
            `id`,
            `stdUserId`,
            `bookid`, 
            `date_issued`, 
            `date_due_for_return`,
            `date_returned`,
            `amount_of_fine`,
            `libUserId`,
            `bookReturnFlag`,
            `libRetId`
        from
            `books_issued`
        where 
            `id` = {id}
     """).on('id -> bookIssueId).as(BookIssueSimple singleOpt)).get
      println("UserDAOImpl.checkForBookIssueId finished")
      bookisu
   }
}
   
      
   def bookIssueUpdate(bookIssue : BookIssue,bookIssueId : Int) : Unit = {
       DB.withConnection { implicit conn =>
       println("UserDAOImpl.bookIssueUpdate started")
       val res : Long = SQL("""
        update `books_issued` set
        `stdUserId` = {stdUserId},
        `bookid` = {bookid}, 
        `date_issued` = {date_issued}, 
        `date_due_for_return` = {date_due_for_return},
        `date_returned` = {date_returned},
        `amount_of_fine` = {amount_of_fine},
        `libUserId` = {libUserId},
        `bookReturnFlag` = {bookReturnFlag},
        `libRetId` = {libRetId}
        where
         `id` = {id}
      """) on (
          'stdUserId ->bookIssue.stdUserId,
          'bookid ->bookIssue.bookid,
          'date_issued -> bookIssue.date_issued,
          'date_due_for_return -> bookIssue.date_due_for_return,
          'date_returned -> bookIssue.date_returned,
          'amount_of_fine -> bookIssue.amount_of_fine,
          'libUserId -> bookIssue.libUserId,
          'bookReturnFlag -> bookIssue.bookReturnFlag,
          'libRetId -> bookIssue.libRetId,
          'id -> bookIssueId)executeUpdate ()
      println(res,"Book Issue Update Rocks")
      } 
   }
   
   
   def checkForUserId(userId : Long) : UserDTO = {
    DB.withConnection { implicit conn =>
    println(" checkForUserId UserDAO IMPL user ID : "+userId)
    SQL("""
        SELECT
          `user`.`id`,
          `user`.`Firstname`,
          `user`.`MiddleName`,
          `user`.`Lastname`,
          `user`.`DOB`,
          `user`.`Gender`,
          `user`.`Address1`,
          `user`.`Address2`,
          `user`.`City`,
          `user`.`State`,
          `user`.`Deleted`
          FROM
          `user`
           WHERE
           `user`.`id` = {id}
           
      """).on('id -> userId).as(UserSimple singleOpt).get
        }
   }
   
   def checkForUserLoginId(userLoginId : Long) : UserLogin = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForUserLoginId started")
      val ul = (SQL("""
        SELECT
          `ul`.`ulogId`,   
          `ul`.`email`,
          `ul`.`phone_number`,
          `ul`.`verified`,          
          `ul`.`user_id`          
        FROM
          `user_login` `ul`
        WHERE
          `ul`.`ulogId` = {ulogId}
      """).on('ulogId -> userLoginId).as(UserLoginSimple singleOpt)).get
      println("UserDAOImpl.checkForUserLoginId finished")
      ul
    }
   }
   
   def checkForUserContextId(userContextId : Long) : UserContext = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForUserContextId begin ",userContextId)
      val c = SQL("""
      select
     `uc`.`id`,`uc`.`user_id`,`uc`.`context_id`,`uc`.`campus_id` 
      from 
         `user_context` `uc` 
      where 
         `uc`.`user_id`={id} 
        """).on('id -> userContextId).as(UserContextSimple singleOpt).get
      println("UserDAOImpl.checkForUserContextId finished")
     c
     }
   }
   
   def checkForLibrarianId(librarianId : Long) : Librarian = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.checkForLibrarianId started")
      val libdet = (SQL("""
        SELECT
          `lib`.`libId`,   
          `lib`.`user_id`       
        FROM
          `librarian` `lib`
        WHERE
          `lib`.`libId` = {libId}
      """).on('libId -> librarianId).as(LibrarianSimple singleOpt)).get
      println("UserDAOImpl.checkForLibrarianId finished")
      libdet
    }
   }
   
   
   def userUpdate(user : User,userId : Long) : Unit = {
     DB.withConnection { implicit conn =>
       println("UserDAOImpl.userUpdate started")
       val res : Long = SQL("""
        update `user` set
          `user`.`Firstname` = {Firstname},
          `user`.`MiddleName` = {MiddleName},
          `user`.`Lastname` = {Lastname},
          `user`.`DOB` = {DOB}, 
          `user`.`Gender` = {Gender},
          `user`.`Address1` = {Address1},
          `user`.`Address2` = {Address2},
          `user`.`City` = {City},
          `user`.`State` = {State},
          `user`.`Deleted` = {Deleted}
        where
         `user`.`id` = {id}
      """) on (
          'Firstname ->user.firstName,
          'MiddleName ->user.middleName,
          'Lastname -> user.lastName,
          'DOB -> user.DOB,
          'Gender -> user.Gender,
          'Address1 -> user.address1,
          'Address2 -> user.address2,
          'City -> user.city,
          'State -> user.state,
          'Deleted -> 1L,
          'id -> userId )executeUpdate ()
      println(res,"User Update Issue Update Rocks")
      } 
   }
   
   def userLoginUpdate(userLogin : UserLogin,userLoginId : Long) : Unit = {
     DB.withConnection { implicit conn =>
       println("UserDAOImpl.userLoginUpdate started")
       val res : Long = SQL("""
        update `user_login` `ul` set
          `ul`.`email` = {email},
          `ul`.`phone_number` = {phone_number},
          `ul`.`verified` = {verified},          
          `ul`.`user_id` = {user_id}
        where
         `ul`.`ulogId` = {ulogId}
      """) on (
          'email ->userLogin.email,
          'phone_number ->userLogin.phoneNumber,
          'verified -> userLogin.verified,
          'user_id -> userLogin.userId,
          'ulogId -> userLoginId)executeUpdate ()
      println(res,"User Login Update Rocks")
      } 
   }
   
   def updateUserContext(userContext : UserContext,userContextId : Long) : Unit = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateUserContext begin ",userContextId)
      println("User Id : "+userContext.userId+" Context Id : "+userContext.contextId+" Campus ID : "+userContext.campusId)
      val c = SQL("""
      update `user_context` `uc` SET
             `uc`.`user_id` = {user_id},
             `uc`.`context_id` = {context_id},
             `uc`.`campus_id` = {campus_id}
      where 
         `uc`.`id`={id} 
        """) on(
            'user_id -> userContext.userId,
            'context_id -> userContext.contextId,
            'campus_id -> userContext.campusId,
            'id -> userContextId) executeUpdate()
      println(c,"UserDAOImpl.Update User Context Rocks finished")
     c
     }
   }
   
   def updateLibrarian(librarian : Librarian,librarianId : Long) : Unit = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateLibrarian Started")
      val libdet = SQL("""
        Update `librarian` `lib` SET
          `lib`.`user_id` = {user_id}       
        WHERE
          `lib`.`libId` = {libId}
      """)on
         ('user_id -> librarian.user_id,
          'libId -> librarianId)executeUpdate()
      println(libdet,"UserDAOImpl.updateLibrarian Rocks")
      libdet
    }
   }
   
   def getUserLoginIdByUserId(userId : Long) : UserLogin = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getUserLoginIdByUserId started")
      val ul = (SQL("""
        SELECT
          `ul`.`ulogId`,   
          `ul`.`email`,
          `ul`.`phone_number`,
          `ul`.`verified`,          
          `ul`.`user_id`          
        FROM
          `user_login` `ul`
        WHERE
          `ul`.`user_id` = {user_id}
      """).on('user_id -> userId).as(UserLoginSimple singleOpt)).get
      println("UserDAOImpl.getUserLoginIdByUserId finished")
      ul
    }
   } 
  
    def getUserContextIdByUserIdANDContextId(userId : Long, contextId : Long) : UserContext = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getUserContextIdByUserIdANDContextId begin "+userId+" Context : "+contextId)
      val c = SQL("""
      select distinct
       `uc`.`id`,`uc`.`user_id`,`uc`.`context_id`,`uc`.`campus_id` 
      from 
         `user_context` `uc` 
      where 
         `uc`.`user_id`={user_id} 
         AND `uc`.`context_id` = {context_id}
        """).on('user_id -> userId,'context_id -> contextId).as(UserContextSimple singleOpt).get
      println("UserDAOImpl.getUserContextIdByUserIdANDContextId finished")
     c
     }
    }
  
    def getDriverIdByUserId(userId : Long) : DriverInfo= {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.createDriverDetails center")
      val dd = (SQL("""
        SELECT
          `driDet`.`dId`,   
          `driDet`.`DLno`,
          `driDet`.`user_id`,
          `driDet`.`vehicleId`     
        FROM
          `driver_details` `driDet`
        WHERE
          `driDet`.`user_id` = {user_id}
      """).on('user_id -> userId).as(driverSimple singleOpt)).get
      println("UserDAOImpl.createDriverDetails finished")
      dd
    }   
      
    }
    
    def updateDriver(driverDetails : DriverInfo,driverId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateDriver Started")
      val libdet = SQL("""
        Update `driver_details` `driDet` SET
          `driDet`.`DLno` = {DLno},
          `driDet`.`user_id` = {user_id},
          `driDet`.`vehicleId` = {vehicleId}      
        WHERE
          `driDet`.`dId` = {dId}
      """)on
         ('DLno -> driverDetails.DLno,
          'user_id -> driverDetails.user_id,
          'vehicleId -> driverDetails.vehicleid,
          'dId -> driverId)executeUpdate()
      println(libdet,"UserDAOImpl.updateDriver Rocks")
      libdet
    }
    }
    
    def getStaffDetailByUserId(userId : Long) : Staff = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStaffDetailByUserId started")
      val sd = (SQL("""
        SELECT
          `sd`.`id`,   
          `sd`.`user_id`,
          `sd`.`vehicleid`       
        FROM
          `staff_details` `sd`
        WHERE
          `sd`.`user_id` = {user_id}
      """).on('user_id -> userId).as(StaffSimple singleOpt)).get
      println("UserDAOImpl.getStaffDetailByUserId finished")
      sd
    }
    }
    
    def getStaffSubjectMapByUserId(userId : Long) : StaffSubjectMap = {
     DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStaffSubjectMapByUserId started")
      val ssmap = (SQL("""
        SELECT
          `ssm`.`stfSubMapId`, 
          `ssm`.`subId`,
          `ssm`.`userId`
        FROM
          `staff_subject_map` `ssm`
        WHERE
          `ssm`.`userId` = {userId}
      """).on('userId -> userId).as(StaffSubjectMapSimple singleOpt)).get
      println("UserDAOImpl.getStaffSubjectMapByUserId finished")
      ssmap
      }
    }
    
    def updateStaff(staffDetails : Staff,staffId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateStaff Started")
      val staff = SQL("""
        Update `staff_details` `sd` SET
          `sd`.`user_id` = {user_id},
          `sd`.`vehicleid` = {vehicleid}      
        WHERE
          `sd`.`id` = {id}   
      """)on
         ('user_id -> staffDetails.userId,
          'vehicleid -> staffDetails.vehicleId,
          'id -> staffId)executeUpdate()
      println(staff,"UserDAOImpl.updateStaff Rocks")
      staff
    }
    }
    
    def updateStaffSubjectMap(staffSubjectMap : StaffSubjectMap,stfSubMapId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateStaffSubjectMap Started")
      val staffSubMap = SQL("""
        Update `staff_subject_map` `ssm` SET
          `ssm`.`subId` = {subId},
          `ssm`.`userId` = {userId} 
        WHERE
          `ssm`.`stfSubMapId` = {stfSubMapId}
      """)on
         ('subId -> staffSubjectMap.subjectId,
          'userId -> staffSubjectMap.userId,
          'stfSubMapId -> stfSubMapId)executeUpdate()
      println(staffSubMap,"UserDAOImpl.updateStaffSubjectMap Rocks")
      staffSubMap
    }
    }
    
    def getGuardainDetailByUserId(userId : Long) : GuardianDetail = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getGuardainDetailByUserId started")
      val gd = (SQL("""
        SELECT
          `gd`.`gId`,   
          `gd`.`user_id`,
          `gd`.`relationship`,
          `gd`.`mobile`,   
          `gd`.`income`,
          `gd`.`education`,
          `gd`.`stdadmissionno`       
        FROM
          `guardian` `gd`
        WHERE
          `gd`.`user_id` = {user_id}
      """).on('user_id -> userId).as(GuardianDetailsSimple singleOpt)).get
      println("UserDAOImpl.getGuardainDetailByUserId finished")
      gd
    }
    }
    
    def updateGuardianDetails(guardianDetails : GuardianDetail,guardainDetailId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateGuardianDetails Started")
      val gd = SQL("""
        Update `guardian` `gd` SET
          `gd`.`user_id` = {user_id},
          `gd`.`relationship` = {relationship},
          `gd`.`mobile` = {mobile},   
          `gd`.`income` = {income},
          `gd`.`education` = {education},
          `gd`.`stdadmissionno` = {stdadmissionno}
        WHERE
          `gd`.`gId` = {gId}
      """)on
         ('user_id -> guardianDetails.user_id,
          'relationship -> guardianDetails.relationship,
          'mobile -> guardianDetails.mobile,
          'income -> guardianDetails.income,
          'education -> guardianDetails.education,
          'stdadmissionno -> guardianDetails.stdadmissionno,
          'gId -> guardainDetailId)executeUpdate()
      println(gd,"UserDAOImpl.updateGuardianDetails Rocks")
      gd
    }
    }
    
    def getStudentDetailByUserId(studentUserId : Long) : StudentDetail = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentDetailByUserId started")
      val std = (SQL("""
        SELECT
          `stdDet`.`sdId`,   
          `stdDet`.`user_id`,
          `stdDet`.`Studentadminno`,
          `stdDet`.`vehicleId`
    
        FROM
          `Student_Details` `stdDet`
        WHERE
          `stdDet`.`user_id` = {user_id}
      """).on('user_id -> studentUserId).as(studentDetailsSimple singleOpt)).get
      println("UserDAOImpl.getStudentDetailByUserId finished")
      std
    }   
    }
    
    def getStudentClassMapDetailByUserId(userId : Long) : StudentClassMapping = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStudentClassMapDetailByUserId started")
      val stdClsMap = (SQL("""
        SELECT
          `stdcls`.`id`,   
          `stdcls`.`user_id`,
          `stdcls`.`class_id`         
        FROM
          `student_class` `stdcls`
        WHERE
          `stdcls`.`user_id` = {user_id}
      """).on('user_id -> userId).as(insertStudentClassMap singleOpt)).get
      println("UserDAOImpl.getStudentClassMapDetailByUserId finished")
      stdClsMap
    }
    }
    
    def getUserTermDetailByUserId(userId : Long) : UserTerm = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getUserTermDetailByUserId started")
      val ut = (SQL("""
        SELECT
          `ut`.`id`,   
          `ut`.`user_id`,
          `ut`.`term_id`,
          `ut`.`active`,
          `ut`.`deleted`          
        FROM
          `user_term` `ut`
        WHERE
          `ut`.`user_id` = {user_id}
      """).on('user_id -> userId).as(CreateUserTerm singleOpt)).get
      println("UserDAOImpl.getUserTermDetailByUserId finished")
      ut
    }
    }
    
    def updateStudentDetails(studentDetail : StudentDetail,studentId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateStudentDetails Started : "+studentId)
      val stdup = SQL("""
        Update `Student_Details` `stdDet` SET
          `stdDet`.`user_id` = {user_id},
          `stdDet`.`Studentadminno` = {Studentadminno},
          `stdDet`.`vehicleId` = {vehicleId}
        WHERE
          `stdDet`.`sdId` = {sdId}
      """)on
         ('user_id -> studentDetail.user_id,
          'Studentadminno -> studentDetail.Studentadminno,
          'vehicleId -> studentDetail.vehicleId,
          'sdId -> studentId)executeUpdate()
      println(stdup,"UserDAOImpl.updateStudentDetails Rocks ")
      stdup
    }
    }
    
    def updateStudentClassMap(studentClassMap : StudentClassMapping,studentClassMapId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateStudentClassMap Started")
      val stdClsMap = SQL("""
        Update `student_class` `stdcls` SET
          `stdcls`.`user_id` = {user_id},
          `stdcls`.`class_id` = {class_id}  
        WHERE
          `stdcls`.`id` = {id}
      """)on
         ('user_id -> studentClassMap.user_id,
          'class_id -> studentClassMap.class_id,
          'id ->studentClassMapId)executeUpdate()
      println(stdClsMap,"UserDAOImpl.updateStudentClassMap Rocks")
      stdClsMap
    }
    }
    
    def updateUserTermDetails(userTermDetails : UserTerm,userTermId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateUserTermDetails Started")
      val ut = SQL("""
        Update `user_term` `ut` SET
          `ut`.`user_id` = {user_id},
          `ut`.`term_id` = {term_id},
          `ut`.`active` = {active},
          `ut`.`deleted` = {deleted} 
        WHERE
          `ut`.`id` = {id}
      """)on
         ('user_id -> userTermDetails.user_id,
          'term_id -> userTermDetails.term_id,
          'active -> userTermDetails.active,
          'deleted -> userTermDetails.deleted,
          'id -> userTermId)executeUpdate()
      println(ut,"UserDAOImpl.updateUserTermDetails Rocks")
      ut
    }
    }
    
    def getVehicleDetailByVehicleId(vehicleId : Long) : VehicleDetail = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getVehicleDetailByVehicleId started : "+vehicleId)
      val vd = (SQL("""
        SELECT
          `vdet`.`vdId`,   
          `vdet`.`Vehicle_no`,
          `vdet`.`Vehicle_code`,
          `vdet`.`No_of_Seat`,
          `vdet`.`Maximum_capacity`,   
          `vdet`.`insurance`,
          `vdet`.`tax_remitted`,
          `vdet`.`permit`,
          `vdet`.`status`,
          `vdet`.`Vehicle_type_id`,
          `vdet`.`campusId`
        FROM
          `vehicle_details` `vdet`
        WHERE
          `vdet`.`vdId` = {vdId}
      """).on('vdId -> vehicleId).as(CreateVehicleDetails singleOpt)).get
      println("UserDAOImpl.getVehicleDetailByVehicleId finished")
      vd
    }   
    }
    
    def vehicleDetailsUpdate(vehicleDetail : VehicleDetail,vehicleId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.vehicleDetailsUpdate Started")
      val vd = SQL("""
        Update  `vehicle_details` `vdet` SET
          `vdet`.`Vehicle_no` = {Vehicle_no},
          `vdet`.`Vehicle_code` = {Vehicle_code},
          `vdet`.`No_of_Seat` = {No_of_Seat},
          `vdet`.`Maximum_capacity` = {Maximum_capacity},   
          `vdet`.`insurance` = {insurance},
          `vdet`.`tax_remitted` = {tax_remitted},
          `vdet`.`permit` = {permit},
          `vdet`.`status` = {status},
          `vdet`.`Vehicle_type_id` = {Vehicle_type_id},
          `vdet`.`campusId` = {campusId}
        WHERE
          `vdet`.`vdId` = {vdId}
      """)on
         ('Vehicle_no -> vehicleDetail.Vehicle_no,
          'Vehicle_code -> vehicleDetail.Vehicle_code,
          'No_of_Seat -> vehicleDetail.No_of_Seat,
          'Maximum_capacity -> vehicleDetail.Maximum_capacity,
          'insurance -> vehicleDetail.insurance,
          'tax_remitted -> vehicleDetail.tax_remitted,
          'permit -> vehicleDetail.permit,
          'status -> vehicleDetail.status,
          'Vehicle_type_id -> vehicleDetail.Vehicle_type_id,
          'campusId -> vehicleDetail.campusId,
          'vdId -> vehicleId)executeUpdate()
      println(vd,"UserDAOImpl.vehicleDetailsUpdate Rocks")
      vd
    }
    }
    
    def getRouteDetailByVehicleId(vehicleId : Long) : RouteDetail = {
       DB.withConnection { implicit conn =>
      println("UserDAOImpl.getRouteDetailByVehicleId started")
      val rdet = (SQL("""
        SELECT
          `rdet`.`rdId`,   
          `rdet`.`Route_Name`,
          `rdet`.`No_of_Stops`,
          `rdet`.`Vehicle_id`
        FROM
          `route_details` `rdet`
        WHERE
          `rdet`.`Vehicle_id` = {Vehicle_id}
      """).on('Vehicle_id -> vehicleId).as(CreateRouteDetail singleOpt)).get
      println("UserDAOImpl.getRouteDetailByVehicleId finished")
      rdet
    }   
    }
    
     def updateRoute(route : RouteDetail,routeDetailId : Long) : Unit = {
       DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateRoute Started")
      val rt = SQL("""
        Update  `route_details` `rdet` SET
          `rdet`.`Route_Name` = {Route_Name},
          `rdet`.`No_of_Stops` = {No_of_Stops},
          `rdet`.`Vehicle_id` = {Vehicle_id}
        WHERE
          `rdet`.`rdId` = {rdId}
      """)on
         ('Route_Name -> route.Route_Name,
          'No_of_Stops -> route.No_of_Stops,
          'Vehicle_id -> route.Vehicle_id,
          'rdId -> routeDetailId)executeUpdate()
      println(rt,"UserDAOImpl.updateRoute Rocks")
      rt
    }
     }
    
    def getStopDetailByRouteId(routeId : Long) : List[StopDetail] = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getStopDetailByRouteId started : "+routeId)
      val stpdet = (SQL("""
        SELECT
          `stpdet`.`id`,   
          `stpdet`.`Stop_Name`,
          `stpdet`.`fare`,
          `stpdet`.`Arival_Mrng`,
          `stpdet`.`Departure_Mrng`,   
          `stpdet`.`Arival_Evng`,
          `stpdet`.`Departure_Evng`,
          `stpdet`.`Route_details_id`
        FROM
          `stop_details` `stpdet`
        WHERE
          `stpdet`.`Route_details_id` = {Route_details_id}
      """).on('Route_details_id -> routeId).as(CreateStopDetail *))
      println("UserDAOImpl.getStopDetailByRouteId finished")
      stpdet
    }   
    }
    
    def updateStopDetail(stop : StopDetail,stopDetailId : Long) : Unit = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.updateStopDetail Started")
      val stp = SQL("""
        Update   `stop_details` `stpdet` SET
          `stpdet`.`Stop_Name` = {Stop_Name},
          `stpdet`.`fare` = {fare},
          `stpdet`.`Arival_Mrng` = {Arival_Mrng},
          `stpdet`.`Departure_Mrng` = {Departure_Mrng},   
          `stpdet`.`Arival_Evng` = {Arival_Evng},
          `stpdet`.`Departure_Evng` = {Departure_Evng},
          `stpdet`.`Route_details_id` = {Route_details_id}
        WHERE
          `stpdet`.`id` = {id}
      """)on
         ('Stop_Name -> stop.Stop_Name,
          'fare -> stop.fare,
          'Arival_Mrng -> stop.Arival_Mrng,
          'Departure_Mrng -> stop.Departure_Mrng,
          'Arival_Evng -> stop.Arival_Evng,
          'Departure_Evng -> stop.Departure_Evng,
          'Route_details_id -> stop.Route_details_id,
          'id -> stopDetailId)executeUpdate()
      println(stp,"UserDAOImpl.updateStopDetail Rocks")
      stp
    }
    }
    
    def getHolidayDetailsBySystemCurrentDate(campusId : Long) : List[Holiday] = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getHolidayDetailsBySystemCurrentDate started")
      val hd = (SQL("""
        SELECT
         `holidays`.`hId`,
         `holidays`.`holidayDate`,
         `holidays`.`holidayName`,
         `holidays`.`hoildayDesc`,
         `holidays`.`campusId`,
         `holidays`.`messageFlag`
        FROM
          `holidays`
        WHERE
         DATE(holidayDate) = DATE(CURDATE()+1)
         AND messageFlag != 1
      """).on('campusId -> campusId).as(HolidaySimple *))
      println("UserDAOImpl.getHolidayDetailsBySystemCurrentDate finished")
      hd
    } 
    }
    
    def updateHolidayForMessageFlagByHolidayId(holidayId : Int) : Unit = {
       DB.withConnection { implicit conn =>
      println("Holiday Update Started : "+holidayId)
      val res : Long = SQL("""
      UPDATE `holidays` SET
       `holidays`.`messageFlag` = {messageFlag}
      WHERE
        `holidays`.`hId` = {hId}
      """) on (
        'messageFlag -> 1,
        'hId -> holidayId) executeUpdate ()
      println(res,"Holiday Update Rocks")
      } 
    }
    
    def getEventListBySYstemCurrentDateAndBycmapusId(campusId : Long) : List[EventsUser] = {
      DB.withConnection { implicit conn =>
      println("UserDAOImpl.getEventListBySYstemCurrentDateAndBycmapusId started")
      val eusr = (SQL("""
       SELECT distinct
        `evd`.`eId`,
        `evd`.`evId`,
        `evm`.`Name`,
        `evm`.`desc`,
        `evd`.`startDate`,
        `evd`.`endDate`,
        `evd`.`studId`,
        `evd`.`campusId`,
        `evm`.`status`,
        `evd`.`messageFlag`
        FROM
          `events_master` `evm`, `events_details` `evd`,`class` `cls`, `term` `trm`
        WHERE
         `evd`.`campusId` = {campusId}
         AND `evd`.`evId` = `evm`.`evId`
         AND `cls`.`campus_id` = `evd`.`campusId`
         AND `trm`.`id` = `cls`.`term_id`
         AND `trm`.`active` = 1
         AND DATE(`evd`.`startDate`) = DATE(CURDATE()+1) 
         AND `evd`.`messageFlag` != 1
      """).on('campusId -> campusId).as(EventUserSimple *))
      println("UserDAOImpl.getEventListBySYstemCurrentDateAndBycmapusId finished")
      eusr
      }
    }
    
    
    def updateEventForMessageFlagByEventId(eventId : Int) : Unit = {
      DB.withConnection { implicit conn =>
      println("Event Update Started : "+eventId)
      val res : Long = SQL("""
      UPDATE `events_details` `evn` SET
       `evn`.`messageFlag` = {messageFlag}
      WHERE
        `evn`.`eId` = {eId}
      """) on (
        'messageFlag -> 1,
        'eId -> eventId) executeUpdate ()
      println(res,"Event Update Rocks")
      } 
    }
    
} 
  
