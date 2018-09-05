package grails338geb.geb

import geb.spock.GebReportingSpec
import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class BasalAftaleSpec extends GebReportingSpec {


    void "lav ny aftale"() {
        when:
            go '/aftale'

        then:
            title == "Aftale Liste"

        and:
            $("table tbody tr").size() == 0

        when:
            $("div.nav a", text: "Ny Aftale").click()
            waitFor {
                title == "Opret Aftale"
            }

        then:
            $("h1").text() == 'Opret Aftale'

        when:
            $("form").tekst = 'Ny Aftale'

        and:
            $("input", type: "submit").click()
            waitFor {
                title == "Vis Aftale"
            }

        then:
            $("div.message").text() == 'Aftale 1 oprettet'

        when:
            $("div.nav a", text: "Aftale Liste").click()
            waitFor {
                title == "Aftale Liste"
            }

        then:
            $("table tbody tr").size() == 1
    }
}
