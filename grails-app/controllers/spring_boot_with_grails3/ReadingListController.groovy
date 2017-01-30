package spring_boot_with_grails3

import grails.transaction.Transactional

class ReadingListController {

    def index() {
        respond Book.list(params), model:[book: new Book()]
    }

    @Transactional
    def save(Book book) {
        book.reader = "hreeman"
        
        book.save flush:true

        redirect(action: "index")
    }
}
