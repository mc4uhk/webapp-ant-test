package test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hk.mc4u.Book;
import hk.mc4u.Handbook;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Test07 {

	@BeforeEach
	public void init() {
	}

	@Test
	public void test01() throws JAXBException, IOException {
		marshal();
	}

	@Test
	public void test02() throws JAXBException, IOException {
		Handbook book = unmarshall();
		log.info("{}", book);
	}

	@AfterEach
	public void cleanup() throws InterruptedException {
	}

	public void marshal() throws JAXBException, IOException {
		Book book = new Book();
		book.setId(1L);
		book.setName("Book1");
		book.setAuthor("Author1");
		book.setDate(new Date());

		JAXBContext context = JAXBContext.newInstance(Book.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(book, new File("./book.xml"));
	}

	public Handbook unmarshall() throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Handbook.class);
		Handbook book = (Handbook) context.createUnmarshaller().unmarshal(new FileReader("./book.xml"));
		return book;
	}
}
