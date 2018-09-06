package grails338geb.geb

import geb.Page

class AftaleVisPage extends Page {

    static url = "aftale/show"

    static at = { title == "Vis Aftale" }

    static content = {
        beskedBanner { $("div.message") }
        aftaleListeKnap(to: AftaleListePage) { $("div.nav a", text: "Aftale Liste") }
    }


}
