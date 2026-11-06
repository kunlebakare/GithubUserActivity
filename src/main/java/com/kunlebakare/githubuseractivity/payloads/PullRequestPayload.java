

package com.kunlebakare.githubuseractivity.payloads;

/**
 *
 * @author Kunle Bakare
 */
public class PullRequestPayload implements Payload{

    @Override
    public String type() {
        return "PullRequest";
    }
}
