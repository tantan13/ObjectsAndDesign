// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/akshatsistla/Desktop/riskPlay/conf/routes
// @DATE:Fri Mar 29 02:19:12 EDT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
