package grails338geb

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AftaleServiceSpec extends Specification {

    AftaleService aftaleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Aftale(...).save(flush: true, failOnError: true)
        //new Aftale(...).save(flush: true, failOnError: true)
        //Aftale aftale = new Aftale(...).save(flush: true, failOnError: true)
        //new Aftale(...).save(flush: true, failOnError: true)
        //new Aftale(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //aftale.id
    }

    void "test get"() {
        setupData()

        expect:
        aftaleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Aftale> aftaleList = aftaleService.list(max: 2, offset: 2)

        then:
        aftaleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        aftaleService.count() == 5
    }

    void "test delete"() {
        Long aftaleId = setupData()

        expect:
        aftaleService.count() == 5

        when:
        aftaleService.delete(aftaleId)
        sessionFactory.currentSession.flush()

        then:
        aftaleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Aftale aftale = new Aftale()
        aftaleService.save(aftale)

        then:
        aftale.id != null
    }
}
