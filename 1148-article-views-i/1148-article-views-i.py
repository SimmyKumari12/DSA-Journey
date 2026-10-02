import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    self_viewed = views[views["author_id"] == views["viewer_id"]]

    result = pd.DataFrame(self_viewed["author_id"].unique(),columns = ["id"])

    result = result.sort_values(by = "id",ascending = True)

    return result

