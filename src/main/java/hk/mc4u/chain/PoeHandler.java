package hk.mc4u.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PoeHandler extends AbstractHandler{

	public PoeHandler() {
		handleList = new String[]{"POE"};

	}

	@Override
	public void result(String itemCode) {
		log.info("POE Handler");
		
	}
	
}
