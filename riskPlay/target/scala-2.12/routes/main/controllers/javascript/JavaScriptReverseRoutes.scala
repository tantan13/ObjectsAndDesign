// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/akshatsistla/Desktop/riskPlay/conf/routes
// @DATE:Fri Mar 29 02:19:12 EDT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def risk: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.risk",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "risk"})
        }
      """
    )
  
  }


}
