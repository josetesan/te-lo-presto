package com.telopresto.service.articulos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArticulosApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@DataJpaTest
public class TestRestData {

    @Autowired
    private TestRestTemplate template;

    private static String ITEM_ENDPOINT = "http://localhost:8080/articulos/";
    private static String VALUATION_ENDPOINT = "http://localhost:8080/valuations/";


    @Test
    public void whenSaveOneToManyRelationship_thenCorrect() {
//        Library library = new Library(LIBRARY_NAME);
//        template.postForEntity(LIBRARY_ENDPOINT, library, Library.class);
//
//        Book book1 = new Book("Dune");
//        template.postForEntity(BOOK_ENDPOINT, book1, Book.class);
//
//        Book book2 = new Book("1984");
//        template.postForEntity(BOOK_ENDPOINT, book2, Book.class);
//
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.add("Content-Type", "text/uri-list");
//        HttpEntity<String> bookHttpEntity
//                = new HttpEntity<>(LIBRARY_ENDPOINT + "/1", requestHeaders);
//        template.exchange(BOOK_ENDPOINT + "/1/library",
//                HttpMethod.PUT, bookHttpEntity, String.class);
//        template.exchange(BOOK_ENDPOINT + "/2/library",
//                HttpMethod.PUT, bookHttpEntity, String.class);
//
//        ResponseEntity<Library> libraryGetResponse =
//                template.getForEntity(BOOK_ENDPOINT + "/1/library", Library.class);
//        assertEquals("library is incorrect",
//                libraryGetResponse.getBody().getName(), LIBRARY_NAME);
    }

}
