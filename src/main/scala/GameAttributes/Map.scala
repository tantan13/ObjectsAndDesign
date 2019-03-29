package GameAttributes

object Map {
  val nAmericaTerr: List[Territory] = List(new Territory("Alaska", 0), new Territory("Alberta", 0),
    new Territory("Greenland", 0), new Territory("Ontario", 0))
  val sAmericaTerr: List[Territory] = List(new Territory("Argentina", 0), new Territory("Brazil", 0),
    new Territory("Peru", 0), new Territory("Venezuela", 0))
  val euroTerr: List[Territory] = List(new Territory("Great Britain", 0), new Territory("Iceland", 0),
    new Territory("Scandinavia", 0), new Territory("Ukraine", 0))
  val africaTerr: List[Territory] = List(new Territory("Congo", 0), new Territory("East Africa", 0),
    new Territory("Egypt", 0), new Territory("Madagascar", 0))
  val asiaTerr: List[Territory] = List(new Territory("China", 0), new Territory("India", 0),
    new Territory("Japan", 0), new Territory("Ural", 0))
  val australiaTerr: List[Territory] = List(new Territory("Eastern Australia", 0), new Territory("Indonesia", 0),
    new Territory("New Guinea", 0), new Territory("Western Australia", 0))


  val northAmerica = new Continent("North America", 5, nAmericaTerr)
  val southAmerica = new Continent("South America", 2, sAmericaTerr)
  val europe = new Continent("Europe", 5, euroTerr)
  val africa = new Continent("Africa", 3, africaTerr)
  val asia = new Continent("Asia", 7, asiaTerr)
  val australia = new Continent("Australia", 2, australiaTerr)

  val continents: List[Continent] = List(northAmerica, southAmerica, europe, africa, asia, australia)

  def displayMap = continents.foreach(println)
}