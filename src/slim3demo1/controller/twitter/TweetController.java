package slim3demo1.controller.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import slim3demo1.meta.TweetMeta;
import slim3demo1.service.TwitterService;

public class TweetController extends Controller {

    private TwitterService service = new TwitterService();
    private TweetMeta meta = TweetMeta.get();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        if (validate() && (!requestMap.get("content").toString().trim().equals(""))) {
            service.tweet(requestMap);
        }
        return redirect(basePath);
    }
    
    protected boolean validate () {
        Validators v = new Validators (request);
        v.add(meta.email, v.required());
        v.add(meta.content, v.required());
        return v.validate();
    }
}
