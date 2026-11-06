

package com.kunlebakare.githubuseractivity.payloads;

/**
 *
 * @author Kunle Bakare
 */
public class PullRequestReviewPayload implements Payload{

    @Override
    public String type() {
        return "PullRequestReview";
    }
}
