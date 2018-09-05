package grails338geb

import grails.gorm.services.Service

@Service(Aftale)
interface AftaleService {

    Aftale get(Serializable id)

    List<Aftale> list(Map args)

    Long count()

    void delete(Serializable id)

    Aftale save(Aftale aftale)

}