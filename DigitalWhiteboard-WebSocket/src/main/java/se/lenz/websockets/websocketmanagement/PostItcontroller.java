package se.lenz.websockets.websocketmanagement;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import se.lenz.websockets.model.*;

;

public class PostItcontroller {

	static int id = 0;
	
	static Set<PostIt> PostItSet = Collections.synchronizedSet(new HashSet<PostIt>());

	public void addPostit(Message message) {

		id = id + 1;

		PostIt postitadd = new PostIt();

		postitadd.setId(id);
		postitadd.setName(message.getName());
		postitadd.setTextarea(message.getTextarea());
		postitadd.setColor(message.getColor());

		PostItSet.add(postitadd);
		System.out.println("size of collection: " + PostItSet.size());

	}

	public void updatePostit(Message message) {

		PostIt postitupdate = new PostIt();
		
		postitupdate = serchpost(message);

		postitupdate.setId(id);
		postitupdate.setName(message.getName());
		postitupdate.setTextarea(message.getTextarea());
		postitupdate.setColor(message.getColor());

		PostItSet.add(postitupdate);

	}

	public void deletePostIt(Message messgae) {

		PostIt p = new PostIt();

		p = serchpost(messgae);
		PostItSet.remove(p);
		System.out.println("size of collection: " + PostItSet.size());

	}

	public PostIt serchpost(Message message) {
		for (PostIt postIt : PostItSet) {
			if (postIt.getId() == message.getId()) {
				return postIt;
			}
		}
		return null;
	}

	public Set<PostIt> getAllpostits() {
		return PostItSet;

	}

}
