package net.korasoft.movies;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.sap.cds.Result;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.services.EventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.ServiceName;
import cds.gen.movie_srv.MovieSrv_;
import cds.gen.books_srv.Books;
import cds.gen.books_srv.BooksSrv_;
import cds.gen.books_srv.Books_;
import cds.gen.movie_srv.Movie;
import cds.gen.movie_srv.Movie_;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
@ServiceName(MovieSrv_.CDS_NAME)
public class MovieSrv implements EventHandler {

  

  @Autowired
  @Qualifier(BooksSrv_.CDS_NAME)
  private CdsService bookSrv;

  
  
  @After(entity = Movie_.CDS_NAME, event = CdsService.EVENT_READ)
  public void readMovies(final CdsReadEventContext context,
      List<Movie> movies)  {
    
    for(Movie m : movies ) {
      CdsReadEventContext readCheckValues = EventContext.create(CdsReadEventContext.class, Books_.CDS_NAME);
      CqnSelect sel = Select.from(Books_.CDS_NAME).where(b -> b.get(Books.ISBN).eq(m.getIsbn()));
      readCheckValues.setCqn(sel);
      bookSrv.emit(readCheckValues);
      Result r = readCheckValues.getResult();
      Books b = (Books) r.first().get().as(Books.class);
      b.getDescription();
      m.setBookDescription(b.getDescription());
    }
    
    
    
  }

}
