import pandas as pd

def invalid_tweets(tweets: pd.DataFrame) -> pd.DataFrame:
    tweet_final = tweets[(tweets['content'].str.len()) > 15]

    return tweet_final[['tweet_id']]