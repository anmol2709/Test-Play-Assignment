package controllers

import javax.inject._
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import sun.security.util.Password
import views.html.helper.form

import scala.collection.mutable.ListBuffer

case class User(name : String,userName:String,password: String,verifyPassword:String,mobileNumber:Int,gender:String, age: Int,hobbies:String)

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {


val formControl=new FormController

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }




    def signUp= Action {
      Ok(views.html.signUp())
    }

  def login= Action {
    Ok(views.html.login())
  }




  def submit = Action { implicit request =>
    val processedForm = formControl.userForm.bindFromRequest
    val user: User = formControl.userForm.bindFromRequest.get
    processedForm.fold(Errors => {
      BadRequest("display error")
    }, success => {

      Ok(views.html.profile(user))
    })

  }


}


