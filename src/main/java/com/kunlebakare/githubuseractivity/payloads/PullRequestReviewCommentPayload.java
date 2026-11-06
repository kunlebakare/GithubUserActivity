

package com.kunlebakare.githubuseractivity.payloads;

/**
 *
 * @author Kunle Bakare
 */
public class PullRequestReviewCommentPayload implements Payload{

    @Override
    public String type() {
        return "PullRequestReviewComment";
    }
}
