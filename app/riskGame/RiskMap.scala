package riskGame

object RiskMap {
  val northAmerica = new Continent("North America", 5)
  val southAmerica = new Continent("South America", 2)
  val europe = new Continent("Europe", 5)
  val africa = new Continent("Africa", 3)
  val asia = new Continent("Asia", 7)
  val australia = new Continent("Australia", 2)

  val alaska = new Territory("Alaska", northAmerica)
  val alberta = new Territory("Alberta", northAmerica)
  val centralAmerica = new Territory("C. America", northAmerica)
  val eastUS = new Territory("Eastern US", northAmerica)
  val greenland = new Territory("Greenland", northAmerica)
  val northwest = new Territory("NW Territory", northAmerica)
  val ontario = new Territory("Ontario", northAmerica)
  val quebec = new Territory("Quebec", northAmerica)
  val westUS = new Territory("Western US", northAmerica)
  val nAmericaTerr: List[Territory] = List(alaska, alberta, centralAmerica, eastUS,
                                                greenland, northwest, ontario, quebec, westUS)
  northAmerica.territories = nAmericaTerr

  val argentina = new Territory("Argentina", southAmerica)
  val brazil = new Territory("Brazil", southAmerica)
  val peru = new Territory("Peru", southAmerica)
  val venezuela = new Territory("Venezuela", southAmerica)
  val sAmericaTerr: List[Territory] = List(argentina, brazil, peru, venezuela)
  southAmerica.territories = sAmericaTerr

  val greatBritain = new Territory("Great Britain", europe)
  val iceland = new Territory("Iceland", europe)
  val nEurope = new Territory("N. Europe", europe)
  val scandinavia = new Territory("Scandinavia", europe)
  val sEurope = new Territory("S. Europe", europe)
  val ukraine = new Territory("Ukraine", europe)
  val wEurope = new Territory("W. Europe", europe)
  val euroTerr: List[Territory] = List(greatBritain, iceland, nEurope, scandinavia, sEurope, ukraine, wEurope)
  europe.territories = euroTerr

  val congo = new Territory("Congo", africa)
  val eAfrica = new Territory("East Africa", africa)
  val egypt = new Territory("Egypt", africa)
  val madagascar = new Territory("Madagascar", africa)
  val nAfrica = new Territory("North Africa", africa)
  val sAfrica = new Territory("South Africa", africa)
  val africaTerr: List[Territory] = List(congo, eAfrica, egypt, madagascar, nAfrica, sAfrica)
  africa.territories = africaTerr

  val afghanistan = new Territory("Afghanistan", asia)
  val china = new Territory("China", asia)
  val india = new Territory("India", asia)
  val irkutsk = new Territory("Irkutsk", asia)
  val japan = new Territory("Japan", asia)
  val kamchatka = new Territory("Kamchatka", asia)
  val midEast = new Territory("Middle East", asia)
  val mongolia = new Territory("Mongolia", asia)
  val siam = new Territory("Siam", asia)
  val siberia = new Territory("Siberia", asia)
  val ural = new Territory("Ural", asia)
  val yakutsk = new Territory("Yakutsk", asia)
  val asiaTerr: List[Territory] = List(afghanistan, china, india, irkutsk, japan, kamchatka,
                                                midEast, mongolia, siam, siberia, ural, yakutsk)
  asia.territories = asiaTerr

  val eAustralia = new Territory("E. Australia", australia)
  val indonesia = new Territory("Indonesia", australia)
  val newGuinea = new Territory("New Guinea", australia)
  val wAustralia = new Territory("W. Australia", australia)
  val australiaTerr: List[Territory] = List(eAustralia, indonesia, newGuinea, wAustralia)
  australia.territories = australiaTerr

  val allTerritories: List[Territory] = nAmericaTerr ::: sAmericaTerr ::: euroTerr ::: africaTerr ::: asiaTerr ::: australiaTerr
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
    china -> List(afghanistan, india, siam, mongolia, ural, siberia),
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
