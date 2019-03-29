// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/akshatsistla/Desktop/cs2340/CS2340SP19Team19/riskPlay/conf/routes
// @DATE:Fri Mar 29 02:46:49 EDT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def risk(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "risk")
    }
  
  }


}
