package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.mvc.Controller

class FormController extends Controller{




  val userForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "age" -> number,
      "password" -> nonEmptyText

    )(User.apply)(User.unapply)
  )


  val anyData = Map("name" -> "bob", "age" -> "18","password" -> "anmol")
  val user1: User = userForm.bind(anyData).get
  val user=User("anmol",18,"anmol")


}