package grails338geb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AftaleController {

    AftaleService aftaleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond aftaleService.list(params), model:[aftaleCount: aftaleService.count()]
    }

    def show(Long id) {
        respond aftaleService.get(id)
    }

    def create() {
        respond new Aftale(params)
    }

    def save(Aftale aftale) {
        if (aftale == null) {
            notFound()
            return
        }

        try {
            aftaleService.save(aftale)
        } catch (ValidationException e) {
            respond aftale.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'aftale.label', default: 'Aftale'), aftale.id])
                redirect aftale
            }
            '*' { respond aftale, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond aftaleService.get(id)
    }

    def update(Aftale aftale) {
        if (aftale == null) {
            notFound()
            return
        }

        try {
            aftaleService.save(aftale)
        } catch (ValidationException e) {
            respond aftale.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'aftale.label', default: 'Aftale'), aftale.id])
                redirect aftale
            }
            '*'{ respond aftale, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        aftaleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'aftale.label', default: 'Aftale'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aftale.label', default: 'Aftale'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
