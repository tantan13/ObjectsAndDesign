package forms

import play.api.data.Form
import play.api.data.Forms._

case class PlayerForm(p1: String, p2: String, p3: String, p4: String, p5: String, p6: String)

object PlayerForm {
  val playerForm: Form[PlayerForm] = Form(
    mapping(
      "Player 1" -> nonEmptyText,
      "Player 2" -> nonEmptyText,
      "Player 3" -> nonEmptyText,
      "Player 4" -> text,
      "Player 5" -> text,
      "Player 6" -> text
    )(PlayerForm.apply)(PlayerForm.unapply)
  )
}
