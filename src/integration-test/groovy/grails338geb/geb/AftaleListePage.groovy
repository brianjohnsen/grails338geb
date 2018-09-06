package grails338geb.geb

import geb.Page

class AftaleListePage extends Page {

    static url = "aftale"

    static at = { title == "Aftale Liste" }

    static content = {
        aftaleListe { $("table tbody tr") ?: [] }
        opertNyAftaleKnap(to: AftaleOpretPage) { $("div.nav a", text: "Ny Aftale") }
    }

    def xxx() {
    }

}
