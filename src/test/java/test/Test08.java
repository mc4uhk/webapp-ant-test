package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hk.mc4u.chain.AbstractHandler;
import hk.mc4u.chain.ArmsHandler;
import hk.mc4u.chain.PoeHandler;
import hk.mc4u.chain.TllHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Test08 {

	private static AbstractHandler handler;

	@BeforeEach
	public void init() {

		AbstractHandler handler01 = new ArmsHandler();
		AbstractHandler handler02 = new PoeHandler();
		AbstractHandler handler03 = new TllHandler();

		handler01.setNext(handler02);
		handler02.setNext(handler03);
		handler03.setNext(null);

		handler = handler01;
	}

	@Test
	public void test01() {
		handler.handle("TLL");
		handler.handle("ARMS");
		handler.handle("POE");
	}

	@AfterEach
	public void cleanup() throws InterruptedException {
	}

}
