package DecoratorPatternExample;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackSMSAndEmailNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);

        System.out.println("Testing EmailNotifier:");
        emailNotifier.send("Hello, Email!");

        System.out.println("\nTesting SMSNotifierDecorator:");
        smsAndEmailNotifier.send("Hello, SMS and Email!");

        System.out.println("\nTesting SlackNotifierDecorator:");
        slackSMSAndEmailNotifier.send("Hello, Slack, SMS, and Email!");
    }
}
