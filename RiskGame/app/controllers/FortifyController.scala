package controllers

import forms.{MoveArmiesForm, TerritoryForm}
import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import riskGame.{Game, Player, RiskMap, Territory}

class FortifyController @Inject()(cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
                extends AbstractController(cc) with play.api.i18n.I18nSupport{

  var fromTerr = new Territory("from")
  var toTerr = new Territory("to")

  def moveTo = Action { implicit request =>
    TerritoryForm.form.bindFromRequest.fold(
      formError => {
        Ok(views.html.moveFrom(Game.getCurrPlayer)(formError)(Game.getCurrPlayer.getOccTerr))
      },
      correctForm => {
        fromTerr = correctForm.terr
        Ok(views.html.moveTo(Game.getCurrPlayer)(TerritoryForm.form)(RiskMap.getTerrToMoveTo(Game.getCurrPlayer, fromTerr)))
      }
    )
  }

  def selectArmies = Action { implicit request =>
    TerritoryForm.form.bindFromRequest.fold(
      formError => {
        Ok(views.html.moveTo(Game.getCurrPlayer)(formError)(RiskMap.getTerrToMoveTo(Game.getCurrPlayer, fromTerr)))
      },
      correctForm => {
        toTerr = correctForm.terr
        Ok(views.html.selectArmies((1 until fromTerr.numArmies).toList)(MoveArmiesForm.form))
      }
    )
  }

  def move = Action { implicit request =>
    MoveArmiesForm.form.bindFromRequest.fold(
      formError => {
        Ok(views.html.selectArmies((1 until fromTerr.numArmies).toList)(formError))
      },
      correctForm => {
        Game.moveArmies(fromTerr, toTerr, correctForm.numArmies)
        Ok(views.html.turn(Game.getNextPlayer)(s"${correctForm.numArmies} armies moved to ${toTerr.name}")(false))
      }
    )
  }
}