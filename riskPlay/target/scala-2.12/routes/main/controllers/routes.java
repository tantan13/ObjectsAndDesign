// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/akshatsistla/Desktop/cs2340/CS2340SP19Team19/riskPlay/conf/routes
// @DATE:Fri Mar 29 02:46:49 EDT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
