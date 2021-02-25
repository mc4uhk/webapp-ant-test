package hk.mc4u.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArmsHandler extends AbstractHandler{

	public ArmsHandler() {
		handleList = new String[]{"ARMS"};

	}

	@Override
	public void result(String itemCode) {
		log.info("Arms Handler");
		
	}
	
}
