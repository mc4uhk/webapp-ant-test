package hk.mc4u.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TllHandler extends AbstractHandler{

	public TllHandler() {
		handleList = new String[]{"TLL"};

	}

	@Override
	public void result(String itemCode) {
		log.info("TLL Handler");
		
	}
	
}
