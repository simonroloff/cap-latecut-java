package net.korasoft.books;

import org.springframework.stereotype.Component;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.ServiceName;
import cds.gen.books_srv.BooksSrv_;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
@ServiceName(BooksSrv_.CDS_NAME)
public class BooksSrv implements EventHandler {

 
  
}

