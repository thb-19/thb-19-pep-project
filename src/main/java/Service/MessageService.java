package Service;

import java.util.List;

import DAO.MessageDAO;
import Model.Message;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public Message postCreationOfNewMessage(Message message) {
        return messageDAO.postCreationOfNewMessage(message);
    }

    public boolean userExistsOrNot(Message message){
        return messageDAO.userExistsOrNot(message);
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageByID(int i) {
        return messageDAO.getMessageByID(i);
    }

    public Message deleteMessageByMessageID(int i) {
        Message messageToDelete = messageDAO.getMessageByID(i);
        if (messageToDelete != null) {
            messageDAO.deleteMessageByMessageID(i);
        }
        return messageToDelete;
    }

    public Message patchUpdateMessageTextByMessageID(int message_id, Message message) {
        messageDAO.patchUpdateMessageTextByMessageID(message_id, message);
        return messageDAO.getMessageByID(message_id);    
    }

    public List<Message> getMessagesByParticularUser(int i) {
        return messageDAO.getMessagesByParticularUser(i);
    }

    
}

