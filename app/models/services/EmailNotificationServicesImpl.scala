package models.services

import play.api.Play.current
import scala.concurrent.Future
import dtos.UserDTO
//import java.net.URL
import play.api.libs.concurrent.Execution.Implicits._
import com.amazonaws.AmazonClientException
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.regions.{ Region, Regions }
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient
import com.amazonaws.services.simpleemail.model.{ Body, Content, Destination, Message, SendEmailRequest }
import javax.inject.Inject
import models.daos.UserDAO
//import _root_.exceptions.{ServiceLayerException,UserSeverityLevel}

class EmailNotificationServiceAmazonSESImpl @Inject() (implicit val userDAO: UserDAO) extends EmailNotificationService {
  override def sendPasswordResetInstructions(email: String): Future[Unit] = Future {
    val ctx = s"sending forgot password email, email [$email]"
    val user = userDAO.byEmail(email) match {
      case Some(u) => u
    }
    val FROM = current.configuration.getString("email.from").get // Replace with your "From" address. This address must be verified.
    val TO = email // Replace with a "To" address. If you have not yet requested
    // production access, this address must be verified.
    
    val BODY = "WELCOME TO MINDS".toString
    val SUBJECT = "Reset password at theApp.com"
    // Construct an object to contain the recipient address.
    val destination: Destination = new Destination().withToAddresses(TO)

    // Create the subject and body of the message.
    val subject = new Content().withData(SUBJECT)
    val textBody = new Content().withData(BODY)
    val body = new Body().withHtml(textBody)

    // Create a message with the specified subject and body.
    val message = new Message().withSubject(subject).withBody(body)

    // Assemble the email.
    val request = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message)

    val credentials:AWSCredentials = new AWSCredentials {
      override def getAWSAccessKeyId: String = current.configuration.getString("AWSAccessKeyId").get
      override def getAWSSecretKey: String = current.configuration.getString("AWSSecretKey").get
    }

    // Instantiate an Amazon SES client, which will make the service call with the supplied AWS credentials.
    val client = new AmazonSimpleEmailServiceClient(credentials)

    // Choose the AWS region of the Amazon SES endpoint you want to connect to. Note that your production
    // access status, sending limits, and Amazon SES identity-related settings are specific to a given
    // AWS region, so be sure to select an AWS region in which you set up Amazon SES. Here, we are using
    // the US East (N. Virginia) region. Examples of other regions that Amazon SES supports are US_WEST_2
    // and EU_WEST_1. For a complete list, see http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html
    val REGION = Region.getRegion(Regions.US_EAST_1)
    client.setRegion(REGION)
    println(" From Email : "+FROM)
    println(" To Email : "+TO)
    client.sendEmail(request)
  }
  
  override def sendPasswordChangedEmail(user: UserDTO): Future[Unit] = Future {
    ()
  }
}
