package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import services.ListAllTodosService
import entities.Todo

@Singleton
class TodosController @Inject() (
    cc: ControllerComponents,
    listAllTodosService: ListAllTodosService
) extends AbstractController(cc) {

  // Define or import the implicit formatter for ITodo
  implicit val todoFormat: OFormat[Todo] =
    Json.format[Todo] // Formatter for ITodo

  /** Endpoint to return JSON content.
    *
    * This method will be invoked when a GET request is made to the `/` path.
    */
  def index(): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
      val todos = listAllTodosService.execute()
      Ok(Json.toJson(todos)).as("application/json")
  }
}
