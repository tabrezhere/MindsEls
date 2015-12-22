
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en" ng-app="theApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MindsEls- AngularJS Page</title>
<link rel="stylesheet" href='"""),_display_(/*8.31*/routes/*8.37*/.Assets.at("stylesheets/main.css")),format.raw/*8.71*/("""'>

<link rel="stylesheet" href='"""),_display_(/*10.31*/routes/*10.37*/.Assets.at("lib/bootstrap/css/bootstrap.css")),format.raw/*10.82*/("""'>
<link rel="stylesheet" href='"""),_display_(/*11.31*/routes/*11.37*/.Assets.at("lib/bootstrap/css/bootstrap-theme.min.css")),format.raw/*11.92*/("""'>
<link rel="stylesheet" href='"""),_display_(/*12.31*/routes/*12.37*/.Assets.at("lib/bootstrap/css/bootstrap-datetimepicker.css")),format.raw/*12.97*/("""'>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<script type="text/javascript" src='"""),_display_(/*15.38*/routes/*15.44*/.Assets.at("lib/bootstrap/js/bootstrap-datetimepicker.js")),format.raw/*15.102*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*16.38*/routes/*16.44*/.Assets.at("lib/jquery/jquery.min.js")),format.raw/*16.82*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*17.38*/routes/*17.44*/.Assets.at("lib/toastr/toastr.min.js")),format.raw/*17.82*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*18.38*/routes/*18.44*/.Assets.at("lib/bootstrap/js/bootstrap.min.js")),format.raw/*18.91*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*19.38*/routes/*19.44*/.Assets.at("lib/angularjs/angular.min.js")),format.raw/*19.86*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*20.38*/routes/*20.44*/.Assets.at("lib/angularjs/angular-resource.min.js")),format.raw/*20.95*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*21.38*/routes/*21.44*/.Assets.at("lib/angularjs/angular-route.min.js")),format.raw/*21.92*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*22.38*/routes/*22.44*/.Assets.at("lib/angularjs/angular-ui-router.min.js")),format.raw/*22.96*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*23.38*/routes/*23.44*/.Assets.at("lib/angularjs/dirPagination.js")),format.raw/*23.88*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*24.38*/routes/*24.44*/.Assets.at("lib/font-awesome/css/font-awesome.min.css")),format.raw/*24.99*/("""'></script>

<!-- <script type="text/javascript" src='"""),_display_(/*26.43*/routes/*26.49*/.Assets.at("lib/ui-router-extras/ct-ui-router-extras.js")),format.raw/*26.106*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*27.38*/routes/*27.44*/.Assets.at("lib/ui-router-extras/ct-ui-router-extras.sticky.js")),format.raw/*27.108*/("""'></script> -->


<script type="text/javascript" src='"""),_display_(/*30.38*/routes/*30.44*/.Assets.at("javascripts/app.js")),format.raw/*30.76*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*31.38*/routes/*31.44*/.Assets.at("javascripts/constants.js")),format.raw/*31.82*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*32.38*/routes/*32.44*/.Assets.at("javascripts/controllers.js")),format.raw/*32.84*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*33.38*/routes/*33.44*/.Assets.at("javascripts/directives.js")),format.raw/*33.83*/("""'></script>
 <script type="text/javascript" src='"""),_display_(/*34.39*/routes/*34.45*/.Assets.at("javascripts/services.js")),format.raw/*34.82*/("""'></script>
 <script type="text/javascript" src='"""),_display_(/*35.39*/routes/*35.45*/.Assets.at("javascripts/htmlcontrols/htmlcontroller.js")),format.raw/*35.101*/("""'></script>

<script type="text/javascript" src='"""),_display_(/*37.38*/routes/*37.44*/.Assets.at("javascripts/staff/staff.controller.js")),format.raw/*37.95*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*38.38*/routes/*38.44*/.Assets.at("javascripts/staff/stafflist.controller.js")),format.raw/*38.99*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*39.38*/routes/*39.44*/.Assets.at("javascripts/staff/staff.services.js")),format.raw/*39.93*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*40.38*/routes/*40.44*/.Assets.at("javascripts/staff/staff.apiservices.js")),format.raw/*40.96*/("""'></script>



<script type="text/javascript" src='"""),_display_(/*44.38*/routes/*44.44*/.Assets.at("javascripts/Login/login.controller.js")),format.raw/*44.95*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*45.38*/routes/*45.44*/.Assets.at("javascripts/Login/authentication.service.js")),format.raw/*45.101*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*46.38*/routes/*46.44*/.Assets.at("javascripts/Login/flash.service.js")),format.raw/*46.92*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*47.38*/routes/*47.44*/.Assets.at("javascripts/Login/user.service.js")),format.raw/*47.91*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*48.38*/routes/*48.44*/.Assets.at("javascripts/Login/userDetail.service.js")),format.raw/*48.97*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*49.38*/routes/*49.44*/.Assets.at("javascripts/register/register.controller.js")),format.raw/*49.101*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*50.38*/routes/*50.44*/.Assets.at("javascripts/admin/organization.controller.js")),format.raw/*50.102*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*51.38*/routes/*51.44*/.Assets.at("javascripts/admin/admin.controller.js")),format.raw/*51.95*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*52.38*/routes/*52.44*/.Assets.at("javascripts/admin/admin.controller.js")),format.raw/*52.95*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*53.38*/routes/*53.44*/.Assets.at("javascripts/admin/admin.service.js")),format.raw/*53.92*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*54.38*/routes/*54.44*/.Assets.at("javascripts/admin/adminpost.service.js")),format.raw/*54.96*/("""'></script>




<script type="text/javascript" src='"""),_display_(/*59.38*/routes/*59.44*/.Assets.at("javascripts/admin/adminAPI.service.js")),format.raw/*59.95*/("""'></script>


<!-- New Template Dependencies -->
<script type="text/javascript" src='"""),_display_(/*63.38*/routes/*63.44*/.Assets.at("partial-html-app/newTemplate/admin/newlogin.controller.js")),format.raw/*63.115*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*64.38*/routes/*64.44*/.Assets.at("partial-html-app/newTemplate/admin/newuser.service.js")),format.raw/*64.111*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*65.38*/routes/*65.44*/.Assets.at("partial-html-app/newTemplate/admin/newauth.service.js")),format.raw/*65.111*/("""'></script>

<script type="text/javascript" src='"""),_display_(/*67.38*/routes/*67.44*/.Assets.at("partial-html-app/admin/student/admin.stud.controller.js")),format.raw/*67.113*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*68.38*/routes/*68.44*/.Assets.at("partial-html-app/admin/staff/admin.staff.controller.js")),format.raw/*68.112*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*69.38*/routes/*69.44*/.Assets.at("partial-html-app/admin/transportation/admin.transport.controller.js")),format.raw/*69.125*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*70.38*/routes/*70.44*/.Assets.at("partial-html-app/admin/Campus/admin.campus.controller.js")),format.raw/*70.114*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*71.38*/routes/*71.44*/.Assets.at("partial-html-app/admin/Campus/admin.news.controller.js")),format.raw/*71.112*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*72.38*/routes/*72.44*/.Assets.at("partial-html-app/admin/library/library.controller.js")),format.raw/*72.110*/("""'></script>






</head>
<body ng-controller="AppCtrl">
	<!-- Static navbar -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				 <div class="row">
        <div class="col-sm-12 col-sm-offset-2">
          <div class="col-sm-1 ">
            <img  src='"""),_display_(/*92.25*/routes/*92.31*/.Assets.at("images/yeoman.png")),format.raw/*92.62*/("""' width="60" height="60">
          </div>
          <div class="col-sm-11 text-left">
            <h3><strong>Minds E Learning Student Information System - [MELSIS]</strong></h3>
            <hr >
          </div>
        </div>
    </div>
			</div>
			
			<!--/.nav-collapse -->
			 
		</div>
	</nav>
	


	<div class="col-md-12" ng-view>
	
	</div>
	 
	<div class="container">
		<div class="row">&nbsp;</div>
		<div class="alert alert-info ">
	    	<p class="text-center">Following will allow you to make API Calls</p>
	     </div>
		<nav class="navbar">
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#/index">Home</a></li>
					<!-- <li><a href="#/messages">Messages</a></li>
					<li><a href="#/users">Users</a></li> -->
					<li><a href="#/new_login">Log In</a></li>
					<li><a href="#/signupstudent">Sign Up staff</a></li>
					<li><a href="#/signupguardian">Guardian sign up </a></li>
					<li><a href="#/admindashboard">Admin Dashboard </a></li>
					<li><a ng-click="logout()" href>Logout</a></li>
					
					
					<li><a ng-click="getuserRoles()" href>User Roles</a></li>
					<li><a ng-click="getAllCampus()" href>All Campuses</a></li>
					
					
					<li><a ng-click="getUserById()" href>Get User Id 3</a></li>
					
					<li><a ng-click="getUserLoginByEmail()" href>Get UserLogin user1</a></li>
					
					<li><a ng-click="getUserContextById()" href>Get User Context</a></li>
					
					<li><a ng-click="getContextById()" href>Get Context</a></li>
					
					<li><a ng-click="getStaffDetails()" href>Get Staff Details</a></li>
					
					
					<li><a ng-click="getStudentDetails()" href>Get Student Details</a></li>
					
					<li><a ng-click="getGuardianDetails()" href>Get Guardian Details</a></li>
					
					<li><a href="#/dashboard">Dashboard</a></li>
					<li><a href="#/Guardiandashboard">Guardian Dashboard</a></li>
					<li><a href="#/admindashboard/1">Admin Dashboard</a></li>
					
					<li><a href="#/staffdashboard/1">Staff Dashboard</a></li>
					<li><a href="#/getstaff">userlist</a></li>
					<li><a href="#/staffdashboard">Staff Dashboard</a></li>
					<li><a href="#/getreddash">red dashboard</a></li>
					
				</ul>
				
			</div>
		</nav>
	</div>
	
	<!-- /container -->
	<div ui-view="organisationtab" ng-show="$state.includes('top.organisation')" class="col-sm-8"></div>
    <div ui-view="parenttab"    ng-show="$state.includes('top.parent')"    class="col-sm-8"></div>
    <div ui-view="stafftab"   ng-show="$state.includes('top.staff')"   class="col-sm-8"></div>

	<footer>
		<hr />
		<div>
			<span>&copy; MindsSolvit 2015</span>
		</div>
		<div>
			<span app-version></span>
		</div>
	</footer>
</body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Dec 15 17:47:28 IST 2015
                  SOURCE: E:/PlayWorkspace/tabrez/test jar/Eonline_22_15_tab/Eonline_22_15_tab/app/views/index.scala.html
                  HASH: d643a8c36a88247f1aa0a6cb357bb907ba788ebc
                  MATRIX: 580->0|878->272|892->278|946->312|1007->346|1022->352|1088->397|1148->430|1163->436|1239->491|1299->524|1314->530|1395->590|1570->738|1585->744|1665->802|1741->851|1756->857|1815->895|1891->944|1906->950|1965->988|2041->1037|2056->1043|2124->1090|2200->1139|2215->1145|2278->1187|2354->1236|2369->1242|2441->1293|2517->1342|2532->1348|2601->1396|2677->1445|2692->1451|2765->1503|2841->1552|2856->1558|2921->1602|2997->1651|3012->1657|3088->1712|3170->1767|3185->1773|3264->1830|3340->1879|3355->1885|3441->1949|3523->2004|3538->2010|3591->2042|3667->2091|3682->2097|3741->2135|3817->2184|3832->2190|3893->2230|3969->2279|3984->2285|4044->2324|4121->2374|4136->2380|4194->2417|4271->2467|4286->2473|4364->2529|4441->2579|4456->2585|4528->2636|4604->2685|4619->2691|4695->2746|4771->2795|4786->2801|4856->2850|4932->2899|4947->2905|5020->2957|5099->3009|5114->3015|5186->3066|5262->3115|5277->3121|5356->3178|5432->3227|5447->3233|5516->3281|5592->3330|5607->3336|5675->3383|5751->3432|5766->3438|5840->3491|5916->3540|5931->3546|6010->3603|6086->3652|6101->3658|6181->3716|6257->3765|6272->3771|6344->3822|6420->3871|6435->3877|6507->3928|6583->3977|6598->3983|6667->4031|6743->4080|6758->4086|6831->4138|6911->4191|6926->4197|6998->4248|7111->4334|7126->4340|7219->4411|7295->4460|7310->4466|7399->4533|7475->4582|7490->4588|7579->4655|7656->4705|7671->4711|7762->4780|7838->4829|7853->4835|7943->4903|8019->4952|8034->4958|8137->5039|8213->5088|8228->5094|8320->5164|8396->5213|8411->5219|8501->5287|8577->5336|8592->5342|8680->5408|9342->6043|9357->6049|9409->6080
                  LINES: 22->1|29->8|29->8|29->8|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|41->20|41->20|41->20|42->21|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|45->24|45->24|45->24|47->26|47->26|47->26|48->27|48->27|48->27|51->30|51->30|51->30|52->31|52->31|52->31|53->32|53->32|53->32|54->33|54->33|54->33|55->34|55->34|55->34|56->35|56->35|56->35|58->37|58->37|58->37|59->38|59->38|59->38|60->39|60->39|60->39|61->40|61->40|61->40|65->44|65->44|65->44|66->45|66->45|66->45|67->46|67->46|67->46|68->47|68->47|68->47|69->48|69->48|69->48|70->49|70->49|70->49|71->50|71->50|71->50|72->51|72->51|72->51|73->52|73->52|73->52|74->53|74->53|74->53|75->54|75->54|75->54|80->59|80->59|80->59|84->63|84->63|84->63|85->64|85->64|85->64|86->65|86->65|86->65|88->67|88->67|88->67|89->68|89->68|89->68|90->69|90->69|90->69|91->70|91->70|91->70|92->71|92->71|92->71|93->72|93->72|93->72|113->92|113->92|113->92
                  -- GENERATED --
              */
          