package models.services

import javax.inject.Inject
import models.daos.MiscDAO
import models.commons.Context
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent._
import models.commons.Campus
import models.users.Organization
import models.users.CampusUser


class MiscServiceImpl @Inject() (miscDao: MiscDAO) extends MiscService{
  
	def getUserRoles(): Future[List[Context]] = Future {
		miscDao.getUserRoles()
  }
	
	def getAllOrganization() : List[Organization] = {
   miscDao.getAllOrganization() 
  }
	def getAllCampusByOrganizationId(orgId : Int): Future[List[CampusUser]] = Future {
		miscDao.getAllCampusByOrganizationId(orgId)
  }

}