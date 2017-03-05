package services

import controllers.{FormController, HomeController}

import scala.collection.mutable.ListBuffer

class userHandling {
  val userList = ListBuffer[controllers.User]()

  val user1=new (controllers.User)("Anmol",24,"password")
  userList+=user1



}