package models.services

import models.daos.StudentDAO
import javax.inject.Inject
import scala.concurrent.Future
import models.users.User

class StudentServiceImpl @Inject() (studentDAO: StudentDAO) extends StudentService {
  
  

}