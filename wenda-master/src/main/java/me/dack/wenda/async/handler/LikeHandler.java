package me.dack.wenda.async.handler;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.dack.wenda.async.EventHandler;
import me.dack.wenda.async.EventModel;
import me.dack.wenda.async.EventType;
import me.dack.wenda.model.Message;
import me.dack.wenda.model.User;
import me.dack.wenda.service.MessageService;
import me.dack.wenda.service.UserService;
@Component
public class LikeHandler implements EventHandler{
	
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;

	@Override
	public void doHandle(EventModel model) {
		Message message = new Message();
		message.setFromId(0);
		message.setToId(model.getEntityOwnerId());
		message.setCreateTime(new Date());
		
		User user = userService.getUserById(model.getActorId());
		message.setContent("用户"+user.getName()
		+ "点赞了你的评论，http://119.23.227.157:8080/qusetion/"+model.getExt("questionId"));
		messageService.addMessage(message);
	}

	@Override
	public List<EventType> getSupportEventTypes() {
		return Arrays.asList(EventType.LIKE);
	}

}
