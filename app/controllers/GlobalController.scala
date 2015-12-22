package controllers

import java.net.HttpURLConnection
import java.util.StringTokenizer
import java.net._
import services.UserService
import com.google.inject.Inject
import models.daos.UserDAOImpl
import scala.collection.mutable.ListBuffer
import models.users.GuardianUserWithStudentInfo
import javax.mail.Message.RecipientType
import org.codemonkey.simplejavamail.{TransportStrategy, Mailer, Email}
import java.net.HttpURLConnection

//import controllers.RestUserController

/**
 * @author ilyas
 */
class GlobalController {
  
  val userDAOImpl = new UserDAOImpl
  
  //val userService : UserService
  
  def sendMessageMethod(phoneNumber : Long,message1 : String) : Unit = {
    val st = new StringTokenizer(message1, " ");
    val sb = new StringBuffer();
    while(st.hasMoreElements()){
        sb.append(st.nextElement()).append("%20");
   }
   if(message1.contains(" ")){
     println(" If Block Message 1 : "+message1)
   }
   else{
     println(" Else Block Message 1 : "+message1)
   }
    val recipient: String  = phoneNumber.toString()
    println(" sendMessageMethod Phone Number : "+recipient)
    val  message : String  = sb.toString().trim();
    println(" sendMessageMethod Message : "+message)
    val username: String  = "Minds";
    val password: String  = "1358919004";
    val originator:String= "+440987654321";
    val sendername:String ="MINDSI";
    val mobileno:String  = phoneNumber.toString()
    println(" Enterd into send sms")
    val requestUrl:String = " http://bulksms.mysmsmantra.com:8080/WebSMS/SMSAPI.jsp?username=" +username+ "&password=" +password+ "&sendername=" +sendername+ "&mobileno=" +mobileno+ "&message=" +message.trim()+"";
    //println(" Rquest Url : "+requestUrl)
    val url = new URL(requestUrl);
    val conn = url.openConnection.asInstanceOf[HttpURLConnection]
    println("Connection Result Message : "+conn.getResponseMessage());
    conn.disconnect()
    println(" Message Rocks")
  }
  
  
  def emailSend = {
    val guardianUserList =  userDAOImpl.getAllGuardianListByCampusId(1)
    var campusId : Long = 0
    var holidayId : Int = 0
    for(guardianUser <- guardianUserList){
    campusId = guardianUser.campusId
    }
     val holidaysList = userDAOImpl.getHolidayDetailsBySystemCurrentDate(campusId)
     println(" Result Of H List : "+holidaysList)
     for(holidays <- holidaysList){
       holidayId = holidays.hId
       println(" Holiday Id : "+holidayId)
          for(guardianUser <- guardianUserList){
            sendMessageMethod(9986064613L,holidays.hoildayDesc)
            println(" Im from Guardian User ")
            val email = new Email()
            email.setFromAddress(" Ahmed Shareef ", "ahmedshareef07@yahoo.com");
            email.setSubject(holidays.holidayName);
            email.addRecipient(" Ahmed Shareef ", "ahmedshareef613@gmail.com", RecipientType.TO);
            email.setTextHTML("<img src='https://media.licdn.com/media/p/6/005/02e/3d3/30bab89.png'/><br/><font color='blue'><b>There is an Email Testing on Minds ELS Holiday! <br/> Tomorrow is Holiday <br/> Holiday Testing is going on..! </b><font><br/><font color='green'><b><i>"+holidays.hoildayDesc+"</i></b></font>");
            new Mailer("smtp.mail.yahoo.com", 465, "ahmedshareef07@yahoo.com", "\"9972aqsa\"", TransportStrategy.SMTP_SSL).sendMail(email);
      }
    }
     if(holidayId != 0){
     val updateHolidayResult = userDAOImpl.updateHolidayForMessageFlagByHolidayId(holidayId)
     }
     
     
     
     
     var eventId : Int = 0
     var eventCampusId : Long = 0
      //val guardianUserList =  userDAOImpl.getAllGuardianListByCampusId(1)
      for(guardianUser <- guardianUserList){
      eventCampusId = guardianUser.campusId
    }
     val eventList = userDAOImpl.getEventListBySYstemCurrentDateAndBycmapusId(eventCampusId)
     for(event <- eventList){
       eventId = event.id
       println(" Event Id : "+eventId)
          for(guardianUser <- guardianUserList){
            sendMessageMethod(9986064613L,event.desc)
            println(" Im from Guardian User ")
            val email = new Email()
            email.setFromAddress(" Ahmed Shareef ", "ahmedshareef07@yahoo.com");
            email.setSubject(event.name);
            email.addRecipient(" Ahmed Shareef ", "ahmedshareef613@gmail.com", RecipientType.TO);
            email.setTextHTML("<img src='https://media.licdn.com/media/p/6/005/02e/3d3/30bab89.png'/><br/><font color='blue'><b>There is an Email Testing on Minds ELS Holiday! <br/> Tomorrow is Holiday <br/> Holiday Testing is going on..! </b><font><br/><font color='green'><b><i>"+event.desc+"</i></b></font>");
            new Mailer("smtp.mail.yahoo.com", 465, "ahmedshareef07@yahoo.com", "\"9972aqsa\"", TransportStrategy.SMTP_SSL).sendMail(email);
      } 
   }
     if(eventId != 0){
       val updateEventResult = userDAOImpl.updateEventForMessageFlagByEventId(eventId)
       }
     }
}