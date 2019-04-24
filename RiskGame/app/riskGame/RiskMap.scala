package riskGame

object RiskMap {
  val alaska = new Territory("Alaska")
  val alberta = new Territory("Alberta")
  val centralAmerica = new Territory("Central America")
  val eastUS = new Territory("Eastern United States")
  val greenland = new Territory("Greenland")
  val northwest = new Territory("Northwest Territory")
  val ontario = new Territory("Ontario")
  val quebec = new Territory("Quebec")
  val westUS = new Territory("Western United States")
  val nAmericaTerr: List[Territory] = List(alaska, alberta, centralAmerica, eastUS,
                                                greenland, northwest, ontario, quebec, westUS)

  val argentina = new Territory("Argentina")
  val brazil = new Territory("Brazil")
  val peru = new Territory("Peru")
  val venezuela = new Territory("Venezuela")
  val sAmericaTerr: List[Territory] = List(argentina, brazil, peru, venezuela)

  val greatBritain = new Territory("Great Britain")
  val iceland = new Territory("Iceland")
  val nEurope = new Territory("Northern Europe")
  val scandinavia = new Territory("Scandinavia")
  val sEurope = new Territory("Southern Europe")
  val ukraine = new Territory("Ukraine")
  val wEurope = new Territory("Western Europe")
  val euroTerr: List[Territory] = List(greatBritain, iceland, nEurope, scandinavia, sEurope, ukraine, wEurope)

  val congo = new Territory("Congo")
  val eAfrica = new Territory("East Africa")
  val egypt = new Territory("Egypt")
  val madagascar = new Territory("Madagascar")
  val nAfrica = new Territory("North Africa")
  val sAfrica = new Territory("South Africa")
  val africaTerr: List[Territory] = List(congo, eAfrica, egypt, madagascar, nAfrica, sAfrica)

  val afghanistan = new Territory("Afghanistan")
  val china = new Territory("China")
  val india = new Territory("India")
  val irkutsk = new Territory("Irkutsk")
  val japan = new Territory("Japan")
  val kamchatka = new Territory("Kamchatka")
  val midEast = new Territory("Middle East")
  val mongolia = new Territory("Mongolia")
  val siam = new Territory("Siam")
  val siberia = new Territory("Siberia")
  val ural = new Territory("Ural")
  val yakutsk = new Territory("Yakutsk")
  val asiaTerr: List[Territory] = List(afghanistan, china, india, irkutsk, japan, kamchatka,
                                                midEast, mongolia, siam, siberia, ural, yakutsk)

  val eAustralia = new Territory("Eastern Australia")
  val indonesia = new Territory("Indonesia")
  val newGuinea = new Territory("New Guinea")
  val wAustralia = new Territory("Western Australia")
  val australiaTerr: List[Territory] = List(eAustralia, indonesia, newGuinea, wAustralia)

  val allTerritories: List[Territory] = nAmericaTerr ::: sAmericaTerr ::: euroTerr ::: africaTerr ::: asiaTerr ::: australiaTerr

  val northAmerica = new Continent("North America", 5, nAmericaTerr)
  val southAmerica = new Continent("South America", 2, sAmericaTerr)
  val europe = new Continent("Europe", 5, euroTerr)
  val africa = new Continent("Africa", 3, africaTerr)
  val asia = new Continent("Asia", 7, asiaTerr)
  val australia = new Continent("Australia", 2, australiaTerr)
  val continents: List[Continent] = List(northAmerica, southAmerica, europe, africa, asia, australia)

  private val terrAdjList: Map[Territory, List[Territory]] = Map(
    alaska -> List(alberta, northwest, kamchatka),
    alberta -> List(alaska, northwest, ontario, westUS),
    centralAmerica -> List(eastUS, westUS, venezuela),
    eastUS -> List(centralAmerica, ontario, quebec, westUS),
    greenland -> List(northwest, ontario, quebec, iceland),
    northwest -> List(alaska, alberta, greenland, ontario),
    ontario -> List(alberta, northwest, quebec, eastUS, westUS),
    quebec -> List(eastUS, ontario, greenland),
    westUS -> List(centralAmerica, eastUS, alberta, ontario),
    argentina -> List(brazil, peru),
    brazil -> List(argentina, peru, nAfrica),
    peru -> List(argentina, brazil, venezuela),
    venezuela -> List(brazil, peru, centralAmerica),
    greatBritain -> List(iceland, nEurope, wEurope, scandinavia),
    iceland -> List(greatBritain, scandinavia, greenland),
    nEurope -> List(greatBritain, scandinavia, sEurope, ukraine, wEurope),
    scandinavia -> List(greatBritain, iceland, nEurope, ukraine),
    sEurope -> List(nEurope, ukraine, wEurope, egypt, midEast),
    ukraine -> List(nEurope, scandinavia, sEurope, afghanistan, midEast, ural),
    wEurope -> List(greatBritain, nEurope, sEurope, nAfrica),
    congo -> List(eAfrica, nAfrica, sAfrica),
    eAfrica -> List(congo, egypt, madagascar, sAfrica),
    egypt -> List(eAfrica, nAfrica, sEurope, midEast),
    madagascar -> List(eAfrica, sAfrica),
    nAfrica -> List(congo, eAfrica, egypt, wEurope),
    sAfrica -> List(congo, eAfrica, madagascar),
    afghanistan -> List(china, india, midEast, ural, ukraine),
    china -> List(afghanistan, india, siam, mongolia, ural),
    india -> List(afghanistan, china, midEast, siam),
    irkutsk -> List(kamchatka, mongolia, siberia, yakutsk),
    japan -> List(kamchatka, mongolia),
    kamchatka -> List(irkutsk, japan, mongolia, yakutsk),
    midEast -> List(afghanistan, india, eAfrica, egypt, ukraine, sEurope),
    mongolia -> List(china, irkutsk, japan, kamchatka, siberia),
    siam -> List(china, india, indonesia),
    siberia -> List(china, irkutsk, mongolia, ural, yakutsk),
    ural -> List(afghanistan, china, siberia, ukraine),
    yakutsk -> List(irkutsk, kamchatka, siberia),
    eAustralia -> List(newGuinea, wAustralia),
    indonesia -> List(siam, newGuinea),
    newGuinea -> List(eAustralia, indonesia),
    wAustralia -> List(eAustralia, newGuinea)
  )

  def getAdjacentTerritories(terr: Territory): List[Territory] = terrAdjList.get(terr) match {
    case Some(list) => list
    case None => Nil
  }

  def getTerrToAttack(terr: Territory): List[Territory] = {
    getAdjacentTerritories(terr).filter(terr.numArmies > _.numArmies).filterNot(_.owner.equals(terr.owner))
  }

  def getTerrToMoveTo(player: Player, terr: Territory): List[Territory] = {
    getAdjacentTerritories(terr).filter(_.owner.equals(player))
  }

  def getTerrByName(name: String): Option[Territory] = {
    for(terr <- allTerritories) {
      if (terr.name.equals(name)) Some(terr)
    }
    None
  }


}