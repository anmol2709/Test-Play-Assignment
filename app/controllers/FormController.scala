package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{Request, Action, Controller}

class FormController extends Controller{





  val userForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "userName" -> nonEmptyText,
      "password" -> nonEmptyText,
      "verifyPassword"->nonEmptyText,
      "mobileNumber" -> number,
      "gender" -> nonEmptyText,
      "age" -> number(min = 18, max = 75),
      "hobbies" -> nonEmptyText
    )(User.apply)(User.unapply).verifying("Passwords do not match", fields => fields match {
      case data => (data.password == data.verifyPassword)
    }
    ))


  val anyData = Map("name" -> "bob", "age" -> "18")
//  val user1: User = userForm.bind(anyData).get
//  val user1 = userForm.bindFromRequest
//  user1.fold(hasErrors => BadRequest("Invalid submission"), success => {
//    Ok("Account registered.")
//  })
//  val user=User("anmol",18,"anmol")


//
//  val signUp = Action(parse.form(userForm)) { implicit request =>
//    val userData = request.body
//    val newUser = User(userData.name, userData.age, userData.password)
//
//    Redirect(routes.FormController.signUpFinal)
//  }

//  def signUpFinal = Action {
//    implicit request =>
//
//      val userForm = Form(
//        mapping(
//          "name" -> nonEmptyText,
//          "age" -> number,
//          "password" -> nonEmptyText
//
//        )(User.apply)(User.unapply)
//      )
//      val processedForm = userForm.bindFromRequest

//
//      processedForm.fold(hasErrors => BadRequest("Invalid submission"), success => {
//        Ok("Account registered.")
//      })}




}
