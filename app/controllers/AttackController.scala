package controllers

import forms.{DiceForm, MoveArmiesForm, TerritoryForm}
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import riskGame.{Game, RiskMap, Territory}

@Singleton
class AttackController @Inject()(cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
                                      extends AbstractController(cc) with play.api.i18n.I18nSupport{
  var fromTerr: Territory = new Territory("from")
  var toTerr: Territory = new Territory("to")
  var numDice: (Int, Int) = (-1, -1)

  def getAdjTerr = Action { implicit request =>
    TerritoryForm.form.bindFromRequest.fold(
      formError => {
        BadRequest(views.html.attackPage(Game.getCurrPlayer)(formError))
      },
      correctForm => {
        fromTerr = correctForm.terr
        Ok(views.html.displayAdjTerr(RiskMap.getTerrToAttack(fromTerr))(fromTerr)(TerritoryForm.form))
      }
    )
  }

  def toDice = Action { implicit request =>
    TerritoryForm.form.bindFromRequest.fold(
      formError => {
        BadRequest(views.html.displayAdjTerr(RiskMap.getAdjacentTerritories(fromTerr))(fromTerr)(formError))
      },
      correctForm => {
        toTerr = correctForm.terr
        numDice = Game.getMaxDice(fromTerr, toTerr)
        Ok(views.html.setDice(fromTerr.owner.name)(toTerr.owner.name)(DiceForm.diceForm)((1 to numDice._1).toList)((1 to numDice._2).toList))
      }
    )
  }

  def rollDice = Action { implicit request =>
    DiceForm.diceForm.bindFromRequest.fold(
      formError => {
        BadRequest(views.html.setDice(fromTerr.owner.name)(toTerr.owner.name)(formError)((1 to numDice._1).toList)((1 to numDice._2).toList))
      },
      correctForm => {
        Ok(views.html.attackResult(Game.attack(fromTerr, toTerr, correctForm.aDice, correctForm.dDice)))
      }
    )
  }

  def findNext = Action { implicit request =>
    if (toTerr.isConquered) {
      if (toTerr.owner.isOut) {
        Game.removePlayer(toTerr.owner)
        if (Game.gameOver) Ok(views.html.gameOver(Game.getCurrPlayer))
      }
      toTerr.owner.occupiedTerr -= toTerr
      fromTerr.owner.occupiedTerr += toTerr
      Ok(views.html.moveTerritories((1 until fromTerr.numArmies).toList)(MoveArmiesForm.form))
    } else Ok(views.html.turn(Game.getCurrPlayer)(s"${fromTerr.owner.name} continues")(true))
  }

  def occupy = Action { implicit request =>
    MoveArmiesForm.form.bindFromRequest.fold(
      formError => {
        BadRequest(views.html.moveTerritories((1 until fromTerr.numArmies).toList)(formError))
      },
      correctForm => {
        Game.occupy(fromTerr, toTerr, correctForm.numArmies)
        val message = s"${fromTerr.owner.name} has conquered ${toTerr.name}"
        Ok(views.html.turn(Game.getCurrPlayer)(message)(true))
      }
    )
  }
}
