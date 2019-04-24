package forms

import play.api.data.Form
import play.api.data.Forms._

case class DiceForm(aDice: Int, dDice: Int)

object DiceForm {
  val diceForm: Form[DiceForm] = Form(
    mapping(
      "aDice" -> number,
      "dDice" -> number
    )(DiceForm.apply)(DiceForm.unapply)
  )
}