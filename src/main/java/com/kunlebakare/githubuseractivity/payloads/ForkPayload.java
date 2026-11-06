

package com.kunlebakare.githubuseractivity.payloads;

/**
 *
 * @author Kunle Bakare
 */
public class ForkPayload implements Payload{

    @Override
    public String type() {
        return "Fork";
    }
}
