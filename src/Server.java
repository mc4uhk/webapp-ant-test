import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ServerEndpoint("/serverendpoint")
public class Server {

	@OnOpen
	public void handleOpen() {
		log.info("client is now connected ...");
	}

	@OnMessage
	public String handleMessage(String message) {
		log.info("received from client:" + message);
		String reply = "echo: " + message;
		log.info("sent to client:" + reply);
		return reply;
	}
	
	@OnClose
	public void handleClose() {
		log.info("client is disconnected ...");
	}
	
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
}
