package slim3demo1.controller.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import slim3demo1.meta.TweetMeta;
import slim3demo1.service.TwitterService;

public class DeleteController extends Controller {
    private TwitterService service = new TwitterService();
    private TweetMeta meta = TweetMeta.get();

    @Override
    public Navigation run() throws Exception {
        service.delete(asKey(meta.key), asLong(meta.version));
        return redirect(basePath);
    }
}