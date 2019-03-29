package controllers

import javax.inject._
import play.api.mvc._

class HomeController @Inject()(cc: ControllerComponents)
                        (implicit assetsFinder: AssetsFinder)
        extends AbstractController(cc) {
    def risk = Action {
        Ok(views.html.risk())
    }
}
