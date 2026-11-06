

package com.kunlebakare.githubuseractivity.payloads;

/**
 *
 * @author Kunle Bakare
 */
public class IssueCommentPayload implements Payload{

    @Override
    public String type() {
        return "IssueComment";
    }
}
