package grails338geb.geb

import geb.spock.GebReportingSpec
import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Stepwise

@Stepwise
@Integration
@Rollback
class AftaleSpec extends GebReportingSpec {


    void "kan lave ny aftale"() {
        given:
            to AftaleListePage //tjekker 'at' også

        when:
            opertNyAftaleKnap.click()

        then:
            at AftaleOpretPage

        when:
            tekstFelt.text = 'Ny Aftale'

        and:
            opretKnap.click()

        then:
            at AftaleVisPage //dobbelt tjek

        and:
            beskedBanner.displayed
            beskedBanner.text() ==~ /Aftale \d+ oprettet/

        when:
            aftaleListeKnap.click()

        then:
            at AftaleListePage //dobbelt tjek igen

        and:
            aftaleListe.size() >= 1
    }


    void "mere aftale"() {
        given:
            to AftaleListePage

        when:
            aftaleListe.first().find('a').click()

        then:
            at AftaleVisPage
    }


}