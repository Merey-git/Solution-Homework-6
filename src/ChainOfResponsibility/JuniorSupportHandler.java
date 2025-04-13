package ChainOfResponsibility;

class JuniorSupportHandler extends SupportHandler {
    @Override
    public void handle(String issue) throws Exception {
        if ("refund_request".equals(issue) || "billing_issue".equals(issue)) {
            logger.info("[JuniorSupport] Handled " + issue);
            System.out.println("[JuniorSupport] Handled " + issue);
        } else {
            logger.warning("[JuniorSupport] Cannot handle " + issue + " — escalate");
            if (nextHandler != null) {
                nextHandler.handle(issue);
            } else {
                System.out.println("[JuniorSupport] No handler could process the issue: " + issue);
            }
        }
    }
}
