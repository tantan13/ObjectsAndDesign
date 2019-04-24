package forms

import play.api.data.Form
import play.api.data.Forms._

case class PlayerForm(p1: String, p2: String, p3: String, p4: String, p5: String, p6: String)

object PlayerForm {
  val playerForm: Form[PlayerForm] = Form(
    mapping(
      "p1" -> nonEmptyText,
      "p2" -> nonEmptyText,
      "p3" -> nonEmptyText,
      "p4" -> text,
      "p5" -> text,
      "p6" -> text
    )(PlayerForm.apply)(PlayerForm.unapply)
  )
}
