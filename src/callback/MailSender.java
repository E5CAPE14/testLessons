package callback;

public class MailSender {

    public MailSender() {
    }

    public void sendMessage(Object object){
        System.out.printf("MailSender::sendMessage <--> %s\n",((People) object).getName());
    }

}
