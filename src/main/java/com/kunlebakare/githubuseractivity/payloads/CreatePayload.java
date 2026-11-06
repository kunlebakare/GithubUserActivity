
package com.kunlebakare.githubuseractivity.payloads;
/**
 *
 * @author Kunle Bakare
 */
public class CreatePayload implements Payload{

    @Override
    public String type() {
        return "Create";
    }
}
