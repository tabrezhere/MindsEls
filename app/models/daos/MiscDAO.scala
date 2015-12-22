package models.daos

import models.commons.Context
import models.commons.Campus
import models.users.Organization
import models.users.CampusUser

trait MiscDAO {
  
  def getUserRoles(): List[Context]
  def getAllOrganization() : List[Organization]
  def getAllCampusByOrganizationId(orgId : Int): List[CampusUser]

}