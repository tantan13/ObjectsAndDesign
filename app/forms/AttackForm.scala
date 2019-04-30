package forms

import ImplicitFormBuilders.TerritoryFormatter
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationResult}
import riskGame.{RiskMap, Territory}

case class AttackForm(terr: Territory)

object AttackForm {

  val validTerritory = Constraint[Territory] ({
    case terr if RiskMap.getTerrToAttack(terr) == Nil => Invalid("No territories to Attack")
    case _ => Valid
  }: PartialFunction[Territory, ValidationResult])

  val terrForm = Form(
    mapping(
      "Territory" -> of[Territory].verifying(validTerritory)
    )(AttackForm.apply)(AttackForm.unapply)
  )
}
