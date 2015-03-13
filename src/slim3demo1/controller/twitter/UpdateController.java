package slim3demo1.controller.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

import slim3demo1.meta.TweetMeta;
import slim3demo1.service.TwitterService;

public class UpdateController extends Controller {
    private TwitterService service = new TwitterService();
    private TweetMeta meta = TweetMeta.get();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
//        int index = Integer.parseInt(requestMap.get("index").toString());
//        String content = requestMap.get("content").toString();
//        List<Tweet> listTween = service.getTweetList();
//        int maxIndex = listTween.size();
//        if (index < maxIndex) {
//            service.updateTweet(listTween.get(index).getKey(), content);
//            listTween = service.getTweetList();
//            requestScope("tweetList", listTween);
//        }
        if (validate() && (!requestMap.get("content").toString().trim().equals(""))) {
            service.updateTweet(asKey(meta.key), asLong(meta.version), requestMap);
        } else {
            return forward ("edit.jsp");
        }
        return redirect(basePath);
    }
    
    protected boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.content, v.required());
        return v.validate();
    }
}
