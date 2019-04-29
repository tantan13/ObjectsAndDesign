package forms

import play.api.data.Form
import play.api.data.Forms._

case class MoveArmiesForm(numArmies: Int)

object MoveArmiesForm {
  val form = Form(
    mapping(
      "Number of Armies" -> number
    )(MoveArmiesForm.apply)(MoveArmiesForm.unapply)
  )
}
