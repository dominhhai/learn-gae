package slim3demo1.controller.twitter;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import slim3demo1.model.Tweet;
import slim3demo1.service.TwitterService;

public class IndexController extends Controller {
    private TwitterService service = new TwitterService();

    @Override
    public Navigation run() throws Exception {
        // check login
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        if (!userService.isUserLoggedIn()) { // not login
            return redirect(userService.createLoginURL(request.getRequestURI()));
        } else {
            List<Tweet> tweetList = service.getTweetList();
            requestScope("tweetList", tweetList);
            requestScope("myEmail", user.getEmail());
            requestScope("myNickname", user.getNickname());
            requestScope("myIsAdmin", userService.isUserAdmin());
            return forward("index.jsp");
        }
    }
}
