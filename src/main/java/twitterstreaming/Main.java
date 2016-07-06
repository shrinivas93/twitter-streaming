package twitterstreaming;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;

public class Main {

	public static void main(String args[]) throws Exception {
		TwitterFactory factory = new TwitterFactory();
		Twitter twitter = factory.getInstance();
		AccessToken accessToken = loadAccessToken();
		twitter.setOAuthConsumer("SX0DQVWYBjhrh9Fc8mGxJYTyA", "l4vaztFYhDJJ1PiHSBt3RPoOHDjWrLExYqTExn5zBBH6QJLSNX");
		twitter.setOAuthAccessToken(accessToken);
		System.out.println(twitter.getScreenName());

		/***************************************************************************************/

		StatusListener listener = new StatusListener() {
			public void onStatus(Status status) {
				System.out.println(status.getUser().getName() + " : " + status.getText());
			}

			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
			}

			public void onException(Exception ex) {
			}

			public void onScrubGeo(long arg0, long arg1) {
			}

			public void onStallWarning(StallWarning arg0) {
			}
		};
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.setOAuthConsumer("SX0DQVWYBjhrh9Fc8mGxJYTyA",
				"l4vaztFYhDJJ1PiHSBt3RPoOHDjWrLExYqTExn5zBBH6QJLSNX");
		twitterStream.setOAuthAccessToken(accessToken);
		twitterStream.addListener(listener);
		twitterStream.filter(new FilterQuery("narendra modi"));
	}

	private static AccessToken loadAccessToken() {
		String token = "3222473696-Jg1VNuzIW6qrRYULzp5kQYSwxhm5Up1XzvC1kW0";
		String tokenSecret = "txi4oZO246ZpyMSSBOqjdCCfDYaZygJCTm3Fue8T8X9FF";
		return new AccessToken(token, tokenSecret);
	}

}
