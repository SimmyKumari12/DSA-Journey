import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    #Removing all the duplicates
    employee = employee.drop_duplicates(subset=["salary"])

    #Sorting the values
    employee = employee.sort_values(by = "salary",ascending = False)

    if(len(employee) < 2):
        return pd.DataFrame({"SecondHighestSalary" : [None]})

    second_highest = employee['salary'].iloc[1]
    
    return pd.DataFrame({"SecondHighestSalary" : [second_highest]})