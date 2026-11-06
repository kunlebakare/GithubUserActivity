

package com.kunlebakare.githubuseractivity.payloads;

/**
 *
 * @author Kunle Bakare
 */
public class ReleasePayload implements Payload{

    @Override
    public String type() {
        return "Release";
    }
}
