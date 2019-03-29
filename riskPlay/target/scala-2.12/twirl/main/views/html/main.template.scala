
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Risk</title>
        <style>
            body  """),format.raw/*6.19*/("""{"""),format.raw/*6.20*/("""
                """),format.raw/*7.17*/("""background-color: #4863A0;
                """),format.raw/*8.17*/("""}"""),format.raw/*8.18*/("""
        """),format.raw/*9.9*/("""</style>
    </head>
    <body>
        <h1>Hello Risk players</h1>
        <h2>This is a fun game and we hope you enjoy!</h2>
    </body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 29 03:12:50 EDT 2019
                  SOURCE: /Users/akshatsistla/Desktop/cs2340/CS2340SP19Team19/riskPlay/app/views/main.scala.html
                  HASH: 7e709ca9fed51c3381752c154271d060cd7c0bb1
                  MATRIX: 810->0|943->106|971->107|1015->124|1085->167|1113->168|1148->177
                  LINES: 26->1|31->6|31->6|32->7|33->8|33->8|34->9
                  -- GENERATED --
              */
          