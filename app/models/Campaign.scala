package models

import play.mvc.BodyParser.Json

/**
  * Created by dominik on 9/11/16.
  */
case class Campaign(title: Sting)

object Campaign{

  implicit val campaignFormat = Json.format[Campaign]
}
