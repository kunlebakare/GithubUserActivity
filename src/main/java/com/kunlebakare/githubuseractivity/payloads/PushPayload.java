

package com.kunlebakare.githubuseractivity.payloads;

/**
 *
 * @author Kunle Bakare
 */
public class PushPayload implements Payload{

    @Override
    public String type() {
        return "Push";
    }
}
