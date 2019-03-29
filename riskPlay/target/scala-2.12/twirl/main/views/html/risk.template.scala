
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

object risk extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Risk")/*1.14*/ {_display_(Seq[Any](format.raw/*1.16*/("""
    """),format.raw/*2.5*/("""<section id="top">
        <div class="wrapper">
            <h1>Welcome to Risk</h1>
            <h2>This is a fun game and we hope you enjoy!<h2>
        </div>
    </section>
""")))}),format.raw/*8.2*/("""
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
                  DATE: Fri Mar 29 02:21:18 EDT 2019
                  SOURCE: /Users/akshatsistla/Desktop/riskPlay/app/views/risk.scala.html
                  HASH: c038b2c9cee27cebfaec6d9ddafbf00743b680cc
                  MATRIX: 810->1|830->13|869->15|900->20|1108->199
                  LINES: 26->1|26->1|26->1|27->2|33->8
                  -- GENERATED --
              */
          