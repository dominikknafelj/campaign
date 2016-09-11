package controllers

import javax.inject._

import models.Campaign
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Cool it runs."))
  }

  def addPerson = Action { implicit request =>
    val campaign = campaignForm.bindFromRequest.get
    DB.save(campaign)
    Redirect(routes.Application.index)
  }

  val campaignForm: Form[Campaign] = Form{ mapping( "title" -> text  )}(Campaign.apply)(Campaign.unapply)

}
