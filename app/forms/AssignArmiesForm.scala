package forms

import ImplicitFormBuilders.TerritoryFormatter
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationResult}
import riskGame.{Game, Territory}

case class AssignArmiesForm(terr: Territory, numArmies: Int)

object AssignArmiesForm {

  val validAmount = Constraint[Int] ({
    case num if (num <= Game.getCurrPlayer.armies && num > 0) => Valid
    case armies if armies <= 0 => Invalid("Must have positive amount of armies")
    case _ => Invalid("Too many armies")
  }: PartialFunction[Int, ValidationResult])

  val form = Form(
    mapping(
      "Territory" -> of[Territory],
      "Number of Armies" -> number.verifying(validAmount)
    )(AssignArmiesForm.apply)(AssignArmiesForm.unapply)
  )

}
