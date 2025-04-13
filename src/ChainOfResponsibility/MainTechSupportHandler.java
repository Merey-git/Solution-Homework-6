package ChainOfResponsibility;

public class MainTechSupportHandler {
    public static void main(String[] args) {
        try {
            SupportHandler faq = new FAQBotHandler();
            SupportHandler junior = new JuniorSupportHandler();
            SupportHandler senior = new SeniorSupportHandler();

            faq.setNext(junior);
            junior.setNext(senior);

            String[] issues = {"password_reset", "refund_request", "account_ban", "unknown_bug"};
            for (String issue : issues) {
                try {
                    faq.handle(issue);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Unresolved issue: " + e.getMessage());
        }
    }
}
