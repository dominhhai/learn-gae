package slim3demo1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import com.google.appengine.api.users.UserServiceFactory;

import slim3demo1.model.Tweet;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TwitterServiceTest extends AppEngineTestCase {

    private TwitterService service = new TwitterService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void tweet() throws Exception {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("content", "Hello");
        String email = "haidm@testmail.com";
        Tweet tweeted = service.tweet(input);
        assertThat(tweeted, is(notNullValue()));
        Tweet stored = Datastore.get(Tweet.class, tweeted.getKey());
        assertThat(stored.getContent(), is("Hello"));
        assertThat(stored.getEmail(), is("haidm@testmail.com"));
    }

    @Test
    public void getTweetList() throws Exception {
        Tweet tweet = new Tweet();
        tweet.setContent("Hello");
        Datastore.put(tweet);
        List<Tweet> tweetList = service.getTweetList();
        assertThat(tweetList.size(), is(1));
        assertThat(tweetList.get(0).getContent(), is("Hello"));
    }
    
    @Test
    public void deleteTweet () throws Exception {
        Tweet tweet1 = new Tweet();
        tweet1.setContent("Hello");
        Datastore.put(tweet1);
        List<Tweet> tweetList = service.getTweetList();
        assertThat(tweetList.size(), is(1));
        assertThat(tweetList.get(0).getContent(), is("Hello"));
        
        List<Tweet> listTweet = service.getTweetList();
        int listTweetSize = listTweet.size();
        int ranIndex = (new Random()).nextInt(listTweetSize);
        Tweet tweet = listTweet.get(ranIndex);
        System.out.println ("delete Tweet: " + tweet.getEmail() + "; " + tweet.getContent() + "; " + tweet.getKey());
//        listTweet = service.deleteTweet(tweet.getKey());
        assertThat (listTweet.contains(tweet), is (false));
    }
}
