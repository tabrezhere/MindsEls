package models.services

import scala.concurrent.Future
import models.commons.Context
import models.commons.Campus
import models.users.Organization
import models.users.CampusUser


trait MiscService {
  
  def getUserRoles(): Future[List[Context]]
  def getAllCampusByOrganizationId(orgId : Int): Future[List[CampusUser]]
  def getAllOrganization() : List[Organization]
}