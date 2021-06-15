package net.korasoft.movies;

import org.springframework.stereotype.Component;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.ServiceName;
import cds.gen.movie_srv.MovieSrv_;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
@ServiceName(MovieSrv_.CDS_NAME)
public class MovieSrv implements EventHandler {


}
