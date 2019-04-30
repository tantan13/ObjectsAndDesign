package forms

import ImplicitFormBuilders.TerritoryFormatter
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationResult}
import riskGame.{RiskMap, Territory}

case class FortifyForm(terr: Territory)

object FortifyForm {

  val validTerritory = Constraint[Territory] ({
    case terr if RiskMap.getTerrToMoveTo(terr.owner, terr) == Nil => Invalid("No territories to move to")
    case _ => Valid
  }: PartialFunction[Territory, ValidationResult])

  val terrForm = Form(
    mapping(
      "Territory" -> of[Territory].verifying(validTerritory)
    )(FortifyForm.apply)(FortifyForm.unapply)
  )
}
