package callback;

public class RegisterHandler implements Callback{

    private MailSender mailSender = new MailSender();

    /*
        Переопределяем метод execute(Object object) для дальнейшего использования в People.
     */
    @Override
    public void execute(Object object) {
        System.out.printf("Пользователь %s зарегистрирован!\n",((People) object).getName());
        mailSender.sendMessage(object);
        System.out.printf("Сообщение обьекту %s отправлено\n",((People) object).getName());
    }
}
