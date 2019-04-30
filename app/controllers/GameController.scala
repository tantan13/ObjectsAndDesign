package controllers

import javax.inject._
import play.api.mvc._
import forms.{AssignArmiesForm, PlayerForm, TerritoryForm}
import riskGame.{Game, RiskMap, Territory}

@Singleton
class GameController @Inject()(cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
                      extends AbstractController(cc) with play.api.i18n.I18nSupport {
  def starting = Action { implicit request =>
    Ok(views.html.start())
  }
  def showForm = Action { implicit request =>
    Ok(views.html.formTest(PlayerForm.playerForm))
  }

  def display = Action { implicit request =>
    PlayerForm.playerForm.bindFromRequest.fold(
      formError => {
        BadRequest(views.html.formTest(formError))
      },
      correctForm => {
        val playerString = Array(correctForm.p1, correctForm.p2, correctForm.p3,
              correctForm.p4, correctForm.p5, correctForm.p6).filter(!_.equals(""))
        Game.initGame(playerString)
        Ok(views.html.turn(Game.getNextPlayer)("")(false))
      }
    )
  }

  def assignTerr = Action { implicit request =>
    AssignArmiesForm.form.bindFromRequest.fold(
      formError => {
        BadRequest(views.html.assignTerr(formError)(Game.getCurrPlayer))
      },
      correctForm => {
        Game.addArmies(correctForm.terr, correctForm.numArmies)
        Ok(views.html.turn(Game.getCurrPlayer)(s"\n${correctForm.numArmies} territories added to ${correctForm.terr.name}")(true))
      }
    )
  }

  def chooseTerr = Action { implicit request =>
    Ok(views.html.assignTerr(AssignArmiesForm.form)(Game.getCurrPlayer))
  }

  def attack = Action { implicit request =>
    Ok(views.html.attackPage(Game.getCurrPlayer)(AttackForm.form))
  }

  def nextTurn = Action { implicit request =>
    Ok(views.html.turn(Game.getNextPlayer)("")(false))
  }

  def fortify = Action { implicit request =>
    Ok(views.html.moveFrom(Game.getCurrPlayer)(TerritoryForm.form)(Game.getCurrPlayer.getOccTerr))
  }

}
