// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/akshatsistla/Desktop/riskPlay/conf/routes
// @DATE:Fri Mar 29 02:19:12 EDT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
