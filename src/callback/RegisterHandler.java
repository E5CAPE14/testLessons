package callback;

public class RegisterHandler implements Callback{

    private MailSender mailSender = new MailSender();

    @Override
    public void execute(Object object) {
        System.out.println("Пользователь "+ ((People) object).getName() + " зарегистрирован!");
        mailSender.sendMessage(object);
        System.out.println("Сообщение обьекту " + ((People) object).getName() + " отправлено");
    }
}
