package customer_feedback_handler;

import customer_feedback_handler.handlers.CompensationClaimHandler;
import customer_feedback_handler.handlers.ContactRequestHandler;
import customer_feedback_handler.handlers.DevelopmentSuggestionHandler;
import customer_feedback_handler.handlers.GeneralFeedbackHandler;

public class Main {
    public static void main(String[] args) {
        CompensationClaimHandler compensationClaimHandler = new CompensationClaimHandler();
        ContactRequestHandler contactRequestHandler = new ContactRequestHandler();
        DevelopmentSuggestionHandler developmentSuggestionHandler = new DevelopmentSuggestionHandler();
        GeneralFeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        compensationClaimHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(developmentSuggestionHandler);
        developmentSuggestionHandler.setNextHandler(generalFeedbackHandler);

        Handler handler = compensationClaimHandler;

        Message compensateMeNow = new Message(MessageType.COMPENSATION, "Your sales representative severely bruised my ego, I demand 10% of your company's annual profits as compensation!", "dave.jones@yahoo.com");
        Message iMustContactYou = new Message(MessageType.CONTACT, "Hello, I'd like to speak to your CEO. I have an urgent matter that MUST be heard!", "hen_ry1963@gmail.com");
        Message pleaseAddThisFeature = new Message(MessageType.DEVELOPMENT_SUGGESTION, "You should develop all of your systems again from scratch to accomodate my incredibly minor issue.", "guywhoknowsnothingaboutdevelopment@genericemail.com");
        Message theOnlySaneOneHere = new Message(MessageType.GENERAL_FEEDBACK, "I quite liked how your company handled the recent event, keep up the great work!", "ther56@hotmail.com");

        handler.handle(compensateMeNow);
        handler.handle(iMustContactYou);
        handler.handle(pleaseAddThisFeature);
        handler.handle(theOnlySaneOneHere);
    }
}
