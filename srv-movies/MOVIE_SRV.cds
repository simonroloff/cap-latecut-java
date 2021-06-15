using kora.db.movie as dbshlp from './db/MOVIE';

service MOVIE_SRV {

  entity Movie as projection on dbshlp.Movie;
  

}