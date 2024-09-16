package services

import javax.inject._
import play.api.libs.json._

@Singleton
class SayHelloWorldService {

  // Define case classes to represent your data structure
  case class Location(lat: Double, long: Double)
  case class Resident(name: String, age: Int, role: Option[String])
  case class City(name: String, location: Location, residents: Seq[Resident])

  // Define implicit JSON formats using Play's macro
  implicit val locationFormat: OFormat[Location] = Json.format[Location]
  implicit val residentFormat: OFormat[Resident] = Json.format[Resident]
  implicit val cityFormat: OFormat[City] = Json.format[City]

  def execute(): JsValue = {
    val city = City(
      name = "Watership Down",
      location = Location(lat = 51.235685, long = -1.309197),
      residents = Seq(
        Resident(name = "Fiver", age = 4, role = None),
        Resident(name = "Bigwig", age = 6, role = Some("Owsla"))
      )
    )

    Json.toJson(city)
  }
}
