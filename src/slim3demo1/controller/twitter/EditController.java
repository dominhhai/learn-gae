package slim3demo1.controller.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

import slim3demo1.meta.TweetMeta;
import slim3demo1.model.Tweet;
import slim3demo1.service.TwitterService;

public class EditController extends Controller {
    private TwitterService service = new TwitterService();
    private TweetMeta meta = TweetMeta.get();

    @Override
    public Navigation run() throws Exception {
        Tweet tweet = service.getTweet(asKey(meta.key), asLong(meta.version));
        BeanUtil.copy(tweet, request);
        return forward("edit.jsp");
    }
}
