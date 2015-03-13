package slim3demo1.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import slim3demo1.meta.TweetMeta;
import slim3demo1.model.Tweet;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class TwitterService {

    private TweetMeta t = new TweetMeta();

    public Tweet tweet(Map<String, Object> input) {
        Tweet tweet = new Tweet();
        BeanUtil.copy(input, tweet);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx, tweet);
        tx.commit();
        return tweet;
    }

    public Tweet getTweet(Key key, Long version) {
        return Datastore.get(t, key, version);
    }
    
    public List<Tweet> getTweetList() {
        // TODO Auto-generated method stub
        return Datastore.query(t).sort(t.createdDate.desc).asList();
    }

    public void deleteTweet(Key key) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.delete(tx, key);
        tx.commit();
    }
    
    public void delete(Key key, Long version) {
        Transaction tx = Datastore.beginTransaction();
        Tweet tweet = Datastore.get(tx, t, key, version);
        Datastore.delete(tx, tweet.getKey());
        tx.commit();
    }

    public void updateTweet(Key key, String content) {
        Transaction tx = Datastore.beginTransaction();
        Tweet tweet = Datastore.get(Tweet.class, key);
        tweet.setContent(content);
        Datastore.put(tx, tweet);
        tx.commit();
    }

    public void updateTweet(Key key, Long version, Map<String, Object> input) {
        // TODO Auto-generated method stub
        Transaction tx = Datastore.beginTransaction();
        Tweet tweet = Datastore.get(tx, t, key, version);
        BeanUtil.copy(input, tweet);
        Datastore.put(tx, tweet);
        tx.commit();
    }
}
