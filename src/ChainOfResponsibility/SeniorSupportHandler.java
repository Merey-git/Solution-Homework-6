package ChainOfResponsibility;

class SeniorSupportHandler extends SupportHandler {
    @Override
    public void handle(String issue) throws Exception {
        if ("account_ban".equals(issue) || "data_loss".equals(issue)) {
            logger.info("[SeniorSupport] Handled " + issue);
            System.out.println("[SeniorSupport] Handled " + issue);
        } else {
            logger.warning("[SeniorSupport] Cannot handle " + issue + " — escalate manually");
            if (nextHandler != null) {
                nextHandler.handle(issue);
            } else {
                System.out.println("[SeniorSupport] No handler could process the issue: " + issue);
            }
        }
    }
}

