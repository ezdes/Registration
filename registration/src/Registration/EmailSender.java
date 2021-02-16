package Registration;

import com.email.durgesh.Email;

import java.util.Random;

public class EmailSender {

    private static String result;

    public static String generate() {
        result = "";
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int c = random.nextInt(10);
        int d = random.nextInt(10);

        result = a + "" + b + "" + c + "" + d;

        return result;
    }

    public static void send() {
        try {

            String code = generate();

            Email email = new Email("madaratoptyanka@gmail.com", "madara2m3410lt");
            email.setFrom("madaratoptyanka@gmail.com", "Code");

            email.setSubject("Hello " + SignUpFrame.getTf1().getText() + "!");

            email.setContent(code, "text/html");
            email.addRecipient(SignUpFrame.getTf4().getText() + "@gmail.com");

            email.send();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void send(String userEmail) {
        try {

            String code = generate();

            Email email = new Email("madaratoptyanka@gmail.com", "madara2m3410lt");
            email.setFrom("madaratoptyanka7@gmail.com", "Code");

            email.setSubject("Hello!");

            if (!SignInFrame.getEmail().contains("@")) userEmail = userEmail + "@gmail.com";

            email.setContent(code, "text/html");
            email.addRecipient(userEmail);

            email.send();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean checkCode(String code) {
        return code.equals(result);
    }
}
