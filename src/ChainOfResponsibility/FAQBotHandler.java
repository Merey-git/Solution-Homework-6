package ChainOfResponsibility;

class FAQBotHandler extends SupportHandler {
    @Override
    public void handle(String issue) throws Exception {
        if ("password_reset".equals(issue)) {
            logger.info("[FAQBot] Handled password_reset");
            System.out.println("[FAQBot] Handled password_reset");
        } else {
            logger.warning("[FAQBot] Cannot handle " + issue + " — escalate");
            if (nextHandler != null) {
                nextHandler.handle(issue);
            } else {
                throw new Exception("Issue unresolved: " + issue);  // Исключение, если нет обработчика
            }
        }
    }
}
