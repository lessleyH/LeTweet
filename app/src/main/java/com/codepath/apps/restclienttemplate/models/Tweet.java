package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Tweet {
    //list of attributes I want to store
    public String body;
    public long uid; // database ID for teh tweet
    public User user;
    public String createdAt;

    public String handle;
    public String likes;
    public String retweet;

    //deserialized the JSON
    public static Tweet fromJSON(JSONObject jsonObject) throws JSONException{
        Tweet tweet = new Tweet();

        //extract the val from JSON
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        tweet.handle = tweet.user.screenName;
        tweet.likes = jsonObject.getString("favorite_count");
        tweet.retweet = jsonObject.getString("retweet_count");
        return tweet;
    }
}
