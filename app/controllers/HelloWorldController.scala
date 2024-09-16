package controllers

import javax.inject._
import play.api.mvc._
import services.SayHelloWorldService
import play.api.libs.json._

@Singleton
class HelloWorldController @Inject() (
    cc: ControllerComponents,
    sayHelloWorldService: SayHelloWorldService
) extends AbstractController(cc) {

  /** Endpoint to return JSON content.
    *
    * This method will be invoked when a GET request is made to the `/` path.
    */
  def index(): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
      val jsonResponse: JsValue = sayHelloWorldService.execute()
      Ok(jsonResponse).as("application/json")
  }
}
