using { kora.db.books as db } from './db/BOOKS';

service BOOKS_SRV {
	entity Books as projection on db.Books;
}