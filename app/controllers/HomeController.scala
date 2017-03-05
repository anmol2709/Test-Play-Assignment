package controllers

import javax.inject._
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import sun.security.util.Password

import scala.collection.mutable.ListBuffer

case class User(name: String, age: Int,password: String)
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  val userList = ListBuffer[User]()

  val user1=new (User)("Anmol",24,"password")
  userList+=user1

val formObj= new FormController
  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def login = Action {
    Ok(views.html.login())
  }


    def signUp= Action {
      Ok(views.html.signUp( formObj.user))
    }

  def profile = Action {
    Ok(views.html.profile( formObj.user1))
  }
  def checkDetails=Action{
    if (((new FormController).user1.name==user1.name) && ((new FormController).user1.password==user1.password)) {
      Redirect(routes.HomeController.profile)

    }
    else
      Redirect(routes.HomeController.login)
  }

}


