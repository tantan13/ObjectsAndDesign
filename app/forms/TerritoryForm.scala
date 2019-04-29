package forms

import ImplicitFormBuilders.{TerritoryFormatter}
import play.api.data.Form
import play.api.data.Forms._
import riskGame.{Territory}

case class TerritoryForm(terr: Territory)

object TerritoryForm {
  val form = Form(
    mapping(
      "Territory" -> of[Territory]
    )(TerritoryForm.apply)(TerritoryForm.unapply)
  )
}
