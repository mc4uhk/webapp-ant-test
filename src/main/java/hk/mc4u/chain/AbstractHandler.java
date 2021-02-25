package hk.mc4u.chain;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractHandler {

	protected AbstractHandler next;

	protected String[] handleList;


	public void setNext(AbstractHandler next) {
		this.next = next;
	}

	public void handle(String itemCode) {
		//log.info("{} : {}", handleList, itemCode);

		if (Arrays.stream(handleList).anyMatch(itemCode::equals)) {
			result(itemCode);
		}else if (next != null) {
			next.handle(itemCode);
		}
	}

	abstract public void result(String itemCode);
}
