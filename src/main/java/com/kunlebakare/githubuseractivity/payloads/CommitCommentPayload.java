
package com.kunlebakare.githubuseractivity.payloads;
/**
 *
 * @author Kunle Bakare
 */
public class CommitCommentPayload implements Payload{

    @Override
    public String type() {
        return "CommitComment";
    }

}
