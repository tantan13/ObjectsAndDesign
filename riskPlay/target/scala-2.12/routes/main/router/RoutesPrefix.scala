// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/akshatsistla/Desktop/cs2340/CS2340SP19Team19/riskPlay/conf/routes
// @DATE:Fri Mar 29 02:46:49 EDT 2019


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
