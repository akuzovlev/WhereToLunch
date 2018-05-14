# WhereToLunch

A voting system for deciding where to have lunch.

- 2 types of users: admin and regular users 
- Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price) 
- Menu changes each day (admins do the updates) 
- Users can vote on which restaurant they want to have lunch at 
- Only one vote counted per user 
- If user votes again the same day:  
    - If it is before 11:00 we asume that he changed his mind. 
    - If it is after 11:00 then it is too late, vote can't be changed 

Each restaurant provides new menu each day.

Prices is returned in cents!

API documentation and couple curl commands to test it:

--------------------Avaliable for all logged users-------------------

Get:
/restaurants  -  JSON with all restaurants sorted by name or NOT_FOUND(404) if list is empty.
/restaurants/{id} - restaurant with id in JSON format or NOT_FOUND(404) if restaurant with id is not exists.

Put:
/users/vote/{id} - vote for restaurant with id. Returns OK(200) on success or BAD_REQUEST(400) if user try vote repeatedly after 11 a.m. 

--------------------Avaliable for admin users-------------------

Get:
/users - JSON with all users sorted by name or NOT_FOUND(404) if list is empty.
/users/{id} - user with id in JSON format or NOT_FOUND(404) if user with id is not exists.
/users/votehistory - JSON with Votes history ordered by vote date
/restaurants/history - JSON with restaurants change history ordered by change date
/restaurants/{id}/withvotes  - restaurant with id in JSON format with voted users list or NOT_FOUND(404) if restaurant with id is not exists.
/restaurants/withvotes  -  JSON with all restaurants (each with voted users list) sorted by name or NOT_FOUND(404) if list is empty.


Delete:
/restaurants/{id} - delete restaurant by id. Returns NO_CONTENT(204) on success or NOT_FOUND(404) if restaurant with id is not exists.
/users/{id} - delete user by id. Returns NO_CONTENT(204) on success or NOT_FOUND(404) if user with id is not exists.

Update(Put):
/restaurants/{id} - consumes JSON, updates restaurant by id. Id in JSON is no matter. It will be automatically replaced by id from path. Returns OK(200) on success or NOT_FOUND(404) if restaurant with id is not exists.
/users/{id} - consumes JSON, updates user by id. Id in JSON is no matter. It will be automatically replaced by id from path. Returns OK(200) on success or NOT_FOUND(404) if user with id is not exists.

Create(post):
/restaurants/{id}  -  consumes JSON, creates restaurant. Returns CREATED(201) and JSON with created record or CONFLICT(409) if restaurant with this id is already exists.
/users/{id} - consumes JSON, creates user. Returns CREATED(201) and JSON with created record or CONFLICT(409) if user with this id is already exists.