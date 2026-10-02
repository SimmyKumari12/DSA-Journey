import pandas as pd

def valid_emails(users: pd.DataFrame) -> pd.DataFrame:
    pat = r"^[A-Za-z][A-Za-z0-9_.-]*@leetcode\.com$"
    return users[users["mail"].str.match(pat)]