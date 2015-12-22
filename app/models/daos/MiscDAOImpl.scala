package models.daos

import models.commons.Context
import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import models.commons.Campus
import models.commons.Campus
import models.users.Organization
import models.users.CampusUser

class MiscDAOImpl extends MiscDAO{
  
  
  val ContextSimple = {    
		  get[Int]("id") ~
		  get[String]("context") map {
		    case(id ~ ctxt) => Context(id = id, context = ctxt)
		  }
    
  }
  
  
  
   val CampusUserSimple = {    
		  get[Int]("cmId") ~
		  get[String]("campus_name") ~
      get[String]("campusAddress") ~
      get[String]("campusLocation") ~
      get[Int]("organization_id") ~
		  get[String]("name")  map {
		    case(id ~ cps ~ cmpAdd ~ cmpLoc ~ oid ~ orgnm) => CampusUser(id = id, campus_name = cps,campusAddress = cmpAdd, campusLocation = cmpLoc, organization_id = oid, organizationName= orgnm)
		  }
  }
   
  val OrganizationSimple = {
     get[Int]("oId") ~
     get[String]("name") ~
     get[String]("Type") ~
     get[Int]("activated") ~
     get[Int]("paid") ~
     get[Int]("deleted") map {
        case(id ~ nm ~ otyp ~ act ~ pad ~ del) => Organization(id = id, name = nm, Type = otyp, activated = act, paid = pad, deleted= del)
      }
  }
  
  def getUserRoles() : List[Context] = DB.withConnection { implicit conn =>
    
    SQL("""
        SELECT `id`,`context` FROM `CONTEXT` 
        """)  as (ContextSimple *)
  }
  
  def getAllOrganization() : List[Organization] = DB.withConnection { implicit conn =>
     SQL("""
        SELECT * FROM `organization` 
        """)  as (OrganizationSimple *)
  }
  
   def getAllCampusByOrganizationId(organization_id : Int) : List[CampusUser] = DB.withConnection { implicit conn =>
     println(" getAllCampusByOrganizationId DAOImpl Start orgID : "+organization_id)
    
    val campus = SQL("""
        SELECT 
        `cmp`.`cmId`,
        `cmp`.`campus_name`,
        `cmp`.`campusAddress`,
        `cmp`.`campusLocation`,
        `cmp`.`organization_id`,
        `org`.`name`
         FROM 
        `campus` `cmp`, `organization` `org`
         where
        `cmp`.`organization_id`={organization_id}
        AND `cmp`.`organization_id` = `org`.`oId`
        """).on('organization_id ->organization_id).as (CampusUserSimple *)
        println("getAllCampusByOrganizationId DAOImpl finished")
        campus
  }

}