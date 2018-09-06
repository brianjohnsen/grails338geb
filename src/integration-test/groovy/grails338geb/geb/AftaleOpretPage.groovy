package grails338geb.geb

import geb.Page
import geb.module.TextInput

class AftaleOpretPage extends Page {

    static url = "aftale/create"

    static at = { title == "Opret Aftale" }

    static content = {
        tekstFelt { $(name: "tekst").module(TextInput) }
        opretKnap(to: AftaleVisPage) { $("input", type: "submit") }
    }


}
