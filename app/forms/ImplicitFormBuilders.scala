package forms

import play.api.data.FormError
import play.api.data.format.Formatter
import riskGame.{Player, RiskMap, Territory, Game}

object ImplicitFormBuilders {

  implicit object TerritoryFormatter extends Formatter[Territory] {
    override def bind(key: String, data: Map[String, String]): Either[Seq[FormError], Territory] = {
      data.get(key) map { value =>
        RiskMap.allTerritories.find(_.name.equals(value)) match {
          case Some(terr) => Right(terr)
          case None => Left(Seq(FormError(key, "Territory not found")))
        }
      } getOrElse Left(Seq(FormError(key, "Key not found")))
    }

    override def unbind(key: String, value: Territory): Map[String, String] = Map(key -> value.name)
  }

  implicit object PlayerFormatter extends Formatter[Player] {
    override def bind(key: String, data: Map[String, String]): Either[Seq[FormError], Player] = {
      data.get(key) map { value =>
        Game.players.find(_.name.equals(value)) match {
          case Some(player) => Right(player)
          case None => Left(Seq(FormError(key, "Player not found")))
        }
      } getOrElse Left(Seq(FormError(key, "Key not found")))
    }

    override def unbind(key: String, value: Player): Map[String, String] = Map(key -> value.name)
  }

}