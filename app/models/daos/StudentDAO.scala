package models.daos

import security.models.StudentDetail


trait StudentDAO {
  /*def byId(id: Long): Option[StudentDetails]
  def byUserName(username: String): Option[StudentDetails]*/
  
  def create(user_context_id: Long, Studentadminno: String): StudentDetail
 
}
