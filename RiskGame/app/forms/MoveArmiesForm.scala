package forms

import play.api.data.Form
import play.api.data.Forms._

case class MoveArmiesForm(numArmies: Int)

object MoveArmiesForm {
  val form = Form(
    mapping(
      "numArmies" -> number
    )(MoveArmiesForm.apply)(MoveArmiesForm.unapply)
  )
}
