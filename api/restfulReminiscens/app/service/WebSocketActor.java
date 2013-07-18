package service;

import static akka.pattern.Patterns.ask;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.HashMap;
import java.util.Map;

import play.Logger;
import play.libs.Akka;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.mvc.WebSocket;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class WebSocketActor extends UntypedActor {

	// Default room.
	static ActorRef defaultRoom = Akka.system().actorOf(
			new Props(WebSocketActor.class));

	static Map<String, WebSocket.Out<String>> clientsViewers = new HashMap<String, WebSocket.Out<String>>();
	static Map<String, WebSocket.Out<String>> clientsSensors = new HashMap<String, WebSocket.Out<String>>();

	@Override
	public void onReceive(Object message) throws Exception {

		if (message instanceof Join) {
			// Received a Join message
			Join join = (Join) message;

			if ("SENDER".equals(join.type)) {
				// Check if this username is free.
				// if (clientsSensors.containsKey(join.id)) {
				// getSender().tell("This username is already used",
				// getContext().system().deadLetters());
				// } else {
				clientsSensors.put(join.id, join.channel);
				// notifyAll("join", join.id, "has entered the room");
				getSender().tell("OK", getContext().system().deadLetters());
				Logger.debug("sensors: " + clientsSensors.toString());
				// }
			} else {
				clientsViewers.put(join.id, join.channel);
				getSender().tell("OK", getContext().system().deadLetters());
				Logger.debug("viewers: " + clientsViewers.toString());
			}
		} else if (message instanceof Talk) {

			// Received a Talk message
			Talk talk = (Talk) message;

			Logger.debug("message into OnReceive method: " + talk.text);

			// notifyAll("talk", talk.username, talk.text);
			notifyAll(talk.text);

		} else if (message instanceof Quit) {

			// Received a Quit message
			Quit quit = (Quit) message;

			clientsSensors.remove(quit.username);
			clientsViewers.remove(quit.username);
			Logger.debug("sensors: " + clientsSensors.toString());
			Logger.debug("viewers: " + clientsViewers.toString());
			// notifyAll("quit", quit.username, "has leaved the room");

		} else {
			unhandled(message);
		}

	}

	// Send a Json event to all members
	public void notifyAll(String text) {
		Logger.debug("sending message to : " + clientsViewers.size()
				+ " viewers");
		for (WebSocket.Out<String> channel : clientsViewers.values()) {
			channel.write(text);
		}
	}

	public static void join(final String type, final String id,
			WebSocket.In<String> in, WebSocket.Out<String> out)
			throws Exception {

		String result = (String) Await.result(
				ask(defaultRoom, new Join(type, id, out), 1000),
				Duration.create(1, SECONDS));
		Logger.debug("result: " + result);

		if ("OK".equals(result)) {

			// For each event received on the socket,
			in.onMessage(new Callback<String>() {
				public void invoke(String event) {
					// Send a Talk message to the room.
					defaultRoom.tell(new Talk(id, event), Akka.system()
							.deadLetters());

				}
			});

			// When the socket is closed.
			in.onClose(new Callback0() {
				public void invoke() {

					defaultRoom.tell(new Quit(id), Akka.system().deadLetters());

				}
			});

		} else {

			out.write(result);

		}

	}

	// -- Messages

	public static class Join {

		final String id;
		final WebSocket.Out<String> channel;
		final String type;

		public Join(String type, String id, WebSocket.Out<String> channel) {
			this.id = id;
			this.channel = channel;
			this.type = type;
		}

	}

	public static class Talk {

		final String username;
		final String text;

		public Talk(String username, String text) {
			this.username = username;
			this.text = text;
		}

	}

	public static class Quit {

		final String username;

		public Quit(String username) {
			this.username = username;
		}

	}

}
