package models.daos


import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import security.models.StudentDetail


class StudentDAOImpl extends StudentDAO {
  
  val StudentSimple = {
   
      get[Long]("sdId") ~
      get[Long]("user_id") ~
      get[String]("Studentadminno") ~
      get[Option[Long]]("vehicleId") map {
        case (id ~ ucid ~ stadno ~ vid) => StudentDetail(id = id, user_id = ucid, Studentadminno = stadno, vehicleId = vid)
      }
  }
  
  def create(user_context_id: Long, Studentadminno: String): StudentDetail = {
    val id = DB.withTransaction { implicit conn =>

      println("UserDAOImpl.create started")
      val id =    SQL("""
      INSERT INTO `Student_Details`
        (`user_id`, `Studentadminno`,`vehicleId`)
      VALUES
        ({user_id}, {Studentadminno},{vehicleId})
      """) on (
        'user_context_id -> user_context_id,
        'Studentadminno -> Studentadminno,
        'vehicleId -> 1) executeInsert (scalar[Long] single)

      id
    }

    DB.withTransaction { implicit conn =>
      println("StudentDetailsDAOImpl.create center")
      val std = (SQL("""
        SELECT
          `std`.`sdId`,
          `std`.`user_id`,
          `std`.`Studentadminno`,
          `std`.`vehicleId`
        FROM
          `Student_Details` `std`
        WHERE
          `std`.`sdId` = {id}
      """).on('sdId -> id).as(StudentSimple singleOpt)).get
      println("StudentDetailsDAOImpl.create finished")
      std
    }
  }

}