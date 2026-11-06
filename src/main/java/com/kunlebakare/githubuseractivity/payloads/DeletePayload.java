package com.kunlebakare.githubuseractivity.payloads;

/**
 *
 * @author Kunle Bakare
 */
public class DeletePayload  implements Payload{

    @Override
    public String type() {
        return "Delete";
    }
}
